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

	public void setCode(int code){
		this.code = code;
	}

	public int getCode(){
		return code;
	}

	public void setUserList(List<UserData> userList){
		this.userList = userList;
	}

	public List<UserData> getUserList(){
		return userList;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}
}