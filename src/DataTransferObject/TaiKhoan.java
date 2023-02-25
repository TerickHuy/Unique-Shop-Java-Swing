/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTransferObject;

/**
 *
 * @author petpkpro123
 */
public class TaiKhoan {
    private String tenTk, matKhau;

    public TaiKhoan(String tenTk, String matKhau) {
        this.tenTk = tenTk;
        this.matKhau = matKhau;
    }
    
    public TaiKhoan(){
        this.tenTk = "";
        this.matKhau = "";
    }

    public String getTenTk() {
        return tenTk;
    }

    public void setTenTk(String tenTk) {
        this.tenTk = tenTk;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    
}
