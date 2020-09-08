/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.service;

import java.util.List;
import projek.e.commerce.springhibernate.dto.KecamatanDto;
import projek.e.commerce.springhibernate.dto.TampMainDto;

/**
 *
 * @author amelia.yuniar
 */
public interface KecamatanService {
    public List <KecamatanDto> getListKecamatan()throws Exception;
    public List <KecamatanDto> getListKecamatanById(String param);
    public List<TampMainDto> getNama(String Kota, String Kec);
}
