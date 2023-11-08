package com.example.reporthing.Students.Models;

import com.google.gson.annotations.SerializedName;

public class ProfileData {

	@SerializedName("nama_siswa")
	private String namaSiswa;

	@SerializedName("nama_kelas")
	private String namaKelas;

	@SerializedName("nisn")
	private String nisn;

	public void setNamaSiswa(String namaSiswa){
		this.namaSiswa = namaSiswa;
	}

	public String getNamaSiswa(){
		return namaSiswa;
	}

	public void setNamaKelas(String namaKelas){
		this.namaKelas = namaKelas;
	}

	public String getNamaKelas(){
		return namaKelas;
	}

	public void setNisn(String nisn){
		this.nisn = nisn;
	}

	public String getNisn(){
		return nisn;
	}
}