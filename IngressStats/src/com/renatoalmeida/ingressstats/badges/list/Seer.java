package com.renatoalmeida.ingressstats.badges.list;

import java.util.ArrayList;
import java.util.List;

import com.renatoalmeida.ingressstats.R;
import com.renatoalmeida.ingressstats.badges.BadgeLevel;
import com.renatoalmeida.ingressstats.badges.BadgeList;
import com.renatoalmeida.ingressstats.badges.BadgeRequirement;
import com.renatoalmeida.ingressstats.badges.IBadge;

public class Seer extends IBadge{

	private List<BadgeRequirement> requirements;
	
	static{
		BadgeList.add(new Seer());
	}
	
	public Seer(){
		requirements = new ArrayList<BadgeRequirement>(5);
		requirements.add(new BadgeRequirement(BadgeLevel.Bronze,   10,   R.drawable.ic_badge_seer_bronze));
		requirements.add(new BadgeRequirement(BadgeLevel.Silver,   50,   R.drawable.ic_badge_seer_silver));
		requirements.add(new BadgeRequirement(BadgeLevel.Gold,     200,  R.drawable.ic_badge_seer_gold));
		requirements.add(new BadgeRequirement(BadgeLevel.Platinum, 500,  R.drawable.ic_badge_seer_platinum));
		requirements.add(new BadgeRequirement(BadgeLevel.Onyx,     5000, R.drawable.ic_badge_seer_onyx));
	}
	
	public String getID() {
		return "PortalsDiscovered";
	}

	public String getName() {
		return "Seer";
	}

	public String getDescription() {
		return "Seer badge is achieved by discovering and successfully submitting new Portals.";
	}

	public List<BadgeRequirement> getRequirements() {
		return requirements;
	}
}
