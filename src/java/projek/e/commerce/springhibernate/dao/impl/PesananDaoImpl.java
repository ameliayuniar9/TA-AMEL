/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.dao.impl;

import java.util.List;
import org.hibernate.Query;
import projek.e.commerce.springhibernate.model.PesananModel;
import projek.e.commerce.springhibernate.dao.PesananDao;

/**
 *
 * @author HP
 */
public class PesananDaoImpl extends HibernateUtil implements PesananDao{

    @Override
    public void saveDataBelanja(PesananModel belanjaModel) throws Exception {
        try {
            getSession().save(belanjaModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<PesananModel> getListDataBelanja() throws Exception {
        List<PesananModel> listData = null;
        try {
            String sql = "select model from PesananModel model";
            Query query = createQuery(sql);
            listData = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    @Override
    public PesananModel getBelanjaById(String id) throws Exception {
        PesananModel belanja = new PesananModel();
        Query query = null;
        try {
            String sql = "select model from PesananModel model where kode_pesanan=:kdpdkparam";
            query = createQuery(sql).setParameter("kdpdkparam", id);                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (PesananModel) query.uniqueResult();
    }

    @Override
    public void deleteBelanja(String id) {
        PesananModel ddm = new PesananModel();
        ddm.setKode_pesanan(id);
        getSession().delete(ddm);
    }

    @Override
    public void updateBelanja(PesananModel belanjaModel) {
        if (belanjaModel.getKode_pesanan()!= null) {
            getSession().merge(belanjaModel);
        } else {
            getSession().saveOrUpdate(belanjaModel);
        }
    }

    @Override
    public List<PesananModel> getListBelanjaUpdate(String kode_pesanan) {
        List<PesananModel> dataList = null;
        String sql = "select model from PesananModel model where kode_pesanan=:kode_pesanan";
        Query query = createQuery(sql).setParameter("kode_pesanan", kode_pesanan);
        dataList = query.list();
        return dataList;
    }
    
}
