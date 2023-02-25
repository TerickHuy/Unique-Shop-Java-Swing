/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinessLayer;

import DataTransferObject.HangHoa;
import DataTransferObject.HoaDon;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author petpkpro123
 */
public class HangHoaBL {

    public static List<HangHoa> dsHangHoang() {
        List<HangHoa> rs = null;
        try (Connection ketNoi = CSDL.Connect()) {
            rs = new ArrayList<>();
            java.sql.Statement statement = ketNoi.createStatement();
            String sql = "SELECT * FROM QUANLYQUANAO ";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                HangHoa hh = new HangHoa();
                hh.setiMaHH(resultSet.getInt("MaHH"));
                hh.setStrTenHH(resultSet.getString("TenHH"));
                hh.setiGiaBan(resultSet.getInt("GiaBan"));
                hh.setStrDVT(resultSet.getString("DVT"));
                hh.setMaNCC(resultSet.getString("MaNCC"));
                rs.add(hh);
            }
        } catch (Exception e) {
            System.out.println("Bi loi List:  " + e.getMessage());
        }
        return rs;
    }
    
    public static int themHangHoa(int maHH, String tenHH, int giaBan, String dvt, String maNcc) {
        int smt = 0;
        try (Connection ketNoi = CSDL.Connect()) {
            String sql = "insert into QUANLYQUANAO(MaHH,TenHH,GiaBan,DVT,MaNCC) values ('" + maHH + "', '" + tenHH + "', '" + giaBan + "', '" + dvt + "', '" + maNcc + "')";
            Statement sta = ketNoi.createStatement();
            sta.executeUpdate(sql);

        } catch (Exception ex) {
            System.out.println("Loi Thêm: " + ex.getMessage());
        }
        return smt;
    }

    public static void capNhatHH(int maHH, String tenHH, int giaBan, String dvt, String maNcc) {
        try (Connection ketNoi = CSDL.Connect()) {
            String sql = "update QUANLYQUANAO set TenHH= N'" + tenHH + "',GiaBan='" + giaBan + "',DVT='" + dvt + "', MaNCC='" + maNcc + "' where MaHH='" + maHH + "'";
            PreparedStatement statement = ketNoi.prepareStatement(sql);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Bị lỗi update: " + e.getMessage());
        }
    }

    public static void xoaHH(String maHH) {
        try (Connection ketNoi = CSDL.Connect()) {
            String sql = "DELETE FROM QUANLYQUANAO WHERE MaHH='" + maHH + "'";
            PreparedStatement statement = ketNoi.prepareStatement(sql);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("bi loi xoa: " + e.getMessage());
        }
    }

    public static List<HangHoa> timkiemHH() {
        List<HangHoa> rs = null;
        try (Connection ketNoi = CSDL.Connect()) {
            rs = new ArrayList<>();
            Statement Statement = ketNoi.createStatement();
            String sql = "SELECT * FROM QUANLYQUANAO ";
            ResultSet resultSet = Statement.executeQuery(sql);
            while (resultSet.next()) {
                HangHoa hh = new HangHoa();
                hh.setiMaHH(resultSet.getInt("MaHH"));
                hh.setStrTenHH(resultSet.getString("TenHH"));
                hh.setiGiaBan(resultSet.getInt("GiaBan"));
                hh.setStrDVT(resultSet.getString("DVT"));
                hh.setMaNCC(resultSet.getString("MaNCC"));
                rs.add(hh);
            }
        } catch (Exception e) {
            System.out.println("Bi Loi tim kiem: " + e.getMessage());
        }
        return rs;
    }
//WHERE MaHH like '%" + maHH + "%'
}
