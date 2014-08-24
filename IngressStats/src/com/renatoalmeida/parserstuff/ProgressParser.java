package com.renatoalmeida.parserstuff;

import java.util.HashMap;
import java.util.Locale;

import android.content.Context;

import com.renatoalmeida.ingressstats.R;

public class ProgressParser {
	
	public HashMap<String, Long> statValue;
	
	public ProgressParser(Context context, String text){
		
		statValue = new HashMap<String, Long>();
		
		String[] stats = context.getResources().getStringArray(R.array.stats);
		
		for(String line : text.split("\\r?\\n")){
			String tmpLine = line.replace(" ", "");
			
			for(int statIndex = 0; statIndex < stats.length; statIndex++){
				
				String stat = stats[statIndex];
				
				if (stat == "AP")
					continue;
				String tmpStat = stat;
				
				if(tmpLine.toLowerCase().startsWith(tmpStat.toLowerCase())){
					long val = 0;
					try{
						val = Integer.parseInt(line.replaceAll("[^\\d.]", ""));
					}
					catch(Exception e){}
					
					statValue.put(stat, val);
				}
			}
			
			if(line.toLowerCase(Locale.getDefault()).contains("ap")){
				String tmpString[] = line.toLowerCase(Locale.getDefault()).split("ap");
				
				long val = 0;
				try{
					val = Integer.parseInt(tmpString[0].replaceAll("[^\\d.]", ""));

					statValue.put("AP", val);
				}
				catch(Exception e){}
			}
		}
	}
}
