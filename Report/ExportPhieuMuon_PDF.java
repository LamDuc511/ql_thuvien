package Report;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import BUS.CTPhieuMuonBUS;
import BUS.NhanVienBUS;
import BUS.sachBUS;
import BUS.ReaderBUS;

import DTO.NhanVienDTO;
import DTO.CTPhieuMuonDTO;
import DTO.PhieuMuonDTO;
import DTO.ReaderDTO;
import DTO.sachDTO;
public class ExportPhieuMuon_PDF  {
    
    private CTPhieuMuonBUS busCTPM;
    private ReaderBUS busDG;
    private NhanVienBUS busNV;
    private sachBUS busSach;
    
    private PhieuMuonDTO pm;
    
    public ExportPhieuMuon_PDF()throws Exception {}
    public ExportPhieuMuon_PDF(PhieuMuonDTO pm)throws Exception {
        this.pm=pm;
    }

    public void exportPhieuMuon () throws Exception
    {
        //đọc danh sach phieu muon
        busCTPM=new CTPhieuMuonBUS(Integer.toString(pm.getMa()));
        ArrayList<CTPhieuMuonDTO> listCT=busCTPM.getList_PM();
        
        //lấy thông tin nhân viên thực hiện
        busNV=new NhanVienBUS();
        NhanVienDTO nhanvien =new NhanVienDTO();
        
        for (NhanVienDTO nv : busNV.getList_PM()){
            if(nv.getMa()==pm.getMaNV())
            {
                nhanvien=nv;
            }
        }      
        
        //lấy thông tin người mượn
        busDG=new ReaderBUS();
        ReaderDTO docgia =new ReaderDTO();
        for (ReaderDTO dg : busDG.getdsdg()){
            if(Integer.parseInt(dg.getid())==pm.getMaNV())
            {
                docgia=dg;
            }
        }
        
        //lấy thông tin sách 
        busSach=new sachBUS();
        sachDTO sach =new sachDTO();
        //tạo đối tượng document
        Document document;
        document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream("./src/pdf/"+pm.getMa() +  "-" +docgia.getten()+ ".pdf"));
            document.open();
            Font font = FontFactory.getFont("./src/font/arial-unicode-ms.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font fontTitle = FontFactory.getFont("./src/font/arial-unicode-ms.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED,20);
            Paragraph txtHoaDonNhapHang = new Paragraph("Chi Tiết Phiếu Mượn ",fontTitle);
            txtHoaDonNhapHang.setAlignment(Element.ALIGN_CENTER); // căn giữa
    
            Paragraph txtMaHDN = new Paragraph("Mã hóa đơn : " + pm.getMa(),font);
            txtMaHDN.setAlignment(Element.ALIGN_CENTER); // căn giữa

        //hiện thông tin nhân viên
            //Tên nhân viên
            Paragraph txtTenNV = new Paragraph("Tên nhân viên : " +nhanvien.getHo()+" "+nhanvien.getTen() ,font);
            txtTenNV.setIndentationLeft(50f);
            //Ma và SDT nhân viên
            Paragraph para = new Paragraph();
            para.setFont(font);
            para.add("Mã nhân viên: " + nhanvien.getMa());
            para.add("                                    " );
            para.add("Số điện thoại nhân viên: 0" +  Integer.toString(nhanvien.getSoDienThoai()));
            para.setIndentationLeft(50f);
            
        //ngày mượn ngày trả
            Paragraph day = new Paragraph("Ngày nhập: " + pm.getNgayMuon()+"                                  Ngày Trả: "+pm.getNgayTra(),font);
            day.setIndentationLeft(50f);
           
        //thông tin người mượn
            //tên người mượn
            Paragraph txtTenDG = new Paragraph("Tên Người mượn: " +docgia.getho()+" "+docgia.getten(),font);
            txtTenDG.setIndentationLeft(50f);
            //ma va so dien thoai người mượn
            Paragraph para1 = new Paragraph();
            para1.setFont(font);
            para1.add("Mã người mượn: " +docgia.getid());
            para1.add("                                    " );
            para1.add("Số điện thoại người mượn: " +  docgia.getsdt());
            para1.setIndentationLeft(50f);
        
            float[] columnWidths = { 1,1,2,1};
            PdfPTable t = new PdfPTable(columnWidths);
           
            // t.TotalWidth = 216f; // đặt chiều rộng bảng là 216 điểm
            t.setSpacingBefore(25);
            t.setSpacingAfter(25);
            
            //thêm cột đầu bảng
            PdfPCell stt = new PdfPCell(new Phrase("Số thứ tự",font));
            t.addCell(stt);
            
            PdfPCell tenSP = new PdfPCell(new Phrase("Mã phiếu mượn",font));
            t.addCell(tenSP);
            
            PdfPCell masach = new PdfPCell(new Phrase("Tên sách",font));
            t.addCell(masach);

            PdfPCell soLuong = new PdfPCell(new Phrase("Số lượng",font));
            t.addCell(soLuong);
               
            PdfPCell tensach;
            for (int i = 0; i<listCT.size(); i++)
            {
                t.addCell(Integer.toString(i+1));
                t.addCell(Integer.toString(listCT.get(i).getMaPM()));
                for (sachDTO dg : busSach.getListSach()){
                    if( listCT.get(i).getMaSach() == dg.getMa() )
                    {
                        tensach = new PdfPCell(new Phrase(dg.getTen(),font));
                        t.addCell(tensach);
                        break;
                    }
                }
                
                t.addCell(Integer.toString(listCT.get(i).getSoLuong()));
    
            }
            Paragraph paraChuKy = new Paragraph();
            paraChuKy.setFont(font);
            paraChuKy.add("        Nhân Viên ");
            paraChuKy.add("                                                                   " );
            paraChuKy.add("Người Mượn                    ");
           
            paraChuKy.add("  (Ký,ghi rõ họ tên)");
            paraChuKy.add("                                                            " );
            paraChuKy.add("(Ký,ghi rõ họ tên)");   
            paraChuKy.setIndentationLeft(50f);
            
            Paragraph lineBreak = new Paragraph();
            lineBreak.add(" ");
            
            Paragraph hoten = new Paragraph();
            hoten.setFont(font);
            hoten.add("      "+nhanvien.getHo()+" "+nhanvien.getTen());
            hoten.add("                                                                   ");
            hoten.add(docgia.getho()+" "+docgia.getten() );
            hoten.setIndentationLeft(50f);

            

            document.add(txtHoaDonNhapHang);
            document.add(txtMaHDN);
            document.add(txtTenNV);
            document.add(para);
            document.add(txtTenDG);
            document.add(para1);
            document.add(day);
            document.add(t); 
            document.add(paraChuKy); 
            document.add(lineBreak);
            document.add(lineBreak);
            document.add(lineBreak);
            document.add(hoten);

            document.close();
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

}
