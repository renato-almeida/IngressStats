package com.renatoalmeida.ingressstats.badges;

import java.util.List;


public abstract class IBadge {
	public abstract String getID();
	public abstract String getName();
	public abstract String getDescription();
	public abstract List<BadgeRequirement> getRequirements();
	
	public BadgeRequirement getBadge(long value){
		BadgeRequirement retBReq = null;
		
		for(BadgeRequirement bReq : getRequirements())
			if(value >= bReq.getValue())
				retBReq = bReq;
			else
				break;
		
		return retBReq;
	}
	
	public BadgeRequirement getNextBadgeRequirement(BadgeRequirement current){
		int pos = getRequirements().indexOf(current);
		
		if(pos >= getRequirements().size()-1)
			return null;
		else
			return getRequirements().get(pos+1);
	}
}
