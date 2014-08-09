package com.renatoalmeida.ingressstats.badges.list;

import java.util.ArrayList;
import java.util.List;

import com.renatoalmeida.ingressstats.R;
import com.renatoalmeida.ingressstats.badges.BadgeLevel;
import com.renatoalmeida.ingressstats.badges.BadgeList;
import com.renatoalmeida.ingressstats.badges.BadgeRequirement;
import com.renatoalmeida.ingressstats.badges.IBadge;

public class Guardian extends IBadge{

	private List<BadgeRequirement> requirements;
	
	static{
		BadgeList.add(new Guardian());
	}
	
	public Guardian(){
		requirements = new ArrayList<BadgeRequirement>(5);
		requirements.add(new BadgeRequirement(BadgeLevel.Bronze,   3,   R.drawable.ic_badge_guardian_bronze));
		requirements.add(new BadgeRequirement(BadgeLevel.Silver,   10,  R.drawable.ic_badge_guardian_silver));
		requirements.add(new BadgeRequirement(BadgeLevel.Gold,     20,  R.drawable.ic_badge_guardian_gold));
		requirements.add(new BadgeRequirement(BadgeLevel.Platinum, 90,  R.drawable.ic_badge_guardian_platinum));
		requirements.add(new BadgeRequirement(BadgeLevel.Onyx,     150, R.drawable.ic_badge_guardian_onyx));
	}
	
	public String getID() {
		return "MaxTimePortalHeld";
	}

	public String getName() {
		return "Guardian";
	}

	public String getDescription() {
		return "Guardian badge is achieved by protecting and maintain control of a Portal for an extended period of time.";
	}

	public List<BadgeRequirement> getRequirements() {
		return requirements;
	}
}
