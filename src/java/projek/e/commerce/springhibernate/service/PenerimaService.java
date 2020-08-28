/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.service;

import java.util.List;
import projek.e.commerce.springhibernate.dto.PenerimaDto;
import projek.e.commerce.springhibernate.model.PenerimaModel;

/**
 *
 * @author HP
 */
public interface PenerimaService {
    public List <PenerimaDto> getListPenerima()throws Exception;
    public void saveDataPenerima(PenerimaDto penerimaDto) throws Exception;
    public PenerimaModel getPenerimaById(String id);
    public void deleteDataPenerima(String id_penerima) throws Exception;
    public PenerimaDto getUpdateDataPenerima(String id_penerima) throws Exception;
    public void doUpdateDataPenerima(PenerimaDto penerimaDto) throws Exception;
    public List <PenerimaDto> getListPenerimaById(String id_pembeli);
}
