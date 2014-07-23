package com.renatoalmeida.ingressstats;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map.Entry;

import com.googlecode.tesseract.android.TessBaseAPI;
import com.renatoalmeida.parserstuff.ProgressParser;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class ShareActivity extends Activity {

	public static final String DATA_PATH = Environment.getExternalStorageDirectory().toString() + "/IngressStats/";
	public static final String lang = "eng";
	private static final String TAG = "IngressStats.java";

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_share);
		
		setOCRStuff();
		
		Intent intent = getIntent();

	    if (intent.getType().indexOf("image/") != -1) {
	    	Uri imageUri = (Uri) intent.getParcelableExtra(Intent.EXTRA_STREAM);
		    if (imageUri != null) {
		    	Bitmap image = getImage(imageUri);
		        
		        //ImageView i = (ImageView)findViewById(R.id.picture);
		        
		        //i.setImageBitmap(image);
		        
		        TessBaseAPI baseApi = new TessBaseAPI();
				baseApi.setDebug(true);
				baseApi.init(DATA_PATH, lang);
				baseApi.setImage(image);

				String recognizedText = baseApi.getUTF8Text();

				baseApi.end();
				
				Log.v(TAG, recognizedText);
				
				ProgressParser pp = new ProgressParser(recognizedText);
				
				TextView tv = (TextView) findViewById(R.id.texto);
				
				for(Entry<String, Integer> item : pp.statValue.entrySet()){
					tv.setText(tv.getText() + item.getKey() + " : " + item.getValue()+"\n");
				}
				
		        
		    }else{
				 Log.d("cenas", "nullllll");
		    }
	    }
	}
	
	private Bitmap getImage(Uri uri){
	   try {
		return  MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   return null;
	}
	
	private void setOCRStuff(){
		String[] paths = new String[] { DATA_PATH, DATA_PATH + "tessdata/" };

		for (String path : paths) {
			File dir = new File(path);
			if (!dir.exists()) {
				if (!dir.mkdirs()) {
					Log.v(TAG, "ERROR: Creation of directory " + path + " on sdcard failed");
					return;
				} else {
					Log.v(TAG, "Created directory " + path + " on sdcard");
				}
			}

		}

		if (!(new File(DATA_PATH + "tessdata/" + lang + ".traineddata")).exists()) {
			try {

				AssetManager assetManager = getAssets();
				InputStream in = assetManager.open("tessdata/" + lang + ".traineddata");
				//GZIPInputStream gin = new GZIPInputStream(in);
				OutputStream out = new FileOutputStream(DATA_PATH + "tessdata/" + lang + ".traineddata");

				// Transfer bytes from in to out
				byte[] buf = new byte[1024];
				int len;
				//while ((lenf = gin.read(buff)) > 0) {
				while ((len = in.read(buf)) > 0) {
					out.write(buf, 0, len);
				}
				in.close();
				//gin.close();
				out.close();

				Log.v(TAG, "Copied " + lang + " traineddata");
			} catch (IOException e) {
				Log.e(TAG, "Was unable to copy " + lang + " traineddata " + e.toString());
			}
		}
	}
}
