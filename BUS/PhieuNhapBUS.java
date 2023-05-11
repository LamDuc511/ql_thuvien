/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.PhieuNhapDAO;
import DTO.PhieuNhapDTO;
import java.util.ArrayList;

/**
 *
 * @author quang
 */
public class PhieuNhapBUS {
    public ArrayList<PhieuNhapDTO> list_PM;
    /*
      Xử lý các lệnh trong SQL
     */
    private PhieuNhapDAO pmDAO;
    
    public PhieuNhapBUS() throws Exception {
        list_PM = new ArrayList<>();
        pmDAO = new PhieuNhapDAO();
        list_PM = pmDAO.docDB();
    }
    
    public void add(PhieuNhapDTO pn) {
        list_PM.add(pn);
    }
    
    public void deleteAll() {
        list_PM.removeAll(list_PM);
    }
    
    public void docDB() throws Exception {
        list_PM = new ArrayList<>();
        pmDAO = new PhieuNhapDAO();
        list_PM = pmDAO.docDB();
    }
    public ArrayList<PhieuNhapDTO> getList_PM() {
        return list_PM;
    }

    public void setList_PM(ArrayList<PhieuNhapDTO> list_PM) {
        this.list_PM = list_PM;
    }

    
    public int getNumb() {
        return list_PM.size();
    }
    
    public PhieuNhapDTO getInfor(int i){
        int iCount =0;
        for (PhieuNhapDTO hd : list_PM) {
            if (iCount == i)
                return hd;
            iCount++;
        }
        return null;
    }
    
    public int demSoChuSo(int nInput){
	if (nInput < 10) {
		return 1;
	}
	return 1 + demSoChuSo(nInput / 10);
    }
    
    public int getDefaultMaPN() {
        if (list_PM.isEmpty()) return 0; 
        else {
            ArrayList<Integer> mangMa = new ArrayList<Integer>();
            int iNumb = 0;
            for (PhieuNhapDTO a : list_PM) 
                    mangMa.add(a.getMa());
            while(true){
                if(!mangMa.contains(iNumb))
                    return iNumb;
                iNumb++;
            }
            
        }
    }    
    
    /**
     * thêm 1 tài khoản vào danh sách và database
     * @return true nếu thành công
     */
    public Boolean them(PhieuNhapDTO tk) throws Exception{
        if ( pmDAO.them(tk) ) {
            list_PM.add(tk);
            return true;
        }
        return false;
    }
    
    /**
     //xóa 1 tài khoản khỏi danh sách và database
     * @return true nếu thành công
     */
    public Boolean xoa(PhieuNhapDTO tk) throws Exception {
        if ( pmDAO.xoa(tk) ) {
            
            // duyệt từng phẩn tử
            for ( PhieuNhapDTO phieuMuon : list_PM ) {
                if (phieuMuon.getMa()==tk.getMa()){
                    list_PM.remove(phieuMuon);
                    return true;
                }
            }
        }
        
        return false;
    }
    
    /**
     * sửa thông tin của 1 tài khoản <br>
     * - Trừ thông tin đăng nhập của tài khoản đó
     * @return true nếu thực hiện thành công
     */
    public Boolean sua(PhieuNhapDTO tk) throws Exception {
        if ( pmDAO.sua(tk) ) {
            
            // duyệt từng phẩn tử
            for ( PhieuNhapDTO phieuMuon : list_PM ) {
                if (phieuMuon.getMa()==(tk.getMa())){
                    phieuMuon.setMaNhaCungCap(tk.getMaNhaCungCap());
                    phieuMuon.setMaNhanVien(tk.getMaNhanVien());
                    phieuMuon.setNgayNhap(tk.getNgayNhap());
                    phieuMuon.setTongTien(tk.getTongTien());
                    return true;
                }
            }
        }
      
        return false;
    }
}
