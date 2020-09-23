/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.dao.impl;

import java.util.List;
import org.hibernate.Query;
import projek.e.commerce.springhibernate.dao.PenerimaDao;
import projek.e.commerce.springhibernate.model.PenerimaModel;

/**
 *
 * @author HP
 */
public class PenerimaDaoImpl extends HibernateUtil implements PenerimaDao{

    @Override
    public List<PenerimaModel> getListDataPenerima() throws Exception {
        List<PenerimaModel> listData = null;
        try {
            String sql = "select model from PenerimaModel model";
            Query query = createQuery(sql);
            listData = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    @Override
    public PenerimaModel getPenerimaModelById(String id) {
        PenerimaModel kategori = new PenerimaModel();
        Query query = null;
        try {
            String sql = "select model from PenerimaModel model where id_penerima=:id";
            query = createQuery(sql).setParameter("id", id);                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (PenerimaModel) query.uniqueResult();
    }

    @Override
    public void deletePenerima(String id) {
        PenerimaModel ddm = new PenerimaModel();
        ddm.setId_penerima(id);
        getSession().delete(ddm);
    }


    @Override
    public void updatePenerima(PenerimaModel penerimaModel) {
        if (penerimaModel.getId_penerima()!= null) {
            getSession().merge(penerimaModel);
        } else {
            getSession().saveOrUpdate(penerimaModel);
        }
    }

    @Override
    public void saveDataPenerima(PenerimaModel penerimaModel) {
        getSession().save(penerimaModel);
    }

    @Override
    public List<PenerimaModel> getListPenerimaUpdate(String id_penerima) {
        List<PenerimaModel> dataList = null;
        String sql = "select model from PenerimaModel model where id_penerima=:id";
        Query query = createQuery(sql).setParameter("id", id_penerima);
        dataList = query.list();
        return dataList;
    }
    
    @Override
    public List<PenerimaModel> getListDataPenerimaById(String id_pembeli) {
        List<PenerimaModel> listData = null;
        String sql = "select model from PenerimaModel model where id_pembeli=:id_pembeli";
        Query query = createQuery(sql).setParameter("id_pembeli", id_pembeli);
        listData = query.list();
        return listData;
    }

    @Override
    public List<Object[]> getAlamatPenerima(String kode_pesanan) throws Exception {
        List<Object[]> listData = null;
        String sql = "SELECT a.nama_penerima,a.no_telp,a.provinsi,a.kabupaten,a.kecamatan,a.alamat_lengkap FROM tb_penerima a JOIN tb_pesanan b " +
                     "ON a.id_penerima=b.id_penerima WHERE a.id_penerima  IN(SELECT id_penerima FROM tb_pesanan WHERE kode_pesanan=:kode) " +
                     "GROUP BY a.id_penerima ";
        Query query = createNativeQuery(sql).setParameter("kode", kode_pesanan);
        listData = query.list();
        return listData;
    }
}
