/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.service;

import java.util.List;
import projek.e.commerce.springhibernate.dto.AkunDto;
import projek.e.commerce.springhibernate.model.AkunModel;

/**
 *
 * @author amelia.yuniar
 */
public interface AkunService {
    public void saveDataAkun(AkunDto akunDto) throws Exception;
    public List <AkunDto> getListAkun()throws Exception;
    public AkunModel getAkunById(String id);
    public void deleteDataAkun(String kode_akun) throws Exception;
    public AkunDto getUpdateDataAkun(String kode_akun) throws Exception;
    public void doUpdateDataAkun(AkunDto akunDto) throws Exception;
}
