/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.dao.impl;

import java.util.List;
import org.hibernate.Query;
import projek.e.commerce.springhibernate.dao.AkunDao;
import projek.e.commerce.springhibernate.model.AkunModel;

/**
 *
 * @author amelia.yuniar
 */
public class AkunDaoImpl extends HibernateUtil implements AkunDao{
    
    @Override
    public void saveDataAkun(AkunModel akunModel) throws Exception {
        try {
            getSession().save(akunModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<AkunModel> getListDataAkun() throws Exception {
        List<AkunModel> listData = null;
        try {
            String sql = "select model from AkunModel model";
            Query query = createQuery(sql);
            listData = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    @Override
    public AkunModel getAkunById(String id) throws Exception {
        AkunModel ak = new AkunModel();
        Query query = null;
        try {
            String sql = "select model from AkunModel model where kode_akun=:kdkakunparam";
            query = createQuery(sql).setParameter("kdakunparam", id);                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (AkunModel) query.uniqueResult();
    }

    @Override
    public void deleteAkun(String id) {
        AkunModel ddm = new AkunModel();
        ddm.setKode_akun(id);
        getSession().delete(ddm);
    }

    @Override
    public void updateAkun(AkunModel akunModel) {
        getSession().saveOrUpdate(akunModel);
    }

    @Override
    public List<AkunModel> getListAkunUpdate(String kode_akun) {
         List<AkunModel> dataList = null;
        String sql = "select model from AkunModel model where kode_akun=:id";
        Query query = createQuery(sql).setParameter("id", kode_akun);
        dataList = query.list();
        return dataList;
    }
    
}
