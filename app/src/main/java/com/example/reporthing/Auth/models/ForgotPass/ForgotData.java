package com.example.reporthing.Auth.models.ForgotPass;

import com.google.gson.annotations.SerializedName;

public class ForgotData {

	@SerializedName("nisn")
	private String nisn;

	@SerializedName("email")
	private String email;

	@SerializedName("username")
	private String username;

	public void setNisn(String nisn){
		this.nisn = nisn;
	}

	public String getNisn(){
		return nisn;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}
}