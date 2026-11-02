package model.KhachHang;

public class LoaiKhachHang {
    private String maLoaiKhachHang;
    private String noiDung;
    private double tyLeGiamGia; // Thêm thuộc tính tỷ lệ giảm giá (vd: 0.05 = giảm 5%)

    public LoaiKhachHang(String maLoaiKhachHang, String noiDung, double tyLeGiamGia) {
        this.maLoaiKhachHang = maLoaiKhachHang;
        this.noiDung = noiDung;
        this.tyLeGiamGia = tyLeGiamGia;
    }

    public String getMaLoaiKhachHang() { return maLoaiKhachHang; }
    public String getNoiDung() { return noiDung; }
    public double getTyLeGiamGia() { return tyLeGiamGia; }
    public void setTyLeGiamGia(double tyLeGiamGia) { this.tyLeGiamGia = tyLeGiamGia; }
}