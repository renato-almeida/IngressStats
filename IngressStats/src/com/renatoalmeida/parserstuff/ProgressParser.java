package com.renatoalmeida.parserstuff;

import java.util.HashMap;
import java.util.Locale;

import com.renatoalmeida.db.StatsResources;

import android.util.Log;
import android.util.SparseArray;

public class ProgressParser {
	
	public HashMap<String, Integer> statValue;
	
	public ProgressParser(String text){
		statValue = new HashMap<String, Integer>();
		
		for(String line : text.split("\\r?\\n")){
			String tmpLine = line.replace(" ", "");
			
			for(int statIndex = 0; statIndex < StatsResources.stats.size(); statIndex++){
				
				String stat = StatsResources.stats.get(statIndex);
				
				if (stat == "AP")
					continue;
				String tmpStat = stat;
				
				if(tmpLine.toLowerCase().startsWith(tmpStat.toLowerCase())){
					int val = 0;
					try{
						val = Integer.parseInt(line.replaceAll("[^\\d.]", ""));
					}
					catch(Exception e){}
					
					statValue.put(stat, val);
				}
			}
			if(line.toLowerCase(Locale.getDefault()).contains("ap")){
				String tmpString[] = line.toLowerCase(Locale.getDefault()).split("ap");
				
				int val = 0;
				try{
					val = Integer.parseInt(tmpString[0].replaceAll("[^\\d.]", ""));

					statValue.put("AP", val);
				}
				catch(Exception e){}
			}
		}
	}
}
