/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.tacGiaDTO;
import DTO.nhaXuatBanDTO;
import com.mysql.cj.protocol.Resultset;
import java.util.ArrayList;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author DO THE TUNG
 */
public class tacGiaDAO {

    public static Connection con = null;
    public static PreparedStatement ptst = null;
    public static ResultSet rs = null;

    public tacGiaDAO() {
        if (con == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ql_thuvien", "root", "");

            } catch (Exception e) {

            }
        }
    }

    public void them_dao(tacGiaDTO tg) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {

            String qry = "Insert into tacgia values (";
            qry = qry + "'" + tg.Ma + "'";
            qry = qry + "," + "'" + tg.Ten + "'";
            qry = qry + "," + "'" + tg.Ho + "'";
            qry = qry + "," + "'" + tg.GioiTinh + "'";
            qry = qry + "," + "'" + tg.soDienThoai + "'";
            qry = qry + "," + "'" + 1 + "'";
            qry = qry + ")";

            ptst = con.prepareCall(qry);
            ptst.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {

        }

    }

   public boolean checkExist(int Ma,int soDienThoai) {
        try {
            String qry = "select * from tacgia where Ma='" + Ma + "'" +" OR soDienThoai='"+soDienThoai+"'";
//           ma='Ma' AND soDienThoi='soDienThoai';
            PreparedStatement ptst = con.prepareCall(qry);
            ResultSet rs = ptst.executeQuery();
            if (!rs.next()) {
                return false;
            }
            return true;

        } catch (Exception e) {
        }
        return false;
    }

    public ArrayList ReadData() {
        ArrayList ds = new ArrayList<nhaXuatBanDTO>();
        try {
            String qry = "SELECT * FROM tacgia where trangthai=1 ";
            PreparedStatement ptst = con.prepareCall(qry);
            ResultSet rs = ptst.executeQuery();
            while (rs.next()) {
                tacGiaDTO tgdto = new tacGiaDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
                ds.add(tgdto);
            }
        } catch (Exception e) {
        }
        return ds;
    }

   public void xoa(int Ma) {
        try {
            String qry = "update tacgia set trangthai=0 where Ma='" + Ma + "'";
            ptst = con.prepareCall(qry);
            ptst.executeUpdate();

        } catch (Exception e) {

        }
    }

  public  void sua(tacGiaDTO tgdto) {
        try {

            String qry = "UPDATE tacgia set ";
            qry = qry + " Ten=" + "'" + tgdto.Ten + "'";
//               qry = qry+",MaNhaSanXuat"+"'"+nxb.MaNhaSanXuat+"'";

            qry = qry + ",Ho=" + "'" + tgdto.Ho + "'";
            qry = qry + ",GioiTinh=" + "'" + tgdto.GioiTinh + "'";
            qry = qry + ",soDienThoai=" + "'" + tgdto.soDienThoai + "'";

            qry = qry + "where Ma= '" + tgdto.Ma + "'";
            ptst = con.prepareCall(qry);
            ptst.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog((null), e);
        }
    }

  public ArrayList docDSTG(){
        ArrayList ds = new ArrayList<tacGiaDTO>();
        try{
            String qry = "SELECT * FROM tacgia";
            PreparedStatement pst = con.prepareCall(qry);
            rs = pst.executeQuery();
            while(rs.next()){
                tacGiaDTO newtg = new tacGiaDTO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
            ds.add(newtg);
            }
            
        }catch(Exception e){JOptionPane.showMessageDialog(null,e);} 

     return ds;
    }
}
