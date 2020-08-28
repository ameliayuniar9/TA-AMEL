/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.dao;

import java.util.List;
import projek.e.commerce.springhibernate.dto.LoginDto;
import projek.e.commerce.springhibernate.model.LoginModel;

/**
 *
 * @author HP
 */
public interface LoginDao {
    public void saveLogin(LoginModel loginModel)throws Exception;
    public List<LoginModel> getListDataUser()throws Exception;
    public List<LoginModel> getListDataUserSelect(String id_user)throws Exception;
    public List<LoginModel> getListDataLogin(LoginDto loginDto)throws Exception;
    public void deleteLogin(String id);
    public void updateLogin(LoginModel loginModel);   
    public LoginModel getLoginById(String id) throws Exception;
    public List<LoginModel> getListDataUserAdmin()throws Exception;
}
