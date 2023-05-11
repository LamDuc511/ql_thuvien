
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import GUI.*;
import DTO.EmployeeDTO;
import BUS.EmployeeBUS;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author ADMIN
 */
public class EmployeeDAO {
        Connection con = null;
        PreparedStatement ptst = null;
        ResultSet rs = null;
        
     public  EmployeeDAO(){
        if(con == null){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ql_thuvien","root","");
            }
        catch(ClassNotFoundException | SQLException e){JOptionPane.showMessageDialog(null, e);}
        }            
       }
    public void them(EmployeeDTO nv){
        try{
            String qry = "INSERT into nhanvien values(";
            qry=qry+"'"+nv.id+"'";
            qry=qry+","+"'"+nv.ho+"'";
            qry=qry+","+"'"+nv.ten+"'";
            qry=qry+","+"'"+nv.luong+"'";
            qry=qry+","+"'"+nv.diachi+"'";
            qry=qry+","+"'"+nv.ngaysinh+"'";
            qry=qry+","+"'"+nv.gioitinh+"'";
            qry=qry+","+"'"+nv.sdt+"'";
            qry=qry+")";
       
            ptst = con.prepareStatement(qry);
            ptst.executeUpdate();
        }catch(Exception e){JOptionPane.showMessageDialog(null,e);} 
        
    }

   public ArrayList docDSNV(){
        ArrayList ds = new ArrayList<EmployeeDTO>();
        try{
            String qry = "SELECT * FROM nhanvien";
            PreparedStatement pst = con.prepareCall(qry);
            rs = pst.executeQuery();
            while(rs.next()){
                EmployeeDTO newnv = new EmployeeDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
            ds.add(newnv);
            }
            
        }catch(Exception e){JOptionPane.showMessageDialog(null,e);} 

     return ds;
    }
    public void xoa(String ma){
        try{
            String qry = "DELETE from nhanvien where Ma = '" + ma + "'";
            ptst = con.prepareStatement(qry);
            ptst.executeUpdate();
        }catch(Exception e){JOptionPane.showMessageDialog(null,e);}
        }
    public void sua(EmployeeDTO nv){
        try{
            String qry = "UPDATE nhanvien set ";
            qry=qry+" ho="+"'"+nv.ho+"'";
            qry=qry+",ten="+"'"+nv.ten+"'";
            qry=qry+",luong="+"'"+nv.luong+"'";
            qry=qry+",diachi="+"'"+nv.diachi+"'";
            qry=qry+",ngaysinh="+"'"+nv.ngaysinh+"'";
            qry=qry+",gioitinh="+"'"+nv.gioitinh+"'";
            qry=qry+",sodienthoai="+"'"+nv.sdt+"'";
            qry=qry+" where Ma = '"+nv.id+"'";
            ptst = con.prepareStatement(qry);
            ptst.executeUpdate();
        }catch(Exception e){JOptionPane.showMessageDialog(null,e);}
        
                         }
        }
     


            




