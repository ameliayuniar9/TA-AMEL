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
public class PesananDto {
   String kode_pesanan,id_pembeli,status,bukti_pembayaran,tanggal_pesan,id_penerima,tanggal_pembayaran,nama,nama_penerima;
<<<<<<< HEAD
   Integer total_pesanan;
   String kodeChart,kode_detail,jumlah_belanja,harga;
=======
   String nama_produk,warna,kode_detail;
   Integer total_pesanan,kuantitas;
   String[] kodeChart;
>>>>>>> menuAdmin
    MultipartFile file;
    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }
    
    public String getJumlah_belanja() {
        return jumlah_belanja;
    }

    public void setJumlah_belanja(String jumlah_belanja) {
        this.jumlah_belanja = jumlah_belanja;
    }
    public String getKode_detail() {
        return kode_detail;
    }

    public void setKode_detail(String kode_detail) {
        this.kode_detail = kode_detail;
    }
    public String getKodeChart() {
        return kodeChart;
    }

    public void setKodeChart(String kodeChart) {
        this.kodeChart = kodeChart;
    }

    public String getKode_pesanan() {
        return kode_pesanan;
    }

    public void setKode_pesanan(String kode_pesanan) {
        this.kode_pesanan = kode_pesanan;
    }

    public String getId_pembeli() {
        return id_pembeli;
    }

    public void setId_pembeli(String id_pembeli) {
        this.id_pembeli = id_pembeli;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBukti_pembayaran() {
        return bukti_pembayaran;
    }

    public void setBukti_pembayaran(String bukti_pembayaran) {
        this.bukti_pembayaran = bukti_pembayaran;
    }

    public String getTanggal_pesan() {
        return tanggal_pesan;
    }

    public void setTanggal_pesan(String tanggal_pesan) {
        this.tanggal_pesan = tanggal_pesan;
    }

    public String getId_penerima() {
        return id_penerima;
    }

    public void setId_penerima(String id_penerima) {
        this.id_penerima = id_penerima;
    }

    public String getTanggal_pembayaran() {
        return tanggal_pembayaran;
    }

    public void setTanggal_pembayaran(String tanggal_pembayaran) {
        this.tanggal_pembayaran = tanggal_pembayaran;
    }

    public Integer getTotal_pesanan() {
        return total_pesanan;
    }

    public void setTotal_pesanan(Integer total_pesanan) {
        this.total_pesanan = total_pesanan;
    }

   
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama_penerima() {
        return nama_penerima;
    }

    public void setNama_penerima(String nama_penerima) {
        this.nama_penerima = nama_penerima;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getNama_produk() {
        return nama_produk;
    }

    public void setNama_produk(String nama_produk) {
        this.nama_produk = nama_produk;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public String getKode_detail() {
        return kode_detail;
    }

    public void setKode_detail(String kode_detail) {
        this.kode_detail = kode_detail;
    }

    public Integer getKuantitas() {
        return kuantitas;
    }

    public void setKuantitas(Integer kuantitas) {
        this.kuantitas = kuantitas;
    }
    
}
