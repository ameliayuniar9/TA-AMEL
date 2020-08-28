/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.dto;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author amelia.yuniar
 */
public class UlasanDto {
    String kode_ulasan,video,keterangan;
    MultipartFile file;

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

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
    
    
}
