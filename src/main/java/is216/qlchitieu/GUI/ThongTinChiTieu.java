/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is216.qlchitieu.GUI;

import is216.qlchitieu.BLL.ThongTinChiTieuBLL;
import is216.qlchitieu.DBUtils.DBConnect;
import is216.qlchitieu.DTO.ThongTinChiTieuDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class ThongTinChiTieu extends javax.swing.JFrame {

    /**
     * Creates new form ThongTinChiTieu
     *
     */
    final String nguoiDung;

    DefaultTableModel tblModelTTCT;
    ArrayList<String> ListMaTieuDung = new ArrayList<String>();
    ArrayList<String> ListLoaiCT = new ArrayList<String>();
    String MaTD = "";
    String MaCT = "";

    DBConnect dbu = null;
    java.sql.Connection con = null;
    PreparedStatement pres = null;
    ResultSet rs = null;
    String temp = "";

    public double TinhTongChiTieuThang() {
        double TongChiTieuThang = 0;
        String strSQL = "SELECT tongChiTieuThang from gioihanchitieu where tenDangNhap = '" + lbNguoiDung.getText() + "'";
        try {
            dbu = new DBConnect();
            con = dbu.createConn();
            pres = con.prepareStatement(strSQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = pres.executeQuery();
            String TongHienTai = "";
            while (rs.next()) {
                TongHienTai = rs.getString("tongChiTieuThang");
            }
            TongChiTieuThang = Double.parseDouble(TongHienTai) + Double.parseDouble(txtLuongTien.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return TongChiTieuThang;

    }

    public int getGioiHan() {
        int GioiHan = 0;
        String strSQL = "SELECT gioiHan from gioihanchitieu where tenDangNhap = '" + lbNguoiDung.getText() + "'";
        try {
            dbu = new DBConnect();
            con = dbu.createConn();
            pres = con.prepareStatement(strSQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = pres.executeQuery();
            String GH = "";
            while (rs.next()) {
                GH = rs.getString("gioiHan");
            }
            GioiHan = Integer.parseInt(GH);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return GioiHan;
    }

    public void Refresh() {
        datNgayChi.setDateFormatString("");
        txtTenHangHoa.setText("");
        txtSoLuong.setText("");
        txtThanhTien.setText("");
        cbbLoaiChiTieu.setSelectedIndex(0);
        txtLuongTien.setText("");
    }

    public String LoadMaTieuDung() {

        String strSQL = "SELECT maTieuDung FROM TIEUDUNG order by maTieuDung DESC";
        try {
            dbu = new DBConnect();
            con = dbu.createConn();
            pres = con.prepareStatement(strSQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = pres.executeQuery();
            if (rs.absolute(1) == false) {
                MaTD = "td0001";
            } else {
                String MaTDHienTai = rs.getString("maTieuDung");
                MaTD = MaTDHienTai.substring(2, 6);
                int MaTDmoi = Integer.parseInt(MaTD) + 1;
                if (MaTDmoi < 10) {
                    MaTD = "td000" + MaTDmoi;
                } else if (MaTDmoi < 100) {
                    MaTD = "td00" + MaTDmoi;
                } else if (MaTDmoi < 1000) {
                    MaTD = "td0" + MaTDmoi;
                } else {
                    MaTD = "td" + MaTDmoi;
                }
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ListMaTieuDung.add(MaTD);
        return MaTD;
    }

    public String LoadMaChiTieu() {

        String strSQL = "SELECT maChiTieu FROM THONGTINCHITIEU order by maChiTieu DESC";
        try {
            dbu = new DBConnect();
            con = dbu.createConn();
            pres = con.prepareStatement(strSQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = pres.executeQuery();
            if (rs.absolute(1) == false) {
                MaCT = "ct0001";
            } else {
                String MaCTHienTai = rs.getString("maChiTieu");
                MaCT = MaCTHienTai.substring(2, 6);
                int MaCTmoi = Integer.parseInt(MaCT) + 1;
                if (MaCTmoi < 10) {
                    MaCT = "ct000" + MaCTmoi;
                } else if (MaCTmoi < 100) {
                    MaCT = "ct00" + MaCTmoi;
                } else if (MaCTmoi < 1000) {
                    MaCT = "ct0" + MaCTmoi;
                } else {
                    MaCT = "ct" + MaCTmoi;
                }
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return MaCT;
    }

    public void LoadTable() {
        tblModelTTCT = new DefaultTableModel();
        String tieude[] = {"STT", "Tên hàng hóa", "Tên loại chi tiêu", "Số lượng", "Thành tiền"};
        tblModelTTCT.setColumnIdentifiers(tieude);

        ArrayList<ThongTinChiTieuDTO> arr = new ArrayList<ThongTinChiTieuDTO>();

        for (int i = 0; i < ListMaTieuDung.size(); i++) {
            String sqlSelect = "select * from TIEUDUNG WHERE maTieuDung = '" + ListMaTieuDung.get(i) + "'";
            try {
                dbu = new DBConnect();
                con = dbu.createConn();
                pres = con.prepareStatement(sqlSelect);

                rs = pres.executeQuery();

                String row[] = new String[5];
                while (rs.next()) {
                    int count = i + 1;
                    row[0] = temp + count;
                    row[1] = rs.getString("tenHangHoa");
                    String j = rs.getString("loaiChiTieu");
                    row[2] = ListLoaiCT.get(Integer.parseInt(j) - 1);
                    row[3] = rs.getString("soLuong");
                    row[4] = rs.getString("thanhTien");
                    tblModelTTCT.addRow(row);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        tblTTCT.setModel(tblModelTTCT);
    }

    public void LoadCbbLoaiCT() {
        ListLoaiCT.removeAll(ListLoaiCT);
        try {
            String strSQL = "Select tenloaiChiTieu from LOAICHITIEU";
            dbu = new DBConnect();
            con = dbu.createConn();
            pres = con.prepareStatement(strSQL);
            rs = pres.executeQuery();
            while (rs.next()) {
                ListLoaiCT.add(rs.getString("tenloaiChiTieu"));
            }

            cbbLoaiChiTieu.setModel(new DefaultComboBoxModel<String>(ListLoaiCT.toArray(new String[0])));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public double TinhLuongTien() {
        double LuongTien = 0;
        for (int i = 0; i < tblModelTTCT.getRowCount(); i++) {
            LuongTien += Double.parseDouble(tblModelTTCT.getValueAt(i, 4).toString());
        }
        return LuongTien;
    }

    public void settxtLuongTien() {
        double LuongTien = TinhLuongTien();
        String temp = String.valueOf(LuongTien);
        txtLuongTien.setText(temp);
    }

    public ThongTinChiTieu(String nguoiDung) {
        initComponents();
        this.nguoiDung = nguoiDung;
        lbNguoiDung.setText(nguoiDung);
        Date date = new Date();
        datNgayChi.setDate(date);
        tblModelTTCT = new DefaultTableModel();
        String tieude[] = {"STT", "Tên hàng hóa", "Tên loại chi tiêu", "Số lượng", "Thành tiền"};
        tblModelTTCT.setColumnIdentifiers(tieude);
        LoadCbbLoaiCT();
        if (lbNguoiDung.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Xin hãy đăng nhập trước",
                    "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            new Login().setVisible(true);
            this.dispose();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbNguoiDung = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTTCT = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        datNgayChi = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        txtTenHangHoa = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtThanhTien = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtLuongTien = new javax.swing.JTextField();
        btnQuayLai = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cbbLoaiChiTieu = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        btnThemHangHoa = new javax.swing.JButton();
        btnXoaHangHoa = new javax.swing.JButton();
        btnThemChiTieu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Thông tin chi tiêu");

        lbNguoiDung.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbNguoiDung.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbNguoiDung, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addComponent(lbNguoiDung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblTTCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblTTCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTTCTMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTTCT);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Ngày giao dịch");

        datNgayChi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Tên hàng hóa");

        txtTenHangHoa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Số lượng");

        txtSoLuong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Thành tiền");

        txtThanhTien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Lượng tiền đã chi");

        txtLuongTien.setEditable(false);
        txtLuongTien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnQuayLai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnQuayLai.setText("Quay lại");
        btnQuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayLaiActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Tên loại chi tiêu");

        cbbLoaiChiTieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(datNgayChi, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnQuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtTenHangHoa, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(103, 103, 103)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtLuongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbbLoaiChiTieu, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(btnQuayLai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(datNgayChi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbLoaiChiTieu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenHangHoa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLuongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        btnThemHangHoa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnThemHangHoa.setText("Thêm hàng hóa");
        btnThemHangHoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemHangHoaActionPerformed(evt);
            }
        });

        btnXoaHangHoa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnXoaHangHoa.setText("Xóa hàng hóa");
        btnXoaHangHoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaHangHoaActionPerformed(evt);
            }
        });

        btnThemChiTieu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnThemChiTieu.setText("Thêm chi tiêu");
        btnThemChiTieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemChiTieuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(btnThemHangHoa, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnXoaHangHoa, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(183, 183, 183)
                .addComponent(btnThemChiTieu, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnXoaHangHoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThemChiTieu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemHangHoa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 701, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 401, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayLaiActionPerformed
        // TODO add your handling code here:
        if (!lbNguoiDung.getText().equals("")) {
            new MainMenu(nguoiDung).setVisible(true);
            this.dispose();
        } else {
            new Login().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnQuayLaiActionPerformed

    private void btnXoaHangHoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaHangHoaActionPerformed
        // TODO add your handling code here:
        ThongTinChiTieuDTO HangHoa = new ThongTinChiTieuDTO();
        String MaTDRemove = "";
        try {
            dbu = new DBConnect();
            con = dbu.createConn();
            String MaTDSQL = "SELECT maTieuDung FROM TIEUDUNG WHERE tenHangHoa = '" + txtTenHangHoa.getText()
                    + "' AND soLuong = '" + txtSoLuong.getText() + "' AND thanhTien = '" + txtThanhTien.getText() + "'";
            pres = con.prepareStatement(MaTDSQL);
            rs = pres.executeQuery();
            while (rs.next()) {
                MaTDRemove = rs.getString("maTieuDung");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        HangHoa.setmaTieuDung(MaTDRemove);

        ThongTinChiTieuBLL HangHoaBLL = new ThongTinChiTieuBLL();
        int choice = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn xóa dữ liệu!", "Xác Nhận", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            try {
                int result = HangHoaBLL.deleteHangHoa(HangHoa);
                if (result != 0) {
                    JOptionPane.showMessageDialog(null, "Xóa dữ liệu thành công: ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }

                for (int i = 0; i < ListMaTieuDung.size(); i++) {
                    if (ListMaTieuDung.get(i).equals(MaTDRemove)) {
                        ListMaTieuDung.remove(i);
                    }
                }

                LoadTable();
                settxtLuongTien();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnXoaHangHoaActionPerformed

    private void btnThemHangHoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemHangHoaActionPerformed
        // TODO add your handling code here:
        ThongTinChiTieuDTO HangHoa = new ThongTinChiTieuDTO();
        ThongTinChiTieuBLL HangHoa_BLL = new ThongTinChiTieuBLL();

        LoadMaTieuDung();
        if (lbNguoiDung.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Xin hãy đăng nhập trước",
                    "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (txtTenHangHoa.getText().equals("") || txtThanhTien.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập tên hàng hóa và thành tiền",
                        "Thông báo", JOptionPane.INFORMATION_MESSAGE);

            } else {
                HangHoa.setmaTieuDung(MaTD);
                HangHoa.setLoaiChiTieu(cbbLoaiChiTieu.getSelectedIndex() + 1);
                HangHoa.setTenHangHoa(txtTenHangHoa.getText());
                HangHoa.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
                HangHoa.setThanhTien(Double.parseDouble(txtThanhTien.getText()));

                try {
                    int result = HangHoa_BLL.insertHangHoa(HangHoa);
                    if (result != 0) {
                        JOptionPane.showMessageDialog(null, "Thêm hàng hóa thành công: ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

                    }
                    LoadTable();
                    settxtLuongTien();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.out.println("Lỗi");
                    JOptionPane.showMessageDialog(null, "Thêm dữ liệu không thành công: ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnThemHangHoaActionPerformed

    private void tblTTCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTTCTMouseClicked
        // TODO add your handling code here:
        int indexTB = tblTTCT.getSelectedRow();
        if (indexTB < tblTTCT.getRowCount() && indexTB >= 0) {
            txtTenHangHoa.setText(tblModelTTCT.getValueAt(indexTB, 1).toString());
            for (int i = 0; i < ListLoaiCT.size(); i++) {
                if (ListLoaiCT.get(i).equals(tblModelTTCT.getValueAt(indexTB, 2).toString())) {
                    cbbLoaiChiTieu.setSelectedIndex(i);
                }
            }
            txtSoLuong.setText(tblModelTTCT.getValueAt(indexTB, 3).toString());
            txtThanhTien.setText(tblModelTTCT.getValueAt(indexTB, 4).toString());
        }
    }//GEN-LAST:event_tblTTCTMouseClicked

    private void btnThemChiTieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemChiTieuActionPerformed
        // TODO add your handling code here:
        ThongTinChiTieuDTO TTCT = new ThongTinChiTieuDTO();
        ThongTinChiTieuBLL TTCT_BLL = new ThongTinChiTieuBLL();
        int result = 0;

        LoadMaChiTieu();
        if (lbNguoiDung.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Xin hãy đăng nhập trước",
                    "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (tblTTCT.getRowCount() < 1) {
                JOptionPane.showMessageDialog(null, "Vui lòng thêm hàng hóa trước ",
                        "Thông báo", JOptionPane.INFORMATION_MESSAGE);

            } else {
                TTCT.setMaChiTieu(MaCT);
                TTCT.setTenDangNhap(nguoiDung);
                TTCT.setLuongTien(TinhLuongTien());
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                TTCT.setNgayChi(df.format(datNgayChi.getDate()));
                for (int i = 0; i < ListMaTieuDung.size(); i++) {
                    TTCT.setmaTieuDung(ListMaTieuDung.get(i));

                    try {
                        result = TTCT_BLL.insertTTCT(TTCT);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        System.out.println("Lỗi");
                        JOptionPane.showMessageDialog(null, "Thêm dữ liệu không thành công: ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                if (result != 0) {
                    JOptionPane.showMessageDialog(null, "Thêm chi tiêu thành công: ",
                            "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
                result = 0;
                double TongChiTieu = TinhTongChiTieuThang();
                double KhoangCach = getGioiHan() - TongChiTieu;
                TTCT.settongChiTieuThang(TongChiTieu);
                TTCT.setTenDangNhap(nguoiDung);
                try {
                    result = TTCT_BLL.updateTongChiTieuThang(TTCT);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.out.println("Lỗi");
                    JOptionPane.showMessageDialog(null, "Cập nhật tổng chi tiêu tháng không thành công: ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
                if (result != 0) {
                    JOptionPane.showMessageDialog(null, "Tháng này đã chi " + TongChiTieu
                            + " (" + (Math.round(TongChiTieu / getGioiHan() * 100)) + "%)"
                            + "\n\nCòn cách giơi hạn " + KhoangCach,
                            "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
                Refresh();
            }
        }
    }//GEN-LAST:event_btnThemChiTieuActionPerformed

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
            java.util.logging.Logger.getLogger(ThongTinChiTieu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongTinChiTieu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongTinChiTieu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongTinChiTieu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        String username = "";
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThongTinChiTieu(username).setVisible(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnQuayLai;
    private javax.swing.JButton btnThemChiTieu;
    private javax.swing.JButton btnThemHangHoa;
    private javax.swing.JButton btnXoaHangHoa;
    private javax.swing.JComboBox<String> cbbLoaiChiTieu;
    private com.toedter.calendar.JDateChooser datNgayChi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbNguoiDung;
    private javax.swing.JTable tblTTCT;
    private javax.swing.JTextField txtLuongTien;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenHangHoa;
    private javax.swing.JTextField txtThanhTien;
    // End of variables declaration//GEN-END:variables
}
