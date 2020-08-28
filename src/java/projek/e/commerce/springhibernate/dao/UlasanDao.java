/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.dao;

import java.util.List;
import projek.e.commerce.springhibernate.model.UlasanModel;

/**
 *
 * @author amelia.yuniar
 */
public interface UlasanDao {
    public List<UlasanModel> getListDataReview()throws Exception;
    public UlasanModel getReviewModelById(String kode_ulasan);
    public void deleteReview(String kode);
    public void updateReview(UlasanModel reviewModel);
    public void saveDataReview(UlasanModel reviewModel);
    public List<UlasanModel> getListReviewUpdate(String kode_ulasan);
}
