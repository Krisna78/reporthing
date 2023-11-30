package com.example.reporthing.Students.Models.Semesters;

import com.google.gson.annotations.SerializedName;

public class SemesterData {

	@SerializedName("nisn")
	private String nisn;

	@SerializedName("semester")
	private String semester;

	@SerializedName("tahun_ajaran")
	private String tahunAjaran;

	public void setNisn(String nisn){
		this.nisn = nisn;
	}

	public String getNisn(){
		return nisn;
	}

	public void setSemester(String semester){
		this.semester = semester;
	}

	public String getSemester(){
		return semester;
	}

	public void setTahunAjaran(String tahunAjaran){
		this.tahunAjaran = tahunAjaran;
	}

	public String getTahunAjaran(){
		return tahunAjaran;
	}
}