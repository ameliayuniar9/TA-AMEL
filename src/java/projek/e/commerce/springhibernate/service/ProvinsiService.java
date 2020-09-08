/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.service;

import java.util.List;
import projek.e.commerce.springhibernate.dto.ProvinsiDto;

/**
 *
 * @author amelia.yuniar
 */
public interface ProvinsiService {
    public List <ProvinsiDto> getListProvinsi()throws Exception;
}
