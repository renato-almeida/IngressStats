package com.renatoalmeida.ingressstats.badges.list;

import java.util.ArrayList;
import java.util.List;

import com.renatoalmeida.ingressstats.R;
import com.renatoalmeida.ingressstats.badges.BadgeLevel;
import com.renatoalmeida.ingressstats.badges.BadgeList;
import com.renatoalmeida.ingressstats.badges.BadgeRequirement;
import com.renatoalmeida.ingressstats.badges.IBadge;

public class Pioneer extends IBadge{

	private List<BadgeRequirement> requirements;
	
	static{
		BadgeList.add(new Pioneer());
	}
	
	public Pioneer(){
		requirements = new ArrayList<BadgeRequirement>(5);
		requirements.add(new BadgeRequirement(BadgeLevel.Bronze,   20,    R.drawable.ic_badge_pioneer_bronze));
		requirements.add(new BadgeRequirement(BadgeLevel.Silver,   200,   R.drawable.ic_badge_pioneer_silver));
		requirements.add(new BadgeRequirement(BadgeLevel.Gold,     1000,  R.drawable.ic_badge_pioneer_gold));
		requirements.add(new BadgeRequirement(BadgeLevel.Platinum, 5000,  R.drawable.ic_badge_pioneer_platinum));
		requirements.add(new BadgeRequirement(BadgeLevel.Onyx,     20000, R.drawable.ic_badge_pioneer_onyx));
	}
	
	public String getID() {
		return "UniquePortalsCaptured";
	}

	public String getName() {
		return "Pioneer";
	}

	public String getDescription() {
		return "Pioneer badge is achieved by capturing unique portals.";
	}

	public List<BadgeRequirement> getRequirements() {
		return requirements;
	}
}
