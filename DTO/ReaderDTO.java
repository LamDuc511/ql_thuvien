/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */package DTO;
import java.util.*;
import java.lang.*;


/**
 *
 * @author ADMIN
 */
public class ReaderDTO {
   public String id,ho,ten;
    public String ngaysinh,gioitinh,sdt;

    public ReaderDTO(String id, String ho, String ten, String ngaysinh, String gioitinh, String sdt) {
        this.id = id;
        this.ho = ho;
        this.ten = ten;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.sdt = sdt;
    }
    public ReaderDTO(){}
  public String getid(){
      return id;
  }
  public void setid(String id){
      this.id = id;
  }
    public String getho(){
      return ho;
  }
  public void setho(String ho){
      this.ho = ho;
  }
    public String getten(){
      return ten;
  }
  public void setten(String ten){
      this.ten = ten;
  }
    public String getngaysinh(){
      return ngaysinh;
  }
  public void setngaysinh(String ngaysinh){
      this.ngaysinh = ngaysinh;
  }
    public String getgioitinh(){
      return gioitinh;
  }
  public void setgioitinh(String gioitinh){
      this.gioitinh = gioitinh;
  }
    public String getsdt(){
      return sdt;
  }
  public void setsdt(String sdt){
      this.sdt = sdt;
  }
}
