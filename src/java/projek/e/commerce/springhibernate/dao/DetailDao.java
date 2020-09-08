/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.dao;

import java.util.List;
import projek.e.commerce.springhibernate.model.DetailModel;
import projek.e.commerce.springhibernate.model.KategoriModel;

/**
 *
 * @author HP
 */
public interface DetailDao {
    public List<DetailModel> getListDataDetail()throws Exception;
    public void deleteDetail(String kode);
    public DetailModel getDetailById(String kode) throws Exception;
    public void updateDetail(DetailModel detailModel);
    public void saveDataDetail(DetailModel detailModel);
    public List<DetailModel> getListDetailUpdate(String kode_detail);
    public List<Object[]> getListProdukByKategori(String kode_kategori);
}
