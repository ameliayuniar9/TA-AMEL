/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.dto;

import java.util.List;

/**
 *
 * @author amelia.yuniar
 */
public class ListKodeDto {
    List<String> kodeCart;

    public List<String> getKodeCart() {
        return kodeCart;
    }

    public void setKodeCart(List<String> kodeCart) {
        this.kodeCart = kodeCart;
    }
    
}
