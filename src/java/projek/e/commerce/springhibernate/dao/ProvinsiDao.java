/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.dao;

import java.util.List;
import projek.e.commerce.springhibernate.model.ProvinsiModel;

/**
 *
 * @author amelia.yuniar
 */
public interface ProvinsiDao {
    public List<ProvinsiModel> getListDataProvinsi()throws Exception;
    public ProvinsiModel getProvinsiModelById(String id);
}
