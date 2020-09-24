/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.dao;

import java.util.List;
import projek.e.commerce.springhibernate.model.PesananModel;

/**
 *
 * @author HP
 */
public interface PesananDao {
    public void deletegagalpesan(String belanjaModel)throws Exception;
    public void deleteDetailPesanan(String kodePesanan,String kodeDetail)throws Exception;
    public void updatepdateDetail(String kodeDetail,int stok)throws Exception;
    
    public List<Object[]> deletePesanan()throws Exception;
    public void saveDataBelanja(PesananModel belanjaModel)throws Exception;
    public List<PesananModel> getListDataBelanja()throws Exception;
    public PesananModel getBelanjaById(String id) throws Exception;
    public void deleteBelanja(String id);
    public void updateBelanja(PesananModel belanjaModel);
    public List<PesananModel> getListBelanjaUpdate(String kode_pesanan);
    public List<Object[]> getPesananStatusBaru() throws Exception;
    public List<Object[]> getPesananStatusBelumBayar() throws Exception;
    public List<Object[]> getPesananStatusSudahBayar() throws Exception;
    public List<Object[]> getPesananStatusReject(String id) throws Exception;
    public List<PesananModel> getListBelanjaByIdPembeli(String id_pembeli);
    public List<Object[]> getProdukForGrafik() throws Exception;
    public List<PesananModel> getListDataPesananByIdPembeli(String id)throws Exception;
    public List<Object[]> getMakeLaporanPenjualan(String tanggal_transaksi, String bulan_transaksi) throws Exception;
    public List<Object[]> getProdukTerjual(String tanggal_transaksi, String bulan_transaksi) throws Exception;
    public List<Object[]> getTahunToMakeLaporan() throws Exception;
    public List<Object[]> getDetailPesanan(String kode_pesanan) throws Exception;
    public List<Object[]> getPesananStatusReject() throws Exception;
   
}
