/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import DAO.theloaiDAO;
import DTO.theloaiDTO;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class theloaiBUS {
    static ArrayList<theloaiDTO> listTheloai = new ArrayList();
    static theloaiDAO data = new theloaiDAO();
    public theloaiBUS(){
        
    }
    public void getdata(){
         if (listTheloai == null) {
            listTheloai = new ArrayList<theloaiDTO>();
        }
        listTheloai = data.gettheloai();

        listTheloai.addAll(data.gettheloai());

    }
    public String gettheloaifromMa(int ma){
        for(theloaiDTO tl: listTheloai){
            if(tl.getMa() == ma)
                return tl.getTen();
        }
        return "";
    }
}
