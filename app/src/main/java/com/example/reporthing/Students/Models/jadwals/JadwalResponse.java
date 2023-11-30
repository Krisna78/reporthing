package com.example.reporthing.Students.Models.jadwals;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class JadwalResponse {

	@SerializedName("jadwal")
	private List<JadwalData> jadwal;

	@SerializedName("code")
	private int code;

	@SerializedName("status")
	private String status;

	public void setJadwal(List<JadwalData> jadwal){
		this.jadwal = jadwal;
	}

	public List<JadwalData> getJadwal(){
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