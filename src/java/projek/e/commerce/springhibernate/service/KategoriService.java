/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.service;

import java.util.List;
import projek.e.commerce.springhibernate.dto.KategoriDto;
import projek.e.commerce.springhibernate.model.KategoriModel;

/**
 *
 * @author HP
 */
public interface KategoriService {
    public List <KategoriDto> getListKategori()throws Exception;
    public void saveDataKategori(KategoriDto kategoriDto) throws Exception;
    public KategoriModel getKategoriById(String id);
    public void deleteDataKategori(String kode_kategori) throws Exception;
    public KategoriDto getUpdateDataKategori(String kode_kategori) throws Exception;
    public void doUpdateDataKategori(KategoriDto kategoriDto) throws Exception;
}
