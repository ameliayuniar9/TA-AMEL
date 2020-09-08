/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.dao.impl;

import java.util.List;
import org.hibernate.Query;
import projek.e.commerce.springhibernate.dao.ProvinsiDao;
import projek.e.commerce.springhibernate.model.ProvinsiModel;

/**
 *
 * @author amelia.yuniar
 */
public class ProvinsiDaoImpl extends HibernateUtil implements ProvinsiDao{

    @Override
    public List<ProvinsiModel> getListDataProvinsi() throws Exception {
        List<ProvinsiModel> listData = null;
        try {
            String sql = "select model from ProvinsiModel model order by nama";
            Query query = createQuery(sql);
            listData = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    @Override
    public ProvinsiModel getProvinsiModelById(String id) {
        Query query = null;
        try {
            String sql = "select model from ProvinsiModel model where id_provinsi=:idCat";
            query = createQuery(sql).setParameter("idCat", id);                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (ProvinsiModel) query.uniqueResult();
    }
}
