package com.renatoalmeida.parserstuff;

public interface IStat {
	
	String getStatName();
	
	String getStatLine();
	
	int handle(String line);
	
	int getStatNumber();
}
