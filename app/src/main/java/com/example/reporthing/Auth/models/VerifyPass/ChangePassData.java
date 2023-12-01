package com.example.reporthing.Auth.models.VerifyPass;

import com.google.gson.annotations.SerializedName;

public class ChangePassData {

	@SerializedName("nisn")
	private String nisn;

	public void setNisn(String nisn){
		this.nisn = nisn;
	}

	public String getNisn(){
		return nisn;
	}
}