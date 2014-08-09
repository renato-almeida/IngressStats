package com.renatoalmeida.db;

import java.util.HashMap;

import android.util.SparseArray;

public class StatsResources {

	public final static SparseArray<String> stats = new SparseArray<String>();
	public final static HashMap<String, String> statsString= new HashMap<String, String>();
	
	static{
		//Fill the order that will be shown when presenting the results
		//kind of stupid
		stats.put(0, "UniquePortalsVisited");
		stats.put(1, "PortalsDiscovered");
		stats.put(2, "XmCollected");
		
		stats.put(3, "Hacks");
		stats.put(4, "ResonatorsDeployed");
		stats.put(5, "LinksCreated");
		stats.put(6, "ControlFieldsCreated");
		stats.put(7, "MindUnitsCaptured");
		stats.put(8, "LongestLinkEverCreated");
		stats.put(9, "LargestControlField");
		stats.put(10, "XMRecharged");
		stats.put(11, "PortalsCaptured");
		stats.put(12, "UniquePortalsCaptured");

		stats.put(13, "ResonatorsDestroyed");
		stats.put(14, "PortalsNeutralized");
		stats.put(15, "EnemyLinksDestroyed");
		stats.put(16, "EnemyControlFieldsDestroyed");		
		
		stats.put(17, "DistanceWalked");
		
		stats.put(18, "MaxTimePortalHeld");
		stats.put(19, "MaxTimeLinkMaintained");
		stats.put(20, "MaxLinkLengthxDays");
		stats.put(21, "MaxTimeFieldHeld");
		stats.put(22, "LargestFieldMUsxDays");

		//statLine
		
		//Discovery
		statsString.put(stats.get(0), "Unique Portals Visited");
		statsString.put(stats.get(1), "Portals Discovered");
		statsString.put(stats.get(2), "XM Collected");
		
		//Building
		statsString.put(stats.get(3), "Hacks");
		statsString.put(stats.get(4), "Resonators Deployed");
		statsString.put(stats.get(5), "Links Created");
		statsString.put(stats.get(6), "Control Fields Created");
		statsString.put(stats.get(7), "Mind Units Captured");
		statsString.put(stats.get(8), "Longest Link Ever Created");
		statsString.put(stats.get(9), "Largest Control Field");
		statsString.put(stats.get(10), "XM Recharged");
		statsString.put(stats.get(11), "Portals Captured");
		statsString.put(stats.get(12), "Unique Portals Captured");

		//Combat
		statsString.put(stats.get(13), "Resonators Destroyed");
		statsString.put(stats.get(14), "Portals Neutralized");
		statsString.put(stats.get(15), "Enemy Links Destroyed");
		statsString.put(stats.get(16), "Enemy Control Fields Destroyed");		
		
		//Health
		statsString.put(stats.get(17), "Distance Walked");
		
		//Defence
		statsString.put(stats.get(18), "Max Time Portal Held");
		statsString.put(stats.get(19), "Max Time Link Maintained");
		statsString.put(stats.get(20), "Max Link Length x Days");
		statsString.put(stats.get(21), "Max Time Field Held");
		statsString.put(stats.get(22), "Largest Field MUs x Days");
	}
}
