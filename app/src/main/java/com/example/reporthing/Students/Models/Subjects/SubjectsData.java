package com.example.reporthing.Students.Models.Subjects;

import com.google.gson.annotations.SerializedName;

public class SubjectsData {

	@SerializedName("pjok")
	private String pjok;

	@SerializedName("bahasa_inggris")
	private String bahasaInggris;

	@SerializedName("nisn")
	private String nisn;

	@SerializedName("mtk")
	private String mtk;

	@SerializedName("ipas")
	private String ipas;

	@SerializedName("seni_tari")
	private String seniTari;

	@SerializedName("rata_rata")
	private String rataRata;

	@SerializedName("tahun_ajaran")
	private String tahunAjaran;

	@SerializedName("bahasa_indonesia")
	private String bahasaIndonesia;

	@SerializedName("nama_siswa")
	private String namaSiswa;

	@SerializedName("seni_rupa")
	private String seniRupa;

	@SerializedName("semester")
	private String semester;

	@SerializedName("id_kelas")
	private String idKelas;

	@SerializedName("seni_musik")
	private String seniMusik;

	@SerializedName("seni_teater")
	private String seniTeater;

	public void setPjok(String pjok){
		this.pjok = pjok;
	}

	public String getPjok(){
		return pjok;
	}

	public void setBahasaInggris(String bahasaInggris){
		this.bahasaInggris = bahasaInggris;
	}

	public String getBahasaInggris(){
		return bahasaInggris;
	}

	public void setNisn(String nisn){
		this.nisn = nisn;
	}

	public String getNisn(){
		return nisn;
	}

	public void setMtk(String mtk){
		this.mtk = mtk;
	}

	public String getMtk(){
		return mtk;
	}

	public void setIpas(String ipas){
		this.ipas = ipas;
	}

	public String getIpas(){
		return ipas;
	}

	public void setSeniTari(String seniTari){
		this.seniTari = seniTari;
	}

	public String getSeniTari(){
		return seniTari;
	}

	public void setRataRata(String rataRata){
		this.rataRata = rataRata;
	}

	public String getRataRata(){
		return rataRata;
	}

	public void setTahunAjaran(String tahunAjaran){
		this.tahunAjaran = tahunAjaran;
	}

	public String getTahunAjaran(){
		return tahunAjaran;
	}

	public void setBahasaIndonesia(String bahasaIndonesia){
		this.bahasaIndonesia = bahasaIndonesia;
	}

	public String getBahasaIndonesia(){
		return bahasaIndonesia;
	}

	public void setNamaSiswa(String namaSiswa){
		this.namaSiswa = namaSiswa;
	}

	public String getNamaSiswa(){
		return namaSiswa;
	}

	public void setSeniRupa(String seniRupa){
		this.seniRupa = seniRupa;
	}

	public String getSeniRupa(){
		return seniRupa;
	}

	public void setSemester(String semester){
		this.semester = semester;
	}

	public String getSemester(){
		return semester;
	}

	public void setIdKelas(String idKelas){
		this.idKelas = idKelas;
	}

	public String getIdKelas(){
		return idKelas;
	}

	public void setSeniMusik(String seniMusik){
		this.seniMusik = seniMusik;
	}

	public String getSeniMusik(){
		return seniMusik;
	}

	public void setSeniTeater(String seniTeater){
		this.seniTeater = seniTeater;
	}

	public String getSeniTeater(){
		return seniTeater;
	}
}