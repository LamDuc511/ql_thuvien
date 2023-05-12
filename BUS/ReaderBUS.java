/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import java.util.ArrayList;
import DAO.*;
import DTO.*;
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
 * @author ADMIN
 */
public class ReaderBUS {
  public  static ArrayList<ReaderDTO> dsdg;
   public ReaderBUS(){}
  public static void docDSDG(){
        ReaderDAO data=new ReaderDAO();
        if(dsdg==null)dsdg=new ArrayList<ReaderDTO>();
        dsdg=data.docDSDG();
    }
  public ArrayList<ReaderDTO> getdsdg(){
      if(dsdg==null)
          docDSDG();
      return ReaderBUS.dsdg;
  }
   public void them(ReaderDTO rd){
        ReaderDAO data = new ReaderDAO();
        data.them(rd);
        dsdg.add(rd);
    }
    public void xoa(String ma){
        ReaderDAO data = new ReaderDAO();
        data.xoa(ma);
        dsdg.remove(timkiemtheoMa(ma));
        
        
    }
    public void sua(ReaderDTO rd){
        ReaderDAO data = new ReaderDAO();
        data.sua(rd);
        
        
    }
   public boolean checkID(String ma){ 
        for(ReaderDTO s: dsdg){
            if(ma.equalsIgnoreCase(s.getid())){

                return false;
            }
        }
        return true;
    }
     public void khoitao(ReaderDTO rd,DefaultTableModel model,JTable tblReader){
    Vector header = new Vector();
        header.add("Mã độc giả");
        header.add("Họ độc giả");
        header.add("Tên độc giả");
        header.add("Ngày sinh");
        header.add("Giới tính");
        header.add("Số điện thoại");
   if(model.getRowCount()==0){
       model = new DefaultTableModel(header,0);
   }
   Vector row = new Vector();
        row.add(rd.id);
        row.add(rd.ho);
        row.add(rd.ten);
        row.add(rd.ngaysinh);
        row.add(rd.gioitinh);
        row.add(rd.sdt);
  if(checkID(rd.getid())){
      model.addRow(row);
      tblReader.setModel(model);
      dsdg.add(rd);
      them(rd);
      JOptionPane.showMessageDialog(null,"Thêm thành công.");
  }
  else{
      JOptionPane.showMessageDialog(null,"Mã bị trùng khớp");
  }
        
}
     public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }
  public  ReaderDTO timkiemtheoMa(String ma){
       // ReaderDTO rd = new ReaderDTO();
        for(ReaderDTO rd: dsdg){
            if(rd.getid().equalsIgnoreCase(ma)){
                return rd;
            }
            
        }
        return null;
                
    }
 public   ArrayList<ReaderDTO> timkiemtheoHo(String ho){
        ArrayList dstim = new ArrayList<ReaderDTO>();
        for(ReaderDTO rd: dsdg){
            if(rd.getho().equalsIgnoreCase(ho)){
                dstim.add(rd);
            }
        }
        return dstim;
    }
 public ArrayList<ReaderDTO> timkiemtheoTen(String ten){
     ArrayList dsten = new ArrayList<ReaderDTO>();
     for(ReaderDTO rd: dsdg){
         if(rd.getten().contains(ten)){
             dsten.add(rd);
         }
     }
     return dsten;
 }
    void thongketheoPhai(ArrayList<ReaderDTO> male, ArrayList<ReaderDTO> female){
       for(ReaderDTO s1: dsdg){
           if(s1.getgioitinh().equalsIgnoreCase("Nam")){
               male.add(s1);
           }
           else {female.add(s1);
           }
       }
    }
    public void Search(String ma,JComboBox cboxFilter,JLabel jLabel3,JTable tblRsearch){
            ReaderBUS bus = new ReaderBUS();
         Vector header = new Vector();
        header.add("Mã");
        header.add("Họ");
        header.add("Tên");
        header.add("Ngày sinh");
        header.add("Giới tính");
        header.add("Số điện thoại");
        DefaultTableModel dtmDocgia2 = new DefaultTableModel(header,0);
 
        switch(cboxFilter.getSelectedItem().toString()){
            case "Mã":
                tblRsearch.removeAll();
         jLabel3.setText("Tìm kiếm theo mã");
        ReaderDTO rd = bus.timkiemtheoMa(ma);
           if(rd == null){
               JOptionPane.showMessageDialog(null,"Khong tim thay doc gia.");
           } 
           else{
        Vector row1 = new Vector();
        row1.add(rd.getid());
        row1.add(rd.getho());
        row1.add(rd.getten());
        row1.add(rd.getngaysinh());
        row1.add(rd.getgioitinh());
        row1.add(rd.getsdt());
        dtmDocgia2.addRow(row1);
        tblRsearch.setModel(dtmDocgia2);
            }
            break;
            case "Họ":
                jLabel3.setText("Tìm kiếm theo họ");
                tblRsearch.removeAll();
                ArrayList<ReaderDTO> dstim = bus.timkiemtheoHo(ma) ;
            for(ReaderDTO newrd: dstim){
        Vector row2 = new Vector();
        row2.add(newrd.getid());
        row2.add(newrd.getho());
        row2.add(newrd.getten());
        row2.add(newrd.getngaysinh());
        row2.add(newrd.getgioitinh());
        row2.add(newrd.getsdt());
        dtmDocgia2.addRow(row2);
        tblRsearch.setModel(dtmDocgia2);
            }
      if(dstim==null)
          JOptionPane.showMessageDialog(null,"không tìm thấy độc giả.");
      
        break;
        case "Tên":
            jLabel3.setText("Tìm kiếm theo tên");
            tblRsearch.removeAll();
            ArrayList<ReaderDTO> dsten = bus.timkiemtheoTen(ma);
            for(ReaderDTO newrd:dsten){
                Vector row3=new Vector();
                row3.add(newrd.getid());
                row3.add(newrd.getho());
                row3.add(newrd.getten());
                row3.add(newrd.getngaysinh());
                row3.add(newrd.getgioitinh());
                row3.add(newrd.getsdt());
        dtmDocgia2.addRow(row3);
        tblRsearch.setModel(dtmDocgia2);
            }
        }
    }
}
