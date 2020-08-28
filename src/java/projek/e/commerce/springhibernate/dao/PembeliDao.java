/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.dao;

import java.util.List;
import projek.e.commerce.springhibernate.dto.PembeliDto;
import projek.e.commerce.springhibernate.model.PembeliModel;

/**
 *
 * @author HP
 */
public interface PembeliDao {
    public void saveDataPembeli(PembeliModel pembeliModel)throws Exception;
    public List<PembeliModel> getListDataPembeli()throws Exception;
    public PembeliModel getPembeliById(String id) throws Exception;
    public void deletePembeli(String id);
    public void updatePembeli(PembeliModel pembeliModel);
    public List<PembeliModel> getListPembeliUpdate(String id_pembeli);
    public List<PembeliModel> getListLoginPembeli(PembeliDto pembeliDto)throws Exception;
    public List<PembeliModel> getListDataPembeliSelect(String id_pembeli) throws Exception;
    public List<Object[]> getId(String user, String pass) throws Exception;
}
