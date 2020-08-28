/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.dto;

/**
 *
 * @author HP
 */
public class OngkirDto {
    String kode_ongkir,nama_kota;
    Integer harga;

    public String getKode_ongkir() {
        return kode_ongkir;
    }

    public void setKode_ongkir(String kode_ongkir) {
        this.kode_ongkir = kode_ongkir;
    }

    public String getNama_kota() {
        return nama_kota;
    }

    public void setNama_kota(String nama_kota) {
        this.nama_kota = nama_kota;
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }
}
