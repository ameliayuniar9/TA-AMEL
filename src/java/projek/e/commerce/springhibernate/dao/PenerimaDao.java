/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.dao;

import java.util.List;
import projek.e.commerce.springhibernate.model.KategoriModel;
import projek.e.commerce.springhibernate.model.PenerimaModel;

/**
 *
 * @author HP
 */
public interface PenerimaDao {
    public List<PenerimaModel> getListDataPenerima()throws Exception;
    public PenerimaModel getPenerimaModelById(String id);
    public void deletePenerima(String id);
    public void updatePenerima(PenerimaModel penerimaModel);
    public void saveDataPenerima(PenerimaModel penerimaModel);
    public List<PenerimaModel> getListPenerimaUpdate(String id_penerima);
    public List<PenerimaModel> getListDataPenerimaById(String id_pembeli);
}
