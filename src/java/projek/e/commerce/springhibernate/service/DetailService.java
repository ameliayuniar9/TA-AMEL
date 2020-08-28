/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.service;

import java.util.List;
import projek.e.commerce.springhibernate.dto.DetailDto;
import projek.e.commerce.springhibernate.model.DetailModel;

/**
 *
 * @author HP
 */
public interface DetailService {
    public List <DetailDto> getListDetail()throws Exception;
    public void saveDataDetail(DetailDto detailDto) throws Exception;
    public DetailModel getDetailById(String kode);
    public void deleteDataDetail(String kode_detail) throws Exception;
    public DetailDto getUpdateDataDetail(String kode_produk) throws Exception;
    public void doUpdateDataDetail(DetailDto detailDto) throws Exception;
}
