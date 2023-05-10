/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import static BUS.tacgiaBUS.tgList;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import DTO.*;
import DAO.*;
import DTO.*;

/**
 *
 * @author DO THE TUNG
 */
public class sachBUS {
    tacGiaDAO dataDAO = new tacGiaDAO();
      ArrayList<tacGiaDTO>  tgList = dataDAO.ReadData();
    nhaXuatBanDAO nxbDAO = new nhaXuatBanDAO();
      ArrayList<nhaXuatBanDTO> nxblist = nxbDAO.ReadData();
    private ArrayList<sachDTO> listSach = null;
    private sachDAO sachDAO = new sachDAO();

    public sachBUS() {
        doclistSach();

    }

    public void showMess(String s) {
        JOptionPane.showMessageDialog(null, s);
    }

    public void doclistSach() {
        listSach = sachDAO.getListSach();

    }

    public ArrayList<sachDTO> getListSach() {
        if (listSach == null) {
            doclistSach();
        }
        return listSach;
    }

    public sachDTO getSach(String ma) {
        if (!ma.trim().equals("")) {
            try {
                int maSach = Integer.parseInt(ma);
                for (sachDTO sach : listSach) {
                    if (sach.getMa() == maSach) {
                        return sach;

                    }
                }
            } catch (Exception e) {
            }

        }
        return null;

    }

    public ArrayList<sachDTO> getSachtheoMaTacGia(String ma) {
        if (!ma.trim().equals("")) {
            ArrayList<sachDTO> dsSach = new ArrayList<>();
            try {
                int maTacGia = Integer.parseInt(ma);
                for (sachDTO sach : listSach) {
                    if (sach.getMaTacGia() == maTacGia) {
                        dsSach.add(sach);
                    }
                }
                return dsSach;

            } catch (Exception e) {
            }
        }
        return null;

    }

    public String getAnh(String ma) {
        int maSach = Integer.parseInt(ma);
        return sachDAO.getAnh(maSach);

    }

    public void capNhatScoLuongSP(int ma, int soLuongMat) {
        sachDAO.updateSoLuong(ma, soLuongMat);
    }

    public boolean themSanPham(String Ma, String Ten, String MaTacGia, String MaTheLoai, String MaNhaSanXuat, String NamSanXuat, String soLuong, String Anh, String Gia) {

        if (Ma.trim().equals("")) {
            showMess("khong duoc de trong ma");
            return false;
        }
        if (Ten.trim().equals("")) {
            showMess("khong duoc de trog ten");
            return false;

        }
        try {
            String[] MaTacGiaTmp = MaTacGia.split("-");
            int maTacGia = Integer.parseInt(MaTacGiaTmp[0]);
            String[] MaNhaSanXuatTMP = MaNhaSanXuat.split("-");
            int maNhaSanXuat = Integer.parseInt(MaNhaSanXuatTMP[0]);
            int ma = Integer.parseInt(Ma);

            int maTheLoai = Integer.parseInt(MaTheLoai);
            int namSanXuat = Integer.parseInt(NamSanXuat);
            int soluong = Integer.parseInt(soLuong);
            int gia = Integer.parseInt(Gia);

            sachDTO sach = new sachDTO();
            sach.setMa(ma);
            sach.setTen(Ten);
            sach.setMaNhaSanXuat(maNhaSanXuat);
            sach.setMaTacGia(maTacGia);
            sach.setMaTheLoai(maTheLoai);
            sach.setNamSanXuat(namSanXuat);
            sach.setAnh(Anh);
            sach.setGia(gia);

            sach.setSoLuong(soluong);

            if (sachDAO.themSanPham(sach)) {
                showMess("them thanh cong ");
                return true;

            } else {
                showMess("them that bai");
                return false;

            }
        } catch (Exception e) {
        }
        return false;

    }

    public boolean xoaSanPham(String ma) {
        if (ma.trim().equals("")) {
            showMess("chua chon san pham de xoa ");
            return false;

        }
        int maSach = Integer.parseInt(ma);
        if (sachDAO.xoaSanch(maSach)) {
            showMess(" xoa thanh cong");
            return true;

        }
        showMess(" xoa that bai");
        return false;
    }

    public boolean suaSanPham(String Ma, String Ten, String MaTacGia, String MaTheLoai, String MaNhaSanXuat, String NamSanXuat, String soLuong, String Anh, String Gia) {
        try {
            if (Ma.trim().equals("")) {
                showMess(" chua chon san pham de sua");
                return false;

            }
            int maSach = Integer.parseInt(Ma);
            String[] MaTacGiaTmp = MaTacGia.split("-");
            int maTacGia = Integer.parseInt(MaTacGiaTmp[0]);

            String[] maNhaSanXuat = MaNhaSanXuat.split("-");
            int maNSX = Integer.parseInt(maNhaSanXuat[0]);

            int maLoai = Integer.parseInt(Ma);
            int namsanxuat = Integer.parseInt(NamSanXuat);
            int soluong = Integer.parseInt(soLuong);
            int gia = Integer.parseInt(Gia);
            if (maTacGia == 0) {
                showMess("vui long chon loai san pham");
                return false;

            }
            if (Ten.trim().equals("")) {
                showMess(" ten sach khong duoc de trong");
                return false;
            }
            sachDTO sach = new sachDTO();
            sach.setMa(maSach);
            sach.setTen(Ten);
            sach.setMaTacGia(maTacGia);
            sach.setMaNhaSanXuat(maNSX);
            sach.setMaTheLoai(maLoai);
            sach.setNamSanXuat(namsanxuat);
            sach.setSoLuong(soluong);
            sach.setAnh(Anh);
            sach.setGia(gia);

            if (sachDAO.suaSach(sach)) {
                showMess(" sua thanh cong ");
                return true;
            } else {
                showMess(" sua that bai");
                return false;
            }

        } catch (Exception e) {
        }

        return false;

    }

    public String getTenSP(int maSach) {
        for (sachDTO sach : listSach) {
            if (sach.getMa() == maSach) {
                return sach.getTen();
            }
        }
        return "";
    }
    public String getTenTG(int matg){
        for( tacGiaDTO tg : tgList ){
            if(tg.getMa() == matg)
           return tg.getHo()+" " +tg.getTen();
        }
        return "";
    }
    public String getTenNXB(int manxb){
        for(nhaXuatBanDTO nxb: nxblist){
            if(nxb.getMaNhaSanXuat() == manxb)
                return nxb.getTenNhaXuatBan();
        }
        return "";
    }
}
