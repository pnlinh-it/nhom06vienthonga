package MODEL.POJO;
// Generated Oct 13, 2011 8:14:39 AM by Hibernate Tools 3.2.1.GA



/**
 * Giohang generated by hbm2java
 */
public class Giohang  implements java.io.Serializable {


     private String maGioHang;
     private Sanpham sanpham;
     private Nguoidung nguoidung;
     private Integer soLuong;
     private Float donGia;
     private Float thanhTien;
     private Integer tinhTrang;

    public Giohang() {
    }

	
    public Giohang(String maGioHang) {
        this.maGioHang = maGioHang;
    }
    public Giohang(String maGioHang, Sanpham sanpham, Nguoidung nguoidung, Integer soLuong, Float donGia, Float thanhTien, Integer tinhTrang) {
       this.maGioHang = maGioHang;
       this.sanpham = sanpham;
       this.nguoidung = nguoidung;
       this.soLuong = soLuong;
       this.donGia = donGia;
       this.thanhTien = thanhTien;
       this.tinhTrang = tinhTrang;
    }
   
    public String getMaGioHang() {
        return this.maGioHang;
    }
    
    public void setMaGioHang(String maGioHang) {
        this.maGioHang = maGioHang;
    }
    public Sanpham getSanpham() {
        return this.sanpham;
    }
    
    public void setSanpham(Sanpham sanpham) {
        this.sanpham = sanpham;
    }
    public Nguoidung getNguoidung() {
        return this.nguoidung;
    }
    
    public void setNguoidung(Nguoidung nguoidung) {
        this.nguoidung = nguoidung;
    }
    public Integer getSoLuong() {
        return this.soLuong;
    }
    
    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }
    public Float getDonGia() {
        return this.donGia;
    }
    
    public void setDonGia(Float donGia) {
        this.donGia = donGia;
    }
    public Float getThanhTien() {
        return this.thanhTien;
    }
    
    public void setThanhTien(Float thanhTien) {
        this.thanhTien = thanhTien;
    }
    public Integer getTinhTrang() {
        return this.tinhTrang;
    }
    
    public void setTinhTrang(Integer tinhTrang) {
        this.tinhTrang = tinhTrang;
    }




}


