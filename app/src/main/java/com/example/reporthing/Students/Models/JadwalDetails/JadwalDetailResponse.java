package com.example.reporthing.Students.Models.JadwalDetails;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class JadwalDetailResponse {

	@SerializedName("jadwal")
	private List<JadwalDetailData> jadwal;

	@SerializedName("code")
	private int code;

	@SerializedName("status")
	private String status;

	public void setJadwal(List<JadwalDetailData> jadwal){
		this.jadwal = jadwal;
	}

	public List<JadwalDetailData> getJadwal(){
		return jadwal;
	}

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