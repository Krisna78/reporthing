package com.example.reporthing.Students.Models.jadwals;

import com.google.gson.annotations.SerializedName;

public class JadwalData {

	@SerializedName("hari")
	private String hari;

	@SerializedName("nama_kelas")
	private String namaKelas;

	@SerializedName("id_jadwal")
	private String idJadwal;

	public void setHari(String hari){
		this.hari = hari;
	}

	public String getHari(){
		return hari;
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
}