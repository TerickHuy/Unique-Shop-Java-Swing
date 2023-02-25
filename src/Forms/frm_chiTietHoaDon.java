/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import BussinessLayer.CSDL;
import BussinessLayer.CTHDBL;
import BussinessLayer.HangHoaBL;
import DataTransferObject.CTHD;
import DataTransferObject.HangHoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author petpkpro123
 */
public class frm_chiTietHoaDon extends javax.swing.JFrame {

    private static DefaultTableModel TableModel = new DefaultTableModel();
    DefaultTableModel model;
    String soHD;

    void initCTHD() {
        List<CTHD> listCTHD;
        listCTHD = CTHDBL.dsCTHoaDon();
        if (listCTHD.size() > 0) {
            model = (DefaultTableModel) tbl_chiTietHD.getModel();
            model.setRowCount(0);
            for (CTHD s : listCTHD) {
                model.addRow(new Object[]{s.getiSoHD(), s.getiMaHH(), s.getStrTenHH(), s.getiGiaBan(), s.getiSoLuong(), s.getiTong()});
            }
        }
    }

    public static void LoadCTHD() {
        try (Connection ketNoi = CSDL.Connect()) {
            String sql = "SELECT * FROM CHITIETHOADON";
            PreparedStatement pst = ketNoi.prepareStatement(sql);
            ResultSet res = pst.executeQuery(sql);
            String[] colsName = {"SoHD", "MaHH", "TenHH", "GiaBan", "SoLuong", "Tong"};
            TableModel.setColumnIdentifiers(colsName);
            while (res.next()) {
                String rows[] = new String[10];
                rows[0] = res.getString(1);
                rows[0] = res.getString(2);
                rows[0] = res.getString(3);
                rows[0] = res.getString(4);
                rows[0] = res.getString(5);
                rows[0] = res.getString(6);
                TableModel.addRow(rows);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void macDinhCTHD() {
        txt_soHD.setText(null);
        txt_donGia.setText(null);
        txt_maHH.setText(null);
        txt_soLuong.setText(null);
        txt_tenHH.setText(null);
        txt_thanhTien.setText(null);
    }

    public frm_chiTietHoaDon() {
        initComponents();
        initCTHD();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_chiTietHD = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txt_soHD = new javax.swing.JTextField();
        txt_maHH = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_tenHH = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_donGia = new javax.swing.JTextField();
        txt_soLuong = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_thanhTien = new javax.swing.JTextField();
        btn_luu = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        btn_quayVe = new javax.swing.JButton();
        btn_themMoi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(253, 243, 243));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(39, 34, 87));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CHI TIẾT HÓA ĐƠN");

        tbl_chiTietHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Số hóa đơn", "Mã hàng hóa ", "Tên hàng hóa", "Đơn giá", "Số lượng", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_chiTietHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_chiTietHDMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_chiTietHD);

        jLabel2.setForeground(new java.awt.Color(39, 34, 87));
        jLabel2.setText("Số hóa đơn:");

        jLabel3.setForeground(new java.awt.Color(39, 34, 87));
        jLabel3.setText("Mã hàng hóa:");

        jLabel4.setForeground(new java.awt.Color(39, 34, 87));
        jLabel4.setText("Tên hàng hóa:");

        jLabel5.setForeground(new java.awt.Color(39, 34, 87));
        jLabel5.setText("Đơn giá:");

        jLabel6.setForeground(new java.awt.Color(39, 34, 87));
        jLabel6.setText("Số lượng:");

        jLabel7.setForeground(new java.awt.Color(39, 34, 87));
        jLabel7.setText("Thành tiền:");

        txt_thanhTien.setEnabled(false);

        btn_luu.setForeground(new java.awt.Color(39, 34, 87));
        btn_luu.setText("Lưu");
        btn_luu.setPreferredSize(new java.awt.Dimension(88, 29));
        btn_luu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_luuActionPerformed(evt);
            }
        });

        btn_sua.setForeground(new java.awt.Color(39, 34, 87));
        btn_sua.setText("Sửa");
        btn_sua.setPreferredSize(new java.awt.Dimension(88, 29));
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        btn_xoa.setForeground(new java.awt.Color(39, 34, 87));
        btn_xoa.setText("Xóa");
        btn_xoa.setPreferredSize(new java.awt.Dimension(88, 29));
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        btn_quayVe.setForeground(new java.awt.Color(39, 34, 87));
        btn_quayVe.setText("Quay lại");
        btn_quayVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_quayVeActionPerformed(evt);
            }
        });

        btn_themMoi.setForeground(new java.awt.Color(39, 34, 87));
        btn_themMoi.setText("Thêm mới");
        btn_themMoi.setPreferredSize(new java.awt.Dimension(88, 29));
        btn_themMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(362, 362, 362)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 891, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_soHD, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_maHH, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(371, 371, 371)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txt_soLuong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_thanhTien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(296, 296, 296)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txt_tenHH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_donGia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(btn_themMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(133, 133, 133)
                                .addComponent(btn_luu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(126, 126, 126)
                                .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(401, 401, 401)
                        .addComponent(btn_quayVe)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txt_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(txt_thanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txt_soHD, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txt_maHH, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txt_tenHH, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txt_donGia, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_luu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_themMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addComponent(btn_quayVe)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_quayVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_quayVeActionPerformed
        frm_QLCH reciept = new frm_QLCH();
        this.dispose();
        reciept.setVisible(true);
    }//GEN-LAST:event_btn_quayVeActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (JOptionPane.showConfirmDialog(this, "Bạn muốn ngưng mua sắm?", "Thông báo?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }//GEN-LAST:event_formWindowClosing

    private void tbl_chiTietHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_chiTietHDMouseClicked
        txt_soHD.setText(String.valueOf(model.getValueAt(tbl_chiTietHD.getSelectedRow(), 0)));
        txt_maHH.setText(String.valueOf(model.getValueAt(tbl_chiTietHD.getSelectedRow(), 1)));
        txt_tenHH.setText(String.valueOf(model.getValueAt(tbl_chiTietHD.getSelectedRow(), 2)));
        txt_donGia.setText(String.valueOf(model.getValueAt(tbl_chiTietHD.getSelectedRow(), 3)));
        txt_soLuong.setText(String.valueOf(model.getValueAt(tbl_chiTietHD.getSelectedRow(), 4)));
        txt_thanhTien.setText(String.valueOf(model.getValueAt(tbl_chiTietHD.getSelectedRow(), 5)));
    }//GEN-LAST:event_tbl_chiTietHDMouseClicked

    private void btn_themMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themMoiActionPerformed
        macDinhCTHD();
    }//GEN-LAST:event_btn_themMoiActionPerformed

    private void btn_luuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_luuActionPerformed
        int maHH = Integer.parseInt(txt_maHH.getText());
        int soHD = Integer.parseInt(txt_soHD.getText());
        String tenHH = txt_tenHH.getText();
        int giaBan = Integer.parseInt(txt_donGia.getText());
        int soLuong = Integer.parseInt(txt_soLuong.getText());
        int tong = soLuong * giaBan;
        CTHDBL.themCTHoaDon(soHD, maHH, tenHH, giaBan, soLuong, tong);
        JOptionPane.showMessageDialog(rootPane, "Thêm hóa đơn thành công");
        model = (DefaultTableModel) tbl_chiTietHD.getModel();
        model.setNumRows(0);
        initCTHD();
        macDinhCTHD();
    }//GEN-LAST:event_btn_luuActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        int maHH = Integer.parseInt(txt_maHH.getText());
        int soHD = Integer.parseInt(txt_soHD.getText());
        String tenHH = txt_tenHH.getText();
        int giaBan = Integer.parseInt(txt_donGia.getText());
        int soLuong = Integer.parseInt(txt_soLuong.getText());
        int tong = soLuong * giaBan;
        CTHDBL.capNhatCTHD(soHD, maHH, tenHH, giaBan, soLuong, tong);
        JOptionPane.showMessageDialog(rootPane, "Cập nhật hóa đơn thành công");
        model = (DefaultTableModel) tbl_chiTietHD.getModel();
        model.setNumRows(0);
        initCTHD();
        macDinhCTHD();
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        if (tbl_chiTietHD.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(rootPane, "Chọn thông tin cần xóa");
        } else {
            DefaultTableModel defaultTableModel = (DefaultTableModel) tbl_chiTietHD.getModel();
            int as = JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn xóa hóa đơn?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
            if (as == JOptionPane.YES_OPTION) {
                CTHDBL.xoaCTHD(String.valueOf(soHD));
            }
            defaultTableModel.setRowCount(0);
            macDinhCTHD();
            initCTHD();
        }
    }//GEN-LAST:event_btn_xoaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frm_chiTietHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_chiTietHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_chiTietHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_chiTietHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_chiTietHoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_luu;
    private javax.swing.JButton btn_quayVe;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_themMoi;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_chiTietHD;
    private javax.swing.JTextField txt_donGia;
    private javax.swing.JTextField txt_maHH;
    private javax.swing.JTextField txt_soHD;
    private javax.swing.JTextField txt_soLuong;
    private javax.swing.JTextField txt_tenHH;
    private javax.swing.JTextField txt_thanhTien;
    // End of variables declaration//GEN-END:variables
}
