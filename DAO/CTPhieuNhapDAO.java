/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.CTPhieuNhapDTO;
import com.itextpdf.xmp.XMPConst;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author quang
 */
public class CTPhieuNhapDAO {
    MyConnectUnit connect;
    
    //Lấy thông tin từ db
    public ArrayList<CTPhieuNhapDTO> docDB(String condition, String orderBy) throws Exception {
        // kết nối CSDL
        connect = new MyConnectUnit();
        
        ResultSet result = this.connect.Select("chitietphieunhap", condition, orderBy);
        ArrayList<CTPhieuNhapDTO> pmuons = new ArrayList<>();
        while ( result.next() ) {
            CTPhieuNhapDTO pmuon = new CTPhieuNhapDTO();
            pmuon.setMaPhieuNhap(result.getInt("MaPhieuNhap"));
            pmuon.setMaSach(result.getInt("MaSach"));
            pmuon.setSoLuong(result.getInt("SoLuong"));
            pmuon.setThanhTien(result.getInt("ThanhTien"));
            pmuon.setDonGia(result.getInt("DonGia"));
            pmuons.add(pmuon);
        }
        connect.Close();
        return pmuons;
    }
    
    public ArrayList<CTPhieuNhapDTO> docDB(String condition) throws Exception {
        return docDB(condition, null);
    }
    
    public ArrayList<CTPhieuNhapDTO> docDB() throws Exception {
        return docDB(null);
    }
    
    /*
     Tạo thêm 1 pmuon dựa theo đã có thông tin trước
     * @return true nếu thành công
     */
    public Boolean them(CTPhieuNhapDTO nv) throws Exception {
        connect = new MyConnectUnit();
        
        // tạo đối tượng truyền vào
        HashMap<String, Object> insertValues = new HashMap<>();
        insertValues.put("MaPhieuNhap", nv.getMaPhieuNhap());
        insertValues.put("MaSach", nv.getMaSach());
        insertValues.put("DonGia", nv.getDonGia());
        insertValues.put("SoLuong", nv.getSoLuong());
        insertValues.put("ThanhTien", nv.getThanhTien());
        
        Boolean check = connect.Insert("chitietphieunhap", insertValues);        
        connect.Close();
        return check;
    }
    
    /** 
     * @param nv chuyền vào dữ liệu tài khoản để xóa
     * @return true nếu thành công
     * @throws java.lang.Exception
     */
    public Boolean xoa(CTPhieuNhapDTO nv) throws Exception {
        connect = new MyConnectUnit();
        String condition = "MaPhieuNhap = '"+nv.getMaPhieuNhap()+"'AND MaSach ='"+nv.getMaSach()+"'";
        
        Boolean check = connect.Delete("chitietphieunhap", condition);
        
        connect.Close();
        return check;
    }
}
