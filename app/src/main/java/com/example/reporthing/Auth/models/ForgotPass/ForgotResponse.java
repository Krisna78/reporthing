package com.example.reporthing.Auth.models.ForgotPass;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ForgotResponse {

	@SerializedName("code")
	private int code;
	@SerializedName("status")
	private String status;
	@SerializedName("user_profile")
	private List<ForgotData> userProfile;

	public void setCode(int code){
		this.code = code;
	}

	public int getCode(){
		return code;
	}

	public void setUserProfile(List<ForgotData> userProfile){
		this.userProfile = userProfile;
	}

	public List<ForgotData> getUserProfile(){
		return userProfile;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}
}