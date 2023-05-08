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

        public ArrayList<PhieuPhatDTO> timKiem_MaPN(String strMaPN) {
        ArrayList<PhieuPhatDTO> arr = new ArrayList<>();
        for (PhieuPhatDTO hoadon : list_PM) {
            if ( hoadon.getSoTienPhat().indexOf(strMaPN) != -1 ) {
                System.out.println("Tim thay " + hoadon.getMa() );
                arr.add(hoadon);
            }
        }
        return arr;
    }
    
//    public ArrayList<PhieuPhatDTO> timKiem_MaNV(String strMaNV) {
//        ArrayList<PhieuPhatDTO> arr = new ArrayList<>();
//        for (PhieuPhatDTO hoadon : list_PM) {
//            if ( hoadon.getMaNV().indexOf(strMaNV) != -1 ) {
//                System.out.println("Tim thay " + hoadon.getStrMaPN() );
//                arr.add(hoadon);
//            }
//        }
//        
//        return arr;
//    }
    
//    public ArrayList<PhieuPhatDTO> timKiem_MaNCC(String strMaNCC) {
//        ArrayList<PhieuPhatDTO> arr = new ArrayList<>();
//        for (PhieuPhatDTO hoadon : list_PM) {
//            if ( hoadon.getStrMaNCC().indexOf(strMaNCC) != -1 ) {
//                System.out.println("Tim thay " + hoadon.getStrMaPN() );
//                arr.add(hoadon);
//            }
//        }
//        
//        return arr;
//    }
    
    public ArrayList<PhieuPhatDTO> timKiem_TongTien(String strTT) {
        ArrayList<PhieuPhatDTO> arr = new ArrayList<>();
        for (PhieuPhatDTO hoadon : list_PM) {
            if ( String.valueOf(hoadon.getSoTienPhat()).indexOf(strTT) != -1 ) {
                System.out.println("Tim thay " + hoadon.getMa() );
                arr.add(hoadon);
            }
        }
        
        return arr;
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
