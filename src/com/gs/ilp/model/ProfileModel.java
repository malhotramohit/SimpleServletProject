package com.gs.ilp.model;

public class ProfileModel {

	private int seq;
	private String username;
	private String password;

	public ProfileModel(int seq, String username, String password) {
		super();
		this.seq = seq;
		this.username = username;
		this.password = password;
	}

	
	
	public ProfileModel() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
