package com.example.reporthing.Auth.models;

import com.google.gson.annotations.SerializedName;

public class UserData{

	@SerializedName("password")
	private String password;

	@SerializedName("nisn")
	private String nisn;

	@SerializedName("id_user_siswa")
	private String idUserSiswa;

	@SerializedName("username")
	private String username;

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setNisn(String nisn){
		this.nisn = nisn;
	}

	public String getNisn(){
		return nisn;
	}

	public void setIdUserSiswa(String idUserSiswa){
		this.idUserSiswa = idUserSiswa;
	}

	public String getIdUserSiswa(){
		return idUserSiswa;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}
}