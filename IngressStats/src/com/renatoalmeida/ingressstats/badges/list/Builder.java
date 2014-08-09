package com.renatoalmeida.ingressstats.badges.list;

import java.util.ArrayList;
import java.util.List;

import com.renatoalmeida.ingressstats.R;
import com.renatoalmeida.ingressstats.badges.BadgeLevel;
import com.renatoalmeida.ingressstats.badges.BadgeList;
import com.renatoalmeida.ingressstats.badges.BadgeRequirement;
import com.renatoalmeida.ingressstats.badges.IBadge;

public class Builder extends IBadge{

	private List<BadgeRequirement> requirements;
	
	static{
		BadgeList.add(new Builder());
	}
	
	public Builder(){
		requirements = new ArrayList<BadgeRequirement>(5);
		requirements.add(new BadgeRequirement(BadgeLevel.Bronze,   2000,   R.drawable.ic_badge_builder_bronze));
		requirements.add(new BadgeRequirement(BadgeLevel.Silver,   10000,  R.drawable.ic_badge_builder_silver));
		requirements.add(new BadgeRequirement(BadgeLevel.Gold,     30000,  R.drawable.ic_badge_builder_gold));
		requirements.add(new BadgeRequirement(BadgeLevel.Platinum, 100000, R.drawable.ic_badge_builder_platinum));
		requirements.add(new BadgeRequirement(BadgeLevel.Onyx,     200000, R.drawable.ic_badge_builder_onyx));
	}
	
	public String getID() {
		return "ResonatorsDeployed";
	}

	public String getName() {
		return "Builder";
	}

	public String getDescription() {
		return "Builder badge is achieved by deploying resonators to portals.";
	}

	public List<BadgeRequirement> getRequirements() {
		return requirements;
	}
}
