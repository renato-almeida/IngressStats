package com.renatoalmeida.ingressstats.badges;

import java.util.HashMap;

import com.renatoalmeida.ingressstats.badges.list.Builder;
import com.renatoalmeida.ingressstats.badges.list.Connector;
import com.renatoalmeida.ingressstats.badges.list.Explorer;
import com.renatoalmeida.ingressstats.badges.list.Guardian;
import com.renatoalmeida.ingressstats.badges.list.Hacker;
import com.renatoalmeida.ingressstats.badges.list.Liberator;
import com.renatoalmeida.ingressstats.badges.list.MindController;
import com.renatoalmeida.ingressstats.badges.list.Pioneer;
import com.renatoalmeida.ingressstats.badges.list.Purifier;
import com.renatoalmeida.ingressstats.badges.list.Recharger;
import com.renatoalmeida.ingressstats.badges.list.Seer;

public class BadgeList {
	
	public static final HashMap<String, IBadge> List = new HashMap<String, IBadge>();
	
	public static void add(IBadge badge){
		List.put(badge.getID(), badge);
	}
	
	static{
		add(new Builder());
		add(new Connector());
		add(new Explorer());
		add(new Guardian());
		add(new Hacker());
		add(new Liberator());
		add(new MindController());
		add(new Pioneer());
		add(new Purifier());
		add(new Recharger());
		add(new Seer());
	}
}