/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.dto;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author HP
 */
public class DetailDto {
    String kode_detail, kode_produk,nama_produk,warna,gambar,keterangan_produk;
    Integer stok,harga_jual;
    MultipartFile file;

    public String getKode_detail() {
        return kode_detail;
    }

    public void setKode_detail(String kode_detail) {
        this.kode_detail = kode_detail;
    }

    public String getKode_produk() {
        return kode_produk;
    }

    public void setKode_produk(String kode_produk) {
        this.kode_produk = kode_produk;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public Integer getStok() {
        return stok;
    }

    public void setStok(Integer stok) {
        this.stok = stok;
    }

    public String getNama_produk() {
        return nama_produk;
    }

    public void setNama_produk(String nama_produk) {
        this.nama_produk = nama_produk;
    }

    public Integer getHarga_jual() {
        return harga_jual;
    }

    public void setHarga_jual(Integer harga_jual) {
        this.harga_jual = harga_jual;
    }

    public String getKeterangan_produk() {
        return keterangan_produk;
    }

    public void setKeterangan_produk(String keterangan_produk) {
        this.keterangan_produk = keterangan_produk;
    }  

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
    
}
