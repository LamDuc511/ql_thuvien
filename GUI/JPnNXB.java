/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import DTO.nhaXuatBanDTO;
import DAO.nhaXuatBanDAO;
import BUS.nhaXuatBanBUS;
/**
 *
 * @author ADMIN
 */
public class JPnNXB extends javax.swing.JPanel {
 DefaultTableModel tablemodel = new DefaultTableModel();
    ArrayList<nhaXuatBanDTO> nxbList = new ArrayList<>();
    /**
     * Creates new form JPnNXB1
     */
    public JPnNXB() {
        setSize(724,656);
        initComponents();
     tablemodel = (DefaultTableModel) tbnNxb.getModel();

        showData();

    }

    public void showData() {
        nhaXuatBanDAO dataDAO = new nhaXuatBanDAO();
        nxbList = dataDAO.ReadData();

        System.out.println(nxbList.toString());
        tablemodel.setRowCount(0);
        nxbList.forEach((nxb)
                -> {
            System.out.println(nxb.toString());
            tablemodel.addRow(new Object[]{nxb.getMaNhaSanXuat(), nxb.getTenNhaXuatBan(),
                nxb.getDiaChi(), nxb.getSoDienThoai()});
        }
        );

    
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
        jLabel3 = new javax.swing.JLabel();
        txtdiachi = new javax.swing.JTextField();
        txtmanxb = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbnNxb = new javax.swing.JTable();
        txttennxb = new javax.swing.JTextField();
        them = new javax.swing.JButton();
        xoa = new javax.swing.JButton();
        sua = new javax.swing.JButton();
        find = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtsoDienThoai = new javax.swing.JTextField();
        re = new javax.swing.JButton();
        txtFindTen = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(724, 656));
        setPreferredSize(new java.awt.Dimension(724, 656));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(217, 237, 202));
        jPanel1.setMinimumSize(new java.awt.Dimension(724, 656));
        jPanel1.setPreferredSize(new java.awt.Dimension(724, 656));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("TÊN NHÀ XUẤT BẢN");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("MÃ NHÀ XUẤT BẢN");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, -1, -1));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, -1, -1));

        txtdiachi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdiachiActionPerformed(evt);
            }
        });
        jPanel1.add(txtdiachi, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 378, -1));

        txtmanxb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmanxbActionPerformed(evt);
            }
        });
        jPanel1.add(txtmanxb, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 378, -1));

        tbnNxb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "TEN NHA XUAT BAN", "MA NHA XUAT BAN", "ĐỊA CHỈ", "SO DIEN THOAI"
            }
        ));
        tbnNxb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbnNxbMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbnNxb);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 840, 330));

        txttennxb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttennxbActionPerformed(evt);
            }
        });
        jPanel1.add(txttennxb, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 378, -1));

        them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Add.png"))); // NOI18N
        them.setText("THEM");
        them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themActionPerformed(evt);
            }
        });
        jPanel1.add(them, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, -1, -1));

        xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Delete.png"))); // NOI18N
        xoa.setText("XOA ");
        xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoaActionPerformed(evt);
            }
        });
        jPanel1.add(xoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 360, -1, -1));

        sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Edit.png"))); // NOI18N
        sua.setText("SUA");
        sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suaActionPerformed(evt);
            }
        });
        jPanel1.add(sua, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 360, -1, -1));

        find.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Search.png"))); // NOI18N
        find.setText("TIM KIEM");
        find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findActionPerformed(evt);
            }
        });
        jPanel1.add(find, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 430, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("ĐỊA CHỈ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 111, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("SO DIEN THOAI");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, -1, -1));

        txtsoDienThoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsoDienThoaiActionPerformed(evt);
            }
        });
        jPanel1.add(txtsoDienThoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, 378, -1));

        re.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Refresh.png"))); // NOI18N
        re.setText("Refresh");
        re.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reActionPerformed(evt);
            }
        });
        jPanel1.add(re, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 360, -1, -1));
        jPanel1.add(txtFindTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 430, 307, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel7.setText("QUẢN LÝ NHÀ XUẤT BẢN");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 840, 656));
    }// </editor-fold>//GEN-END:initComponents

    private void txtdiachiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdiachiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdiachiActionPerformed

    private void txtmanxbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmanxbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmanxbActionPerformed

    private void tbnNxbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbnNxbMouseClicked
        // TODO add your handling code here:

        DefaultTableModel clickTable = (DefaultTableModel) tbnNxb.getModel();
        int i = tbnNxb.getSelectedRow();
        try {
            txtmanxb.setText(clickTable.getValueAt(i, 0).toString());
            txttennxb.setText(clickTable.getValueAt(i, 1).toString());
            //            txtmanxb.setText(clickTable.getValueAt(i, 1).toString());

            txtdiachi.setText(clickTable.getValueAt(i, 2).toString());
            txtsoDienThoai.setText(clickTable.getValueAt(i, 3).toString());

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_tbnNxbMouseClicked

    private void txttennxbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttennxbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttennxbActionPerformed

    private void themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themActionPerformed
        // TODO add your handling code here:
        nhaXuatBanDTO nxb = new nhaXuatBanDTO();

        nxb.MaNhaSanXuat = Integer.parseInt(txtmanxb.getText());
        nxb.TenNhaXuatBan = txttennxb.getText();
        nxb.DiaChi = txtdiachi.getText();
        nxb.soDienThoai = Integer.parseInt(txtsoDienThoai.getText());
        nhaXuatBanBUS bus = new nhaXuatBanBUS();
        Vector header = new Vector();
        header.add("Ten Nha XUAT BAN");
        header.add("MA NHA XUAT BAN");
        //header.add("Ten Nha XUAT BAN");
        header.add("Dia chi");
        header.add("SO DIEN THOAI");
        if (tablemodel.getRowCount() == 0) {
            tablemodel = new DefaultTableModel(header, 0);

        }
        Vector rowVectoc = new Vector();

        rowVectoc.add(nxb.MaNhaSanXuat);
        rowVectoc.add(nxb.TenNhaXuatBan);
        rowVectoc.add(nxb.DiaChi);
        rowVectoc.add(nxb.soDienThoai);

        if (bus.checkMaNXB(nxb.getMaNhaSanXuat(), nxb.getSoDienThoai())) {
            JOptionPane.showMessageDialog(null, "Mã nha xuat ban bi trung hoac so dien thoai bi trung ");
        } else {
            tablemodel.addRow(rowVectoc);
            tbnNxb.setModel(tablemodel);
            nxbList.add(nxb);
            bus.insert_BUS(nxb);
            JOptionPane.showMessageDialog(null, "THEM NXB THANH CONG");
            System.out.println(nxbList.toString());
        }
    }//GEN-LAST:event_themActionPerformed

    private void xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoaActionPerformed
        // TODO add your handling code here:
        nhaXuatBanBUS bus = new nhaXuatBanBUS();
        int i = tbnNxb.getSelectedRow();
        if (i >= 0) {
            int Ma = Integer.parseInt(txtmanxb.getText());

            nxbList.remove(bus.findWithId(Ma));

            bus.xoa(Ma);

            tablemodel.removeRow(i);

            tbnNxb.setModel(tablemodel);

            System.out.println(nxbList.toString());
            JOptionPane.showMessageDialog(null, " DA XOA THANH CONG");

        }
    }//GEN-LAST:event_xoaActionPerformed

    private void suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suaActionPerformed
        // TODO add your handling code here:

        int i = tbnNxb.getSelectedRow();
        nhaXuatBanBUS bus = new nhaXuatBanBUS();
        if (i >= 0) {
            nhaXuatBanDTO nxb = new nhaXuatBanDTO();

            nxb.MaNhaSanXuat = Integer.parseInt(txtmanxb.getText());
            nxb.TenNhaXuatBan = txttennxb.getText();
            nxb.DiaChi = txtdiachi.getText();
            nxb.soDienThoai = Integer.parseInt(txtsoDienThoai.getText());
            tablemodel.setValueAt(nxb.TenNhaXuatBan, i, 1);
            tablemodel.setValueAt(nxb.MaNhaSanXuat, i, 0);
            tablemodel.setValueAt(nxb.DiaChi, i, 2);
            tablemodel.setValueAt(nxb.soDienThoai, i, 3);
            tbnNxb.setModel(tablemodel);

            bus.sua(nxb);
            JOptionPane.showMessageDialog(null, " DA SUA THANH CONG");

        }
    }//GEN-LAST:event_suaActionPerformed

    private void findActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findActionPerformed
        // TODO add your handling code here:

        //        tbnNxb.setModel(returnTable(TimTen(txtFindTen.getText())));
        nhaXuatBanBUS busfind = new nhaXuatBanBUS();
        ArrayList<nhaXuatBanDTO> ds = busfind.TimMa(Integer.parseInt(txtFindTen.getText()));
        //busfind.returnTable(ds);
        System.out.println(ds.toString());
        tbnNxb.setModel(busfind.returnTable(ds));
    }//GEN-LAST:event_findActionPerformed

    private void txtsoDienThoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsoDienThoaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsoDienThoaiActionPerformed

    private void reActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reActionPerformed

        nhaXuatBanDAO dataDAO = new nhaXuatBanDAO();
        nxbList = dataDAO.ReadData();
        DefaultTableModel tblmodel = (DefaultTableModel) tbnNxb.getModel();
        System.out.println(nxbList.toString());
        tblmodel.setRowCount(0);
        nxbList.forEach((nxb)
            -> {
                System.out.println(nxb.toString());
                tblmodel.addRow(new Object[]{nxb.getMaNhaSanXuat(), nxb.getTenNhaXuatBan(),
                    nxb.getDiaChi(), nxb.getSoDienThoai()});
        }
                
        );
        tbnNxb.setModel(tblmodel);
    }//GEN-LAST:event_reActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton find;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JButton re;
    public javax.swing.JButton sua;
    public javax.swing.JTable tbnNxb;
    public javax.swing.JButton them;
    public javax.swing.JTextField txtFindTen;
    public javax.swing.JTextField txtdiachi;
    public javax.swing.JTextField txtmanxb;
    public javax.swing.JTextField txtsoDienThoai;
    public javax.swing.JTextField txttennxb;
    public javax.swing.JButton xoa;
    // End of variables declaration//GEN-END:variables
}