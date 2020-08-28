/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.dao;

import java.util.List;
import projek.e.commerce.springhibernate.model.ProdukModel;

/**
 *
 * @author HP
 */
public interface ProdukDao {
    public void saveDataProduk(ProdukModel produkModel)throws Exception;
    public List<ProdukModel> getListDataProduk()throws Exception;
    public ProdukModel getProdukById(String id) throws Exception;
    public void deleteProduk(String id);
    public void updateProduk(ProdukModel produkModel);
    public List<ProdukModel> getListProdukUpdate(String kode_produk);
    public List<ProdukModel> getListProdukByKategori(String kode_kategori);
}
