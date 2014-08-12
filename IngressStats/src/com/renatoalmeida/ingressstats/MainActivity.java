package com.renatoalmeida.ingressstats;

import java.util.ArrayList;
import java.util.List;

import com.renatoalmeida.db.StatsReaderDbHelper;
import com.renatoalmeida.db.StatsContract.StatsEntry;
import com.renatoalmeida.db.StatsResources;
import com.renatoalmeida.ingressstats.badges.BadgeList;
import com.renatoalmeida.ingressstats.badges.BadgeRequirement;
import com.renatoalmeida.ingressstats.badges.IBadge;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

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
		
		
		
		/*String[] columns = new String[] {
		    //StatsEntry.COLUMN_NAME_STATS_ID,
		    "Hacks"
		};
			 
			  // the XML defined views which the data will be bound to
		  int[] to = new int[] { 
		    android.R.id.text1,
		  };
		
		SimpleCursorAdapter dataAdapter = new SimpleCursorAdapter(
			    this, android.R.layout.simple_list_item_1, 
			    db.getLastEntry(),
			    columns, 
			    to,
			    0);
		
		lv.setAdapter(dataAdapter);
		
		
		Cursor c = db.getLastEntry();
		c.moveToFirst();
		

		Log.d("cenas", "  "+BadgeList.List.size());
		
		for(int i=0; i<StatsResources.stats.size(); i++ ){
			String stat = StatsResources.stats.get(i);
			
			long value = c.getLong(c.getColumnIndex(stat));
			BadgeRequirement b;
			IBadge badge;
			
			if((badge = BadgeList.List.get(stat)) != null){
				Log.d("cenas", stat + " : " + badge.getBadge(value).getBadgeLevel().name());
			}else{
				Log.d("cenas", stat + " : -----------");
			}
			
		}*/
		
	}
}
