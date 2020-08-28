/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.dao.impl;

import java.util.List;
import org.hibernate.Query;
import projek.e.commerce.springhibernate.dao.PembeliDao;
import projek.e.commerce.springhibernate.dto.PembeliDto;
import projek.e.commerce.springhibernate.model.PembeliModel;

/**
 *
 * @author HP
 */
public class PembeliDaoImpl extends HibernateUtil implements PembeliDao{

    @Override
    public void saveDataPembeli(PembeliModel pembeliModel) throws Exception {
        try {
            getSession().save(pembeliModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<PembeliModel> getListDataPembeli() throws Exception {
        List<PembeliModel> listData = null;
        try {
            String sql = "select model from PembeliModel model";
            Query query = createQuery(sql);
            listData = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    @Override
    public PembeliModel getPembeliById(String id) throws Exception {
        PembeliModel pembeli = new PembeliModel();
        Query query = null;
        try {
            String sql = "select model from PembeliModel model where id_pembeli=:idparam";
            query = createQuery(sql).setParameter("idparam", id);                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (PembeliModel) query.uniqueResult();
    }

    @Override
    public void deletePembeli(String id) {
        PembeliModel ddm = new PembeliModel();
        ddm.setId_pembeli(id);
        getSession().delete(ddm);
    }

    @Override
    public void updatePembeli(PembeliModel pembeliModel) {
        getSession().saveOrUpdate(pembeliModel);
    }

    @Override
    public List<PembeliModel> getListPembeliUpdate(String id_pembeli) {
        List<PembeliModel> dataList = null;
        String sql = "select model from PembeliModel model where id_pembeli=:id";
        Query query = createQuery(sql).setParameter("id",id_pembeli);
        dataList = query.list();
        return dataList;
    }
    
    @Override
    public List<PembeliModel> getListDataPembeliSelect(String id_pembeli) throws Exception {
        List<PembeliModel> listData = null;
        try {
            String sql = "select model from PembeliModel model where id_pembeli=:id";
            Query query = createQuery(sql).setParameter("id", id_pembeli);
            listData = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }
    
    @Override
    public List<Object[]> getId(String user, String pass) throws Exception {
        List<Object[]> obj=null;
        String sql="select * from tb_pembeli where password='"+pass+"' and username='"+user+"'";
        Query query= createNativeQuery(sql);
        obj= query.list();
        return obj;
    }
    
    @Override
    public List<PembeliModel> getListLoginPembeli(PembeliDto pembeliDto) throws Exception {
        String sql=null;
        List<PembeliModel> listUsr=null;
        try {
            sql="select model from PembeliModel model where username=:user and password=:pass";
            Query query = createQuery(sql).setParameter("user",pembeliDto.getUsername());
            query.setParameter("pass", pembeliDto.getPassword());
            listUsr = query.list();
        } catch (Exception e) {
        }
        return listUsr;
    }
    
}
