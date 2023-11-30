package com.example.reporthing.Auth.models.VerifyPass;

import com.google.gson.annotations.SerializedName;

public class VerifyData {

	@SerializedName("nisn")
	private String nisn;

	@SerializedName("otp")
	private String otp;

	public void setNisn(String nisn){
		this.nisn = nisn;
	}

	public String getNisn(){
		return nisn;
	}

	public void setOtp(String otp){
		this.otp = otp;
	}

	public String getOtp(){
		return otp;
	}
}