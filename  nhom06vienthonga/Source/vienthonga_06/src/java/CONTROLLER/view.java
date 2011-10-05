/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import MODEL.DAO.*;
import MODEL.POJO.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LAPTOP
 */
@WebServlet(name = "view", urlPatterns = {"/view"})
public class view extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        try {
            String task = "";
            if (request.getParameter("task") != null) {
                task = request.getParameter("task").toString();
            }

            //<editor-fold defaultstate="collapsed" desc="show sản phẩm của hãng">
            if (task.equals("sanphamtheohang")) {
                int sp1trang = ThamSoDao.LaySoSanPhamTrenTrang();
                int tongsotrang = 0;
                int trang = 1;
                if (request.getParameter("trang") != null) {
                    trang = Integer.parseInt(request.getParameter("trang").toString());
                }
                int batdau = 0;
                if (trang > 1) {
                    batdau = sp1trang * trang - sp1trang;
                }

                String MH = request.getParameter("MH");
                List<Sanpham> list = SanPhamDAO.LaySanPhamTheoHang(MH, batdau, -1);
                tongsotrang = list.size() / sp1trang;
                if (list.size() % sp1trang > 0) {
                    tongsotrang = tongsotrang + 1;
                }
                list = SanPhamDAO.LaySanPhamTheoHang(MH, batdau, sp1trang);
                //list = list.subList(0, sp1trang);

                request.setAttribute("tongsotrang", tongsotrang);
                request.setAttribute("list", list);
                request.getRequestDispatcher("SanPhamTheoHang.jsp").forward(request, response);
                return;
            }
            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="show chi tiết sản phẩm">
            if (task.equals("chitietsanpham")) {
                String MSP = request.getParameter("MSP");

                Sanpham sp = SanPhamDAO.LaySanPhamTheoMa(MSP);

                request.setAttribute("sanpham", sp);
                request.getRequestDispatcher("ChiTietSanPham.jsp").forward(request, response);
                return;
            }
            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="show theo danh mục sản phẩm">
            if (task.equals("danhmucsanpham")) {
                String task_chitiet = request.getParameter("task_chitiet");
                //<editor-fold defaultstate="collapsed" desc="show sản phẩm điện thoại">
                if (task_chitiet.equals("dienthoai")) {
                    int sp1trang = ThamSoDao.LaySoSanPhamTrenTrang();
                    int tongsotrang = 0;
                    int trang = 1;
                    if (request.getParameter("trang") != null) {
                        trang = Integer.parseInt(request.getParameter("trang").toString());
                    }
                    int batdau = 0;
                    if (trang > 1) {
                        batdau = sp1trang * trang - sp1trang;
                    }

                    List<Sanpham> list = SanPhamDAO.LaySanPhamTheoLoai("DT", batdau, -1);
                    tongsotrang = list.size() / sp1trang;
                    if (list.size() % sp1trang > 0) {
                        tongsotrang = tongsotrang + 1;
                    }
                    list = SanPhamDAO.LaySanPhamTheoLoai("DT", batdau, sp1trang);
                    //list = list.subList(0, sp1trang);

                    request.setAttribute("tongsotrang", tongsotrang);
                    request.setAttribute("list", list);
                    request.getRequestDispatcher("DanhMucSanPham.jsp").forward(request, response);
                    return;
                }
                //</editor-fold>

                //<editor-fold defaultstate="collapsed" desc="show sản phẩm laptop">
                if (task_chitiet.equals("laptop")) {
                    int sp1trang = ThamSoDao.LaySoSanPhamTrenTrang();
                    int tongsotrang = 0;
                    int trang = 1;
                    if (request.getParameter("trang") != null) {
                        trang = Integer.parseInt(request.getParameter("trang").toString());
                    }
                    int batdau = 0;
                    if (trang > 1) {
                        batdau = sp1trang * trang - sp1trang;
                    }

                    List<Sanpham> list = SanPhamDAO.LaySanPhamTheoLoai("LT", batdau, -1);
                    tongsotrang = list.size() / sp1trang;
                    if (list.size() % sp1trang > 0) {
                        tongsotrang = tongsotrang + 1;
                    }
                    list = SanPhamDAO.LaySanPhamTheoLoai("LT", batdau, sp1trang);
                    //list = list.subList(0, sp1trang);

                    request.setAttribute("tongsotrang", tongsotrang);
                    request.setAttribute("list", list);
                    request.getRequestDispatcher("DanhMucSanPham.jsp").forward(request, response);
                    return;
                }
                //</editor-fold>
            }
            //</editor-fold>            

            //<editor-fold defaultstate="collapsed" desc="chuyển trang đăng nhập">
            if(task.equals("DangNhap")){
                request.getRequestDispatcher("DangNhap.jsp").forward(request, response);                        
            }
            //</editor-fold>
            
            //<editor-fold defaultstate="collapsed" desc="chuyển trang quản lý admin">
            if (task.equals("quanly")) {
                if (session.getAttribute("TenDangNhap") == null) {
                    request.getRequestDispatcher("DangNhap.jsp").forward(request, response);
                    return;
                }

                Nguoidung nd = new Nguoidung();
                nd.setTenDangNhap(session.getAttribute("TenDangNhap").toString());
                nd = (NguoiDungDAO.TimKiem(nd)).get(0);

                //admin
                if (nd.getLoainguoidung().getMaLoaiNguoiDung().equals("MLND1")) {
                    if (request.getParameter("task_chitiet") != null) {
                        String task_chitiet = request.getParameter("task_chitiet");

                        //<editor-fold defaultstate="collapsed" desc="người dùng">
                        if (task_chitiet.equals("nguoidung")) {
                            
                            
                            request.getRequestDispatcher("QuanLyAdmin_NguoiDung.jsp").forward(request, response);
                            return;
                        }
                        //</editor-fold>
                        
                        //<editor-fold defaultstate="collapsed" desc="công ty">
                        if (task_chitiet.equals("congty")) {
                            
                            
                            request.getRequestDispatcher("QuanLyAdmin_CongTy.jsp").forward(request, response);
                            return;
                        }
                        //</editor-fold>
                    }

                    request.getRequestDispatcher("QuanLyAdmin.jsp").forward(request, response);
                    return;
                }

                //người dùng
                if (nd.getLoainguoidung().getMaLoaiNguoiDung().equals("MLND2")) {
                    if (request.getParameter("task_chitiet") != null) {
                        String task_chitiet = request.getParameter("task_chitiet");

                        //<editor-fold defaultstate="collapsed" desc="thông tin người dùng">
                        if (task_chitiet.equals("thongtinnguoidung")) {
                            request.getRequestDispatcher("XXXXXX.jsp").forward(request, response);
                            return;
                        }
                        //</editor-fold>
                    }

                    request.getRequestDispatcher("QuanLyNguoiDung.jsp").forward(request, response);
                    return;
                }

                //nhân viên
                if (nd.getLoainguoidung().getMaLoaiNguoiDung().equals("MLND3")) {
                    if (request.getParameter("task_chitiet") != null) {
                        String task_chitiet = request.getParameter("task_chitiet");
                        
                        //<editor-fold defaultstate="collapsed" desc="sản phẩm">
                        
                        //</editor-fold>
                    }

                    request.getRequestDispatcher("QuanLyNhanVien.jsp").forward(request, response);
                    return;
                }
            }
            //</editor-fold>

            request.getRequestDispatcher("TrangChu.jsp").forward(request, response);
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}