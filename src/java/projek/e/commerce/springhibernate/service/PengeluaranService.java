/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.service;

import java.util.List;
import projek.e.commerce.springhibernate.dto.PengeluaranDto;
import projek.e.commerce.springhibernate.model.PengeluaranModel;

/**
 *
 * @author amelia.yuniar
 */
public interface PengeluaranService {
    public void saveDataPengeluaran(PengeluaranDto pengeluaranDto) throws Exception;
    public List <PengeluaranDto> getListPengeluaran()throws Exception;
    public List <PengeluaranDto> getListPengeluaraCek()throws Exception;
    public PengeluaranModel getPengeluaranById(String id);
    public void deleteDataPengeluaran(String kode_pengeluaran) throws Exception;
    public PengeluaranDto getUpdateDataPengeluaran(String kode_pengeluaran) throws Exception;
    public void doUpdateDataPengeluaran(PengeluaranDto pengeluaranDto) throws Exception;
    public List<PengeluaranDto> doGetDataLaporanPengeluaran (String tahun, String bulan);
    public List<PengeluaranDto> doGetDataPengeluaranWithAccountName ();
    public List<PengeluaranDto> doGetDataPengeluaranWithAccountNameCek();
    
    public  void Approved(String kode_pengeluaran) throws Exception;
    public  void Disapproved(String kode_pengeluaran) throws Exception;
}
