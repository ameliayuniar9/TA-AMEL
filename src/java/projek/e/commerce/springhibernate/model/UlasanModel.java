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
public class UlasanModel {
    String kode_ulasan,video,keterangan;

    public String getKode_ulasan() {
        return kode_ulasan;
    }

    public void setKode_ulasan(String kode_ulasan) {
        this.kode_ulasan = kode_ulasan;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
    
}
