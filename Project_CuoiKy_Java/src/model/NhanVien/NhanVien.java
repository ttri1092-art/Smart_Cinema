package model.NhanVien;

public class NhanVien {
    private String maNV;
    private String hoTen;
    private String ngaySinh;
    private String diaChi;
    private String sdt;
    private String maNhomNV;

    public NhanVien(String maNV, String hoTen, String ngaySinh, String diaChi, String sdt, String maNhomNV) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.maNhomNV = maNhomNV;
    }

    public String getMaNV() { return maNV; }
    public void setMaNV(String maNV) { this.maNV = maNV; }
    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }
    public String getNgaySinh() { return ngaySinh; }
    public void setNgaySinh(String ngaySinh) { this.ngaySinh = ngaySinh; }
    public String getDiaChi() { return diaChi; }
    public void setDiaChi(String diaChi) { this.diaChi = diaChi; }
    public String getSdt() { return sdt; }
    public void setSdt(String sdt) { this.sdt = sdt; }
    public String getMaNhomNV() { return maNhomNV; }
    public void setMaNhomNV(String maNhomNV) { this.maNhomNV = maNhomNV; }
}