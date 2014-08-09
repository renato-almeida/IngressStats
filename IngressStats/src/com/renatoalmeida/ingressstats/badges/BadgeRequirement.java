package com.renatoalmeida.ingressstats.badges;

public class BadgeRequirement {
	
	private long value;
	private int imageResource;
	private BadgeLevel badgeLevel;
	
	public BadgeRequirement(BadgeLevel badgeLevel, long value, int imageResource) {
		this.value = value;
		this.imageResource = imageResource;
		this.badgeLevel = badgeLevel;
	}
	
	public long getValue() {
		return value;
	}
	
	public int getImageResource() {
		return imageResource;
	}
	
	public BadgeLevel getBadgeLevel() {
		return badgeLevel;
	}
}
