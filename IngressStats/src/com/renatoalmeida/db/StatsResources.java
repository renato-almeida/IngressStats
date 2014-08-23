package com.renatoalmeida.db;

import java.util.List;

import android.util.SparseArray;

public class StatsResources {

	public final static SparseArray<String> stats = new SparseArray<String>();
	
	static{
		//Fill the order that will be shown when presenting the results
		//kind of stupid
		
		//Discovery
		stats.put(0, "UniquePortalsVisited");
		stats.put(1, "PortalsDiscovered");
		stats.put(2, "XMCollected");
		
		//Building
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

		//Combat
		stats.put(13, "ResonatorsDestroyed");
		stats.put(14, "PortalsNeutralized");
		stats.put(15, "EnemyLinksDestroyed");
		stats.put(16, "EnemyControlFieldsDestroyed");		
		
		//Health
		stats.put(17, "DistanceWalked");
		
		//Defence
		stats.put(18, "MaxTimePortalHeld");
		stats.put(19, "MaxTimeLinkMaintained");
		stats.put(20, "MaxLinkLengthxDays");
		stats.put(21, "MaxTimeFieldHeld");
		stats.put(22, "LargestFieldMUsxDays");

		stats.put(23, "AP");
		
		
		//Groups
		//
		
	}
}
