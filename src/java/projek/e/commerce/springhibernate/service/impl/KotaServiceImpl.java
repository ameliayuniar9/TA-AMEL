/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import projek.e.commerce.springhibernate.dao.KotaDao;
import projek.e.commerce.springhibernate.dao.ProvinsiDao;
import projek.e.commerce.springhibernate.dto.KotaDto;
import projek.e.commerce.springhibernate.dto.TampMainDto;
import projek.e.commerce.springhibernate.model.KotaModel;
import projek.e.commerce.springhibernate.model.ProvinsiModel;
import projek.e.commerce.springhibernate.service.KotaService;

/**
 *
 * @author amelia.yuniar
 */
public class KotaServiceImpl implements KotaService{
    @Autowired
    KotaDao kotaDao;
    
    @Autowired
    ProvinsiDao provinsiDao;

    @Override
    public List<KotaDto> getListKota() throws Exception {
        List<KotaDto> ListDto = new ArrayList<>();
        List<KotaModel> data = kotaDao.getListDataKota();
        try {
            if (data != null) {
                for (KotaModel ddm : data) {
                    KotaDto dto = new KotaDto();
                    if (ddm.getId_kota()!= null) {
                        dto.setId_kota(ddm.getId_kota());
                    }
                    if (ddm.getId_provinsi()!= null) {
                        dto.setId_provinsi(ddm.getId_provinsi());
                    }
                    if (ddm.getNama() != null) {
                        dto.setNama(ddm.getNama());
                    }
                    ListDto.add(dto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListDto;
    }

    @Override
    public List<KotaDto> getKotaById(String param) {
        List<KotaDto> ListDto = new ArrayList<>();
        List<KotaModel> data = null;
        try {
            data = kotaDao.getKotaById(param);
        } catch (Exception ex) {
            Logger.getLogger(KotaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (data != null) {
            for (KotaModel ddm : data) {
                KotaDto dto = new KotaDto();
                if (ddm.getId_kota()!= null) {
                    dto.setId_kota(ddm.getId_kota());
                }
                if (ddm.getId_provinsi()!= null) {
                    dto.setId_provinsi(ddm.getId_provinsi());
                }
                if (ddm.getNama() != null) {
                    dto.setNama(ddm.getNama());
                }
                ListDto.add(dto);
            }
        }
        return ListDto;
    }

    @Override
    public List<TampMainDto> getNama(String Prov, String Kota) {
        List<TampMainDto> ListDto = new ArrayList<>();
        KotaModel datakot = kotaDao.getKotaModelById(Kota);
        ProvinsiModel dataprov = provinsiDao.getProvinsiModelById(Prov);
        
        TampMainDto dto = new TampMainDto();
        dto.setKode(Prov);
        dto.setNama(dataprov.getNama());
        ListDto.add(dto);
        TampMainDto dto2 = new TampMainDto();
        dto2.setKode(Kota);
        dto2.setNama(datakot.getNama());
        ListDto.add(dto2);
        
        return ListDto;
    }
    
}
