/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author DO THE TUNG
 */
public class tacGiaDTO {
    public String Ten;
    public int Ma;
    public String Ho;
    public String GioiTinh;
    public int soDienThoai;
    public  tacGiaDTO(){}
    public  tacGiaDTO(int Ma,String Ten, String Ho, String GioiTinh,int soDienThoai)
    {
        this.Ma=Ma;
        this.Ten=Ten;
        this.Ho = Ho;
        this.GioiTinh=GioiTinh;
        
        this.soDienThoai=  soDienThoai;
        
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public int getMa() {
        return Ma;
    }

    public void setMa(int Ma) {
        this.Ma = Ma;
    }

    public String getHo() {
        return Ho;
    }

    public void setHo(String Ho) {
        this.Ho = Ho;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public int getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(int soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
    
}
