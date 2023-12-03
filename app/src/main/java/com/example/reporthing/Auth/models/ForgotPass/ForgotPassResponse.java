package com.example.reporthing.Auth.models.ForgotPass;

import com.google.gson.annotations.SerializedName;

public class ForgotPassResponse {

	@SerializedName("code")
	private int code;

	@SerializedName("status")
	private String status;

	public void setCode(int code){
		this.code = code;
	}

	public int getCode(){
		return code;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}
}