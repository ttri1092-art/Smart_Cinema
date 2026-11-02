using model;
using exception;

namespace TinhToan
{
    public class PricingCalculator
    {
        public static double tinhPhuPhiNhomPhim(NhomPhim nhomPhim)
        {
            if (nhomPhim == null)
                throw new InvalidDataException("Lỗi: Thông tin Nhóm Phim không được để trống!");
            if (nhomPhim.getPhuPhi() < 0)
                throw new InvalidPricingException("Lỗi: Phụ phí nhóm phim không thể có giá trị âm!");

            return nhomPhim.getPhuPhi();
        }

        public static double tinhGiamGiaTheoKhachHang(LoaiKhachHang loaiKhachHang)
        {
            if (loaiKhachHang == null) return 0.0;
            double tyLe = loaiKhachHang.getTyLeGiamGia();
            if (tyLe < 0.0 || tyLe > 1.0)
                throw new InvalidPricingException("Lỗi: Tỷ lệ giảm giá của khách hàng phải nằm trong khoảng từ 0.0 đến 1.0!");

            return tyLe;
        }

        public static double tinhGiamGiaTheoLoaiVe(LoaiVe loaiVe)
        {
            if (loaiVe == null)
                throw new InvalidDataException("Lỗi: Loại vé không được để trống!");
            double mucGiam = loaiVe.getMucGiamGia();
            if (mucGiam < 0.0 || mucGiam > 1.0)
                throw new InvalidPricingException("Lỗi: Mức giảm giá của vé phải nằm trong khoảng từ 0.0 đến 1.0!");

            return mucGiam;
        }

        public static double tinhTongTienMotVe(Phim phim, NhomPhim nhomPhim, LoaiVe loaiVe, KhachHang khachHang, LoaiKhachHang loaiKhachHang)
        {
            if (phim == null)
                throw new InvalidDataException("Lỗi: Không tìm thấy thông tin Phim để tính tiền!");
            if (phim.getGiaCoBan() < 0)
                throw new InvalidPricingException("Lỗi: Giá cơ bản của phim không thể là số âm!");

            double giaGoc = phim.getGiaCoBan();
            double phuPhi = tinhPhuPhiNhomPhim(nhomPhim);
            double giaSauPhuPhi = giaGoc + phuPhi;

            double mucGiamVe = tinhGiamGiaTheoLoaiVe(loaiVe);
            double giaSauVe = giaSauPhuPhi * (1 - mucGiamVe);

            double mucGiamKH = tinhGiamGiaTheoKhachHang(loaiKhachHang);
            double thanhTienCuoiCung = giaSauVe * (1 - mucGiamKH);

            if (thanhTienCuoiCung < 0)
                throw new InvalidPricingException("Lỗi: Tổng tiền thanh toán sau khi giảm giá không hợp lệ!");

            return thanhTienCuoiCung;
        }
    }
}