<<<<<<< HEAD
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import com.mysql.cj.protocol.Resultset;
import java.util.ArrayList;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.ResultSet;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import DTO.sachDTO;
import BUS.sachBUS;

/**
 *
 * @author DO THE TUNG
 */
public class sachDAO {

    public static Connection conn = null;
    public static PreparedStatement ptst = null;
    public static ResultSet rs = null;

    public sachDAO() {
        if (conn == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ql_thuvien", "root", "");
            } catch (Exception e) {
            }
        }
    }

    public ArrayList<sachDTO> getListSach() {

        try {
            String sql = " select * from  sach trangthai =1";
            PreparedStatement ptst = conn.prepareCall(sql);
            ResultSet rs = ptst.executeQuery();
            ArrayList<sachDTO> dssp = new ArrayList<>();
            while (rs.next()) {
                sachDTO sach = new sachDTO();
                sach.setMa(rs.getInt(1));
                sach.setTen(rs.getString(2));
                sach.setMaTacGia(rs.getInt(3));

                sach.setMaTheLoai(rs.getInt(4));
                sach.setMaNhaSanXuat(rs.getInt(5));
                sach.setNamSanXuat(rs.getInt(6));
                sach.setSoLuong(rs.getInt(7));
                sach.setAnh(rs.getString(8));
                sach.setGia(rs.getInt(9));
                dssp.add(sach);
            }
            return dssp;

        } catch (Exception e) {
        }
        return null;

    }

    public sachDTO getSach(int ma) {
        try {
            String sql = "select * from sach where Ma=?";
            PreparedStatement ptst = conn.prepareCall(sql);
            ptst.setInt(1, ma);

            ResultSet rs = ptst.executeQuery();
            if (rs.next()) {
                sachDTO sach = new sachDTO();
                sach.setMa(rs.getInt(1));

                sach.setTen(rs.getString(2));
                sach.setMaTacGia(rs.getInt(3));
                sach.setMaTheLoai(rs.getInt(4));
                sach.setMaNhaSanXuat(rs.getInt(5));
                sach.setNamSanXuat(rs.getInt(6));

                sach.setSoLuong((rs.getInt(7)));
                sach.setAnh(rs.getString(8));
                sach.setGia(rs.getInt(9));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public ArrayList<sachDTO> getSachtheoMaTacGia(int maTacGia) {

        try {
            String sql = " select * from sach where MaTacGia = ?";
            PreparedStatement ptst = conn.prepareCall(sql);
            ptst.setInt(1, maTacGia);
            ResultSet rs = ptst.executeQuery();
            ArrayList<sachDTO> dssp = new ArrayList<>();
            while (rs.next()) {
                sachDTO sach = new sachDTO();

                sach.setMa(rs.getInt(1));
                sach.setTen(rs.getString(2));
                sach.setMaTacGia(rs.getInt(3));
                sach.setMaTheLoai(rs.getInt(4));
                sach.setMaNhaSanXuat(rs.getInt(5));
                sach.setNamSanXuat(rs.getInt(6));
                sach.setSoLuong(rs.getInt(7));
                sach.setAnh(rs.getString(8));
                sach.setGia(rs.getInt(9));

                dssp.add(sach);

            }
            return dssp;

        } catch (SQLException e) {

        }
        return null;

    }

    
    
            
    public String getAnh(int ma) {
        try {
            String sql = "select Anh from sach where Ma=?";
            PreparedStatement ptst = conn.prepareCall(sql);
            ptst.setInt(1, ma);
            ResultSet rs = ptst.executeQuery();
            if (rs.next()) {
                return rs.getString(" Anh");

            }

        } catch (SQLException e) {

        }
        return "";

    }

    public void updateSoLuong(int ma, int soLuongMat) {
        sachDTO sach = getSach(ma);
        int soLuong = sach.getSoLuong();
        sach.setSoLuong(soLuong + soLuongMat);
        try {
            String sql = " upadate Sach set soluong =? where ma=" + ma;
            PreparedStatement ptst = conn.prepareStatement(sql);
            ptst.setInt(1, sach.getSoLuong());
            ptst.executeUpdate();
        } catch (Exception e) {
        }

    }

    public boolean themSanPham(sachDTO sach) {
        try {
            String sql = " insert Into sach (Ma,Ten,MaTacGia,MaTheLoai,MaNhaSanXuat, NamSanXuat,soLuong,Anh,Gia,trangthai)" + "VALUES(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ptst = conn.prepareCall(sql);
            ptst.setInt(1, sach.getMa());
            ptst.setString(2, sach.getTen());
            ptst.setInt(3, sach.getMaTacGia());
            ptst.setInt(3, sach.getMaTheLoai());
            ptst.setInt(4, sach.getMaNhaSanXuat());
            ptst.setInt(5, sach.getNamSanXuat());
            ptst.setInt(7, sach.getSoLuong());
            ptst.setString(8, sach.getAnh());
            ptst.setInt(9, sach.getGia());
            ptst.setInt(10,1);
            

            ptst.execute();

            return true;
            
                   
        } catch (SQLException e) {

        }

        return false;

    }

    public boolean xoaSanch(int maSach) {
        try {
            String sql = "update sach set trang thai = 0 where ma='" + maSach + "'";
            Statement st = conn.createStatement();
            st.execute(sql);
            return true;
            
        } catch (Exception e) {
        }
        return false;

    }

    public boolean suaSach(sachDTO sach) {
        try {
            String sql = " update sach set" + " Ten=?,"
                    + "MaTacGia=?,MaTheLoai=?,MaNhaSanXuat=?,NamSanXuat=?,soLuong= ?,Anh=? ,Gia =?"
                    + "where Ma=?";
            PreparedStatement ptst = conn.prepareCall(sql);
            ptst.setString(1, sach.getTen());

            ptst.setInt(2, sach.getMaTacGia());
            ptst.setInt(3, sach.getMaTheLoai());
            ptst.setInt(4, sach.getMaNhaSanXuat());
            ptst.setInt(5, sach.getNamSanXuat());
            ptst.setInt(6, sach.getSoLuong());
            ptst.setString(7, sach.getAnh());
            ptst.setInt(8, sach.getGia());
            ptst.execute();
            return true;
            

        } catch (Exception e) {

        }
        return false;

    }
}
=======
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import com.mysql.cj.protocol.Resultset;
import java.util.ArrayList;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.ResultSet;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import DTO.sachDTO;
import BUS.sachBUS;

/**
 *
 * @author DO THE TUNG
 */
public class sachDAO {

    public static Connection conn = null;
    public static PreparedStatement ptst = null;
    public static ResultSet rs = null;

    public sachDAO() {
        if (conn == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ql_thuvien", "root", "");
            } catch (Exception e) {
            }
        }
    }

    public ArrayList<sachDTO> getListSach() {

        try {
            String sql = " select * from  sach trangthai =1";
            PreparedStatement ptst = conn.prepareCall(sql);
            ResultSet rs = ptst.executeQuery();
            ArrayList<sachDTO> dssp = new ArrayList<>();
            while (rs.next()) {
                sachDTO sach = new sachDTO();
                sach.setMa(rs.getInt(1));
                sach.setTen(rs.getString(2));
                sach.setMaTacGia(rs.getInt(3));

                sach.setMaTheLoai(rs.getInt(4));
                sach.setMaNhaSanXuat(rs.getInt(5));
                sach.setNamSanXuat(rs.getInt(6));
                sach.setSoLuong(rs.getInt(7));
                sach.setAnh(rs.getString(8));
                sach.setGia(rs.getInt(9));
                dssp.add(sach);
            }
            return dssp;

        } catch (Exception e) {
        }
        return null;

    }

    public sachDTO getSach(int ma) {
        try {
            String sql = "select * from sach where Ma=?";
            PreparedStatement ptst = conn.prepareCall(sql);
            ptst.setInt(1, ma);

            ResultSet rs = ptst.executeQuery();
            if (rs.next()) {
                sachDTO sach = new sachDTO();
                sach.setMa(rs.getInt(1));

                sach.setTen(rs.getString(2));
                sach.setMaTacGia(rs.getInt(3));
                sach.setMaTheLoai(rs.getInt(4));
                sach.setMaNhaSanXuat(rs.getInt(5));
                sach.setNamSanXuat(rs.getInt(6));

                sach.setSoLuong((rs.getInt(7)));
                sach.setAnh(rs.getString(8));
                sach.setGia(rs.getInt(9));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public ArrayList<sachDTO> getSachtheoMaTacGia(int maTacGia) {

        try {
            String sql = " select * from sach where MaTacGia = ?";
            PreparedStatement ptst = conn.prepareCall(sql);
            ptst.setInt(1, maTacGia);
            ResultSet rs = ptst.executeQuery();
            ArrayList<sachDTO> dssp = new ArrayList<>();
            while (rs.next()) {
                sachDTO sach = new sachDTO();

                sach.setMa(rs.getInt(1));
                sach.setTen(rs.getString(2));
                sach.setMaTacGia(rs.getInt(3));
                sach.setMaTheLoai(rs.getInt(4));
                sach.setMaNhaSanXuat(rs.getInt(5));
                sach.setNamSanXuat(rs.getInt(6));
                sach.setSoLuong(rs.getInt(7));
                sach.setAnh(rs.getString(8));
                sach.setGia(rs.getInt(9));

                dssp.add(sach);

            }
            return dssp;

        } catch (SQLException e) {

        }
        return null;

    }

    
    
            
    public String getAnh(int ma) {
        try {
            String sql = "select Anh from sach where Ma=?";
            PreparedStatement ptst = conn.prepareCall(sql);
            ptst.setInt(1, ma);
            ResultSet rs = ptst.executeQuery();
            if (rs.next()) {
                return rs.getString(" Anh");

            }

        } catch (SQLException e) {

        }
        return "";

    }

    public void updateSoLuong(int ma, int soLuongMat) {
        sachDTO sach = getSach(ma);
        int soLuong = sach.getSoLuong();
        sach.setSoLuong(soLuong + soLuongMat);
        try {
            String sql = " upadate Sach set soluong =? where ma=" + ma;
            PreparedStatement ptst = conn.prepareStatement(sql);
            ptst.setInt(1, sach.getSoLuong());
            ptst.executeUpdate();
        } catch (Exception e) {
        }

    }

    public boolean themSanPham(sachDTO sach) {
        try {
            String sql = " insert Into sach (Ma,Ten,MaTacGia,MaTheLoai,MaNhaSanXuat, NamSanXuat,soLuong,Anh,Gia,trangthai)" + "VALUES(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ptst = conn.prepareCall(sql);
            ptst.setInt(1, sach.getMa());
            ptst.setString(2, sach.getTen());
            ptst.setInt(3, sach.getMaTacGia());
            ptst.setInt(3, sach.getMaTheLoai());
            ptst.setInt(4, sach.getMaNhaSanXuat());
            ptst.setInt(5, sach.getNamSanXuat());
            ptst.setInt(7, sach.getSoLuong());
            ptst.setString(8, sach.getAnh());
            ptst.setInt(9, sach.getGia());
            ptst.setInt(10,1);
            

            ptst.execute();

            return true;
            
                   
        } catch (SQLException e) {

        }

        return false;

    }

    public boolean xoaSanch(int maSach) {
        try {
            String sql = "update sach set trang thai = 0 where ma='" + maSach + "'";
            Statement st = conn.createStatement();
            st.execute(sql);
            return true;
            
        } catch (Exception e) {
        }
        return false;

    }

    public boolean suaSach(sachDTO sach) {
        try {
            String sql = " update sach set" + " Ten=?,"
                    + "MaTacGia=?,MaTheLoai=?,MaNhaSanXuat=?,NamSanXuat=?,soLuong= ?,Anh=? ,Gia =?"
                    + "where Ma=?";
            PreparedStatement ptst = conn.prepareCall(sql);
            ptst.setString(1, sach.getTen());

            ptst.setInt(2, sach.getMaTacGia());
            ptst.setInt(3, sach.getMaTheLoai());
            ptst.setInt(4, sach.getMaNhaSanXuat());
            ptst.setInt(5, sach.getNamSanXuat());
            ptst.setInt(6, sach.getSoLuong());
            ptst.setString(7, sach.getAnh());
            ptst.setInt(8, sach.getGia());
            ptst.execute();
            return true;
            

        } catch (Exception e) {

        }
        return false;

    }
}
>>>>>>> origin/main
