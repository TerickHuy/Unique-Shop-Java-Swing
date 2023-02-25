/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinessLayer;

import DataTransferObject.TaiKhoan;
import Forms.frm_QLCH;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import Forms.frm_dangNhap;
import Forms.frm_QLCH;

/**
 *
 * @author petpkpro123
 */
public class TaiKhoanBL extends JFrame {

    public static List<TaiKhoan> dsTaiKhoan() {
        List<TaiKhoan> rs = null;
        try (Connection conn = CSDL.Connect()) {
            rs = new ArrayList<>();
            java.sql.Statement statement = conn.createStatement();
            String sql = "select * from Login";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                TaiKhoan tk = new TaiKhoan();
                tk.setTenTk(resultSet.getString("tendangnhap"));
                tk.setMatKhau(resultSet.getString("matkhau"));
                rs.add(tk);
            }
        } catch (Exception e) {
            System.out.println("Bi loi List:  " + e.getMessage());
        }
        return rs;
    }

}
