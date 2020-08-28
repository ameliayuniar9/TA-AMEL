/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projek.e.commerce.springhibernate.dao.KategoriDao;
import projek.e.commerce.springhibernate.dto.KategoriDto;
import projek.e.commerce.springhibernate.model.KategoriModel;
import projek.e.commerce.springhibernate.service.KategoriService;

/**
 *
 * @author HP
 */
@Service
@Transactional
public class KategoriServiceImpl implements KategoriService{
    @Autowired
    KategoriDao kategoriDao; 

    @Override
    public List<KategoriDto> getListKategori() throws Exception {
        List <KategoriDto> listDataDto = new ArrayList<>();
        List <KategoriModel> listData = kategoriDao.getListDataKategori();
        KategoriDto kategoriDto = null;
        try {
            if(listData != null){
                for(KategoriModel model : listData){
                    kategoriDto = new KategoriDto();
                    if(model.getKode_kategori()!= null){
                        kategoriDto.setKode_kategori(model.getKode_kategori());
                    }
                    if(model.getNama_kategori()!= null){
                        kategoriDto.setNama_kategori(model.getNama_kategori());
                    }
                    listDataDto.add(kategoriDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listDataDto;
    }

    @Override
    public void saveDataKategori(KategoriDto kategoriDto) throws Exception {
        KategoriModel kategoriModel = new KategoriModel();
        List<KategoriModel> listData=kategoriDao.getListDataKategori();
        try {
            int b=0;
            for(KategoriModel model : listData){
                String tam=model.getKode_kategori();
                String tamp=tam.substring(4);
                if(b<Integer.parseInt(tamp)){
                    b=Integer.parseInt(tamp);
                }
            }
            b+=1;
            String kodeKategori="KTG-"+b+"";
            kategoriModel.setKode_kategori(kodeKategori);
            kategoriModel.setNama_kategori(kategoriDto.getNama_kategori());
            
            kategoriDao.saveDataKategori(kategoriModel);
                       
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public KategoriModel getKategoriById(String id) {
        KategoriModel kategoriModel = null;
        try {
            kategoriModel = kategoriDao.getKategoriById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kategoriModel;
    }
     
    
    @Override
    public void deleteDataKategori(String kode_kategori) throws Exception {
        try {
            kategoriDao.deleteKategori(kode_kategori);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public KategoriDto getUpdateDataKategori(String kode_kategori) throws Exception {
        List<KategoriModel> dataList = kategoriDao.getListKategoriUpdate(kode_kategori);
        KategoriDto dto = new KategoriDto();
        if(dataList != null){
            for (KategoriModel ddm : dataList) {       
                if(ddm.getKode_kategori()!= null){
                    dto.setKode_kategori(ddm.getKode_kategori());
                }
                if(ddm.getNama_kategori()!= null){
                    dto.setNama_kategori(ddm.getNama_kategori());
                }
            }
        }
        return dto;
    }

    @Override
    public void doUpdateDataKategori(KategoriDto kategoriDto) throws Exception {
        KategoriModel ddm = new KategoriModel();
        try {
            ddm.setKode_kategori(kategoriDto.getKode_kategori());
            ddm.setNama_kategori(kategoriDto.getNama_kategori());
        } catch (Exception e) {
            e.printStackTrace();
        }
        kategoriDao.updateKategori(ddm);
    }
    
    
    
}
