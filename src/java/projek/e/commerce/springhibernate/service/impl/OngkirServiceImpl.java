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
import projek.e.commerce.springhibernate.dao.OngkirDao;
import projek.e.commerce.springhibernate.dto.OngkirDto;
import projek.e.commerce.springhibernate.model.OngkirModel;
import projek.e.commerce.springhibernate.service.OngkirService;

/**
 *
 * @author HP
 */
@Service
@Transactional
public class OngkirServiceImpl implements OngkirService{

    @Autowired
    OngkirDao ongkirDao;
    
    @Override
    public List<OngkirDto> getListOngkir() throws Exception {
        List <OngkirDto> listDataDto = new ArrayList<>();
        List <OngkirModel> listData = ongkirDao.getListDataOngkir();
        OngkirDto ongkirDto = null;
        try {
            if(listData != null){
                for(OngkirModel model : listData){
                    ongkirDto = new OngkirDto();
                    if(model.getKode_ongkir()!= null){
                        ongkirDto.setKode_ongkir(model.getKode_ongkir());
                    }
                    if(model.getNama_kota()!= null){
                        ongkirDto.setNama_kota(model.getNama_kota());
                    }
                    if(model.getHarga()!= null){
                        ongkirDto.setHarga(model.getHarga());
                    }
                    
                    listDataDto.add(ongkirDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listDataDto;
    }
    
    @Override
    public void saveDataOngkir(OngkirDto ongkirDto) throws Exception {
        OngkirModel ongkirModel = new OngkirModel();
        List<OngkirModel> listData=ongkirDao.getListDataOngkir();
        int a=0;
        for(OngkirModel model : listData){
            String tam=model.getKode_ongkir();
            String tamp=tam.substring(5);
            if(a<Integer.parseInt(tamp)){
                a=Integer.parseInt(tamp);
            }
        }
        a+=1;
        String kodeOngkir="ONGK-"+a+"";
        try {
            ongkirModel.setKode_ongkir(kodeOngkir);
            ongkirModel.setNama_kota(ongkirDto.getNama_kota());
            ongkirModel.setHarga(ongkirDto.getHarga());
            
            ongkirDao.saveDataOngkir(ongkirModel);
                       
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public OngkirModel getOngkirById(String id) {
        OngkirModel ongkirModel = null;
        try {
            ongkirModel = ongkirDao.getOngkirById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ongkirModel;
    }

    @Override
    public void deleteDataOngkir(String kode_ongkir) throws Exception {
        try {
            ongkirDao.deleteOngkir(kode_ongkir);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public OngkirDto getUpdateDataOngkir(String kode_ongkir) throws Exception {
        List<OngkirModel> dataList = ongkirDao.getListOngkirUpdate(kode_ongkir);
        OngkirDto dto = new OngkirDto();
        if(dataList != null){
            for (OngkirModel ddm : dataList) {       
                if(ddm.getKode_ongkir()!= null){
                    dto.setKode_ongkir(ddm.getKode_ongkir());
                }
                if(ddm.getNama_kota()!= null){
                    dto.setNama_kota(ddm.getNama_kota());
                }
                if(ddm.getHarga()!= null){
                    dto.setHarga(ddm.getHarga());
                }
            }
        }
        return dto;
    }

    @Override
    public void doUpdateDataOngkir(OngkirDto ongkirDto) throws Exception {
        OngkirModel ddm = new OngkirModel();
        try {
            ddm.setKode_ongkir(ongkirDto.getKode_ongkir());
            ddm.setNama_kota(ongkirDto.getNama_kota());
            ddm.setHarga(ongkirDto.getHarga());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ongkirDao.updateOngkir(ddm);
    }
}
