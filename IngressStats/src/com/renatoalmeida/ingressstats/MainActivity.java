package com.renatoalmeida.ingressstats;

import java.util.ArrayList;
import java.util.List;

import com.renatoalmeida.db.StatsReaderDbHelper;
import com.renatoalmeida.db.StatsContract.StatsEntry;
import com.renatoalmeida.db.StatsResources;
import com.renatoalmeida.ingressstats.badges.BadgeList;
import com.renatoalmeida.ingressstats.badges.BadgeRequirement;
import com.renatoalmeida.ingressstats.badges.IBadge;
import com.renatoalmeida.ingressstats.shareactivity.ShareActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ListView lv = (ListView) findViewById(R.id.stats);
		
		StatsReaderDbHelper db = new StatsReaderDbHelper(this);
		
		Cursor c = db.getLastEntry();
		c.moveToFirst();
		
		if(c.getCount() == 0)
			return;
		
		
		List<String> statWithBadge = new ArrayList<String>();
		
		for(int i=0; i<StatsResources.stats.size(); i++ ){
			String stat = StatsResources.stats.get(i);
			
			if(BadgeList.List.get(stat) != null)
				statWithBadge.add(stat);
		}
		
		BadgeAdapter ba = new BadgeAdapter(this, statWithBadge, c);
		lv.setAdapter(ba);
		
		TextView tv = (TextView) findViewById(R.id.ap);
		Log.d("cenas", "pos: "+c.getColumnIndex("AP"));
		tv.setText("AP :" + c.getLong(c.getColumnIndex("AP")));
		
	}
}
