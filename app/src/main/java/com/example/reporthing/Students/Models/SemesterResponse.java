package com.example.reporthing.Students.Models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class SemesterResponse {

	@SerializedName("code")
	private int code;

	@SerializedName("user_profile")
	private List<SemesterData> userProfile;

	@SerializedName("status")
	private String status;

	public void setCode(int code){
		this.code = code;
	}

	public int getCode(){
		return code;
	}

	public void setUserProfile(List<SemesterData> userProfile){
		this.userProfile = userProfile;
	}

	public List<SemesterData> getUserProfile(){
		return userProfile;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}
}