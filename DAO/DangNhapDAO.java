/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import DTO.TaiKhoan;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class DangNhapDAO {
      Connection con = null;
        PreparedStatement ptst = null;
        ResultSet rs = null;
             public  DangNhapDAO(){
        if(con == null){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ql_thuvien","root","");
            }
        catch(ClassNotFoundException | SQLException e){JOptionPane.showMessageDialog(null, e);}
        }            
       }
      public TaiKhoan dangNhap(TaiKhoan tk) {
        try {
            String sql = "SELECT * FROM taikhoan WHERE TaiKhoan=? AND MatKhau=?";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, tk.getTaikhoan());
            pre.setString(2, tk.getMatkhau());
            ResultSet rs = pre.executeQuery();
            TaiKhoan tkLogin = null;
            if (rs.next()) {
                tkLogin = tk;
            }
            return tkLogin;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tk;
    }
}

