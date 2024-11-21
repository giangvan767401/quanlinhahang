package qlinhahang;

import java.io.Serializable;

public class food implements Serializable {
     
    private String tenmon;
    private float gia;

    public String getTenmon() {
        return tenmon;
    }

    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }
 
    public food( String tenmon, float gia){
    
       this.tenmon = tenmon;
       this.gia = gia;
    }
    
    public void hienthithongtin(){
         System.out.println("Ten mon: "+tenmon);
         System.out.println("Gia: "+gia+ "VND");
    }
}
