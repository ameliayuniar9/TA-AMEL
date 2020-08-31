/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.dao.impl;

import java.util.List;
import org.hibernate.Query;
import projek.e.commerce.springhibernate.dao.KotaDao;
import projek.e.commerce.springhibernate.model.KotaModel;

/**
 *
 * @author amelia.yuniar
 */
public class KotaDaoImpl extends HibernateUtil implements KotaDao{

    @Override
    public List<KotaModel> getListDataKota() throws Exception {
        List<KotaModel> listData = null;
        try {
            String sql = "select model from KotaModel model";
            Query query = createQuery(sql);
            listData = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    @Override
    public List<KotaModel> getKotaById(String param) throws Exception {
        List<KotaModel> dataList = null;
        String sql = "select model from KotaModel model where id_provinsi=:param order by nama";
        Query query = createQuery(sql).setParameter("param", param);          
        dataList = query.list();
        return dataList;
    }

    @Override
    public KotaModel getKotaModelById(String id) {
        Query query = null;
        try {
            String sql = "select model from KotaModel model where id_kota=:idKota";
            query = createQuery(sql).setParameter("idKota", id);                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (KotaModel) query.uniqueResult();
    }
    
}
