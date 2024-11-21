package qlinhahang;

public class quanli extends human {
    
    private String thamnien;
     private float luong;

    public float getLuong() {
        return luong;
    }

    public void setLuong(float luong) {
        this.luong = luong;
    }

    public String getThamnien() {
        return thamnien;
    }

    public void setThamnien(String thamnien) {
        this.thamnien = thamnien;
    }
    
    public quanli(String ma, String name, String gender, int tuoi, String thamnien, float luong){
       super(ma, name, gender,tuoi);      
       this.thamnien = thamnien;
       this.luong = luong;
    }
    
    @Override
    public void hienthithongtin(){
       super.hienthithongtin();
        System.out.println("Quan li co tham nien: "+thamnien+"nam");
        System.out.println("Luong cua quan li: "+luong+"VND");
    }
}
