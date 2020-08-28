/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.service;

import java.util.List;
import projek.e.commerce.springhibernate.dto.UlasanDto;
import projek.e.commerce.springhibernate.model.UlasanModel;

/**
 *
 * @author amelia.yuniar
 */
public interface UlasanService {
    public List <UlasanDto> getListReview()throws Exception;
    public void saveDataReview(UlasanDto ulasanDto) throws Exception;
    public UlasanModel getReviewByKode(String kode_ulasan);
    public void deleteDataReview(String kode_ulasan) throws Exception;
    public UlasanDto getUpdateDataReview(String kode_ulasn) throws Exception;
    public void doUpdateDataReview(UlasanDto ulasanDto) throws Exception;   
}
