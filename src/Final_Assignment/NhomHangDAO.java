package Final_Assignment;

import java.util.ArrayList;
import java.util.Scanner;

public class NhomHangDAO {
    private ArrayList<NhomHang> dsNhomHang;
    Scanner sc = new Scanner(System.in);

    public NhomHangDAO() {
        this.dsNhomHang = new ArrayList<NhomHang>();
    }

    public ArrayList<NhomHang> getDsNhomHang() {
        return this.dsNhomHang;
    }

    public void setDsNhomHang(ArrayList<NhomHang> dsNhomHang) {
        this.dsNhomHang = dsNhomHang;
    }

    public void taoNhomHang() {
        String maNH = "";
        do {
            System.out.println("Nhap ma nhom hang (4 char & no space): ");
            maNH = sc.nextLine();
        } while (maNH.length() != 4 || maNH.contains(" "));

        int index = this.timNhomHangTuMa(maNH);
        if (index >= 0) {
            System.out.println("MA NHOM HANG DA TON TAI");
        } else {
            NhomHang nh = new NhomHang();
            nh.nhapNhomHang(maNH);
            this.dsNhomHang.add(nh);
        }
    }

    public void taoNhomHang(NhomHang nhomHang) {
        this.dsNhomHang.add(nhomHang);
    }

    public void showDsNhomHang() {
        for (NhomHang nh : this.dsNhomHang) {
            System.out.println(nh.toString());
        }
    }

    public int timNhomHangTuMa(String maNH) {
        if (maNH == null || maNH.length() != 4) {
            return -1; // ma nhom hang khong dung
        } else {
            for (int i = 0; i < this.dsNhomHang.size(); i++) {
                if (this.dsNhomHang.get(i).getMaNhomHang().equalsIgnoreCase(maNH)) {
                    return i;
                }
            }
        }
        return -2; // nhom hang khong ton tai
    }
}
