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
public class EmployeeBUS {
  public  static ArrayList<EmployeeDTO> dsnv;
   public EmployeeBUS(){}
  public static void docDSNV(){
        EmployeeDAO data=new EmployeeDAO();
        if(dsnv==null)dsnv=new ArrayList<EmployeeDTO>();
        dsnv=data.docDSNV();
    }
  public static ArrayList<EmployeeDTO> getdsnv(){
      if(dsnv==null){
          docDSNV();
      }
      return EmployeeBUS.dsnv;
  }
   public void them(EmployeeDTO nv){
        EmployeeDAO data = new EmployeeDAO();
        data.them(nv);
        dsnv.add(nv);
    }
    public void xoa(String ma){
        EmployeeDAO data = new EmployeeDAO();
        data.xoa(ma);
        dsnv.remove(timkiemtheoMa(ma));
        
        
    }
    public void sua(EmployeeDTO nv){
        EmployeeDAO data = new EmployeeDAO();
        data.sua(nv);
        
        
    }
   public boolean checkID(String ma){ 
        for(EmployeeDTO s: dsnv){
            if(ma.equalsIgnoreCase(s.getid())){

                return false;
            }
        }
        return true;
    }
     public void khoitao(EmployeeDTO nv,DefaultTableModel model,JTable tblNhanvien){
    Vector header = new Vector();
        header.add("Mã ");
        header.add("Họ nhân viên");
        header.add("Tên nhân viên");
        header.add("Lương");
        header.add("Địa chỉ");
        header.add("Ngày sinh");
        header.add("Giới tính");
        header.add("Số điện thoại");
   if(model.getRowCount()==0){
       model = new DefaultTableModel(header,0);
   }
   Vector row = new Vector();
        row.add(nv.id);
        row.add(nv.ho);
        row.add(nv.ten);
        row.add(nv.luong);
        row.add(nv.diachi);
        row.add(nv.ngaysinh);
        row.add(nv.gioitinh);
        row.add(nv.sdt);
  if(checkID(nv.getid())){
      model.addRow(row);
      tblNhanvien.setModel(model);
      dsnv.add(nv);
      them(nv);
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
  public  EmployeeDTO timkiemtheoMa(String ma){
       // EmployeeDTO nv = new EmployeeDTO();
        for(EmployeeDTO nv: dsnv){
            if(nv.getid().equalsIgnoreCase(ma)){
                return nv;
            }
            
        }
        return null;
                
    }
 public   ArrayList<EmployeeDTO> timkiemtheoHo(String ho){
        ArrayList dstim = new ArrayList<EmployeeDTO>();
        for(EmployeeDTO nv: dsnv){
            if(nv.getho().equalsIgnoreCase(ho)){
                dstim.add(nv);
            }
        }
        return dstim;
    }
 public ArrayList<EmployeeDTO> timkiemtheoTen(String ten){
     ArrayList dsten = new ArrayList<EmployeeDTO>();
     for(EmployeeDTO nv: dsnv){
         if(nv.getten().contains(ten)){
             dsten.add(nv);
         }
     }
     return dsten;
 }
    void thongketheoPhai(ArrayList<EmployeeDTO> male, ArrayList<EmployeeDTO> female){
       for(EmployeeDTO s1: dsnv){
           if(s1.getgioitinh().equalsIgnoreCase("Nam")){
               male.add(s1);
           }
           else {female.add(s1);
           }
       }
    }
    public void Search(String ma,JComboBox cboxFilter,JLabel jLabel3,JTable tblRsearch){
            EmployeeBUS bus = new EmployeeBUS();
         Vector header = new Vector();
        header.add("Mã");
        header.add("Họ");
        header.add("Tên");
        header.add("Lương");
        header.add("Địa chỉ");
        header.add("Ngày sinh");
        header.add("Giới tính");
        header.add("Số điện thoại");
        DefaultTableModel dtmNhanvien2 = new DefaultTableModel(header,0);
 
        switch(cboxFilter.getSelectedItem().toString()){
            case "Mã":
                tblRsearch.removeAll();
         jLabel3.setText("Tìm kiếm theo mã");
        EmployeeDTO nv = bus.timkiemtheoMa(ma);
           if(nv == null){
               JOptionPane.showMessageDialog(null,"Khong tim thay nhan vien.");
           } 
           else{
        Vector row1 = new Vector();
        row1.add(nv.getid());
        row1.add(nv.getho());
        row1.add(nv.getten());
        row1.add(nv.getluong());
        row1.add(nv.getDiachi());
        row1.add(nv.getngaysinh());
        row1.add(nv.getgioitinh());
        row1.add(nv.getsdt());
        dtmNhanvien2.addRow(row1);
        tblRsearch.setModel(dtmNhanvien2);
            }
            break;
            case "Họ":
                jLabel3.setText("Tìm kiếm theo họ");
                tblRsearch.removeAll();
                ArrayList<EmployeeDTO> dstim = timkiemtheoHo(ma) ;
            for(EmployeeDTO newnv: dstim){
        Vector row2 = new Vector();
        row2.add(newnv.getid());
        row2.add(newnv.getho());
        row2.add(newnv.getten());
        row2.add(newnv.getluong());
        row2.add(newnv.getDiachi());
        row2.add(newnv.getngaysinh());
        row2.add(newnv.getgioitinh());
        row2.add(newnv.getsdt());
        dtmNhanvien2.addRow(row2);
        tblRsearch.setModel(dtmNhanvien2);
            }
      if(dstim==null)
          JOptionPane.showMessageDialog(null,"không tìm thấy nhân viên.");
      
        break;
        case "Tên":
            jLabel3.setText("Tìm kiếm theo tên");
            tblRsearch.removeAll();
            ArrayList<EmployeeDTO> dsten = timkiemtheoTen(ma);
            for(EmployeeDTO newnv:dsten){
                Vector row3=new Vector();
                row3.add(newnv.getid());
                row3.add(newnv.getho());
                row3.add(newnv.getten());
                row3.add(newnv.getluong());
                row3.add(newnv.getDiachi());
                row3.add(newnv.getngaysinh());
                row3.add(newnv.getgioitinh());
                row3.add(newnv.getsdt());
        dtmNhanvien2.addRow(row3);
        tblRsearch.setModel(dtmNhanvien2);
            }
        }
    }
}
