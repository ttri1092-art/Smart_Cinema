package model.Ticket;

public class DatVe {
    private String maDatVe;
    private String ngayDat;
    private double tongTien;
    private String maHoaDon; // Khóa ngoại liên kết HoaDon

    // Cập nhật Constructor thêm maHoaDon
    public DatVe(String maDatVe, String ngayDat, double tongTien, String maHoaDon) {
        this.maDatVe = maDatVe;
        this.ngayDat = ngayDat;
        this.tongTien = tongTien;
        this.maHoaDon = maHoaDon;
    }

    public String getMaDatVe() { return maDatVe; }
    public void setMaDatVe(String maDatVe) { this.maDatVe = maDatVe; }
    public String getNgayDat() { return ngayDat; }
    public void setNgayDat(String ngayDat) { this.ngayDat = ngayDat; }
    public double getTongTien() { return tongTien; }
    public void setTongTien(double tongTien) { this.tongTien = tongTien; }

    // Getter/Setter cho khóa ngoại
    public String getMaHoaDon() { return maHoaDon; }
    public void setMaHoaDon(String maHoaDon) { this.maHoaDon = maHoaDon; }
}