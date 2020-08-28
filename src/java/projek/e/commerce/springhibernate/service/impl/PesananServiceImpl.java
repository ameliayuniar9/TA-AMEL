/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import projek.e.commerce.springhibernate.service.PesananService;

/**
 *
 * @author HP
 */
@Service
@Transactional
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
        SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss"); 
        try {
            dataModel.setKode_pesanan(belanjaDto.getKode_pesanan());
            dataModel.setId_pembeli(belanjaDto.getId_pembeli());
            dataModel.setTotal_pesanan(belanjaDto.getTotal_pesanan());
            dataModel.setTanggal_pesan(belanjaDto.getTanggal_pesan());
            dataModel.setStatus("SUDAH BAYAR");
            dataModel.setBukti_pembayaran(belanjaDto.getFile().getOriginalFilename());
            dataModel.setId_penerima(belanjaDto.getId_penerima());
            dataModel.setTanggal_pembayaran(String.valueOf(dt.format(new Date())));
        } catch (Exception e) {
            e.printStackTrace();
        }
        belanjaDao.updateBelanja(dataModel);
    }

    @Override
    public void saveDataBelanja(PesananDto belanjaDto,String id_pembeli) throws Exception {
        PesananModel dataModel = new PesananModel();
        List<PesananModel> listData=belanjaDao.getListDataBelanja();
        int a=0;
        for(PesananModel model : listData){
            String tam=model.getKode_pesanan();
            String tamp=tam.substring(4);
            if(a<Integer.parseInt(tamp)){
                a=Integer.parseInt(tamp);
            }
        }
        a+=1;
        String kode_bel="PEN-"+a+"";
        SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss");
        dataModel.setKode_pesanan(kode_bel);
        dataModel.setId_pembeli(id_pembeli);
        dataModel.setTotal_pesanan(belanjaDto.getTotal_pesanan());
        dataModel.setTanggal_pesan(String.valueOf(dt.format(new Date())));
        dataModel.setStatus("BELUM BAYAR");
        dataModel.setBukti_pembayaran("");
        dataModel.setId_penerima(belanjaDto.getId_penerima());
        dataModel.setTanggal_pembayaran("");

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
}