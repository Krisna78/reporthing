package com.example.reporthing.Auth.models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class UserResponse {

	@SerializedName("code")
	private int code;

	@SerializedName("user_list")
	private List<UserData> userList;

	@SerializedName("status")
	private String status;

	public int getCode(){
		return code;
	}

	public List<UserData> getUserList(){
		return userList;
	}

	public String getStatus(){
		return status;
	}
}