package Service;

import java.util.*;
import java.util.stream.Collectors;

import DAO.CinemaDAO.*;
import model.Enum.LoaiGheEnum;
import model.Enum.PhuongThucThanhToanEnum;
import model.Enum.TrangThaiGiaoDichEnum;
import model.HoaDon.ChiTietItemVe;
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
import model.Ticket.Ghe;
import model.Ticket.LoaiVe;
import model.Ticket.Ve;

public class TruyVan {

    // 1. In danh sách từng vé đã bán theo khách hàng
    public static void cau1_DanhSachVeDaBanTheoKhachHang() {
        System.out.println("\n--- [CÂU 1] DANH SÁCH CHI TIẾT TỪNG VÉ ĐÃ BÁN THEO KHÁCH HÀNG ---");
        System.out.println(String.format("%-18s | %-8s | %-22s | %-24s | %-14s | %-12s | %-12s | %-15s",
                "Tên Khách Hàng", "Mã Vé", "Loại Vé", "Phim", "Loại Phim", "Phụ Phí", "Giảm Giá", "Tổng Tiền"));
        System.out.println(new String(new char[145]).replace("\0", "-"));

        int[] indexVe = {0}; // Mảng 1 phần tử để cho phép thay đổi trong Lambda
        List<Ve> dsVe = VeDAO.layTatCa();

        HoaDonDAO.layTatCa().forEach(hd -> {
            String tenKH = (hd.getKhachHang() != null) ? hd.getKhachHang().getHoTen() : "Khách vãng lai";

            if (hd.getDanhSachItemVe() != null) {
                hd.getDanhSachItemVe().forEach(item -> {
                    String maVe = (indexVe[0] < dsVe.size()) ? dsVe.get(indexVe[0]++).getMaVe() : "N/A";
                    String tenLoaiVe = (item.getLoaiVe() != null) ? item.getLoaiVe().getTenLoaiVe() : "Không rõ";
                    double phuPhi = item.getPhuPhi();
                    double tienGiamGia = (item.getGiaGoc() + phuPhi) - item.getThanhTien();

                    System.out.println(String.format("%-18s | %-8s | %-22s | %-24s | %-14s | %,8.0f VNĐ | %,8.0f VNĐ | %,11.0f VNĐ",
                            tenKH, maVe, tenLoaiVe, item.getPhim().getTenPhim(), item.getNhomPhim().getTenNhomPhim(), phuPhi, tienGiamGia, item.getThanhTien()));
                });
            }
        });
    }

    // CÂU 2: Tìm khách hàng theo số điện thoại
    public static void Cau2_TimKhachHangTheoSDT(String soDienThoai) {
        System.out.println("\n--- [CÂU 2] TÌM KHÁCH HÀNG THEO SĐT (" + soDienThoai + ") ---");
        KhachHangDAO.layTatCa().stream()
                .filter(k -> k.getSdt().equals(soDienThoai))
                .findFirst()
                .ifPresentOrElse(
                        kh -> System.out.printf("Họ tên: %s | SĐT: %s\n", kh.getHoTen(), kh.getSdt()),
                        () -> System.out.println("Không tìm thấy khách hàng.")
                );
    }

    // CÂU 3: Liệt kê ghế VIP của rạp R01
    public static void Cau3_LayDanhSachGheVipRapR01() {
        System.out.println("\n--- [CÂU 3] DANH SÁCH GHẾ VIP RẠP R01 ---");
        GheDAO.layTatCa().stream()
                .filter(g -> g.getMaRap().equals("R01") && g.getLoaiGhe() == LoaiGheEnum.VIP)
                .forEach(g -> System.out.printf("Mã ghế: %s | Loại: %s\n", g.getMaGhe(), g.getLoaiGhe()));
    }

    // CÂU 4: Lấy danh sách ca làm việc
    public static void Cau4_LayDanhSachCaLamViec() {
        System.out.println("\n--- [CÂU 4] DANH SÁCH CA LÀM VIỆC ---");
        CalamViecDAO.layTatCa().forEach(c -> System.out.printf("Ca: %s (%s)\n", c.getTenCa(), c.getThoiGian()));
    }

    // CÂU 5: Lọc các loại vé có giảm giá
    public static void Cau5_LocLoaiVeGiamGiaLonHon10() {
        System.out.println("\n--- [CÂU 5] LOẠI VÉ CÓ GIẢM GIÁ ---");
        LoaiVeDAO.layTatCa().stream()
                .filter(lv -> lv.getMucGiamGia() > 0)
                .forEach(lv -> System.out.printf("%s - Giảm: %.0f%%\n", lv.getTenLoaiVe(), lv.getMucGiamGia() * 100));
    }

    // CÂU 6: Tìm hóa đơn theo ngày
    public static void Cau6_TimHoaDonTheoNgay(String ngayLap) {
        System.out.println("\n--- [CÂU 6] HÓA ĐƠN NGÀY " + ngayLap + " ---");
        HoaDonDAO.layTatCa().stream()
                .filter(hd -> hd.getNgayLap().equals(ngayLap))
                .forEach(hd -> System.out.printf("Mã hóa đơn: %s\n", hd.getMaHoaDon()));
    }

    // CÂU 7: Lấy nhân viên ở khu vực Thủ Đức
    public static void Cau7_LayNhanVienKhuVucThuDuc() {
        System.out.println("\n--- [CÂU 7] NHÂN VIÊN KHU VỰC THỦ ĐỨC ---");
        NhanVienDAO.layTatCa().stream()
                .filter(nv -> nv.getDiaChi() != null && nv.getDiaChi().contains("Thủ Đức"))
                .forEach(nv -> System.out.printf("%s - Địa chỉ: %s\n", nv.getHoTen(), nv.getDiaChi()));
    }

    // CÂU 8: Hiển thị phim kèm tên nhóm và phụ phí
    public static void Cau8_HienThiPhimVaNhomPhim() {
        System.out.println("\n--- [CÂU 8] PHIM VÀ NHÓM ĐỊNH DẠNG ---");
        PhimDAO.layTatCa().forEach(phim -> {
            NhomPhim nhom = NhomPhimDAO.layTatCa().stream()
                    .filter(np -> np.getMaNhomPhim().equals(phim.getMaNhomPhim()))
                    .findFirst().orElse(null);

            String tenNhom = nhom != null ? nhom.getTenNhomPhim() : "Không có";
            double phuPhi = nhom != null ? nhom.getPhuPhi() : 0;
            System.out.printf("%s | Nhóm: %s | Phụ phí: %,.0fđ\n", phim.getTenPhim(), tenNhom, phuPhi);
        });
    }

    // CÂU 9: Hiển thị thông tin vé và loại vé
    public static void Cau9_HienThiThongTinVeDaBan() {
        System.out.println("\n--- [CÂU 9] THÔNG TIN VÉ ĐÃ BÁN ---");
        VeDAO.layTatCa().forEach(ve -> {
            LoaiVe loaiVe = LoaiVeDAO.layTatCa().stream()
                    .filter(lv -> lv.getMaLoaiVe().equals(ve.getMaLoaiVe()))
                    .findFirst().orElse(null);

            String tenLoai = loaiVe != null ? loaiVe.getTenLoaiVe() : "Không rõ";
            System.out.printf("Mã vé: %s | Loại: %s | Giá: %,.0fđ\n", ve.getMaVe(), tenLoai, ve.getGiaCoBan());
        });
    }

    // CÂU 10: Hiển thị khách hàng kèm phân hạng hội viên
    public static void Cau10_HienThiKhachHangVaPhanHang() {
        System.out.println("\n--- [CÂU 10] KHÁCH HÀNG VÀ PHÂN HẠNG HỘI VIÊN ---");
        KhachHangDAO.layTatCa().forEach(kh -> {
            LoaiKhachHang hang = LoaiKhachHangDAO.layTatCa().stream()
                    .filter(lkh -> lkh.getMaLoaiKhachHang().equals(kh.getMaLoaiKhachHang()))
                    .findFirst().orElse(null);

            String tenHang = hang != null ? hang.getNoiDung() : "Khách thường";
            double giamGia = hang != null ? hang.getTyLeGiamGia() * 100 : 0;
            System.out.printf("%s | Hạng: %s | Giảm giá: %.0f%%\n", kh.getHoTen(), tenHang, giamGia);
        });
    }


    // 11. Liệt kê nhân viên, ca trực và nhiệm vụ
    public static void cau11_LietKeNhanVienVaCaTruc() {
        System.out.println("\n--- [CÂU 11] DANH SÁCH NHÂN VIÊN, CA TRỰC VÀ NHIỆM VỤ ---");
        System.out.println(String.format("%-10s | %-20s | %-12s | %-15s | %-20s", "Mã NV", "Họ Tên", "Tên Ca", "Thời Gian", "Nhiệm Vụ"));
        System.out.println(new String(new char[88]).replace("\0", "-"));

        QuanlyCalamviecDAO.layTatCa().stream().forEach(ql -> {
            NhanVien nv = NhanVienDAO.layTatCa().stream().filter(n -> n.getMaNV().equalsIgnoreCase(ql.getMaNV())).findFirst().orElse(null);
            CalamViec ca = CalamViecDAO.layTatCa().stream().filter(c -> c.getMaCa().equalsIgnoreCase(ql.getMaCa())).findFirst().orElse(null);

            if (nv != null && ca != null) {
                System.out.println(String.format("%-10s | %-20s | %-12s | %-15s | %-20s",
                        nv.getMaNV(), nv.getHoTen(), ca.getTenCa(), ca.getThoiGian(), ql.getCongViec()));
            }
        });
    }

    // 12. Danh sách hóa đơn kèm khách hàng
    public static void cau12_HienThiHoaDonKemThuNganVaKhachHang() {
        System.out.println("\n--- [CÂU 12] HÓA ĐƠN KÈM KHÁCH HÀNG ---");
        System.out.println(String.format("%-10s | %-12s | %-20s", "Mã HĐ", "Ngày Lập", "Khách Hàng"));
        System.out.println(new String(new char[48]).replace("\0", "-"));

        HoaDonDAO.layTatCa().stream().forEach(hd -> {
            String tenKH = hd.getKhachHang() != null ? hd.getKhachHang().getHoTen() : "N/A";
            System.out.println(String.format("%-10s | %-12s | %-20s", hd.getMaHoaDon(), hd.getNgayLap(), tenKH));
        });
    }

    // 13. Xem chi tiết các ghế theo mã đặt vé (DV01)
    public static void cau13_XemChiTietGheTheoMaDatVe(String maDatVe) {
        System.out.println("\n--- [CÂU 13] CHI TIẾT GHẾ THEO MÃ ĐẶT VÉ: " + maDatVe + " ---");
        System.out.println(String.format("%-12s | %-10s | %-15s | %-10s", "Mã Đặt Vé", "Mã Ghế", "Loại Ghế", "Mã Rạp"));
        System.out.println(new String(new char[55]).replace("\0", "-"));

        ChiTietDatVeDAO.layTatCa().stream()
                .filter(ct -> ct.getMaDatVe().equalsIgnoreCase(maDatVe))
                .forEach(ct -> {
                    Ghe ghe = GheDAO.layTatCa().stream().filter(g -> g.getMaGhe().equalsIgnoreCase(ct.getMaGhe())).findFirst().orElse(null);
                    if (ghe != null) {
                        System.out.println(String.format("%-12s | %-10s | %-15s | %-10s", ct.getMaDatVe(), ghe.getMaGhe(), ghe.getLoaiGhe(), ghe.getMaRap()));
                    }
                });
    }

    // 14. Lấy thông tin thanh toán (Payment) của hóa đơn
    public static void cau14_LayPaymentCuaHoaDon(String maHoaDon) {
        System.out.println("\n--- [CÂU 14] THÔNG TIN PAYMENT CỦA HÓA ĐƠN: " + maHoaDon + " ---");
        PaymentDAO.layTatCa().stream()
                .filter(p -> p.getMaHoaDon().equalsIgnoreCase(maHoaDon))
                .findFirst()
                .ifPresentOrElse(
                        Payment::inThongTinThanhToan,
                        () -> System.out.println("Không tìm thấy thông tin thanh toán cho hóa đơn: " + maHoaDon)
                );
    }

    // 15. Thống kê tổng số lượng phim theo từng nhóm phim
    public static void cau15_ThongKeSoLuongPhimTheoNhom() {
        System.out.println("\n--- [CÂU 15] THỐNG KÊ SỐ LƯỢNG PHIM THEO NHÓM ĐỊNH DẠNG ---");
        System.out.println(String.format("%-12s | %-20s | %-15s", "Mã Nhóm", "Tên Nhóm Phim", "Số Lượng Phim"));
        System.out.println(new String(new char[55]).replace("\0", "-"));

        NhomPhimDAO.layTatCa().stream().forEach(np -> {
            long dem = PhimDAO.layTatCa().stream().filter(p -> p.getMaNhomPhim().equalsIgnoreCase(np.getMaNhomPhim())).count();
            System.out.println(String.format("%-12s | %-20s | %-15d", np.getMaNhomPhim(), np.getTenNhomPhim(), dem));
        });
    }

    // 16. Đếm tổng số lượng vé và vị trí ghế đã được đặt theo từng bộ phim
    public static void cau16_DemSoVeVaGheDaDatTheoPhim() {
        System.out.println("\n--- [CÂU 16] SỐ LƯỢNG GHẾ ĐÃ ĐẶT THEO BỘ PHIM ---");
        System.out.println(String.format("%-10s | %-32s | %-15s", "Mã Phim", "Tên Phim", "Số Ghế Đã Đặt"));
        System.out.println(new String(new char[65]).replace("\0", "-"));

        PhimDAO.layTatCa().stream().forEach(p -> {
            long dem = ChiTietDatVeDAO.layTatCa().stream().filter(ct -> ct.getMaPhim().equalsIgnoreCase(p.getMaPhim())).count();
            System.out.println(String.format("%-10s | %-32s | %-15d", p.getMaPhim(), p.getTenPhim(), dem));
        });
    }

    // 17. Tìm top 3 khách hàng có tổng chi tiêu mua vé cao nhất
    public static void cau17_Top3KhachHangChiTieuCaoNhat() {
        System.out.println("\n--- [CÂU 17] TOP 3 KHÁCH HÀNG CHI TIÊU NHIỀU NHẤT ---");

        List<Map.Entry<KhachHang, Double>> ketQua = HoaDonDAO.layTatCa().stream()
                .filter(hd -> hd.getKhachHang() != null)
                .collect(Collectors.groupingBy(HoaDon::getKhachHang, Collectors.summingDouble(HoaDon::getTongTien)))
                .entrySet().stream()
                .sorted(Map.Entry.<KhachHang, Double>comparingByValue().reversed())
                .limit(3)
                .toList();

        if (ketQua.isEmpty()) {
            System.out.println("Chưa có dữ liệu chi tiêu.");
        } else {
            int top = 1;
            for (Map.Entry<KhachHang, Double> item : ketQua) {
                System.out.println(String.format("Top %d: %-20s | Tổng chi tiêu: %,12.0f VNĐ", top++, item.getKey().getHoTen(), item.getValue()));
            }
        }
    }

    // 18. Thống kê tổng doanh thu thực tế theo từng phương thức thanh toán
    public static void cau18_ThongKeDoanhThuTheoPhuongThuc() {
        System.out.println("\n--- [CÂU 18] TỔNG DOANH THU THEO PHƯƠNG THỨC THANH TOÁN ---");
        System.out.println(String.format("%-20s | %-12s | %-18s", "Phương Thức", "Số Lượng GD", "Tổng Doanh Thu"));
        System.out.println(new String(new char[56]).replace("\0", "-"));

        PaymentDAO.layTatCa().stream()
                .filter(p -> p.getTrangThai() == TrangThaiGiaoDichEnum.DA_THANH_TOAN)
                .collect(Collectors.groupingBy(Payment::getPhuongThuc))
                .forEach((pt, list) -> {
                    double tongDoanhThu = list.stream().mapToDouble(Payment::getTongTien).sum();
                    System.out.println(String.format("%-20s | %-12d | %,15.0f VNĐ", pt, list.size(), tongDoanhThu));
                });
    }

    // 19. Tìm các bộ phim hiện chưa từng phát sinh lượt đặt vé nào
    public static void cau19_TimPhimChuaTungPhatSinhDatVe() {
        System.out.println("\n--- [CÂU 19] CÁC BỘ PHIM CHƯA CÓ LƯỢT ĐẶT VÉ NÀO ---");
        PhimDAO.layTatCa().stream()
                .filter(p -> ChiTietDatVeDAO.layTatCa().stream().noneMatch(ct -> ct.getMaPhim().equalsIgnoreCase(p.getMaPhim())))
                .forEach(p -> System.out.println(String.format("Mã Phim: %-8s | Tên Phim: %-30s | Giá: %,.0f VNĐ", p.getMaPhim(), p.getTenPhim(), p.getGiaCoBan())));
    }

    // 20. Lọc danh sách những nhân viên đã tham gia trực từ 5 ca làm việc trở lên
    public static void cau20_LocNhanVienTrucTu5CaTroLen() {
        System.out.println("\n--- [CÂU 20] NHÂN VIÊN TRỰC TỪ 5 CA LÀM VIỆC TRỞ LÊN ---");

        boolean[] hasData = {false};
        QuanlyCalamviecDAO.layTatCa().stream()
                .collect(Collectors.groupingBy(QuanlyCalamviec::getMaNV, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() >= 5)
                .forEach(e -> {
                    hasData[0] = true;
                    String tenNV = NhanVienDAO.layTatCa().stream().filter(nv -> nv.getMaNV().equalsIgnoreCase(e.getKey())).map(NhanVien::getHoTen).findFirst().orElse("N/A");
                    System.out.println(String.format("Mã NV: %-8s | Tên: %-20s | Số ca đã trực: %d ca", e.getKey(), tenNV, e.getValue()));
                });

        if (!hasData[0]) System.out.println("Không có nhân viên nào trực từ 5 ca trở lên.");
    }



    public static void thucThiTatCa() {
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