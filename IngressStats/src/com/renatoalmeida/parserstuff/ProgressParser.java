package com.renatoalmeida.parserstuff;

import java.util.HashMap;

import com.renatoalmeida.db.StatsResources;

import android.util.Log;
import android.util.SparseArray;

public class ProgressParser {
	
	public HashMap<String, Integer> statValue;
	
	public ProgressParser(String text){
		statValue = new HashMap<String, Integer>();
		
		for(String line : text.split("\\r?\\n")){
			for(String stat : StatsResources.statsString.keySet()){
				Log.d("cenas", line + " "+stat);
				if(line.startsWith(StatsResources.statsString.get(stat))){
					statValue.put(stat, Integer.parseInt(line.replaceAll("[^\\d.]", "")));
				}
			}
		}
		
	}
}
