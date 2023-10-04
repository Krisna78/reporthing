package com.example.belajar_intent;

public class cardmodel {
    private String namanama,fullnama,gender,agama,tgl_lahir,alamat,email,password;

    private int img;

    public cardmodel(String namanama,String fullnama,String gender, String agama, String tgl_lahir, String alamat, String email,String password, int img) {
        this.namanama = namanama;
        this.fullnama = fullnama;
        this.gender = gender;
        this.agama = agama;
        this.tgl_lahir = tgl_lahir;
        this.alamat = alamat;
        this.email = email;
        this.password = password;
        this.img = img;
    }

    public String getNamanama() {
        return namanama;
    }
    public String getFullnama() {
        return fullnama;
    }
    public String getGender() {
        return gender;
    }
    public String getAgama() {
        return agama;
    }
    public String getTgl_lahir() {
        return tgl_lahir;
    }
    public String getAlamat() {
        return alamat;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }

    public void setNamanama(String namanama) {
        this.namanama = namanama;
    }
    public void setFullnama(String fullnama) {
        this.fullnama = fullnama;
    }public void setGender(String gender) {
        this.gender = gender;
    }public void setAgama(String agama) {
        this.agama = agama;
    }public void setTgl_lahir(String tgl_lahir) {
        this.tgl_lahir = tgl_lahir;
    }public void setAlamat(String alamat) {
        this.alamat = alamat;
    }public void setEmail(String email) {
        this.email = email;
    }public void setPassword(String password) {
        this.password = password;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
