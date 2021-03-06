/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projek.e.commerce.springhibernate.dto.PesananDto;
import projek.e.commerce.springhibernate.model.PesananModel;
import projek.e.commerce.springhibernate.dao.PesananDao;
import projek.e.commerce.springhibernate.dto.KategoriDto;
import projek.e.commerce.springhibernate.dto.LaporanDto;
import projek.e.commerce.springhibernate.service.PesananService;

/**
 *
 * @author HP
 */
@Service
public class PesananServiceImpl implements PesananService{

    @Autowired
    PesananDao belanjaDao;
    
    @Override
    public List<PesananDto> getListBelanja() throws Exception {
        List <PesananDto> listDataDto = new ArrayList<>();
        List <PesananModel> listData = null;
        try {
            listData = belanjaDao.getListDataBelanja();
        } catch (Exception ex) {
            Logger.getLogger(PesananServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        PesananDto belanjaDto = null;
        try {
            if(listData != null){
                for(PesananModel model : listData){
                    belanjaDto = new PesananDto();
                    if(model.getKode_pesanan()!= null){
                        belanjaDto.setKode_pesanan(model.getKode_pesanan());
                    }
                    if(model.getId_pembeli()!= null){
                        belanjaDto.setId_pembeli(model.getId_pembeli());
                    }
                    if(model.getTotal_pesanan()!= null){
                        belanjaDto.setTotal_pesanan(model.getTotal_pesanan());
                    }
                    if(model.getTanggal_pesan()!= null){
                        belanjaDto.setTanggal_pesan(model.getTanggal_pesan());
                    }
                    if(model.getStatus()!= null){
                        belanjaDto.setStatus(model.getStatus());
                    }
                    if(model.getBukti_pembayaran()!= null){
                        belanjaDto.setBukti_pembayaran(model.getBukti_pembayaran());
                    }
                    if(model.getId_penerima()!= null){
                        belanjaDto.setId_pembeli(model.getId_penerima());
                    }
                    if(model.getTanggal_pembayaran()!= null){
                        belanjaDto.setTanggal_pembayaran(model.getTanggal_pembayaran());
                    }
                    
                    listDataDto.add(belanjaDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listDataDto; 
    }

    @Override
    public List<PesananDto> getBelanjaById(String id) {
        List <PesananDto> listDataDto = new ArrayList<>();
        List <PesananModel> listData = null;
        try {
            listData = (List<PesananModel>) belanjaDao.getBelanjaById(id);
        } catch (Exception ex) {
            Logger.getLogger(ProdukServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        PesananDto belanjaDto = null;
        try {
            if(listData != null){
                for(PesananModel model : listData){
                    belanjaDto = new PesananDto();
                    if(model.getKode_pesanan()!= null){
                        belanjaDto.setKode_pesanan(model.getKode_pesanan());
                    }
                    if(model.getId_pembeli()!= null){
                        belanjaDto.setId_pembeli(model.getId_pembeli());
                    }
                    if(model.getTotal_pesanan()!= null){
                        belanjaDto.setTotal_pesanan(model.getTotal_pesanan());
                    }
                    if(model.getTanggal_pesan()!= null){
                        belanjaDto.setTanggal_pesan(model.getTanggal_pesan());
                    }
                    if(model.getStatus()!= null){
                        belanjaDto.setStatus(model.getStatus());
                    }
                    if(model.getBukti_pembayaran()!= null){
                        belanjaDto.setBukti_pembayaran(model.getBukti_pembayaran());
                    }
                    if(model.getId_penerima()!= null){
                        belanjaDto.setId_penerima(model.getId_penerima());
                    }
                    if(model.getTanggal_pembayaran()!= null){
                        belanjaDto.setTanggal_pembayaran(model.getTanggal_pembayaran());
                    }
                    
                    listDataDto.add(belanjaDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listDataDto; 
    }

    @Override
    public void doUpdateDataBelanja(PesananDto belanjaDto) throws Exception {
        PesananModel dataModel = new PesananModel();
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss"); 
        try {
            dataModel.setKode_pesanan(belanjaDto.getKode_pesanan());
            dataModel.setId_pembeli(belanjaDto.getId_pembeli());
            dataModel.setTotal_pesanan(belanjaDto.getTotal_pesanan());
            dataModel.setTanggal_pesan(belanjaDto.getTanggal_pesan());
            dataModel.setStatus("BARU");
            dataModel.setBukti_pembayaran(belanjaDto.getFile().getOriginalFilename());
            dataModel.setId_penerima(belanjaDto.getId_penerima());
            dataModel.setTanggal_pembayaran(String.valueOf(dt.format(new Date())));
            dataModel.setTgl_max_bayar(belanjaDto.getTgl_max_bayar());
        } catch (Exception e) {
            e.printStackTrace();
        }
        belanjaDao.updateBelanja(dataModel);
    }

    @Override
    public void saveDataBelanja(PesananDto belanjaDto,String id_pembeli) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        PesananModel dataModel = new PesananModel();
        List<PesananModel> listData=belanjaDao.getListDataBelanja();
        int a=0;
        for(PesananModel model : listData){
            String tam=model.getKode_pesanan();
            String tamp=tam.substring(8);
            if(a<Integer.parseInt(tamp)){
                a=Integer.parseInt(tamp);
            }
        }
        a+=1;
        String kode_bel=sdf.format(new Date())+a+"";
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        dataModel.setKode_pesanan(kode_bel);
        dataModel.setId_pembeli(id_pembeli);
        dataModel.setTotal_pesanan(belanjaDto.getTotal_pesanan());
        dataModel.setTanggal_pesan(String.valueOf(dt.format(new Date())));
        dataModel.setStatus("BELUM BAYAR");
        dataModel.setBukti_pembayaran("");
        dataModel.setId_penerima(belanjaDto.getId_penerima());
        dataModel.setTanggal_pembayaran("");
        Date today = new Date();
        Date tomorrow = new Date(today.getTime() + (1000 * 60 * 60 * 24));
        dataModel.setTgl_max_bayar(String.valueOf(dt.format(tomorrow)));

        belanjaDao.saveDataBelanja(dataModel);
    }

    @Override
    public void deleteDataBelanja(String kode_belanja) throws Exception {
        try {
            belanjaDao.deleteBelanja(kode_belanja);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDataBelanjaPesan() throws Exception {
        try {
            List<Object[]> list=belanjaDao.deletePesanan();
            if(list != null){
                for(Object[] model : list){
                    belanjaDao.deleteDetailPesanan(model[0].toString(),model[1].toString());
                    belanjaDao.deleteBelanja(model[0].toString());
                    belanjaDao.updatepdateDetail(model[1].toString(),(int) model[2]);
                }
                    
                    
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public PesananDto getUpdateDataBelanja(String kode_belanja) throws Exception {
        List<PesananModel> dataList = belanjaDao.getListBelanjaUpdate(kode_belanja);
        PesananDto belanjaDto = null;
        if(dataList != null){
            for(PesananModel model : dataList){
                    belanjaDto = new PesananDto();
                    if(model.getKode_pesanan()!= null){
                        belanjaDto.setKode_pesanan(model.getKode_pesanan());
                    }
                    if(model.getId_pembeli()!= null){
                        belanjaDto.setId_pembeli(model.getId_pembeli());
                    }
                    if(model.getTotal_pesanan()!= null){
                        belanjaDto.setTotal_pesanan(model.getTotal_pesanan());
                    }
                    if(model.getTanggal_pesan()!= null){
                        belanjaDto.setTanggal_pesan(model.getTanggal_pesan());
                    }
                    if(model.getStatus()!= null){
                        belanjaDto.setStatus(model.getStatus());
                    }
                    if(model.getBukti_pembayaran()!= null){
                        belanjaDto.setBukti_pembayaran(model.getBukti_pembayaran());
                    }
                    if(model.getId_penerima()!= null){
                        belanjaDto.setId_penerima(model.getId_penerima());
                    }
                    if(model.getTanggal_pembayaran()!= null){
                        belanjaDto.setTanggal_pembayaran(model.getTanggal_pembayaran());
                    }
                }
        }
        return belanjaDto;
    }  

    @Override
    public List<PesananDto> getPesananStatusBaru() throws Exception {
        List <PesananDto> listDataDto = new ArrayList<>();
        PesananDto pesananDto = null;
        try {
           List <Object[]> listData = belanjaDao.getPesananStatusBaru();
           if(listData != null){
                for(Object[] model : listData){
                    pesananDto = new PesananDto();
                    pesananDto.setKode_pesanan(model[0].toString());
                    pesananDto.setNama(model[1].toString());
                    pesananDto.setTotal_pesanan(Integer.parseInt(model[2].toString()));
                    pesananDto.setTanggal_pesan(model[3].toString());
                    pesananDto.setStatus(model[4].toString());
                    pesananDto.setBukti_pembayaran(model[5].toString());
                    pesananDto.setTanggal_pembayaran(model[6].toString());
                    
                    listDataDto.add(pesananDto);   
                }
           }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listDataDto;
    }

    @Override
    public List<PesananDto> getPesananStatusBelumBayar() throws Exception {
        List <PesananDto> listDataDto = new ArrayList<>();
        PesananDto pesananDto = null;
        try {
           List <Object[]> listData = belanjaDao.getPesananStatusBelumBayar();
           if(listData != null){
                for(Object[] model : listData){
                    pesananDto = new PesananDto();
                    pesananDto.setKode_pesanan(model[0].toString());
                    pesananDto.setNama(model[1].toString());
                    pesananDto.setTotal_pesanan(Integer.parseInt(model[2].toString()));
                    pesananDto.setTanggal_pesan(model[3].toString());
                    pesananDto.setStatus(model[4].toString());
                    pesananDto.setBukti_pembayaran(model[5].toString());
                    pesananDto.setTanggal_pembayaran(model[6].toString());
                    
                    listDataDto.add(pesananDto);   
                }
           }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listDataDto;
    }

    @Override
    public List<PesananDto> getPesananStatusSudahBayar() throws Exception {
        List <PesananDto> listDataDto = new ArrayList<>();
        PesananDto pesananDto = null;
        try {
           List <Object[]> listData = belanjaDao.getPesananStatusSudahBayar();
           if(listData != null){
                for(Object[] model : listData){
                    pesananDto = new PesananDto();
                    pesananDto.setKode_pesanan(model[0].toString());
                    pesananDto.setNama(model[1].toString());
                    pesananDto.setTotal_pesanan(Integer.parseInt(model[2].toString()));
                    pesananDto.setTanggal_pesan(model[3].toString());
                    pesananDto.setStatus(model[4].toString());
                    pesananDto.setBukti_pembayaran(model[5].toString());
                    pesananDto.setTanggal_pembayaran(model[6].toString());
                    
                    listDataDto.add(pesananDto);   
                }
           }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listDataDto;
    }

    @Override
    public List<PesananDto> getPesananStatusReject() throws Exception {
        List <PesananDto> listDataDto = new ArrayList<>();
        PesananDto pesananDto = null;
        try {
           List <Object[]> listData = belanjaDao.getPesananStatusReject();
           if(listData != null){
                for(Object[] model : listData){
                    pesananDto = new PesananDto();
                    pesananDto.setKode_pesanan(model[0].toString());
                    pesananDto.setNama(model[1].toString());
                    pesananDto.setTotal_pesanan(Integer.parseInt(model[2].toString()));
                    pesananDto.setTanggal_pesan(model[3].toString());
                    pesananDto.setStatus(model[4].toString());
                    pesananDto.setBukti_pembayaran(model[5].toString());
                    pesananDto.setTanggal_pembayaran(model[6].toString());
                    
                    listDataDto.add(pesananDto);   
                }
           }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listDataDto;
    }
    
    @Override
    public void Confirm(String kode_pesanan) throws Exception {
        PesananModel dataModel = new PesananModel();
        PesananModel belanjaDto=belanjaDao.getBelanjaById(kode_pesanan);
        dataModel.setKode_pesanan(belanjaDto.getKode_pesanan());
        dataModel.setId_pembeli(belanjaDto.getId_pembeli());
        dataModel.setTotal_pesanan(belanjaDto.getTotal_pesanan());
        dataModel.setTanggal_pesan(belanjaDto.getTanggal_pesan());
        dataModel.setStatus("SUDAH BAYAR");
        dataModel.setBukti_pembayaran(belanjaDto.getBukti_pembayaran());
        dataModel.setId_penerima(belanjaDto.getId_penerima());
        dataModel.setTanggal_pembayaran(belanjaDto.getTanggal_pembayaran());

        belanjaDao.updateBelanja(dataModel);
    }
    
    @Override
    public void Reject(String kode_pesanan) throws Exception {
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        PesananModel dataModel = new PesananModel();
        PesananModel belanjaDto=belanjaDao.getBelanjaById(kode_pesanan);
        List<PesananModel> listData=belanjaDao.getListDataBelanja();
        dataModel.setKode_pesanan(belanjaDto.getKode_pesanan());
        dataModel.setId_pembeli(belanjaDto.getId_pembeli());
        dataModel.setTotal_pesanan(belanjaDto.getTotal_pesanan());
        dataModel.setTanggal_pesan(belanjaDto.getTanggal_pesan());
        dataModel.setStatus("REJECT");
        dataModel.setBukti_pembayaran(belanjaDto.getBukti_pembayaran());
        dataModel.setId_penerima(belanjaDto.getId_penerima());
        dataModel.setTanggal_pembayaran(belanjaDto.getTanggal_pembayaran());
        Date today = new Date();
        Date tomorrow = new Date(today.getTime() + (1000 * 60 * 60 * 24));
        dataModel.setTgl_max_bayar(String.valueOf(dt.format(tomorrow)));

        belanjaDao.updateBelanja(dataModel);
    }

    @Override
    public List<PesananDto> getBelanjaByIdPembeli(String id) {
        List <PesananDto> listDataDto = new ArrayList<>();
        List <PesananModel> listData = null;
        try {
            listData = (List<PesananModel>) belanjaDao.getListBelanjaByIdPembeli(id);
            
            PesananDto belanjaDto = null;
            if(listData != null){
                for(PesananModel model : listData){
                    belanjaDto = new PesananDto();
                    if(model.getKode_pesanan()!= null){
                        belanjaDto.setKode_pesanan(model.getKode_pesanan());
                    }
                    if(model.getId_pembeli()!= null){
                        belanjaDto.setId_pembeli(model.getId_pembeli());
                    }
                    if(model.getTotal_pesanan()!= null){
                        belanjaDto.setTotal_pesanan(model.getTotal_pesanan());
                    }
                    if(model.getTanggal_pesan()!= null){
                        belanjaDto.setTanggal_pesan(model.getTanggal_pesan());
                    }
                    if(model.getStatus()!= null){
                        belanjaDto.setStatus(model.getStatus());
                    }
                    if(model.getBukti_pembayaran()!= null){
                        belanjaDto.setBukti_pembayaran(model.getBukti_pembayaran());
                    }
                    if(model.getId_penerima()!= null){
                        belanjaDto.setId_penerima(model.getId_penerima());
                    }
                    if(model.getTanggal_pembayaran()!= null){
                        belanjaDto.setTanggal_pembayaran(model.getTanggal_pembayaran());
                    }
                    if(model.getTgl_max_bayar()!= null){
                        belanjaDto.setTgl_max_bayar(model.getTgl_max_bayar());
                    }
                    
                    listDataDto.add(belanjaDto);
                }
            }
        }catch (Exception e) {
            Logger.getLogger(ProdukServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return listDataDto;
    }
    public List<PesananDto> GrafikProdukToko() throws Exception {
        List <PesananDto> listDataDto = new ArrayList<>();
        PesananDto pesananDto = null;
        try {
           List <Object[]> listData = belanjaDao.getProdukForGrafik();
           if(listData != null){
                for(Object[] model : listData){
                    pesananDto = new PesananDto();
                    pesananDto.setKode_detail(model[0].toString());
                    pesananDto.setNama_produk(model[1].toString());
                    pesananDto.setWarna(model[2].toString());
                    pesananDto.setKuantitas(Integer.parseInt(model[3].toString()));
                    
                    listDataDto.add(pesananDto);   
                }
           }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listDataDto;
    }

    @Override
    public List<PesananDto> getListPesananByIdPembeli(String id) {
        List <PesananDto> listDataDto = new ArrayList<>();
        List <PesananModel> listData = null;
        try {
            listData = (List<PesananModel>) belanjaDao.getListDataPesananByIdPembeli(id);
        } catch (Exception ex) {
            Logger.getLogger(ProdukServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        PesananDto belanjaDto = null;
        try {
            if(listData != null){
                for(PesananModel model : listData){
                    belanjaDto = new PesananDto();
                    if(model.getKode_pesanan()!= null){
                        belanjaDto.setKode_pesanan(model.getKode_pesanan());
                    }
                    if(model.getId_pembeli()!= null){
                        belanjaDto.setId_pembeli(model.getId_pembeli());
                    }
                    if(model.getTotal_pesanan()!= null){
                        belanjaDto.setTotal_pesanan(model.getTotal_pesanan());
                    }
                    if(model.getTanggal_pesan()!= null){
                        belanjaDto.setTanggal_pesan(model.getTanggal_pesan());
                    }
                    if(model.getStatus()!= null){
                        belanjaDto.setStatus(model.getStatus());
                    }
                    if(model.getBukti_pembayaran()!= null){
                        belanjaDto.setBukti_pembayaran(model.getBukti_pembayaran());
                    }
                    if(model.getId_penerima()!= null){
                        belanjaDto.setId_penerima(model.getId_penerima());
                    }
                    if(model.getTanggal_pembayaran()!= null){
                        belanjaDto.setTanggal_pembayaran(model.getTanggal_pembayaran());
                    }
                    
                    listDataDto.add(belanjaDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listDataDto; 
    }

    @Override
    public List<PesananDto> getMakeLaporanPenjualan(String tanggal_transaksi, String bulan_transaksi) {
        List <PesananDto> listDataDto = new ArrayList<>();
        PesananDto pesananDto = null;
        try {
           List <Object[]> listData = belanjaDao.getMakeLaporanPenjualan(tanggal_transaksi, bulan_transaksi);
           if(listData != null){
                for(Object[] model : listData){
                    pesananDto = new PesananDto();
                    pesananDto.setKode_detail(model[0].toString());
                    pesananDto.setNama_produk(model[1].toString());
                    pesananDto.setKuantitas(Integer.parseInt(model[2].toString()));
                    pesananDto.setTotal_pesanan(Integer.parseInt(model[3].toString()));
                    pesananDto.setTanggal_pesan(model[4].toString());
                    
                    listDataDto.add(pesananDto);   
                }
           }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listDataDto;
    }

    @Override
    public List<PesananDto> getProdukTerjual(String tanggal_transaksi, String bulan_transaksi) {
        List <PesananDto> listDataDto = new ArrayList<>();
        PesananDto pesananDto = null;
        try {
           List <Object[]> listData = belanjaDao.getProdukTerjual(tanggal_transaksi, bulan_transaksi);
           if(listData != null){
                for(Object[] model : listData){
                    pesananDto = new PesananDto();
                    pesananDto.setNama_produk(model[0].toString().toLowerCase());
                    pesananDto.setTotal_pesanan(Integer.parseInt(model[1].toString()));
                    
                    listDataDto.add(pesananDto);   
                }
           }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listDataDto;
    }

    @Override
    public List<PesananDto> getTahunToMakeLaporan() throws Exception {
        List <PesananDto> listDataDto = new ArrayList<>();
        PesananDto laporanDto = null;
        try {
           List <Object[]> listData = belanjaDao.getTahunToMakeLaporan();
           System.out.println(listData);
           if(listData != null){
                for(Object[] model : listData){
                    laporanDto = new PesananDto();
                    laporanDto.setTanggal_pesan(model[1].toString());
                   
                    listDataDto.add(laporanDto);   
                }
           }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listDataDto;
    }

    @Override
    public List<PesananDto> getDetailPesanan(String kode_pesanan) throws Exception {
        List <PesananDto> listDataDto = new ArrayList<>();
        PesananDto pesananDto = null;
        try {
           List <Object[]> listData = belanjaDao.getDetailPesanan(kode_pesanan);
           if(listData != null){
                for(Object[] model : listData){
                    pesananDto = new PesananDto();
                    pesananDto.setKode_pesanan(model[0].toString());
                    pesananDto.setNama_produk(model[1].toString().toLowerCase());
                    pesananDto.setKuantitas(Integer.parseInt(model[2].toString()));
                    
                    listDataDto.add(pesananDto);   
                }
           }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listDataDto;
    }
    
   
}