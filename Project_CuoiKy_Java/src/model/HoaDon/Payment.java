package model.HoaDon;

import model.Enum.PhuongThucThanhToanEnum;
import model.Enum.TrangThaiGiaoDichEnum;

public class Payment {
    private String maThanhToan;
    private String ngayLap;
    private double tongTien;
    private PhuongThucThanhToanEnum phuongThuc;
    private TrangThaiGiaoDichEnum trangThai;
    private String maHoaDon;

    public Payment(String maThanhToan, String ngayLap, double tongTien,
                   PhuongThucThanhToanEnum phuongThuc, TrangThaiGiaoDichEnum trangThai, String maHoaDon) {
        this.maThanhToan = maThanhToan;
        this.ngayLap = ngayLap;
        this.tongTien = tongTien;
        this.phuongThuc = phuongThuc;
        this.trangThai = trangThai;
        this.maHoaDon = maHoaDon;
    }

    /**
     * Phương thức in riêng chi tiết giao dịch thanh toán
     */
    public void inThongTinThanhToan() {
        System.out.println("---------- THÔNG TIN THANH TOÁN (PAYMENT) ----------");
        System.out.println(" Mã giao dịch    : " + this.maThanhToan);
        System.out.println(" Thời gian GD    : " + this.ngayLap);
        System.out.println(" Phương thức     : " + this.phuongThuc);
        System.out.println(" Số tiền đã trả  : " + String.format("%,.0f", this.tongTien) + " VNĐ");
        System.out.println(" Trạng thái GD   : " + this.trangThai);
        System.out.println("----------------------------------------------------");
    }

    // Getters & Setters
    public String getMaThanhToan() { return maThanhToan; }
    public void setMaThanhToan(String maThanhToan) { this.maThanhToan = maThanhToan; }

    public String getNgayLap() { return ngayLap; }
    public void setNgayLap() { this.ngayLap = ngayLap; }

    public double getTongTien() { return tongTien; }
    public void setTongTien(double tongTien) { this.tongTien = tongTien; }

    public PhuongThucThanhToanEnum getPhuongThuc() { return phuongThuc; }
    public void setPhuongThuc(PhuongThucThanhToanEnum phuongThuc) { this.phuongThuc = phuongThuc; }

    public TrangThaiGiaoDichEnum getTrangThai() { return trangThai; }
    public void setTrangThai(TrangThaiGiaoDichEnum trangThai) { this.trangThai = trangThai; }

    public String getMaHoaDon() { return maHoaDon; }
    public void setMaHoaDon(String maHoaDon) { this.maHoaDon = maHoaDon; }
}