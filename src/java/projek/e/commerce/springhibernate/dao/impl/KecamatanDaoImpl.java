/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.dao.impl;

import java.util.List;
import org.hibernate.Query;
import projek.e.commerce.springhibernate.dao.KecamatanDao;
import projek.e.commerce.springhibernate.model.KecamatanModel;

/**
 *
 * @author amelia.yuniar
 */
public class KecamatanDaoImpl extends HibernateUtil implements KecamatanDao{

    @Override
    public List<KecamatanModel> getListDataKecamatan() throws Exception {
        List<KecamatanModel> listData = null;
        try {
            String sql = "select model from KecamatanModel model";
            Query query = createQuery(sql);
            listData = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
        
    }

    @Override
    public List<KecamatanModel> getKecamatanById(String param) throws Exception {
        List<KecamatanModel> dataList = null;
        String sql = "select model from KecamatanModel model where id_kota=:param order by nama";
        Query query = createQuery(sql).setParameter("param", param);          
        dataList = query.list();
        return dataList;
    }

    @Override
    public KecamatanModel getKecamatanModelById(String id) {
        Query query = null;
        try {
            String sql = "select model from KecamatanModel model where id_kecamatan=:idKecamatan";
            query = createQuery(sql).setParameter("idKecamatan", id);                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (KecamatanModel) query.uniqueResult();
    }
    
}
