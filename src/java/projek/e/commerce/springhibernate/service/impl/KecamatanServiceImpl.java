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
import projek.e.commerce.springhibernate.dao.KecamatanDao;
import projek.e.commerce.springhibernate.dao.KotaDao;
import projek.e.commerce.springhibernate.dto.KecamatanDto;
import projek.e.commerce.springhibernate.dto.TampMainDto;
import projek.e.commerce.springhibernate.model.KecamatanModel;
import projek.e.commerce.springhibernate.model.KotaModel;
import projek.e.commerce.springhibernate.service.KecamatanService;

/**
 *
 * @author amelia.yuniar
 */
public class KecamatanServiceImpl implements KecamatanService {

    @Autowired
    KecamatanDao kecamatanDao;
    
    @Autowired
    KotaDao kotaDao;

    @Override
    public List<KecamatanDto> getListKecamatan() throws Exception {
        List<KecamatanDto> ListDto = new ArrayList<>();
        List<KecamatanModel> data = kecamatanDao.getListDataKecamatan();
        try {
            if (data != null) {
                for (KecamatanModel ddm : data) {
                    KecamatanDto dto = new KecamatanDto();
                    if (ddm.getId_kecamatan() != null) {
                        dto.setId_kecamatan(ddm.getId_kecamatan());
                    }
                    if (ddm.getId_kota() != null) {
                        dto.setId_kota(ddm.getId_kota());
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
    public List<KecamatanDto> getListKecamatanById(String param) {
        List<KecamatanDto> ListDto = new ArrayList<>();
        List<KecamatanModel> data = null;
        try {
            data = kecamatanDao.getKecamatanById(param);
        } catch (Exception ex) {
            Logger.getLogger(KecamatanServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (data != null) {
            for (KecamatanModel ddm : data) {
                KecamatanDto dto = new KecamatanDto();
                if (ddm.getId_kecamatan() != null) {
                    dto.setId_kecamatan(ddm.getId_kecamatan());
                }
                if (ddm.getId_kota() != null) {
                    dto.setId_kota(ddm.getId_kota());
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
    public List<TampMainDto> getNama(String Kota, String Kec) {
        List<TampMainDto> ListDto = new ArrayList<>();
        KecamatanModel datakec = kecamatanDao.getKecamatanModelById(Kec);
        KotaModel datakot = kotaDao.getKotaModelById(Kota);

        TampMainDto dto = new TampMainDto();
        dto.setKode(Kota);
        dto.setNama(datakot.getNama());
        ListDto.add(dto);
        TampMainDto dto2 = new TampMainDto();
        dto2.setKode(Kec);
        dto2.setNama(datakec.getNama());
        ListDto.add(dto2);
        
        return ListDto;
    }

}
