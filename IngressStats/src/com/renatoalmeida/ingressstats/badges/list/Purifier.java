package com.renatoalmeida.ingressstats.badges.list;

import java.util.ArrayList;
import java.util.List;

import com.renatoalmeida.ingressstats.R;
import com.renatoalmeida.ingressstats.badges.BadgeLevel;
import com.renatoalmeida.ingressstats.badges.BadgeList;
import com.renatoalmeida.ingressstats.badges.BadgeRequirement;
import com.renatoalmeida.ingressstats.badges.IBadge;

public class Purifier extends IBadge{

	private List<BadgeRequirement> requirements;
	
	static{
		BadgeList.add(new Purifier());
	}
	
	public Purifier(){
		requirements = new ArrayList<BadgeRequirement>(5);
		requirements.add(new BadgeRequirement(BadgeLevel.Bronze,   2000,   R.drawable.ic_badge_purifier_bronze));
		requirements.add(new BadgeRequirement(BadgeLevel.Silver,   10000,  R.drawable.ic_badge_purifier_silver));
		requirements.add(new BadgeRequirement(BadgeLevel.Gold,     30000,  R.drawable.ic_badge_purifier_gold));
		requirements.add(new BadgeRequirement(BadgeLevel.Platinum, 100000, R.drawable.ic_badge_purifier_platinum));
		requirements.add(new BadgeRequirement(BadgeLevel.Onyx,     300000, R.drawable.ic_badge_purifier_onyx));
	}
	
	public String getID() {
		return "ResonatorsDestroyed";
	}

	public String getName() {
		return "Purifier";
	}

	public String getDescription() {
		return "Purifier badge is achieved by destroying enemy Resonators.";
	}

	public List<BadgeRequirement> getRequirements() {
		return requirements;
	}
}
