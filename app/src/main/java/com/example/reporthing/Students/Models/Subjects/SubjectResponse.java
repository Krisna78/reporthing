package com.example.reporthing.Students.Models.Subjects;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class SubjectResponse {

	@SerializedName("code")
	private int code;

	@SerializedName("subjects")
	private List<SubjectsData> subjects;

	@SerializedName("status")
	private String status;

	public void setCode(int code){
		this.code = code;
	}

	public int getCode(){
		return code;
	}

	public void setSubjects(List<SubjectsData> subjects){
		this.subjects = subjects;
	}

	public List<SubjectsData> getSubjects(){
		return subjects;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}
}