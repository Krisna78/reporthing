package com.example.reporthing.Auth.models.VerifyPass;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class VerifyResponse {

	@SerializedName("code")
	private int code;

	@SerializedName("user_profile")
	private List<VerifyData> userProfile;

	@SerializedName("status")
	private String status;

	public void setCode(int code){
		this.code = code;
	}

	public int getCode(){
		return code;
	}

	public void setUserProfile(List<VerifyData> userProfile){
		this.userProfile = userProfile;
	}

	public List<VerifyData> getUserProfile(){
		return userProfile;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}
}