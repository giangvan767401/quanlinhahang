package qlinhahang;

public class phucvu extends human {
  
    private float luongtheogio;

    public float getLuongtheogio() {
        return luongtheogio;
    }

    public void setLuongtheogio(float luongtheogio) {
        this.luongtheogio = luongtheogio;
    }
    
    public phucvu(String ma, String name, String gender, int tuoi, float luongtheogio){
       super(ma, name, gender, tuoi);
       this.luongtheogio = luongtheogio;
    }  
    
    @Override
    public void hienthithongtin(){
       super.hienthithongtin();
        System.out.println("Luong theo gio lam: "+luongtheogio+"VND");
    }
}
