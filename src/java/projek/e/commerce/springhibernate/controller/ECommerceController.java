/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.e.commerce.springhibernate.controller;

import com.google.gson.Gson;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.ModelAndView;
import projek.e.commerce.springhibernate.dao.AkunDao;
import projek.e.commerce.springhibernate.dao.CartDao;
import projek.e.commerce.springhibernate.dao.DetailDao;
import projek.e.commerce.springhibernate.dao.DetailPesananDao;
import projek.e.commerce.springhibernate.dao.PesananDao;
import projek.e.commerce.springhibernate.dao.KecamatanDao;
import projek.e.commerce.springhibernate.dao.KotaDao;
import projek.e.commerce.springhibernate.dao.LoginDao;
import projek.e.commerce.springhibernate.dao.PembeliDao;
import projek.e.commerce.springhibernate.dao.PenerimaDao;
import projek.e.commerce.springhibernate.dao.PengeluaranDao;
import projek.e.commerce.springhibernate.dao.ProvinsiDao;
import projek.e.commerce.springhibernate.dao.UlasanDao;
import projek.e.commerce.springhibernate.dto.AkunDto;
import projek.e.commerce.springhibernate.dto.CartDto;
import projek.e.commerce.springhibernate.dto.KategoriDto;
import projek.e.commerce.springhibernate.dto.LoginDto;
import projek.e.commerce.springhibernate.dto.NotivDto;
import projek.e.commerce.springhibernate.dto.OngkirDto;
import projek.e.commerce.springhibernate.dto.PembeliDto;
import projek.e.commerce.springhibernate.dto.PesananDto;
import projek.e.commerce.springhibernate.dto.DetailDto;
import projek.e.commerce.springhibernate.dto.DetailPesananDto;
import projek.e.commerce.springhibernate.dto.KecamatanDto;
import projek.e.commerce.springhibernate.dto.KotaDto;
import projek.e.commerce.springhibernate.dto.LaporanDto;
import projek.e.commerce.springhibernate.dto.ListKodeDto;
import projek.e.commerce.springhibernate.dto.PenerimaDto;
import projek.e.commerce.springhibernate.dto.PengeluaranDto;
import projek.e.commerce.springhibernate.dto.ProdukDto;
import projek.e.commerce.springhibernate.dto.ProvinsiDto;
import projek.e.commerce.springhibernate.dto.TampMainDto;
import projek.e.commerce.springhibernate.dto.UlasanDto;
import projek.e.commerce.springhibernate.model.DetailModel;
import projek.e.commerce.springhibernate.model.DetailPesananModel;
import projek.e.commerce.springhibernate.model.LoginModel;
import projek.e.commerce.springhibernate.model.PembeliModel;
import projek.e.commerce.springhibernate.service.AkunService;
import projek.e.commerce.springhibernate.service.CartService;
import projek.e.commerce.springhibernate.service.DetailPesananService;
import projek.e.commerce.springhibernate.service.KategoriService;
import projek.e.commerce.springhibernate.service.LoginService;
import projek.e.commerce.springhibernate.service.OngkirService;
import projek.e.commerce.springhibernate.service.PembeliService;
import projek.e.commerce.springhibernate.service.ProdukService;
import projek.e.commerce.springhibernate.service.impl.LoginServiceImpl;
import projek.e.commerce.springhibernate.service.impl.PembeliServiceImpl;
import projek.e.commerce.springhibernate.service.DetailService;
import projek.e.commerce.springhibernate.service.KecamatanService;
import projek.e.commerce.springhibernate.service.KotaService;
import projek.e.commerce.springhibernate.service.PenerimaService;
import projek.e.commerce.springhibernate.service.PengeluaranService;
import projek.e.commerce.springhibernate.service.PesananService;
import projek.e.commerce.springhibernate.service.ProvinsiService;
import projek.e.commerce.springhibernate.service.UlasanService;

/**
 *
 * @author HP
 */
@Controller
public class ECommerceController {
    
     @Autowired
    LoginService loginService;
     
     @Autowired
    PembeliService pembeliService;
     
      @Autowired
    KategoriService kategoriService;
      
    
      @Autowired
    ProdukService produkService;
      
      @Autowired
    PesananService pesananService;
      
      @Autowired
    OngkirService ongkirService;
      
     @Autowired
    LoginDao loginDao;
     
      @Autowired
    PembeliDao pembeliDao;
     
      @Autowired
    CartService cartService;
      
      @Autowired
    CartDao  cartDao;
      
      @Autowired
    DetailService detailService;
      
      @Autowired
    DetailDao  detailDao;
      
      @Autowired
    PenerimaService penerimaService;
      
      @Autowired
    PenerimaDao  penerimaDao;
    
      @Autowired
    PesananDao  pesananDao;
      
      @Autowired
    UlasanService ulasanService;
      
      @Autowired
    UlasanDao  ulasanDao;
      
      @Autowired
    AkunService akunService;
      
      @Autowired
    AkunDao  akunDao;
      
      @Autowired
    PengeluaranService pengeluaranService;
      
      @Autowired
    PengeluaranDao  pengeluaranDao;
      
      @Autowired
    DetailPesananService detailPesananService;
      
      @Autowired
    DetailPesananDao detailPesananDao;
      
      @Autowired
    ProvinsiService provinsiService;
      
      @Autowired
    ProvinsiDao  provinsiDao;
      
      @Autowired
    KotaService kotaService;
      
      @Autowired
    KotaDao kotaDao;
      
      @Autowired
    KecamatanService kecamatanService;
      
      @Autowired
    KecamatanDao  kecamatanDao;
    
    LoginModel uModel=new LoginModel();
    PembeliDto dto=new PembeliDto();
    HttpSession session;
    
    String pp;
    
    String x="",akses;
    int cek=0;
    String kodeProd,id,kodeDetail,id_login;
    int jmlProd=0;
    
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String viewIndex(ModelMap model,LoginDto loginDto,NotivDto notivDto){
        model.addAttribute("loginDto", loginDto);
         if(cek==2){
             notivDto.setSukses(x);
         }
        model.addAttribute("notivDto", notivDto);
        return "index";
    }
    
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String viewHome(String id_pembeli,ModelMap model) throws Exception{
        List<CartDto> listCartDto=cartService.getListCartByIdPembeli(id);
        model.addAttribute("listCartDto", listCartDto);
        List<PesananDto> listPesananDto = pesananService.getPesananStatusReject(id);
        model.addAttribute("listPesananDto", listPesananDto);
        return "home";
    }
    
    @RequestMapping(value = "/tentang", method = RequestMethod.GET)
    public String viewTentang(String id_pembeli,ModelMap model){
        List<CartDto> listCartDto=cartService.getListCartByIdPembeli(id);
        model.addAttribute("listCartDto", listCartDto);
        return "tentang";
    }

    @RequestMapping(value = "/pembayaran", method = RequestMethod.GET)
    public String viewPembayaran(String id_pembeli,String kode_pesanan,ModelMap model) throws Exception{
        List<CartDto> listCartDto=cartService.getListCartByIdPembeli(id);
        model.addAttribute("listCartDto", listCartDto);
        PesananDto pesananDto =pesananService.getUpdateDataBelanja(kode_pesanan);
        model.addAttribute("pesananDto", pesananDto);
        return "pembayaran";
    }
    
    @RequestMapping(value = "/kontak", method = RequestMethod.GET)
    public String viewKontak(){
        return "kontak";
    }
    
    @RequestMapping(value = "/detailProduk", method = RequestMethod.GET)
    public String viewDetailProduk(String kode_detail,String id_pembeli,CartDto cartDto,ModelMap model) throws Exception{
        DetailDto detailDto = detailService.getUpdateDataDetail(kode_detail);
        kodeDetail=detailDto.getKode_detail();
        kodeProd=detailDto.getKode_produk();
        List<PembeliDto> listPembeliDtoSelect = pembeliService.getListPembeliSelect(id);
        model.addAttribute("listPembeliDtoSelect", listPembeliDtoSelect);
        List<CartDto> listCartDto=cartService.getListCartByIdPembeli(id);
        model.addAttribute("listCartDto", listCartDto);
        model.addAttribute("detailDto", detailDto); 
        return "detailProduk";
    }
    
    @RequestMapping(value = "/detailKeranjang", method = RequestMethod.GET)
    public String viewDetailKeranjang(ModelMap model,PesananDto pesananDto) throws Exception{
        KategoriDto dto = null;     
        dto = new KategoriDto();
        model.addAttribute("kategoriDto", dto);
       
        List<CartDto> listCartDto=cartService.getListCartByIdPembeli(id);
        System.out.println("controllerrrrrrrrrrr");
        List<PenerimaDto> listPenerimaDto=penerimaService.getListPenerimaById(id);
        System.out.println("controllerrrrrrrrrrr"+listPenerimaDto.size());
        List<ProvinsiDto> listProvinsi = provinsiService.getListProvinsi();
        List<KotaDto> listKota=kotaService.getListKota();
        List<KecamatanDto> listKecamatan=kecamatanService.getListKecamatan();
        PenerimaDto penerimaDto=new PenerimaDto();
        try {
            model.addAttribute("listCartDto", listCartDto);
            model.addAttribute("pesananDto", pesananDto);
            model.addAttribute("listPenerimaDto", listPenerimaDto);
            model.addAttribute("penerimaDto",penerimaDto);
            model.addAttribute("listProvinsi", listProvinsi);
            model.addAttribute("listKota", listKota);
            model.addAttribute("listKecamatan", listKecamatan);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "detailKeranjang";
    }
    
    @RequestMapping(value = "/getDataKotaByProvinsi", method = RequestMethod.GET)
    @ResponseBody
    public String getDataKotaByProvinsi(String id_provinsi) {
        List<KotaDto> listKota = kotaService.getKotaById(id_provinsi);
        return new Gson().toJson(listKota);
    }

    @RequestMapping(value = "/getKota2", method = RequestMethod.GET)
    @ResponseBody
    public String getKota2(String Prov, String Kota) {
        List<TampMainDto> listNama = kotaService.getNama(Prov, Kota);
        return new Gson().toJson(listNama);
    }
    
    @RequestMapping(value = "/getDataKecamatanByKota", method = RequestMethod.GET)
    @ResponseBody
    public String getDataKecamatanByKota(String id_kota) {
        List<KecamatanDto> listKecamatan = kecamatanService.getListKecamatanById(id_kota);
        return new Gson().toJson(listKecamatan);
    }

    @RequestMapping(value = "/getKecamatan2", method = RequestMethod.GET)
    @ResponseBody
    public String getKecamatan2(String Kota, String Kec) {
        List<TampMainDto> listNama = kotaService.getNama(Kota, Kec);
        return new Gson().toJson(listNama);
    }
    
    
    @RequestMapping(value = "/settingAddress", method = RequestMethod.GET)
    public String viewAddress(PesananDto pesananDto,ModelMap model){
        List<PenerimaDto> listPenerimaDto=penerimaService.getListPenerimaById(id);
        model.addAttribute("listPenerimaDto", listPenerimaDto);
        PenerimaDto penerimaDto=new PenerimaDto();
        model.addAttribute("penerimaDto",penerimaDto);
        model.addAttribute("pesananDto", pesananDto);
        return "settingAddress";
    }
    
    @RequestMapping(value = "/produk", method = RequestMethod.GET)
    public String viewProduk(){
        return "dataProduk";
    }
    
    @RequestMapping(value = "/tabelOngkir", method = RequestMethod.GET)
    public String viewTabelOngkir(ModelMap model){
        try {
            List<OngkirDto> listOngkirDto = ongkirService.getListOngkir();
            model.addAttribute("listOngkirDto", listOngkirDto);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return "tabelOngkir";
    }
    
    @RequestMapping(value = "/saveOngkir", method = RequestMethod.POST)
    public String saveDataOngkir(OngkirDto ongkirDto, ModelMap model) throws Exception{                
        ModelAndView mdl = new ModelAndView();
        ongkirService.saveDataOngkir(ongkirDto);                
        return "redirect:tabelOngkir.htm";
    }
    
    @RequestMapping(value = "/doTambahDataOngkir", method = RequestMethod.GET)
    public String doTambahDataOngkir(ModelMap model){
        OngkirDto dto = null;     
        try {
            dto = new OngkirDto();
            model.addAttribute("ongkirDto", dto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "insertOngkir";
    }
    
    @RequestMapping(value = "/deleteDataOngkir", method = RequestMethod.GET)
    public String hapusDataOngkir(String kode_ongkir, ModelMap model) throws Exception{        
        ongkirService.deleteDataOngkir(kode_ongkir);
        return "redirect:tabelOngkir.htm";
    }
    
    @RequestMapping(value = "/getDataUpdateOngkir", method = RequestMethod.GET)
    public String getUpdateDataOngkir(String kode_ongkir, ModelMap model) throws Exception{
        OngkirDto ongkirDto =ongkirService.getUpdateDataOngkir(kode_ongkir);
        model.addAttribute("ongkirDto", ongkirDto);
        return "updateOngkir";
    }
    
    
    
    @RequestMapping(value = "/updateOngkir", method = RequestMethod.POST)
    public String editDataOngkir(OngkirDto ongkirDto) throws Exception{
        ongkirService.doUpdateDataOngkir(ongkirDto);
        return "redirect:tabelOngkir.htm";
    }
    
    @RequestMapping(value = "/savePenerima", method = RequestMethod.POST)
    public String saveDataPenerima(PenerimaDto penerimaDto, ModelMap model) throws Exception{                
        ModelAndView mdl = new ModelAndView();
        penerimaDto.setId_penerima(id);
        penerimaService.saveDataPenerima(penerimaDto);                
        return "redirect:detailKeranjang.htm?id_pembeli="+id;
    }
    
    @RequestMapping(value = "/tabelKategori", method = RequestMethod.GET)
    public String viewTabelKategori(ModelMap model){
        try {
            List<KategoriDto> listKategoriDto = kategoriService.getListKategori();
            model.addAttribute("listKategoriDto", listKategoriDto);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return "tabelKategori";
    }
    @RequestMapping(value = "/doTambahDataPembeli", method = RequestMethod.GET)
    public String doTambahDataPembeli(ModelMap model){
        PembeliDto dto = null;       
        try {
            dto = new PembeliDto();
            model.addAttribute("pembeliDto", dto);
        } catch (Exception e) {
            e.printStackTrace();
            return "gagal upload " + e.getMessage();
            
        }
        return "registrasiPembeli";
    }
    
    @RequestMapping(value = "/savePembeli", method = RequestMethod.POST)
    public String saveDataPembeli(PembeliDto pembeliDto, ModelMap model) throws Exception{ 
        try{
            ModelAndView mdl = new ModelAndView();
            pembeliService.saveDataPembeli(pembeliDto); 
        }catch (Exception e) {
            e.printStackTrace();
            Logger.getLogger(PembeliServiceImpl.class.getName()).log(Level.SEVERE, null, e.getMessage());
        }
        return "redirect:index.htm";
    }
    
    
    
    @RequestMapping(value = "/deleteDataKategori", method = RequestMethod.GET)
    public String hapusData1(String kode_kategori, ModelMap model) throws Exception{        
        kategoriService.deleteDataKategori(kode_kategori);
        return "redirect:tabelKategori.htm";
    }
    
    @RequestMapping(value = "/doTambahDataKategori", method = RequestMethod.GET)
    public String viewInsertKtg(ModelMap model){
        KategoriDto dto = null;     
        try {
            dto = new KategoriDto();
            model.addAttribute("kategoriDto", dto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "insertKategori";
    }
    
     @RequestMapping(value = "/getDataUpdateKategori", method = RequestMethod.GET)
    public String getUpdateDataKategori(String kode_kategori, ModelMap model) throws Exception{   
        KategoriDto kategoriDto =kategoriService.getUpdateDataKategori(kode_kategori);
        model.addAttribute("kategoriDto", kategoriDto);
        return "updateKategori";
    }
    
    @RequestMapping(value = "/updateKategori", method = RequestMethod.POST)
    public String editData(KategoriDto kategoriDto) throws Exception{
        kategoriService.doUpdateDataKategori(kategoriDto);
        return "redirect:tabelKategori.htm";
    }
    
    @RequestMapping(value = "/saveKategori", method = RequestMethod.POST)
    public String saveData(KategoriDto kategoriDto, ModelMap model) throws Exception{                
        ModelAndView mdl = new ModelAndView();
        kategoriService.saveDataKategori(kategoriDto);                
        return "redirect:tabelKategori.htm";
    }
    
    @RequestMapping(value = "/savePesanan", method = RequestMethod.POST)
    public String Pesan(PesananDto pesananDto,ModelMap model) throws Exception{
        System.out.println("KODE DETAIL "+pesananDto.getKode_detail());
        System.out.println("KODE CART "+pesananDto.getKodeChart());
        System.out.println("JUMLAH BELANJA"+pesananDto.getJumlah_belanja());
        System.out.println("HARGA :"+pesananDto.getHarga());
         
        try {
            String[] detail=pesananDto.getKode_detail().split(",");
            String[] chart=pesananDto.getKodeChart().split(",");
            String[] stok=pesananDto.getJumlah_belanja().split(",");
            String[] harga=pesananDto.getHarga().split(",");
            
            for (int i = 0; i < detail.length; i++) {
                DetailPesananDto data=new DetailPesananDto();
                DetailModel detailPesanan=detailService.getDetailById(detail[i]);
                detailPesanan.setStok(detailPesanan.getStok()- Integer.parseInt(stok[i]));
                detailDao.updateDetail(detailPesanan);
                cartService.deleteDataCart(chart[i]);
                data.setKode_detail(detail[i]);
                data.setKuantitas(Integer.parseInt(stok[i]));
                data.setTotal(Integer.parseInt(harga[i]));
                detailPesananService.saveDataDetailPesanan(data);
            }
            pesananService.saveDataBelanja(pesananDto,pp);
        } catch (Exception e) {
            System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBB");
            e.printStackTrace();
        }
        return "redirect:pesananPembeli.htm?id_pembeli="+id+"&kode_pesanan="+pesananDto.getKode_pesanan();
    }
    
    @RequestMapping(value = "/updatePesanan", method = RequestMethod.POST)
    public String editData(PesananDto pesananDto) throws Exception{
         if (!pesananDto.getFile().isEmpty()) {
            try {
                byte[] bytes = pesananDto.getFile().getBytes();
//                ServletContext context = session.getServletContext();  
//                String rootPath = context.getRealPath("/b/img");
                String rootPath = "E:\\Amelia\\E-Commerce\\web\\b\\img\\pembayaran" ;
                // Creating the directory to store file
                //String rootPath = "E:\\file" ;
                File dir = new File(rootPath);//rootPath itu url nya..
                if (!dir.exists())
                        dir.mkdirs();//mkdirs() untuk membuat sebuah direktori baru, terdapat pd klas file
                
                File serverFile = new File(dir.getAbsolutePath()
                                + File.separator + pesananDto.getFile().getOriginalFilename());
                try (BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile)) //pembacaan data binary dari sebuah file
                ) {
                    stream.write(bytes);      
                }
                
                ModelAndView mdl = new ModelAndView();
                pesananService.doUpdateDataBelanja(pesananDto);
                return "redirect:pesananPembeli.htm";
            } catch (Exception e) {
                    return "gagal upload " + pesananDto.getFile().getName() + " => " + e.getMessage();
            }
        } else {
                return "file kosong " + pesananDto.getFile().getName();
        }
    }
    
    @RequestMapping(value = "/saveProduk", method = RequestMethod.POST)
    public String saveDataSiswa(@ModelAttribute ProdukDto produkDto, ModelMap model){   
//        if (!produkDto.getFile().isEmpty()) {
            try {
//                byte[] bytes = produkDto.getFile().getBytes();
//
//                // Creating the directory to store file
//                String rootPath = "C:\\Users\\HP\\Documents\\NetBeansProjects\\E-Commerce\\web\\b\\img" ;
//                File dir = new File(rootPath);//rootPath itu url nya..
//                if (!dir.exists())
//                        dir.mkdirs();//mkdirs() untuk membuat sebuah direktori baru, terdapat pd klas file
//                
//                File serverFile = new File(dir.getAbsolutePath()
//                                + File.separator + produkDto.getFile().getOriginalFilename());
//                BufferedOutputStream stream = new BufferedOutputStream(
//                                new FileOutputStream(serverFile));//pembacaan data binary dari sebuah file
               // SerialBlob blob = new javax.sql.rowset.serial.SerialBlob(IOUtils.toByteArray(file.getInputStream()));
//                javax.sql.rowset.serial.SerialBlob sb = new SerialBlob((java.sql.Blob) file.getInputStream());
////			dto.setGambar(file.getOriginalFilename());
                //SerialBlob blob = new SerialBlob(file.getBytes());
		//produkDto.setImage(blob);
//                stream.write(bytes);
//                stream.close();                  
                ModelAndView mdl = new ModelAndView();
                produkService.saveDataProduk(produkDto);  
                
            } catch (Exception e) {
                    
            }
//    }
        return "redirect:tabelProduk.htm"; 
    }
    
    @RequestMapping(value = "/doTambahDataProduk", method = RequestMethod.GET)
    public String doTambahDataProduk(ModelMap model) throws IOException{
        ProdukDto dto = null;    
        List<KategoriDto> listKodeKategori = null;   
        
        try {
            dto = new ProdukDto();
//            SerialBlob blob = new javax.sql.rowset.serial.SerialBlob(IOUtils.toByteArray(file.getInputStream()));
//
//			dto.setGambar(file.getOriginalFilename());
//			dto.setImage(blob);
            model.addAttribute("produkDto", dto);
            listKodeKategori = kategoriService.getListKategori();
            model.addAttribute("listKk", listKodeKategori);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "insertProduk";
    }
    
    @RequestMapping(value = "/saveDetail", method = RequestMethod.POST)
    public String saveDataPengeluaran(@ModelAttribute DetailDto detailDto, ModelMap model) throws Exception {
        if (!detailDto.getFile().isEmpty()) {
            try {
                byte[] bytes = detailDto.getFile().getBytes();
//                ServletContext context = session.getServletContext();  
//                String rootPath = context.getRealPath("/b/img");
                String rootPath = "E:\\Amelia\\E-Commerce\\web\\b\\img" ;
                // Creating the directory to store file
                //String rootPath = "E:\\file" ;
                File dir = new File(rootPath);//rootPath itu url nya..
                if (!dir.exists())
                        dir.mkdirs();//mkdirs() untuk membuat sebuah direktori baru, terdapat pd klas file
                
                File serverFile = new File(dir.getAbsolutePath()
                                + File.separator + detailDto.getFile().getOriginalFilename());
                try (BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile)) //pembacaan data binary dari sebuah file
                ) {
                    stream.write(bytes);      
                }
                
                ModelAndView mdl = new ModelAndView();
                detailService.saveDataDetail(detailDto);
                return "redirect:tabelDetail.htm";
            } catch (Exception e) {
                    return "gagal upload " + detailDto.getFile().getName() + " => " + e.getMessage();
            }
        } else {
                return "file kosong " + detailDto.getFile().getName();
        }
    }

    @RequestMapping(value = "/doTambahDataDetail", method = RequestMethod.GET)
    public String doTambahDataDetail(ModelMap model) throws IOException{
        DetailDto dto = null;    
        List<ProdukDto> listKodeProduk = null;   
        try {
            dto = new DetailDto();
            model.addAttribute("detailDto", dto);
            listKodeProduk = produkService.getListProduk();
            model.addAttribute("listProd", listKodeProduk);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "insertDetail";
    }
    
    @RequestMapping(value = "/deleteDataDetail", method = RequestMethod.GET)
    public String hapusData2(String kode_detail, ModelMap model) throws Exception{        
        detailService.deleteDataDetail(kode_detail);
        return "redirect:tabelDetail.htm";
    }
    
    @RequestMapping(value = "/getDataUpdateDetail", method = RequestMethod.GET)
    public String getUpdateDataDetail(String kode_detail, ModelMap model) throws Exception{
        DetailDto detailDto =detailService.getUpdateDataDetail(kode_detail);
        model.addAttribute("detailDto", detailDto);
        List<ProdukDto> listKodeProduk = null; 
        listKodeProduk = produkService.getListProduk();
        model.addAttribute("listProd", listKodeProduk);
        return "updateDetail";
    }
    
    @RequestMapping(value = "/updateDetail", method = RequestMethod.POST)
    public String editDataDetail(DetailDto detailDto) throws Exception{
        if (!detailDto.getFile().isEmpty()) {
            try {
                byte[] bytes = detailDto.getFile().getBytes();
//                ServletContext context = session.getServletContext();  
//                String rootPath = context.getRealPath("/b/img");
                String rootPath = "E:\\Amelia\\E-Commerce\\web\\b\\img" ;
                // Creating the directory to store file
                //String rootPath = "E:\\file" ;
                File dir = new File(rootPath);//rootPath itu url nya..
                if (!dir.exists())
                        dir.mkdirs();//mkdirs() untuk membuat sebuah direktori baru, terdapat pd klas file
                
                File serverFile = new File(dir.getAbsolutePath()
                                + File.separator + detailDto.getFile().getOriginalFilename());
                try (BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile)) //pembacaan data binary dari sebuah file
                ) {
                    stream.write(bytes);      
                }
                
                ModelAndView mdl = new ModelAndView();
                detailService.doUpdateDataDetail(detailDto);
                return "redirect:tabelDetail.htm";
            } catch (Exception e) {
                    return "gagal upload " + detailDto.getFile().getName() + " => " + e.getMessage();
            }
        } else {
                return "file kosong " + detailDto.getFile().getName();
        }
    }
    
    
    @RequestMapping(value = "/deleteDataProduk", method = RequestMethod.GET)
    public String hapusData(String kode_produk, ModelMap model) throws Exception{        
        produkService.deleteDataProduk(kode_produk);
        return "redirect:tabelProduk.htm";
    }
    
    @RequestMapping(value = "/getDataUpdateProduk", method = RequestMethod.GET)
    public String getUpdateDataProduk(String kode_produk, ModelMap model) throws Exception{   
        List<KategoriDto> listKodeKategori = null;   
        listKodeKategori = kategoriService.getListKategori();
        model.addAttribute("listKk", listKodeKategori);
        ProdukDto produkDto =produkService.getUpdateDataProduk(kode_produk);
        model.addAttribute("produkDto", produkDto);
        return "updateProduk";
    }
    
    @RequestMapping(value = "/updateProduk", method = RequestMethod.POST)
    public String editData2(ProdukDto produkDto) throws Exception{
        produkService.doUpdateDataProduk(produkDto);
        return "redirect:tabelProduk.htm";
    }
    
    @RequestMapping(value = "/tabelProduk", method = RequestMethod.GET)
    public String viewTabelProduk(ModelMap model){
        try {
            List<ProdukDto> listProdukDto = produkService.getListProduk();
            model.addAttribute("listProdukDto", listProdukDto);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return "tabelProduk";
    }
    
    @RequestMapping(value = "/tabelDetail", method = RequestMethod.GET)
    public String viewTabelDetail(ModelMap model){
        try {
            List<DetailDto> listDetailDto = detailService.getListDetail();
            model.addAttribute("listDetailDto", listDetailDto);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return "tabelDetail";
    }
   
    @RequestMapping(value = "/tabelPesanan", method = RequestMethod.GET)
    public String viewTabelPesanan(ModelMap model){
        try {
            List<PesananDto> listPesananDto = pesananService.getPesananStatusBaru();
            model.addAttribute("listPesananDto", listPesananDto);
            List<PesananDto> listPesananRejectDto = pesananService.getPesananStatusReject();
            model.addAttribute("listPesananRejectDto", listPesananRejectDto);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return "tabelPesanan";
    }
    @RequestMapping(value = "/updateConfirm", method = RequestMethod.GET)
    public String updateConfirm(String kode_pesanan, ModelMap model) throws Exception {
        pesananService.Confirm(kode_pesanan);
        return "redirect:tabelPesanan.htm";
    }
    
    @RequestMapping(value = "/updateDikirim", method = RequestMethod.GET)
    public String updateDikirim(String kode_pesanan, ModelMap model) throws Exception {
        pesananService.Dikirim(kode_pesanan);
        return "redirect:tabelPesanan2.htm";
    }
    
    @RequestMapping(value = "/cetak", method = RequestMethod.GET)
    public String viewCetak(String kode_pesanan,ModelMap model) throws Exception{
        List<CartDto> listCartDto=cartService.getListCartByIdPembeli(id);
        model.addAttribute("listCartDto", listCartDto);
        List<PenerimaDto> listPenerima=penerimaService.getPenerimaByKodePesanan(kode_pesanan);
        List<PesananDto> listProduk=pesananService.getDetailPesanan(kode_pesanan);
        model.addAttribute("listPenerimaDto",listPenerima);
        model.addAttribute("listProdukDto",listProduk);
        return "cetakAlamatPenerima";
    }
    
    @RequestMapping(value = "/updateReject", method = RequestMethod.GET)
    public String updateReject(String kode_pesanan, ModelMap model) throws Exception {
        pesananService.Reject(kode_pesanan);
        return "redirect:tabelPesanan.htm";
    }
    
    @RequestMapping(value = "/tabelPesanan2", method = RequestMethod.GET)
    public String viewTabelPesanan2(ModelMap model){
        try {
            List<PesananDto> listPesananDto = pesananService.getPesananStatusSudahBayar();
            model.addAttribute("listPesananDto", listPesananDto);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return "tabelPesanan2";
    }
    
    @RequestMapping(value = "/tabelPesanan3", method = RequestMethod.GET)
    public String viewTabelPesanan3(ModelMap model){
        try {
            List<PesananDto> listPesananDto = pesananService.getPesananStatusBelumBayar();
            model.addAttribute("listPesananDto", listPesananDto);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return "tabelPesanan3";
    }
    
    @RequestMapping(value = "/tabelDetailPesanan", method = RequestMethod.GET)
    public String viewTabelDetailPesanan(ModelMap model){
        try {
            List<DetailPesananDto> listDetailPesananDto = detailPesananService.getListDetailPesanan();
            model.addAttribute("listDetailPesananDto", listDetailPesananDto);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return "tabelDetailPesanan";
    }
    
    @RequestMapping(value = "/deleteDataBelanja", method = RequestMethod.GET)
    public String hapusDataBelanja(String kode_belanja, ModelMap model) throws Exception{        
        pesananService.deleteDataBelanja(kode_belanja);
        return "redirect:tabelPenjualan.htm";
    }
    
    @RequestMapping(value = "/getDataUpdateBelanja", method = RequestMethod.GET)
    public String getUpdateDataPenjualan(String kode_belanja, ModelMap model) throws Exception{   
        List<ProdukDto> listKodeProduk = null;   
        listKodeProduk = produkService.getListProduk();
        model.addAttribute("listKp", listKodeProduk);
        PesananDto belanjaDto =pesananService.getUpdateDataBelanja(kode_belanja);
        model.addAttribute("belanjaDto", belanjaDto);
        return "updateBelanja";
    }
    
     @RequestMapping(value = "/updateBelanja", method = RequestMethod.POST)
    public String editDataPenjualan(PesananDto belanjaDto) throws Exception{
        pesananService.doUpdateDataBelanja(belanjaDto);
        return "redirect:tabelBelanja.htm";
    }
    
    @RequestMapping(value = "/tabelPembeli", method = RequestMethod.GET)
    public String viewTabelPembeli(ModelMap model){
        try {
            List<PembeliDto> listPembeliDto = pembeliService.getListPembeli();
            model.addAttribute("listPembeliDto", listPembeliDto);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return "tabelPembeli";
    }
    
     @RequestMapping(value = "/saveKeranjang", method = RequestMethod.POST)
    public String saveDataKeranjang(CartDto cartDto,String kode_detail,ModelMap model) throws Exception{
        jmlProd=cartDto.getKuantitas();
        kode_detail=kodeDetail;
        cartService.saveDataCart(cartDto,kode_detail,kodeProd,id,jmlProd);
        List<CartDto> listCartDto=cartService.getListCartByIdPembeli(id);
        model.addAttribute("listCartDto", listCartDto);
        return "redirect:menuBaru.htm?id_pembeli="+id;
    } 
    
    
    @RequestMapping(value = "/menuAdmin", method = RequestMethod.GET)
    public String viewMenuAdm(ModelMap model,NotivDto notivDto) throws Exception{
        if(cek==1){
             notivDto.setSukses(x);
             notivDto.setAkses(akses);
         }
        cek=0;
        model.addAttribute("notivDto", notivDto);
        LoginDto login=loginService.getUpdateDataLogin(id_login);
        model.addAttribute("id_login", id_login);
        List<PesananDto> listPesananDto = pesananService.getPesananStatusBaru();
        model.addAttribute("listPesananDto", listPesananDto);
        return "menuAdmin";
    }
    
    @RequestMapping(value = "/menuOwner", method = RequestMethod.GET)
    public String viewMenuOwner(ModelMap model,NotivDto notivDto){
        if(cek==1){
             notivDto.setSukses(x);
             notivDto.setAkses(akses);
         }
        cek=0;
        model.addAttribute("notivDto", notivDto);
        List<PengeluaranDto> ListPengeluaranCek=pengeluaranService.doGetDataPengeluaranWithAccountNameCek();
        model.addAttribute("listPengeluaranCek", ListPengeluaranCek);
        return "menuOwner";
    }
    
    @RequestMapping(value = "/menuPembeli", method = RequestMethod.GET)
    public String viewMenuPembeli(ModelMap model,NotivDto notivDto){
        if(cek==1){
             notivDto.setSukses(x);
         }
        cek=0;
        model.addAttribute("notivDto", notivDto);
        return "menuPembeli";
    }
    
    @RequestMapping(value = "/menuBaru", method = RequestMethod.GET)
    public String viewMenuBaru(ModelMap model,String id_pembeli,NotivDto notivDto){
        if(cek==1){
             notivDto.setSukses(x);
         }
        cek=0;
        model.addAttribute("notivDto", notivDto);
        try {
            List<DetailDto> listDetailDto = detailService.getListDetail();
            model.addAttribute("listDetailDto", listDetailDto);
            List<CartDto> listCartDto=cartService.getListCartByIdPembeli(id);
            model.addAttribute("listCartDto", listCartDto);
            List<KategoriDto> listKategoriDto=kategoriService.getListKategori();
            model.addAttribute("listKategoriDto", listKategoriDto);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return "menuBaru";
    }
    
    
    @RequestMapping(value = "/getProdukByKategori", method = RequestMethod.GET)
    public String getProdukByKategori(String kode_kategori,String id_pembeli, ModelMap model) throws Exception{
        try {
            List<DetailDto> listDetailDto = detailService.getProdukByKategori(kode_kategori);
            model.addAttribute("listDetailDto", listDetailDto);
            List<CartDto> listCartDto=cartService.getListCartByIdPembeli(id_pembeli);
            model.addAttribute("listCartDto", listCartDto);
            List<KategoriDto> listKategoriDto=kategoriService.getListKategori();
            model.addAttribute("listKategoriDto", listKategoriDto);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return "produkByKategori";
    }
    
    @RequestMapping(value = "/loginPembeli", method = RequestMethod.GET)
    public String viewLogin(ModelMap model,PembeliDto pembeliDto,NotivDto notivDto){
        model.addAttribute("pembeliDto", pembeliDto);
        if(cek==1){
             notivDto.setSukses(x);
             notivDto.setAkses(akses);
         }
        cek=0;
        model.addAttribute("notivDto", notivDto);
        return "loginPembeli";
    }
    
    @RequestMapping(value = "/dataProduk", method = RequestMethod.GET)
    public String viewDataProduk(){
        return "dataProduk";
    }
//    @RequestMapping(value = "doLogin", method = RequestMethod.POST)
//    public void doLogin(LoginDto loginDto, ModelMap model,HttpServletResponse response, HttpServletRequest request) throws Exception{
//        String u= null;
//        dto= loginService.getListDataUserLogin(loginDto);
//        model.addAttribute("userDto", dto);
//        if(dto.getListDataUser().isEmpty()){
//            u="login.htm";
//        } else{
//            uModel=dto.getListDataUser().get(0);
//            LoginDto dd=new LoginDto();
//            if(uModel.getUsername().equals(loginDto.getUsername())){
//              //model.addAttribute("listUserDtoSelect", dto);             
//              //dd=loginService.getDataId(loginDto.getUsername(),loginDto.getPassword());
//              //pp=dd.getId_login();
//              u="masuk.htm";
//             //   formDto.getId_user();
//                
//            }
////            session= request.getSession(true);
////            session.setAttribute("id_user",dto.getId_user());
////            session.setAttribute("username",dto.getUsername());
////            session.setAttribute("jenis_kelamin",dto.getJenis_kelamin());
////            session.setAttribute("alamat",dto.getAlamat());
////            session.setAttribute("no_telp",dto.getNo_telp());
////            session.setAttribute("password",dto.getPassword());
//        }
//        response.sendRedirect(u);
//    }
    
    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public String viewCek(ModelMap model,LoginDto formDto,NotivDto notivDto) throws Exception{
        List<LoginModel> listData = loginDao.getListDataUser();
        model.addAttribute("notivDto", notivDto);
        try {
            listData = loginDao.getListDataUser();
        } catch (Exception ex) {
            Logger.getLogger(LoginServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(listData != null){
            for (LoginModel ddm : listData) {
                if(ddm.getUsername().equals(formDto.getUsername()) && ddm.getPassword().equals(formDto.getPassword())){
                    if(ddm.getAkses().equalsIgnoreCase("Admin")){  
                        x=ddm.getUsername();
                        cek=1;
                        id_login=ddm.getId_login();
                        akses=ddm.getAkses();
                        pesananService.deleteDataBelanjaPesan();
                        return"redirect:menuAdmin.htm?id_login="+id_login;   
                    }else if(ddm.getAkses().equalsIgnoreCase("Owner")){
                        x=ddm.getUsername();
                        cek=1;
                        akses=ddm.getAkses();
                        return"redirect:menuOwner.htm";
                    }else if(ddm.getAkses().equalsIgnoreCase("Pembeli")){
                        id=ddm.getId_pembeli();
                        x=ddm.getUsername();
                        cek=1;
                        akses=ddm.getAkses();
                        pp=ddm.getId_pembeli(); 
                        return"redirect:home.htm?id_pembeli="+pp;
                    }                        
                }
            }
        }
        cek=2;
        x="Gagal login";
        return "redirect:index.htm";
    }
    
    @RequestMapping(value = "/doLoginPembeli", method = RequestMethod.POST)
    public void viewCekLogin(ModelMap model,PembeliDto formDto,NotivDto notivDto,HttpServletResponse response, HttpServletRequest request) throws Exception{
        String u= null;
        dto= pembeliService.getListDataUserLoginPembeli(formDto);
        List<PembeliModel> listData = pembeliDao.getListDataPembeli();
        model.addAttribute("notivDto", notivDto);
        try {
            listData = pembeliDao.getListDataPembeli();
        } catch (Exception ex) {
            Logger.getLogger(PembeliServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(listData != null){
            for (PembeliModel ddm : listData) {
                if(ddm.getUsername().equals(formDto.getUsername()) && ddm.getPassword().equals(formDto.getPassword())){  
                        x=ddm.getUsername();
                        cek=1;
                        PembeliDto dd=new PembeliDto();
                        model.addAttribute("listPembeliDtoSelect", dto);             
                        dd=pembeliService.getDataId(formDto.getUsername(),formDto.getPassword());
                        pp=dd.getId_pembeli();
                        u="home.htm?id_pembeli="+pp;
                        
                }
            }
        }else{
            cek=2;
            x="Gagal login";
            u="loginPembeli.htm";
        }
        
        response.sendRedirect(u);
    }
    
//    @RequestMapping(value = "doLogin", method = RequestMethod.POST)
//    public void doLogin(LoginDto formDto, ModelMap model,HttpServletResponse response, HttpServletRequest request) throws Exception{
//        String u= null;
//        dto= loginService.getListDataUserLogin(formDto);
//        model.addAttribute("loginDto", dto);
//        //u="menuAdmin.htm";
//        if(dto.getListDataUser().isEmpty()){
//            u="index.htm";
//        } else{
//            uModel=dto.getListDataUser().get(0);
//            if(uModel.getUsername().equals(formDto.getUsername())){
//                if(uModel.getAkses().equalsIgnoreCase("Admin")){      
//                    u="menuAdmin.htm";
//                }else if(uModel.getAkses().equalsIgnoreCase("Operator")){
//                    u="menuOperator.htm";
//                }
//             //   formDto.getId_user();
//                
//            }
////            session= request.getSession(true);
////            session.setAttribute("id_user",dto.getId_user());
////            session.setAttribute("username",dto.getUsername());
////            session.setAttribute("jenis_kelamin",dto.getJenis_kelamin());
////            session.setAttribute("alamat",dto.getAlamat());
////            session.setAttribute("no_telp",dto.getNo_telp());
////            session.setAttribute("password",dto.getPassword());
//        }
//        response.sendRedirect(u);
//    }
    
    @RequestMapping(value = "/tabelUlasan", method = RequestMethod.GET)
    public String viewTabelUlasan(ModelMap model){
        try {
            List<UlasanDto> listUlasanDto = ulasanService.getListReview();
            model.addAttribute("listUlasanDto", listUlasanDto);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return "tabelUlasan";
    }
    
    @RequestMapping(value = "/saveUlasan", method = RequestMethod.POST)
    public String saveDataUlasan(@ModelAttribute UlasanDto ulasanDto, ModelMap model) throws Exception{   
        if (!ulasanDto.getFile().isEmpty()) {
            try {
                byte[] bytes = ulasanDto.getFile().getBytes();
//                ServletContext context = session.getServletContext();  
//                String rootPath = context.getRealPath("/b/img");
                String rootPath = "E:\\Amelia\\E-Commerce\\web\\b\\img\\video" ;
                // Creating the directory to store file
                //String rootPath = "E:\\file" ;
                File dir = new File(rootPath);//rootPath itu url nya..
                if (!dir.exists())
                        dir.mkdirs();//mkdirs() untuk membuat sebuah direktori baru, terdapat pd klas file
                
                File serverFile = new File(dir.getAbsolutePath()
                                + File.separator + ulasanDto.getFile().getOriginalFilename());
                try (BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile)) //pembacaan data binary dari sebuah file
                ) {
                    stream.write(bytes);      
                }
                
                ModelAndView mdl = new ModelAndView();
                ulasanService.saveDataReview(ulasanDto);
                return "redirect:tabelUlasan.htm";
            } catch (Exception e) {
                    return "gagal upload " + ulasanDto.getFile().getName() + " => " + e.getMessage();
            }
        } else {
                return "file kosong " + ulasanDto.getFile().getName();
        }
    }
    
    @RequestMapping(value = "/doTambahDataUlasan", method = RequestMethod.GET)
    public String doTambahDataUlasan(ModelMap model){
        UlasanDto dto = null;     
        try {
            dto = new UlasanDto();
            model.addAttribute("ulasanDto", dto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "insertUlasan";
    }
    
    @RequestMapping(value = "/deleteDataUlasan", method = RequestMethod.GET)
    public String hapusDataUlasan(String kode_ulasan, ModelMap model) throws Exception{        
        ulasanService.deleteDataReview(kode_ulasan);
        return "redirect:tabelUlasan.htm";
    }
    
    @RequestMapping(value = "/getDataUpdateUlasan", method = RequestMethod.GET)
    public String getUpdateDataUlasan(String kode_ulasan, ModelMap model) throws Exception{
        UlasanDto ulasanDto =ulasanService.getUpdateDataReview(kode_ulasan);
        model.addAttribute("ulasanDto", ulasanDto);
        return "updateUlasan";
    }
    
    @RequestMapping(value = "/updateUlasan", method = RequestMethod.POST)
    public String editDataUlasan(UlasanDto ulasanDto) throws Exception{
        if (!ulasanDto.getFile().isEmpty()) {
            try {
                byte[] bytes = ulasanDto.getFile().getBytes();
//                ServletContext context = session.getServletContext();  
//                String rootPath = context.getRealPath("/b/img");
                String rootPath = "E:\\Amelia\\E-Commerce\\web\\b\\img\\video" ;
                // Creating the directory to store file
                //String rootPath = "E:\\file" ;
                File dir = new File(rootPath);//rootPath itu url nya..
                if (!dir.exists())
                        dir.mkdirs();//mkdirs() untuk membuat sebuah direktori baru, terdapat pd klas file
                
                File serverFile = new File(dir.getAbsolutePath()
                                + File.separator + ulasanDto.getFile().getOriginalFilename());
                try (BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile)) //pembacaan data binary dari sebuah file
                ) {
                    stream.write(bytes);      
                }
                
                ulasanService.doUpdateDataReview(ulasanDto);
                return "redirect:tabelUlasan.htm";
            } catch (Exception e) {
                    return "gagal upload " + ulasanDto.getFile().getName() + " => " + e.getMessage();
            }
        } else {
                return "file kosong " + ulasanDto.getFile().getName();
        }  
    }
    
    @RequestMapping(value = "/ulasanVideo", method = RequestMethod.GET)
    public String viewUlasan(ModelMap model){
        try {
            List<UlasanDto> listUlasanDto = ulasanService.getListReview();
            model.addAttribute("listUlasanDto", listUlasanDto);
            List<CartDto> listCartDto=cartService.getListCartByIdPembeli(id);
            model.addAttribute("listCartDto", listCartDto);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return "ulasanVideo";
    }
    
    @RequestMapping(value = "/tabelAdmin", method = RequestMethod.GET)
    public String viewTabelAdmin(ModelMap model){
        try {
            List<LoginDto> listAdminDto = loginService.getListLoginAdmin();
            model.addAttribute("listAdminDto", listAdminDto);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return "tabelAdmin";
    }
    
    @RequestMapping(value = "/saveAdmin", method = RequestMethod.POST)
    public String saveDataAdmin(LoginDto loginDto, ModelMap model) throws Exception{                
        ModelAndView mdl = new ModelAndView();
        loginService.saveDataLogin(loginDto);                
        return "redirect:tabelAdmin.htm";
    }
    
    @RequestMapping(value = "/doTambahDataAdmin", method = RequestMethod.GET)
    public String doTambahDataAdmin(ModelMap model){
        LoginDto dto = null;     
        try {
            dto = new LoginDto();
            model.addAttribute("adminDto", dto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "insertAdmin";
    }
    
    @RequestMapping(value = "/deleteDataAdmin", method = RequestMethod.GET)
    public String hapusDataAdmin(String id_login, ModelMap model) throws Exception{        
        loginService.deleteDataLogin(id_login);
        return "redirect:tabelAdmin.htm";
    }
    
    @RequestMapping(value = "/getDataUpdateAdmin", method = RequestMethod.GET)
    public String getUpdateDataAdmin(String id_login, ModelMap model) throws Exception{
        LoginDto loginDto =loginService.getUpdateDataLogin(id_login);
        model.addAttribute("adminDto", loginDto);
        return "updateAdmin";
    }
    
    @RequestMapping(value = "/updateAdmin", method = RequestMethod.POST)
    public String editDataAdmin(LoginDto loginDto) throws Exception{
        loginService.doUpdateDataLogin(loginDto);
        return "redirect:tabelAdmin.htm";
    }
    
    @RequestMapping(value = "/tabelAkun", method = RequestMethod.GET)
    public String viewAkun(ModelMap model) {
        try {
            List<AkunDto> listAkunDto = akunService.getListAkun();
            model.addAttribute("listAkunDto", listAkunDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "tabelAkun";
    }
    
    @RequestMapping(value = "/deleteDataAkun", method = RequestMethod.GET)
    public String hapusDataAkun(String kode_akun, ModelMap model) throws Exception {
        akunService.deleteDataAkun(kode_akun);
        return "redirect:tabelAkun.htm";
    }
    
    @RequestMapping(value = "/saveDataAkun", method = RequestMethod.POST)
    public String saveDataAkun(AkunDto akunDto, ModelMap model) throws Exception {
        ModelAndView mdl = new ModelAndView();
        akunService.saveDataAkun(akunDto);
        return "redirect:tabelAkun.htm";
    }

    @RequestMapping(value = "/doTambahDataAkun", method = RequestMethod.GET)
    public String doTambahDataAkun(ModelMap model) {
        AkunDto dto = null;

        try {
            dto = new AkunDto();
            model.addAttribute("akunDto", dto);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "insertAkun";
    }
    
    @RequestMapping(value = "/updateDataAkun", method = RequestMethod.POST)
    public String editData(AkunDto akunDto) throws Exception {
        akunService.doUpdateDataAkun(akunDto);
        return "redirect:tabelAkun.htm";
    }

    @RequestMapping(value = "/getDataUpdateAkun", method = RequestMethod.GET)
    public String getUpdateDataAkun(String kode_akun, ModelMap model) throws Exception {
        AkunDto akunDto = akunService.getUpdateDataAkun(kode_akun);
        model.addAttribute("akunDto", akunDto);
        return "updateAkun";
    }
   
    @RequestMapping(value = "/tabelPengeluaran", method = RequestMethod.GET)
    public String viewPengeluaran(ModelMap model) {
        try {
            List<PengeluaranDto> listPengeluaranDto = pengeluaranService.doGetDataPengeluaranWithAccountName();
            model.addAttribute("listPengeluaranDto", listPengeluaranDto);
            List<PengeluaranDto> listPengeluaranDtoCek = pengeluaranService.getListPengeluaraCek();
            model.addAttribute("listPengeluaranDtoCek", listPengeluaranDtoCek);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "tabelPengeluaran";
    }
    
    @RequestMapping(value = "/tabelPengeluaranForOwner", method = RequestMethod.GET)
    public String viewPengeluaranForOwner(ModelMap model) {
        try {
            List<PengeluaranDto> listPengeluaranDto = pengeluaranService.doGetDataPengeluaranWithAccountName();
            model.addAttribute("listPengeluaranDto", listPengeluaranDto);
            List<PengeluaranDto> listPengeluaranDtoCek = pengeluaranService.doGetDataPengeluaranWithAccountNameCek();
            model.addAttribute("listPengeluaranDtoCek", listPengeluaranDtoCek);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "tabelPengeluaranForOwner";
    }
    
    @RequestMapping(value = "/updateApproved", method = RequestMethod.GET)
    public String updateApproved(String kode_pengeluaran, ModelMap model) throws Exception {
        pengeluaranService.Approved(kode_pengeluaran);
        return "redirect:tabelPengeluaranForOwner.htm";
    }
    @RequestMapping(value = "/updateDisapprove", method = RequestMethod.GET)
    public String updateDisapprove(String kode_pengeluaran, ModelMap model) throws Exception {
        pengeluaranService.Disapproved(kode_pengeluaran);
        return "redirect:tabelPengeluaranForOwner.htm";
    }
    
    @RequestMapping(value = "/deleteDataPengeluaran", method = RequestMethod.GET)
    public String hapusDataPengeluaran(String kode_pengeluaran, ModelMap model) throws Exception {
        pengeluaranService.deleteDataPengeluaran(kode_pengeluaran);
        return "redirect:tabelPengeluaran.htm";
    }
    
    @RequestMapping(value = "/saveDataPengeluaran", method = RequestMethod.POST)
    public String saveDataPengeluaran( @ModelAttribute PengeluaranDto pengeluaranDto, ModelMap model) throws Exception {
        
        
        if (!pengeluaranDto.getFile().isEmpty()) {
            try {
                byte[] bytes = pengeluaranDto.getFile().getBytes();  
                String rootPath = "E:\\Amelia\\E-Commerce\\web\\b\\img\\bukti pengeluaran"; 
//                System.out.println("tampilannya :"+);
//
//                // Creating the directory to store file
//                String rootPath = System.getProperty("catalina.home");
                System.out.println("rootnya "+rootPath);
                File dir = new File(rootPath);//rootPath itu url nya..
                if (!dir.exists())
                        dir.mkdirs();//mkdirs() untuk membuat sebuah direktori baru, terdapat pd klas file
                
                File serverFile = new File(dir.getAbsolutePath()
                                + File.separator + pengeluaranDto.getFile().getOriginalFilename());
                BufferedOutputStream stream = new BufferedOutputStream(
                                new FileOutputStream(serverFile));//pembacaan data binary dari sebuah file
                stream.write(bytes);
                stream.close();      
                
                ModelAndView mdl = new ModelAndView();
                pengeluaranService.saveDataPengeluaran(pengeluaranDto);
                return "redirect:tabelPengeluaran.htm";
            } catch (Exception e) {
                    return "gagal upload " + pengeluaranDto.getFile().getName() + " => " + e.getMessage();
            }
        } else {
                return "file kosong " + pengeluaranDto.getFile().getName();
        }
    }

    @RequestMapping(value = "/doTambahDataPengeluaran", method = RequestMethod.GET)
    public String doTambahDataPengeluaran(ModelMap model) {
        PengeluaranDto dto = null;
        List<AkunDto> listKodeAkun = null;
        try {
            dto = new PengeluaranDto();
            model.addAttribute("pengeluaranDto", dto);
            listKodeAkun = akunService.getListAkun();
            model.addAttribute("listKk", listKodeAkun);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "insertPengeluaran";
    }
    
    @RequestMapping(value = "/updateDataPengeluaran", method = RequestMethod.POST)
    public String editData(PengeluaranDto pengeluaranDto) throws Exception {
        pengeluaranService.doUpdateDataPengeluaran(pengeluaranDto);
        return "redirect:tabelPengeluaran.htm";
    }

    @RequestMapping(value = "/getDataUpdatePengeluaran", method = RequestMethod.GET)
    public String getUpdateDataPengeluaran(String kode_pengeluaran, ModelMap model) throws Exception {
        PengeluaranDto pengeluaranDto = pengeluaranService.getUpdateDataPengeluaran(kode_pengeluaran);
        model.addAttribute("pengeluaranDto", pengeluaranDto);
        List<AkunDto> akunDto1 = akunService.getListAkun();
        model.addAttribute("listkp", akunDto1);
        return "updateDataPengeluaran";
    }
    
    @RequestMapping(value = "/pesananPembeli", method = RequestMethod.GET)
    public String viewPesananPembeli(ModelMap model,PesananDto pesananDto){
        KategoriDto dto = null;     
            dto = new KategoriDto();
            model.addAttribute("kategoriDto", dto);
       
        List<CartDto> listCartDto=cartService.getListCartByIdPembeli(id);
        List<PenerimaDto> listPenerimaDto=penerimaService.getListPenerimaById(id);
        List<PesananDto> listPesananDto=pesananService.getBelanjaByIdPembeli(id);
        //List<PesananDto> listPesananDto=pesananService.getListPesananByIdPembeli(id);
        PenerimaDto penerimaDto=new PenerimaDto();
        try {
            model.addAttribute("listCartDto", listCartDto);
            model.addAttribute("pesananDto", pesananDto);
            model.addAttribute("listPenerimaDto", listPenerimaDto);
            model.addAttribute("listPesananDto", listPesananDto);
            model.addAttribute("penerimaDto",penerimaDto);
            model.addAttribute("listPesananDto", listPesananDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "pesananPembeli";
    }
    
    @RequestMapping(value = "/getDataUpdateLogin", method = RequestMethod.GET)
    public String getUpdateDataLogin(ModelMap model) throws Exception{   
        LoginDto loginDto =loginService.getUpdateDataLogin(id_login);
        model.addAttribute("loginDto", loginDto);
        return "changePassword";
    }
    
    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    public String editData(LoginDto loginDto) throws Exception{
        loginService.doUpdateDataLogin(loginDto);
        return "redirect:menuAdmin.htm";
    }
    @RequestMapping(value = "/uploadBuktiTransfer", method = RequestMethod.GET)
    public String viewUpload(ModelMap model,LoginDto loginDto,NotivDto notivDto){
        return "uploadBuktiTransfer";
    }
    @RequestMapping(value = "/getGrafik", method = RequestMethod.GET)
    @ResponseBody
    public String getDataGrafik() throws Exception {
        List<PesananDto> listGrafik = pesananService.GrafikProdukToko();
        return new Gson().toJson(listGrafik);
    }
    
    @RequestMapping(value = "/getDataLaporanOwner", method = RequestMethod.GET)
    public String getDataLaporanOwner(LaporanDto laporanDto, ModelMap model) throws Exception {
        try {
            String bulan="";
            if(laporanDto.getBulan().equalsIgnoreCase("Januari")){
                bulan = "01";
            }else if(laporanDto.getBulan().equalsIgnoreCase("Februari")){
                bulan = "02"; 
            }else if(laporanDto.getBulan().equalsIgnoreCase("Maret")){
                bulan = "03";
            }else if(laporanDto.getBulan().equalsIgnoreCase("April")){
                bulan  = "04";
            }else if(laporanDto.getBulan().equalsIgnoreCase("Mei")){
                bulan = "05";
            }else if(laporanDto.getBulan().equalsIgnoreCase("Juni")){
                bulan = "06";
            }else if(laporanDto.getBulan().equalsIgnoreCase("Juli")){
                bulan = "07";
            }else if(laporanDto.getBulan().equalsIgnoreCase("Agustus")){
                bulan = "08";
            }else if(laporanDto.getBulan().equalsIgnoreCase("September")){
                bulan = "09";
            }else if(laporanDto.getBulan().equalsIgnoreCase("Oktober")){
                bulan = "10";
            }else if(laporanDto.getBulan().equalsIgnoreCase("Novenber")){
                bulan = "11";
            }else if(laporanDto.getBulan().equalsIgnoreCase("Desember")){
                bulan = "12";
            }
           // String tahunBulan = customerDto.getTanggal_penjualan()+"-"+bulan+"%";
            String periodeTahun = laporanDto.getTanggal_penjualan();
            List<PesananDto> listProdukDto =pesananService.getProdukTerjual(periodeTahun,bulan);
            model.addAttribute("listProdukDto", listProdukDto);
            model.addAttribute("periodeBulan", laporanDto.getBulan());
            model.addAttribute("periodeTahun", periodeTahun);
            int jmlPenjualan=0;
            for(PesananDto pesanan : listProdukDto){
                jmlPenjualan+=pesanan.getTotal_pesanan();
            }
            model.addAttribute("totalPenjualan", jmlPenjualan);
            
            List<PengeluaranDto> listPengeluaranDto = pengeluaranService.doGetDataLaporanPengeluaran(periodeTahun,bulan);
            model.addAttribute("listPengeluaranDto", listPengeluaranDto);
            int jmlPengeluaran=0;
            for(PengeluaranDto pengeluaran : listPengeluaranDto){
                jmlPengeluaran+=pengeluaran.getJumlah();
            }
            model.addAttribute("totalPengeluaran", jmlPengeluaran);
            model.addAttribute("labaRugi", jmlPenjualan-jmlPengeluaran);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "laporanLabaRugiOwner";
    }
    
    @RequestMapping(value = "/getDataLaporan", method = RequestMethod.GET)
    public String getDataLaporan(LaporanDto laporanDto, ModelMap model) throws Exception {
        try {
            String bulan="";
            if(laporanDto.getBulan().equalsIgnoreCase("Januari")){
                bulan = "01";
            }else if(laporanDto.getBulan().equalsIgnoreCase("Februari")){
                bulan = "02"; 
            }else if(laporanDto.getBulan().equalsIgnoreCase("Maret")){
                bulan = "03";
            }else if(laporanDto.getBulan().equalsIgnoreCase("April")){
                bulan  = "04";
            }else if(laporanDto.getBulan().equalsIgnoreCase("Mei")){
                bulan = "05";
            }else if(laporanDto.getBulan().equalsIgnoreCase("Juni")){
                bulan = "06";
            }else if(laporanDto.getBulan().equalsIgnoreCase("Juli")){
                bulan = "07";
            }else if(laporanDto.getBulan().equalsIgnoreCase("Agustus")){
                bulan = "08";
            }else if(laporanDto.getBulan().equalsIgnoreCase("September")){
                bulan = "09";
            }else if(laporanDto.getBulan().equalsIgnoreCase("Oktober")){
                bulan = "10";
            }else if(laporanDto.getBulan().equalsIgnoreCase("Novenber")){
                bulan = "11";
            }else if(laporanDto.getBulan().equalsIgnoreCase("Desember")){
                bulan = "12";
            }
           // String tahunBulan = customerDto.getTanggal_penjualan()+"-"+bulan+"%";
            String periodeTahun = laporanDto.getTanggal_penjualan();
            List<PesananDto> listProdukDto =pesananService.getProdukTerjual(periodeTahun,bulan);
            model.addAttribute("listProdukDto", listProdukDto);
            model.addAttribute("periodeBulan", laporanDto.getBulan());
            model.addAttribute("periodeTahun", periodeTahun);
            int jmlPenjualan=0;
            for(PesananDto pesanan : listProdukDto){
                jmlPenjualan+=pesanan.getTotal_pesanan();
            }
            model.addAttribute("totalPenjualan", jmlPenjualan);
            
            List<PengeluaranDto> listPengeluaranDto = pengeluaranService.doGetDataLaporanPengeluaran(periodeTahun,bulan);
            model.addAttribute("listPengeluaranDto", listPengeluaranDto);
            int jmlPengeluaran=0;
            for(PengeluaranDto pengeluaran : listPengeluaranDto){
                jmlPengeluaran+=pengeluaran.getJumlah();
            }
            model.addAttribute("totalPengeluaran", jmlPengeluaran);
            model.addAttribute("labaRugi", jmlPenjualan-jmlPengeluaran);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "laporanLabaRugi";
    }
    
    @RequestMapping(value = "/getDataLaporanPenjualanOwner", method = RequestMethod.GET)
    public String getDataLaporanPenjualanOwner(LaporanDto laporanDto, ModelMap model) throws Exception {
        try {
            String bulan="";
            if(laporanDto.getBulan().equalsIgnoreCase("Januari")){
                bulan = "01";
            }else if(laporanDto.getBulan().equalsIgnoreCase("Februari")){
                bulan = "02"; 
            }else if(laporanDto.getBulan().equalsIgnoreCase("Maret")){
                bulan = "03";
            }else if(laporanDto.getBulan().equalsIgnoreCase("April")){
                bulan  = "04";
            }else if(laporanDto.getBulan().equalsIgnoreCase("Mei")){
                bulan = "05";
            }else if(laporanDto.getBulan().equalsIgnoreCase("Juni")){
                bulan = "06";
            }else if(laporanDto.getBulan().equalsIgnoreCase("Juli")){
                bulan = "07";
            }else if(laporanDto.getBulan().equalsIgnoreCase("Agustus")){
                bulan = "08";
            }else if(laporanDto.getBulan().equalsIgnoreCase("September")){
                bulan = "09";
            }else if(laporanDto.getBulan().equalsIgnoreCase("Oktober")){
                bulan = "10";
            }else if(laporanDto.getBulan().equalsIgnoreCase("Novenber")){
                bulan = "11";
            }else if(laporanDto.getBulan().equalsIgnoreCase("Desember")){
                bulan = "12";
            }
           // String tahunBulan = customerDto.getTanggal_penjualan()+"-"+bulan+"%";
            String periodeTahun = laporanDto.getTanggal_penjualan();
            List<PesananDto> listProdukDto =pesananService.getMakeLaporanPenjualan(periodeTahun,bulan);
            model.addAttribute("listProdukDto", listProdukDto);
            model.addAttribute("periodeBulan", laporanDto.getBulan());
            model.addAttribute("periodeTahun", periodeTahun);
            int jmlPesanan=0;
            for(PesananDto pesanan : listProdukDto ){
                jmlPesanan+=pesanan.getTotal_pesanan();
            }
            model.addAttribute("totalPesanan", jmlPesanan);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "laporanPenjualanOwner";
    }
    
    @RequestMapping(value = "/getDataLaporanPenjualan", method = RequestMethod.GET)
    public String getDataLaporanPenjualan(LaporanDto laporanDto, ModelMap model) throws Exception {
        try {
            String bulan="";
            if(laporanDto.getBulan().equalsIgnoreCase("Januari")){
                bulan = "01";
            }else if(laporanDto.getBulan().equalsIgnoreCase("Februari")){
                bulan = "02"; 
            }else if(laporanDto.getBulan().equalsIgnoreCase("Maret")){
                bulan = "03";
            }else if(laporanDto.getBulan().equalsIgnoreCase("April")){
                bulan  = "04";
            }else if(laporanDto.getBulan().equalsIgnoreCase("Mei")){
                bulan = "05";
            }else if(laporanDto.getBulan().equalsIgnoreCase("Juni")){
                bulan = "06";
            }else if(laporanDto.getBulan().equalsIgnoreCase("Juli")){
                bulan = "07";
            }else if(laporanDto.getBulan().equalsIgnoreCase("Agustus")){
                bulan = "08";
            }else if(laporanDto.getBulan().equalsIgnoreCase("September")){
                bulan = "09";
            }else if(laporanDto.getBulan().equalsIgnoreCase("Oktober")){
                bulan = "10";
            }else if(laporanDto.getBulan().equalsIgnoreCase("Novenber")){
                bulan = "11";
            }else if(laporanDto.getBulan().equalsIgnoreCase("Desember")){
                bulan = "12";
            }
            
            String periodeTahun = laporanDto.getTanggal_penjualan();
            List<PesananDto> listProdukDto =pesananService.getMakeLaporanPenjualan(periodeTahun,bulan);
            model.addAttribute("listProdukDto", listProdukDto);
            model.addAttribute("periodeBulan", laporanDto.getBulan());
            model.addAttribute("periodeTahun", periodeTahun);
            int jmlPesanan=0;
            for(PesananDto pesanan : listProdukDto ){
                jmlPesanan+=pesanan.getTotal_pesanan();
            }
            model.addAttribute("totalPesanan", jmlPesanan);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "laporanPenjualan";
    }
    
    @RequestMapping(value = "/doSelectTahunLaporanOwner", method = RequestMethod.GET)
    public String doSelectTahunLaporanOwner(String value,ModelMap model) {
        PesananDto dto = null;
        List<PesananDto > listTahun = null;
        try {
            dto = new PesananDto();
            model.addAttribute("laporanDto", dto);
            listTahun = pesananService.getTahunToMakeLaporan();
            model.addAttribute("listKk", listTahun);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "insertLaporanOwner";
    }
    
    @RequestMapping(value = "/doSelectTahunLaporan", method = RequestMethod.GET)
    public String doSelectTahunLaporan(String value,ModelMap model) {
        PesananDto dto = null;
        List<PesananDto > listTahun = null;
        try {
            dto = new PesananDto();
            model.addAttribute("laporanDto", dto);
            listTahun = pesananService.getTahunToMakeLaporan();
            model.addAttribute("listKk", listTahun);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "insertLaporan";
    }
    
    @RequestMapping(value = "/doSelectTahunLaporanPenjualanOwner", method = RequestMethod.GET)
    public String doSelectTahunLaporanPenjualanOwner(String value,ModelMap model) {
        PesananDto dto = null;
        List<PesananDto > listTahun = null;
        try {
            dto = new PesananDto();
            model.addAttribute("laporanDto", dto);
            listTahun = pesananService.getTahunToMakeLaporan();
            model.addAttribute("listKk", listTahun);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "insertLaporanPenjualanOwner";
    }
    
    @RequestMapping(value = "/doSelectTahunLaporanPenjualan", method = RequestMethod.GET)
    public String doSelectTahunLaporanPenjualan(String value,ModelMap model) {
        PesananDto dto = null;
        List<PesananDto > listTahun = null;
        try {
            dto = new PesananDto();
            model.addAttribute("laporanDto", dto);
            listTahun = pesananService.getTahunToMakeLaporan();
            model.addAttribute("listKk", listTahun);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "insertLaporanPenjualan";
    }
    
    @RequestMapping(value = "/tabelProdukForOwner", method = RequestMethod.GET)
    public String viewtabel(ModelMap model,String id_pembeli,NotivDto notivDto){
        try {
            List<DetailDto> listDetailDto = detailService.getListDetail();
            model.addAttribute("listDetailDto", listDetailDto);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return "tabelProdukForOwner";
    }
    
    @RequestMapping(value = "/deleteDataKeranjang", method = RequestMethod.GET)
    public String hapusData3(String kode_cart, ModelMap model) throws Exception{        
        cartService.deleteDataCart(kode_cart);
        return "redirect:menuBaru.htm";
    }
    
    @RequestMapping(value = "/deleteDataPenerima", method = RequestMethod.GET)
    public String hapusData4(String id_penerima, ModelMap model) throws Exception{        
        penerimaService.deleteDataPenerima(id_penerima);
        return "redirect:detailKeranjang.htm";
    }
    
    @RequestMapping(value = "/getDataUpdatePenerima", method = RequestMethod.GET)
    public String getUpdateDataPenerima(String id_penerima, ModelMap model) throws Exception{
        PenerimaDto penerimaDto =penerimaService.getUpdateDataPenerima(id_penerima);
        KategoriDto dto = null;     
        dto = new KategoriDto();
       
        List<CartDto> listCartDto=cartService.getListCartByIdPembeli(id);
        List<PenerimaDto> listPenerimaDto=penerimaService.getListPenerimaById(id);
        List<ProvinsiDto> listProvinsi = provinsiService.getListProvinsi();
        List<KotaDto> listKota=kotaService.getListKota();
        List<KecamatanDto> listKecamatan=kecamatanService.getListKecamatan();
        try {
            model.addAttribute("listCartDto", listCartDto);
            model.addAttribute("kategoriDto", dto);
            model.addAttribute("penerimaDto", penerimaDto);
            model.addAttribute("listPenerimaDto", listPenerimaDto);
            model.addAttribute("listProvinsi", listProvinsi);
            model.addAttribute("listKota", listKota);
            model.addAttribute("listKecamatan", listKecamatan);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "updatePenerima";
    }
    
    @RequestMapping(value = "/updatePenerima", method = RequestMethod.POST)
    public String editData1(PenerimaDto penerimaDto) throws Exception{
        penerimaService.doUpdateDataPenerima(penerimaDto);
        return "redirect:detailKeranjang.htm";
    }
}