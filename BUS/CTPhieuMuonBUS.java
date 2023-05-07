/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.CTPhieuMuonDAO;
import DTO.CTPhieuMuonDTO;
import java.util.ArrayList;

/**
 *
 * @author quang
 */
public class CTPhieuMuonBUS {
    public ArrayList<CTPhieuMuonDTO> list_PM;
    /*
      Xử lý các lệnh trong SQL
     */
    private CTPhieuMuonDAO pmDAO;
    
    public CTPhieuMuonBUS() throws Exception {
//        list_PM = new ArrayList<>();
//        pmDAO = new CTPhieuMuonDAO();
//        list_PM = pmDAO.docDB();
    }
    
    public void add(CTPhieuMuonDTO pn) {
        list_PM.add(pn);
    }
    
    public void deleteAll() {
        list_PM.removeAll(list_PM);
    }
    
    public void docDB() throws Exception {
        list_PM = new ArrayList<>();
        pmDAO = new CTPhieuMuonDAO();
        list_PM = pmDAO.docDB();
    }
    public void docDB(String MaPM) throws Exception {
        list_PM = new ArrayList<>();
        pmDAO = new CTPhieuMuonDAO();
        String Condition ="MaPhieuMuon ='"+MaPM+"'";
        list_PM = pmDAO.docDB(Condition);
        System.out.println("docdb");
    }
    public ArrayList<CTPhieuMuonDTO> getList_PM() {
        return list_PM;
    }

    public void setList_PM(ArrayList<CTPhieuMuonDTO> list_PM) {
        this.list_PM = list_PM;
    }

    
    public int getNumb() {
        return list_PM.size();
    }
    
    public CTPhieuMuonDTO getInfor(int i){
        int iCount =0;
        for (CTPhieuMuonDTO hd : list_PM) {
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
    
    
    
    /**
     * thêm 1 tài khoản vào danh sách và database
     * @return true nếu thành công
     */
    public Boolean them(CTPhieuMuonDTO tk) throws Exception{
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
    public Boolean xoa(CTPhieuMuonDTO tk) throws Exception {
        if ( pmDAO.xoa(tk) ) {
            
            // duyệt từng phẩn tử
            for ( CTPhieuMuonDTO phieuMuon : list_PM ) {
                if ((phieuMuon.getMaSach()==tk.getMaSach())&&(phieuMuon.getMaPM()==tk.getMaPM())){
                    list_PM.remove(phieuMuon);
                return true;
                }
            }
        }
        
        return false;
    }

}
