package com.renatoalmeida.ingressstats.badges.list;

import java.util.ArrayList;
import java.util.List;

import com.renatoalmeida.ingressstats.R;
import com.renatoalmeida.ingressstats.badges.BadgeLevel;
import com.renatoalmeida.ingressstats.badges.BadgeList;
import com.renatoalmeida.ingressstats.badges.BadgeRequirement;
import com.renatoalmeida.ingressstats.badges.IBadge;

public class MindController extends IBadge{

	private List<BadgeRequirement> requirements;
	
	static{
		BadgeList.add(new MindController());
	}
	
	public MindController(){
		requirements = new ArrayList<BadgeRequirement>(5);
		requirements.add(new BadgeRequirement(BadgeLevel.Bronze,   100,   R.drawable.ic_badge_mind_controller_bronze));
		requirements.add(new BadgeRequirement(BadgeLevel.Silver,   500,   R.drawable.ic_badge_mind_controller_silver));
		requirements.add(new BadgeRequirement(BadgeLevel.Gold,     2000,  R.drawable.ic_badge_mind_controller_gold));
		requirements.add(new BadgeRequirement(BadgeLevel.Platinum, 10000, R.drawable.ic_badge_mind_controller_platinum));
		requirements.add(new BadgeRequirement(BadgeLevel.Onyx,     40000, R.drawable.ic_badge_mind_controller_onyx));
	}
	
	public String getID() {
		return "ControlFieldsCreated";
	}

	public String getName() {
		return "Mind Controller";
	}

	public String getDescription() {
		return "Mind Controller badge is achieved by creating Control Fields.";
	}

	public List<BadgeRequirement> getRequirements() {
		return requirements;
	}
}
