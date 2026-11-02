package TinhToan;

// Import các ngoại lệ
import exception.InvalidDataException;
import exception.InvalidPricingException;

// Import các model cần thiết để tính toán
import model.Phim.Phim;
import model.Phim.NhomPhim;
import model.Ticket.LoaiVe;
import model.KhachHang.KhachHang;
import model.KhachHang.LoaiKhachHang;

public class PricingCalculator {

    /**
     * 1. Tính phụ phí dựa vào nhóm phim (Có kiểm tra null)
     */
    public static double tinhPhuPhiNhomPhim(NhomPhim nhomPhim) throws InvalidDataException {
        if (nhomPhim == null) {
            throw new InvalidDataException("Lỗi: Thông tin Nhóm Phim không được để trống!");
        }
        if (nhomPhim.getPhuPhi() < 0) {
            throw new InvalidPricingException("Lỗi: Phụ phí nhóm phim không thể có giá trị âm!");
        }
        return nhomPhim.getPhuPhi();
    }

    /**
     * 2. Tính mức giảm giá theo loại khách hàng (Có kiểm tra tỷ lệ hợp lệ từ 0 đến 1)
     */
    public static double tinhGiamGiaTheoKhachHang(LoaiKhachHang loaiKhachHang) throws InvalidDataException {
        if (loaiKhachHang == null) {
            // Khách hàng có thể là khách vãng lai (không bắt buộc loại KH), trả về 0 nếu null
            return 0.0;
        }
        double tyLe = loaiKhachHang.getTyLeGiamGia();
        if (tyLe < 0.0 || tyLe > 1.0) {
            throw new InvalidPricingException("Lỗi: Tỷ lệ giảm giá của khách hàng phải nằm trong khoảng từ 0.0 (0%) đến 1.0 (100%)!");
        }
        return tyLe;
    }

    /**
     * 3. Tính mức giảm giá theo loại vé
     */
    public static double tinhGiamGiaTheoLoaiVe(LoaiVe loaiVe) throws InvalidDataException {
        if (loaiVe == null) {
            throw new InvalidDataException("Lỗi: Loại vé không được để trống!");
        }
        double mucGiam = loaiVe.getMucGiamGia();
        if (mucGiam < 0.0 || mucGiam > 1.0) {
            throw new InvalidPricingException("Lỗi: Mức giảm giá của vé phải nằm trong khoảng từ 0.0 đến 1.0!");
        }
        return mucGiam;
    }

    /**
     * 4. Tính tổng thanh toán cho một vé hoàn chỉnh (Ném ngoại lệ nếu dữ liệu gốc sai)
     */
    public static double tinhTongTienMotVe(Phim phim, NhomPhim nhomPhim, LoaiVe loaiVe, KhachHang khachHang, LoaiKhachHang loaiKhachHang)
            throws InvalidDataException, InvalidPricingException {

        // Kiểm tra tính hợp lệ của Phim đầu vào
        if (phim == null) {
            throw new InvalidDataException("Lỗi: Không tìm thấy thông tin Phim để tính tiền!");
        }
        if (phim.getGiaCoBan() < 0) {
            throw new InvalidPricingException("Lỗi: Giá cơ bản của phim không thể là số âm!");
        }

        double giaGoc = phim.getGiaCoBan();
        double phuPhi = tinhPhuPhiNhomPhim(nhomPhim);
        double giaSauPhuPhi = giaGoc + phuPhi;

        // Trừ giảm giá loại vé
        double mucGiamVe = tinhGiamGiaTheoLoaiVe(loaiVe);
        double giaSauVe = giaSauPhuPhi * (1 - mucGiamVe);

        // Trừ tiếp giảm giá loại khách hàng
        double mucGiamKH = tinhGiamGiaTheoKhachHang(loaiKhachHang);
        double thanhTienCuoiCung = giaSauVe * (1 - mucGiamKH);

        if (thanhTienCuoiCung < 0) {
            throw new InvalidPricingException("Lỗi: Tổng tiền thanh toán sau khi giảm giá không hợp lệ (âm)!");
        }

        return thanhTienCuoiCung;
    }
}