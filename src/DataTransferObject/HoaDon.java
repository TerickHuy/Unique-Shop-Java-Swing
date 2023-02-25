/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTransferObject;

import java.sql.Date;

/**
 *
 * @author petpkpro123
 */
public class HoaDon {
    private String strMaNv, strTenNV ;
    private int iSoHD, iTong;
    private Date dNgayLap;

    public HoaDon(String strMaNv, String strTenNV, int iSoHD, int iTong, Date dNgayLap) {
        this.strMaNv = strMaNv;
        this.strTenNV = strTenNV;
        this.iSoHD = iSoHD;
        this.iTong = iTong;
        this.dNgayLap = dNgayLap;
    }
    
    public HoaDon(){
        strMaNv = "";
        strTenNV = "";
        iSoHD = 0;
        iTong = 0;
    }

    public String getStrMaNv() {
        return strMaNv;
    }

    public void setStrMaNv(String strMaNv) {
        this.strMaNv = strMaNv;
    }

    public String getStrTenNV() {
        return strTenNV;
    }

    public void setStrTenNV(String strTenNV) {
        this.strTenNV = strTenNV;
    }

    public int getiSoHD() {
        return iSoHD;
    }

    public void setiSoHD(int iSoHD) {
        this.iSoHD = iSoHD;
    }

    public int getiTong() {
        return iTong;
    }

    public void setiTong(int iTong) {
        this.iTong = iTong;
    }

    public Date getdNgayLap() {
        return dNgayLap;
    }

    public void setdNgayLap(Date dNgayLap) {
        this.dNgayLap = dNgayLap;
    }
}
