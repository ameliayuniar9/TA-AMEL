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
import projek.e.commerce.springhibernate.dao.KecamatanDao;
import projek.e.commerce.springhibernate.dao.KotaDao;
import projek.e.commerce.springhibernate.dao.OngkirDao;
import projek.e.commerce.springhibernate.dao.PenerimaDao;
import projek.e.commerce.springhibernate.dao.ProvinsiDao;
import projek.e.commerce.springhibernate.dto.PenerimaDto;
import projek.e.commerce.springhibernate.model.KecamatanModel;
import projek.e.commerce.springhibernate.model.KotaModel;
import projek.e.commerce.springhibernate.model.OngkirModel;
import projek.e.commerce.springhibernate.model.PenerimaModel;
import projek.e.commerce.springhibernate.model.ProvinsiModel;
import projek.e.commerce.springhibernate.service.PenerimaService;

/**
 *
 * @author HP
 */
@Service
public class PenerimaServiceImpl implements PenerimaService{
    
    @Autowired
    PenerimaDao penerimaDao;
    
    @Autowired
    ProvinsiDao provinsiDao;
    
    @Autowired
    KotaDao kotaDao;
    
    @Autowired
    OngkirDao OngkirDao;
    
    @Autowired
    KecamatanDao kecamatanDao;
    
    @Override
    public List<PenerimaDto> getListPenerima() throws Exception {
        List <PenerimaDto> listDataDto = new ArrayList<>();
        List <PenerimaModel> listData = penerimaDao.getListDataPenerima();
        PenerimaDto penerimaDto = null;
        try {
            if(listData != null){
                for(PenerimaModel model : listData){
                    penerimaDto = new PenerimaDto();
                    if(model.getId_penerima()!= null){
                        penerimaDto.setId_penerima(model.getId_penerima());
                    }
                    if(model.getId_pembeli()!=null){
                        penerimaDto.setId_pembeli(model.getId_pembeli());
                    }
                    if(model.getNama_penerima()!= null){
                        penerimaDto.setNama_penerima(model.getNama_penerima());
                    }
                    if(model.getNo_telp()!= null){
                        penerimaDto.setNo_telp(model.getNo_telp());
                    }
                    if(model.getProvinsi()!= null){
                        penerimaDto.setProvinsi(model.getProvinsi());
                    }
                    if(model.getKabupaten()!= null){
                        penerimaDto.setKabupaten(model.getKabupaten());
                    }
                    if(model.getKecamatan()!= null){
                        penerimaDto.setKecamatan(model.getKecamatan());
                    }
                    if(model.getAlamat_lengkap()!= null){
                        penerimaDto.setAlamat_lengkap(model.getAlamat_lengkap());
                    }
                    if(model.getStatus()!= null){
                        penerimaDto.setStatus(model.getStatus());
                    }
                    
                    listDataDto.add(penerimaDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listDataDto;
    }
    
    
    @Override
    public void saveDataPenerima(PenerimaDto penerimaDto) throws Exception {
        PenerimaModel penerimaModel = new PenerimaModel();
        ProvinsiModel provinsiModel=provinsiDao.getProvinsiModelById(penerimaDto.getProvinsi());
        KotaModel kotaModel=kotaDao.getKotaModelById(penerimaDto.getKabupaten());
        KecamatanModel kecamatanModel=kecamatanDao.getKecamatanModelById(penerimaDto.getKecamatan());
        List<PenerimaModel> listData=penerimaDao.getListDataPenerima();
        int b=1;
        for(PenerimaModel model : listData){
            String tam=model.getId_penerima();
            String tamp=tam.substring(4);
            if(b<Integer.parseInt(tamp)){
                b=Integer.parseInt(tamp);
            }
        }
        b+=1;
        String id_pen="PEN-"+b+"";
        try {
            penerimaModel.setId_penerima(id_pen);
            penerimaModel.setId_pembeli(penerimaDto.getId_penerima());
            penerimaModel.setNama_penerima(penerimaDto.getNama_penerima());
            penerimaModel.setNo_telp(penerimaDto.getNo_telp());
            penerimaModel.setProvinsi(provinsiModel.getNama());
            penerimaModel.setKabupaten(kotaModel.getNama());
            penerimaModel.setKecamatan(kecamatanModel.getNama());
            penerimaModel.setAlamat_lengkap(penerimaDto.getAlamat_lengkap());
            penerimaModel.setStatus("IN_ACTIVE");
            
            penerimaDao.saveDataPenerima(penerimaModel);
                       
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public PenerimaModel getPenerimaById(String id) {
        PenerimaModel penerimaModel = null;
        try {
            penerimaModel = penerimaDao.getPenerimaModelById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return penerimaModel;
    }

    @Override
    public void deleteDataPenerima(String id_penerima) throws Exception {
        try {
            penerimaDao.deletePenerima(id_penerima);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public PenerimaDto getUpdateDataPenerima(String id_penerima) throws Exception {
        List<PenerimaModel> dataList = penerimaDao.getListPenerimaUpdate(id_penerima);
        PenerimaDto penerimaDto = new PenerimaDto();
        if(dataList != null){
            for (PenerimaModel model : dataList) {      
                if(model.getId_penerima()!= null){
                        penerimaDto.setId_penerima(model.getId_penerima());
                    }
                    if(model.getId_pembeli()!=null){
                        penerimaDto.setId_pembeli(model.getId_pembeli());
                    }
                    if(model.getNama_penerima()!= null){
                        penerimaDto.setNama_penerima(model.getNama_penerima());
                    }
                    if(model.getNo_telp()!= null){
                        penerimaDto.setNo_telp(model.getNo_telp());
                    }
                    if(model.getProvinsi()!= null){
                        penerimaDto.setProvinsi(model.getProvinsi());
                    }
                    if(model.getKabupaten()!= null){
                        penerimaDto.setKabupaten(model.getKabupaten());
                    }
                    if(model.getKecamatan()!= null){
                        penerimaDto.setKecamatan(model.getKecamatan());
                    }
                    if(model.getAlamat_lengkap()!= null){
                        penerimaDto.setAlamat_lengkap(model.getAlamat_lengkap());
                    }
                    if(model.getStatus()!= null){
                        penerimaDto.setStatus(model.getStatus());
                    }
            }
        }
        return penerimaDto;
    }

    @Override
    public void doUpdateDataPenerima(PenerimaDto penerimaDto) throws Exception {
        PenerimaModel penerimaModel= new PenerimaModel();
        ProvinsiModel provinsiModel=provinsiDao.getProvinsiModelById(penerimaDto.getProvinsi());
        KotaModel kotaModel=kotaDao.getKotaModelById(penerimaDto.getKabupaten());
        KecamatanModel kecamatanModel=kecamatanDao.getKecamatanModelById(penerimaDto.getKecamatan());
        try {
            penerimaModel.setId_penerima(penerimaDto.getId_penerima());
            penerimaModel.setId_pembeli(penerimaDto.getId_pembeli());
            penerimaModel.setNama_penerima(penerimaDto.getNama_penerima());
            penerimaModel.setNo_telp(penerimaDto.getNo_telp());
            penerimaModel.setProvinsi(provinsiModel.getNama());
            penerimaModel.setKabupaten(kotaModel.getNama());
            penerimaModel.setKecamatan(kecamatanModel.getNama());
            penerimaModel.setAlamat_lengkap(penerimaDto.getAlamat_lengkap());
            penerimaModel.setStatus("IN_ACTIVE");
        } catch (Exception e) {
            e.printStackTrace();
        }
        penerimaDao.updatePenerima(penerimaModel);
    }
    
    @Override
    public List<PenerimaDto> getListPenerimaById(String id_pembeli){
        List <PenerimaDto> listDataDto = new ArrayList<>();
        List <PenerimaModel> listData = penerimaDao.getListDataPenerimaById(id_pembeli);
        PenerimaDto penerimaDto = null;
        try {
            if(listData != null){
                for(PenerimaModel model : listData){
                    penerimaDto = new PenerimaDto();
                    if(model.getId_penerima()!= null){
                        penerimaDto.setId_penerima(model.getId_penerima());
                    }
                    if(model.getId_pembeli()!=null){
                        penerimaDto.setId_pembeli(model.getId_pembeli());
                    }
                    if(model.getNama_penerima()!= null){
                        penerimaDto.setNama_penerima(model.getNama_penerima());
                    }
                    if(model.getNo_telp()!= null){
                        penerimaDto.setNo_telp(model.getNo_telp());
                    }
                    if(model.getProvinsi()!= null){
                        penerimaDto.setProvinsi(model.getProvinsi());
                    }
                    if(model.getKabupaten()!= null){
                        penerimaDto.setKabupaten(model.getKabupaten());
                        try{
                            OngkirModel dd=(OngkirModel) OngkirDao.getOngkir(penerimaDto.getKabupaten());
                            penerimaDto.setHarga(dd.getHarga());
                        }catch(Exception e){
                            penerimaDto.setHarga(0);
                        }
                        
                    }
                    if(model.getKecamatan()!= null){
                        penerimaDto.setKecamatan(model.getKecamatan());
                        
                    }
                    if(model.getAlamat_lengkap()!= null){
                        penerimaDto.setAlamat_lengkap(model.getAlamat_lengkap());
                    }
                    if(model.getStatus()!= null){
                        penerimaDto.setStatus(model.getStatus());
                    }
                    
                    listDataDto.add(penerimaDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listDataDto;
    }

    @Override
    public List<PenerimaDto> getPenerimaByKodePesanan(String kode_pesanan) throws Exception{
        List <PenerimaDto> listDataDto = new ArrayList<>();
        List <Object[]> listData = penerimaDao.getAlamatPenerima(kode_pesanan);
        PenerimaDto penerimaDto = null;
        try {
            if(listData != null){
                for(Object[] model : listData){
                    penerimaDto = new PenerimaDto();
                    penerimaDto.setNama_penerima(model[0].toString());
                    penerimaDto.setNo_telp(model[1].toString());
                    penerimaDto.setProvinsi(model[2].toString());
                    penerimaDto.setKabupaten(model[3].toString());
                    penerimaDto.setKecamatan(model[4].toString());
                    penerimaDto.setAlamat_lengkap(model[5].toString());
                    
                    
                    listDataDto.add(penerimaDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listDataDto;
    }
    
}
