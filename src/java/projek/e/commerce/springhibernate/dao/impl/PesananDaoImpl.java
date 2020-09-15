/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.dao.impl;

import java.util.List;
import org.hibernate.Query;
import projek.e.commerce.springhibernate.model.PesananModel;
import projek.e.commerce.springhibernate.dao.PesananDao;

/**
 *
 * @author HP
 */
public class PesananDaoImpl extends HibernateUtil implements PesananDao{

    @Override
    public void saveDataBelanja(PesananModel belanjaModel) throws Exception {
        try {
            getSession().save(belanjaModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<PesananModel> getListDataBelanja() throws Exception {
        List<PesananModel> listData = null;
        try {
            String sql = "select model from PesananModel model";
            Query query = createQuery(sql);
            listData = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    @Override
    public PesananModel getBelanjaById(String id) throws Exception {
        PesananModel belanja = new PesananModel();
        Query query = null;
        try {
            String sql = "select model from PesananModel model where kode_pesanan=:kdpdkparam";
            query = createQuery(sql).setParameter("kdpdkparam", id);                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (PesananModel) query.uniqueResult();
    }

    @Override
    public void deleteBelanja(String id) {
        PesananModel ddm = new PesananModel();
        ddm.setKode_pesanan(id);
        getSession().delete(ddm);
    }

    @Override
    public void updateBelanja(PesananModel belanjaModel) {
        if (belanjaModel.getKode_pesanan()!= null) {
            getSession().merge(belanjaModel);
        } else {
            getSession().saveOrUpdate(belanjaModel);
        }
    }

    @Override
    public List<PesananModel> getListBelanjaUpdate(String kode_pesanan) {
        List<PesananModel> dataList = null;
        String sql = "select model from PesananModel model where kode_pesanan=:kode_pesanan";
        Query query = createQuery(sql).setParameter("kode_pesanan", kode_pesanan);
        dataList = query.list();
        return dataList;
    }

    @Override
    public List<Object[]> getPesananStatusBaru() throws Exception {
        List<Object[]> listData = null;
        String sql = "SELECT a.kode_pesanan,b.nama,a.total_pesanan,a.tanggal_pesan,a.status,a.bukti_pembayaran,a.tanggal_pembayaran " +
                      "FROM tb_pesanan a JOIN tb_pembeli b ON a.id_pembeli=b.id_pembeli " +
                      "WHERE a.status='BARU' ";
        Query query = createNativeQuery(sql);
        listData = query.list();
        return listData;
    }

    @Override
    public List<Object[]> getPesananStatusBelumBayar() throws Exception {
        List<Object[]> listData = null;
        String sql = "SELECT a.kode_pesanan,b.nama,a.total_pesanan,a.tanggal_pesan,a.status,a.bukti_pembayaran,a.tanggal_pembayaran " +
                      "FROM tb_pesanan a JOIN tb_pembeli b ON a.id_pembeli=b.id_pembeli " +
                      "WHERE a.status='BELUM BAYAR' ";
        Query query = createNativeQuery(sql);
        listData = query.list();
        return listData;
    }

    @Override
    public List<Object[]> getPesananStatusSudahBayar() throws Exception {
        List<Object[]> listData = null;
        String sql = "SELECT a.kode_pesanan,b.nama,a.total_pesanan,a.tanggal_pesan,a.status,a.bukti_pembayaran,a.tanggal_pembayaran " +
                      "FROM tb_pesanan a JOIN tb_pembeli b ON a.id_pembeli=b.id_pembeli " +
                      "WHERE a.status='SUDAH BAYAR' ";
        Query query = createNativeQuery(sql);
        listData = query.list();
        return listData;
    }

    @Override
    public List<Object[]> getPesananStatusReject() throws Exception {
        List<Object[]> listData = null;
        String sql = "SELECT a.kode_pesanan,b.nama,a.total_pesanan,a.tanggal_pesan,a.status,a.bukti_pembayaran,a.tanggal_pembayaran " +
                      "FROM tb_pesanan a JOIN tb_pembeli b ON a.id_pembeli=b.id_pembeli " +
                      "WHERE a.status='REJECT' ";
        Query query = createNativeQuery(sql);
        listData = query.list();
        return listData;
    }
    
    @Override
    public List<PesananModel> getListBelanjaByIdPembeli(String id_pembeli) {
        List<PesananModel> dataList = null;
        String sql = "select model from PesananModel model where id_pembeli=:id";
        Query query = createQuery(sql).setParameter("id",id_pembeli);
        dataList = query.list();
        return dataList;
    }
    @Override
    public List<Object[]> getProdukForGrafik() throws Exception {
        List<Object[]> listData = null;
        String sql = "SELECT c.kode_detail,b.nama_produk,a.warna,SUM(c.kuantitas) FROM tb_detail_pesanan c " +
                     "JOIN tb_pesanan d ON c.kode_pesanan=d.kode_pesanan JOIN tb_detail a " +
                     "ON a.kode_detail=c.kode_detail JOIN tb_produk b ON a.kode_produk=b.kode_produk WHERE d.status='SUDAH BAYAR' GROUP BY c.kode_detail ORDER BY SUM(kuantitas) DESC LIMIT 5";
        Query query = createNativeQuery(sql);
        listData = query.list();
        return listData;
    }

    @Override
    public List<PesananModel> getListDataPesananByIdPembeli(String id) throws Exception {
        List<PesananModel> listData = null;
        try {
            String sql = "select model from PesananModel model where id_pembeli=:id";
            Query query = createQuery(sql).setParameter("id", id);  
            listData = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    @Override
    public List<Object[]> getMakeLaporanPenjualan(String tanggal_transaksi, String bulan_transaksi) throws Exception {
        List<Object[]> listData = null;
        String sql = "SELECT c.kode_detail,CONCAT(b.nama_produk,' ',a.warna) AS produk,SUM(c.kuantitas) AS kuantitas,SUM(d.total_pesanan) AS total,d.tanggal_pesan " +
                     "FROM tb_detail_pesanan c JOIN tb_detail a " +
                     "ON a.kode_detail=c.kode_detail JOIN tb_produk b ON a.kode_produk=b.kode_produk " +
                     "JOIN tb_pesanan d ON c.kode_pesanan=d.kode_pesanan WHERE d.status='SUDAH BAYAR' AND YEAR(tanggal_pesan)=:thn " +
                     "AND MONTH(tanggal_pesan)=:bln " +
                     "GROUP BY c.kode_detail ORDER BY d.tanggal_pesan ASC";
        Query query = createNativeQuery(sql).setParameter("thn", tanggal_transaksi);
        query.setParameter("bln", bulan_transaksi);
        listData = query.list();
        return listData;
    }

    @Override
    public List<Object[]> getProdukTerjual(String tanggal_transaksi, String bulan_transaksi) throws Exception {
        List<Object[]> listData = null;
        String sql = "SELECT CONCAT(b.nama_produk,' ',a.warna) AS produk,SUM(d.total_pesanan) AS total " +
                     "FROM tb_detail_pesanan c JOIN tb_detail a " +
                     "ON a.kode_detail=c.kode_detail JOIN tb_produk b ON a.kode_produk=b.kode_produk " +
                     "JOIN tb_pesanan d ON c.kode_pesanan=d.kode_pesanan WHERE d.status='SUDAH BAYAR' AND YEAR(tanggal_pesan)=:thn " +
                     "AND MONTH(tanggal_pesan)=:bl " +
                     "GROUP BY c.kode_detail ORDER BY d.tanggal_pesan ASC";
        Query query = createNativeQuery(sql).setParameter("thn", tanggal_transaksi);
        query.setParameter("bl", bulan_transaksi);
        listData = query.list();
        return listData;
    }

    @Override
    public List<Object[]> getTahunToMakeLaporan() throws Exception {
        List<Object[]> listData = null;
        String sql = "SELECT DISTINCT kode_pesanan,YEAR(tanggal_pesan) as tahun FROM tb_pesanan WHERE STATUS='SUDAH BAYAR' GROUP BY YEAR(tanggal_pesan) ";
        Query query = createNativeQuery(sql);
        listData = query.list();
        return listData;
    }

    @Override
    public List<Object[]> getDetailPesanan(String kode_pesanan) throws Exception {
        List<Object[]> listData = null;
        String sql = "SELECT a.kode_pesanan,CONCAT(b.nama_produk,' ',c.warna) AS produk,d.kuantitas FROM tb_pesanan a " +
                     "JOIN tb_detail_pesanan d ON a.kode_pesanan=d.kode_pesanan JOIN tb_detail c " +
                     "ON c.kode_detail=d.kode_detail JOIN tb_produk b ON c.kode_produk=c.kode_produk WHERE a.kode_pesanan=:kode GROUP BY c.kode_detail ";
        Query query = createNativeQuery(sql).setParameter("kode", kode_pesanan);
        listData = query.list();
        return listData;
    }
    
}
