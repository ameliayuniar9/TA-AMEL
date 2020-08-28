/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.dao;

import java.util.List;
import projek.e.commerce.springhibernate.model.AkunModel;

/**
 *
 * @author amelia.yuniar
 */
public interface AkunDao {
    public void saveDataAkun(AkunModel akunModel) throws Exception;
    public List<AkunModel> getListDataAkun() throws Exception;
    public AkunModel getAkunById(String id) throws Exception;
    public void deleteAkun(String id);
    public void updateAkun(AkunModel akunModel);
    public List<AkunModel> getListAkunUpdate(String kode_akun);
}
