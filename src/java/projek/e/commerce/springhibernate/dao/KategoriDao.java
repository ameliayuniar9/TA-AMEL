/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.dao;

import java.util.List;
import projek.e.commerce.springhibernate.model.KategoriModel;

/**
 *
 * @author HP
 */
public interface KategoriDao {
    public List<KategoriModel> getListDataKategori()throws Exception;
    public KategoriModel getKategoriModelById(String id);
    public void deleteKategori(String id);
    public KategoriModel getKategoriById(String id) throws Exception;
    public void updateKategori(KategoriModel kategoriModel);
    public void saveDataKategori(KategoriModel kategoriModel);
    public List<KategoriModel> getListKategoriUpdate(String kode_kategori);
    
}
