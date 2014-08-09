package com.renatoalmeida.ingressstats.badges.list;

import java.util.ArrayList;
import java.util.List;

import com.renatoalmeida.ingressstats.R;
import com.renatoalmeida.ingressstats.badges.BadgeLevel;
import com.renatoalmeida.ingressstats.badges.BadgeList;
import com.renatoalmeida.ingressstats.badges.BadgeRequirement;
import com.renatoalmeida.ingressstats.badges.IBadge;

public class Explorer extends IBadge{

	private List<BadgeRequirement> requirements;
	
	static{
		BadgeList.add(new Explorer());
	}
	
	public Explorer(){
		requirements = new ArrayList<BadgeRequirement>(5);
		requirements.add(new BadgeRequirement(BadgeLevel.Bronze,   100,   R.drawable.ic_badge_explorer_bronze));
		requirements.add(new BadgeRequirement(BadgeLevel.Silver,   1000,  R.drawable.ic_badge_explorer_silver));
		requirements.add(new BadgeRequirement(BadgeLevel.Gold,     2000,  R.drawable.ic_badge_explorer_gold));
		requirements.add(new BadgeRequirement(BadgeLevel.Platinum, 10000, R.drawable.ic_badge_explorer_platinum));
		requirements.add(new BadgeRequirement(BadgeLevel.Onyx,     30000, R.drawable.ic_badge_explorer_onyx));
	}
	
	public String getID() {
		return "UniquePortalsVisited";
	}

	public String getName() {
		return "Explorer";
	}

	public String getDescription() {
		return "Explorer badge is achieved by visiting and hacking distinct Portals.";
	}

	public List<BadgeRequirement> getRequirements() {
		return requirements;
	}
}
