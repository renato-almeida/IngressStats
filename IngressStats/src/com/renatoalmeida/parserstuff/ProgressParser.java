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
			Log.d("cenas", line);
			for(String stat : StatsResources.statsString.keySet()){
				
				String tmpLine = line.replace(" ", "");
				String tmpStat = StatsResources.statsString.get(stat).replace(" ", "");
				
				if(tmpLine.startsWith(tmpStat)){
					statValue.put(stat, Integer.parseInt(line.replaceAll("[^\\d.]", "")));
				}
			}
		}
	}
}
