/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.service;

import java.util.List;
import projek.e.commerce.springhibernate.dto.CartDto;
import projek.e.commerce.springhibernate.model.CartModel;

/**
 *
 * @author HP
 */
public interface CartService {
    public void saveDataCart (CartDto cartDto,String kode_detail,String kode_produk,String id_pembeli,Integer jmlProd) throws Exception;
    public List<CartDto> getListCart() throws Exception;
    public List<CartDto> getListCartByIdPembeli(String id_pembeli);
    public CartModel findByDetailAndPembeli(String kode_detail,String id_pembeli);
    public void doUpdateStatusCart(CartDto cartDto) throws Exception;
    public void deleteDataCart(String kode_cart) throws Exception;
}
