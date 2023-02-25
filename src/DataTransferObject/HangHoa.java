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
public class HangHoa {
    private int iMaHH, iGiaBan;
    private String strTenHH, strDVT, MaNCC; 
    
    public HangHoa(){
        this.MaNCC = "";
        this.iGiaBan = 0;
        this.iMaHH = 0;
        this.strDVT = "";
        this.strTenHH = "";
    }

    public HangHoa(int iMaHH, int iGiaBan, String strTenHH, String strDVT, String MaNCC) {
        this.iMaHH = iMaHH;
        this.iGiaBan = iGiaBan;
        this.strTenHH = strTenHH;
        this.strDVT = strDVT;
        this.MaNCC = MaNCC;
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

    public String getStrTenHH() {
        return strTenHH;
    }

    public void setStrTenHH(String strTenHH) {
        this.strTenHH = strTenHH;
    }

    public String getStrDVT() {
        return strDVT;
    }

    public void setStrDVT(String strDVT) {
        this.strDVT = strDVT;
    }

    public String getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }
}
