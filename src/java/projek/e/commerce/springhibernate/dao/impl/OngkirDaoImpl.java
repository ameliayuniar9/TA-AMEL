/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.dao.impl;

import java.util.List;
import org.hibernate.Query;
import projek.e.commerce.springhibernate.dao.OngkirDao;
import projek.e.commerce.springhibernate.model.OngkirModel;

/**
 *
 * @author HP
 */
public class OngkirDaoImpl extends HibernateUtil implements OngkirDao{

    @Override
    public List<OngkirModel> getListDataOngkir() throws Exception {
        List<OngkirModel> listData = null;
        try {
            String sql = "select model from OngkirModel model";
            Query query = createQuery(sql);
            listData = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    @Override
    public void saveDataOngkir(OngkirModel ongkirModel) throws Exception {
        try {
            getSession().save(ongkirModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public OngkirModel getOngkirById(String id) throws Exception {
        OngkirModel ongkir = new OngkirModel();
        Query query = null;
        try {
            String sql = "select model from OngkirModel model where kode_ongkir=:idkotaparam";
            query = createQuery(sql).setParameter("idkotaparam", id);                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (OngkirModel) query.uniqueResult();
    }

    @Override
    public void deleteOngkir(String id) {
        OngkirModel ddm = new OngkirModel();
        ddm.setKode_ongkir(id);
        getSession().delete(ddm);
    }

    @Override
    public void updateOngkir(OngkirModel ongkirModel) {
        getSession().saveOrUpdate(ongkirModel);
    }

    @Override
    public List<OngkirModel> getListOngkirUpdate(String kode_ongkir) {
        List<OngkirModel> dataList = null;
        String sql = "select model from OngkirModel model where kode_ongkir=:kode_ongkir";
        Query query = createQuery(sql).setParameter("kode_ongkir", kode_ongkir);
        dataList = query.list();
        return dataList;
    }   
}
