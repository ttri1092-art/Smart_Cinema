using System.Collections.Generic;
using model;
using TinhToan;

namespace data
{
    public class CinemaDatabase
    {
        public static List<NhomPhim> danhSachNhomPhim = new List<NhomPhim>();
        public static List<Phim> danhSachPhim = new List<Phim>();
        public static List<LoaiVe> danhSachLoaiVe = new List<LoaiVe>();
        public static List<Rap> danhSachRap = new List<Rap>();
        public static List<Ghe> danhSachGhe = new List<Ghe>();
        public static List<DatVe> danhSachDatVe = new List<DatVe>();
        public static List<Ve> danhSachVe = new List<Ve>();
        public static List<ChiTietDatVe> danhSachChiTietDatVe = new List<ChiTietDatVe>();
        public static List<LoaiKhachHang> danhSachLoaiKhachHang = new List<LoaiKhachHang>();
        public static List<KhachHang> danhSachKhachHang = new List<KhachHang>();
        public static List<NhomNhanVien> danhSachNhomNhanVien = new List<NhomNhanVien>();
        public static List<NhanVien> danhSachNhanVien = new List<NhanVien>();
        public static List<CalamViec> danhSachCalamViec = new List<CalamViec>();
        public static List<QuanlyCalamviec> danhSachQuanlyCalamviec = new List<QuanlyCalamviec>();
        public static List<HoaDon> danhSachHoaDon = new List<HoaDon>();
        public static List<Payment> danhSachPayment = new List<Payment>();

        static CinemaDatabase()
        {
            khoiTaoDuLieuMau();
        }

        public static void khoiTaoDuLieuMau()
        {
            // 1. Nhóm Phim & Phim
            danhSachNhomPhim.Add(new NhomPhim("NP01", "Phim 2D", "Tiêu chuẩn", 0.0));
            danhSachNhomPhim.Add(new NhomPhim("NP02", "Phim 3D", "Không gian 3D", 35000.0));
            danhSachNhomPhim.Add(new NhomPhim("NP03", "Phim IMAX", "Âm thanh vòm IMAX", 60000.0));

            danhSachPhim.Add(new Phim("P01", "Doraemon Symphony", "Hoạt hình", 50000.0, "Hay", "NP01"));
            danhSachPhim.Add(new Phim("P02", "Avatar: The Way of Water", "Viễn tưởng", 50000.0, "Kỹ xảo", "NP03"));
            danhSachPhim.Add(new Phim("P03", "Lật Mặt 7: Một Điều Ước", "Gia đình", 50000.0, "Cảm động", "NP01"));
            danhSachPhim.Add(new Phim("P04", "Thám Tử Lừng Danh Conan", "Trinh thám", 50000.0, "Kịch tính", "NP02"));

            // 2. Loại Vé, Rạp & Ghế
            danhSachLoaiVe.Add(new LoaiVe("LV01", "Vé Người Lớn", 0.0));
            danhSachLoaiVe.Add(new LoaiVe("LV02", "Vé Học Sinh - Sinh Viên", 0.15));
            danhSachLoaiVe.Add(new LoaiVe("LV03", "Vé Khách VIP", 0.20));

            danhSachRap.Add(new Rap("R01", "Phòng chiếu số 1"));
            danhSachRap.Add(new Rap("R02", "Phòng chiếu số 2"));

            danhSachGhe.Add(new Ghe("G01", LoaiGheEnum.VIP, "R01"));
            danhSachGhe.Add(new Ghe("G02", LoaiGheEnum.VIP, "R01"));
            danhSachGhe.Add(new Ghe("G03", LoaiGheEnum.STANDARD, "R01"));
            danhSachGhe.Add(new Ghe("G04", LoaiGheEnum.SWEETBOX, "R01"));

            // 3. Khách Hàng & Loại Khách Hàng
            LoaiKhachHang lkhVip = new LoaiKhachHang("LKH03", "Thành Viên Kim Cương", 0.10);
            LoaiKhachHang lkhBac = new LoaiKhachHang("LKH02", "Thành Viên Bạc", 0.05);
            danhSachLoaiKhachHang.Add(lkhVip);
            danhSachLoaiKhachHang.Add(lkhBac);

            KhachHang kh1 = new KhachHang("KH01", "Trần Minh Trí", "2007-11-17", "TP.HCM", "0901234567", "triminh@gmail.com", "LKH03");
            KhachHang kh2 = new KhachHang("KH02", "Nguyễn Văn An", "2003-05-10", "Bình Dương", "0912345678", "vanan@gmail.com", "LKH02");
            KhachHang kh3 = new KhachHang("KH03", "Đỗ Huy Hoàng", "2001-08-20", "Đồng Nai", "0987654321", "bichle@gmail.com", "LKH02");
            danhSachKhachHang.Add(kh1);
            danhSachKhachHang.Add(kh2);
            danhSachKhachHang.Add(kh3);

            // 4. Nhân Viên, Ca Trực & Phân Công Ca Trực
            NhanVien nv1 = new NhanVien("NV01", "Nguyễn Thu Ngân", "2000-01-01", "TP. Thủ Đức", "0909123456", "NNV01");
            NhanVien nv2 = new NhanVien("NV02", "Lê Văn Kiểm Soát", "2002-04-12", "TP.HCM", "0933221144", "NNV02");
            danhSachNhanVien.Add(nv1);
            danhSachNhanVien.Add(nv2);

            danhSachCalamViec.Add(new CalamViec("CA01", "Ca Sáng", "08:00 - 12:00"));
            danhSachCalamViec.Add(new CalamViec("CA02", "Ca Chiều", "13:00 - 17:00"));
            danhSachCalamViec.Add(new CalamViec("CA03", "Ca Tối", "18:00 - 22:00"));

            danhSachQuanlyCalamviec.Add(new QuanlyCalamviec("CA01", "NV01", "Bán vé quầy"));
            danhSachQuanlyCalamviec.Add(new QuanlyCalamviec("CA02", "NV01", "Bán vé quầy"));
            danhSachQuanlyCalamviec.Add(new QuanlyCalamviec("CA03", "NV01", "Bàn giao ca"));
            danhSachQuanlyCalamviec.Add(new QuanlyCalamviec("CA01", "NV01", "Hỗ trợ khách"));
            danhSachQuanlyCalamviec.Add(new QuanlyCalamviec("CA02", "NV01", "Kiểm tra vé"));
            danhSachQuanlyCalamviec.Add(new QuanlyCalamviec("CA01", "NV02", "Soát vé"));
            danhSachQuanlyCalamviec.Add(new QuanlyCalamviec("CA02", "NV02", "Hỗ trợ phòng chiếu"));


            // =========================================================================
            // 5 & 6. ĐẶT VÉ, HÓA ĐƠN & TÍNH TIỀN TỰ ĐỘNG BẰNG PRICING CALCULATOR
            // =========================================================================

            // Tìm trước dữ liệu phim và loại vé
            Phim p01 = timPhimTheoMa("P01");
            Phim p02 = timPhimTheoMa("P02");
            Phim p03 = timPhimTheoMa("P03");

            NhomPhim np01 = timNhomPhimTheoMa("NP01");
            NhomPhim np03 = timNhomPhimTheoMa("NP03");

            LoaiVe lv01 = timLoaiVeTheoMa("LV01");
            LoaiVe lv02 = timLoaiVeTheoMa("LV02");
            LoaiVe lv03 = timLoaiVeTheoMa("LV03");

            // --- HÓA ĐƠN 1 (Tương ứng DV01) ---
            HoaDon hd1 = new HoaDon("HD1001", "2026-10-04", "NV01", kh1, lkhVip);
            hd1.themVe(p01, np01, lv01); // Vé 1 cho DV01
            hd1.themVe(p01, np01, lv02); // Vé 2 cho DV01
            danhSachHoaDon.Add(hd1);

            // SỬA LỖI: Đã truyền thêm hd1.getMaHoaDon() làm tham số thứ 4
            danhSachDatVe.Add(new DatVe("DV01", "2026-10-04", hd1.getTongTien(), hd1.getMaHoaDon()));
            danhSachPayment.Add(new Payment("PAY01", "2026-10-04 10:35", hd1.getTongTien(), PhuongThucThanhToanEnum.CHUYEN_KHOAN, TrangThaiGiaoDichEnum.DA_THANH_TOAN, hd1.getMaHoaDon()));

            // --- HÓA ĐƠN 2 (Tương ứng DV02) ---
            HoaDon hd2 = new HoaDon("HD1002", "2026-10-04", "NV01", kh2, lkhBac);
            hd2.themVe(p02, np03, lv03); // Vé 1 cho DV02
            danhSachHoaDon.Add(hd2);

            // SỬA LỖI: Đã truyền thêm hd2.getMaHoaDon() làm tham số thứ 4
            danhSachDatVe.Add(new DatVe("DV02", "2026-10-04", hd2.getTongTien(), hd2.getMaHoaDon()));
            danhSachPayment.Add(new Payment("PAY02", "2026-10-04 14:20", hd2.getTongTien(), PhuongThucThanhToanEnum.TIEN_MAT, TrangThaiGiaoDichEnum.DA_THANH_TOAN, hd2.getMaHoaDon()));

            // --- HÓA ĐƠN 3 (Tương ứng DV03) ---
            HoaDon hd3 = new HoaDon("HD1003", "2026-10-05", "NV01", kh3, lkhBac);
            hd3.themVe(p03, np01, lv01); // Vé 1 cho DV03
            danhSachHoaDon.Add(hd3);

            // SỬA LỖI: Đã truyền thêm hd3.getMaHoaDon() làm tham số thứ 4
            danhSachDatVe.Add(new DatVe("DV03", "2026-10-05", hd3.getTongTien(), hd3.getMaHoaDon()));
            danhSachPayment.Add(new Payment("PAY03", "2026-10-05 09:10", hd3.getTongTien(), PhuongThucThanhToanEnum.VI_MOMO, TrangThaiGiaoDichEnum.DA_THANH_TOAN, hd3.getMaHoaDon()));

            // --- Nạp Chi tiết đặt vé và Vé ---
            danhSachChiTietDatVe.Add(new ChiTietDatVe("P01", "DV01", "G01"));
            danhSachChiTietDatVe.Add(new ChiTietDatVe("P01", "DV01", "G02"));
            danhSachChiTietDatVe.Add(new ChiTietDatVe("P02", "DV02", "G03"));
            danhSachChiTietDatVe.Add(new ChiTietDatVe("P03", "DV03", "G04"));

            // SỬA LỖI: Đã truyền thêm mã Hóa đơn làm tham số thứ 4 cho từng Vé
            danhSachVe.Add(new Ve("V01", p01.getGiaCoBan(), "LV01", "HD1001"));
            danhSachVe.Add(new Ve("V02", p01.getGiaCoBan(), "LV02", "HD1001"));
            danhSachVe.Add(new Ve("V03", p02.getGiaCoBan(), "LV03", "HD1002"));
            danhSachVe.Add(new Ve("V04", p03.getGiaCoBan(), "LV01", "HD1003"));
        }

        // --- Các hàm tiện ích dùng để tìm đối tượng gốc ---
        public static NhomPhim timNhomPhimTheoMa(string maNhom)
        {
            foreach (NhomPhim np in danhSachNhomPhim)
            {
                if (np.getMaNhomPhim().ToLower() == maNhom.ToLower()) return np;
            }
            return null;
        }

        public static Phim timPhimTheoMa(string maPhim)
        {
            foreach (Phim p in danhSachPhim)
            {
                if (p.getMaPhim().ToLower() == maPhim.ToLower()) return p;
            }
            return null;
        }

        public static LoaiVe timLoaiVeTheoMa(string maLoaiVe)
        {
            foreach (LoaiVe lv in danhSachLoaiVe)
            {
                if (lv.getMaLoaiVe().ToLower() == maLoaiVe.ToLower()) return lv;
            }
            return null;
        }

        public static LoaiKhachHang timLoaiKhachHangTheoMa(string maLoaiKH)
        {
            foreach (LoaiKhachHang lkh in danhSachLoaiKhachHang)
            {
                if (lkh.getMaLoaiKhachHang().ToLower() == maLoaiKH.ToLower()) return lkh;
            }
            return null;
        }

        public static KhachHang timKhachHangTheoMa(string maKH)
        {
            foreach (KhachHang kh in danhSachKhachHang)
            {
                if (kh.getMaKhachHang().ToLower() == maKH.ToLower()) return kh;
            }
            return null;
        }
    }
}