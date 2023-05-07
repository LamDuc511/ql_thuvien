/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.PhieuPhatDAO;
import DTO.PhieuPhatDTO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quang
 */
public class PhieuPhatBUS {
    public ArrayList<PhieuPhatDTO> list_PM;
    /*
      Xử lý các lệnh trong SQL
     */
    private PhieuPhatDAO pmDAO;
    
    public PhieuPhatBUS() throws Exception {
        list_PM = new ArrayList<>();
        pmDAO = new PhieuPhatDAO();
        list_PM = pmDAO.docDB();
    }
    
    public void add(PhieuPhatDTO pn) {
        list_PM.add(pn);
    }
    
    public void deleteAll() {
        list_PM.removeAll(list_PM);
    }
    
    public void docDB() throws Exception {
        list_PM = new ArrayList<>();
        pmDAO = new PhieuPhatDAO();
        list_PM = pmDAO.docDB();
    }
    public void docDB(String MaPhieuMuon) throws Exception {
        list_PM = new ArrayList<>();
        pmDAO = new PhieuPhatDAO();String condition="MaPhieuMuon ='"+MaPhieuMuon+"'";
        list_PM = pmDAO.docDB();
    }
    public ArrayList<PhieuPhatDTO> getList_PM() {
        return list_PM;
    }

    public void setList_PM(ArrayList<PhieuPhatDTO> list_PM) {
        this.list_PM = list_PM;
    }

    
    public int getNumb() {
        return list_PM.size();
    }
    public int getDefaultMaPN() {
        try {
            docDB();
        } catch (Exception ex) {
            Logger.getLogger(PhieuPhatBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (list_PM.isEmpty()) return 0; 
        else {
            ArrayList<Integer> mangMa = new ArrayList<>();
            int iNumb = 0;
            for (PhieuPhatDTO a : list_PM) {
                    mangMa.add(a.getMa());                    
            }
            while(1==1){
                if(!mangMa.contains(iNumb))
                    return iNumb;
                iNumb++;
            }
            
        }
    } 
    
    public PhieuPhatDTO getInfor(int i){
        int iCount =0;
        for (PhieuPhatDTO hd : list_PM) {
            if (iCount == i)
                return hd;
            iCount++;
        }
        return null;
    }    
    /**
     * thêm 1 tài khoản vào danh sách và database
     * @return true nếu thành công
     */
    public Boolean them(PhieuPhatDTO tk) throws Exception{
        if ( pmDAO.them(tk) ) {
            list_PM.add(tk);
            return true;
        }
        return false;
    }
}
