package com.renatoalmeida.ingressstats;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.renatoalmeida.db.StatsReaderDbHelper;
import com.renatoalmeida.ingressstats.badges.BadgeList;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ListView lv = (ListView) findViewById(R.id.stats);
		
		StatsReaderDbHelper db = new StatsReaderDbHelper(this);
		
		HashMap<String, Long> values = db.getFirstEntry();
		
		if(values == null)
			return;
		
		
		List<String> statWithBadge = new ArrayList<String>();
		
		String[] stats = getResources().getStringArray(R.array.stats);
		
		for(int i=0; i< stats.length; i++ ){
			String stat = stats[i];
			
			if(BadgeList.List.get(stat) != null)
				statWithBadge.add(stat);
		}
		
		BadgeAdapter ba = new BadgeAdapter(this, statWithBadge, values);
		lv.setAdapter(ba);
		
		TextView tv = (TextView) findViewById(R.id.ap);
		tv.setText("AP :" + values.get("AP"));
	}
}
