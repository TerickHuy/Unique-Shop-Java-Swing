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
public class HoaDonBL {

    
    public static List<HoaDon> dsHoaDon() {
        List<HoaDon> rs = null;
        try (Connection ketNoi = CSDL.Connect()) {
            rs = new ArrayList<>();
            java.sql.Statement statement = ketNoi.createStatement();
            String sql = "SELECT * FROM HOADON ";
            ResultSet resultSet1 = statement.executeQuery(sql);
            while (resultSet1.next()) {
                HoaDon hd = new HoaDon();
                hd.setiSoHD(resultSet1.getInt("SoHD"));
                hd.setdNgayLap(resultSet1.getDate("NgayLap"));
                hd.setStrMaNv(resultSet1.getString("MaNV"));
                hd.setStrTenNV(resultSet1.getString("TenKH"));
                hd.setiTong(resultSet1.getInt("Tong"));
                rs.add(hd);
            }
        } catch (Exception e) {
            System.out.println("Bi loi List:  " + e.getMessage());
        }
        return rs;
    }

    public static int themHoaDon(int soHD, Date ngayLap, String maNV, String tenKH, int tong) {
        int smt = 0;
        try (Connection ketNoi = CSDL.Connect()) {
            String sql = "insert into HOADON(SoHD,NgayLap,MaNV,TenKH,Tong) values ('" + soHD + "', '" + ngayLap + "', '" + maNV + "', '" + tenKH + "', '" + tong + "')";
            Statement sta = ketNoi.createStatement();
            sta.executeUpdate(sql);

        } catch (Exception ex) {
            System.out.println("Loi Thêm: " + ex.getMessage());
        }
        return smt;
    }

    public static void capNhatHD(int soHD, Date ngayLap, String maNV, String tenKH, int tong) {
        try (Connection ketNoi = CSDL.Connect()) {
            String sql = "update HOADON set NgayLap='" + ngayLap + "',MaNV='" + maNV + "', TenKH='" + tenKH + "', Tong='"+tong+"' where SoHD='" + soHD + "'";
            PreparedStatement statement = ketNoi.prepareStatement(sql);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Bị lỗi update: " + e.getMessage());
        }
    }

    public static void xoaHD(String soHD) {
        try (Connection ketNoi = CSDL.Connect()) {
            String sql = "DELETE FROM HOADON WHERE SoHD='" + soHD + "'";
            PreparedStatement statement = ketNoi.prepareStatement(sql);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("bi loi xoa: " + e.getMessage());
        }
    }

    public static List<HoaDon> timkiemHD() {
        List<HoaDon> rs = null;
        try (Connection ketNoi = CSDL.Connect()) {
            rs = new ArrayList<>();
            Statement Statement = ketNoi.createStatement();
            String sql = "SELECT * FROM HOADON ";
            ResultSet resultSet = Statement.executeQuery(sql);
            while (resultSet.next()) {
                HoaDon hd = new HoaDon();
                hd.setiSoHD(resultSet.getInt("SoHD"));
                hd.setdNgayLap(resultSet.getDate("NgayLap"));
                hd.setStrMaNv(resultSet.getString("MaNV"));
                hd.setStrTenNV(resultSet.getString("TenKH"));
                hd.setiTong(resultSet.getInt("Tong"));
                rs.add(hd);
            }
        } catch (Exception e) {
            System.out.println("Bi Loi tim kiem: " + e.getMessage());
        }
        return rs;
    }
    
    
//WHERE MaHH like '%" + maHH + "%'
}
