/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.service;

import java.util.List;
import projek.e.commerce.springhibernate.dto.LoginDto;
import projek.e.commerce.springhibernate.model.LoginModel;

/**
 *
 * @author HP
 */
public interface LoginService {
    public List <LoginDto> getListLogin()throws Exception;
    public LoginDto getListDataUserLogin(LoginDto fromDto) throws Exception;
    public void saveDataLogin(LoginDto loginDto) throws Exception;
    public LoginModel getLoginById(String id);
    public void deleteDataLogin(String id_login) throws Exception;
    public LoginDto getUpdateDataLogin(String id_login) throws Exception;
    public void doUpdateDataLogin(LoginDto loginDto) throws Exception;
    public List<LoginDto> getListLoginAdmin() throws Exception;
}
