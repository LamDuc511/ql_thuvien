/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import GUI.*;
import DTO.*;
import DAO.*;
import static DAO.tacGiaDAO.con;
import static DAO.tacGiaDAO.ptst;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author ADMIN
 */
public class ReaderDAO {
        Connection con = null;
        PreparedStatement ptst = null;
        ResultSet rs = null;
        
     public  ReaderDAO(){
        if(con == null){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ql_thuvien","root","");
            }
        catch(ClassNotFoundException | SQLException e){JOptionPane.showMessageDialog(null, e);}
        }            
       }
    public void them(ReaderDTO dg){
        try{
            String qry = "INSERT into docgia values(";
            qry=qry+"'"+dg.id+"'";
            qry=qry+","+"'"+dg.ho+"'";
            qry=qry+","+"'"+dg.ten+"'";
            qry=qry+","+"'"+dg.ngaysinh+"'";
            qry=qry+","+"'"+dg.gioitinh+"'";
            qry=qry+","+"'"+dg.sdt+"'";
            qry=qry+")";
       
            ptst = con.prepareStatement(qry);
            ptst.executeUpdate();
        }catch(Exception e){JOptionPane.showMessageDialog(null,e);} 
        
    }

   public ArrayList docDSDG(){
        ArrayList ds = new ArrayList<ReaderDTO>();
        try{
            String qry = "SELECT * FROM docgia";
            PreparedStatement pst = con.prepareCall(qry);
            rs = pst.executeQuery();
            while(rs.next()){
                ReaderDTO newdg = new ReaderDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
            ds.add(newdg);
            }
            
        }catch(Exception e){JOptionPane.showMessageDialog(null,e);} 

     return ds;
    }
    public void xoa(String ma){
        try {
            String qry = "update docgia set trangthai=0 where Ma='" + ma + "'";
            ptst = con.prepareCall(qry);
            ptst.executeUpdate();

        } catch (Exception e) {        }
    
    }
    public void sua(ReaderDTO dg){
        try{
            String qry = "UPDATE docgia set ";
            qry=qry+" ho="+"'"+dg.ho+"'";
            qry=qry+",ten="+"'"+dg.ten+"'";
            qry=qry+",ngaysinh="+"'"+dg.ngaysinh+"'";
            qry=qry+",gioitinh="+"'"+dg.gioitinh+"'";
            qry=qry+",sodienthoai="+"'"+dg.sdt+"'";
            qry=qry+" where Ma = '"+dg.id+"'";
            ptst = con.prepareStatement(qry);
            ptst.executeUpdate();
        }catch(Exception e){JOptionPane.showMessageDialog(null,e);}
        
                         }
        }
     


            



