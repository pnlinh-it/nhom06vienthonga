package MODEL.POJO;
// Generated Oct 4, 2011 11:02:12 AM by Hibernate Tools 3.2.1.GA



/**
 * Hinhanhkhuyenmai generated by hbm2java
 */
public class Hinhanhkhuyenmai  implements java.io.Serializable {


     private String maHinhAnhKhuyenMai;
     private Khuyenmai khuyenmai;
     private String tenHinhAnh;
     private String duongDan;
     private Integer tinhTrang;

    public Hinhanhkhuyenmai() {
    }

	
    public Hinhanhkhuyenmai(String maHinhAnhKhuyenMai) {
        this.maHinhAnhKhuyenMai = maHinhAnhKhuyenMai;
    }
    public Hinhanhkhuyenmai(String maHinhAnhKhuyenMai, Khuyenmai khuyenmai, String tenHinhAnh, String duongDan, Integer tinhTrang) {
       this.maHinhAnhKhuyenMai = maHinhAnhKhuyenMai;
       this.khuyenmai = khuyenmai;
       this.tenHinhAnh = tenHinhAnh;
       this.duongDan = duongDan;
       this.tinhTrang = tinhTrang;
    }
   
    public String getMaHinhAnhKhuyenMai() {
        return this.maHinhAnhKhuyenMai;
    }
    
    public void setMaHinhAnhKhuyenMai(String maHinhAnhKhuyenMai) {
        this.maHinhAnhKhuyenMai = maHinhAnhKhuyenMai;
    }
    public Khuyenmai getKhuyenmai() {
        return this.khuyenmai;
    }
    
    public void setKhuyenmai(Khuyenmai khuyenmai) {
        this.khuyenmai = khuyenmai;
    }
    public String getTenHinhAnh() {
        return this.tenHinhAnh;
    }
    
    public void setTenHinhAnh(String tenHinhAnh) {
        this.tenHinhAnh = tenHinhAnh;
    }
    public String getDuongDan() {
        return this.duongDan;
    }
    
    public void setDuongDan(String duongDan) {
        this.duongDan = duongDan;
    }
    public Integer getTinhTrang() {
        return this.tinhTrang;
    }
    
    public void setTinhTrang(Integer tinhTrang) {
        this.tinhTrang = tinhTrang;
    }




}

