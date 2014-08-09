package com.renatoalmeida.ingressstats.badges.list;

import java.util.ArrayList;
import java.util.List;

import com.renatoalmeida.ingressstats.R;
import com.renatoalmeida.ingressstats.badges.BadgeLevel;
import com.renatoalmeida.ingressstats.badges.BadgeList;
import com.renatoalmeida.ingressstats.badges.BadgeRequirement;
import com.renatoalmeida.ingressstats.badges.IBadge;

public class Connector extends IBadge{

	private List<BadgeRequirement> requirements;
	
	static{
		BadgeList.add(new Connector());
	}
	
	public Connector(){
		requirements = new ArrayList<BadgeRequirement>(5);
		requirements.add(new BadgeRequirement(BadgeLevel.Bronze,   50,    R.drawable.ic_badge_connector_bronze));
		requirements.add(new BadgeRequirement(BadgeLevel.Silver,   1000,  R.drawable.ic_badge_connector_silver));
		requirements.add(new BadgeRequirement(BadgeLevel.Gold,     5000,  R.drawable.ic_badge_connector_gold));
		requirements.add(new BadgeRequirement(BadgeLevel.Platinum, 25000, R.drawable.ic_badge_connector_platinum));
		requirements.add(new BadgeRequirement(BadgeLevel.Onyx,     100000, R.drawable.ic_badge_connector_onyx));
	}
	
	public String getID() {
		return "LinksCreated";
	}

	public String getName() {
		return "Connector";
	}

	public String getDescription() {
		return "Connector badge is achieved by linking portals, the more you link, the better tier you will obtain.";
	}

	public List<BadgeRequirement> getRequirements() {
		return requirements;
	}
}
