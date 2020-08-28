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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projek.e.commerce.springhibernate.dao.ProdukDao;
import projek.e.commerce.springhibernate.dto.ProdukDto;
import projek.e.commerce.springhibernate.model.ProdukModel;
import projek.e.commerce.springhibernate.service.ProdukService;

/**
 *
 * @author HP
 */
@Service
@Transactional
public class ProdukServiceImpl implements ProdukService {

    @Autowired
    ProdukDao produkDao;

    @Override
    public List<ProdukDto> getListProduk() {
        List<ProdukDto> listDataDto = new ArrayList<>();
        List<ProdukModel> listData = null;
        try {
            listData = produkDao.getListDataProduk();
        } catch (Exception ex) {
            Logger.getLogger(ProdukServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ProdukDto produkDto = null;
        try {
            if (listData != null) {
                for (ProdukModel model : listData) {
                    produkDto = new ProdukDto();
                    if (model.getKode_produk() != null) {
                        produkDto.setKode_produk(model.getKode_produk());
                    }
                    if (model.getKode_kategori() != null) {
                        produkDto.setKode_kategori(model.getKode_kategori());
                    }
                    if (model.getNama_produk() != null) {
                        produkDto.setNama_produk(model.getNama_produk());
                    }
                    if (model.getHarga_jual() != null) {
                        produkDto.setHarga_jual(model.getHarga_jual());
                    }
                    if (model.getBerat() != null) {
                        produkDto.setBerat(model.getBerat());
                    }
                    if (model.getKeterangan_produk() != null) {
                        produkDto.setKeterangan_produk(model.getKeterangan_produk());
                    }

                    listDataDto.add(produkDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDataDto;
    }

    @Override
    public List<ProdukDto> getProdukById(String id) {
        List<ProdukDto> listDataDto = new ArrayList<>();
        List<ProdukModel> listData = null;
        try {
            listData = (List<ProdukModel>) produkDao.getProdukById(id);
        } catch (Exception ex) {
            Logger.getLogger(ProdukServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ProdukDto produkDto = null;
        try {
            if (listData != null) {
                for (ProdukModel model : listData) {
                    produkDto = new ProdukDto();
                    if (model.getKode_produk() != null) {
                        produkDto.setKode_produk(model.getKode_produk());
                    }
                    if (model.getKode_kategori() != null) {
                        produkDto.setKode_kategori(model.getKode_kategori());
                    }
                    if (model.getNama_produk() != null) {
                        produkDto.setNama_produk(model.getNama_produk());
                    }
                    if (model.getHarga_jual() != null) {
                        produkDto.setHarga_jual(model.getHarga_jual());
                    }
                    if (model.getBerat() != null) {
                        produkDto.setBerat(model.getBerat());
                    }
                    if (model.getKeterangan_produk() != null) {
                        produkDto.setKeterangan_produk(model.getKeterangan_produk());
                    }

                    listDataDto.add(produkDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDataDto;
    }

    @Override
    public void doUpdateDataProduk(ProdukDto produkDto) throws Exception {
        ProdukModel dataModel = new ProdukModel();
        try {
            dataModel.setKode_produk(produkDto.getKode_produk());
            dataModel.setKode_kategori(produkDto.getKode_kategori());
            dataModel.setNama_produk(produkDto.getNama_produk());
            dataModel.setHarga_jual(produkDto.getHarga_jual());
            dataModel.setBerat(produkDto.getBerat());
            dataModel.setKeterangan_produk(produkDto.getKeterangan_produk());
        } catch (Exception e) {
            e.printStackTrace();
        }
        produkDao.updateProduk(dataModel);
    }

    @Override
    public void saveDataProduk(ProdukDto produkDto) throws Exception {
        ProdukModel produkModel = new ProdukModel();
        List<ProdukModel> listData=produkDao.getListDataProduk();
        try {
            int p=0;
            for(ProdukModel model : listData){
                String tam=model.getKode_produk();
                String tamp=tam.substring(4);
                if(p<Integer.parseInt(tamp)){
                    p=Integer.parseInt(tamp);
                }
            }
            p+=1;
            String kode="PROD"+p+"";
            produkModel.setKode_produk(kode);
            produkModel.setKode_kategori(produkDto.getKode_kategori());
            produkModel.setNama_produk(produkDto.getNama_produk());
            produkModel.setHarga_jual(produkDto.getHarga_jual());
            produkModel.setBerat(produkDto.getBerat());
            produkModel.setKeterangan_produk(produkDto.getKeterangan_produk());
            
            produkDao.saveDataProduk(produkModel);
                       
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDataProduk(String kode_produk) throws Exception {
        try {
            produkDao.deleteProduk(kode_produk);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ProdukDto getUpdateDataProduk(String kode_produk) throws Exception {
        List<ProdukModel> dataList = produkDao.getListProdukUpdate(kode_produk);
        ProdukDto dto = new ProdukDto();
        if (dataList != null) {
            for (ProdukModel ddm : dataList) {
                if (ddm.getKode_produk() != null) {
                    dto.setKode_produk(ddm.getKode_produk());
                }
                if (ddm.getKode_kategori() != null) {
                    dto.setKode_kategori(ddm.getKode_kategori());
                }
                if (ddm.getNama_produk() != null) {
                    dto.setNama_produk(ddm.getNama_produk());
                }
                if (ddm.getHarga_jual() != null) {
                    dto.setHarga_jual(ddm.getHarga_jual());
                }
                if (ddm.getBerat() != null) {
                    dto.setBerat(ddm.getBerat());
                }
                if (ddm.getKeterangan_produk() != null) {
                    dto.setKeterangan_produk(ddm.getKeterangan_produk());
                }
            }
        }
        return dto;
    }

    @Override
    public List<ProdukDto> getProdukByKategori(String kode_kategori) {
        List<ProdukDto> listDataDto = new ArrayList<>();
        List<ProdukModel> listData = null;
        try {
            listData = (List<ProdukModel>) produkDao.getListProdukByKategori(kode_kategori);
        } catch (Exception ex) {
            Logger.getLogger(ProdukServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ProdukDto produkDto = null;
        try {
            if (listData != null) {
                for (ProdukModel model : listData) {
                    produkDto = new ProdukDto();
                    if (model.getKode_produk() != null) {
                        produkDto.setKode_produk(model.getKode_produk());
                    }
                    if (model.getKode_kategori() != null) {
                        produkDto.setKode_kategori(model.getKode_kategori());
                    }
                    if (model.getNama_produk() != null) {
                        produkDto.setNama_produk(model.getNama_produk());
                    }
                    if (model.getHarga_jual() != null) {
                        produkDto.setHarga_jual(model.getHarga_jual());
                    }
                    if (model.getBerat() != null) {
                        produkDto.setBerat(model.getBerat());
                    }
                    if (model.getKeterangan_produk() != null) {
                        produkDto.setKeterangan_produk(model.getKeterangan_produk());
                    }

                    listDataDto.add(produkDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDataDto;
    }
}
