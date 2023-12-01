package com.example.reporthing.Auth.models.VerifyPass;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ChangePassResponse {

	@SerializedName("code")
	private int code;

	@SerializedName("forgot_pass")
	private List<ChangePassData> forgotPass;

	@SerializedName("status")
	private String status;

	public void setCode(int code){
		this.code = code;
	}

	public int getCode(){
		return code;
	}

	public void setForgotPass(List<ChangePassData> forgotPass){
		this.forgotPass = forgotPass;
	}

	public List<ChangePassData> getForgotPass(){
		return forgotPass;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}
}