package com.example.reporthing.Auth.models.ForgotPass;

import com.google.gson.annotations.SerializedName;

public class ForgotPassData {

	@SerializedName("nisn")
	private String nisn;

	public void setNisn(String nisn){
		this.nisn = nisn;
	}

	public String getNisn(){
		return nisn;
	}
}