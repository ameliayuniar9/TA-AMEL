/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.dao.impl;

import java.util.List;
import org.hibernate.Query;
import projek.e.commerce.springhibernate.dao.ProdukDao;
import projek.e.commerce.springhibernate.model.ProdukModel;

/**
 *
 * @author HP
 */
public class ProdukDaoImpl extends HibernateUtil implements ProdukDao{
    

    @Override
    public void saveDataProduk(ProdukModel produkModel) throws Exception {
        try {
            getSession().save(produkModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ProdukModel> getListDataProduk() throws Exception {
        List<ProdukModel> listData = null;
        try {
            String sql = "select model from ProdukModel model";
            Query query = createQuery(sql);
            listData = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    @Override
    public ProdukModel getProdukById(String id) throws Exception {
        ProdukModel produk = new ProdukModel();
        Query query = null;
        try {
            String sql = "select model from ProdukModel model where kode_produk=:kdktgparam";
            query = createQuery(sql).setParameter("kdktgparam", id);                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (ProdukModel) query.uniqueResult();
    }

    @Override
    public void deleteProduk(String id) {
        ProdukModel ddm = new ProdukModel();
        ddm.setKode_produk(id);
        getSession().delete(ddm);
    }

    @Override
    public void updateProduk(ProdukModel produkModel) {
        getSession().saveOrUpdate(produkModel);
    }

    @Override
    public List<ProdukModel> getListProdukUpdate(String kode_produk) {
        List<ProdukModel> dataList = null;
        String sql = "select model from ProdukModel model where kode_produk=:kode_prod";
        Query query = createQuery(sql).setParameter("kode_prod", kode_produk);
        dataList = query.list();
        return dataList;
    }

    @Override
    public List<ProdukModel> getListProdukByKategori(String kode_kategori) {
        List<ProdukModel> dataList = null;
        String sql = "select model from ProdukModel model where kode_kategori=:id";
        Query query = createQuery(sql).setParameter("id", kode_kategori);
        dataList = query.list();
        return dataList;
    }
    
}
