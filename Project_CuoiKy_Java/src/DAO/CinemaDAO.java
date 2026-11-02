package DAO;

import java.util.List;
import data.CinemaDatabase;
import model.HoaDon.HoaDon;
import model.HoaDon.Payment;
import model.KhachHang.KhachHang;
import model.KhachHang.LoaiKhachHang;
import model.NhanVien.CalamViec;
import model.NhanVien.NhanVien;
import model.NhanVien.QuanlyCalamviec;
import model.Phim.NhomPhim;
import model.Phim.Phim;
import model.Ticket.ChiTietDatVe;
import model.Ticket.DatVe;
import model.Ticket.Ghe;
import model.Ticket.LoaiVe;
import model.Ticket.Rap;
import model.Ticket.Ve;

public class CinemaDAO {
    public static class PhimDAO { public static List<Phim> layTatCa() { return CinemaDatabase.danhSachPhim; } }
    public static class NhomPhimDAO { public static List<NhomPhim> layTatCa() { return CinemaDatabase.danhSachNhomPhim; } }
    public static class LoaiVeDAO { public static List<LoaiVe> layTatCa() { return CinemaDatabase.danhSachLoaiVe; } }
    public static class RapDAO { public static List<Rap> layTatCa() { return CinemaDatabase.danhSachRap; } }
    public static class GheDAO { public static List<Ghe> layTatCa() { return CinemaDatabase.danhSachGhe; } }
    public static class DatVeDAO { public static List<DatVe> layTatCa() { return CinemaDatabase.danhSachDatVe; } }
    public static class VeDAO { public static List<Ve> layTatCa() { return CinemaDatabase.danhSachVe; } }
    public static class ChiTietDatVeDAO { public static List<ChiTietDatVe> layTatCa() { return CinemaDatabase.danhSachChiTietDatVe; } }
    public static class LoaiKhachHangDAO { public static List<LoaiKhachHang> layTatCa() { return CinemaDatabase.danhSachLoaiKhachHang; } }
    public static class KhachHangDAO { public static List<KhachHang> layTatCa() { return CinemaDatabase.danhSachKhachHang; } }
    public static class NhanVienDAO { public static List<NhanVien> layTatCa() { return CinemaDatabase.danhSachNhanVien; } }
    public static class CalamViecDAO { public static List<CalamViec> layTatCa() { return CinemaDatabase.danhSachCalamViec; } }
    public static class QuanlyCalamviecDAO { public static List<QuanlyCalamviec> layTatCa() { return CinemaDatabase.danhSachQuanlyCalamviec; } }
    public static class HoaDonDAO { public static List<HoaDon> layTatCa() { return CinemaDatabase.danhSachHoaDon; } }
    public static class PaymentDAO { public static List<Payment> layTatCa() { return CinemaDatabase.danhSachPayment; } }
}