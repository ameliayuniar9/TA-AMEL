/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.model;

/**
 *
 * @author HP
 */
public class PenerimaModel {
    String id_penerima,id_pembeli,nama_penerima,no_telp,provinsi,kabupaten,kecamatan,alamat_lengkap,status;

    public String getId_penerima() {
        return id_penerima;
    }

    public void setId_penerima(String id_penerima) {
        this.id_penerima = id_penerima;
    }

    public String getId_pembeli() {
        return id_pembeli;
    }

    public void setId_pembeli(String id_pembeli) {
        this.id_pembeli = id_pembeli;
    }

    public String getNama_penerima() {
        return nama_penerima;
    }

    public void setNama_penerima(String nama_penerima) {
        this.nama_penerima = nama_penerima;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getKabupaten() {
        return kabupaten;
    }

    public void setKabupaten(String kabupaten) {
        this.kabupaten = kabupaten;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getAlamat_lengkap() {
        return alamat_lengkap;
    }

    public void setAlamat_lengkap(String alamat_lengkap) {
        this.alamat_lengkap = alamat_lengkap;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
