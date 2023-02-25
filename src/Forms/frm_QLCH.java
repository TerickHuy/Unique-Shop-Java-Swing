/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import BussinessLayer.CSDL;
import BussinessLayer.HangHoaBL;
import BussinessLayer.HoaDonBL;
import BussinessLayer.KhachhangBL;

import DataTransferObject.HangHoa;
import DataTransferObject.HoaDon;
import DataTransferObject.Khachhang;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author petpkpro123
 */
public class frm_QLCH extends javax.swing.JFrame {

    /**
     * Creates new form frm_storeManager
     */
    private static DefaultTableModel TableModel = new DefaultTableModel();
    DefaultTableModel model, model2, model3;
    String maHH, soHD, maKH;

    public frm_QLCH() {
        initComponents();
        
        initHangHoa();
        
        initHoaDon();
        
        initkhachhang();
    }

    void initHangHoa() {
        List<HangHoa> listHH;
        listHH = HangHoaBL.dsHangHoang();
        if (listHH.size() > 0) {
            model = (DefaultTableModel) tbl_thongTin.getModel();
            model.setRowCount(0);
            for (HangHoa s : listHH) {
                model.addRow(new Object[]{s.getiMaHH(), s.getStrTenHH(), s.getiGiaBan(), s.getStrDVT(), s.getMaNCC()});
            }
        }
    }

    void initHoaDon() {
        List<HoaDon> listHD;
        listHD = HoaDonBL.dsHoaDon();
        if (listHD.size() > 0) {
            model2 = (DefaultTableModel) tbl_thongTinHD.getModel();
            model2.setRowCount(0);
            for (HoaDon hd : listHD) {
                model2.addRow(new Object[]{hd.getiSoHD(), hd.getdNgayLap(), hd.getStrMaNv(), hd.getStrTenNV(), hd.getiTong()});
            }
        }
    }
    
        void initkhachhang() {
        List<Khachhang> listKH;
        listKH = KhachhangBL.dsKhachhang();
        if (listKH.size() > 0) {
            model3 = (DefaultTableModel) tbl_thongTinKH.getModel();
            for (Khachhang s : listKH) {
                model3.addRow(new Object[]{s.getStrMakh(), s.getStrTenkh(), s.getStrGioitinh(), s.getStrDiachi(), s.getStrSdt()});
            }
        }
    }

    public static void LoadHH() {
        try (Connection ketNoi = CSDL.Connect()) {
            String sql = "SELECT * FROM QUANLYQUANAO";
            PreparedStatement pst = ketNoi.prepareStatement(sql);
            ResultSet res = pst.executeQuery(sql);
            String[] colsName = {"MaHH", "TenHH", "GiaBan", "DVT", "MaNCC"};
            TableModel.setColumnIdentifiers(colsName);
            while (res.next()) {
                String rows[] = new String[10];
                rows[0] = res.getString(1);
                rows[0] = res.getString(2);
                rows[0] = res.getString(3);
                rows[0] = res.getString(4);
                rows[0] = res.getString(5);
                TableModel.addRow(rows);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
        public static void LoadKH() {
        try (Connection ketNoi = CSDL.Connect()) {
            String sql = "SELECT * FROM KHACHHANG";
            PreparedStatement pst = ketNoi.prepareStatement(sql);
            ResultSet res = pst.executeQuery(sql);
            String[] colsName = {"MaKH", "TenKH", "Gioitinh", "Diachi", "SDT"};
            TableModel.setColumnIdentifiers(colsName);
            while (res.next()) {
                String rows[] = new String[10];
                rows[0] = res.getString(1);
                rows[0] = res.getString(2);
                rows[0] = res.getString(3);
                rows[0] = res.getString(4);
                rows[0] = res.getString(5);
                TableModel.addRow(rows);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void LoadHD() {
        try (Connection ketNoi = CSDL.Connect()) {
            String sql = "SELECT * FROM HOADON";
            PreparedStatement pst = ketNoi.prepareStatement(sql);
            ResultSet res = pst.executeQuery(sql);
            String[] colsName = {"SoHD", "NgayLap", "MaNV", "TenKH", "Tong"};
            TableModel.setColumnIdentifiers(colsName);
            while (res.next()) {
                String rows[] = new String[10];
                rows[0] = res.getString(1);
                rows[0] = res.getString(2);
                rows[0] = res.getString(3);
                rows[0] = res.getString(4);
                rows[0] = res.getString(5);
                TableModel.addRow(rows);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void macDinhHH() {
        txt_giaBan.setText(null);
        txt_maHangHoa.setText(null);
        txt_maNCC.setText(null);
        txt_tenHangHoa.setText(null);
        cbo_DVT.setSelectedIndex(0);
    }

    public void macDinhHD() {
        txt_soHD.setText(null);
        txt_ngayLap.setText(null);
        txt_maNV.setText(null);
        txt_tenKH.setText(null);
        txt_tong.setText(null);
    }
    
        public void macDinhKH() {
        txt_maKH.setText(null);
        txt_TenKH.setText(null);
        cbo_gioiTinhKH.setSelectedIndex(0);
        txt_diaChiKH.setText(null);
        txt_sdtKH.setText(null);
    }

    public void SearchHH(String str) {
        model = (DefaultTableModel) tbl_thongTin.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        tbl_thongTin.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str));
    }

    public void SearchHD(String str) {
        model2 = (DefaultTableModel) tbl_thongTinHD.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model2);
        tbl_thongTinHD.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str));
    }
    
        public void SearchKH(String str) {
        model3 = (DefaultTableModel) tbl_thongTinKH.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model3);
        tbl_thongTinKH.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str));
    }

    public void logOut() {
        if (JOptionPane.showConfirmDialog(this, "Bạn muốn đăng xuất?", "Thông báo?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            frm_dangNhap login = new frm_dangNhap();
            this.dispose();
            login.setVisible(true);
            JOptionPane.showMessageDialog(rootPane, "Hẹn gặp lại");
        }
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tpn_fromSwitch = new javax.swing.JTabbedPane();
        pnl_info = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_thongTinKH = new javax.swing.JTable();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        txt_timKH = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        btn_timKH = new javax.swing.JButton();
        txt_maKH = new javax.swing.JTextField();
        txt_TenKH = new javax.swing.JTextField();
        txt_diaChiKH = new javax.swing.JTextField();
        cbo_gioiTinhKH = new javax.swing.JComboBox<>();
        txt_sdtKH = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        btn_themMoiKH = new javax.swing.JButton();
        btn_luuKH = new javax.swing.JButton();
        btn_xoaKH = new javax.swing.JButton();
        btn_suaKH = new javax.swing.JButton();
        btn_dangXuatKH = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        pnl_shoping = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_thongTin = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txt_maHangHoa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_tenHangHoa = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_giaBan = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbo_DVT = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txt_maNCC = new javax.swing.JTextField();
        btn_update = new javax.swing.JButton();
        btn_insert = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_search = new javax.swing.JButton();
        txt_search = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btn_logOut = new javax.swing.JButton();
        btn_new = new javax.swing.JButton();
        jLabel45 = new javax.swing.JLabel();
        pnl_hoaDon = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbl_thongTinHD = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txt_timKiemHD = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        txt_tong = new javax.swing.JTextField();
        txt_maNV = new javax.swing.JTextField();
        txt_tenKH = new javax.swing.JTextField();
        txt_ngayLap = new javax.swing.JTextField();
        txt_soHD = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        btn_themMoiHD = new javax.swing.JButton();
        btn_luuHD = new javax.swing.JButton();
        btn_suaHD = new javax.swing.JButton();
        btn_xoaHD = new javax.swing.JButton();
        btn_cthd = new javax.swing.JButton();
        btn_dangXuat = new javax.swing.JButton();
        btn_timKiemHD = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 243, 243));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo (2).png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(39, 34, 87));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("UNIQUE'S STORE");

        tpn_fromSwitch.setForeground(new java.awt.Color(39, 34, 87));
        tpn_fromSwitch.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        tpn_fromSwitch.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tpn_fromSwitch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tpn_fromSwitchMouseClicked(evt);
            }
        });

        pnl_info.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel4.setBackground(new java.awt.Color(255, 243, 243));
        jPanel4.setPreferredSize(new java.awt.Dimension(913, 606));

        jLabel34.setForeground(new java.awt.Color(39, 34, 87));
        jLabel34.setText("Tên khách hàng");

        tbl_thongTinKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khách hàng", "Tên khách hàng", "Giới tính", "Địa chỉ", "Số điện thoại"
            }
        ));
        tbl_thongTinKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_thongTinKHMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbl_thongTinKH);

        jLabel39.setForeground(new java.awt.Color(39, 34, 87));
        jLabel39.setText("Giới tính:");

        jLabel40.setForeground(new java.awt.Color(39, 34, 87));
        jLabel40.setText("Tìm kiếm khách hàng:");

        jLabel41.setForeground(new java.awt.Color(39, 34, 87));
        jLabel41.setText("Địa chỉ:");

        jLabel42.setForeground(new java.awt.Color(39, 34, 87));
        jLabel42.setText("Số điện thoại:");

        btn_timKH.setForeground(new java.awt.Color(39, 34, 87));
        btn_timKH.setText("Tìm kiếm");
        btn_timKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timKHActionPerformed(evt);
            }
        });

        cbo_gioiTinhKH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn giới tính", "Nam", "Nữ", "Khác" }));

        jLabel43.setForeground(new java.awt.Color(39, 34, 87));
        jLabel43.setText("Mã khách hàng:");

        btn_themMoiKH.setForeground(new java.awt.Color(39, 34, 87));
        btn_themMoiKH.setText("Thêm mới");
        btn_themMoiKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themMoiKHActionPerformed(evt);
            }
        });

        btn_luuKH.setForeground(new java.awt.Color(39, 34, 87));
        btn_luuKH.setText("Lưu");
        btn_luuKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_luuKHActionPerformed(evt);
            }
        });

        btn_xoaKH.setForeground(new java.awt.Color(39, 34, 87));
        btn_xoaKH.setText("Xóa");
        btn_xoaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaKHActionPerformed(evt);
            }
        });

        btn_suaKH.setForeground(new java.awt.Color(39, 34, 87));
        btn_suaKH.setText("Sửa");
        btn_suaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaKHActionPerformed(evt);
            }
        });

        btn_dangXuatKH.setForeground(new java.awt.Color(39, 34, 87));
        btn_dangXuatKH.setText("Đăng xuất");
        btn_dangXuatKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dangXuatKHActionPerformed(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Lucida Grande", 2, 24)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(39, 34, 87));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("THÔNG TIN KHÁCH HÀNG");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel44)
                .addGap(304, 304, 304))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 863, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(51, 51, 51)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(btn_themMoiKH)
                                    .addGap(130, 130, 130)
                                    .addComponent(btn_luuKH, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_suaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(136, 136, 136)
                                    .addComponent(btn_xoaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel34)
                                    .addGap(18, 18, 18)
                                    .addComponent(txt_TenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(173, 173, 173)
                                    .addComponent(txt_diaChiKH, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                            .addComponent(jLabel39)
                                            .addGap(58, 58, 58)
                                            .addComponent(cbo_gioiTinhKH, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                            .addComponent(jLabel43)
                                            .addGap(18, 18, 18)
                                            .addComponent(txt_maKH, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addGap(81, 81, 81)
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel41)
                                                .addComponent(jLabel42)))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addGap(173, 173, 173)
                                            .addComponent(txt_sdtKH, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGap(161, 161, 161)
                                    .addComponent(jLabel40)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txt_timKH, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btn_timKH)))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(412, 412, 412)
                        .addComponent(btn_dangXuatKH, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel44)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_timKH, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_timKH, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(txt_TenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_diaChiKH, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(txt_maKH, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42)
                    .addComponent(txt_sdtKH, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbo_gioiTinhKH, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_themMoiKH, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_luuKH, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_suaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_xoaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(btn_dangXuatKH, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout pnl_infoLayout = new javax.swing.GroupLayout(pnl_info);
        pnl_info.setLayout(pnl_infoLayout);
        pnl_infoLayout.setHorizontalGroup(
            pnl_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 919, Short.MAX_VALUE)
        );
        pnl_infoLayout.setVerticalGroup(
            pnl_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
        );

        tpn_fromSwitch.addTab("Khách hàng", pnl_info);

        pnl_shoping.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_shopingMouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 243, 243));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tbl_thongTin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hàng", "Tên", "Giá", "Đơn vị tính", "Mã nhà cung cấp"
            }
        ));
        tbl_thongTin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_thongTinMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_thongTin);

        jLabel4.setForeground(new java.awt.Color(39, 34, 87));
        jLabel4.setText("Mã hàng hóa:");

        jLabel5.setForeground(new java.awt.Color(39, 34, 87));
        jLabel5.setText("Tên hàng hóa:");

        txt_tenHangHoa.setMinimumSize(new java.awt.Dimension(10, 30));
        txt_tenHangHoa.setPreferredSize(new java.awt.Dimension(10, 30));

        jLabel6.setForeground(new java.awt.Color(39, 34, 87));
        jLabel6.setText("Giá bán:");

        txt_giaBan.setPreferredSize(new java.awt.Dimension(10, 30));

        jLabel7.setForeground(new java.awt.Color(39, 34, 87));
        jLabel7.setText("Đơn Vị Tính:");

        cbo_DVT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn đơn vị tính", "VND", "USD", "EUR" }));
        cbo_DVT.setPreferredSize(new java.awt.Dimension(96, 30));

        jLabel8.setForeground(new java.awt.Color(39, 34, 87));
        jLabel8.setText("Mã nhà cung cấp:");

        txt_maNCC.setPreferredSize(new java.awt.Dimension(10, 30));

        btn_update.setForeground(new java.awt.Color(39, 34, 87));
        btn_update.setText("Sửa");
        btn_update.setPreferredSize(new java.awt.Dimension(90, 30));
        btn_update.setSize(new java.awt.Dimension(90, 30));
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_insert.setForeground(new java.awt.Color(39, 34, 87));
        btn_insert.setText("Lưu");
        btn_insert.setPreferredSize(new java.awt.Dimension(90, 30));
        btn_insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insertActionPerformed(evt);
            }
        });

        btn_delete.setForeground(new java.awt.Color(39, 34, 87));
        btn_delete.setText("Xóa");
        btn_delete.setPreferredSize(new java.awt.Dimension(90, 30));
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_search.setForeground(new java.awt.Color(39, 34, 87));
        btn_search.setText("Search");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(39, 34, 87));
        jLabel9.setText("Tìm hàng hóa:");

        btn_logOut.setForeground(new java.awt.Color(39, 34, 87));
        btn_logOut.setText("Đăng xuất");
        btn_logOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logOutActionPerformed(evt);
            }
        });

        btn_new.setForeground(new java.awt.Color(39, 34, 87));
        btn_new.setText("Thêm mới");
        btn_new.setPreferredSize(new java.awt.Dimension(90, 30));
        btn_new.setSize(new java.awt.Dimension(90, 30));
        btn_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newActionPerformed(evt);
            }
        });

        jLabel45.setFont(new java.awt.Font("Lucida Grande", 2, 24)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(39, 34, 87));
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("CHI TIẾT HÀNG HÓA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74)
                                .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btn_new, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_insert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_giaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_tenHangHoa, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_maHangHoa, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_maNCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbo_DVT, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(9, 9, 9)))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_search)
                        .addGap(74, 74, 74)))
                .addGap(923, 923, 923))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(299, 299, 299)
                        .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(btn_logOut)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel45)
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_maHangHoa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_tenHangHoa, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_giaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cbo_DVT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txt_maNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_new, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_insert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_search))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addComponent(btn_logOut)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnl_shopingLayout = new javax.swing.GroupLayout(pnl_shoping);
        pnl_shoping.setLayout(pnl_shopingLayout);
        pnl_shopingLayout.setHorizontalGroup(
            pnl_shopingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 925, Short.MAX_VALUE)
        );
        pnl_shopingLayout.setVerticalGroup(
            pnl_shopingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tpn_fromSwitch.addTab("Hàng Hóa", pnl_shoping);

        jPanel3.setBackground(new java.awt.Color(255, 243, 243));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 2, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(39, 34, 87));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("HÓA ĐƠN QUẦN ÁO");

        tbl_thongTinHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Số hóa đơn", "Ngày lập", "Mã nhân viên", "Tên khách hàng", "Tổng"
            }
        ));
        tbl_thongTinHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_thongTinHDMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tbl_thongTinHD);

        jLabel10.setForeground(new java.awt.Color(39, 34, 87));
        jLabel10.setText("Tìm kiếm hóa đơn:");

        jLabel33.setForeground(new java.awt.Color(39, 34, 87));
        jLabel33.setText("Ngày lập:");

        jLabel35.setForeground(new java.awt.Color(39, 34, 87));
        jLabel35.setText("Mã nhân viên:");

        jLabel36.setForeground(new java.awt.Color(39, 34, 87));
        jLabel36.setText("Tên khách hàng:");

        jLabel37.setForeground(new java.awt.Color(39, 34, 87));
        jLabel37.setText("Tổng:");

        jLabel38.setForeground(new java.awt.Color(39, 34, 87));
        jLabel38.setText("Số hóa đơn:");

        btn_themMoiHD.setForeground(new java.awt.Color(39, 34, 87));
        btn_themMoiHD.setText("Thêm mới");
        btn_themMoiHD.setPreferredSize(new java.awt.Dimension(88, 29));
        btn_themMoiHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themMoiHDActionPerformed(evt);
            }
        });

        btn_luuHD.setForeground(new java.awt.Color(39, 34, 87));
        btn_luuHD.setText("Lưu");
        btn_luuHD.setPreferredSize(new java.awt.Dimension(88, 29));
        btn_luuHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_luuHDActionPerformed(evt);
            }
        });

        btn_suaHD.setForeground(new java.awt.Color(39, 34, 87));
        btn_suaHD.setText("Sửa");
        btn_suaHD.setPreferredSize(new java.awt.Dimension(88, 29));
        btn_suaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaHDActionPerformed(evt);
            }
        });

        btn_xoaHD.setForeground(new java.awt.Color(39, 34, 87));
        btn_xoaHD.setText("Xóa");
        btn_xoaHD.setPreferredSize(new java.awt.Dimension(88, 29));
        btn_xoaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaHDActionPerformed(evt);
            }
        });

        btn_cthd.setForeground(new java.awt.Color(39, 34, 87));
        btn_cthd.setText("Chi tiết hóa đơn");
        btn_cthd.setPreferredSize(null);
        btn_cthd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cthdActionPerformed(evt);
            }
        });

        btn_dangXuat.setForeground(new java.awt.Color(39, 34, 87));
        btn_dangXuat.setText("Đăng xuất");
        btn_dangXuat.setPreferredSize(null);
        btn_dangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dangXuatActionPerformed(evt);
            }
        });

        btn_timKiemHD.setForeground(new java.awt.Color(39, 34, 87));
        btn_timKiemHD.setText("Tìm Kiếm");
        btn_timKiemHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timKiemHDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addGap(18, 18, 18)
                        .addComponent(txt_tenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel37)
                            .addComponent(jLabel35)
                            .addComponent(jLabel33)
                            .addComponent(jLabel38))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_ngayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_maNV, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_tong, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_soHD, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btn_suaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_xoaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btn_themMoiHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(btn_luuHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(btn_dangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(btn_cthd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(168, 168, 168))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(txt_timKiemHD, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_timKiemHD)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(310, 310, 310)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel3)
                .addGap(51, 51, 51)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_soHD, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(txt_ngayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(txt_maNV, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36)
                            .addComponent(txt_tenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel37)
                            .addComponent(txt_tong, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_themMoiHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_luuHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_suaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_xoaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addComponent(btn_dangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_timKiemHD, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(btn_timKiemHD))
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_cthd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnl_hoaDonLayout = new javax.swing.GroupLayout(pnl_hoaDon);
        pnl_hoaDon.setLayout(pnl_hoaDonLayout);
        pnl_hoaDonLayout.setHorizontalGroup(
            pnl_hoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_hoaDonLayout.setVerticalGroup(
            pnl_hoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tpn_fromSwitch.addTab("Hóa đơn", pnl_hoaDon);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addGap(380, 380, 380))
            .addComponent(tpn_fromSwitch)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tpn_fromSwitch))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tpn_fromSwitchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tpn_fromSwitchMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tpn_fromSwitchMouseClicked

    private void pnl_shopingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_shopingMouseClicked

    }//GEN-LAST:event_pnl_shopingMouseClicked

    private void btn_logOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logOutActionPerformed
        logOut();
    }//GEN-LAST:event_btn_logOutActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(this, "Bạn muốn ngưng mua sắm?", "Thông báo?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }//GEN-LAST:event_formWindowClosing

    private void tbl_thongTinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_thongTinMouseClicked
        txt_maHangHoa.setText(String.valueOf(model.getValueAt(tbl_thongTin.getSelectedRow(), 0)));
        txt_tenHangHoa.setText(String.valueOf(model.getValueAt(tbl_thongTin.getSelectedRow(), 1)));
        txt_giaBan.setText(String.valueOf(model.getValueAt(tbl_thongTin.getSelectedRow(), 2)));
        cbo_DVT.setSelectedItem(String.valueOf(model.getValueAt(tbl_thongTin.getSelectedRow(), 3)));
        txt_maNCC.setText(String.valueOf(model.getValueAt(tbl_thongTin.getSelectedRow(), 4)));
    }//GEN-LAST:event_tbl_thongTinMouseClicked

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        int maHH = Integer.parseInt(txt_maHangHoa.getText());
        String tenHH = txt_tenHangHoa.getText();
        int giaBan = Integer.parseInt(txt_giaBan.getText());
        String dvt = cbo_DVT.getSelectedItem().toString();
        String maNCC = txt_maNCC.getText();
        HangHoaBL.capNhatHH(maHH, tenHH, giaBan, dvt, maNCC);
        JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công");
        model = (DefaultTableModel) tbl_thongTin.getModel();
        model.setNumRows(0);
        initHangHoa();
        LoadHH();
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insertActionPerformed
        int maHH = Integer.parseInt(txt_maHangHoa.getText());
        String tenHH = txt_tenHangHoa.getText();
        int giaBan = Integer.parseInt(txt_giaBan.getText());
        String dvt = cbo_DVT.getSelectedItem().toString();
        String maNCC = txt_maNCC.getText();
        HangHoaBL.themHangHoa(maHH, tenHH, giaBan, dvt, maNCC);
        JOptionPane.showMessageDialog(rootPane, "Thêm hàng hóa thành công");
        model = (DefaultTableModel) tbl_thongTin.getModel();
        model.setNumRows(0);
        initHangHoa();
//        LoadHH();
    }//GEN-LAST:event_btn_insertActionPerformed

    private void btn_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newActionPerformed
        // TODO add your handling code here:
        macDinhHH();
    }//GEN-LAST:event_btn_newActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        if (tbl_thongTin.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(rootPane, "Chọn thông tin cần xóa");
        } else {
            DefaultTableModel defaultTableModel = (DefaultTableModel) tbl_thongTin.getModel();
            int as = JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn xóa hàng hóa?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
            if (as == JOptionPane.YES_OPTION) {
                HangHoaBL.xoaHH(String.valueOf(maHH));
            }
            defaultTableModel.setRowCount(0);
            macDinhHH();
            initHangHoa();
        }

    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        List<HangHoa> listHH;
        maHH = txt_search.getText();
        listHH = HangHoaBL.timkiemHH();
        if (listHH.size() <= 0) {
            JOptionPane.showMessageDialog(rootPane, "Không tìm thấy hàng hóa cần tìm");
        } else {
            SearchHH(maHH);
        }
    }//GEN-LAST:event_btn_searchActionPerformed

    private void btn_themMoiHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themMoiHDActionPerformed
        // TODO add your handling code here:
        macDinhHD();
    }//GEN-LAST:event_btn_themMoiHDActionPerformed

    private void tbl_thongTinHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_thongTinHDMouseClicked
        txt_soHD.setText(String.valueOf(model2.getValueAt(tbl_thongTinHD.getSelectedRow(), 0)));
        txt_ngayLap.setText(String.valueOf(model2.getValueAt(tbl_thongTinHD.getSelectedRow(), 1)));
        txt_maNV.setText(String.valueOf(model2.getValueAt(tbl_thongTinHD.getSelectedRow(), 2)));
        txt_tenKH.setText(String.valueOf(model2.getValueAt(tbl_thongTinHD.getSelectedRow(), 3)));
        txt_tong.setText(String.valueOf(model2.getValueAt(tbl_thongTinHD.getSelectedRow(), 4)));
    }//GEN-LAST:event_tbl_thongTinHDMouseClicked

    private void btn_luuHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_luuHDActionPerformed
        int soHD = Integer.parseInt(txt_soHD.getText());
        Date ngapLap = Date.valueOf(txt_ngayLap.getText());
        String maNV = txt_maNV.getText();
        String tenKH = txt_tenKH.getText();
        int tong = Integer.parseInt(txt_tong.getText());
        HoaDonBL.themHoaDon(soHD, ngapLap, maNV, tenKH, tong);
        JOptionPane.showMessageDialog(rootPane, "Thêm hàng hóa thành công");
        model2 = (DefaultTableModel) tbl_thongTinHD.getModel();
        model2.setNumRows(0);
        initHoaDon();
    }//GEN-LAST:event_btn_luuHDActionPerformed

    private void btn_suaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaHDActionPerformed
        int soHD = Integer.parseInt(txt_soHD.getText());
        Date ngapLap = Date.valueOf(txt_ngayLap.getText());
        String maNV = txt_maNV.getText();
        String tenKH = txt_tenKH.getText();
        int tong = Integer.parseInt(txt_tong.getText());
        HoaDonBL.capNhatHD(soHD, ngapLap, maNV, tenKH, tong);
        JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công");
        model2 = (DefaultTableModel) tbl_thongTinHD.getModel();
        model2.setNumRows(0);
        initHoaDon();
        LoadHD();
    }//GEN-LAST:event_btn_suaHDActionPerformed

    private void btn_xoaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaHDActionPerformed
        if (tbl_thongTinHD.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(rootPane, "Chọn thông tin cần xóa");
        } else {
            DefaultTableModel defaultTableModel = (DefaultTableModel) tbl_thongTinHD.getModel();
            int as = JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn xóa hàng hóa?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
            if (as == JOptionPane.YES_OPTION) {
                HoaDonBL.xoaHD(String.valueOf(soHD));
            }
            defaultTableModel.setRowCount(0);
            macDinhHD();
            initHoaDon();
        }
    }//GEN-LAST:event_btn_xoaHDActionPerformed

    private void btn_dangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dangXuatActionPerformed
        logOut();
    }//GEN-LAST:event_btn_dangXuatActionPerformed

    private void btn_timKiemHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timKiemHDActionPerformed
        List<HoaDon> listHD;
        soHD = txt_timKiemHD.getText();
        listHD = HoaDonBL.timkiemHD();
        if (listHD.size() <= 0) {
            JOptionPane.showMessageDialog(rootPane, "Không tìm thấy hàng hóa cần tìm");
        } else {
            SearchHD(soHD);     
        }
    }//GEN-LAST:event_btn_timKiemHDActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void tbl_thongTinKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_thongTinKHMouseClicked
        // TODO add your handling code here:
        txt_maKH.setText(String.valueOf(model3.getValueAt(tbl_thongTinKH.getSelectedRow(), 0)));
        txt_TenKH.setText(String.valueOf(model3.getValueAt(tbl_thongTinKH.getSelectedRow(), 1)));
        cbo_gioiTinhKH.setSelectedItem(String.valueOf(model3.getValueAt(tbl_thongTinKH.getSelectedRow(), 2)));
        txt_diaChiKH.setText(String.valueOf(model3.getValueAt(tbl_thongTinKH.getSelectedRow(), 3)));
        txt_sdtKH.setText(String.valueOf(model3.getValueAt(tbl_thongTinKH.getSelectedRow(), 4)));
    }//GEN-LAST:event_tbl_thongTinKHMouseClicked

    private void btn_timKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timKHActionPerformed
        // TODO add your handling code here:
        List<Khachhang> listKH;
        maKH = txt_timKH.getText();
        listKH = KhachhangBL.timkiemKH();
        if (listKH.size() <= 0) {
            JOptionPane.showMessageDialog(rootPane, "Không tìm thấy khách hàng cần tìm");
        } else {
            SearchKH(String.valueOf(maKH));
        }
    }//GEN-LAST:event_btn_timKHActionPerformed

    private void btn_themMoiKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themMoiKHActionPerformed
        // TODO add your handling code here:
        macDinhKH();
    }//GEN-LAST:event_btn_themMoiKHActionPerformed

    private void btn_luuKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_luuKHActionPerformed
        // TODO add your handling code here:
        String maKH = txt_maKH.getText();
        String tenKH = txt_TenKH.getText();
        String gioiTinh = cbo_gioiTinhKH.getSelectedItem().toString();
        String Diachi = txt_diaChiKH.getText();
        String sdt = txt_sdtKH.getText();
        KhachhangBL.themkhachhang(maKH, tenKH, gioiTinh, Diachi, sdt);
        JOptionPane.showMessageDialog(rootPane, "Thêm khách hàng thành công");
        model3 = (DefaultTableModel) tbl_thongTinKH.getModel();
        model3.setNumRows(0);
        initkhachhang();
        macDinhKH();
    }//GEN-LAST:event_btn_luuKHActionPerformed

    private void btn_xoaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaKHActionPerformed
        // TODO add your handling code here:
        if (tbl_thongTinKH.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(rootPane, "Chọn thông tin cần xóa");
        } else {
            DefaultTableModel defaultTableModel = (DefaultTableModel) tbl_thongTinKH.getModel();
            int as = JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn xóa khách hàng?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
            if (as == JOptionPane.YES_OPTION) {
                KhachhangBL.xoaKH(String.valueOf(maKH));
            }
            defaultTableModel.setRowCount(0);
            macDinhKH();
            initkhachhang();
        }
    }//GEN-LAST:event_btn_xoaKHActionPerformed

    private void btn_suaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaKHActionPerformed
        // TODO add your handling code here:
        String maKH = txt_maKH.getText();
        String tenKH = txt_tenKH.getText();
        String gioiTinh = cbo_gioiTinhKH.getSelectedItem().toString();
        String Diachi = txt_diaChiKH.getText();
        String sdt = txt_sdtKH.getText();
        KhachhangBL.capNhatKH(maKH, tenKH, gioiTinh, Diachi, sdt);
        JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công");
        model3 = (DefaultTableModel) tbl_thongTinKH.getModel();
        model3.setNumRows(0);
        initkhachhang();
        LoadKH();
        macDinhKH();
    }//GEN-LAST:event_btn_suaKHActionPerformed

    private void btn_dangXuatKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dangXuatKHActionPerformed
        logOut();
    }//GEN-LAST:event_btn_dangXuatKHActionPerformed

    private void btn_cthdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cthdActionPerformed
        frm_chiTietHoaDon cthd = new frm_chiTietHoaDon();
        this.dispose();
        cthd.setVisible(true);
    }//GEN-LAST:event_btn_cthdActionPerformed

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
            java.util.logging.Logger.getLogger(frm_QLCH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_QLCH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_QLCH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_QLCH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_QLCH().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cthd;
    private javax.swing.JButton btn_dangXuat;
    private javax.swing.JButton btn_dangXuatKH;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_insert;
    private javax.swing.JButton btn_logOut;
    private javax.swing.JButton btn_luuHD;
    private javax.swing.JButton btn_luuKH;
    private javax.swing.JButton btn_new;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_suaHD;
    private javax.swing.JButton btn_suaKH;
    private javax.swing.JButton btn_themMoiHD;
    private javax.swing.JButton btn_themMoiKH;
    private javax.swing.JButton btn_timKH;
    private javax.swing.JButton btn_timKiemHD;
    private javax.swing.JButton btn_update;
    private javax.swing.JButton btn_xoaHD;
    private javax.swing.JButton btn_xoaKH;
    private javax.swing.JComboBox<String> cbo_DVT;
    private javax.swing.JComboBox<String> cbo_gioiTinhKH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JPanel pnl_hoaDon;
    private javax.swing.JPanel pnl_info;
    private javax.swing.JPanel pnl_shoping;
    private javax.swing.JTable tbl_thongTin;
    private javax.swing.JTable tbl_thongTinHD;
    private javax.swing.JTable tbl_thongTinKH;
    private javax.swing.JTabbedPane tpn_fromSwitch;
    private javax.swing.JTextField txt_TenKH;
    private javax.swing.JTextField txt_diaChiKH;
    private javax.swing.JTextField txt_giaBan;
    private javax.swing.JTextField txt_maHangHoa;
    private javax.swing.JTextField txt_maKH;
    private javax.swing.JTextField txt_maNCC;
    private javax.swing.JTextField txt_maNV;
    private javax.swing.JTextField txt_ngayLap;
    private javax.swing.JTextField txt_sdtKH;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTextField txt_soHD;
    private javax.swing.JTextField txt_tenHangHoa;
    private javax.swing.JTextField txt_tenKH;
    private javax.swing.JTextField txt_timKH;
    private javax.swing.JTextField txt_timKiemHD;
    private javax.swing.JTextField txt_tong;
    // End of variables declaration//GEN-END:variables
}
