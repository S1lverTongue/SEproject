// Coded by Trent May
package com;

import java.io.Serializable;

public class PIPEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2927455895964225131L;
	/*
	 * Interface block:
	 * 	void setID()
	 * 	int getID()
	 *
	 * 	void setTag()
	 * 	String getTag()
	 * 
	 * void setTitle()
	 * String getTitle();
	 */
	private int id;
	private String tag;
	private String title;

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
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return this.title;
	}
}
