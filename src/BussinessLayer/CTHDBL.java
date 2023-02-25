/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinessLayer;

import DataTransferObject.CTHD;
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
public class CTHDBL {

    public static List<CTHD> dsCTHoaDon() {
        List<CTHD> rs = null;
        try (Connection ketNoi = CSDL.Connect()) {
            rs = new ArrayList<>();
            java.sql.Statement statement = ketNoi.createStatement();
            String sql = "SELECT * FROM CHITIETHOADON ";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                CTHD hd = new CTHD();
                hd.setiSoHD(resultSet.getInt("SoHD"));
                hd.setiMaHH(resultSet.getInt("MaHH"));
                hd.setStrTenHH(resultSet.getString("TenHH"));
                hd.setiGiaBan(resultSet.getInt("GiaBan"));
                hd.setiSoLuong(resultSet.getInt("SoLuong"));
                hd.setiTong(resultSet.getInt("Tong"));
                rs.add(hd);
            }
        } catch (Exception e) {
            System.out.println("Bi loi List:  " + e.getMessage());
        }
        return rs;
    }

    public static int themCTHoaDon(int soHD, int maHH, String tenHH, int giaBan, int soLuong, int tong) {
        int smt = 0;
        try (Connection ketNoi = CSDL.Connect()) {
            tong = giaBan * soLuong;
            String sql = "insert into CHITIETHOADON(SoHD,MaHH,TenHH,GiaBan,SoLuong,Tong) values ('" + soHD + "', '" + maHH + "', '" + tenHH + "', '" + giaBan + "', '" + soLuong + "', '" + tong + "')";
            Statement sta = ketNoi.createStatement();
            sta.executeUpdate(sql);

        } catch (Exception ex) {
            System.out.println("Loi Thêm: " + ex.getMessage());
        }
        return smt;
    }

    public static void capNhatCTHD(int soHD, int maHH, String tenHH, int giaBan, int soLuong, int tong) {
        try (Connection ketNoi = CSDL.Connect()) {
            String sql = "update CHITIETHOADON set MaHH='" + maHH + "',TenHH='" + tenHH + "', GiaBan='" + giaBan + "', SoLuong='" + soLuong + "',Tong='" + tong + "' where SoHD='" + soHD + "'";
            PreparedStatement statement = ketNoi.prepareStatement(sql);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Bị lỗi update: " + e.getMessage());
        }
    }

    public static void xoaCTHD(String soHD) {
        try (Connection ketNoi = CSDL.Connect()) {
            String sql = "DELETE FROM CHITIETHOADON WHERE SoHD='" + soHD + "'";
            PreparedStatement statement = ketNoi.prepareStatement(sql);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("bi loi xoa: " + e.getMessage());
        }
    }

    public static List<CTHD> timkiemCTHD() {
        List<CTHD> rs = null;
        try (Connection ketNoi = CSDL.Connect()) {
            rs = new ArrayList<>();
            Statement Statement = ketNoi.createStatement();
            String sql = "SELECT * FROM CHITIETHOADON ";
            ResultSet resultSet = Statement.executeQuery(sql);
            while (resultSet.next()) {
               CTHD hd = new CTHD();
                hd.setiSoHD(resultSet.getInt("SoHD"));
                hd.setiMaHH(resultSet.getInt("MaHH"));
                hd.setStrTenHH(resultSet.getString("TenHH"));
                hd.setiGiaBan(resultSet.getInt("GiaBan"));
                hd.setiSoLuong(resultSet.getInt("SoLuong"));
                hd.setiTong(resultSet.getInt("Tong"));
                rs.add(hd);
            }
        } catch (Exception e) {
            System.out.println("Bi Loi tim kiem: " + e.getMessage());
        }
        return rs;
    }

}
