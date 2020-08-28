/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import projek.e.commerce.springhibernate.dao.AkunDao;
import projek.e.commerce.springhibernate.dto.AkunDto;
import projek.e.commerce.springhibernate.model.AkunModel;
import projek.e.commerce.springhibernate.service.AkunService;

/**
 *
 * @author amelia.yuniar
 */
public class AkunServiceImpl implements AkunService{
    
    @Autowired
    AkunDao akunDao;

    @Override
    public void saveDataAkun(AkunDto akunDto) throws Exception {
        List<AkunModel> listData=akunDao.getListDataAkun();
        int i=0;
        for(AkunModel model : listData){
            String tam=model.getKode_akun();
            String tamp=tam.substring(1);
            if(i<Integer.parseInt(tamp)){
                i=Integer.parseInt(tamp);
            }
        }
        i+=1;
        String kode_ak="A0"+i+"";
        AkunModel ak = new AkunModel();
        try {
            ak.setKode_akun(kode_ak);
            ak.setNama_akun(akunDto.getNama_akun());
            ak.setDeskripsi(akunDto.getDeskripsi());
            akunDao.saveDataAkun(ak);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<AkunDto> getListAkun() throws Exception {
        List<AkunDto> listDataDto = new ArrayList<>();
        List<AkunModel> listData = akunDao.getListDataAkun();
        AkunDto akunDto = null;
        try {
            if (listData != null) {
                for (AkunModel model : listData) {
                    akunDto = new AkunDto();
                    if (model.getKode_akun()!= null) {
                        akunDto.setKode_akun(model.getKode_akun());
                    }
                    if (model.getNama_akun()!= null) {
                        akunDto.setNama_akun(model.getNama_akun());
                    }
                    if (model.getDeskripsi()!= null) {
                        akunDto.setDeskripsi(model.getDeskripsi());
                    }

                    listDataDto.add(akunDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDataDto;
    }

    @Override
    public AkunModel getAkunById(String id) {
        AkunModel akunModel = null;
        try {
            akunModel = akunDao.getAkunById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return akunModel;
    }

    @Override
    public void deleteDataAkun(String kode_akun) throws Exception {
        try {
            akunDao.deleteAkun(kode_akun);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public AkunDto getUpdateDataAkun(String kode_akun) throws Exception {
        List<AkunModel> dataList = akunDao.getListAkunUpdate(kode_akun);
        AkunDto dto = new AkunDto();
        if(dataList != null){
            for (AkunModel ddm : dataList) {       
                if(ddm.getKode_akun()!= null){
                    dto.setKode_akun(ddm.getKode_akun());
                }
                if(ddm.getNama_akun()!= null){
                    dto.setNama_akun(ddm.getNama_akun());
                }
                if(ddm.getDeskripsi()!= null){
                    dto.setDeskripsi(ddm.getDeskripsi());
                }
            }
        }
        return dto;
    }

    @Override
    public void doUpdateDataAkun(AkunDto akunDto) throws Exception {
        AkunModel ddm = new AkunModel();
        try {
            ddm.setKode_akun(akunDto.getKode_akun());
            ddm.setNama_akun(akunDto.getNama_akun());
            ddm.setDeskripsi(akunDto.getDeskripsi());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        akunDao.updateAkun(ddm);
    }
    
}
