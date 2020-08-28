/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.dao.impl;

import java.util.List;
import org.hibernate.Query;
import projek.e.commerce.springhibernate.dao.PengeluaranDao;
import projek.e.commerce.springhibernate.model.PengeluaranModel;


/**
 *
 * @author amelia.yuniar
 */
public class PengeluaranDaoImpl extends HibernateUtil implements PengeluaranDao{
    @Override
    public void saveDataPengeluaran(PengeluaranModel pengeluaranModel) throws Exception {
        try {
            getSession().save(pengeluaranModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<PengeluaranModel> getListDataPengeluaran() throws Exception {
        List<PengeluaranModel> listData = null;
        try {
            String sql = "select model from PengeluaranModel model ";
            Query query = createQuery(sql);
            listData = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    @Override
    public PengeluaranModel getPengeluaranById(String id) throws Exception {
         PengeluaranModel pe = new PengeluaranModel();
        Query query = null;
        try {
            String sql = "select model from PengeluaranModel model where kode_pengeluaran=:kdpengeluaranparam";
            query = createQuery(sql).setParameter("kdpengeluaranparam", id);                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (PengeluaranModel) query.uniqueResult();
    }

    @Override
    public void deletePengeluaran(String id) {
        PengeluaranModel ddm = new PengeluaranModel();
        ddm.setKode_pengeluaran(id);
        getSession().delete(ddm);
    }

    @Override
    public void updatePengeluaran(PengeluaranModel pengeluaranModel) {
        getSession().saveOrUpdate(pengeluaranModel);
    }

    @Override
    public List<PengeluaranModel> getListPegeluaranUpdate(String kode_pengeluaran) {
         List<PengeluaranModel> dataList = null;
        String sql = "select model from PengeluaranModel model where kode_pengeluaran=:id";
        Query query = createQuery(sql).setParameter("id", kode_pengeluaran);
        dataList = query.list();
        return dataList;
    }

    @Override
    public List<Object[]> getExpenseValueToMakeLaporan(String tanggal_transaksi, String bulan_transaksi) throws Exception {
        List<Object[]> listData = null;
        String sql = "SELECT SUM(IF( YEAR(a.tanggal) =:thn AND MONTH(a.tanggal) =:bln, jumlah, 0)) AS total, b.nama_akun \n" +
                     "FROM tb_pengeluaran a , tb_akun b WHERE a.status='approved' and a.kode_akun=b.kode_akun GROUP BY a.kode_akun";
        Query query = createNativeQuery(sql).setParameter("thn", tanggal_transaksi);
        query.setParameter("bln", bulan_transaksi);
        listData = query.list();
        return listData;
    }

    @Override
    public List<Object[]> getExpenseWithAccountName() throws Exception {
        List<Object[]> listData = null;
        String sql = "SELECT  a.kode_pengeluaran, a.tanggal, a.kode_akun, a.deskripsi, a.jumlah, a.upload_file, a.status, b.nama_akun FROM tb_pengeluaran a JOIN tb_akun b ON a.kode_akun=b.kode_akun WHERE a.STATUS='approved' ";
        Query query = createNativeQuery(sql);
        listData = query.list();
        return listData;
    }

    @Override
    public List<Object[]> getListDataPengeluaranCek() throws Exception {
        List<Object[]> listData = null;
        String sql = "SELECT  a.kode_pengeluaran, a.tanggal, a.kode_akun, a.deskripsi, a.jumlah, a.upload_file, a.status, b.nama_akun FROM tb_pengeluaran a JOIN tb_akun b ON a.kode_akun=b.kode_akun WHERE a.STATUS!='approved' ";
        Query query = createNativeQuery(sql);
        listData = query.list();
        return listData;
    }

    @Override
    public List<Object[]> getExpenseWithAccountNameCek() throws Exception {
       List<Object[]> listData = null;
        String sql = "SELECT  a.kode_pengeluaran, a.tanggal, a.kode_akun, a.deskripsi, a.jumlah, a.upload_file, a.status, b.nama_akun FROM tb_pengeluaran a JOIN tb_akun b ON a.kode_akun=b.kode_akun WHERE a.STATUS='Baru' ";
        Query query = createNativeQuery(sql);
        listData = query.list();
        return listData;
    }
}
