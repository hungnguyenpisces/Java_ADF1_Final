package Final_Assignment;

public class SanPhamTop {

    public SanPham sanPham;
    public int soLuong;

    public SanPhamTop() {
        super();
    }

    public SanPhamTop(SanPham sanPham, int soLuong) {
        super();
        this.sanPham = sanPham;
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "San pham: " + this.sanPham.toList() + " - So luong: " + this.soLuong;
    }

}
