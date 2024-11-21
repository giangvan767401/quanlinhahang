package qlinhahang;

public class daubep extends human {
    
    private String taynghe;
    private float luong;

    public float getLuong() {
        return luong;
    }

    public void setLuong(float luong) {
        this.luong = luong;
    }
 
    public String getTaynghe() {
        return taynghe;
    }

    public void setTaynghe(String taynghe) {
        this.taynghe = taynghe;
    }
    
    public daubep(String ma, String name, String gender, int tuoi, String taynghe, float luong){
       super(ma, name, gender,tuoi);
       this.taynghe = taynghe;
       this.luong = luong;
    }
    
    @Override
    public void hienthithongtin(){
       super.hienthithongtin();
        System.out.println("Tay nghe cua dau bep: "+taynghe);
        System.out.println("Luong cua dau bep: "+luong+"VND");
    }
}
