
package qlinhahang;
import java.util.ArrayList;

public class customer extends human{
    private String rank;
    private ArrayList<food> selectedFoods;
    private float tongtien,ttskm;

    public float getTongtien() {
        return tongtien;
    }

    public void setTongtien(float tongtien) {
        this.tongtien = tongtien;
    }
    

    public float getTtskm() {
        return ttskm;
    }

    public void setTtskm(float ttskm) {
        this.ttskm = ttskm;
    }

    public ArrayList<food> getSelectedFoods() {
        return selectedFoods;
    }

    public void setSelectedFoods(ArrayList<food> selectedFoods) {
        this.selectedFoods = selectedFoods;
    }
  
    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

      public customer(String ma, String name, String gender, int tuoi, String rank){
       super(ma, name, gender, tuoi);
       this.rank = rank;
       this.selectedFoods = new ArrayList<>();
       this.tongtien = 0;
       this.ttskm = 0;
    }  
      
    public void addfood(food mon) {
        selectedFoods.add(mon);
    }
    
    public void tinhtien(food mon) {
        tongtien += mon.getGia();
    }
    
    public float khuyenmai() {
        switch (rank.toLowerCase()) {
        case "bac":
            return tongtien * 0.05f; 
        case "vang":
            return tongtien * 0.1f;  
        case "kim cuong":
            return tongtien * 0.2f;  
        default:
            return 0f;
        }
    }
    
    public void tinhtienGiam(food mon) {
    tongtien -= mon.getGia(); 
    if (tongtien < 0) {
        tongtien = 0; 
    }
}
    
    public float tongtiensaukm() {
    return tongtien - khuyenmai(); 
}
   
    @Override
    public void hienthithongtin(){
       super.hienthithongtin();
        System.out.println("cap bac cua khach hang: "+rank);
        System.out.print("Mon da chon: ");
        for (food mon : selectedFoods) {
            System.out.print(mon.getTenmon() + ", ");
        }
        System.out.println(" ");
        System.out.println("Tong so tien truoc khi giam gia: " + tongtien);
        System.out.println("Tong so tien sau khi giam gia: " + tongtiensaukm());
    }
}     
