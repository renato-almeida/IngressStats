package com.renatoalmeida.ingressstats.shareactivity;

public class StatItem implements Item {
	
	private final String stat;
	private final long value;

	public StatItem(String stat, long value) {
		this.stat = stat;
		this.value = value;
	}

	public String getStat() {
		return stat;
	}

	public long getValue() {
		return value;
	}

	@Override
	public boolean isSection() {
		return false;
	}
}
