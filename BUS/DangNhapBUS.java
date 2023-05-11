<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import DTO.TaiKhoan;
import DAO.DangNhapDAO;
import javax.swing.JOptionPane;
/**
 *
 * @author ADMIN
 */
public class DangNhapBUS {
    private final static int EMPTY_ERROR = 1;
    private final static int WRONG_ERROR = 2;
    public static TaiKhoan taiKhoanLogin = null;

    public TaiKhoan getTaiKhoanDangNhap(String user, String password) {
        if (kiemTraDangNhap(user, password) == EMPTY_ERROR) {
            JOptionPane.showMessageDialog(null,"Không được để trống thông tin!");
            return null;
        }
        TaiKhoan tk = new TaiKhoan();
        tk.setTaikhoan(user);
        tk.setMatkhau(password);

        DangNhapDAO dangNhapDAO = new DangNhapDAO();
        TaiKhoan account = dangNhapDAO.dangNhap(tk);
        taiKhoanLogin = account;

        if (account == null) {
            JOptionPane.showMessageDialog(null,"Sai thông tin đăng nhập");
       
        }
        return account;
    }
private int kiemTraDangNhap(String user, String password) {
        user = user.replaceAll("\\s+", "");
        password = password.replaceAll("\\s+", "");
        int result = 0;

        TaiKhoan tk = new TaiKhoan();
        tk.setTaikhoan(user);
        tk.setMatkhau(password);

        DangNhapDAO dangNhapDAO = new DangNhapDAO();
        TaiKhoan account = dangNhapDAO.dangNhap(tk);

        if (user.length() <= 0 || password.length() <= 0) {
            result = EMPTY_ERROR;
        } else if (account == null) {
            result = WRONG_ERROR;
        }
        return result;
    }
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import DTO.TaiKhoan;
import DAO.DangNhapDAO;
import javax.swing.JOptionPane;
/**
 *
 * @author ADMIN
 */
public class DangNhapBUS {
    private final static int EMPTY_ERROR = 1;
    private final static int WRONG_ERROR = 2;
    public static TaiKhoan taiKhoanLogin = null;

    public TaiKhoan getTaiKhoanDangNhap(String user, String password) {
        if (kiemTraDangNhap(user, password) == EMPTY_ERROR) {
            JOptionPane.showMessageDialog(null,"Không được để trống thông tin!");
            return null;
        }
        TaiKhoan tk = new TaiKhoan();
        tk.setTaikhoan(user);
        tk.setMatkhau(password);

        DangNhapDAO dangNhapDAO = new DangNhapDAO();
        TaiKhoan account = dangNhapDAO.dangNhap(tk);
        taiKhoanLogin = account;

        if (account == null) {
            JOptionPane.showMessageDialog(null,"Sai thông tin đăng nhập");
       
        }
        return account;
    }
private int kiemTraDangNhap(String user, String password) {
        user = user.replaceAll("\\s+", "");
        password = password.replaceAll("\\s+", "");
        int result = 0;

        TaiKhoan tk = new TaiKhoan();
        tk.setTaikhoan(user);
        tk.setMatkhau(password);

        DangNhapDAO dangNhapDAO = new DangNhapDAO();
        TaiKhoan account = dangNhapDAO.dangNhap(tk);

        if (user.length() <= 0 || password.length() <= 0) {
            result = EMPTY_ERROR;
        } else if (account == null) {
            result = WRONG_ERROR;
        }
        return result;
    }
}
>>>>>>> origin/main
