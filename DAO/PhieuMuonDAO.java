/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.PhieuMuonDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author quang
 */
public class PhieuMuonDAO {
    MyConnectUnit connect;
    
    //Lấy thông tin từ db
    public ArrayList<PhieuMuonDTO> docDB(String condition, String orderBy) throws Exception {
        // kết nối CSDL
        connect = new MyConnectUnit();
        
        ResultSet result = this.connect.Select("phieumuon", condition, orderBy);
        ArrayList<PhieuMuonDTO> pmuons = new ArrayList<>();
        while ( result.next() ) {
            PhieuMuonDTO pmuon = new PhieuMuonDTO();
            pmuon.setMa(result.getInt("Ma"));
            pmuon.setMaDG(result.getInt("MaDocGia"));
            pmuon.setMaNV(result.getInt("MaNhanVien"));
            pmuon.setNgayMuon(result.getString("NgayMuon"));
            pmuon.setNgayTra(result.getString("NgayTra"));
            pmuon.setNgayTraThuc(result.getString("NgayTraThuc"));
            pmuon.setTrangThai((int) result.getDouble("TrangThai"));
            pmuons.add(pmuon);
        }
        connect.Close();
        return pmuons;
    }
    
    public ArrayList<PhieuMuonDTO> docDB(String condition) throws Exception {
        return docDB(condition, null);
    }
    
    public ArrayList<PhieuMuonDTO> docDB() throws Exception {
        return docDB(null);
    }
    
    /*
     Tạo thêm 1 pmuon dựa theo đã có thông tin trước
     * @return true nếu thành công
     */
    public Boolean them(PhieuMuonDTO nv) throws Exception {
        connect = new MyConnectUnit();
        
        // tạo đối tượng truyền vào
        HashMap<String, Object> insertValues = new HashMap<>();
        insertValues.put("MaDocGia", nv.getMaDG());
        insertValues.put("MaNhanVien", nv.getMaNV());
        insertValues.put("Ma", nv.getMa());
        insertValues.put("NgayMuon", nv.getNgayMuon());
        insertValues.put("NgayTra", nv.getNgayTra());
        insertValues.put("TrangThai", nv.getTrangThai());
        
        Boolean check = connect.Insert("phieumuon", insertValues);        
        connect.Close();
        return check;
    }
    
    /** 
     * @param nv chuyền vào dữ liệu tài khoản để xóa
     * @return true nếu thành công
     * @throws java.lang.Exception
     */
    public Boolean xoa(PhieuMuonDTO nv) throws Exception {
        connect = new MyConnectUnit();
        String condition = "Ma = '"+nv.getMa()+"'";
        
        Boolean check = connect.Delete("phieumuon", condition);
        
        connect.Close();
        return check;
    }
    
    /**
     * @param nv truyền vào dữ liệu tài khoản mới
     * Sửa thông tin đăng nhập hoặc là cấp bậc của 1 tài khoản
     * @return true nếu thành công
     * @throws java.lang.Exception
     */
    public Boolean sua(PhieuMuonDTO nv) throws Exception {
        connect = new MyConnectUnit();
        
        // tạo đối tượng truyền vào
        HashMap<String, Object> insertValues = new HashMap<>();
        insertValues.put("MaDocGia", nv.getMaDG());
        insertValues.put("MaNhanVien", nv.getMaNV());
        insertValues.put("NgayMuon", nv.getNgayMuon());
        insertValues.put("NgayTra", nv.getNgayTra());
        insertValues.put("NgayTraThuc", nv.getNgayTraThuc());
        insertValues.put("TrangThai", nv.getTrangThai());
        
        String condition = " ma = '"+nv.getMa()+"'";
        
        Boolean check = connect.Update("phieumuon", insertValues, condition);
        
        connect.Close();
        return check;
    }
}
