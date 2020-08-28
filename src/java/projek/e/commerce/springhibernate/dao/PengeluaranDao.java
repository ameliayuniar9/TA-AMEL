/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.dao;

import java.util.List;
import projek.e.commerce.springhibernate.model.PengeluaranModel;

/**
 *
 * @author amelia.yuniar
 */
public interface PengeluaranDao {
    
    public void saveDataPengeluaran(PengeluaranModel pengeluaranModel) throws Exception;
    public List<PengeluaranModel> getListDataPengeluaran() throws Exception;
    public List<Object[]> getListDataPengeluaranCek() throws Exception;
    public PengeluaranModel getPengeluaranById(String id) throws Exception;
    public void deletePengeluaran(String id);
    public void updatePengeluaran(PengeluaranModel pengeluaranModel);
    public List<PengeluaranModel> getListPegeluaranUpdate(String kode_pengeluaran);
    public List<Object[]> getExpenseValueToMakeLaporan(String tanggal_transaksi, String bulan_transaksi) throws Exception;
    public List<Object[]> getExpenseWithAccountName() throws Exception;
    public List<Object[]> getExpenseWithAccountNameCek() throws Exception;
}
