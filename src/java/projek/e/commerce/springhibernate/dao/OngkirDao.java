/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.dao;

import java.util.List;
import projek.e.commerce.springhibernate.model.OngkirModel;

/**
 *
 * @author HP
 */
public interface OngkirDao {
    public void saveDataOngkir(OngkirModel ongkirModel) throws Exception;
    public List<OngkirModel> getListDataOngkir() throws Exception;
    public OngkirModel getOngkirById(String id) throws Exception;
    public void deleteOngkir(String id);
    public void updateOngkir(OngkirModel ongkirModel);
    public List<OngkirModel> getListOngkirUpdate(String kode_ongkir);
    
}
