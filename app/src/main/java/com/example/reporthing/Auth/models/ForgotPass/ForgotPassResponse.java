package com.example.reporthing.Auth.models.ForgotPass;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ForgotPassResponse {

	@SerializedName("code")
	private int code;

	@SerializedName("forgot_pass")
	private List<ForgotPassData> forgotPass;

	@SerializedName("status")
	private String status;

	public void setCode(int code){
		this.code = code;
	}

	public int getCode(){
		return code;
	}

	public void setForgotPass(List<ForgotPassData> forgotPass){
		this.forgotPass = forgotPass;
	}

	public List<ForgotPassData> getForgotPass(){
		return forgotPass;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}
}