/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTransferObject;

/**
 *
 * @author this pc
 */
public class Khachhang {
    private String strMakh, strTenkh, strGioitinh, strDiachi,strSdt;

    public Khachhang(String strMakh, String strTenkh, String strGioitinh, String strDiachi, String strSdt) {
        this.strMakh = strMakh;
        this.strTenkh = strTenkh;
        this.strGioitinh = strGioitinh;
        this.strDiachi = strDiachi;
        this.strSdt = strSdt;
    }

    public String getStrMakh() {
        return strMakh;
    }

    public void setStrMakh(String strMakh) {
        this.strMakh = strMakh;
    }

    public String getStrTenkh() {
        return strTenkh;
    }

    public void setStrTenkh(String strTenkh) {
        this.strTenkh = strTenkh;
    }

    public String getStrGioitinh() {
        return strGioitinh;
    }

    public void setStrGioitinh(String strGioitinh) {
        this.strGioitinh = strGioitinh;
    }

    public String getStrDiachi() {
        return strDiachi;
    }

    public void setStrDiachi(String strDiachi) {
        this.strDiachi = strDiachi;
    }

    public String getStrSdt() {
        return strSdt;
    }

    public void setStrSdt(String strSdt) {
        this.strSdt = strSdt;
    }



    public Khachhang() {
        this.strMakh = "";
        this.strTenkh = "";
        this.strGioitinh = "";
        this.strDiachi = "";
        this.strSdt = "";
    }
}
