/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.dao;

import java.util.List;
import projek.e.commerce.springhibernate.model.KotaModel;

/**
 *
 * @author amelia.yuniar
 */
public interface KotaDao {
    public List<KotaModel> getListDataKota()throws Exception;
    public List<KotaModel> getKotaById(String param) throws Exception;
    public KotaModel getKotaModelById(String id);
    
}
