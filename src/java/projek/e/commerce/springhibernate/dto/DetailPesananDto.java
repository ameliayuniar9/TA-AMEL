/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.dto;

/**
 *
 * @author amelia.yuniar
 */
public class DetailPesananDto {
    String kode_detail_pesanan,kode_pesanan,kode_detail;
    Integer kuantitas,total;

    public String getKode_detail_pesanan() {
        return kode_detail_pesanan;
    }

    public void setKode_detail_pesanan(String kode_detail_pesanan) {
        this.kode_detail_pesanan = kode_detail_pesanan;
    }

    public String getKode_pesanan() {
        return kode_pesanan;
    }

    public void setKode_pesanan(String kode_pesanan) {
        this.kode_pesanan = kode_pesanan;
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

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    } 
}
