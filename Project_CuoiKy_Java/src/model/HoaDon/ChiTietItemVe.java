package model.HoaDon;

import model.Phim.Phim;
import model.Phim.NhomPhim;
import model.Ticket.LoaiVe;


public class ChiTietItemVe {
    private Phim phim;
    private NhomPhim nhomPhim;
    private LoaiVe loaiVe;
    private double giaGoc;
    private double phuPhi;
    private double giamGiaVe;
    private double giamGiaKhachHang;
    private double thanhTien;

    public ChiTietItemVe(Phim phim, NhomPhim nhomPhim, LoaiVe loaiVe,
                         double giaGoc, double phuPhi, double giamGiaVe,
                         double giamGiaKhachHang, double thanhTien) {
        this.phim = phim;
        this.nhomPhim = nhomPhim;
        this.loaiVe = loaiVe;
        this.giaGoc = giaGoc;
        this.phuPhi = phuPhi;
        this.giamGiaVe = giamGiaVe;
        this.giamGiaKhachHang = giamGiaKhachHang;
        this.thanhTien = thanhTien;
    }

    public Phim getPhim() { return phim; }
    public NhomPhim getNhomPhim() { return nhomPhim; }
    public LoaiVe getLoaiVe() { return loaiVe; }
    public double getGiaGoc() { return giaGoc; }
    public double getPhuPhi() { return phuPhi; }
    public double getGiamGiaVe() { return giamGiaVe; }
    public double getGiamGiaKhachHang() { return giamGiaKhachHang; }
    public double getThanhTien() { return thanhTien; }
}