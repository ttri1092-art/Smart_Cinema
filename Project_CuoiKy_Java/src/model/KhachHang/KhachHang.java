package model.KhachHang;

public class KhachHang {
    private String maKhachHang;
    private String hoTen;
    private String ngaySinh;
    private String diaChi;
    private String sdt;
    private String email;
    private String maLoaiKhachHang;

    public KhachHang(String maKhachHang, String hoTen, String ngaySinh, String diaChi, String sdt, String email, String maLoaiKhachHang) {
        this.maKhachHang = maKhachHang;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
        this.maLoaiKhachHang = maLoaiKhachHang;
    }

    public String getMaKhachHang() { return maKhachHang; }
    public void setMaKhachHang(String maKhachHang) { this.maKhachHang = maKhachHang; }
    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }
    public String getNgaySinh() { return ngaySinh; }
    public void setNgaySinh(String ngaySinh) { this.ngaySinh = ngaySinh; }
    public String getDiaChi() { return diaChi; }
    public void setDiaChi(String diaChi) { this.diaChi = diaChi; }
    public String getSdt() { return sdt; }
    public void setSdt(String sdt) { this.sdt = sdt; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getMaLoaiKhachHang() { return maLoaiKhachHang; }
    public void setMaLoaiKhachHang(String maLoaiKhachHang) { this.maLoaiKhachHang = maLoaiKhachHang; }
}