/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.dao.impl;

import java.util.List;
import org.hibernate.Query;
import projek.e.commerce.springhibernate.dao.KategoriDao;
import projek.e.commerce.springhibernate.model.KategoriModel;
import projek.e.commerce.springhibernate.model.ProdukModel;

/**
 *
 * @author HP
 */
public class KategoriDaoImpl extends HibernateUtil implements KategoriDao{

    @Override
    public List<KategoriModel> getListDataKategori() throws Exception {
        List<KategoriModel> listData = null;
        try {
            String sql = "select model from KategoriModel model";
            Query query = createQuery(sql);
            listData = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    @Override
    public KategoriModel getKategoriModelById(String id) {
        KategoriModel kategori = new KategoriModel();
        Query query = null;
        try {
            String sql = "select model from KategoriModel model where kode_kategori=:kdktgparam";
            query = createQuery(sql).setParameter("kdktgparam", id);                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (KategoriModel) query.uniqueResult();
    }

    @Override
    public void updateKategori(KategoriModel kategoriModel) {
        if (kategoriModel.getKode_kategori()!= null) {
            getSession().merge(kategoriModel);
        } else {
            getSession().saveOrUpdate(kategoriModel);
        }
    }

    @Override
    public void saveDataKategori(KategoriModel kategoriModel) {
        getSession().save(kategoriModel);
    }

    @Override
    public void deleteKategori(String id) {
        KategoriModel ddm = new KategoriModel();
        ddm.setKode_kategori(id);
        getSession().delete(ddm);
    }

    @Override
    public KategoriModel getKategoriById(String id) throws Exception {
        KategoriModel kategori = new KategoriModel();
        Query query = null;
        try {
            String sql = "select model from KategoriModel model where kode_kategori=:kodekategoriparam";
            query = createQuery(sql).setParameter("kodekategoriparam", id);                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (KategoriModel) query.uniqueResult();
    }

    @Override
    public List<KategoriModel> getListKategoriUpdate(String kode_kategori) {
        List<KategoriModel> dataList = null;
        String sql = "select model from KategoriModel model where kode_kategori=:id";
        Query query = createQuery(sql).setParameter("id", kode_kategori);
        dataList = query.list();
        return dataList;
    }
    
}
    
