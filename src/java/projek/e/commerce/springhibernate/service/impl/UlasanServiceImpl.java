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
import projek.e.commerce.springhibernate.dao.UlasanDao;
import projek.e.commerce.springhibernate.dto.UlasanDto;
import projek.e.commerce.springhibernate.model.UlasanModel;
import projek.e.commerce.springhibernate.service.UlasanService;


@Service
@Transactional
public class UlasanServiceImpl implements UlasanService{
    
    @Autowired
    UlasanDao ulasanDao;

    @Override
    public List<UlasanDto> getListReview() throws Exception {
        List<UlasanDto> listDataDto=new ArrayList<>();
        List<UlasanModel> listData=ulasanDao.getListDataReview();
        UlasanDto ulasanDto=null;
        try {
            if(listData!=null){
                for(UlasanModel model:listData){
                    ulasanDto=new UlasanDto();
                    if(model.getKode_ulasan()!=null){
                        ulasanDto.setKode_ulasan(model.getKode_ulasan());
                    }
                    if(model.getVideo()!=null){
                        ulasanDto.setVideo(model.getVideo());
                    }
                    if(model.getKeterangan()!=null){
                        ulasanDto.setKeterangan(model.getKeterangan());
                    }
                    listDataDto.add(ulasanDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDataDto;
    }

    @Override
    public void saveDataReview(UlasanDto ulasanDto) throws Exception {
        UlasanModel ulasanModel=new UlasanModel();
        List<UlasanModel> listData=ulasanDao.getListDataReview();
        int p=0;
        for(UlasanModel model : listData){
            String tam=model.getKode_ulasan();
            String tamp=tam.substring(4);
            if(p<Integer.parseInt(tamp)){
                p=Integer.parseInt(tamp);
            }
        }
        p+=1;
        String kode="REV-"+p+"";
        try {
            ulasanModel.setKode_ulasan(kode);
            ulasanModel.setVideo(ulasanDto.getFile().getOriginalFilename());
            ulasanModel.setKeterangan(ulasanDto.getKeterangan());

            ulasanDao.saveDataReview(ulasanModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public UlasanModel getReviewByKode(String kode_ulasan) {
        UlasanModel ulasanModel=null;
        try {
            ulasanModel=ulasanDao.getReviewModelById(kode_ulasan);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ulasanModel;
    }

    @Override
    public void deleteDataReview(String kode_ulasan) throws Exception {
        try {
            ulasanDao.getReviewModelById(kode_ulasan);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public UlasanDto getUpdateDataReview(String kode_ulasan) throws Exception {
        List<UlasanDto> listDataDto=new ArrayList<>();
        List<UlasanModel> listData=ulasanDao.getListReviewUpdate(kode_ulasan);
        UlasanDto ulasanDto=null;
        try {
            if(listData!=null){
                for(UlasanModel model:listData){
                    ulasanDto=new UlasanDto();
                    if(model.getKode_ulasan()!=null){
                        ulasanDto.setKode_ulasan(model.getKode_ulasan());
                    }
                    if(model.getVideo()!=null){
                        ulasanDto.setVideo(model.getVideo());
                    }
                    if(model.getKeterangan()!=null){
                        ulasanDto.setKeterangan(model.getKeterangan());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ulasanDto;
    }

    @Override
    public void doUpdateDataReview(UlasanDto ulasanDto) throws Exception {
        UlasanModel reviewModel=new UlasanModel();
        try {
            reviewModel.setKode_ulasan(ulasanDto.getKode_ulasan());
            reviewModel.setVideo(ulasanDto.getFile().getOriginalFilename());
            reviewModel.setKeterangan(ulasanDto.getKeterangan());

            ulasanDao.updateReview(reviewModel);
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }    
    
}
