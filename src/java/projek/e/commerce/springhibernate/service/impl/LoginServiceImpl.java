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
import projek.e.commerce.springhibernate.dao.LoginDao;
import projek.e.commerce.springhibernate.dto.LoginDto;
import projek.e.commerce.springhibernate.model.LoginModel;
import projek.e.commerce.springhibernate.service.LoginService;

/**
 *
 * @author HP
 */
@Service
@Transactional
public class LoginServiceImpl implements LoginService{
    @Autowired
    LoginDao loginDao; 
    
    @Override
    public List<LoginDto> getListLogin() throws Exception {
        List <LoginDto> listDataDto = new ArrayList<>();
        List <LoginModel> listData = loginDao.getListDataUser();
        LoginDto loginDto = null;
        try {
            listData=loginDao.getListDataUser();
        } catch (Exception e) {
        }
        try {
            if(listData != null){
                for(LoginModel model : listData){
                    loginDto = new LoginDto();
                    if(model.getId_login()!= null){
                        loginDto.setId_login(model.getId_login());
                    }
                    if(model.getUsername()!= null){
                        loginDto.setUsername(model.getUsername());
                    }
                    if(model.getPassword()!= null){
                        loginDto.setPassword(model.getPassword());
                    }
                    if(model.getAkses()!= null){
                        loginDto.setAkses(model.getAkses());
                    }
                    if(model.getId_pembeli()!= null){
                        loginDto.setId_pembeli(model.getId_pembeli());
                    }
                    if(model.getNama_lengkap()!= null){
                        loginDto.setNama_lengkap(model.getNama_lengkap());
                    }
                    
                    listDataDto.add(loginDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listDataDto;
    }

    @Override
    public LoginDto getListDataUserLogin(LoginDto fromDto) throws Exception {
       List<LoginModel> dataList=loginDao.getListDataLogin(fromDto);
        LoginDto loginDto=new LoginDto();
        try{
            if(dataList!=null){
            for(LoginModel ddm : dataList){
                if(ddm.getId_login()!=null){
                    loginDto.setId_login(ddm.getId_login());
                }
                if(ddm.getUsername()!=null){
                    loginDto.setUsername(ddm.getUsername());
                }
                if(ddm.getPassword()!=null){
                    loginDto.setPassword(ddm.getPassword());
                }
                if(ddm.getAkses()!=null){
                    loginDto.setAkses(ddm.getAkses());
                }
                if(ddm.getId_pembeli()!=null){
                    loginDto.setId_pembeli(ddm.getId_pembeli());
                }
                if(ddm.getNama_lengkap()!=null){
                    loginDto.setNama_lengkap(ddm.getNama_lengkap());
                }
            }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return loginDto;
    }

    @Override
    public void saveDataLogin(LoginDto loginDto) throws Exception {
        LoginModel loginModel = new LoginModel();
        List<LoginModel> listData=loginDao.getListDataLogin(loginDto);
        try {
            int b=0;
            for(LoginModel model : listData){
                String tam=model.getId_login();
                String tamp=tam.substring(4);
                if(b<Integer.parseInt(tamp)){
                    b=Integer.parseInt(tamp);
                }
            }
            b+=1;
            String id="LOG-"+b+"";
            loginModel.setId_login(id);
            loginModel.setUsername(loginDto.getUsername());
            loginModel.setPassword(loginDto.getPassword());
            loginModel.setAkses("Admin");
            loginModel.setId_pembeli("NULL");
            loginModel.setNama_lengkap(loginDto.getNama_lengkap());
            
            loginDao.saveLogin(loginModel);
                       
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public LoginModel getLoginById(String id) {
        LoginModel loginModel = null;
        try {
            loginModel = loginDao.getLoginById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loginModel;
    }

    @Override
    public void deleteDataLogin(String id_login) throws Exception {
        try {
            loginDao.deleteLogin(id_login);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public LoginDto getUpdateDataLogin(String id_login) throws Exception {
        List<LoginModel> dataList = loginDao.getListDataUserSelect(id_login);
        LoginDto loginDto=new LoginDto();
        if(dataList != null){
            for (LoginModel ddm : dataList) {       
                if(ddm.getId_login()!=null){
                    loginDto.setId_login(ddm.getId_login());
                }
                if(ddm.getUsername()!=null){
                    loginDto.setUsername(ddm.getUsername());
                }
                if(ddm.getPassword()!=null){
                    loginDto.setPassword(ddm.getPassword());
                }
                if(ddm.getAkses()!=null){
                    loginDto.setAkses(ddm.getAkses());
                }
                if(ddm.getId_pembeli()!=null){
                    loginDto.setId_pembeli(ddm.getId_pembeli());
                }
                if(ddm.getNama_lengkap()!=null){
                    loginDto.setNama_lengkap(ddm.getNama_lengkap());
                }
            }
        }
        return loginDto;
    }

    @Override
    public void doUpdateDataLogin(LoginDto loginDto) throws Exception {
        LoginModel loginModel = new LoginModel();
        try {
            loginModel.setId_login(loginDto.getId_login());
            loginModel.setUsername(loginDto.getUsername());
            loginModel.setPassword(loginDto.getPassword());
            loginModel.setAkses("Admin");
            loginModel.setId_pembeli("NULL");
            loginModel.setNama_lengkap(loginDto.getNama_lengkap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        loginDao.updateLogin(loginModel);
    }
    
    @Override
    public List<LoginDto> getListLoginAdmin() throws Exception {
        List <LoginDto> listDataDto = new ArrayList<>();
        List <LoginModel> listData = loginDao.getListDataUserAdmin();
        LoginDto loginDto = null;
        try {
            listData=loginDao.getListDataUserAdmin();
        } catch (Exception e) {
        }
        try {
            if(listData != null){
                for(LoginModel model : listData){
                    loginDto = new LoginDto();
                    if(model.getId_login()!= null){
                        loginDto.setId_login(model.getId_login());
                    }
                    if(model.getUsername()!= null){
                        loginDto.setUsername(model.getUsername());
                    }
                    if(model.getPassword()!= null){
                        loginDto.setPassword(model.getPassword());
                    }
                    if(model.getAkses()!= null){
                        loginDto.setAkses(model.getAkses());
                    }
                    if(model.getId_pembeli()!= null){
                        loginDto.setId_pembeli(model.getId_pembeli());
                    }
                    if(model.getNama_lengkap()!= null){
                        loginDto.setNama_lengkap(model.getNama_lengkap());
                    }
                    
                    listDataDto.add(loginDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listDataDto;
    }
    
}
