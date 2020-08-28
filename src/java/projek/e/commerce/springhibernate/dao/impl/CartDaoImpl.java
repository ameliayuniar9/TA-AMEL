/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.dao.impl;

import java.util.List;
import org.hibernate.Query;
import projek.e.commerce.springhibernate.dao.CartDao;
import projek.e.commerce.springhibernate.model.CartModel;

/**
 *
 * @author HP
 */
public class CartDaoImpl extends HibernateUtil implements CartDao{

    @Override
    public void saveDataCart(CartModel cartModel) {
         try {
            getSession().save(cartModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<CartModel> getListDataCart() throws Exception {
        List<CartModel> listData = null;
        try {
            String sql = "select model from CartModel model";
            Query query = createQuery(sql);
            listData = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }
    
    @Override
    public String getQuery(String query){
        return "select model from CartModel model where id_pembeli="+query;
    }
    @Override
    public List<CartModel> getListCartByIdPembeli(String id_pembeli) {
        List<CartModel> dataList = null;
        String sql = "select model from CartModel model where id_pembeli=:id";
        Query query = createQuery(sql).setParameter("id", id_pembeli);
        dataList = query.list();
        return dataList;
    }
    
    @Override
    public CartModel findByDetailAndPembeli(String kode_detail,String id_pembeli) throws Exception{
        CartModel detail = new CartModel();
        Query query = null;
        try {
            String sql = "select model from CartModel model where kode_detail=:kode and id_pembeli=:id";
            query = createQuery(sql).setParameter("kode",kode_detail);     
            query.setParameter("id",id_pembeli);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (CartModel) query.uniqueResult();
    }

    @Override
    public void updateStatusCart(CartModel cartModel) {
        if (cartModel.getKode_cart()!= null) {
            getSession().merge(cartModel);
        } else {
            getSession().saveOrUpdate(cartModel);
        }
    }

    @Override
    public void deleteCart(String kode_cart) {
        CartModel ddm = new CartModel();
        ddm.setKode_cart(kode_cart);
        getSession().delete(ddm);
    }

    @Override
    public CartModel getCartByKodeCart(String kode_cart) throws Exception {
        CartModel detail = new CartModel();
        Query query = null;
        try {
            String sql = "select model from CartModel model where kode_cart=:kode";
            query = createQuery(sql).setParameter("kode",kode_cart);     
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (CartModel) query.uniqueResult();
    }
    
    
}
