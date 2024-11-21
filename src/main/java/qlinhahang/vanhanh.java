package qlinhahang;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class vanhanh {
     static ArrayList<human> themnguoi = new ArrayList<>();   // danh sách những nhân viên or customer đc khởi tạo sẽ thêm vào đây
     static ArrayList<food> danhsachmon = new ArrayList<>();  // danh sách những món ăn đc khởi tạo sẽ thêm vào đây
     
     public static void themmon(food mon) {
        danhsachmon.add(mon);                  
    }
    
    public static void addnewfood(){                // Thêm món ăn mới vô danh sách món
    Scanner scanner = new Scanner(System.in);               
    System.out.println("So mon an muon them: ");
    int somon = scanner.nextInt();
    while (somon < 0) {             
            System.out.println("Gia tri khong hop le! Vui long nhap lai: ");
            somon = scanner.nextInt();
        }
    scanner.nextLine();
       
    for(int i = 0; i<somon ; i++){
        
        System.out.println("Nhap ten mon an:  ");
        String tenmon = scanner.nextLine();
        System.out.println("Nhap gia tien cua mon: ");
        float gia = scanner.nextFloat();
         while (gia < 0) {             
            System.out.println("Gia tri khong hop le! Vui long nhap lai: ");
            gia = scanner.nextFloat();
        }
        themmon(new food(tenmon, gia));
        System.out.println("Them mon thanh cong");
        scanner.nextLine();
    }   
   } 
    
   public static void hienthimenu(){       // Hiển thị danh sách những món ăn đã nhập vào trước đó
   if (danhsachmon.isEmpty()) {
            System.out.println("Menu hien tai chua co mon an");
        }
   else{
         for (int i = 0; i < danhsachmon.size(); i++) {
             food mon = danhsachmon.get(i); // Lấy đối tượng tại vị trí i
             mon.hienthithongtin(); 
              }
    }
  }

     
    public static boolean kiemtramatrung(String ma) {
    for (int i = 0; i < themnguoi.size(); i++) {
        human nguoi = themnguoi.get(i); // Lấy đối tượng tại vị trí i
        if (nguoi.getMa().equals(ma)) {
            return true;  
        }
    }
    return false;   //Vòng lặp này khi end mà vẫn k thấy mã khớp thì sẽ trả về false
}
  
    public static void nhapnguoi(){   // Hàm giúp nhập vào nhân viên hoặc khách hàng mới.
      
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap so nguoi can them: "); 
        int songuoi = scanner.nextInt();
        
         while (songuoi < 0) {             // Nếu nhập số người là âm thì hệ thống sẽ bắt nhập lại.
            System.out.println("Gia tri khong hop le! Vui long nhap lai: ");
            songuoi = scanner.nextInt();
        }
        scanner.nextLine(); 
       
        for (int i = 0; i < songuoi; i++){
          System.out.println("1. Them nhan vien nha hang");   
          System.out.println("2. Nhap khach hang");
          
          int k = scanner.nextInt();           //Lựa chọn nhập NV hay khách hàng
            
            while (k != 1 && k != 2) {
                System.out.println("Vui long nhap gia tri 1 hoac 2: ");
                k = scanner.nextInt();
            }
            
             scanner.nextLine(); 
            if (k == 1) {
                System.out.println("1. Them quan li");  
                System.out.println("2. Them phuc vu");
                System.out.println("3. Them dau bep");
                int o = scanner.nextInt();
            
            while (o != 1 && o != 2 && o!= 3) {          //Chọn chi tiết vị trí nhân viên muốn nhập
                System.out.println("nhap gia tri 1, 2 hoac 3: ");
                o = scanner.nextInt();
            }
                
                scanner.nextLine(); 
                
        
                String ma;
                do {
                 System.out.println("Nhap ma nhan vien: ");
                ma = scanner.nextLine();
                if (kiemtramatrung(ma)) {         // Kiểm tra trùng mã
                System.out.println("Ma da ton tai, nhap ma khac.");
                  }
                } while (kiemtramatrung(ma));
               
              // Nhập các thông tin cơ bản của một nhân viên trước.
                System.out.println("Nhap ho va ten nhan vien: ");
                String name = scanner.nextLine();
                System.out.println("Nhap gioi tinh:");  
                String gender = scanner.nextLine();
                while (!gender.equalsIgnoreCase("Nam") && !gender.equalsIgnoreCase("Nu")) {  // Giới tính sẽ bắt buộc phải nhập nam hoặc nu dù viết hoa hay viết thường đều được.
                System.out.println("Khong hop le, nhap lai (Nam hoac Nu): ");
                gender = scanner.nextLine();
                }

                
                System.out.println("Nhap tuoi nhan vien: ");
                int tuoi = scanner.nextInt();
                 while (tuoi <= 0) {
            System.out.println("Khong hop le! nhap lai: ");
            tuoi = scanner.nextInt();
        }
              
                if(o == 1){  // Nhập thông tin đặc biệt của quản lí
                scanner.nextLine();
                System.out.println("Nhap tham nien trong nghanh cua quan li (thoi gian hanh nghe): ");
                String thamnien = scanner.nextLine();
                System.out.println("Nhap muc luong offer cho quan li: ");
                float luong = scanner.nextFloat();
                while (luong < 0) {
            System.out.println("Gia tri khong hop le! Vui long nhap lai: ");
            luong = scanner.nextFloat();
        }
                themnguoi.add(new quanli(ma, name, gender,tuoi, thamnien, luong)); // Thêm quản lí vừa nhập vào danh sách
                }
                else if(o == 2){ // Nhập thông tin đặc biệt của phục vụ
                scanner.nextLine();
                System.out.println("Nhap luong theo gio: ");
                float luongtheogio = scanner.nextFloat();
                while (luongtheogio < 0) {
            System.out.println("Gia tri khong hop le! Vui long nhap lai: ");
            luongtheogio = scanner.nextFloat();
        }
                themnguoi.add(new phucvu(ma, name, gender, tuoi, luongtheogio)); // Thêm phục vụ vừa nhập vào danh sách
                }
                else if(o == 3){  // Nhập thông tin đặc biệt của đầu bếp
                scanner.nextLine();
                System.out.println("Nhap trinh do tay nghe cua dau bep(3 sao/4 sao/5sao): ");
                String taynghe = scanner.nextLine();
                while (!taynghe.equalsIgnoreCase("3 sao") && !taynghe.equalsIgnoreCase("4 sao")&& !taynghe.equalsIgnoreCase("5 sao")) {
                System.out.println("Khong hop le! Vui long nhap lai (Nam hoac Nu): ");
                taynghe = scanner.nextLine();
                }
                System.out.println("Nhap muc luong offer cho dau bep: ");
                float luong = scanner.nextFloat();
                while (luong < 0) {
            System.out.println("Gia tri khong hop le! Vui long nhap lai: ");
            luong = scanner.nextFloat();
        }
               
                themnguoi.add(new daubep(ma, name, gender,tuoi, taynghe, luong)); // Thêm đầu bếp vừa nhập vào danh sách
                }
            }
            else{             
                
               
               
                String ma;
          
                do {
                 System.out.println("Nhap ma khach hang: ");   // Kiểm tra mã KH nhập vào có bị trùng không
                ma = scanner.nextLine();
                if (kiemtramatrung(ma)) {
                System.out.println("Ma da ton tai! Vui long nhap ma khac.");
                  }
                } while (kiemtramatrung(ma));
                
                // nhập các thông tin cho khách hàng
                System.out.println("Nhap ho va ten khach hang: ");
                String name = scanner.nextLine();
                System.out.println("Nhap gioi tinh:");
                String gender = scanner.nextLine();
                while (!gender.equalsIgnoreCase("Nam") && !gender.equalsIgnoreCase("Nu")) {
                System.out.println("Khong hop le! Vui long nhap lai: "); // Giới tính sẽ bắt buộc phải nhập nam hoặc nu dù viết hoa hay viết thường đều được.
                gender = scanner.nextLine();
                }

                System.out.println("Nhap tuoi khach hang: ");
                int tuoi = scanner.nextInt();
                while (tuoi <= 0) {
                System.out.println("Gia tri khong hop le! Vui long nhap lai: ");
                tuoi = scanner.nextInt();
                }
                scanner.nextLine();
                System.out.println("Nhap rank khach hang(Bac; Vang; Kim Cuong): "); // Nhập rank có tác dụng giảm phần trăm hoá đơn thanh toán
                String rank = scanner.nextLine();
                 while (!rank.equalsIgnoreCase("Bac") && !rank.equalsIgnoreCase("Vang")&& !rank.equalsIgnoreCase("Kim Cuong")) {
                System.out.println("Khong hop le! Vui long nhap lai: ");
                rank = scanner.nextLine();
                }
             System.out.println("Chon mon an (Nhap so tuong ung): ");   // chọn món ăn theo menu ta đã nhập vào.
             for (int j = 0; j < danhsachmon.size(); j++) {
             System.out.println((j + 1) + ". " + danhsachmon.get(j).getTenmon() + " - Gia: " + danhsachmon.get(j).getGia()); 
             }              // hiển thị tên và giá món ăn theo thứ tự.
             ArrayList<food> selectedFoods = new ArrayList<>();
               // Danh sách món ăn riêng cho từng khách theo nhu cầu chọn
             while (true) {
             System.out.println("Nhap ma mon an de chon (hoac 'x' de out): ");
             String choice = scanner.nextLine();
             if (choice.equalsIgnoreCase("x")) {
             break;
             }

             int index = Integer.parseInt(choice) - 1; //chuyển choice về số nguyên rồi trừ đi 1 vì index bắt đầu từ 0 
             if (index >= 0 && index < danhsachmon.size()) {
            selectedFoods.add(danhsachmon.get(index)); // thêm món ăn vào danh sách chọn món
             } else {
            System.out.println("Chon khong hop le! Vui long nhap lai.");
              }
            }
    
            customer khachhang = new customer(ma, name, gender, tuoi, rank);// khởi tạo đối tượng khách hàng
            for (int g = 0; g < selectedFoods.size(); g++) {
               food mon = selectedFoods.get(g); // Lấy đối tượng tại vị trí g
                 khachhang.addfood(mon);  // Thêm vào danh sách món ăn của KH
                 khachhang.tinhtien(mon);   
                }
    themnguoi.add(khachhang);  // Thêm khách hàng vừa nhập vô danh sách
     }
            System.out.println("Them nhan vien( khach hang ) thanh cong"); 
        }
          for (int i = 0; i < themnguoi.size(); i++) {
            System.out.println("Nguoi thu: " + (i + 1) + ":");
            themnguoi.get(i).hienthithongtin();
            System.out.println("  ");
        }
    }
  
    public static void doanhthu() {
    float tongdoanhthu = 0;

    // Duyệt qua danh sách những người đã thêm
    for (int i = 0; i < themnguoi.size(); i++) {
        human nguoi = themnguoi.get(i);

        // Kiểm tra nếu đó là khách hàng
        if (nguoi instanceof customer) {
            customer khach = (customer) nguoi;

            // Lấy tổng số tiền mà khách hàng đã chi tiêu
            tongdoanhthu += khach.tongtiensaukm();  
        }
    }

    System.out.println("Tong doanh thu hien tai: " + tongdoanhthu + " VND");
}
    
    public static void timnguoi() { // Tìm đối tượng nhân viên hay khách hàng mà ta đã nhập vào theo mã
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ma nguoi can tim: ");
        String matim = scanner.nextLine();

        boolean found = false; //Biến found này được khai báo với giá trị ban đầu là false, đến khi tìm thấy gtri nó sẽ là true
        for (int i = 0; i < themnguoi.size(); i++) {
          human x = themnguoi.get(i); // Lấy đối tượng tại vị trí i
          if (x.getMa().equals(matim)) {
          System.out.println("Thong tin nguoi can tim: ");
          x.hienthithongtin();  // khi tìm được sẽ in thông tin
          found = true;
        break;
         }
     }
        if (!found) {
            System.out.println("Khong tim thay nguoi co ma: " + matim);
        }
    }
    
  public static void xoanguoi() {
    if (themnguoi.isEmpty()) {
        System.out.println("Danh sach nguoi hien dang trong.");
        return; // Kết thúc phương thức nếu danh sách trống
    }

    Scanner scanner = new Scanner(System.in);
    System.out.println("Nhap ma cua nguoi can xoa: ");
    String maxoa = scanner.nextLine();

    boolean found = false;
    for (int i = 0; i < themnguoi.size(); i++) {
        human nguoixoa = themnguoi.get(i); // Lấy đối tượng tại vị trí i
        if (nguoixoa.getMa().equals(maxoa)) {
            themnguoi.remove(i); // Xóa đối tượng tại chỉ số i
            found = true;
            System.out.println("Nguoi co ma: " + maxoa + " da duoc xoa.");
            break; // Thoát khỏi vòng lặp
        }
    }

    if (!found) {
        System.out.println("Khong tim thay nguoi co ma: " + maxoa);
    }
}
    
    public static void xoamon() {
    if (danhsachmon.isEmpty()) {
        System.out.println("Danh sach mon an hien dang trong.");
        return; // Kết thúc phương thức nếu danh sách trống
    }

    Scanner scanner = new Scanner(System.in);
    System.out.println("Nhap ten mon can xoa: ");
    String tenmonxoa = scanner.nextLine();

    boolean found = false;
    for (int i = 0; i < danhsachmon.size(); i++) {
        food monxoa = danhsachmon.get(i); // Lấy đối tượng tại vị trí i
        if (monxoa.getTenmon().equals(tenmonxoa)) {
            danhsachmon.remove(i); // Xóa đối tượng tại chỉ số i
            found = true;
            System.out.println("Mon " + tenmonxoa + " da duoc xoa.");
            break; // Thoát khỏi vòng lặp
        }
    }

    if (!found) {
        System.out.println("Khong tim thay mon co ten: " + tenmonxoa);
    }
}
    
    
    public static void suanguoi() {
    if (themnguoi.isEmpty()) {
        System.out.println("Danh sach nguoi hien dang trong.");
        return; // Kết thúc phương thức nếu danh sách trống
    }

    Scanner scanner = new Scanner(System.in);
    System.out.println("Nhap ma cua nguoi can chinh sua: ");
    String machinhsua = scanner.nextLine();

    boolean found = false;
    for (int i = 0; i < themnguoi.size(); i++) {
        human nguoichinhsua = themnguoi.get(i); // Lấy đối tượng tại vị trí i
        if (nguoichinhsua.getMa().equals(machinhsua)) {
          
            System.out.println("Nhap ten moi: ");
            String tenmoi = scanner.nextLine();
            nguoichinhsua.setName(tenmoi); 

            System.out.println("Nhap tuoi moi: ");
            int tuoimoi = scanner.nextInt();
             while (tuoimoi <= 0) {
                System.out.println("Gia tri khong hop le! Vui long nhap lai: ");
                tuoimoi = scanner.nextInt();
                }
            nguoichinhsua.setTuoi(tuoimoi); 
            
            System.out.println("Nhap gioi tinh: ");
            scanner.nextLine();
            String gendermoi = scanner.nextLine();
            while (!gendermoi.equalsIgnoreCase("Nam") && !gendermoi.equalsIgnoreCase("Nu")) {
                System.out.println("Khong hop le! Vui long nhap lai: "); // Giới tính sẽ bắt buộc phải nhập nam hoặc nu dù viết hoa hay viết thường đều được.
                gendermoi = scanner.nextLine();
                }
             nguoichinhsua.setGender(gendermoi); 
             
             if (nguoichinhsua instanceof quanli) {
             
             quanli suaquanli = (quanli) nguoichinhsua;
             System.out.println("Nhap tham nien trong nghanh cua quan li (thoi gian hanh nghe): ");
             String thamnienmoi = scanner.nextLine();
             suaquanli.setThamnien(thamnienmoi); 
              System.out.println("Nhap muc luong moi offer cho quan li: ");
                float luongmoi = scanner.nextFloat();
                while (luongmoi < 0) {
            System.out.println("Gia tri khong hop le! Vui long nhap lai: ");
            luongmoi = scanner.nextFloat();
        }
        suaquanli.setLuong(luongmoi); 
             
        } else if (nguoichinhsua instanceof phucvu) {
        
            phucvu suaphucvu = (phucvu) nguoichinhsua;
            System.out.println("Nhap luong theo gio: ");
                float luongtheogiomoi = scanner.nextFloat();
                while (luongtheogiomoi < 0) {
            System.out.println("Gia tri khong hop le! Vui long nhap lai: ");
            luongtheogiomoi = scanner.nextFloat();
        }
        suaphucvu.setLuongtheogio(luongtheogiomoi);        
            
        } else if (nguoichinhsua instanceof daubep) {
       
            daubep suadaubep = (daubep) nguoichinhsua;
             System.out.println("Nhap trinh do tay nghe cua dau bep(3 sao/4 sao/5sao): ");
                String taynghemoi = scanner.nextLine();
                while (!taynghemoi.equalsIgnoreCase("3 sao") && !taynghemoi.equalsIgnoreCase("4 sao")&& !taynghemoi.equalsIgnoreCase("5 sao")) {
                System.out.println("Khong hop le! Vui long nhap lai (Nam hoac Nu): ");
                taynghemoi = scanner.nextLine();
                }
                suadaubep.setTaynghe(taynghemoi);
                
                System.out.println("Nhap muc luong offer cho dau bep: ");
                float luongmoi = scanner.nextFloat();
                while (luongmoi < 0) {
            System.out.println("Gia tri khong hop le! Vui long nhap lai: ");
            luongmoi = scanner.nextFloat();
        } 
                 suadaubep.setLuong(luongmoi);
            
        } else if (nguoichinhsua instanceof customer) {
                 
                customer suacustomer = (customer) nguoichinhsua;    
                
                System.out.println("Nhap rank khach hang(Bac; Vang; Kim Cuong): "); // Nhập rank có tác dụng giảm phần trăm hoá đơn thanh toán
                String rankmoi = scanner.nextLine();
                 while (!rankmoi.equalsIgnoreCase("Bac") && !rankmoi.equalsIgnoreCase("Vang")&& !rankmoi.equalsIgnoreCase("Kim Cuong")) {
                System.out.println("Khong hop le! Vui long nhap lai: ");
                rankmoi = scanner.nextLine();
                }
                 suacustomer.setRank(rankmoi);
        }

            found = true;
            System.out.println("Thong tin cua nguoi co ma: " + machinhsua + " da duoc cap nhat.");
            break; // Thoát khỏi vòng lặp
        }
    }

    if (!found) {
        System.out.println("Khong tim thay nguoi co ma: " + machinhsua);
    }
}
    
    public static void suamenu() {
    if (danhsachmon.isEmpty()) {
        System.out.println("Menu hien dang trong.");
        return; // Kết thúc phương thức nếu danh sách trống
    }

    Scanner scanner = new Scanner(System.in);
    System.out.println("Nhap ten cua mon can chinh sua: ");
    String tenmonchinhsua = scanner.nextLine();

    boolean found = false;
    for (int i = 0; i < danhsachmon.size(); i++) {
        food monchinhsua = danhsachmon.get(i); // Lấy đối tượng tại vị trí i
        if (monchinhsua.getTenmon().equals(tenmonchinhsua)) {
          
            System.out.println("Nhap ten moi: ");
            String tenmoi = scanner.nextLine();
            monchinhsua.setTenmon(tenmoi); 

            System.out.println("Nhap gia moi: ");
            float giamoi = scanner.nextFloat();
             while (giamoi <= 0) {
                System.out.println("Gia tri khong hop le! Vui long nhap lai: ");
                giamoi = scanner.nextInt();
                }
            monchinhsua.setGia(giamoi); 

            found = true;
            System.out.println("Thong tin cua mon co ten: " + tenmonchinhsua + " da duoc cap nhat.");
            break; // Thoát khỏi vòng lặp
        }
    }

    if (!found) {
        System.out.println("Khong tim thay mon co ten: " + tenmonchinhsua);
    }
}
    
    
public static void suamondadat() {
    if (themnguoi.isEmpty()) {
        System.out.println("Danh sach nguoi hien dang trong.");
        return; // Kết thúc phương thức nếu danh sách trống
    }

    Scanner scanner = new Scanner(System.in);
    System.out.println("Nhap ma cua nguoi can chinh sua mon da goi: ");
    String machinhsua = scanner.nextLine();

    boolean found = false;
    for (int i = 0; i < themnguoi.size(); i++) {
        human nguoichinhsua = themnguoi.get(i); // Lấy đối tượng tại vị trí i

        if (nguoichinhsua instanceof customer && nguoichinhsua.getMa().equals(machinhsua)) {
            customer nguoisuamon = (customer) nguoichinhsua;

            System.out.println("Ban muon them hay xoa mon trong order cua khach?");
            System.out.println("1. Them mon");
            System.out.println("2. Xoa mon");
            int c = scanner.nextInt();
            scanner.nextLine();  

            while (c != 1 && c != 2) {
                System.out.println("Vui long nhap gia tri 1 hoac 2: ");
                c = scanner.nextInt();
                scanner.nextLine();  
            }

            switch (c) {
                case 1:
                    
                    for (int p = 0; p < danhsachmon.size(); p++) {
                        System.out.println((p + 1) + ". " + danhsachmon.get(p).getTenmon() + " - Gia: " + danhsachmon.get(p).getGia());
                    }
                    while (true){
                    System.out.println("Nhap ma mon an de chon (hoac 'x' de out): ");
                    String monthem = scanner.nextLine();
                     if (monthem.equalsIgnoreCase("x")) {
                      break;
                      }
                    int monthemm = Integer.parseInt(monthem) - 1;
                    if (monthemm >= 0 && monthemm < danhsachmon.size()) {
                        food mon = danhsachmon.get(monthemm);
                        nguoisuamon.addfood(mon);  // Thêm món vào danh sách của khách hàng
                        nguoisuamon.tinhtien(mon);
                        
                        System.out.println("da them mon " + mon.getTenmon() + " cho khach hang.");
                    } else {
                        System.out.println("Lua chon khong hop le.");
                    }
                    }
                    break;

                case 2:
    // Xoa mon bang ten
    ArrayList<food> listMonDaChon = nguoisuamon.getSelectedFoods();

    if (listMonDaChon.isEmpty()) {
        System.out.println("Khach hang chua goi mon nao.");
        return;
    }

    while (true) {
        System.out.println("Nhap ten mon muon xoa (hoac nhap 'x' de thoat):");
        String tenmonxoa = scanner.nextLine();
        
        if (tenmonxoa.equalsIgnoreCase("x")) {
            break;  // Thoat vong lap neu nguoi dung nhap "x"
        }

        boolean monFound = false;
        for (int j = 0; j < listMonDaChon.size(); j++) {
            food monxoa = listMonDaChon.get(j);
            if (monxoa.getTenmon().equalsIgnoreCase(tenmonxoa)) {
                listMonDaChon.remove(j);  // Xoa mon khoi danh sach cua khach hang
                nguoisuamon.tinhtienGiam(monxoa);  // Cap nhat so tien sau khi xoa mon
    System.out.println("Da xoa mon " + monxoa.getTenmon() + " khoi danh sach.");
                monFound = true;
                break;  // Thoat vong lap sau khi tim thay va xoa mon
            }
        }

        if (!monFound) {
            System.out.println("Khong tim thay mon co ten: " + tenmonxoa + " trong danh sach.");
        }
    }
    break;

            }

            found = true;
            System.out.println("Thong tin goi mon cua khach hang co ma: " + machinhsua + " da duoc cap nhat.");
            break; // Thoát khỏi vòng lặp sau khi tìm thấy
        }
    }

    if (!found) {
        System.out.println("Khong tim thay khach co ma: " + machinhsua);
    }
}


    
    public static void tongsonguoi(){ //Hàm giúp ta biết hiện tại cửa hàng đã có biêu nhiêu người theo phân loại từng vị trí và khách hàng
    int soquanli = 0, sophucvu = 0, sodaubep = 0, sokhachhang = 0;

    for (int i = 0; i < themnguoi.size(); i++) {
    human nguoi = themnguoi.get(i);
 // ta dùng instanceof để kiểm tra xem đối tượng có thuộc lớp nào đó hay không, nếu thuôc lớp nào thì giá trị tương ứng sẽ cộng thêm 1.
     if (nguoi instanceof quanli) {
            soquanli++;
        } else if (nguoi instanceof phucvu) {
            sophucvu++;
        } else if (nguoi instanceof daubep) {
            sodaubep++;
        } else if (nguoi instanceof customer) {
            sokhachhang++;          
        }
      }

    System.out.println("So luong quan li: " + soquanli);
    System.out.println("So luong phuc vu: " + sophucvu);
    System.out.println("So luong dau bep: " + sodaubep);
    System.out.println("So luong khach hang hang: " + sokhachhang);        
    }
    
public static void indulieuKH(String filename) {
    try (BufferedWriter viet = new BufferedWriter(new FileWriter(filename))) {
        // Ghi thông tin của danh sách người
        for (int i = 0; i < themnguoi.size(); i++) {
            human nguoi = themnguoi.get(i); // Lấy đối tượng tại vị trí i
            if (nguoi instanceof customer){
            viet.write(nguoi.getMa() + "," + nguoi.getName() + "," + nguoi.getGender() + "," + nguoi.getTuoi());
            viet.newLine();}
        }
        System.out.println("Luu thanh cong ra file.");
    } catch (IOException e){
       System.out.println("Co loi xay ra khi luu du lieu: " + e.getMessage());
    }
}

public static void luudulieu(String filename) {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
        // Ghi thông tin của danh sách người
        oos.writeObject(themnguoi);   // Lưu danh sách nhân viên/khách hàng
        oos.writeObject(danhsachmon); // Lưu danh sách món ăn
        System.out.println("Luu du lieu thanh cong ra file object.");
    } catch (IOException e) {
        System.out.println("Co loi xay ra khi luu du lieu object: " + e.getMessage());
    }
}

public static void docdulieu(String filename) {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
        // Đọc danh sách người
        themnguoi = (ArrayList<human>) ois.readObject();
        // Đọc danh sách món ăn
        danhsachmon = (ArrayList<food>) ois.readObject();
        System.out.println("Doc du lieu thanh cong tu file object.");
    } catch (IOException | ClassNotFoundException e) {
        System.out.println("Co loi xay ra khi doc du lieu object: " + e.getMessage());
    }
}
    
public static void hienthiluachon() {
    System.out.println("                  ______________________________________________________________________");
            System.out.println("                 /                                                                     /");
            System.out.println("*               /                 + HE THONG QUAN LI NHA HANG +                       /");    
            System.out.println("               /_____________________________________________________________________/");
            System.out.println("              /                                                                     /");
            System.out.println("             /                  1. THEM MON AN VAO MENU.                           /");
            System.out.println("            /                   2. XOA MON AN KHOI MENU.                .         /");
            System.out.println("           /                      3. HIEN THI MENU.                              /");
            System.out.println("          /                 4. SUA THONG TIN MON AN TRONG MENU.                 /");
            System.out.println("         /                                                                     /");
            System.out.println("        /                 5. NHAP THEM NHAN VIEN HOAC KHACH HANG.             /");
            System.out.println("       /                  6. HIEN THI SO NHAN VIEN VA KHACH HANG.            /");
            System.out.println("      /__                   7. TIM NHAN VIEN HOAC KHACH HANG.               /__");
            System.out.println("         /                  8. XOA NHANN VIEN HOAC KHACH HANG.  .             /");     
            System.out.println("        /                 9. SUA THONG TIN NHAN VIEN HOAC KHACH HANG.        /");
            System.out.println("       /                       10. SUA ORDER CUA KHACH HANG.                /");
            System.out.println("      /                             11. DOANH THU.                         /");
            System.out.println("     /                     12. IN THONG TIN KHACH HANG RA FILE TXT.       /");
            System.out.println("    /                                                                    /");
            System.out.println("   /                               13. LUU DU LIEU                      /");
            System.out.println("  /                                14.DOC DU LIEU            .         /");
            System.out.println(" /                                    15.Thoat                        /");
            System.out.println("/____________________________________________________________________/");
}

public static void duaraluachon(int luachon) {
   switch (luachon) {
                case 1:
                    addnewfood(); 
                    break;
                case 2:
                    xoamon();
                    break;
                case 3:
                    hienthimenu();
                    break;
                case 4:                
                    suamenu();
                    break;
                case 5:
                    nhapnguoi();
                    break;
                case 6:                
                    tongsonguoi();
                    break;
                case 7:                
                    timnguoi();
                    break;
                case 8:                
                    xoanguoi();
                    break;    
                case 9:                
                    suanguoi();
                    break;  
                case 10:                
                    suamondadat();
                    break;  
                case 11:                
                    doanhthu();
                    break;  
                case 12:
                    indulieuKH("Luudulieu.TXT");
                    break;
                 case 13:
                   luudulieu("dulieu.txt");
                    break;
                 case 14:
                   docdulieu("dulieu.txt");
                    break;
                case 15:
                    System.out.println("Thoat khoi chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le! Vui long nhap lai.");
            }
}
    
    
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int luachon;
    do {
        hienthiluachon();
        System.out.print("# Nhap lua chon cua ban: ");
        luachon = scanner.nextInt();
        scanner.nextLine();
        duaraluachon(luachon);
    } while (luachon != 15);
    scanner.close();
  }
}