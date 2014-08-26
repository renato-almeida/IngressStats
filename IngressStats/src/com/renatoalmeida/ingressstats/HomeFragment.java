package com.renatoalmeida.ingressstats;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.renatoalmeida.db.StatsReaderDbHelper;
import com.renatoalmeida.ingressstats.badges.BadgeList;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

public class HomeFragment extends Fragment{

    public HomeFragment() {
        
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.home_fragment, container, false);
        
        ListView lv = (ListView) rootView.findViewById(R.id.stats);
		
		StatsReaderDbHelper db = new StatsReaderDbHelper(this.getActivity());
		
		HashMap<String, Long> values = db.getFirstEntry();
		
		if(values == null)
			return rootView;
		
		
		List<String> statWithBadge = new ArrayList<String>();
		
		String[] stats = getResources().getStringArray(R.array.stats);
		
		for(int i=0; i< stats.length; i++ ){
			String stat = stats[i];
			
			if(BadgeList.List.get(stat) != null)
				statWithBadge.add(stat);
		}
		
		BadgeAdapter ba = new BadgeAdapter(this.getActivity(), statWithBadge, values);
		lv.setAdapter(ba);
		
		TextView tv = (TextView) rootView.findViewById(R.id.ap);
		tv.setText("AP :" + values.get("AP"));
        
        return rootView;
    }
	

}
