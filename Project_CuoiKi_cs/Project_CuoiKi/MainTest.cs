using System;
using Service;

public class MainTest
{
    public static void Main(string[] args)
    {
        Console.OutputEncoding = System.Text.Encoding.UTF8;
        int luaChon = -1;

        while (luaChon != 0)
        {
            Console.WriteLine("\n=====================================================================");
            Console.WriteLine("          HỆ THỐNG TRUY VẤN NGHIỆP VỤ SMARTCINEMA (CÂU 1 - 20)         ");
            Console.WriteLine("=====================================================================");
            Console.WriteLine(" [ 1] - In danh sách chi tiết từng vé đã bán theo khách hàng");
            Console.WriteLine(" [ 2] - Tìm kiếm thông tin khách hàng theo số điện thoại");
            Console.WriteLine(" [ 3] - Liệt kê ghế VIP trong phòng chiếu có mã 'R01'");
            Console.WriteLine(" [ 4] - Lấy danh sách toàn bộ các ca làm việc trong ngày");
            Console.WriteLine(" [ 5] - Lọc loại vé có mức giảm giá lớn hơn 10% (0.10)");
            Console.WriteLine(" [ 6] - Tìm hóa đơn thanh toán được lập trong ngày cụ thể");
            Console.WriteLine(" [ 7] - Lấy danh sách nhân viên cư trú tại khu vực 'Thủ Đức'");
            Console.WriteLine(" [ 8] - Hiển thị phim kèm tên nhóm định dạng và phụ phí");
            Console.WriteLine(" [ 9] - Lấy danh sách vé đã bán kèm loại vé và mã đặt vé");
            Console.WriteLine(" [10] - Hiển thị khách hàng kèm phân hạng hội viên và chiết khấu");
            Console.WriteLine(" [11] - Liệt kê nhân viên kèm ca trực và nhiệm vụ");
            Console.WriteLine(" [12] - Hiển thị danh sách hóa đơn kèm thu ngân và khách hàng");
            Console.WriteLine(" [13] - Xem chi tiết các ghế đã đặt trong mã đặt vé ('DV01')");
            Console.WriteLine(" [14] - Lấy thông tin thanh toán (Payment) của hóa đơn ('HD1001')");
            Console.WriteLine(" [15] - Thống kê tổng số lượng phim theo từng nhóm phim");
            Console.WriteLine(" [16] - Đếm tổng số lượng vé/ghế đã được đặt theo từng bộ phim");
            Console.WriteLine(" [17] - Tìm top 3 khách hàng chi tiêu nhiều nhất hệ thống");
            Console.WriteLine(" [18] - Thống kê doanh thu theo từng phương thức thanh toán");
            Console.WriteLine(" [19] - Tìm các bộ phim chưa từng phát sinh lượt đặt vé nào");
            Console.WriteLine(" [20] - Lọc danh sách nhân viên đã trực từ 5 ca làm việc trở lên");
            Console.WriteLine(" [0]  - Thoát chương trình");
            Console.WriteLine(" [123]- Tất cả nghiệp vụ");
            Console.WriteLine("==========================================================================");
            Console.Write("👉 Nhập số câu truy vấn cần thực thi (1 - 20) hoặc 0 để thoát: ");

            string input = Console.ReadLine();

            if (!int.TryParse(input, out luaChon))
            {
                Console.WriteLine("⚠️ Vui lòng nhập số!");
                luaChon = -1;
                continue; 
            }

            switch (luaChon)
            {
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
                    Console.WriteLine("👋 Đã thoát chương trình.");
                    break;
                default:
                    Console.WriteLine("⚠️ Lựa chọn không hợp lệ!");
                    break;
            }

            if (luaChon != 0)
            {
                Console.WriteLine("\nNhấn Enter để tiếp tục...");
                Console.ReadLine();
            }
        }
    }
}