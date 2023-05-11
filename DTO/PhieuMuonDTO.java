/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author quang
 */
public class PhieuMuonDTO {
    private int maDG;
    private int ma;
    private int maNV;
    private String ngayMuon,ngayTra,ngayTraThuc;
    private int trangThai;

    public int getMaDG() {
        return maDG;
    }

    public void setMaDG(int maDG) {
        this.maDG = maDG;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(String ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
    }

    public String getNgayTraThuc() {
        return ngayTraThuc;
    }

    public void setNgayTraThuc(String ngayTraThuc) {
        this.ngayTraThuc = ngayTraThuc;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
}
