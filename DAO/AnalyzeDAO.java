<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Others.JConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class AnalyzeDAO {
    Connection con = null;
        PreparedStatement ptst = null;
        ResultSet rs = null;
    public int getSoLuongNhanVien() {
        try {
           String qry = "SELECT COUNT(*) FROM nhanvien";
           PreparedStatement pst = con.prepareCall(qry);
            rs = pst.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            return -1;
        }
        return 0;
    }
     public  AnalyzeDAO(){
        if(con == null){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ql_thuvien","root","");
            }
        catch(ClassNotFoundException | SQLException e){JOptionPane.showMessageDialog(null, e);}
        }            
       }
     public int getSoLuongDocgia() {
        try {
            String qry = "SELECT COUNT(*) FROM docgia";
           PreparedStatement pst = con.prepareCall(qry);
            rs = pst.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            return -1;
        }
        return 0;
    }
     public int getSoLuongSach() {
        try {
            String qry = "SELECT COUNT(*) FROM sach";
           PreparedStatement pst = con.prepareCall(qry);
            rs = pst.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            return -1;
        }
        return 0;
    }
     public int getsoluongMuon(){
         try{
             String qry= "SELECT SUM(SoLuong) FROM chitietphieumuon";
             PreparedStatement pst = con.prepareCall(qry);
             rs=pst.executeQuery();
             while(rs.next()){
                 return rs.getInt(1);
             }
         }catch(SQLException ex){
             return -1;
         }
         return 0;
     }
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Others.JConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class AnalyzeDAO {
    Connection con = null;
        PreparedStatement ptst = null;
        ResultSet rs = null;
    public int getSoLuongNhanVien() {
        try {
           String qry = "SELECT COUNT(*) FROM nhanvien";
           PreparedStatement pst = con.prepareCall(qry);
            rs = pst.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            return -1;
        }
        return 0;
    }
     public  AnalyzeDAO(){
        if(con == null){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ql_thuvien","root","");
            }
        catch(ClassNotFoundException | SQLException e){JOptionPane.showMessageDialog(null, e);}
        }            
       }
     public int getSoLuongDocgia() {
        try {
            String qry = "SELECT COUNT(*) FROM docgia";
           PreparedStatement pst = con.prepareCall(qry);
            rs = pst.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            return -1;
        }
        return 0;
    }
     public int getSoLuongSach() {
        try {
            String qry = "SELECT COUNT(*) FROM sach";
           PreparedStatement pst = con.prepareCall(qry);
            rs = pst.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            return -1;
        }
        return 0;
    }
     public int getsoluongMuon(){
         try{
             String qry= "SELECT SUM(SoLuong) FROM chitietphieumuon";
             PreparedStatement pst = con.prepareCall(qry);
             rs=pst.executeQuery();
             while(rs.next()){
                 return rs.getInt(1);
             }
         }catch(SQLException ex){
             return -1;
         }
         return 0;
     }
}
>>>>>>> origin/main
