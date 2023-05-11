/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Report;

import DTO.*;
import BUS.*;
import DTO.*;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author quang
 */
public class XuatDanhSachExcel {
  
    
    public XuatDanhSachExcel(){
    }

    public void PhieuPhat() throws Exception{
        String[] header = {"Ma", "MaSach", "MaPhieuMuon", "MaViPham", "NgayViPham", "SoTienPhat"};
        String title = "PhieuPhat";
        PhieuPhatBUS bus = new PhieuPhatBUS();
        
        XuatPhieu(bus.getList_PM(),header, title);
    }
    public void PhieuMuon() throws Exception{
        String[] header = {"Ma", "MaNV", "MaDG", "NgayMuon", "NgayTra", "NgayTraThuc","TrangThai"};
        String title = "PhieuMuon";
        PhieuMuonBUS bus = new PhieuMuonBUS();
        
        XuatPhieu(bus.getList_PM(),header, title);
    }
    public void PhieuNhap() throws Exception{
        String[] header = {"Ma", "MaNhanVien", "MaNhaCungCap", "NgayNhap","TongTien"};
        String title = "PhieuNhap";
        PhieuNhapBUS bus = new PhieuNhapBUS();
        XuatPhieu(bus.getList_PM(),header, title);
    }
    public void CTPhieuMuon() throws Exception{
        String[] header = {"MaPM", "MaSach","SoLuong"};
        String title = "CTPhieuMuon";
        CTPhieuMuonBUS bus = new CTPhieuMuonBUS();
        if(bus.getList_PM()==null)
            bus.docDB();
        XuatPhieu(bus.getList_PM(),header, title);
    }
    
    private void XuatPhieu(ArrayList<?> danhSach, String[] header, String title) throws Exception{
    // Tạo một workbook mới
    Workbook workbook = new XSSFWorkbook();
        
    // Tạo một trang trong workbook
    Sheet sheet = workbook.createSheet("Danh sách " + title);

    // Tạo hàng tiêu đề
    Row headerRow = sheet.createRow(0);
    for (int i = 0; i < header.length; i++) {
        headerRow.createCell(i).setCellValue(header[i]);
    }

    // Lặp qua danh sách và thêm dữ liệu vào từng hàng
    int rowIndex = 1;
    for (Object item : danhSach) {
        Row row = sheet.createRow(rowIndex);
        // Thêm dữ liệu cho từng cột tương ứng
        for (int i = 0; i < header.length; i++) {
            // Gọi các phương thức getter tương ứng và set giá trị vào cột
            try {
                Method method = item.getClass().getMethod("get" + header[i]);
                Object value = method.invoke(item);
                if (value != null) {
                    row.createCell(i).setCellValue(value.toString());
                }
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        rowIndex++;
    }

    // Lưu workbook vào một tệp Excel
    try (FileOutputStream fileOut = new FileOutputStream("./src/excel/DanhSach" + title + ".xlsx")) {
        workbook.write(fileOut);
        JOptionPane.showMessageDialog(null, "Xuất Thành Công", "Oke", JOptionPane.OK_OPTION);
        File excelFile = new File("./src/excel/DanhSach" + title + ".xlsx");
        if (excelFile.exists()) {
            Desktop.getDesktop().open(excelFile);
        } else {
            System.out.println("Không tìm thấy file Excel.");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
   
    }
    
}
