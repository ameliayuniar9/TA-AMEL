/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.service;

import java.util.List;
import projek.e.commerce.springhibernate.dto.PembeliDto;

/**
 *
 * @author HP
 */
public interface PembeliService {
    public List <PembeliDto> getListPembeli() throws Exception;
    public List <PembeliDto> getPembeliById(String id);
    public void doUpdateDataPembeli(PembeliDto pembeliDto) throws Exception;
    public void saveDataPembeli(PembeliDto pembeliDto) throws Exception;
    public void deleteDataPembeli(String id_pembeli) throws Exception;
    public PembeliDto getUpdateDataPembeli(String id_pembeli) throws Exception;
    public List <PembeliDto> getListLoginPembeli()throws Exception;
    public PembeliDto getListDataUserLoginPembeli(PembeliDto fromDto) throws Exception;
    public PembeliDto getDataId(String user, String pass) throws Exception;
    public List<PembeliDto> getListPembeliSelect(String id_pembeli) throws Exception;
}
