package com.example.reporthing.Students.Models.Subjects;

import com.google.gson.annotations.SerializedName;

public class SubjectsData {

	@SerializedName("id_tahunajaran")
	private String idTahunajaran;

	@SerializedName("nisn")
	private String nisn;

	@SerializedName("nama_mapel")
	private String namaMapel;

	@SerializedName("sumatif")
	private String sumatif;

	@SerializedName("semester")
	private String semester;

	@SerializedName("sumatif_akhir")
	private String sumatifAkhir;

	@SerializedName("tahun_ajaran")
	private String tahunAjaran;

	@SerializedName("nilai_rapor")
	private String nilaiRapor;

	public void setIdTahunajaran(String idTahunajaran){
		this.idTahunajaran = idTahunajaran;
	}

	public String getIdTahunajaran(){
		return idTahunajaran;
	}

	public void setNisn(String nisn){
		this.nisn = nisn;
	}

	public String getNisn(){
		return nisn;
	}

	public void setNamaMapel(String namaMapel){
		this.namaMapel = namaMapel;
	}

	public String getNamaMapel(){
		return namaMapel;
	}

	public void setSumatif(String sumatif){
		this.sumatif = sumatif;
	}

	public String getSumatif(){
		return sumatif;
	}

	public void setSemester(String semester){
		this.semester = semester;
	}

	public String getSemester(){
		return semester;
	}

	public void setSumatifAkhir(String sumatifAkhir){
		this.sumatifAkhir = sumatifAkhir;
	}

	public String getSumatifAkhir(){
		return sumatifAkhir;
	}

	public void setTahunAjaran(String tahunAjaran){
		this.tahunAjaran = tahunAjaran;
	}

	public String getTahunAjaran(){
		return tahunAjaran;
	}

	public void setNilaiRapor(String nilaiRapor){
		this.nilaiRapor = nilaiRapor;
	}

	public String getNilaiRapor(){
		return nilaiRapor;
	}
}