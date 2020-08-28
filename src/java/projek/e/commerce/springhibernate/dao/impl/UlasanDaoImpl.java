/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.dao.impl;

import java.util.List;
import org.hibernate.Query;
import projek.e.commerce.springhibernate.dao.UlasanDao;
import projek.e.commerce.springhibernate.model.UlasanModel;

/**
 *
 * @author amelia.yuniar
 */
public class UlasanDaoImpl extends HibernateUtil implements UlasanDao{
    @Override
    public List<UlasanModel> getListDataReview() throws Exception {
        List<UlasanModel> listData = null;
        try {
            String sql = "select model from UlasanModel model";
            Query query = createQuery(sql);
            listData = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    @Override
    public UlasanModel getReviewModelById(String kode_ulasan) {
        UlasanModel review = new UlasanModel();
        Query query = null;
        try {
            String sql = "select model from UlasanModel model where kode_ulasan=:kode";
            query = createQuery(sql).setParameter("kode", kode_ulasan);                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (UlasanModel) query.uniqueResult();
    }

    @Override
    public void deleteReview(String kode) {
       UlasanModel ddm = new UlasanModel();
       ddm.setKode_ulasan(kode);
       getSession().delete(ddm);
    }

    @Override
    public void updateReview(UlasanModel reviewModel) {
        if (reviewModel.getKode_ulasan()!= null) {
            getSession().merge(reviewModel);
        } else {
            getSession().saveOrUpdate(reviewModel);
        }
    }

    @Override
    public void saveDataReview(UlasanModel reviewModel) {
        getSession().save(reviewModel);
    }

    @Override
    public List<UlasanModel> getListReviewUpdate(String kode_ulasan) {
        List<UlasanModel> dataList = null;
        String sql = "select model from UlasanModel model where kode_ulasan=:id";
        Query query = createQuery(sql).setParameter("id", kode_ulasan);
        dataList = query.list();
        return dataList;
    }
}
