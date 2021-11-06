package Final_Assignment;

import java.util.ArrayList;
import java.util.Scanner;

public class SanPhamDAO {
    private ArrayList<SanPham> dsSanPham;
    Scanner sc = new Scanner(System.in);

    public SanPhamDAO() {
        this.dsSanPham = new ArrayList<SanPham>();
    }

    public ArrayList<SanPham> getDsSanPham() {
        return this.dsSanPham;
    }

    public void setDsSanPham(ArrayList<SanPham> dsSanPham) {
        this.dsSanPham = dsSanPham;
    }

    public void taoSanPham(NhomHangDAO nhd) {
        System.out.println("----------DS nhom hang----------: ");
        nhd.showDsNhomHang();
        System.out.println("Ban muon them SP vao nhom hang nao? nhap ma: ");
        String maNH = sc.nextLine();
        int index = nhd.timNhomHangTuMa(maNH);
        if (index == -1) {
            System.out.println("MA NHOM HANG NHAP SAI");
        } else if (index == -2) {
            System.out.println("NHOM HANG KHONG TON TAI");
        } else {
            NhomHang nh = nhd.getDsNhomHang().get(index);
            SanPham sp = new SanPham();
            sp.nhapSanPham(nh);
            this.dsSanPham.add(sp);
        }
    }

    public void taoSanPham(SanPham sp) {
        this.dsSanPham.add(sp);
    }

    // tim tu danh sach va tra ve index
    public int timSanPhamTuMa(String maSP) {
        if (maSP == null || maSP.length() != 8) {
            return -1;
            // ma sp ko dung
        } else {
            for (int i = 0; i < this.dsSanPham.size(); i++) {
                if (this.dsSanPham.get(i).getMaSanPham().equalsIgnoreCase(maSP)) {
                    return i;
                }
            }
        }
        return -2;
        // ko tim thay hoac ko ton tai
    }

    public void showDsSanPham() {
        for (SanPham sanPham : this.dsSanPham) {
            System.out.println(sanPham.toList());
        }
    }

    public void updateSanPham(String maSP, NhomHangDAO nhd) {
        if (maSP == null || maSP.length() != 8) {
            System.out.println("MA SAN PHAM KHONG DUNG");
        } else {
            int index = this.timSanPhamTuMa(maSP);
            if (index == -2) {
                System.out.println("KHONG TIM THAY SAN PHAM");
            } else {
                System.out.println("----------DS nhom hang----------: ");
                nhd.showDsNhomHang();
                System.out.println("Chon nhom hang moi cho San Pham? nhap ma: ");
                String maNH = sc.nextLine();
                int indexNH = nhd.timNhomHangTuMa(maNH);
                if (indexNH == -1) {
                    System.out.println("MA NHOM HANG NHAP SAI");
                } else if (indexNH == -2) {
                    System.out.println("NHOM HANG KHONG TON TAI");
                } else {
                    NhomHang nh = nhd.getDsNhomHang().get(indexNH);
                    SanPham sp = this.dsSanPham.get(index);
                    sp.capNhatSanPham(nh, sp);
                    this.dsSanPham.set(index, sp);
                    if (this.dsSanPham.set(index, sp) == null) {
                        System.out.println("Cap nhat san pham THAT BAI!");
                    } else {
                        System.out.println("Cap nhat san pham THANH CONG!");
                    }
                }
            }
        }
    }
}
