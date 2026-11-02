package data;

import java.util.ArrayList;
import java.util.List;

import model.Enum.LoaiGheEnum;
import model.Enum.PhuongThucThanhToanEnum;
import model.Enum.TrangThaiGiaoDichEnum;
import model.HoaDon.HoaDon;
import model.HoaDon.Payment;
import model.KhachHang.KhachHang;
import model.KhachHang.LoaiKhachHang;
import model.NhanVien.CalamViec;
import model.NhanVien.NhanVien;
import model.NhanVien.NhomNhanVien;
import model.NhanVien.QuanlyCalamviec;
import model.Phim.NhomPhim;
import model.Phim.Phim;
import model.Ticket.ChiTietDatVe;
import model.Ticket.DatVe;
import model.Ticket.Ghe;
import model.Ticket.LoaiVe;
import model.Ticket.Rap;
import model.Ticket.Ve;

public class CinemaDatabase {

    public static List<NhomPhim> danhSachNhomPhim = new ArrayList<>();
    public static List<Phim> danhSachPhim = new ArrayList<>();
    public static List<LoaiVe> danhSachLoaiVe = new ArrayList<>();
    public static List<Rap> danhSachRap = new ArrayList<>();
    public static List<Ghe> danhSachGhe = new ArrayList<>();
    public static List<DatVe> danhSachDatVe = new ArrayList<>();
    public static List<Ve> danhSachVe = new ArrayList<>();
    public static List<ChiTietDatVe> danhSachChiTietDatVe = new ArrayList<>();
    public static List<LoaiKhachHang> danhSachLoaiKhachHang = new ArrayList<>();
    public static List<KhachHang> danhSachKhachHang = new ArrayList<>();
    public static List<NhomNhanVien> danhSachNhomNhanVien = new ArrayList<>();
    public static List<NhanVien> danhSachNhanVien = new ArrayList<>();
    public static List<CalamViec> danhSachCalamViec = new ArrayList<>();
    public static List<QuanlyCalamviec> danhSachQuanlyCalamviec = new ArrayList<>();
    public static List<HoaDon> danhSachHoaDon = new ArrayList<>();
    public static List<Payment> danhSachPayment = new ArrayList<>();

    static {
        khoiTaoDuLieuMau();
    }

    public static void khoiTaoDuLieuMau() {
        // 1. Nhóm Phim & Phim
        danhSachNhomPhim.add(new NhomPhim("NP01", "Phim 2D", "Tiêu chuẩn", 0.0));
        danhSachNhomPhim.add(new NhomPhim("NP02", "Phim 3D", "Không gian 3D", 35000.0));
        danhSachNhomPhim.add(new NhomPhim("NP03", "Phim IMAX", "Âm thanh vòm IMAX", 60000.0));

        danhSachPhim.add(new Phim("P01", "Doraemon Symphony", "Hoạt hình", 50000.0, "Hay", "NP01"));
        danhSachPhim.add(new Phim("P02", "Avatar: The Way of Water", "Viễn tưởng", 50000.0, "Kỹ xảo", "NP03"));
        danhSachPhim.add(new Phim("P03", "Lật Mặt 7: Một Điều Ước", "Gia đình", 50000.0, "Cảm động", "NP01"));
        danhSachPhim.add(new Phim("P04", "Thám Tử Lừng Danh Conan", "Trinh thám", 50000.0, "Kịch tính", "NP02"));

        // 2. Loại Vé, Rạp & Ghế
        danhSachLoaiVe.add(new LoaiVe("LV01", "Vé Người Lớn", 0.0));
        danhSachLoaiVe.add(new LoaiVe("LV02", "Vé Học Sinh - Sinh Viên", 0.15));
        danhSachLoaiVe.add(new LoaiVe("LV03", "Vé Khách VIP", 0.20));

        danhSachRap.add(new Rap("R01", "Phòng chiếu số 1"));
        danhSachRap.add(new Rap("R02", "Phòng chiếu số 2"));

        danhSachGhe.add(new Ghe("G01", LoaiGheEnum.VIP, "R01"));
        danhSachGhe.add(new Ghe("G02", LoaiGheEnum.VIP, "R01"));
        danhSachGhe.add(new Ghe("G03", LoaiGheEnum.STANDARD, "R01"));
        danhSachGhe.add(new Ghe("G04", LoaiGheEnum.SWEETBOX, "R01"));

        // 3. Khách Hàng & Loại Khách Hàng
        LoaiKhachHang lkhVip = new LoaiKhachHang("LKH03", "Thành Viên Kim Cương", 0.10);
        LoaiKhachHang lkhBac = new LoaiKhachHang("LKH02", "Thành Viên Bạc", 0.05);
        danhSachLoaiKhachHang.add(lkhVip);
        danhSachLoaiKhachHang.add(lkhBac);

        KhachHang kh1 = new KhachHang("KH01", "Trần Minh Trí", "2007-11-17", "TP.HCM", "0901234567", "triminh@gmail.com", "LKH03");
        KhachHang kh2 = new KhachHang("KH02", "Nguyễn Văn An", "2003-05-10", "Bình Dương", "0912345678", "vanan@gmail.com", "LKH02");
        KhachHang kh3 = new KhachHang("KH03", "Đỗ Huy Hoàng", "2001-08-20", "Đồng Nai", "0987654321", "huyhoang@gmail.com", "LKH02");
        danhSachKhachHang.add(kh1);
        danhSachKhachHang.add(kh2);
        danhSachKhachHang.add(kh3);

        // 4. Nhân Viên, Ca Trực & Phân Công Ca Trực
        NhanVien nv1 = new NhanVien("NV01", "Nguyễn Thu Ngân", "2000-01-01", "TP. Thủ Đức", "0909123456", "NNV01");
        NhanVien nv2 = new NhanVien("NV02", "Lê Văn Kiểm Soát", "2002-04-12", "TP.HCM", "0933221144", "NNV02");
        danhSachNhanVien.add(nv1);
        danhSachNhanVien.add(nv2);

        danhSachCalamViec.add(new CalamViec("CA01", "Ca Sáng", "08:00 - 12:00"));
        danhSachCalamViec.add(new CalamViec("CA02", "Ca Chiều", "13:00 - 17:00"));
        danhSachCalamViec.add(new CalamViec("CA03", "Ca Tối", "18:00 - 22:00"));

        danhSachQuanlyCalamviec.add(new QuanlyCalamviec("CA01", "NV01", "Bán vé quầy"));
        danhSachQuanlyCalamviec.add(new QuanlyCalamviec("CA02", "NV01", "Bán vé quầy"));
        danhSachQuanlyCalamviec.add(new QuanlyCalamviec("CA03", "NV01", "Bàn giao ca"));
        danhSachQuanlyCalamviec.add(new QuanlyCalamviec("CA01", "NV01", "Hỗ trợ khách"));
        danhSachQuanlyCalamviec.add(new QuanlyCalamviec("CA02", "NV01", "Kiểm tra vé"));
        danhSachQuanlyCalamviec.add(new QuanlyCalamviec("CA01", "NV02", "Soát vé"));
        danhSachQuanlyCalamviec.add(new QuanlyCalamviec("CA02", "NV02", "Hỗ trợ phòng chiếu"));


        // Tìm trước dữ liệu phim và loại vé
        Phim p01 = timPhimTheoMa("P01");
        Phim p02 = timPhimTheoMa("P02");
        Phim p03 = timPhimTheoMa("P03");

        NhomPhim np01 = timNhomPhimTheoMa("NP01");
        NhomPhim np03 = timNhomPhimTheoMa("NP03");

        LoaiVe lv01 = timLoaiVeTheoMa("LV01");
        LoaiVe lv02 = timLoaiVeTheoMa("LV02");
        LoaiVe lv03 = timLoaiVeTheoMa("LV03");

        try {
            // --- HÓA ĐƠN 1 (Tương ứng DV01) ---
            HoaDon hd1 = new HoaDon("HD1001", "2026-10-04", "NV01", kh1, lkhVip);
            hd1.themVe(p01, np01, lv01); // Vé 1 cho DV01
            hd1.themVe(p01, np01, lv02); // Vé 2 cho DV01
            danhSachHoaDon.add(hd1);
            danhSachDatVe.add(new DatVe("DV01", "2026-10-04", hd1.getTongTien(), hd1.getMaHoaDon()));
            danhSachPayment.add(new Payment("PAY01", "2026-10-04 10:35", hd1.getTongTien(), PhuongThucThanhToanEnum.CHUYEN_KHOAN, TrangThaiGiaoDichEnum.DA_THANH_TOAN, hd1.getMaHoaDon()));

            // --- HÓA ĐƠN 2 (Tương ứng DV02) ---
            HoaDon hd2 = new HoaDon("HD1002", "2026-10-04", "NV01", kh2, lkhBac);
            hd2.themVe(p02, np03, lv03); // Vé 1 cho DV02
            danhSachHoaDon.add(hd2);

            danhSachDatVe.add(new DatVe("DV02", "2026-10-04", hd2.getTongTien(), hd2.getMaHoaDon()));
            danhSachPayment.add(new Payment("PAY02", "2026-10-04 14:20", hd2.getTongTien(), PhuongThucThanhToanEnum.TIEN_MAT, TrangThaiGiaoDichEnum.DA_THANH_TOAN, hd2.getMaHoaDon()));

            // --- HÓA ĐƠN 3 (Tương ứng DV03) ---
            HoaDon hd3 = new HoaDon("HD1003", "2026-10-05", "NV01", kh3, lkhBac);
            hd3.themVe(p03, np01, lv01); // Vé 1 cho DV03
            danhSachHoaDon.add(hd3);

            danhSachDatVe.add(new DatVe("DV03", "2026-10-05", hd3.getTongTien(), hd3.getMaHoaDon()));
            danhSachPayment.add(new Payment("PAY03", "2026-10-05 09:10", hd3.getTongTien(), PhuongThucThanhToanEnum.VI_MOMO, TrangThaiGiaoDichEnum.DA_THANH_TOAN, hd3.getMaHoaDon()));

        } catch (Exception e) {
            System.out.println("Lỗi khi khởi tạo hóa đơn mẫu: " + e.getMessage());
        }

        // --- Nạp Chi tiết đặt vé và Vé ---
        danhSachChiTietDatVe.add(new ChiTietDatVe("P01", "DV01", "G01"));
        danhSachChiTietDatVe.add(new ChiTietDatVe("P01", "DV01", "G02"));
        danhSachChiTietDatVe.add(new ChiTietDatVe("P02", "DV02", "G03"));
        danhSachChiTietDatVe.add(new ChiTietDatVe("P03", "DV03", "G04"));

        double giaP01 = (p01 != null) ? p01.getGiaCoBan() : 50000;
        double giaP02 = (p02 != null) ? p02.getGiaCoBan() : 50000;
        double giaP03 = (p03 != null) ? p03.getGiaCoBan() : 50000;

        danhSachVe.add(new Ve("V01", giaP01, "LV01", "HD1001"));
        danhSachVe.add(new Ve("V02", giaP01, "LV02", "HD1001"));
        danhSachVe.add(new Ve("V03", giaP02, "LV03", "HD1002"));
        danhSachVe.add(new Ve("V04", giaP03, "LV01", "HD1003"));
    }

    public static NhomPhim timNhomPhimTheoMa(String maNhom) {
        for (NhomPhim np : danhSachNhomPhim) {
            if (np.getMaNhomPhim().equalsIgnoreCase(maNhom)) return np;
        }
        return null;
    }

    public static Phim timPhimTheoMa(String maPhim) {
        for (Phim p : danhSachPhim) {
            if (p.getMaPhim().equalsIgnoreCase(maPhim)) return p;
        }
        return null;
    }

    public static LoaiVe timLoaiVeTheoMa(String maLoaiVe) {
        for (LoaiVe lv : danhSachLoaiVe) {
            if (lv.getMaLoaiVe().equalsIgnoreCase(maLoaiVe)) return lv;
        }
        return null;
    }

    public static LoaiKhachHang timLoaiKhachHangTheoMa(String maLoaiKH) {
        for (LoaiKhachHang lkh : danhSachLoaiKhachHang) {
            if (lkh.getMaLoaiKhachHang().equalsIgnoreCase(maLoaiKH)) return lkh;
        }
        return null;
    }

    public static KhachHang timKhachHangTheoMa(String maKH) {
        for (KhachHang kh : danhSachKhachHang) {
            if (kh.getMaKhachHang().equalsIgnoreCase(maKH)) return kh;
        }
        return null;
    }
}