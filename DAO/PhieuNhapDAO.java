/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.PhieuNhapDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author quang
 */
public class PhieuNhapDAO {
    MyConnectUnit connect;
    
    //Lấy thông tin từ db
    public ArrayList<PhieuNhapDTO> docDB(String condition, String orderBy) throws Exception {
        // kết nối CSDL
        connect = new MyConnectUnit();
        
        ResultSet result = this.connect.Select("phieunhap", condition, orderBy);
        ArrayList<PhieuNhapDTO> pmuons = new ArrayList<>();
        while ( result.next() ) {
            PhieuNhapDTO pmuon = new PhieuNhapDTO();
            pmuon.setMa(result.getInt("Ma"));
            pmuon.setMaNhanVien(result.getInt("MaNhanVien"));
            pmuon.setTongTien(result.getInt("TongTien"));
            pmuon.setMaNhaCungCap(result.getInt("MaNhaCungCap"));
            pmuon.setNgayNhap(result.getString("NgayNhap"));
            pmuons.add(pmuon);
        }
        connect.Close();
        return pmuons;
    }
    
    public ArrayList<PhieuNhapDTO> docDB(String condition) throws Exception {
        return docDB(condition, null);
    }
    
    public ArrayList<PhieuNhapDTO> docDB() throws Exception {
        return docDB(null);
    }
    
    /*
     Tạo thêm 1 pmuon dựa theo đã có thông tin trước
     * @return true nếu thành công
     */
    public Boolean them(PhieuNhapDTO nv) throws Exception {
        connect = new MyConnectUnit();
        
        // tạo đối tượng truyền vào
        HashMap<String, Object> insertValues = new HashMap<>();
        insertValues.put("MaNhaCungCap", nv.getMaNhaCungCap());
        insertValues.put("MaNhanVien", nv.getMaNhanVien());
        insertValues.put("Ma", nv.getMa());
        insertValues.put("NgayNhap", nv.getNgayNhap());
        insertValues.put("TongTien", nv.getTongTien());
        
        Boolean check = connect.Insert("phieunhap", insertValues);        
        connect.Close();
        return check;
    }
    
    /** 
     * @param nv chuyền vào dữ liệu tài khoản để xóa
     * @return true nếu thành công
     * @throws java.lang.Exception
     */
    public Boolean xoa(PhieuNhapDTO nv) throws Exception {
        connect = new MyConnectUnit();
        String condition = "Ma = '"+nv.getMa()+"'";
        
        Boolean check = connect.Delete("phieunhap", condition);
        
        connect.Close();
        return check;
    }
    
    /**
     * @param nv truyền vào dữ liệu tài khoản mới
     * Sửa thông tin đăng nhập hoặc là cấp bậc của 1 tài khoản
     * @return true nếu thành công
     * @throws java.lang.Exception
     */
    public Boolean sua(PhieuNhapDTO nv) throws Exception {
        connect = new MyConnectUnit();
        
        // tạo đối tượng truyền vào
        HashMap<String, Object> insertValues = new HashMap<>();
        insertValues.put("MaNhaCungCap", nv.getMaNhaCungCap());
        insertValues.put("MaNhanVien", nv.getMaNhanVien());
        insertValues.put("NgayNhap", nv.getNgayNhap());
        insertValues.put("TongTien", nv.getTongTien());
        
        String condition = " ma = '"+nv.getMa()+"'";
        
        Boolean check = connect.Update("phieunhap", insertValues, condition);
        
        connect.Close();
        return check;
    }
}
