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
public class PesananModel {
   String kode_pesanan,id_pembeli,status,bukti_pembayaran,tanggal_pesan,id_penerima,tanggal_pembayaran,tgl_max_bayar;
   Integer total_pesanan;

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

    public String getTgl_max_bayar() {
        return tgl_max_bayar;
    }

    public void setTgl_max_bayar(String tgl_max_bayar) {
        this.tgl_max_bayar = tgl_max_bayar;
    }
}
