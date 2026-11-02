using System.Collections.Generic;
using data;
using model;

namespace DAO
{
    public class PhimDAO { public static List<Phim> layTatCa() { return CinemaDatabase.danhSachPhim; } }
    public class NhomPhimDAO { public static List<NhomPhim> layTatCa() { return CinemaDatabase.danhSachNhomPhim; } }
    public class LoaiVeDAO { public static List<LoaiVe> layTatCa() { return CinemaDatabase.danhSachLoaiVe; } }
    public class RapDAO { public static List<Rap> layTatCa() { return CinemaDatabase.danhSachRap; } }
    public class GheDAO { public static List<Ghe> layTatCa() { return CinemaDatabase.danhSachGhe; } }
    public class DatVeDAO { public static List<DatVe> layTatCa() { return CinemaDatabase.danhSachDatVe; } }
    public class VeDAO { public static List<Ve> layTatCa() { return CinemaDatabase.danhSachVe; } }
    public class ChiTietDatVeDAO { public static List<ChiTietDatVe> layTatCa() { return CinemaDatabase.danhSachChiTietDatVe; } }
    public class LoaiKhachHangDAO { public static List<LoaiKhachHang> layTatCa() { return CinemaDatabase.danhSachLoaiKhachHang; } }
    public class KhachHangDAO { public static List<KhachHang> layTatCa() { return CinemaDatabase.danhSachKhachHang; } }
    public class NhanVienDAO { public static List<NhanVien> layTatCa() { return CinemaDatabase.danhSachNhanVien; } }
    public class CalamViecDAO { public static List<CalamViec> layTatCa() { return CinemaDatabase.danhSachCalamViec; } }
    public class QuanlyCalamviecDAO { public static List<QuanlyCalamviec> layTatCa() { return CinemaDatabase.danhSachQuanlyCalamviec; } }
    public class HoaDonDAO { public static List<HoaDon> layTatCa() { return CinemaDatabase.danhSachHoaDon; } }
    public class PaymentDAO { public static List<Payment> layTatCa() { return CinemaDatabase.danhSachPayment; } }
}