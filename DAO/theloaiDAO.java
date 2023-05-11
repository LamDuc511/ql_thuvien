<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import DTO.theloaiDTO;

/**
 *
 * @author ADMIN
 */
public class theloaiDAO {
    Connection con = null;
    PreparedStatement ptst = null;
    ResultSet rs = null;

    public theloaiDAO() {
        if (con == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ql_thuvien", "root", "");

            } catch (Exception e) {

            }
        }
    }
    public ArrayList<theloaiDTO> gettheloai(){
        ArrayList<theloaiDTO> ds = new ArrayList();
        try{
            String qry = "SELECT * from theloaisach";
            PreparedStatement ptst = con.prepareCall(qry);
            rs = ptst.executeQuery();
            while(rs.next()){
                theloaiDTO tl = new theloaiDTO(rs.getInt(1),rs.getString(2));
                ds.add(tl);
            }
        }catch (Exception e){}
        
        return ds;
    }
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import DTO.theloaiDTO;

/**
 *
 * @author ADMIN
 */
public class theloaiDAO {
    Connection con = null;
    PreparedStatement ptst = null;
    ResultSet rs = null;

    public theloaiDAO() {
        if (con == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ql_thuvien", "root", "");

            } catch (Exception e) {

            }
        }
    }
    public ArrayList<theloaiDTO> gettheloai(){
        ArrayList<theloaiDTO> ds = new ArrayList();
        try{
            String qry = "SELECT * from theloaisach";
            PreparedStatement ptst = con.prepareCall(qry);
            rs = ptst.executeQuery();
            while(rs.next()){
                theloaiDTO tl = new theloaiDTO(rs.getInt(1),rs.getString(2));
                ds.add(tl);
            }
        }catch (Exception e){}
        
        return ds;
    }
}
>>>>>>> origin/main
