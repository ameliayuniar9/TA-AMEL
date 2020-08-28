/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.dao;

import java.util.List;
import projek.e.commerce.springhibernate.model.DetailPesananModel;

/**
 *
 * @author amelia.yuniar
 */
public interface DetailPesananDao {
    public void saveDataDetailPesanan(DetailPesananModel detailPesananModel) throws Exception;
    public List<DetailPesananModel> getListDataDetailPesanan() throws Exception;
    public DetailPesananModel getDetailPesananById(String id) throws Exception;
    public void deleteDetailPesanan(String id);
    public void updateDetailPesanan(DetailPesananModel detailPesananModel);
    public List<DetailPesananModel> getListDetailPesananUpdate(String kode_detail_pesanan);
}
