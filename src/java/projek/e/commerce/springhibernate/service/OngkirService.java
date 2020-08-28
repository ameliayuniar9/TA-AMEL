/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.service;

import java.util.List;
import projek.e.commerce.springhibernate.dto.OngkirDto;
import projek.e.commerce.springhibernate.model.OngkirModel;

/**
 *
 * @author HP
 */
public interface OngkirService {
    public void saveDataOngkir (OngkirDto ongkirDto) throws Exception;
    public List<OngkirDto> getListOngkir() throws Exception;
    public OngkirModel getOngkirById(String id);
    public void deleteDataOngkir(String kode_ongkir) throws Exception;
    public OngkirDto getUpdateDataOngkir(String kode_Ongkir) throws Exception;
    public void doUpdateDataOngkir(OngkirDto ongkirDto) throws Exception;
}
