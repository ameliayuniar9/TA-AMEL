/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import projek.e.commerce.springhibernate.dao.CartDao;
import projek.e.commerce.springhibernate.dao.DetailDao;
import projek.e.commerce.springhibernate.dao.ProdukDao;
import projek.e.commerce.springhibernate.dto.CartDto;
import projek.e.commerce.springhibernate.model.CartModel;
import projek.e.commerce.springhibernate.model.DetailModel;
import projek.e.commerce.springhibernate.model.ProdukModel;
import projek.e.commerce.springhibernate.service.CartService;
import projek.e.commerce.springhibernate.service.DetailService;

/**
 *
 * @author HP
 */
public class CartServiceImpl implements CartService{
    @Autowired
    CartDao cartDao;
    
    @Autowired
    ProdukDao produkDao;
        
    @Autowired
    DetailDao detailDao;
    
    @Autowired
    DetailService detailService;
    
    @Override
    public void saveDataCart(CartDto cartDto,String kode_detail,String kode_produk,String id_pembeli,Integer jmlProd) throws Exception {
        CartModel cartModel = new CartModel();
        List<CartModel> listDataCart=cartDao.getListDataCart();
        ProdukModel prod=produkDao.getProdukById(kode_produk);
        int id=0;
        for(CartModel model : listDataCart){
            String tam=model.getKode_cart();
            String tamp=tam.substring(5);
            if(id<Integer.parseInt(tamp)){
                id=Integer.parseInt(tamp);
            }
        }
        id+=1;
        String kodeCart="CART-"+id+"";
        try {
            int qty=0;
            CartModel cart=cartDao.findByDetailAndPembeli(kode_detail, id_pembeli);
            if(cart!=null){
                qty=cart.getKuantitas()+jmlProd;
                cartModel.setKode_cart(cart.getKode_cart());
            }
            else{
                qty=jmlProd;
                cartModel.setKode_cart(kodeCart);
            }            
                cartModel.setKode_detail(kode_detail);
                cartModel.setId_pembeli(id_pembeli);
                cartModel.setKuantitas(qty);
                cartModel.setTotal(qty*prod.getHarga_jual());
                cartModel.setStatus("IN_ACTIVE");
               cartDao.updateStatusCart(cartModel);
                
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<CartDto> getListCart() throws Exception {
        List <CartDto> listDataDto = new ArrayList<>();
        List <CartModel> listData = cartDao.getListDataCart();
        CartDto cartDto = null;
        try {
            if(listData != null){
                for(CartModel model : listData){
                    cartDto = new CartDto();
                    if(model.getKode_cart()!= null){
                        cartDto.setKode_cart(model.getKode_cart());
                    }
                    if(model.getKode_detail()!=null){
                        cartDto.setKode_detail(model.getKode_detail());
                    }
                    if(model.getId_pembeli()!= null){
                        cartDto.setId_pembeli(model.getId_pembeli());
                    }
                    if(model.getKuantitas()!= null){
                        cartDto.setKuantitas(model.getKuantitas());
                    }
                    if(model.getTotal()!= null){
                        cartDto.setTotal(model.getTotal());
                    }
                    if(model.getStatus()!= null){
                        cartDto.setStatus(model.getStatus());
                    }
                    
                    listDataDto.add(cartDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listDataDto;
    }

    @Override
    public List<CartDto> getListCartByIdPembeli(String id_pembeli) {
        List <CartDto> listDataDto = new ArrayList<>();
        List <CartModel> listData = cartDao.getListCartByIdPembeli(id_pembeli);
        System.err.println(cartDao.getQuery(id_pembeli));
        CartDto cartDto = null;
        try {
            if(listData != null){
                for(CartModel model : listData){
                    cartDto = new CartDto();
                    if(model.getKode_cart()!= null){
                        cartDto.setKode_cart(model.getKode_cart());
                    }
                    if(model.getKode_detail()!=null){
                        cartDto.setKode_detail(model.getKode_detail());
                        DetailModel listDataDetail = detailDao.getDetailById(model.getKode_detail());
                        List<ProdukModel> listDataProd = produkDao.getListProdukUpdate(listDataDetail.getKode_produk());
                        for(ProdukModel prod : listDataProd){
                            cartDto.setKode_produk(listDataDetail.getKode_produk());
                            cartDto.setNama_produk(prod.getNama_produk());
                            cartDto.setGambar(listDataDetail.getGambar());
                            cartDto.setHarga_jual(prod.getHarga_jual());
                        }
                    }
                    if(model.getId_pembeli()!= null){
                        cartDto.setId_pembeli(model.getId_pembeli());
                    }
                    if(model.getKuantitas()!= null){
                        cartDto.setKuantitas(model.getKuantitas());
                    }
                    if(model.getTotal()!= null){
                        cartDto.setTotal(model.getTotal());
                    }
                    if(model.getStatus()!= null){
                        cartDto.setStatus(model.getStatus());
                    }
                    
                    listDataDto.add(cartDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listDataDto;
    }
    
     public CartModel findByDetailAndPembeli(String kode_detail,String id_pembeli){
         CartModel cartModel = null;
        try {
            cartModel = cartDao.findByDetailAndPembeli(kode_detail, id_pembeli);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cartModel;
     }

    @Override
    public void doUpdateStatusCart(CartDto cartDto) throws Exception {
        CartModel ddm = new CartModel();
        try {
            ddm.setStatus("ACTIVE");
        } catch (Exception e) {
            e.printStackTrace();
        }
        cartDao.updateStatusCart(ddm);
    }

    @Override
    public void deleteDataCart(String kode_cart) throws Exception {
        try {
            cartDao.deleteCart(kode_cart);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
