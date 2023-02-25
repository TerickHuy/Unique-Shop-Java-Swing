/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinessLayer;

import DataTransferObject.HangHoa;
import DataTransferObject.Khachhang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author this pc
 */
public class KhachhangBL {

    public static List<Khachhang> dsKhachhang() {
        List<Khachhang> rs = null;
        try (Connection ketNoi = CSDL.Connect()) {
            rs = new ArrayList<>();
            java.sql.Statement statement = ketNoi.createStatement();
            String sql = "SELECT * FROM KHACHHANG ";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Khachhang kh = new Khachhang();
                kh.setStrMakh(resultSet.getString("MaKH"));
                kh.setStrTenkh(resultSet.getString("TenKH"));
                kh.setStrGioitinh(resultSet.getString("Gioitinh"));
                kh.setStrDiachi(resultSet.getString("Diachi"));
                kh.setStrSdt(resultSet.getString("SDT"));
                rs.add(kh);
            }
        } catch (Exception e) {
            System.out.println("Bi loi List:  " + e.getMessage());
        }
        return rs;
    }

    public static int themkhachhang(String maKH, String tenKH, String gioiTinh, String diaChi, String sdt) {
        int smt = 0;
        try (Connection ketNoi = CSDL.Connect()) {
            String sql = "insert into KHACHHANG(MaKH,TenKH,Gioitinh,Diachi,SDT) values ('" + maKH + "', '" + tenKH + "', '" + gioiTinh + "', '" + diaChi + "', '" + sdt + "')";
            Statement sta = ketNoi.createStatement();
            sta.executeUpdate(sql);

        } catch (Exception ex) {
            System.out.println("Loi Thêm: " + ex.getMessage());
        }
        return smt;
    }

    public static void capNhatKH(String maKH, String tenKH, String gioiTinh, String diaChi, String sdt) {
        try (Connection ketNoi = CSDL.Connect()) {
            String sql = "update KHACHHANG set TenKH= N'" + tenKH + "',Gioitinh='" + gioiTinh + "',DiaChi='" + diaChi + "', SDT='" + sdt + "' where MaKH='" + maKH + "'";
            PreparedStatement statement = ketNoi.prepareStatement(sql);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Bị lỗi update: " + e.getMessage());
        }
    }

    public static void xoaKH(String maKH) {
        try (Connection ketNoi = CSDL.Connect()) {
            String sql = "DELETE FROM KHACHHANG WHERE MaKH='" + maKH + "'";
            PreparedStatement statement = ketNoi.prepareStatement(sql);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("bi loi xoa: " + e.getMessage());
        }
    }

    public static List<Khachhang> timkiemKH() {
        List<Khachhang> rs = null;
        try (Connection ketNoi = CSDL.Connect()) {
            rs = new ArrayList<>();
            Statement Statement = ketNoi.createStatement();
            String sql = "SELECT * FROM KHACHHANG ";
            ResultSet resultSet = Statement.executeQuery(sql);
            while (resultSet.next()) {
                Khachhang kh = new Khachhang();
                kh.setStrMakh(resultSet.getString("MaKH"));
                kh.setStrTenkh(resultSet.getString("TenKH"));
                kh.setStrGioitinh(resultSet.getString("Gioitinh"));
                kh.setStrDiachi(resultSet.getString("DiaChi"));
                kh.setStrDiachi(resultSet.getString("SDT"));
                rs.add(kh);
            }
        } catch (Exception e) {
            System.out.println("Bi Loi tim kiem: " + e.getMessage());
        }
        return rs;
    }
}
