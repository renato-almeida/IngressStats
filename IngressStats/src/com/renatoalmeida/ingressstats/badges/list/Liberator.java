package com.renatoalmeida.ingressstats.badges.list;

import java.util.ArrayList;
import java.util.List;

import com.renatoalmeida.ingressstats.R;
import com.renatoalmeida.ingressstats.badges.BadgeLevel;
import com.renatoalmeida.ingressstats.badges.BadgeList;
import com.renatoalmeida.ingressstats.badges.BadgeRequirement;
import com.renatoalmeida.ingressstats.badges.IBadge;

public class Liberator extends IBadge{

	private List<BadgeRequirement> requirements;
	
	static{
		BadgeList.add(new Liberator());
	}
	
	public Liberator(){
		requirements = new ArrayList<BadgeRequirement>(5);
		requirements.add(new BadgeRequirement(BadgeLevel.Bronze,   100,   R.drawable.ic_badge_liberator_bronze));
		requirements.add(new BadgeRequirement(BadgeLevel.Silver,   1000,  R.drawable.ic_badge_liberator_silver));
		requirements.add(new BadgeRequirement(BadgeLevel.Gold,     5000,  R.drawable.ic_badge_liberator_gold));
		requirements.add(new BadgeRequirement(BadgeLevel.Platinum, 15000, R.drawable.ic_badge_liberator_platinum));
		requirements.add(new BadgeRequirement(BadgeLevel.Onyx,     40000, R.drawable.ic_badge_liberator_onyx));
	}
	
	public String getID() {
		return "PortalsCaptured";
	}

	public String getName() {
		return "Liberator";
	}

	public String getDescription() {
		return "Liberator badge is achieved by capturing portals.";
	}

	public List<BadgeRequirement> getRequirements() {
		return requirements;
	}
}
