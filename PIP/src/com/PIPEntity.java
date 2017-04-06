package com;

public class PIPEntity {
	/*
	 * Interface block:
	 * 	void setID()
	 * 	int getID()
	 *
	 * 	void setTag()
	 * 	String getTag()
	 */
	private int id;
	private String tag;

	public void setID(int id) {
		this.id = id;
	}
	
	public int getID() {
		return this.id;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getTag() {
		return this.tag;
	}
}
