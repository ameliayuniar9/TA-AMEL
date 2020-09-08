/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.dao.impl;

import java.util.List;
import org.hibernate.Query;
import projek.e.commerce.springhibernate.dao.DetailDao;
import projek.e.commerce.springhibernate.model.DetailModel;

/**
 *
 * @author HP
 */
public class DetailDaoImpl extends HibernateUtil implements DetailDao{

    @Override
    public List<DetailModel> getListDataDetail() throws Exception {
        List<DetailModel> listData = null;
        try {
            String sql = "select model from DetailModel model";
            Query query = createQuery(sql);
            listData = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    @Override
    public void deleteDetail(String kode) {
        DetailModel ddm = new DetailModel();
        ddm.setKode_detail(kode);
        getSession().delete(ddm);
    }

    @Override
    public DetailModel getDetailById(String kode) throws Exception {
        DetailModel detail = new DetailModel();
        Query query = null;
        try {
            String sql = "select model from DetailModel model where kode_detail=:id";
            query = createQuery(sql).setParameter("id", kode);                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (DetailModel) query.uniqueResult();
    }

    @Override
    public void updateDetail(DetailModel detailModel) {
        getSession().saveOrUpdate(detailModel);
    }

    @Override
    public void saveDataDetail(DetailModel detailModel) {
        try {
            getSession().save(detailModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<DetailModel> getListDetailUpdate(String kode_detail) {
        List<DetailModel> dataList = null;
        String sql = "select model from DetailModel model where kode_detail=:id";
        Query query = createQuery(sql).setParameter("id", kode_detail);
        dataList = query.list();
        return dataList;
    }

    @Override
    public List<Object[]> getListProdukByKategori(String kode_kategori) {
        List<Object[]> listData = null;
        String sql = "SELECT a.kode_detail, a.kode_produk,a.warna,a.gambar,a.stok,b.kode_kategori,b.nama_produk,\n" +
                     "b.harga_jual,b.keterangan_produk FROM tb_detail a JOIN tb_produk b ON a.kode_produk=b.kode_produk JOIN\n" +
                     "tb_kategori c ON b.kode_kategori=c.kode_kategori WHERE  c.kode_kategori=:id";
        Query query = createNativeQuery(sql).setParameter("id", kode_kategori);
        listData = query.list();
        return listData;
    }
    
}
