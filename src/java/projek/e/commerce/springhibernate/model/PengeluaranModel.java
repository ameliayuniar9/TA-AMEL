/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.model;

/**
 *
 * @author amelia.yuniar
 */
public class PengeluaranModel {
    String kode_pengeluaran, tanggal, kode_akun, deskripsi, upload_file, status;
    Integer jumlah;

    public String getKode_pengeluaran() {
        return kode_pengeluaran;
    }

    public void setKode_pengeluaran(String kode_pengeluaran) {
        this.kode_pengeluaran = kode_pengeluaran;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getKode_akun() {
        return kode_akun;
    }

    public void setKode_akun(String kode_akun) {
        this.kode_akun = kode_akun;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getUpload_file() {
        return upload_file;
    }

    public void setUpload_file(String upload_file) {
        this.upload_file = upload_file;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }


    
}
