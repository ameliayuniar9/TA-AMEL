/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.dao;

import java.util.List;
import projek.e.commerce.springhibernate.model.KecamatanModel;

/**
 *
 * @author amelia.yuniar
 */
public interface KecamatanDao {
    public List<KecamatanModel> getListDataKecamatan()throws Exception;
    public List<KecamatanModel> getKecamatanById(String param) throws Exception;
    public KecamatanModel getKecamatanModelById(String id);
    
}
