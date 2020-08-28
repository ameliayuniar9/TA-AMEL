/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.service;

import java.util.List;
import projek.e.commerce.springhibernate.dto.ProdukDto;

/**
 *
 * @author HP
 */
public interface ProdukService {
    public List <ProdukDto> getListProduk() throws Exception;
    public List <ProdukDto> getProdukById(String id);
    public void doUpdateDataProduk(ProdukDto produkDto) throws Exception;
    public void saveDataProduk(ProdukDto produkDto) throws Exception;
    public void deleteDataProduk(String kode_produk) throws Exception;
    public ProdukDto getUpdateDataProduk(String kode_produk) throws Exception;
    public List <ProdukDto> getProdukByKategori(String kode_kategori);
    
}
