/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.tacGiaDAO;
import DTO.tacGiaDTO;
import DTO.tacGiaDTO;
import GUI.JPnAuthor;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DO THE TUNG
 */
public class tacgiaBUS {
    static ArrayList<tacGiaDTO> tgList = new ArrayList<>();
    static tacGiaDAO tgdao = new tacGiaDAO();

    public tacgiaBUS() {
    }

    ;
   public static void ReadData_BUS() {
       tacGiaDAO data = new tacGiaDAO();
        if (tgList == null) {
            tgList = new ArrayList<tacGiaDTO>();
        }
        tgList = data.ReadData();

        tgList.addAll(data.ReadData());


    }
  public static void docDSTG(){
        tacGiaDAO data=new tacGiaDAO();
        if(tgList==null)tgList=new ArrayList<tacGiaDTO>();
        tgList=data.ReadData();
    }
   public static ArrayList<tacGiaDTO> getdstg(){
      if(tgList==null){
          ReadData_BUS();
      }
      return tacgiaBUS.tgList;
  }
  public  void insert_BUS(tacGiaDTO tg) {
        tacGiaDAO data = new tacGiaDAO();
        data.them_dao(tg);
        tgList.add(tg);

    }

    public void xoa(int Ma) {
      tacGiaDAO data = new tacGiaDAO();
        data.xoa(Ma);
        tgList.remove(findWithId(Ma));

    }

  public  void sua(tacGiaDTO tgdto) {
        tacGiaDAO data = new tacGiaDAO();
        data.sua(tgdto);
    }

  public  tacGiaDTO findWithId(int Ma) {
        for (tacGiaDTO x : tgList) {
            if (x.getMa() == Ma) {
                return x;
            }

        }
        return null;

    }

  public  boolean checkMaTacGia(int Ma,int soDienThoai) {
//        for ( nhaXuatBanDTO nxbdto :nxbList)
//        {
//            if (Ma == nxbdto.getMaNhaSanXuat())
//            {
//                return false ;
//            }
//        }
//        return true;

        return tgdao.checkExist(Ma, soDienThoai);

    }

//    private ArrayList <nhaXuatBanDTO> TimTen(String ten)
//    {
//        ArrayList<nhaXuatBanDTO>  ds = new ArratList<>();
//        for( nhaXuatBanDTO list_filter : nxbList)
//            
//    }
//    
     public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }
    public ArrayList< tacGiaDTO> TimMaTacGia(int Ma) {
        ArrayList<tacGiaDTO> ds = new ArrayList<>();
        
        tgList = tgdao.ReadData();
        for (tacGiaDTO list_filter : tgList) {
            if (list_filter.getMa()==Ma) 
            {
                ds.add(list_filter);
            }

        }
        return ds;
    }

    public DefaultTableModel returnTable(ArrayList<tacGiaDTO> ds) {
        Vector header = new Vector();
        header.add(" Ma");
        header.add(" Ten");
        header.add("Ho ");
        header.add(" Gioi Tinh");
        header.add(" so Dien Thoai ");
        
        DefaultTableModel tablemodel2 = new DefaultTableModel(header, 0);
        if (tablemodel2.getRowCount() == 0) {

            tablemodel2 = new DefaultTableModel(header, 0);
        }
        for (int i = 0; i < ds.size(); i++) {
            Vector row = new Vector();
            row.add(ds.get(i).getMa());
            row.add(ds.get(i).getTen()
            );
            row.add(ds.get(i).getHo());
            row.add(ds.get(i).getGioiTinh());
            row.add(ds.get(i).getSoDienThoai());
            tablemodel2.addRow(row);
        }
        return tablemodel2;

    }
     public void Search(String ma,JComboBox cboxFilter,JLabel jLabel3,JTable tblRsearch){
            tacgiaBUS bus = new tacgiaBUS();
         Vector header = new Vector();
        header.add("Mã");
        header.add("Họ");
        header.add("Tên");
        header.add("Lương");
        header.add("Địa chỉ");
        header.add("Ngày sinh");
        header.add("Giới tính");
        header.add("Số điện thoại");
        DefaultTableModel dtmtacgia = new DefaultTableModel(header,0);
 
        switch(cboxFilter.getSelectedItem().toString()){
            case "Mã":
                tblRsearch.removeAll();
         jLabel3.setText("Tìm kiếm theo mã");
        tacGiaDTO nv = bus.timkiemtheoMa(Integer.parseInt(ma));
           if(nv == null){
               JOptionPane.showMessageDialog(null,"Khong tim thay nhan vien.");
           } 
           else{
        Vector row1 = new Vector();
        row1.add(nv.getMa());
        row1.add(nv.getHo());
        row1.add(nv.getTen());
        row1.add(nv.getGioiTinh());
        row1.add(nv.getSoDienThoai());
        dtmtacgia.addRow(row1);
        tblRsearch.setModel(dtmtacgia);
            }
            break;
            case "Họ":
                jLabel3.setText("Tìm kiếm theo họ");
                tblRsearch.removeAll();
                ArrayList<tacGiaDTO> dstim = timkiemtheoHo(ma) ;
            for(tacGiaDTO newnv: dstim){
        Vector row2 = new Vector();
        row2.add(newnv.getMa());
        row2.add(newnv.getHo());
        row2.add(newnv.getTen());
        row2.add(newnv.getGioiTinh());
        row2.add(newnv.getSoDienThoai());
        dtmtacgia.addRow(row2);
        tblRsearch.setModel(dtmtacgia);
            }
      if(dstim==null)
          JOptionPane.showMessageDialog(null,"không tìm thấy tác giả.");
      
        break;
        case "Tên":
            jLabel3.setText("Tìm kiếm theo tên");
            tblRsearch.removeAll();
            ArrayList<tacGiaDTO> dsten = timkiemtheoTen(ma);
            for(tacGiaDTO newnv:dsten){
                Vector row3=new Vector();
                row3.add(newnv.getMa());
                row3.add(newnv.getHo());
                row3.add(newnv.getTen());
                row3.add(newnv.getGioiTinh());
                row3.add(newnv.getSoDienThoai());
        dtmtacgia.addRow(row3);
        tblRsearch.setModel(dtmtacgia);
            }
        }
    }
       public  tacGiaDTO timkiemtheoMa(int ma){
       // tacGiaDTO nv = new tacGiaDTO();
        for(tacGiaDTO nv: tgList){
            if(nv.getMa() == ma){
                return nv;
            }
            
        }
        return null;
                
    }
 public   ArrayList<tacGiaDTO> timkiemtheoHo(String ho){
        ArrayList dstim = new ArrayList<tacGiaDTO>();
        for(tacGiaDTO nv: tgList){
            if(nv.getHo().equalsIgnoreCase(ho)){
                dstim.add(nv);
            }
        }
        return dstim;
    }
 public ArrayList<tacGiaDTO> timkiemtheoTen(String ten){
     ArrayList dsten = new ArrayList<tacGiaDTO>();
     for(tacGiaDTO nv: tgList){
         if(nv.getTen().contains(ten)){
             dsten.add(nv);
         }
     }
     return dsten;
 }
}
