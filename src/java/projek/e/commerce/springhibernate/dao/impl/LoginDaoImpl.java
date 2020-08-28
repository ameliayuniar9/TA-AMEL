/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.dao.impl;

import java.util.List;
import org.hibernate.Query;
import projek.e.commerce.springhibernate.dao.LoginDao;
import projek.e.commerce.springhibernate.dto.LoginDto;
import projek.e.commerce.springhibernate.model.LoginModel;

/**
 *
 * @author HP
 */
public class LoginDaoImpl extends HibernateUtil implements LoginDao{

    @Override
    public List<LoginModel> getListDataUser() throws Exception {
        List<LoginModel> listData = null;
        try {
            String sql = "select model from LoginModel model";
            Query query = createQuery(sql);
            listData = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }
    
    @Override
    public List<LoginModel> getListDataUserSelect(String id_login) throws Exception {
        List<LoginModel> listData = null;
        try {
            String sql = "select model from LoginModel model where akses='Admin' and id_login=:id";
            Query query = createQuery(sql).setParameter("id", id_login);
            listData = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }
    
    @Override
    public List<LoginModel> getListDataLogin(LoginDto loginDto) throws Exception {
        String sql=null;
        List<LoginModel> listUsr=null;
        try {
            sql="select model from LoginModel model where username=:user and password=:pass";
            Query query = createQuery(sql).setParameter("user",loginDto.getUsername());
            query.setParameter("pass", loginDto.getPassword());
            listUsr = query.list();
        } catch (Exception e) {
        }
        return listUsr;
    }

    @Override
    public void saveLogin(LoginModel loginModel) throws Exception {
        try {
            getSession().save(loginModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteLogin(String id) {
        LoginModel ddm = new LoginModel();
        ddm.setId_pembeli(id);
        getSession().delete(ddm);
    }

    @Override
    public void updateLogin(LoginModel loginModel) {
        if (loginModel.getId_login()!= null) {
            getSession().merge(loginModel);
        } else {
            getSession().saveOrUpdate(loginModel);
        }
    }
    
    @Override
    public LoginModel getLoginById(String id) throws Exception {
        LoginModel login = new LoginModel();
        Query query = null;
        try {
            String sql = "select model from LoginModel model where id_login=:kodekategoriparam";
            query = createQuery(sql).setParameter("kodekategoriparam", id);                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (LoginModel) query.uniqueResult();
    }

    @Override
    public List<LoginModel> getListDataUserAdmin() throws Exception {
        List<LoginModel> listData = null;
        try {
            String sql = "select model from LoginModel model where akses='Admin'";
            Query query = createQuery(sql);
            listData = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }
    
    
}
