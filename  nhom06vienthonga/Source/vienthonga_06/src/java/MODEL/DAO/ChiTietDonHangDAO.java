/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL.DAO;

import MODEL.POJO.Chitietdonhang;
import MODEL.UTIL.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author LAPTOP
 */
public class ChiTietDonHangDAO {

    public static List<Chitietdonhang> LayChiTietDonHang() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Chitietdonhang> list = null;

        try {
            String hql = "FROM Chitietdonhang WHERE tinhTrang=:tt";
            Query query = session.createQuery(hql);
            query.setInteger("tt", 0);
            list = query.list();
        } catch (Exception ex) {
        } finally {
            session.close();
        }

        return list;
    }

    public static Chitietdonhang LayChiTietDonHangTheoMa(String mctdh) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Chitietdonhang sp = (Chitietdonhang) session.get(Chitietdonhang.class, mctdh);

        session.close();

        return sp;
    }

    public static int Them(Chitietdonhang ctdh) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        int kq = 0;
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();            
            session.save(ctdh);
            transaction.commit();
            kq = 1;
        } catch (Exception ex) {
            transaction.rollback();
        } finally {
            session.close();
        }
        return kq;
    }
}