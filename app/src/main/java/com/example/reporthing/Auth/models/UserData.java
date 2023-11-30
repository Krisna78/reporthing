package com.example.reporthing.Auth.models;

import com.google.gson.annotations.SerializedName;

public class UserData {

	@SerializedName("foto_siswa")
	private String fotoSiswa;

	@SerializedName("password")
	private String password;

	@SerializedName("id_tahunajaran")
	private String idTahunajaran;

	@SerializedName("nama_siswa")
	private String namaSiswa;

	@SerializedName("nama_kelas")
	private String namaKelas;

	@SerializedName("nisn")
	private String nisn;

	@SerializedName("id_kelas")
	private String idKelas;

	@SerializedName("no_telp")
	private String noTelp;

	@SerializedName("tanggal_lahir")
	private String tanggalLahir;

	@SerializedName("username")
	private String username;

	public String getFotoSiswa(){
		return fotoSiswa;
	}

	public String getPassword(){
		return password;
	}

	public String getIdTahunajaran(){
		return idTahunajaran;
	}

	public String getNamaSiswa(){
		return namaSiswa;
	}

	public String getNamaKelas(){
		return namaKelas;
	}

	public String getNisn(){
		return nisn;
	}

	public String getIdKelas(){
		return idKelas;
	}

	public String getNoTelp(){
		return noTelp;
	}

	public String getTanggalLahir(){
		return tanggalLahir;
	}

	public String getUsername(){
		return username;
	}
}