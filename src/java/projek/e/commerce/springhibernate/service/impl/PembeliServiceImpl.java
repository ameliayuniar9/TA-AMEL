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
import projek.e.commerce.springhibernate.dao.LoginDao;
import projek.e.commerce.springhibernate.dao.PembeliDao;
import projek.e.commerce.springhibernate.dto.PembeliDto;
import projek.e.commerce.springhibernate.model.LoginModel;
import projek.e.commerce.springhibernate.model.PembeliModel;
import projek.e.commerce.springhibernate.model.ProdukModel;
import projek.e.commerce.springhibernate.service.PembeliService;

/**
 *
 * @author HP
 */
@Service
@Transactional
public class PembeliServiceImpl implements PembeliService{

    @Autowired
    PembeliDao pembeliDao;
    
    @Autowired
    LoginDao loginDao;

    @Override
    public List<PembeliDto> getListPembeli() throws Exception {
        List <PembeliDto> listDataDto = new ArrayList<>();
        List <PembeliModel> listData = null;
        try {
            listData=pembeliDao.getListDataPembeli();
        } catch (Exception ex) {
            Logger.getLogger(PembeliServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        PembeliDto pembeliDto = null;
        try {
            if(listData != null){
                for(PembeliModel model : listData){
                    pembeliDto = new PembeliDto();
                    if(model.getId_pembeli()!= null){
                        pembeliDto.setId_pembeli(model.getId_pembeli());
                    }
                    if(model.getNama()!= null){
                        pembeliDto.setNama(model.getNama());
                    }
                    if(model.getUsername()!= null){
                        pembeliDto.setUsername(model.getUsername());
                    }
                    if(model.getPassword()!= null){
                        pembeliDto.setPassword(model.getPassword());
                    }
                    if(model.getAlamat()!= null){
                        pembeliDto.setAlamat(model.getAlamat());
                    }
                    if(model.getEmail()!= null){
                        pembeliDto.setEmail(model.getEmail());
                    }
                    if(model.getNo_telp()!= null){
                        pembeliDto.setNo_telp(model.getNo_telp());
                    }
                    if(model.getFoto()!= null){
                        pembeliDto.setFoto(model.getFoto());
                    }
                    
                    listDataDto.add(pembeliDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listDataDto;
    }

    @Override
    public List<PembeliDto> getPembeliById(String id) {
        List <PembeliDto> listDataDto = new ArrayList<>();
        List <PembeliModel> listData = null;
        try {
            listData = (List<PembeliModel>) pembeliDao.getPembeliById(id);
        } catch (Exception ex) {
            Logger.getLogger(PembeliServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        PembeliDto pembeliDto = null;
        try {
            if(listData != null){
                for(PembeliModel model : listData){
                    pembeliDto = new PembeliDto();
                    if(model.getId_pembeli()!= null){
                        pembeliDto.setId_pembeli(model.getId_pembeli());
                    }
                    if(model.getNama()!= null){
                        pembeliDto.setNama(model.getNama());
                    }
                    if(model.getUsername()!= null){
                        pembeliDto.setUsername(model.getUsername());
                    }
                    if(model.getPassword()!= null){
                        pembeliDto.setPassword(model.getPassword());
                    }
                    if(model.getAlamat()!= null){
                        pembeliDto.setAlamat(model.getAlamat());
                    }
                    if(model.getEmail()!= null){
                        pembeliDto.setEmail(model.getEmail());
                    }
                    if(model.getNo_telp()!= null){
                        pembeliDto.setNo_telp(model.getNo_telp());
                    }
                    if(model.getFoto()!= null){
                        pembeliDto.setFoto(model.getFoto());
                    }
                    
                    listDataDto.add(pembeliDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listDataDto;
    }

    @Override
    public void doUpdateDataPembeli(PembeliDto pembeliDto) throws Exception {
        PembeliModel dataModel = new PembeliModel();
        try {
            dataModel.setId_pembeli(pembeliDto.getId_pembeli());
            dataModel.setNama(pembeliDto.getNama());
            dataModel.setNo_telp(pembeliDto.getNo_telp());
            dataModel.setAlamat(pembeliDto.getAlamat());
            dataModel.setUsername(pembeliDto.getUsername());
            dataModel.setPassword(pembeliDto.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
        pembeliDao.updatePembeli(dataModel);
    }

    @Override
    public void saveDataPembeli(PembeliDto pembeliDto) throws Exception {
        PembeliModel dataModel = new PembeliModel();
        LoginModel loginModel=new LoginModel();
        List<PembeliModel> listData=pembeliDao.getListDataPembeli();
        List<LoginModel> listLogin=loginDao.getListDataUser();
        int a=0;
        int b=0;
        for(PembeliModel model : listData){
            String tam=model.getId_pembeli();
            String tamp=tam.substring(5);
            if(a<Integer.parseInt(tamp)){
                a=Integer.parseInt(tamp);
            }
        }
        a+=1;
        String id_pem="20200"+a+"";
        dataModel.setId_pembeli(id_pem);
        dataModel.setNama(pembeliDto.getNama());
        dataModel.setUsername(pembeliDto.getUsername());
        dataModel.setPassword(pembeliDto.getPassword());
        dataModel.setAlamat(pembeliDto.getAlamat());
        dataModel.setEmail(pembeliDto.getEmail());
        dataModel.setNo_telp(pembeliDto.getNo_telp());
        dataModel.setFoto("null");
        
        for(LoginModel model : listLogin){
            String tam=model.getId_login();
            String tamp=tam.substring(4);
            if(b<Integer.parseInt(tamp)){
                b=Integer.parseInt(tamp);
            }
        }
        b+=1;
        String id_log="LOG-"+b+"";
        
        loginModel.setId_login(id_log);
        loginModel.setId_pembeli(id_pem);
        loginModel.setUsername(pembeliDto.getUsername());
        loginModel.setPassword(pembeliDto.getPassword());
        loginModel.setAkses("Pembeli");
        loginModel.setNama_lengkap(pembeliDto.getNama());

        pembeliDao.saveDataPembeli(dataModel);
        loginDao.saveLogin(loginModel);
    }

    @Override
    public void deleteDataPembeli(String id_pembeli) throws Exception {
        try {
            pembeliDao.deletePembeli(id_pembeli);
            loginDao.deleteLogin(id_pembeli);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public PembeliDto getUpdateDataPembeli(String id_pembeli) throws Exception {
        List<PembeliModel> dataList = pembeliDao.getListPembeliUpdate(id_pembeli);
        PembeliDto pembeliDto = new PembeliDto();
        if(dataList != null){
            for (PembeliModel model : dataList) {
                    if(model.getId_pembeli()!= null){
                        pembeliDto.setId_pembeli(model.getId_pembeli());
                    }
                    if(model.getNama()!= null){
                        pembeliDto.setNama(model.getNama());
                    }
                    if(model.getUsername()!= null){
                        pembeliDto.setUsername(model.getUsername());
                    }
                    if(model.getPassword()!= null){
                        pembeliDto.setPassword(model.getPassword());
                    }
                    if(model.getAlamat()!= null){
                        pembeliDto.setAlamat(model.getAlamat());
                    }
                    if(model.getEmail()!= null){
                        pembeliDto.setEmail(model.getEmail());
                    }
                    if(model.getNo_telp()!= null){
                        pembeliDto.setNo_telp(model.getNo_telp());
                    }
                    if(model.getFoto()!= null){
                        pembeliDto.setFoto(model.getFoto());
                    }
            }
        }
        return pembeliDto;
    }

    @Override
    public List<PembeliDto> getListLoginPembeli() throws Exception {
        List <PembeliDto> listDataDto = new ArrayList<>();
        List <PembeliModel> listData = pembeliDao.getListDataPembeli();
        PembeliDto pembeliDto = null;
        try {
            listData=pembeliDao.getListDataPembeli();
        } catch (Exception e) {
        }
        try {
            if(listData != null){
                for(PembeliModel model : listData){
                    pembeliDto = new PembeliDto();
                    if(model.getId_pembeli()!= null){
                        pembeliDto.setId_pembeli(model.getId_pembeli());
                    }
                    if(model.getNama()!= null){
                        pembeliDto.setNama(model.getNama());
                    }
                    if(model.getUsername()!= null){
                        pembeliDto.setUsername(model.getUsername());
                    }
                    if(model.getPassword()!= null){
                        pembeliDto.setPassword(model.getPassword());
                    }
                    if(model.getAlamat()!= null){
                        pembeliDto.setAlamat(model.getAlamat());
                    }
                    if(model.getEmail()!= null){
                        pembeliDto.setEmail(model.getEmail());
                    }
                    if(model.getNo_telp()!= null){
                        pembeliDto.setNo_telp(model.getNo_telp());
                    }
                    if(model.getFoto()!= null){
                        pembeliDto.setFoto(model.getFoto());
                    }
                    
                    listDataDto.add(pembeliDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listDataDto;
    }

    @Override
    public PembeliDto getListDataUserLoginPembeli(PembeliDto fromDto) throws Exception {
        List<PembeliModel> dataList=pembeliDao.getListLoginPembeli(fromDto);
        PembeliDto pembeliDto=new PembeliDto();
        try{
            if(dataList!=null){
            for (PembeliModel ddm : dataList) {       
                if(ddm.getId_pembeli()!= null){
                    pembeliDto.setId_pembeli(ddm.getId_pembeli());
                }
                if(ddm.getNama()!= null){
                    pembeliDto.setNama(ddm.getNama());
                }
                if(ddm.getNo_telp()!= null){
                    pembeliDto.setNo_telp(ddm.getNo_telp());
                }
                if(ddm.getAlamat()!= null){
                    pembeliDto.setAlamat(ddm.getAlamat());
                }
                if(ddm.getUsername()!= null){
                    pembeliDto.setUsername(ddm.getUsername());
                }
                if(ddm.getPassword()!= null){
                    pembeliDto.setPassword(ddm.getPassword());
                }
            }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return pembeliDto;
    } 
    
     @Override
    public List<PembeliDto> getListPembeliSelect(String id_pembeli) throws Exception {
        List <PembeliDto> listDataDto = new ArrayList<>();
        List <PembeliModel> listData = pembeliDao.getListDataPembeliSelect(id_pembeli);
        PembeliDto pembeliDto = null;
        try {
            if(listData != null){
                for(PembeliModel model : listData){
                    pembeliDto = new PembeliDto();
                    if(model.getId_pembeli()!= null){
                        pembeliDto.setId_pembeli(model.getId_pembeli());
                    }
                    if(model.getNama()!= null){
                        pembeliDto.setNama(model.getNama());
                    }
                    if(model.getNo_telp()!= null){
                        pembeliDto.setNo_telp(model.getNo_telp());
                    }
                    if(model.getAlamat()!= null){
                        pembeliDto.setAlamat(model.getAlamat());
                    }
                    if(model.getUsername()!= null){
                        pembeliDto.setUsername(model.getUsername());
                    }
                    if(model.getPassword()!= null){
                        pembeliDto.setPassword(model.getPassword());
                    }
                    
                    listDataDto.add(pembeliDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listDataDto;
    }
    
    @Override
    public PembeliDto getDataId(String user, String pass) throws Exception {
        List<PembeliDto> pembeli=new ArrayList<>();
        List<Object[]> obj=pembeliDao.getId(user, pass);
        PembeliDto dto=null;
        for(Object[] obb:obj){
            dto=new PembeliDto();
            dto.setId_pembeli(obb[0].toString());
        }
        return dto;
    }
}