package MODEL.POJO;
// Generated Oct 4, 2011 11:02:12 AM by Hibernate Tools 3.2.1.GA



/**
 * Thamso generated by hbm2java
 */
public class Thamso  implements java.io.Serializable {


     private String maThamSo;
     private Integer soSanPhamTrenTrang;
     private String duongDanHinhAnh;

    public Thamso() {
    }

	
    public Thamso(String maThamSo) {
        this.maThamSo = maThamSo;
    }
    public Thamso(String maThamSo, Integer soSanPhamTrenTrang, String duongDanHinhAnh) {
       this.maThamSo = maThamSo;
       this.soSanPhamTrenTrang = soSanPhamTrenTrang;
       this.duongDanHinhAnh = duongDanHinhAnh;
    }
   
    public String getMaThamSo() {
        return this.maThamSo;
    }
    
    public void setMaThamSo(String maThamSo) {
        this.maThamSo = maThamSo;
    }
    public Integer getSoSanPhamTrenTrang() {
        return this.soSanPhamTrenTrang;
    }
    
    public void setSoSanPhamTrenTrang(Integer soSanPhamTrenTrang) {
        this.soSanPhamTrenTrang = soSanPhamTrenTrang;
    }
    public String getDuongDanHinhAnh() {
        return this.duongDanHinhAnh;
    }
    
    public void setDuongDanHinhAnh(String duongDanHinhAnh) {
        this.duongDanHinhAnh = duongDanHinhAnh;
    }




}


