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
import org.springframework.transaction.annotation.Transactional;
import projek.e.commerce.springhibernate.dao.DetailDao;
import projek.e.commerce.springhibernate.dao.ProdukDao;
import projek.e.commerce.springhibernate.dto.DetailDto;
import projek.e.commerce.springhibernate.model.DetailModel;
import projek.e.commerce.springhibernate.model.ProdukModel;
import projek.e.commerce.springhibernate.service.DetailService;

/**
 *
 * @author HP
 */
@Service
@Transactional
public class DetailServiceImpl implements DetailService{

    @Autowired
    DetailDao detailDao;
    
     @Autowired
    ProdukDao produkDao;
        
    @Override
    public List<DetailDto> getListDetail() throws Exception {
        List <DetailDto> listDataDto = new ArrayList<>();
        List <DetailModel> listData = detailDao.getListDataDetail();
        DetailDto detailDto = null;
        try {
            if(listData != null){
                for(DetailModel model : listData){
                    detailDto = new DetailDto();
                    if(model.getKode_detail()!= null){
                        detailDto.setKode_detail(model.getKode_detail());
                    }
                    if(model.getKode_produk()!= null){
                        detailDto.setKode_produk(model.getKode_produk());
                        List <ProdukModel> listDataProd = produkDao.getListProdukUpdate(model.getKode_produk());
                        for(ProdukModel prod : listDataProd){
                            detailDto.setKode_kategori(prod.getKode_kategori());
                            detailDto.setNama_produk(prod.getNama_produk());
                            detailDto.setHarga_jual(prod.getHarga_jual());
                            detailDto.setKeterangan_produk(prod.getKeterangan_produk());
                        }
                        
                    }
                    if(model.getWarna()!= null){
                        detailDto.setWarna(model.getWarna());
                    }
                    if(model.getGambar()!= null){
                        detailDto.setGambar(model.getGambar());
                    }
                    if(model.getStok()!= null){
                        detailDto.setStok(model.getStok());
                    } 
                    
                    
                    listDataDto.add(detailDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listDataDto;
    }
  
    @Override
    public void saveDataDetail(DetailDto detailDto) throws Exception {
        DetailModel detailModel = new DetailModel();
        List<DetailModel> listData=detailDao.getListDataDetail();
        int p=0;
        for(DetailModel model : listData){
            String tam=model.getKode_detail();
            String tamp=tam.substring(4);
            if(p<Integer.parseInt(tamp)){
                p=Integer.parseInt(tamp);
            }
        }
        p+=1;
        String kode="DTL-"+p+"";
        try {
            detailModel.setKode_detail(kode);
            detailModel.setKode_produk(detailDto.getKode_produk());
            detailModel.setWarna(detailDto.getWarna());
            detailModel.setGambar(detailDto.getFile().getOriginalFilename());
            detailModel.setStok(detailDto.getStok());
            
            detailDao.saveDataDetail(detailModel);
           
                       
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public DetailModel getDetailById(String kode) {
        DetailModel detailModel = null;
        try {
            detailModel = detailDao.getDetailById(kode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return detailModel;
    }

    @Override
    public void deleteDataDetail(String kode_detail) throws Exception {
        try {
            detailDao.deleteDetail(kode_detail);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public DetailDto getUpdateDataDetail(String kode_detail) throws Exception {
        List<DetailModel> dataList = detailDao.getListDetailUpdate(kode_detail);
        DetailDto detailDto = new DetailDto();
        if(dataList != null){
            for(DetailModel model : dataList){
                    detailDto = new DetailDto();
                    if(model.getKode_detail()!= null){
                        detailDto.setKode_detail(model.getKode_detail());
                    }
                    if(model.getKode_produk()!= null){
                        detailDto.setKode_produk(model.getKode_produk());
                        List <ProdukModel> listDataProd = produkDao.getListProdukUpdate(model.getKode_produk());
                        for(ProdukModel prod : listDataProd){
                            detailDto.setNama_produk(prod.getNama_produk());
                            detailDto.setHarga_jual(prod.getHarga_jual());
                            detailDto.setKeterangan_produk(prod.getKeterangan_produk());
                        }
                    }
                    if(model.getWarna()!= null){
                        detailDto.setWarna(model.getWarna());
                    }
                    if(model.getGambar()!= null){
                        detailDto.setGambar(model.getGambar());
                    }
                    if(model.getStok()!= null){
                        detailDto.setStok(model.getStok());
                    }
                }
        }
        return detailDto;
    }

    @Override
    public void doUpdateDataDetail(DetailDto detailDto) throws Exception {
       DetailModel detailModel = new DetailModel();
        try {
            detailModel.setKode_detail(detailDto.getKode_detail());
            detailModel.setKode_produk(detailDto.getKode_produk());
            detailModel.setWarna(detailDto.getWarna());
            detailModel.setGambar(detailDto.getFile().getOriginalFilename());
            detailModel.setStok(detailDto.getStok());
        } catch (Exception e) {
            e.printStackTrace();
        }
        detailDao.updateDetail(detailModel);
    }

    @Override
    public List<DetailDto> getProdukByKategori(String kode_kategori) throws Exception {
        List <DetailDto> listDataDto = new ArrayList<>();
        List <Object[]> listData = detailDao.getListProdukByKategori(kode_kategori);
        DetailDto detailDto = null;
        try {
            if(listData != null){
                for(Object[] model : listData){
                    detailDto = new DetailDto();
                    detailDto.setKode_detail(model[0].toString());
                    detailDto.setKode_produk(model[1].toString());
                    detailDto.setWarna(model[2].toString());
                    detailDto.setGambar(model[3].toString());
                    detailDto.setStok(Integer.parseInt(model[4].toString()));
                    detailDto.setKode_kategori(model[5].toString());
                    detailDto.setNama_produk(model[6].toString());
                    detailDto.setHarga_jual(Integer.parseInt(model[7].toString()));
                    detailDto.setKeterangan_produk(model[8].toString());
                    
                    listDataDto.add(detailDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listDataDto;
    }
    
}
