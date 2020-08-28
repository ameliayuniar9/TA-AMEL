/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.service;

import java.util.List;
import projek.e.commerce.springhibernate.dto.DetailPesananDto;
import projek.e.commerce.springhibernate.model.DetailPesananModel;

/**
 *
 * @author amelia.yuniar
 */
public interface DetailPesananService {
    public void saveDataDetailPesanan (DetailPesananDto detailPesananDto) throws Exception;
    public List<DetailPesananDto> getListDetailPesanan() throws Exception;
    public DetailPesananModel getDetailPesananById(String id);
    public void deleteDataDetailPesanan(String kode_detail_pesanan) throws Exception;
    public DetailPesananDto getUpdateDataDetailPesanan(String kode_detail_pesanan) throws Exception;
    public void doUpdateDataDetailPesanan(DetailPesananDto detailPesananDto) throws Exception;
}
