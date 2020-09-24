/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projek.e.commerce.springhibernate.dao.AkunDao;
import projek.e.commerce.springhibernate.dao.PengeluaranDao;
import projek.e.commerce.springhibernate.dto.PengeluaranDto;
import projek.e.commerce.springhibernate.model.AkunModel;
import projek.e.commerce.springhibernate.model.PengeluaranModel;
import projek.e.commerce.springhibernate.service.PengeluaranService;

/**
 *
 * @author amelia.yuniar
 */
@Service
public class PengeluaranServiceImpl implements PengeluaranService{
    @Autowired
    PengeluaranDao  pengeluaranDao;
    
    @Autowired
    AkunDao  akunDao;
    
    @Override
    public void saveDataPengeluaran(PengeluaranDto pengeluaranDto) throws Exception {
        List<PengeluaranModel> listData=pengeluaranDao.getListDataPengeluaran();
        int i=0;
        for(PengeluaranModel model : listData){
            String tam=model.getKode_pengeluaran();
            String tamp=tam.substring(4);
            if(i<Integer.parseInt(tamp)){
                i=Integer.parseInt(tamp);
            }
        }
        i+=1;
        String kode_keluar="PNG-"+i+"";
        PengeluaranModel pengeluaranProduk = new PengeluaranModel();
        try {
            pengeluaranProduk.setKode_pengeluaran(kode_keluar);
            pengeluaranProduk.setTanggal(pengeluaranDto.getTanggal());
            pengeluaranProduk.setKode_akun(pengeluaranDto.getKode_akun());
            pengeluaranProduk.setDeskripsi(pengeluaranDto.getDeskripsi());
            pengeluaranProduk.setJumlah(pengeluaranDto.getJumlah());
            pengeluaranProduk.setUpload_file(pengeluaranDto.getFile().getOriginalFilename());
            pengeluaranProduk.setStatus("Baru");
            pengeluaranDao.saveDataPengeluaran(pengeluaranProduk);
            
                       
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<PengeluaranDto> getListPengeluaran() throws Exception {
        List <PengeluaranDto> listDataDto = new ArrayList<>();
        List <PengeluaranModel> listData = pengeluaranDao.getListDataPengeluaran();
        PengeluaranDto pengeluaranDto = null;
        try {
            if(listData != null){
                for(PengeluaranModel model : listData){
                    pengeluaranDto = new PengeluaranDto();
                    if(model.getKode_pengeluaran()!= null){
                        pengeluaranDto.setKode_pengeluaran(model.getKode_pengeluaran());
                    }
                    if(model.getTanggal()!= null){
                        pengeluaranDto.setTanggal(model.getTanggal());
                    }
                    if(model.getKode_akun()!= null){
                        pengeluaranDto.setKode_akun(model.getKode_akun());
                    }
                    if(model.getDeskripsi()!= null){
                        pengeluaranDto.setDeskripsi(model.getDeskripsi());
                    }
                    if(model.getUpload_file()!= null){
                        pengeluaranDto.setUpload_file(model.getUpload_file());
                    }
                    if(model.getStatus()!= null){
                        pengeluaranDto.setStatus(model.getStatus());
                    }
                    pengeluaranDto.setJumlah(model.getJumlah());

                    listDataDto.add(pengeluaranDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listDataDto;
    }

    @Override
    public PengeluaranModel getPengeluaranById(String id) {
        PengeluaranModel pengeluaranModel = null;
        try {
            pengeluaranModel = pengeluaranDao.getPengeluaranById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pengeluaranModel;
    }

    @Override
    public void deleteDataPengeluaran(String kode_pengeluaran) throws Exception {
        try {
            pengeluaranDao.deletePengeluaran(kode_pengeluaran);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public PengeluaranDto getUpdateDataPengeluaran(String kode_pengeluaran) throws Exception {
        List<PengeluaranModel> dataList = pengeluaranDao.getListPegeluaranUpdate(kode_pengeluaran);
        PengeluaranDto dto = new PengeluaranDto();
        if(dataList != null){
            for (PengeluaranModel ddm : dataList) {       
                if(ddm.getKode_pengeluaran()!= null){
                    dto.setKode_pengeluaran(ddm.getKode_pengeluaran());
                }
                if(ddm.getTanggal()!= null){
                    dto.setTanggal(ddm.getTanggal());
                }
                if(ddm.getKode_akun()!= null){
                    dto.setKode_akun(ddm.getKode_akun());
                }
                if(ddm.getDeskripsi()!= null){
                    dto.setDeskripsi(ddm.getDeskripsi());
                }
                if(ddm.getUpload_file()!= null){
                    dto.setUpload_file(ddm.getUpload_file());
                }
                dto.setJumlah(ddm.getJumlah());
            }
        }
        return dto;
    }

    @Override
    public void doUpdateDataPengeluaran(PengeluaranDto pengeluaranDto) throws Exception {
        PengeluaranModel ddm = new PengeluaranModel();
        try {
            ddm.setKode_pengeluaran(pengeluaranDto.getKode_pengeluaran());
            ddm.setTanggal(pengeluaranDto.getTanggal());
            ddm.setKode_akun(pengeluaranDto.getKode_akun());
            ddm.setDeskripsi(pengeluaranDto.getDeskripsi());
            ddm.setJumlah(pengeluaranDto.getJumlah());
            ddm.setUpload_file(pengeluaranDto.getFile().getOriginalFilename());
            ddm.setStatus("Baru");
        } catch (Exception e) {
            e.printStackTrace();
        }
        pengeluaranDao.updatePengeluaran(ddm);
    }

    @Override
    public List<PengeluaranDto> doGetDataLaporanPengeluaran(String tahun, String bulan) {
        List <PengeluaranDto> listDataDto = new ArrayList<>();
        PengeluaranDto pengeluaranDto = null;
        try {
           List <Object[]> listData = pengeluaranDao.getExpenseValueToMakeLaporan(tahun,bulan);
           if(listData != null){
                for(Object[] model : listData){
                    pengeluaranDto = new PengeluaranDto();
                    pengeluaranDto.setJumlah(Integer.parseInt(model[0].toString()));
                    System.out.println("asdjasdkjlashdfjsadhfj");
                    System.out.println((Integer.parseInt(model[0].toString())));
                    pengeluaranDto.setNama_akun(model[1].toString());
                    
                    listDataDto.add(pengeluaranDto);   
                }
           }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listDataDto;
    }

    @Override
    public List<PengeluaranDto> doGetDataPengeluaranWithAccountName() {
        List <PengeluaranDto> listDataDto = new ArrayList<>();
        PengeluaranDto pengeluaranDto = null;
        try {
           List <Object[]> listData = pengeluaranDao.getExpenseWithAccountName();
           if(listData != null){
                for(Object[] model : listData){
                    pengeluaranDto = new PengeluaranDto();
                    pengeluaranDto.setKode_pengeluaran(model[0].toString());
                    pengeluaranDto.setTanggal(model[1].toString());
                    pengeluaranDto.setKode_akun(model[2].toString());
                    pengeluaranDto.setDeskripsi(model[3].toString());
                    pengeluaranDto.setJumlah(Integer.parseInt(model[4].toString()));
                    pengeluaranDto.setUpload_file(model[5].toString());
                    pengeluaranDto.setStatus(model[6].toString());
                    pengeluaranDto.setNama_akun(model[7].toString());
                    
                    listDataDto.add(pengeluaranDto);   
                }
           }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listDataDto;
    }

    @Override
    public List<PengeluaranDto> getListPengeluaraCek() throws Exception {
        List <PengeluaranDto> listDataDto = new ArrayList<>();
        PengeluaranDto pengeluaranDto = null;
        try {
           List <Object[]> listData = pengeluaranDao.getListDataPengeluaranCek();
           if(listData != null){
                for(Object[] model : listData){
                    pengeluaranDto = new PengeluaranDto();
                    pengeluaranDto.setKode_pengeluaran(model[0].toString());
                    pengeluaranDto.setTanggal(model[1].toString());
                    pengeluaranDto.setKode_akun(model[2].toString());
                    pengeluaranDto.setDeskripsi(model[3].toString());
                    pengeluaranDto.setJumlah(Integer.parseInt(model[4].toString()));
                    pengeluaranDto.setUpload_file(model[5].toString());
                    pengeluaranDto.setStatus(model[6].toString());
                    pengeluaranDto.setNama_akun(model[7].toString());
                    
                    listDataDto.add(pengeluaranDto);   
                }
           }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listDataDto;
    }

    @Override
    public List<PengeluaranDto> doGetDataPengeluaranWithAccountNameCek() {
        List <PengeluaranDto> listDataDto = new ArrayList<>();
        PengeluaranDto pengeluaranDto = null;
        try {
           List <Object[]> listData = pengeluaranDao.getExpenseWithAccountNameCek();
           if(listData != null){
                for(Object[] model : listData){
                    pengeluaranDto = new PengeluaranDto();
                    pengeluaranDto.setKode_pengeluaran(model[0].toString());
                    pengeluaranDto.setTanggal(model[1].toString());
                    pengeluaranDto.setKode_akun(model[2].toString());
                    pengeluaranDto.setDeskripsi(model[3].toString());
                    pengeluaranDto.setJumlah(Integer.parseInt(model[4].toString()));
                    pengeluaranDto.setUpload_file(model[5].toString());
                    pengeluaranDto.setStatus(model[6].toString());
                    pengeluaranDto.setNama_akun(model[7].toString());
                    
                    listDataDto.add(pengeluaranDto);   
                }
           }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listDataDto;
    }

    @Override
    public void Approved(String kode_pengeluaran) throws Exception {
        PengeluaranModel pengeluaranDto= pengeluaranDao.getPengeluaranById(kode_pengeluaran);
        PengeluaranModel ddm = new PengeluaranModel();
        try {
            ddm.setKode_pengeluaran(pengeluaranDto.getKode_pengeluaran());
            ddm.setTanggal(pengeluaranDto.getTanggal());
            ddm.setKode_akun(pengeluaranDto.getKode_akun());
            ddm.setDeskripsi(pengeluaranDto.getDeskripsi());
            ddm.setJumlah(pengeluaranDto.getJumlah());
            ddm.setUpload_file(pengeluaranDto.getUpload_file());
            ddm.setStatus("Approved");
        } catch (Exception e) {
            e.printStackTrace();
        }
        pengeluaranDao.updatePengeluaran(ddm);
    }

    @Override
    public void Disapproved(String kode_pengeluaran) throws Exception {
        PengeluaranModel pengeluaranDto= pengeluaranDao.getPengeluaranById(kode_pengeluaran);
        PengeluaranModel ddm = new PengeluaranModel();
        try {
            ddm.setKode_pengeluaran(pengeluaranDto.getKode_pengeluaran());
            ddm.setTanggal(pengeluaranDto.getTanggal());
            ddm.setKode_akun(pengeluaranDto.getKode_akun());
            ddm.setDeskripsi(pengeluaranDto.getDeskripsi());
            ddm.setJumlah(pengeluaranDto.getJumlah());
            ddm.setUpload_file(pengeluaranDto.getUpload_file());
            ddm.setStatus("Disapproved");
        } catch (Exception e) {
            e.printStackTrace();
        }
        pengeluaranDao.updatePengeluaran(ddm);
    }

}
