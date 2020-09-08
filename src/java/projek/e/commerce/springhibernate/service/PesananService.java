/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.service;

import java.util.List;
import projek.e.commerce.springhibernate.dto.PesananDto;

/**
 *
 * @author HP
 */
public interface PesananService {
    public List <PesananDto> getListBelanja() throws Exception;    
    public List <PesananDto> getBelanjaById(String id);
    public void doUpdateDataBelanja(PesananDto belanjaDto) throws Exception;
    public void saveDataBelanja(PesananDto belanjaDto,String id_pembeli) throws Exception;
    public void deleteDataBelanja(String kode_belanja) throws Exception;
    public PesananDto getUpdateDataBelanja(String kode_belanja) throws Exception;
    public List<PesananDto> getPesananStatusBaru() throws Exception;
    public List<PesananDto> getPesananStatusBelumBayar() throws Exception;
    public List<PesananDto> getPesananStatusSudahBayar() throws Exception;
    public List<PesananDto> getPesananStatusReject() throws Exception;
    public  void Confirm(String kode_pesanan) throws Exception;
    public void Reject(String kode_pesanan) throws Exception;
    public List <PesananDto> getBelanjaByIdPembeli(String id);
}
