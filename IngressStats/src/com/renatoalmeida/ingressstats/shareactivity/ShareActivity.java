package com.renatoalmeida.ingressstats.shareactivity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;

import com.googlecode.tesseract.android.TessBaseAPI;
import com.renatoalmeida.db.StatsContract.StatsEntry;
import com.renatoalmeida.db.StatsReaderDbHelper;
import com.renatoalmeida.ingressstats.MainActivity;
import com.renatoalmeida.ingressstats.R;
import com.renatoalmeida.ingressstats.R.id;
import com.renatoalmeida.parserstuff.ProgressParser;

import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ShareActivity extends ListActivity {

	public static final String DATA_PATH = Environment
			.getExternalStorageDirectory().toString() + "/IngressStats/";
	public static final String lang = "eng";
	private static final String TAG = "IngressStats.java";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		getListView().setDivider(null);
		getListView().setDividerHeight(0);
		getWindow().getDecorView().setBackgroundColor(Color.BLACK);		
		
		(new StatsParserTask()).execute(getIntent());
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case R.id.activity_share_ok:
	        	Intent i = new Intent(getApplicationContext(), MainActivity.class);
	        	startActivity(i); 
	        	finish();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.activity_share_list_item, menu);
	    return super.onCreateOptionsMenu(menu);
	}

	private Bitmap getImage(Uri uri) {
		try {
			return MediaStore.Images.Media.getBitmap(this.getContentResolver(),
					uri);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setOCRStuff() {
		String[] paths = new String[] { DATA_PATH, DATA_PATH + "tessdata/" };

		for (String path : paths) {
			File dir = new File(path);
			if (!dir.exists()) {
				if (!dir.mkdirs()) {
					Log.e(TAG, "ERROR: Creation of directory " + path
							+ " on sdcard failed");
					return;
				} else {
					Log.v(TAG, "Created directory " + path + " on sdcard");
				}
			}

		}

		if (!(new File(DATA_PATH + "tessdata/" + lang + ".traineddata"))
				.exists()) {
			try {

				AssetManager assetManager = getAssets();
				InputStream in = assetManager.open("tessdata/" + lang + ".traineddata");
				OutputStream out = new FileOutputStream(DATA_PATH + "tessdata/"	+ lang + ".traineddata");

				// Transfer bytes from in to out
				byte[] buf = new byte[1024];
				int len;
				
				while ((len = in.read(buf)) > 0) {
					out.write(buf, 0, len);
				}
				in.close();
				out.close();

				Log.v(TAG, "Copied " + lang + " traineddata");
			} catch (IOException e) {
				Log.e(TAG,
						"Was unable to copy " + lang + " traineddata "
								+ e.toString());
			}
		}
	}

	private class StatsParserTask extends AsyncTask<Intent, String, HashMap<String, Integer>> {
		private ProgressDialog progDailog;

		@Override
		protected HashMap<String, Integer> doInBackground(Intent... intents) {
			publishProgress("Starting...");
			ShareActivity.this.setOCRStuff();

			HashMap<String, Integer> ret = null;

			Intent intent = getIntent();
			publishProgress("Getting the imagem...");
			if (intent.getType().indexOf("image/") != -1) {
				Uri imageUri = (Uri) intent
						.getParcelableExtra(Intent.EXTRA_STREAM);
				if (imageUri != null) {
					Bitmap image = getImage(imageUri);

					publishProgress("Parsing ...");

					TessBaseAPI baseApi = new TessBaseAPI();
					baseApi.setDebug(true);
					baseApi.init(DATA_PATH, lang);
					baseApi.setImage(image);

					String recognizedText = baseApi.getUTF8Text();

					baseApi.end();

					publishProgress("Parse done, starting text parse ...");

					ProgressParser pp = new ProgressParser(recognizedText);

					publishProgress("Storing values in database...");

					StatsReaderDbHelper mDbHelper = new StatsReaderDbHelper(ShareActivity.this);
					SQLiteDatabase db = mDbHelper.getWritableDatabase();
					ContentValues values = new ContentValues();

					values.put(StatsEntry.COLUMN_NAME_STATS_ID,	System.currentTimeMillis() / 1000L);

					for (Entry<String, Integer> item : pp.statValue.entrySet()) {
						values.put(item.getKey(), item.getValue());
					}

					db.insert(StatsEntry.TABLE_NAME, null, values);

					publishProgress("All went well...");
					ret = pp.statValue;
				} else {
					Log.d("cenas", "nullllll");
				}
			}

			return ret;
		}

		@Override
		protected void onPreExecute() {
			progDailog = new ProgressDialog(ShareActivity.this);
			progDailog.setMessage("Loading...");
			progDailog.setIndeterminate(true);
			progDailog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			progDailog.setCancelable(false);
			progDailog.show();
		}

		@Override
		protected void onProgressUpdate(String... progress) {
			progDailog.setMessage(progress[0]);
		}

		@Override
		protected void onPostExecute(HashMap<String, Integer> result) {
			progDailog.dismiss();

			ShareActivityAdapter adapter = new ShareActivityAdapter(getApplicationContext(), result);

			setListAdapter(adapter);
		}
	}
}
