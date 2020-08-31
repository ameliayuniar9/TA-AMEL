/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import projek.e.commerce.springhibernate.dao.ProvinsiDao;
import projek.e.commerce.springhibernate.dto.ProvinsiDto;
import projek.e.commerce.springhibernate.model.ProvinsiModel;
import projek.e.commerce.springhibernate.service.ProvinsiService;

/**
 *
 * @author amelia.yuniar
 */
public class ProvinsiServiceImpl implements ProvinsiService{
    
    @Autowired
    ProvinsiDao provinsiDao;

    @Override
    public List<ProvinsiDto> getListProvinsi() throws Exception {
        List<ProvinsiDto> listDataDto=new ArrayList<>();
        List<ProvinsiModel> listData=provinsiDao.getListDataProvinsi();
        ProvinsiDto provinsiDto = null;
        try {
            if(listData != null){
                for(ProvinsiModel model : listData){
                    provinsiDto = new ProvinsiDto();
                    if(model.getId_provinsi()!= null){
                        provinsiDto.setId_provinsi(model.getId_provinsi());
                    }
                    if(model.getNama()!= null){
                        provinsiDto.setNama(model.getNama());
                    }
                    
                    listDataDto.add(provinsiDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listDataDto;
    }
}
