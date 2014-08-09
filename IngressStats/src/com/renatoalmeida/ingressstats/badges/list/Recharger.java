package com.renatoalmeida.ingressstats.badges.list;

import java.util.ArrayList;
import java.util.List;

import com.renatoalmeida.ingressstats.R;
import com.renatoalmeida.ingressstats.badges.BadgeLevel;
import com.renatoalmeida.ingressstats.badges.BadgeList;
import com.renatoalmeida.ingressstats.badges.BadgeRequirement;
import com.renatoalmeida.ingressstats.badges.IBadge;

public class Recharger extends IBadge{

	private List<BadgeRequirement> requirements;
	
	static{
		BadgeList.add(new Recharger());
	}
	
	public Recharger(){
		requirements = new ArrayList<BadgeRequirement>(5);
		requirements.add(new BadgeRequirement(BadgeLevel.Bronze,   100000,   R.drawable.ic_badge_recharger_bronze));
		requirements.add(new BadgeRequirement(BadgeLevel.Silver,   1000000,  R.drawable.ic_badge_recharger_silver));
		requirements.add(new BadgeRequirement(BadgeLevel.Gold,     3000000,  R.drawable.ic_badge_recharger_gold));
		requirements.add(new BadgeRequirement(BadgeLevel.Platinum, 10000000, R.drawable.ic_badge_recharger_platinum));
		requirements.add(new BadgeRequirement(BadgeLevel.Onyx,     25000000, R.drawable.ic_badge_recharger_onyx));
	}
	
	public String getID() {
		return "XMRecharged";
	}

	public String getName() {
		return "Recharger";
	}

	public String getDescription() {
		return "Recharge Portals with Exotic Matter ";
	}

	public List<BadgeRequirement> getRequirements() {
		return requirements;
	}
}
