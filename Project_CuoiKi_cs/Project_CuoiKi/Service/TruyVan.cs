using System;
using System.Collections.Generic;
using System.Linq;
using DAO;      
using model;

namespace Service
{
    public class TruyVan
    {
        // 1. In danh sách từng vé đã bán theo khách hàng 
        public static void cau1_DanhSachVeDaBanTheoKhachHang()
        {
            Console.WriteLine("\n--- [CÂU 1] DANH SÁCH CHI TIẾT TỪNG VÉ ĐÃ BÁN THEO KHÁCH HÀNG ---");
            Console.WriteLine(string.Format("{0,-18} | {1,-8} | {2,-24} | {3,-24} | {4,-14} | {5,-12} | {6,-12} | {7,-15}",
                "Tên Khách Hàng", "Mã Vé", "Loại Vé", "Phim", "Loại Phim", "Phụ Phí", "Giảm Giá", "Tổng Tiền"));
            Console.WriteLine(new string('-', 145));

            int indexVe = 0;
            var dsVe = VeDAO.layTatCa(); 

            foreach (HoaDon hd in HoaDonDAO.layTatCa())
            {
                string tenKH = (hd.getKhachHang() != null) ? hd.getKhachHang().getHoTen() : "Khách vãng lai";

                if (hd.getDanhSachItemVe() != null)
                {
                    foreach (ChiTietItemVe item in hd.getDanhSachItemVe())
                    {
                        string maVe = (indexVe < dsVe.Count) ? dsVe[indexVe].getMaVe() : "N/A";
                        indexVe++;

                        string tenLoaiVe = (item.getLoaiVe() != null) ? item.getLoaiVe().getTenLoaiVe() : "Không rõ";
                        double phuPhi = item.getPhuPhi();
                        double tienGiamGia = (item.getGiaGoc() + phuPhi) - item.getThanhTien();

                        Console.WriteLine(string.Format("{0,-18} | {1,-8} | {2,-22} | {3,-24} | {4,-14} | {5,8:#,##0} VNĐ | {6,8:#,##0} VNĐ | {7,11:#,##0} VNĐ",
                            tenKH, maVe, tenLoaiVe, item.getPhim().getTenPhim(), item.getNhomPhim().getTenNhomPhim(), phuPhi, tienGiamGia, item.getThanhTien()));
                    }
                }
            }
        }

        // CÂU 2: Tìm khách hàng theo số điện thoại
        public static void Cau2_TimKhachHangTheoSDT(string soDienThoai)
        {
            Console.WriteLine($"\n--- [CÂU 2] TÌM KHÁCH HÀNG THEO SĐT ({soDienThoai}) ---");
            var kh = KhachHangDAO.layTatCa().FirstOrDefault(k => k.getSdt() == soDienThoai);

            if (kh != null) Console.WriteLine($"Họ tên: {kh.getHoTen()} | SĐT: {kh.getSdt()}");
            else Console.WriteLine("Không tìm thấy khách hàng.");
        }

        // CÂU 3: Liệt kê ghế VIP của rạp R01
        public static void Cau3_LayDanhSachGheVipRapR01()
        {
            Console.WriteLine("\n--- [CÂU 3] DANH SÁCH GHẾ VIP RẠP R01 ---");
            var danhSach = GheDAO.layTatCa().Where(g => g.getMaRap() == "R01" && g.getLoaiGhe() == LoaiGheEnum.VIP);

            foreach (var g in danhSach)
                Console.WriteLine($"Mã ghế: {g.getMaGhe()} | Loại: {g.getLoaiGhe()}");
        }

        // CÂU 4: Lấy danh sách ca làm việc
        public static void Cau4_LayDanhSachCaLamViec()
        {
            Console.WriteLine("\n--- [CÂU 4] DANH SÁCH CA LÀM VIỆC ---");
            CalamViecDAO.layTatCa().ForEach(c => Console.WriteLine($"Ca: {c.getTenCa()} ({c.getThoiGian()})"));
        }

        // CÂU 5: Lọc các loại vé có giảm giá
        public static void Cau5_LocLoaiVeGiamGiaLonHon10()
        {
            Console.WriteLine("\n--- [CÂU 5] LOẠI VÉ CÓ GIẢM GIÁ ---");
            var danhSach = LoaiVeDAO.layTatCa().Where(lv => lv.getMucGiamGia() > 0);

            foreach (var lv in danhSach)
                Console.WriteLine($"{lv.getTenLoaiVe()} - Giảm: {lv.getMucGiamGia() * 100}%");
        }

        // CÂU 6: Tìm hóa đơn theo ngày
        public static void Cau6_TimHoaDonTheoNgay(string ngayLap)
        {
            Console.WriteLine($"\n--- [CÂU 6] HÓA ĐƠN NGÀY {ngayLap} ---");
            var danhSach = HoaDonDAO.layTatCa().Where(hd => hd.getNgayLap() == ngayLap);

            foreach (var hd in danhSach)
                Console.WriteLine($"Mã hóa đơn: {hd.getMaHoaDon()}");
        }

        // CÂU 7: Lấy nhân viên ở khu vực Thủ Đức
        public static void Cau7_LayNhanVienKhuVucThuDuc()
        {
            Console.WriteLine("\n--- [CÂU 7] NHÂN VIÊN KHU VỰC THỦ ĐỨC ---");
            var danhSach = NhanVienDAO.layTatCa().Where(nv => nv.getDiaChi() != null && nv.getDiaChi().Contains("Thủ Đức"));

            foreach (var nv in danhSach)
                Console.WriteLine($"{nv.getHoTen()} - Địa chỉ: {nv.getDiaChi()}");
        }

        // CÂU 8: Hiển thị phim kèm tên nhóm và phụ phí
        public static void Cau8_HienThiPhimVaNhomPhim()
        {
            Console.WriteLine("\n--- [CÂU 8] PHIM VÀ NHÓM ĐỊNH DẠNG ---");
            var ketQua = from p in PhimDAO.layTatCa()
                         join np in NhomPhimDAO.layTatCa() on p.getMaNhomPhim().ToLower() equals np.getMaNhomPhim().ToLower() into nhom
                         from np in nhom.DefaultIfEmpty()
                         select new { p, np };

            foreach (var item in ketQua)
            {
                string tenNhom = item.np != null ? item.np.getTenNhomPhim() : "Không có";
                double phuPhi = item.np != null ? item.np.getPhuPhi() : 0;
                Console.WriteLine($"{item.p.getTenPhim()} | Nhóm: {tenNhom} | Phụ phí: {phuPhi:N0}đ");
            }
        }

        // CÂU 9: Hiển thị thông tin vé và loại vé
        public static void Cau9_HienThiThongTinVeDaBan()
        {
            Console.WriteLine("\n--- [CÂU 9] THÔNG TIN VÉ ĐÃ BÁN ---");
            var ketQua = from v in VeDAO.layTatCa()
                         join lv in LoaiVeDAO.layTatCa() on v.getMaLoaiVe().ToLower() equals lv.getMaLoaiVe().ToLower() into loai
                         from lv in loai.DefaultIfEmpty()
                         select new { v, lv };

            foreach (var item in ketQua)
            {
                string tenLoai = item.lv != null ? item.lv.getTenLoaiVe() : "Không rõ";
                Console.WriteLine($"Mã vé: {item.v.getMaVe()} | Loại: {tenLoai} | Giá: {item.v.getGiaCoBan():N0}đ");
            }
        }

        // CÂU 10: Hiển thị khách hàng kèm phân hạng hội viên
        public static void Cau10_HienThiKhachHangVaPhanHang()
        {
            Console.WriteLine("\n--- [CÂU 10] KHÁCH HÀNG VÀ PHÂN HẠNG HỘI VIÊN ---");
            var ketQua = from kh in KhachHangDAO.layTatCa()
                         join lkh in LoaiKhachHangDAO.layTatCa() on kh.getMaLoaiKhachHang().ToLower() equals lkh.getMaLoaiKhachHang().ToLower() into hang
                         from lkh in hang.DefaultIfEmpty()
                         select new { kh, lkh };

            foreach (var item in ketQua)
            {
                string tenHang = item.lkh != null ? item.lkh.getNoiDung() : "Khách thường";
                double giamGia = item.lkh != null ? item.lkh.getTyLeGiamGia() * 100 : 0;
                Console.WriteLine($"{item.kh.getHoTen()} | Hạng: {tenHang} | Giảm giá: {giamGia}%");
            }
        }

        // 11. Liệt kê nhân viên, ca trực và nhiệm vụ 
        public static void cau11_LietKeNhanVienVaCaTruc()
        {
            Console.WriteLine("\n--- [CÂU 11] DANH SÁCH NHÂN VIÊN, CA TRỰC VÀ NHIỆM VỤ ---");
            Console.WriteLine(string.Format("{0,-10} | {1,-20} | {2,-12} | {3,-15} | {4,-20}", "Mã NV", "Họ Tên", "Tên Ca", "Thời Gian", "Nhiệm Vụ"));
            Console.WriteLine(new string('-', 88));

            var ketQua = from ql in QuanlyCalamviecDAO.layTatCa()
                         join nv in NhanVienDAO.layTatCa() on ql.getMaNV().ToLower() equals nv.getMaNV().ToLower()
                         join ca in CalamViecDAO.layTatCa() on ql.getMaCa().ToLower() equals ca.getMaCa().ToLower()
                         select new { nv, ca, ql };

            foreach (var item in ketQua)
                Console.WriteLine(string.Format("{0,-10} | {1,-20} | {2,-12} | {3,-15} | {4,-20}",
                    item.nv.getMaNV(), item.nv.getHoTen(), item.ca.getTenCa(), item.ca.getThoiGian(), item.ql.getCongViec()));
        }

        // 12. Danh sách hóa đơn kèm khách hàng 
        public static void cau12_HienThiHoaDonKemThuNganVaKhachHang()
        {
            Console.WriteLine("\n--- [CÂU 12] HÓA ĐƠN KÈM KHÁCH HÀNG ---");
            Console.WriteLine(string.Format("{0,-10} | {1,-12} | {2,-20}", "Mã HĐ", "Ngày Lập", "Khách Hàng"));
            Console.WriteLine(new string('-', 48));

            var ketQua = HoaDonDAO.layTatCa().Select(hd => new {
                MaHD = hd.getMaHoaDon(),
                Ngay = hd.getNgayLap(),
                TenKH = hd.getKhachHang() != null ? hd.getKhachHang().getHoTen() : "N/A"
            });

            foreach (var item in ketQua)
                Console.WriteLine(string.Format("{0,-10} | {1,-12} | {2,-20}", item.MaHD, item.Ngay, item.TenKH));
        }

        // 13. Xem chi tiết các ghế theo mã đặt vé (DV01) 
        public static void cau13_XemChiTietGheTheoMaDatVe(string maDatVe)
        {
            Console.WriteLine($"\n--- [CÂU 13] CHI TIẾT GHẾ THEO MÃ ĐẶT VÉ: {maDatVe} ---");
            Console.WriteLine(string.Format("{0,-12} | {1,-10} | {2,-15} | {3,-10}", "Mã Đặt Vé", "Mã Ghế", "Loại Ghế", "Mã Rạp"));
            Console.WriteLine(new string('-', 55));

            var ketQua = from ct in ChiTietDatVeDAO.layTatCa()
                         where ct.getMaDatVe().Equals(maDatVe, StringComparison.OrdinalIgnoreCase)
                         join g in GheDAO.layTatCa() on ct.getMaGhe().ToLower() equals g.getMaGhe().ToLower()
                         select new { ct, g };

            foreach (var item in ketQua)
                Console.WriteLine(string.Format("{0,-12} | {1,-10} | {2,-15} | {3,-10}",
                    item.ct.getMaDatVe(), item.g.getMaGhe(), item.g.getLoaiGhe(), item.g.getMaRap()));
        }

        // 14. Lấy thông tin thanh toán (Payment) của hóa đơn 
        public static void cau14_LayPaymentCuaHoaDon(string maHoaDon)
        {
            Console.WriteLine($"\n--- [CÂU 14] THÔNG TIN PAYMENT CỦA HÓA ĐƠN: {maHoaDon} ---");
            var payment = PaymentDAO.layTatCa().FirstOrDefault(p => p.getMaHoaDon().Equals(maHoaDon, StringComparison.OrdinalIgnoreCase));

            if (payment != null) payment.inThongTinThanhToan();
            else Console.WriteLine("Không tìm thấy thông tin thanh toán.");
        }

        //Câu 15. Thống kê tổng số lượng phim theo từng nhóm phim     
        public static void cau15_ThongKeSoLuongPhimTheoNhom()
        {
            Console.WriteLine("\n--- [CÂU 15] THỐNG KÊ SỐ LƯỢNG PHIM THEO NHÓM ĐỊNH DẠNG ---");
            Console.WriteLine(string.Format("{0,-12} | {1,-20} | {2,-15}", "Mã Nhóm", "Tên Nhóm Phim", "Số Lượng Phim"));
            Console.WriteLine(new string('-', 55));

            var ketQua = NhomPhimDAO.layTatCa().Select(np => new {
                MaNhom = np.getMaNhomPhim(),
                TenNhom = np.getTenNhomPhim(),
                SoLuong = PhimDAO.layTatCa().Count(p => p.getMaNhomPhim().ToLower() == np.getMaNhomPhim().ToLower())
            });

            foreach (var item in ketQua)
                Console.WriteLine(string.Format("{0,-12} | {1,-20} | {2,-15}", item.MaNhom, item.TenNhom, item.SoLuong));
        }


        //Câu 16. Đếm tổng số lượng vé và vị trí ghế đã được đặt theo từng bộ phim

        public static void cau16_DemSoVeVaGheDaDatTheoPhim()
        {
            Console.WriteLine("\n--- [CÂU 16] SỐ LƯỢNG GHẾ ĐÃ ĐẶT THEO BỘ PHIM ---");
            Console.WriteLine(string.Format("{0,-10} | {1,-32} | {2,-15}", "Mã Phim", "Tên Phim", "Số Ghế Đã Đặt"));
            Console.WriteLine(new string('-', 65));

            var ketQua = PhimDAO.layTatCa().Select(p => new {
                MaPhim = p.getMaPhim(),
                TenPhim = p.getTenPhim(),
                SoGhe = ChiTietDatVeDAO.layTatCa().Count(ct => ct.getMaPhim().ToLower() == p.getMaPhim().ToLower())
            });

            foreach (var item in ketQua)
                Console.WriteLine(string.Format("{0,-10} | {1,-32} | {2,-15}", item.MaPhim, item.TenPhim, item.SoGhe));
        }

        // 17. Tìm top 3 khách hàng có tổng chi tiêu mua vé cao nhất 
        public static void cau17_Top3KhachHangChiTieuCaoNhat()
        {
            Console.WriteLine("\n--- [CÂU 17] TOP 3 KHÁCH HÀNG CHI TIÊU NHIỀU NHẤT ---");

            var ketQua = HoaDonDAO.layTatCa()
                .Where(hd => hd.getKhachHang() != null)
                .GroupBy(hd => hd.getKhachHang())
                .Select(g => new { KhachHang = g.Key, TongChiTieu = g.Sum(hd => hd.getTongTien()) })
                .OrderByDescending(x => x.TongChiTieu)
                .Take(3)
                .ToList();

            int top = 1;
            foreach (var item in ketQua)
            {
                Console.WriteLine(string.Format("Top {0}: {1,-20} | Tổng chi tiêu: {2,12:#,##0} VNĐ", top++, item.KhachHang.getHoTen(), item.TongChiTieu));
            }

            if (!ketQua.Any()) Console.WriteLine("Chưa có dữ liệu chi tiêu.");
        }

        // 18. Thống kê tổng doanh thu thực tế theo từng phương thức thanh toán
        public static void cau18_ThongKeDoanhThuTheoPhuongThuc()
        {
            Console.WriteLine("\n--- [CÂU 18] TỔNG DOANH THU THEO PHƯƠNG THỨC THANH TOÁN ---");
            Console.WriteLine(string.Format("{0,-20} | {1,-12} | {2,-18}", "Phương Thức", "Số Lượng GD", "Tổng Doanh Thu"));
            Console.WriteLine(new string('-', 56));

            var ketQua = PaymentDAO.layTatCa()
                .Where(p => p.getTrangThai() == TrangThaiGiaoDichEnum.DA_THANH_TOAN)
                .GroupBy(p => p.getPhuongThuc())
                .Select(g => new { PhuongThuc = g.Key, SoLuong = g.Count(), TongDoanhThu = g.Sum(p => p.getTongTien()) });

            foreach (var item in ketQua)
                Console.WriteLine(string.Format("{0,-20} | {1,-12} | {2,15:#,##0} VNĐ", item.PhuongThuc, item.SoLuong, item.TongDoanhThu));
        }

        // 19. Tìm các bộ phim hiện chưa từng phát sinh lượt đặt vé nào
        public static void cau19_TimPhimChuaTungPhatSinhDatVe()
        {
            Console.WriteLine("\n--- [CÂU 19] CÁC BỘ PHIM CHƯA CÓ LƯỢT ĐẶT VÉ NÀO ---");
            var phimChuaDat = PhimDAO.layTatCa().Where(p => !ChiTietDatVeDAO.layTatCa().Any(ct => ct.getMaPhim().ToLower() == p.getMaPhim().ToLower()));

            foreach (var p in phimChuaDat)
                Console.WriteLine(string.Format("Mã Phim: {0,-8} | Tên Phim: {1,-30} | Giá: {2:#,##0} VNĐ", p.getMaPhim(), p.getTenPhim(), p.getGiaCoBan()));
        }

        // 20. Lọc danh sách những nhân viên đã tham gia trực từ 5 ca làm việc trở lên
        public static void cau20_LocNhanVienTrucTu5CaTroLen()
        {
            Console.WriteLine("\n--- [CÂU 20] NHÂN VIÊN TRỰC TỪ 5 CA LÀM VIỆC TRỞ LÊN ---");
            var ketQua = QuanlyCalamviecDAO.layTatCa()
                .GroupBy(ql => ql.getMaNV())
                .Where(g => g.Count() >= 5)
                .Select(g => new {
                    MaNV = g.Key,
                    SoCa = g.Count(),
                    TenNV = NhanVienDAO.layTatCa().FirstOrDefault(nv => nv.getMaNV() == g.Key)?.getHoTen() ?? "N/A"
                });

            bool hasData = false;
            foreach (var item in ketQua)
            {
                hasData = true;
                Console.WriteLine(string.Format("Mã NV: {0,-8} | Tên: {1,-20} | Số ca đã trực: {2} ca", item.MaNV, item.TenNV, item.SoCa));
            }
            if (!hasData) Console.WriteLine("Không có nhân viên nào trực từ 5 ca trở lên.");
        }

        

        public static void thucThiTatCa()
        {
            cau1_DanhSachVeDaBanTheoKhachHang();
            Cau2_TimKhachHangTheoSDT("0901234567");
            Cau3_LayDanhSachGheVipRapR01();
            Cau4_LayDanhSachCaLamViec();
            Cau5_LocLoaiVeGiamGiaLonHon10();
            Cau6_TimHoaDonTheoNgay("2026-10-04");
            Cau7_LayNhanVienKhuVucThuDuc();
            Cau8_HienThiPhimVaNhomPhim();
            Cau9_HienThiThongTinVeDaBan();
            Cau10_HienThiKhachHangVaPhanHang();
            cau11_LietKeNhanVienVaCaTruc();
            cau12_HienThiHoaDonKemThuNganVaKhachHang();
            cau13_XemChiTietGheTheoMaDatVe("DV01");
            cau14_LayPaymentCuaHoaDon("HD1001");
            cau15_ThongKeSoLuongPhimTheoNhom();
            cau16_DemSoVeVaGheDaDatTheoPhim();
            cau17_Top3KhachHangChiTieuCaoNhat();
            cau18_ThongKeDoanhThuTheoPhuongThuc();
            cau19_TimPhimChuaTungPhatSinhDatVe();
            cau20_LocNhanVienTrucTu5CaTroLen();
            
        }
    }
}