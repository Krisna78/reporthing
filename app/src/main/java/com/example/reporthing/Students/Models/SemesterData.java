package com.example.reporthing.Students.Models;

import com.google.gson.annotations.SerializedName;

public class SemesterData {

	@SerializedName("semester_ke")
	private String semesterKe;

	@SerializedName("thn_ajaran")
	private String thnAjaran;

	@SerializedName("nisn")
	private String nisn;

	public String getSemesterKe() {
		return semesterKe;
	}

	public void setSemesterKe(String semesterKe) {
		this.semesterKe = semesterKe;
	}

	public String getThnAjaran() {
		return thnAjaran;
	}

	public void setThnAjaran(String thnAjaran) {
		this.thnAjaran = thnAjaran;
	}

	public String getNisn() {
		return nisn;
	}

	public void setNisn(String nisn) {
		this.nisn = nisn;
	}
}