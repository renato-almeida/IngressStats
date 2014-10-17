package com.renatoalmeida.ingressstats;

import java.util.HashMap;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.renatoalmeida.db.StatsReaderDbHelper;
import com.renatoalmeida.ingressstats.shareactivity.ShareActivityAdapter;

public class HistoryFragment extends Fragment implements OnItemSelectedListener {

    public HistoryFragment() {
        
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.history_fragment, container, false);
        
        Spinner spinner = (Spinner) rootView.findViewById(R.id.history_fragment_picker);
        
        StatsReaderDbHelper dbHelper = new StatsReaderDbHelper(getActivity());
        
        String timestamps[] = dbHelper.getAllTimestamps();
        
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(getActivity(), android.R.layout.simple_spinner_item, timestamps);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        
        return rootView;
    }
    
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
    	StatsReaderDbHelper dbHelper = new StatsReaderDbHelper(getActivity());
    	
        TextView tv = (TextView)view;
        
        HashMap<String, Long> values = dbHelper.getRecordEntry(tv.getText().toString());
        
        ListView lv = (ListView)this.getView().findViewById(R.id.history_fragment_list);
        ShareActivityAdapter adapter = new ShareActivityAdapter(getActivity(), values, null);
        lv.setAdapter(adapter);
        lv.setDivider(null);
		lv.setDividerHeight(0);
    }

    public void onNothingSelected(AdapterView<?> parent) {
        
    }
}
