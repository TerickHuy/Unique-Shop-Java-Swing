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
public class CTHD {
    private int iSoHD, iMaHH,iGiaBan,iSoLuong,iTong;
    private String strTenHH;

    public CTHD(int iSoHD, int iMaHH, int iGiaBan, int iSoLuong, int iTong, String strTenHH) {
        this.iSoHD = iSoHD;
        this.iMaHH = iMaHH;
        this.iGiaBan = iGiaBan;
        this.iSoLuong = iSoLuong;
        this.iTong = iTong;
        this.strTenHH = strTenHH;
    }
    
    public CTHD(){
        iGiaBan = 0;
        iMaHH = 0;
        iSoHD= 0;
        iSoLuong= 0;
        iTong = 0;
        strTenHH = "";
    }

    public int getiSoHD() {
        return iSoHD;
    }

    public void setiSoHD(int iSoHD) {
        this.iSoHD = iSoHD;
    }

    public int getiMaHH() {
        return iMaHH;
    }

    public void setiMaHH(int iMaHH) {
        this.iMaHH = iMaHH;
    }

    public int getiGiaBan() {
        return iGiaBan;
    }

    public void setiGiaBan(int iGiaBan) {
        this.iGiaBan = iGiaBan;
    }

    public int getiSoLuong() {
        return iSoLuong;
    }

    public void setiSoLuong(int iSoLuong) {
        this.iSoLuong = iSoLuong;
    }

    public int getiTong() {
        return iTong;
    }

    public void setiTong(int iTong) {
        this.iTong = iTong;
    }

    public String getStrTenHH() {
        return strTenHH;
    }

    public void setStrTenHH(String strTenHH) {
        this.strTenHH = strTenHH;
    }
}
