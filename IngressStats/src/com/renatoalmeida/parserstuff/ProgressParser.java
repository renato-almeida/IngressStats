package com.renatoalmeida.parserstuff;

import java.util.HashMap;

import android.util.Log;
import android.util.SparseArray;

public class ProgressParser {
	
	private static SparseArray<String> statOrder = new SparseArray<String>();
	private static HashMap<String, String> statLine = new HashMap<String, String>();
	public HashMap<String, Integer> statValue;
	
	static{
		//Fill the order that will be shown when presenting the results
		//kind of stupid
		statOrder.put(0, "UniquePortalsVisited");
		statOrder.put(1, "PortalsDiscovered");
		statOrder.put(2, "XmCollected");
		
		statOrder.put(3, "Hacks");
		statOrder.put(4, "ResonatorsDeployed");
		statOrder.put(5, "LinksCreated");
		statOrder.put(6, "ControlFieldsCreated");
		statOrder.put(7, "MindUnitsCaptured");
		statOrder.put(8, "LongestLinkEverCreated");
		statOrder.put(9, "LargestControlField");
		statOrder.put(10, "XmRecharged");
		statOrder.put(11, "PortalsCaptured");
		statOrder.put(12, "UniquePortalsCaptured");

		statOrder.put(13, "ResonatorsDestroyed");
		statOrder.put(14, "PortalsNeutralized");
		statOrder.put(15, "EnemyLinksDestroyed");
		statOrder.put(16, "EnemyControlFieldsDestroyed");		
		
		statOrder.put(17, "DistanceWalked");
		
		statOrder.put(18, "MaxTimePortalHeld");
		statOrder.put(19, "MaxTimeLinkMaintained");
		statOrder.put(20, "MaxLinkLengthxDays");
		statOrder.put(21, "MaxTimeFieldHeld");
		statOrder.put(22, "LargestFieldMUsxDays");

		//statLine
		
		//Discovery
		statLine.put("Unique Portals Visited", "UniquePortalsVisited");
		statLine.put("Portals Discovered", "PortalsDiscovered");
		statLine.put("XM Collected", "XmCollected");
		
		//Building
		statLine.put("Hacks", "Hacks");
		statLine.put("Resonators Deployed", "ResonatorsDeployed");
		statLine.put("Links Created", "LinksCreated");
		statLine.put("Control Fields Created", "ControlFieldsCreated");
		statLine.put("Mind Units Captured", "MindUnitsCaptured");
		statLine.put("Longest Link Ever Created", "LongestLinkEverCreated");
		statLine.put("Largest Control Field", "LargestControlField");
		statLine.put("XM Recharged", "XmRecharged");
		statLine.put("Portals Captured", "PortalsCaptured");
		statLine.put("Unique Portals Captured", "UniquePortalsCaptured");

		//Combat
		statLine.put("Resonators Destroyed", "ResonatorsDestroyed");
		statLine.put("Portals Neutralized", "PortalsNeutralized");
		statLine.put("Enemy Links Destroyed", "EnemyLinksDestroyed");
		statLine.put("Enemy Control Fields Destroyed", "EnemyControlFieldsDestroyed");		
		
		//Health
		statLine.put("Distance Walked", "DistanceWalked");
		
		//Defence
		statLine.put("Max Time Portal Held", "MaxTimePortalHeld");
		statLine.put("Max Time Link Maintained", "MaxTimeLinkMaintained");
		statLine.put("Max Link Length x Days", "MaxLinkLengthxDays");
		statLine.put("Max Time Field Held", "MaxTimeFieldHeld");
		statLine.put("Largest Field MUs x Days", "LargestFieldMUsxDays");
	}
	
	public ProgressParser(String text){
		statValue = new HashMap<String, Integer>();
		
		
		for(String line : text.split("\\r?\\n")){
			for(String stat : statLine.keySet()){
				
				if(line.contains(stat)){
					statValue.put(statLine.get(stat), Integer.parseInt(line.replaceAll("[^\\d.]", "")));
				}
			}
		}
		
	}
}
