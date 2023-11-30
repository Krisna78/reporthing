package com.example.reporthing.Students.Models.Profiles;

import com.google.gson.annotations.SerializedName;

public class ProfileData {

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

	public void setFotoSiswa(String fotoSiswa){
		this.fotoSiswa = fotoSiswa;
	}

	public String getFotoSiswa(){
		return fotoSiswa;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setIdTahunajaran(String idTahunajaran){
		this.idTahunajaran = idTahunajaran;
	}

	public String getIdTahunajaran(){
		return idTahunajaran;
	}

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

	public void setIdKelas(String idKelas){
		this.idKelas = idKelas;
	}

	public String getIdKelas(){
		return idKelas;
	}

	public void setNoTelp(String noTelp){
		this.noTelp = noTelp;
	}

	public String getNoTelp(){
		return noTelp;
	}

	public void setTanggalLahir(String tanggalLahir){
		this.tanggalLahir = tanggalLahir;
	}

	public String getTanggalLahir(){
		return tanggalLahir;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}
}