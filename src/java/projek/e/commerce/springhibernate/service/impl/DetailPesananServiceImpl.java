/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import projek.e.commerce.springhibernate.dao.DetailPesananDao;
import projek.e.commerce.springhibernate.dto.DetailPesananDto;
import projek.e.commerce.springhibernate.model.DetailPesananModel;
import projek.e.commerce.springhibernate.service.DetailPesananService;

/**
 *
 * @author amelia.yuniar
 */
public class DetailPesananServiceImpl implements DetailPesananService{
    
    @Autowired
    DetailPesananDao detailPesananDao;
    
    @Override
    public List<DetailPesananDto> getListDetailPesanan() throws Exception {
        List <DetailPesananDto> listDataDto = new ArrayList<>();
        List <DetailPesananModel> listData = detailPesananDao.getListDataDetailPesanan();
        DetailPesananDto detailPesananDto = null;
        try {
            if(listData != null){
                for(DetailPesananModel model : listData){
                    detailPesananDto = new DetailPesananDto();
                    if(model.getKode_detail_pesanan()!= null){
                        detailPesananDto.setKode_detail_pesanan(model.getKode_detail_pesanan());
                    }
                    if(model.getKode_pesanan()!= null){
                        detailPesananDto.setKode_pesanan(model.getKode_pesanan());
                    }
                    if(model.getKode_detail()!= null){
                        detailPesananDto.setKode_detail(model.getKode_detail());
                    }
                    if(model.getKuantitas()!= null){
                        detailPesananDto.setKuantitas(model.getKuantitas());
                    }
                    if(model.getTotal()!= null){
                        detailPesananDto.setTotal(model.getTotal());
                    }
                    
                    listDataDto.add(detailPesananDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listDataDto;
    }
    
    @Override
    public void saveDataDetailPesanan(DetailPesananDto detailPesananDto) throws Exception {
        DetailPesananModel detailPesananModel = new DetailPesananModel();
        List<DetailPesananModel> listData=detailPesananDao.getListDataDetailPesanan();
        int a=0;
        for(DetailPesananModel model : listData){
            String tam=model.getKode_detail_pesanan();
            String tamp=tam.substring(5);
            if(a<Integer.parseInt(tamp)){
                a=Integer.parseInt(tamp);
            }
        }
        a+=1;
        String kodeDtl="DTP-"+a+"";
        try {
            detailPesananModel.setKode_detail_pesanan(kodeDtl);
            detailPesananModel.setKode_pesanan(detailPesananDto.getKode_pesanan());
            detailPesananModel.setKode_detail(detailPesananDto.getKode_detail());
            detailPesananModel.setKuantitas(detailPesananDto.getKuantitas());
            detailPesananModel.setTotal(detailPesananDto.getTotal());
            
            detailPesananDao.saveDataDetailPesanan(detailPesananModel);
                       
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public DetailPesananModel getDetailPesananById(String id) {
        DetailPesananModel detailPesananModel = null;
        try {
            detailPesananModel = detailPesananDao.getDetailPesananById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return detailPesananModel;
    }

    @Override
    public void deleteDataDetailPesanan(String kode_detail_pesanan) throws Exception {
        try {
            detailPesananDao.deleteDetailPesanan(kode_detail_pesanan);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public DetailPesananDto getUpdateDataDetailPesanan(String kode_detail_pesanan) throws Exception {
        List<DetailPesananModel> dataList = detailPesananDao.getListDetailPesananUpdate(kode_detail_pesanan);
        DetailPesananDto detailPesananDto = new DetailPesananDto();
        if(dataList != null){
            for (DetailPesananModel model : dataList) {       
                if(model.getKode_detail_pesanan()!= null){
                        detailPesananDto.setKode_detail_pesanan(model.getKode_detail_pesanan());
                    }
                    if(model.getKode_pesanan()!= null){
                        detailPesananDto.setKode_pesanan(model.getKode_pesanan());
                    }
                    if(model.getKode_detail()!= null){
                        detailPesananDto.setKode_detail(model.getKode_detail());
                    }
                    if(model.getKuantitas()!= null){
                        detailPesananDto.setKuantitas(model.getKuantitas());
                    }
                    if(model.getTotal()!= null){
                        detailPesananDto.setTotal(model.getTotal());
                    }
            }
        }
        return detailPesananDto;
    }

    @Override
    public void doUpdateDataDetailPesanan(DetailPesananDto detailPesananDto) throws Exception {
        DetailPesananModel detailPesananModel = new DetailPesananModel();
        try {
            detailPesananModel.setKode_detail_pesanan(detailPesananDto.getKode_detail_pesanan());
            detailPesananModel.setKode_pesanan(detailPesananDto.getKode_pesanan());
            detailPesananModel.setKode_detail(detailPesananDto.getKode_detail());
            detailPesananModel.setKuantitas(detailPesananDto.getKuantitas());
            detailPesananModel.setTotal(detailPesananDto.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
        }
        detailPesananDao.updateDetailPesanan(detailPesananModel);
    }
}
