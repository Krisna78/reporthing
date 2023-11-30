package com.example.reporthing.Students.Models.JadwalDetails;

import com.google.gson.annotations.SerializedName;

public class JadwalDetailData {

	@SerializedName("hari")
	private String hari;

	@SerializedName("jam_mulai")
	private String jamMulai;

	@SerializedName("nip")
	private String nip;

	@SerializedName("nama_kelas")
	private String namaKelas;

	@SerializedName("id_jadwal")
	private String idJadwal;

	@SerializedName("jam_selesai")
	private String jamSelesai;

	@SerializedName("nama_mapel")
	private String namaMapel;

	@SerializedName("id_kelas")
	private String idKelas;

	@SerializedName("id_mapel")
	private String idMapel;

	public void setHari(String hari){
		this.hari = hari;
	}

	public String getHari(){
		return hari;
	}

	public void setJamMulai(String jamMulai){
		this.jamMulai = jamMulai;
	}

	public String getJamMulai(){
		return jamMulai;
	}

	public void setNip(String nip){
		this.nip = nip;
	}

	public String getNip(){
		return nip;
	}

	public void setNamaKelas(String namaKelas){
		this.namaKelas = namaKelas;
	}

	public String getNamaKelas(){
		return namaKelas;
	}

	public void setIdJadwal(String idJadwal){
		this.idJadwal = idJadwal;
	}

	public String getIdJadwal(){
		return idJadwal;
	}

	public void setJamSelesai(String jamSelesai){
		this.jamSelesai = jamSelesai;
	}

	public String getJamSelesai(){
		return jamSelesai;
	}

	public void setNamaMapel(String namaMapel){
		this.namaMapel = namaMapel;
	}

	public String getNamaMapel(){
		return namaMapel;
	}

	public void setIdKelas(String idKelas){
		this.idKelas = idKelas;
	}

	public String getIdKelas(){
		return idKelas;
	}

	public void setIdMapel(String idMapel){
		this.idMapel = idMapel;
	}

	public String getIdMapel(){
		return idMapel;
	}
}