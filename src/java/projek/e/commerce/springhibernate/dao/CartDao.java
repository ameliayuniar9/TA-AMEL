/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.dao;

import java.util.List;
import projek.e.commerce.springhibernate.model.CartModel;

/**
 *
 * @author HP
 */
public interface CartDao {
    public void saveDataCart(CartModel cartModel);
    public List<CartModel> getListDataCart()throws Exception;
    public List<CartModel> getListCartByIdPembeli(String id_pembeli);
    public CartModel findByDetailAndPembeli(String kode_detail,String id_pembeli) throws Exception;
    public void updateStatusCart(CartModel cartModel);
    public String getQuery(String query);
    public void deleteCart(String kode_cart);
    public CartModel getCartByKodeCart(String kode_cart) throws Exception;
}