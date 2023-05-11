/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.PhieuPhatDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author quang
 */
public class PhieuPhatDAO {
    MyConnectUnit connect;
    
    //Lấy thông tin từ db
    public ArrayList<PhieuPhatDTO> docDB(String condition, String orderBy) throws Exception {
        // kết nối CSDL
        connect = new MyConnectUnit();
        
        ResultSet result = this.connect.Select("phieuphat", condition, orderBy);
        ArrayList<PhieuPhatDTO> pmuons = new ArrayList<>();
        while ( result.next() ) {
            PhieuPhatDTO pmuon = new PhieuPhatDTO();
            pmuon.setMa(result.getInt("Ma"));
            pmuon.setMaSach(result.getInt("MaSach"));
            pmuon.setMaPhieuMuon(result.getInt("MaPhieuMuon"));
            pmuon.setMaViPham(result.getInt("MaViPham"));
            pmuon.setNgayViPham(result.getString("NgayViPham"));
            pmuon.setSoTienPhat(result.getString("SoTienPhat"));
            pmuons.add(pmuon);
        }
        connect.Close();
        return pmuons;
    }
    
    public ArrayList<PhieuPhatDTO> docDB(String condition) throws Exception {
        return docDB(condition, null);
    }
    
    public ArrayList<PhieuPhatDTO> docDB() throws Exception {
        return docDB(null);
    }
    public Boolean them(PhieuPhatDTO nv) throws Exception {
        connect = new MyConnectUnit();
        
        // tạo đối tượng truyền vào
        HashMap<String, Object> insertValues = new HashMap<>();
        insertValues.put("Ma", nv.getMa());
        insertValues.put("MaSach", nv.getMaSach());
        insertValues.put("MaPhieuMuon", nv.getMaPhieuMuon());
        insertValues.put("MaViPham", nv.getMaViPham());
        insertValues.put("NgayViPham", nv.getNgayViPham());
        insertValues.put("SoTienPhat", nv.getSoTienPhat());
        
        Boolean check = connect.Insert("phieuphat", insertValues);        
        connect.Close();
        return check;
    }
}
