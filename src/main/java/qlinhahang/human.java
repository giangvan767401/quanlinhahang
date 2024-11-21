package qlinhahang;

import java.io.Serializable;

public class human implements Serializable {
    private String ma,name,gender;
  
    private int tuoi;

    public String getMa() {
        return ma;
    }

    public void setMa(String maNV) {
        this.ma = maNV;
    }  

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }
    
    public human(String ma, String name, String gender, int tuoi){
       this.ma = ma;
       this.name = name;
       this.gender = gender;
       this.tuoi = tuoi;
    }
    
    public void hienthithongtin() {
        System.out.println("Ma nhan vien(khach hang): "+ma);
        System.out.println("Ten nhan vien(khach hang): "+name);
        System.out.println("Gioi tinh: "+gender);
        System.out.println("Tuoi: "+tuoi);
    }
}