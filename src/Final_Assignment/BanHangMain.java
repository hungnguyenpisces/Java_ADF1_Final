package Final_Assignment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class BanHangMain {
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    static ClearConsole screen = new ClearConsole();
    static Scanner sc = new Scanner(System.in);

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        demoNhomHang();
        demoSanPham();
        demoDonHang();

        String confirm = "";
        boolean isError = false;
        do {
            try {
                isError = false;
                screen.clear();
                mainMenu();
                System.out.println("Nhap lua chon: ");
                int menu0 = sc.nextInt();
                switch (menu0) {
                case 1: // crud nhom hang
                    screen.clear();
                    int menu1;
                    do {
                        crudNhomHang();
                        System.out.println("Nhap lua chon: ");
                        menu1 = sc.nextInt();
                        switch (menu1) {
                        case 1:// tao nhom hang
                            System.out.println("----------Tao nhom hang----------");
                            nhd.taoNhomHang();
                            break;
                        case 2: // show nhom hang
                            System.out.println("----------Danh sach nhom hang----------");
                            nhd.showDsNhomHang();
                            break;
                        case 3: // tim kiem nhom hang
                            System.out.println("----------Tim kiem nhom hang----------");
                            sc.nextLine();
                            System.out.println("Nhap ma nhom hang can tim: ");
                            String maNH = sc.nextLine();
                            int index = nhd.timNhomHangTuMa(maNH);
                            if (index == -1) {
                                System.out.println("Ma nhom hang nhap sai.");
                            } else if (index == -2) {
                                System.out.println("Khong tim thay nhom hang");
                            } else {
                                System.out.println(nhd.getDsNhomHang().get(index));
                            }
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Lua chon khong hop le");
                            break;
                        }
                        if (menu1 == 4) {
                            break;
                        }
                    } while (menu1 != 4);
                    break;
                case 2: // crud san pham
                    screen.clear();
                    int menu2;
                    do {
                        crudSanPham();
                        System.out.println("Nhap lua chon: ");
                        menu2 = sc.nextInt();
                        int index = -1;
                        String maSP = "";
                        switch (menu2) {
                        case 1: // tao san pham
                            System.out.println("----------Tao san pham----------");
                            spd.taoSanPham(nhd);
                            break;
                        case 2: // show san pham
                            System.out.println("----------Danh sach san pham----------");
                            spd.showDsSanPham();
                            break;
                        case 3: // tim kiem san pham theo ma
                            System.out.println("----------Tim kiem san pham----------");
                            sc.nextLine();
                            System.out.println("Nhap ma san pham can tim: ");
                            maSP = sc.nextLine();
                            index = spd.timSanPhamTuMa(maSP);
                            if (index == -1) {
                                System.out.println("Ma san pham nhap sai.");
                            } else if (index == -2) {
                                System.out.println("Khong tim thay san pham");
                            } else {
                                System.out.println(spd.getDsSanPham().get(index).toDetail());
                            }
                            break;
                        case 4: // tim kiem nhom hang tu ma san pham
                            System.out.println("----------Tim kiem nhom hang tu ma san pham----------");
                            sc.nextLine();
                            System.out.println("Nhap ma san pham can tim Nhom Hang: ");
                            maSP = sc.nextLine();
                            index = spd.timSanPhamTuMa(maSP);
                            if (index == -1) {
                                System.out.println("Ma san pham nhap sai.");
                            } else if (index == -2) {
                                System.out.println("Khong tim thay nhom hang nao tu ma vua nhap.");
                            } else {
                                String maNH = spd.getDsSanPham().get(index).getNhomHang().getMaNhomHang();
                                index = nhd.timNhomHangTuMa(maNH);
                                System.out.println(nhd.getDsNhomHang().get(index));
                            }
                            break;
                        case 5: // sua san pham
                            System.out.println("----------Update san pham----------");
                            sc.nextLine();
                            System.out.println("Nhap ma san pham can sua thong tin: ");
                            maSP = sc.nextLine();
                            spd.updateSanPham(maSP, nhd);
                            break;
                        case 6:
                            break;
                        default:
                            System.out.println("Lua chon khong hop le");
                            break;
                        }
                        if (menu2 == 6) {
                            break;
                        }
                    } while (menu2 != 6);
                    break;
                case 3: // crud don hang
                    screen.clear();
                    int menu3;
                    do {
                        crudDonHang();
                        System.out.println("Nhap lua chon: ");
                        menu3 = sc.nextInt();
                        switch (menu3) {
                        case 1: // tao don hang
                            System.out.println("----------Tao don hang----------");
                            dhd.taoDonHang(spd);
                            break;
                        case 2: // show all don hang cua ca nam
                            System.out.println("----------Danh sach don hang----------");
                            dhd.showDsDonHang();
                            break;
                        case 3: // show don hang theo thang
                            System.out.println("----------Danh sach don hang theo thang----------");
                            sc.nextLine();
                            System.out.println("Nhap thang muon xem danh sach don hang:");
                            int thang = sc.nextInt();
                            if (thang < 1 || thang > 12) {
                                System.out.println("Thang nhap sai.");
                            } else {
                                dhd.showDsDonHangTheoThang(thang);
                            }
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Lua chon khong hop le");
                            break;
                        }
                        if (menu3 == 4) {
                            break;
                        }
                    } while (menu3 != 4);
                    break;
                case 4: // thong ke
                    screen.clear();
                    int menu4;
                    do {
                        baoCao();
                        System.out.println("Nhap lua chon: ");
                        menu4 = sc.nextInt();
                        int thang = 0;
                        switch (menu4) {
                        case 1:// bao cao daonh so ca nam
                            System.out.println("----------Bao cao doanh so ca nam----------");
                            int tongSoDonHang = dhd.getDsDonHang().size();
                            int tongSPCaNam = 0;
                            float tongDoanhSoCaNam = 0;
                            for (int i = 0; i < dhd.getDsDonHang().size(); i++) {

                                DonHang dh = dhd.getDsDonHang().get(i);
                                tongSPCaNam += dh.getDsSanPham().size();
                                for (int j = 0; j < dh.getDsSanPham().size(); j++) {
                                    SanPham sp = dh.getDsSanPham().get(j);
                                    tongDoanhSoCaNam += sp.getGiaBan();
                                }
                            }
                            System.out.println("Tong so don hang da ban trong nam: " + tongSoDonHang);
                            System.out.println("Tong so san pham da ban trong nam: " + tongSPCaNam);
                            System.out.println("Tong doanh so ca nam: " + tongDoanhSoCaNam);
                            break;
                        case 2:// bao ca doanh so theo thang
                            System.out.println("----------Bao cao doanh so theo thang----------");
                            sc.nextLine();
                            System.out.println("Nhap thang muon xem bao cao: ");
                            thang = sc.nextInt();
                            if (thang < 1 || thang > 12) {
                                System.out.println("Thang nhap sai.");
                            } else {
                                int tongDongHangThang = 0;
                                int tongSPThang = 0;
                                float tongDoanhSoThang = 0;
                                for (int i = 0; i < dhd.getDsDonHang().size(); i++) {
                                    DonHang dh = dhd.getDsDonHang().get(i);
                                    if (dh.getNgayMuaHang().getMonth() + 1 == thang) {
                                        tongDongHangThang++;
                                        tongSPThang += dh.getDsSanPham().size();
                                        for (int j = 0; j < dh.getDsSanPham().size(); j++) {
                                            SanPham sp = dh.getDsSanPham().get(j);
                                            tongDoanhSoThang += sp.getGiaBan();
                                        }
                                    }
                                }
                                System.out.println("Tong so don hang da ban trong thang: " + thang + ": " + tongDongHangThang);
                                System.out.println("Tong so san pham da ban trong thang " + thang + ": " + tongSPThang);
                                System.out.println("Tong doanh so tien hang " + thang + ": " + tongDoanhSoThang);
                            }
                            break;
                        case 3:// top 3 san pham ban chay nhat
                            System.out.println("----------Top 3 san pham ban chay nhat----------");
                            sc.nextLine();
                            ArrayList<SanPhamTop> dsSpTop = new ArrayList<>();
                            System.out.println("Nhap thang can show top 3 SP ban chay:");
                            thang = sc.nextInt();
                            if (thang < 1 || thang > 12) {
                                System.out.println("Thang nhap sai.");
                            } else {
                                for (int i = 0; i < dhd.getDsDonHang().size(); i++) {
                                    DonHang dh = dhd.getDsDonHang().get(i);
                                    if (dh.getNgayMuaHang().getMonth() + 1 == thang) {
                                        for (int j = 0; j < dh.getDsSanPham().size(); j++) {
                                            SanPham sp = dh.getDsSanPham().get(j);

                                            if (dsSpTop.size() == 0) {
                                                dsSpTop.add(new SanPhamTop(sp, 1));
                                            } else {
                                                boolean isFound = false;
                                                for (int k = 0; k < dsSpTop.size(); k++) {
                                                    if (dsSpTop.get(k).sanPham.getMaSanPham()
                                                            .equals(sp.getMaSanPham())) {
                                                        dsSpTop.get(k).soLuong++;
                                                        isFound = true;
                                                    }
                                                }
                                                if (!isFound) {
                                                    dsSpTop.add(new SanPhamTop(sp, 1));
                                                }
                                            }
                                        }
                                    }
                                }

                                Collections.sort(dsSpTop, new Comparator<SanPhamTop>() {
                                    @Override
                                    public int compare(SanPhamTop o1, SanPhamTop o2) {
                                        return o2.soLuong - o1.soLuong;
                                    }
                                });
                                System.out.println(
                                        "-----------TOP 3 SAN PHAM BAN CHAY NHAT THANG " + thang + "-----------");
                                for (int i = 0; i < 3; i++) {
                                    System.out.println(dsSpTop.get(i));
                                }
                            }
                            System.out
                                    .println("----------Doi chieu ket qua voi danh sach thang " + thang + "----------");
                            for (SanPhamTop sanPhamTop : dsSpTop) {
                                System.out.println(sanPhamTop);
                            }
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Lua chon khong hop le");
                            break;
                        }
                        if (menu4 == 4) {
                            break;
                        }
                    } while (menu4 != 4);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Lua chon khong hop le");
                    break;
                }
                if (menu0 == 5) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Lua chon khong hop le");
                isError = true;
            }
            sc.nextLine();
            System.out.println("Ban co muon tiep tuc? (n = no)");
            confirm = sc.nextLine();
        } while (!"n".equalsIgnoreCase(confirm) || isError);
    }

    public static void mainMenu() {
        System.out.println("---------MAIN MENU---------");
        System.out.println("1. CRUD Nhom Hang.");
        System.out.println("2. CRUD San Pham.");
        System.out.println("3. CRUD Don Hang.");
        System.out.println("4. Bao Cao.");
        System.out.println("5. Thoat.");
    }

    public static void crudNhomHang() {
        System.out.println("---------CRUD NHOM HANG---------");
        System.out.println("1. Them Nhom Hang.");
        System.out.println("2. Show DS Nhom Hang.");
        System.out.println("3. Tim Nhom Hang.");
        System.out.println("4. <-Back to MAIN MENU.");
    }

    public static void crudSanPham() {
        System.out.println("---------CRUD SAN PHAM---------");
        System.out.println("1. Them San Pham.");
        System.out.println("2. Show DS San Pham.");
        System.out.println("3. Tim San pham Theo Ma San Pham.");
        System.out.println("4. Tim Nhom Hang Theo Ma San Pham.");
        System.out.println("5. Sua Thong tin San Pham.");
        System.out.println("6. <-Back to MAIN MENU.");
    }

    public static void crudDonHang() {
        System.out.println("---------CRUD DON HANG---------");
        System.out.println("1. Them Don Hang.");
        System.out.println("2. Show All DS Don Hang.");
        System.out.println("3. Show DS Don Hang theo thang.");
        System.out.println("4. <-Back to MAIN MENU.");
    }

    public static void baoCao() {
        System.out.println("---------BAO CAO---------");
        System.out.println("1. Bao Cao doanh so ca nam.");
        System.out.println("2. Bao Cao doanh so theo thang.");
        System.out.println("3. Bao Cao Top 3 san pham ban chay theo thang.");
        System.out.println("4. <-Back to MAIN MENU.");
    }

    // Data demo
    static NhomHangDAO nhd = new NhomHangDAO();

    public static void demoNhomHang() {
        nhd.taoNhomHang(new NhomHang("1qaz", "nhom hang 1", 0.11F));
        nhd.taoNhomHang(new NhomHang("2wsx", "nhom hang 2", 0.12F));
        nhd.taoNhomHang(new NhomHang("3edc", "nhom hang 3", 0.13F));
        nhd.taoNhomHang(new NhomHang("4rfv", "nhom hang 4", 0.14F));
        nhd.taoNhomHang(new NhomHang("5tgb", "nhom hang 5", 0.15F));
        nhd.taoNhomHang(new NhomHang("6yhn", "nhom hang 6", 0.16F));
        nhd.taoNhomHang(new NhomHang("7ujm", "nhom hang 7", 0.16F));
        nhd.taoNhomHang(new NhomHang("0okm", "nhom hang 8", 0.15F));
        nhd.taoNhomHang(new NhomHang("9ijn", "nhom hang 9", 0.14F));
        nhd.taoNhomHang(new NhomHang("8uhb", "nhom hang 10", 0.13F));
        nhd.taoNhomHang(new NhomHang("7ygv", "nhom hang 11", 0.12F));
        nhd.taoNhomHang(new NhomHang("6tfc", "nhom hang 12", 0.11F));
    }

    static SanPhamDAO spd = new SanPhamDAO();

    public static void demoSanPham() {
        for (int i = 0; i < 12; i++) {
            NhomHang nh = nhd.getDsNhomHang().get(i);
            for (int j = 0; j < 3; j++) {
                spd.taoSanPham(new SanPham(nh, "SP demo" + (i + j), "mo ta sp" + (i + j), i + j + 100, i + j + 101));
            }
        }
    }

    static DonHangDAO dhd = new DonHangDAO();

    public static void demoDonHang() {
        for (int i = 0; i < 12; i++) {
            ArrayList<SanPham> dssp1 = new ArrayList<SanPham>();
            ArrayList<SanPham> dssp2 = new ArrayList<SanPham>();
            ArrayList<SanPham> dssp3 = new ArrayList<SanPham>();
            ArrayList<SanPham> dssp4 = new ArrayList<SanPham>();
            ArrayList<SanPham> dssp5 = new ArrayList<SanPham>();
            for (int j = 0; j < 6; j++) {
                dssp1.add(spd.getDsSanPham().get((int) (Math.random() * 36)));
                dssp2.add(spd.getDsSanPham().get((int) (Math.random() * 36)));
                dssp3.add(spd.getDsSanPham().get((int) (Math.random() * 36)));
                dssp4.add(spd.getDsSanPham().get((int) (Math.random() * 36)));
                dssp5.add(spd.getDsSanPham().get((int) (Math.random() * 36)));
            }
            try {
                dhd.taoDonHangDemo(new DonHang("KH demo" + ((int) (Math.random() * 60)),sdf.parse(((int) (Math.random() * 28) + 1) + "/" + (12 - i) + "/2021"), dssp1));
                dhd.taoDonHangDemo(new DonHang("KH demo" + ((int) (Math.random() * 60)),sdf.parse(((int) (Math.random() * 28) + 1) + "/" + (12 - i) + "/2021"), dssp2));
                dhd.taoDonHangDemo(new DonHang("KH demo" + ((int) (Math.random() * 60)),sdf.parse(((int) (Math.random() * 28) + 1) + "/" + (12 - i) + "/2021"), dssp3));
                dhd.taoDonHangDemo(new DonHang("KH demo" + ((int) (Math.random() * 60)),sdf.parse(((int) (Math.random() * 28) + 1) + "/" + (12 - i) + "/2021"), dssp4));
                dhd.taoDonHangDemo(new DonHang("KH demo" + ((int) (Math.random() * 60)),sdf.parse(((int) (Math.random() * 28) + 1) + "/" + (12 - i) + "/2021"), dssp5));
            } catch (ParseException e) {
            }
        }
    }

}
