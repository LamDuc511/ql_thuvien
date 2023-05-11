/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.CTPhieuMuonDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author quang
 */
public class CTPhieuMuonDAO {
    MyConnectUnit connect;
    
    //Lấy thông tin từ db
    public ArrayList<CTPhieuMuonDTO> docDB(String condition, String orderBy) throws Exception {
        // kết nối CSDL
        connect = new MyConnectUnit();
        
        ResultSet result = this.connect.Select("chitietphieumuon", condition, orderBy);
        ArrayList<CTPhieuMuonDTO> ctpmuons = new ArrayList<>();
        while ( result.next() ) {
            CTPhieuMuonDTO ctpmuon = new CTPhieuMuonDTO();
            ctpmuon.setMaSach(result.getInt("MaSach"));
            ctpmuon.setMaPM(result.getInt("MaPhieuMuon"));
            ctpmuon.setSoLuong(result.getInt("SoLuong"));
            ctpmuons.add(ctpmuon);
        }
        connect.Close();
        return ctpmuons;
    }
    
    public ArrayList<CTPhieuMuonDTO> docDB(String condition) throws Exception {
        return docDB(condition, null);
    }
    
    public ArrayList<CTPhieuMuonDTO> docDB() throws Exception {
        System.out.println("docdb");
        return docDB(null);
    }
    
    /*
     Tạo thêm 1 ctpmuon dựa theo đã có thông tin trước
     * @return true nếu thành công
     */
    public Boolean them(CTPhieuMuonDTO nv) throws Exception {
        connect = new MyConnectUnit();
        
        // tạo đối tượng truyền vào
        HashMap<String, Object> insertValues = new HashMap<>();
        insertValues.put("MaSach", nv.getMaSach());
        insertValues.put("MaPhieuMuon", nv.getMaPM());
        insertValues.put("SoLuong", nv.getSoLuong());
        
        Boolean check = connect.Insert("chitietphieumuon", insertValues);        
        connect.Close();
        return check;
    }
    
    /** 
     * @param nv chuyền vào dữ liệu tài khoản để xóa
     * @return true nếu thành công
     * @throws java.lang.Exception
     */
    public Boolean xoa(CTPhieuMuonDTO nv) throws Exception {
        connect = new MyConnectUnit();
        String condition = "MaSach = '"+nv.getMaSach()+"' and MaPhieuMuon= '"+nv.getMaPM()+"'";
        //DELETE FROM chitietphieumuon WHERE `chitietphieumuon`.`MaPhieuMuon` = 8 AND `chitietphieumuon`.`MaSach` = 3"
        Boolean check = connect.Delete("chitietphieumuon", condition);
        
        connect.Close();
        return check;
    }
    
    /**
     * @param nv truyền vào dữ liệu tài khoản mới
     * Sửa thông tin đăng nhập hoặc là cấp bậc của 1 tài khoản
     * @return true nếu thành công
     * @throws java.lang.Exception
     */
    public Boolean sua(CTPhieuMuonDTO nv) throws Exception {
        connect = new MyConnectUnit();
        
        // tạo đối tượng truyền vào
        HashMap<String, Object> insertValues = new HashMap<>();
        insertValues.put("MaSach", nv.getMaSach());
        insertValues.put("MaPhieuMuon", nv.getMaPM());
        insertValues.put("SoLuong", nv.getSoLuong());
        
        String condition = "MaSach = '"+nv.getMaSach()+"' and MaPhieuMuon= '"+nv.getMaPM()+"'";
        
        Boolean check = connect.Update("chitietphieumuon", insertValues, condition);
        
        connect.Close();
        return check;
    }
}
