/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.dao.impl;

import java.util.List;
import org.hibernate.Query;
import projek.e.commerce.springhibernate.dao.DetailPesananDao;
import projek.e.commerce.springhibernate.model.DetailPesananModel;

/**
 *
 * @author amelia.yuniar
 */
public class DetailPesananDaoImpl extends HibernateUtil implements DetailPesananDao{
    
    @Override
    public List<DetailPesananModel> getListDataDetailPesanan() throws Exception {
        List<DetailPesananModel> listData = null;
        try {
            String sql = "select model from DetailPesananModel model";
            Query query = createQuery(sql);
            listData = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    @Override
    public void saveDataDetailPesanan(DetailPesananModel detailPesananModel) throws Exception {
        try {
            getSession().save(detailPesananModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public DetailPesananModel getDetailPesananById(String id) throws Exception {
        DetailPesananModel ongkir = new DetailPesananModel();
        Query query = null;
        try {
            String sql = "select model from DetailPesananModel model where kode_detail_pesanan=:idkotaparam";
            query = createQuery(sql).setParameter("idkotaparam", id);                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (DetailPesananModel) query.uniqueResult();
    }

    @Override
    public void deleteDetailPesanan(String id) {
        DetailPesananModel ddm = new DetailPesananModel();
        ddm.setKode_detail_pesanan(id);
        getSession().delete(ddm);
    }

    @Override
    public void updateDetailPesanan(DetailPesananModel detailPesananModel) {
        getSession().saveOrUpdate(detailPesananModel);
    }

    @Override
    public List<DetailPesananModel> getListDetailPesananUpdate(String kode_detail_pesanan) {
        List<DetailPesananModel> dataList = null;
        String sql = "select model from DetailPesananModel model where kode_detail_pesanan=:kode_psn";
        Query query = createQuery(sql).setParameter("kode_psn", kode_detail_pesanan);
        dataList = query.list();
        return dataList;
    }
    
}
