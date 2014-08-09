package com.renatoalmeida.ingressstats.badges.list;

import java.util.ArrayList;
import java.util.List;

import com.renatoalmeida.ingressstats.R;
import com.renatoalmeida.ingressstats.badges.BadgeLevel;
import com.renatoalmeida.ingressstats.badges.BadgeList;
import com.renatoalmeida.ingressstats.badges.BadgeRequirement;
import com.renatoalmeida.ingressstats.badges.IBadge;

public class Hacker extends IBadge{

	private List<BadgeRequirement> requirements;
	
	static{
		BadgeList.add(new Hacker());
	}
	
	public Hacker(){
		requirements = new ArrayList<BadgeRequirement>(5);
		requirements.add(new BadgeRequirement(BadgeLevel.Bronze,   2000,   R.drawable.ic_badge_hacker_bronze));
		requirements.add(new BadgeRequirement(BadgeLevel.Silver,   10000,  R.drawable.ic_badge_hacker_silver));
		requirements.add(new BadgeRequirement(BadgeLevel.Gold,     30000,  R.drawable.ic_badge_hacker_gold));
		requirements.add(new BadgeRequirement(BadgeLevel.Platinum, 100000, R.drawable.ic_badge_hacker_platinum));
		requirements.add(new BadgeRequirement(BadgeLevel.Onyx,     200000, R.drawable.ic_badge_hacker_onyx));
	}
	
	public String getID() {
		return "Hacks";
	}

	public String getName() {
		return "Hacker";
	}

	public String getDescription() {
		return "Hacker badge is achieved by hacking Portals.";
	}

	public List<BadgeRequirement> getRequirements() {
		return requirements;
	}
}
