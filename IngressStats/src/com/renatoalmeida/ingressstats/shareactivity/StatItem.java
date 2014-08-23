package com.renatoalmeida.ingressstats.shareactivity;

public class StatItem implements Item {
	
	private final String stat;
	private final int value;

	public StatItem(String stat, int value) {
		this.stat = stat;
		this.value = value;
	}

	public String getStat() {
		return stat;
	}

	public int getValue() {
		return value;
	}

	@Override
	public boolean isSection() {
		return false;
	}
}
