import java.util.Scanner;
import Service.TruyVan;

public class MainTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int luaChon = -1;

        while (luaChon != 0) {
            System.out.println("\n=====================================================================");
            System.out.println("          HỆ THỐNG TRUY VẤN NGHIỆP VỤ SMARTCINEMA (CÂU 1 - 20)         ");
            System.out.println("=====================================================================");
            System.out.println(" [ 1] - In danh sách chi tiết từng vé đã bán theo khách hàng");
            System.out.println(" [ 2] - Tìm kiếm thông tin khách hàng theo số điện thoại");
            System.out.println(" [ 3] - Liệt kê ghế VIP trong phòng chiếu có mã 'R01'");
            System.out.println(" [ 4] - Lấy danh sách toàn bộ các ca làm việc trong ngày");
            System.out.println(" [ 5] - Lọc loại vé có mức giảm giá lớn hơn 10% (0.10)");
            System.out.println(" [ 6] - Tìm hóa đơn thanh toán được lập trong ngày cụ thể");
            System.out.println(" [ 7] - Lấy danh sách nhân viên cư trú tại khu vực 'Thủ Đức'");
            System.out.println(" [ 8] - Hiển thị phim kèm tên nhóm định dạng và phụ phí");
            System.out.println(" [ 9] - Lấy danh sách vé đã bán kèm loại vé và mã đặt vé");
            System.out.println(" [10] - Hiển thị khách hàng kèm phân hạng hội viên và chiết khấu");
            System.out.println(" [11] - Liệt kê nhân viên kèm ca trực và nhiệm vụ");
            System.out.println(" [12] - Hiển thị danh sách hóa đơn kèm thu ngân và khách hàng");
            System.out.println(" [13] - Xem chi tiết các ghế đã đặt trong mã đặt vé ('DV01')");
            System.out.println(" [14] - Lấy thông tin thanh toán (Payment) của hóa đơn ('HD1001')");
            System.out.println(" [15] - Thống kê tổng số lượng phim theo từng nhóm phim");
            System.out.println(" [16] - Đếm tổng số lượng vé/ghế đã được đặt theo từng bộ phim");
            System.out.println(" [17] - Tìm top 3 khách hàng chi tiêu nhiều nhất hệ thống");
            System.out.println(" [18] - Thống kê doanh thu theo từng phương thức thanh toán");
            System.out.println(" [19] - Tìm các bộ phim chưa từng phát sinh lượt đặt vé nào");
            System.out.println(" [20] - Lọc danh sách nhân viên đã trực từ 5 ca làm việc trở lên");
            System.out.println(" [0]  - Thoát chương trình");
            System.out.println(" [123]- Tất cả nghiệp vụ");
            System.out.println("==========================================================================");
            System.out.print("👉 Nhập số câu truy vấn cần thực thi (1 - 20) hoặc 0 để thoát: ");

            String input = scanner.nextLine();

            try {
                luaChon = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Vui lòng nhập số!");
                luaChon = -1;
                continue;
            }

            switch (luaChon) {
                case 1:
                    TruyVan.cau1_DanhSachVeDaBanTheoKhachHang();
                    break;
                case 2:
                    TruyVan.Cau2_TimKhachHangTheoSDT("0901234567");
                    break;
                case 3:
                    TruyVan.Cau3_LayDanhSachGheVipRapR01();
                    break;
                case 4:
                    TruyVan.Cau4_LayDanhSachCaLamViec();
                    break;
                case 5:
                    TruyVan.Cau5_LocLoaiVeGiamGiaLonHon10();
                    break;
                case 6:
                    TruyVan.Cau6_TimHoaDonTheoNgay("2026-10-04");
                    break;
                case 7:
                    TruyVan.Cau7_LayNhanVienKhuVucThuDuc();
                    break;
                case 8:
                    TruyVan.Cau8_HienThiPhimVaNhomPhim();
                    break;
                case 9:
                    TruyVan.Cau9_HienThiThongTinVeDaBan();
                    break;
                case 10:
                    TruyVan.Cau10_HienThiKhachHangVaPhanHang();
                    break;
                case 11:
                    TruyVan.cau11_LietKeNhanVienVaCaTruc();
                    break;
                case 12:
                    TruyVan.cau12_HienThiHoaDonKemThuNganVaKhachHang();
                    break;
                case 13:
                    TruyVan.cau13_XemChiTietGheTheoMaDatVe("DV01");
                    break;
                case 14:
                    TruyVan.cau14_LayPaymentCuaHoaDon("HD1001");
                    break;
                case 15:
                    TruyVan.cau15_ThongKeSoLuongPhimTheoNhom();
                    break;
                case 16:
                    TruyVan.cau16_DemSoVeVaGheDaDatTheoPhim();
                    break;
                case 17:
                    TruyVan.cau17_Top3KhachHangChiTieuCaoNhat();
                    break;
                case 18:
                    TruyVan.cau18_ThongKeDoanhThuTheoPhuongThuc();
                    break;
                case 19:
                    TruyVan.cau19_TimPhimChuaTungPhatSinhDatVe();
                    break;
                case 20:
                    TruyVan.cau20_LocNhanVienTrucTu5CaTroLen();
                    break;

                case 123:
                    TruyVan.thucThiTatCa();
                    break;
                case 0:
                    System.out.println("👋 Đã thoát chương trình.");
                    break;
                default:
                    System.out.println("⚠️ Lựa chọn không hợp lệ!");
                    break;
            }

            if (luaChon != 0) {
                System.out.println("\nNhấn Enter để tiếp tục...");
                scanner.nextLine();
            }
        }

        scanner.close();
    }
}