package model.HoaDon;
import java.util.ArrayList;
import java.util.List;

import model.Enum.PhuongThucThanhToanEnum;
import model.Enum.TrangThaiGiaoDichEnum;

import model.Phim.Phim;
import model.Phim.NhomPhim;
import model.Ticket.LoaiVe;
import model.NhanVien.NhanVien;
import model.KhachHang.KhachHang;
import model.KhachHang.LoaiKhachHang;
import exception.InvalidDataException;
import exception.InvalidPricingException;
import exception.PaymentException;
import TinhToan.PricingCalculator;

public class HoaDon {
    private String maHoaDon;
    private String ngayLap;
    private double tongTien;
    private String maNV;
    private KhachHang khachHang;
    private LoaiKhachHang loaiKhachHang;
    private TrangThaiGiaoDichEnum trangThai;

    // Danh sách lưu trữ các vé được tính tiền động
    private List<ChiTietItemVe> danhSachItemVe;

    // Đối tượng Payment liên kết trực tiếp (1 - 1)
    private Payment thongTinPayment;

    public HoaDon(String maHoaDon, String ngayLap, String maNV, KhachHang khachHang, LoaiKhachHang loaiKhachHang) {
        this.maHoaDon = maHoaDon;
        this.ngayLap = ngayLap;
        this.maNV = maNV;
        this.khachHang = khachHang;
        this.loaiKhachHang = loaiKhachHang;
        this.trangThai = TrangThaiGiaoDichEnum.CHO_XU_LY; // Khởi tạo bằng Enum trạng thái chờ xử lý
        this.tongTien = 0.0;
        this.danhSachItemVe = new ArrayList<>();
        this.thongTinPayment = null;
    }

    /**
     * Thêm vé và tự động tính tiền theo công thức: Giá gốc + Phụ phí - Giảm giá
     */
    public void themVe(Phim phim, NhomPhim nhomPhim, LoaiVe loaiVe)
            throws InvalidDataException, InvalidPricingException {

        // 1. Tính toán giá tiền thực tế bằng PricingCalculator
        double thanhTienVe = PricingCalculator.tinhTongTienMotVe(phim, nhomPhim, loaiVe, this.khachHang, this.loaiKhachHang);

        // 2. Thu thập các thông số để lưu trữ chi tiết dòng vé
        double giaGoc = phim.getGiaCoBan();
        double phuPhi = (nhomPhim != null) ? nhomPhim.getPhuPhi() : 0.0;
        double giamGiaVe = (loaiVe != null) ? loaiVe.getMucGiamGia() : 0.0;
        double giamGiaKH = (loaiKhachHang != null) ? loaiKhachHang.getTyLeGiamGia() : 0.0;

        ChiTietItemVe item = new ChiTietItemVe(phim, nhomPhim, loaiVe, giaGoc, phuPhi, giamGiaVe, giamGiaKH, thanhTienVe);
        this.danhSachItemVe.add(item);

        // 3. Cộng dồn vào tổng tiền của hóa đơn
        this.tongTien += thanhTienVe;
    }

    /**
     * Thực hiện thanh toán cho đúng số tiền hóa đơn
     */
    public void thucHienThanhToan(String maGD, String ngayLap, PhuongThucThanhToanEnum phuongThuc)
            throws PaymentException {

        // So sánh trực tiếp với hằng số Enum thay vì dùng chuỗi String
        if (TrangThaiGiaoDichEnum.DA_THANH_TOAN.equals(this.trangThai)) {
            throw new PaymentException("Lỗi: Hóa đơn " + this.maHoaDon + " đã được thanh toán trước đó!");
        }

        if (this.danhSachItemVe.isEmpty() || this.tongTien <= 0) {
            throw new PaymentException("Lỗi: Hóa đơn không có vé hợp lệ để thanh toán!");
        }

        // Tạo giao dịch thanh toán đúng bằng tổng tiền hóa đơn, truyền đúng kiểu Enum trạng thái DA_THANH_TOAN
        this.thongTinPayment = new Payment(maGD, ngayLap, this.tongTien, phuongThuc, TrangThaiGiaoDichEnum.DA_THANH_TOAN, this.maHoaDon);
        this.trangThai = TrangThaiGiaoDichEnum.DA_THANH_TOAN;
    }

    /**
     * IN HÓA ĐƠN VÀ PHẦN THANH TOÁN (ĐÃ BỎ PHẦN TIỀN THỪA)
     */
    public void inHoaDon(NhanVien nv) {
        System.out.println("\n================================================================================");
        System.out.println("                         HÓA ĐƠN XEM PHIM - SMARTCINEMA                         ");
        System.out.println("================================================================================");
        System.out.println(" Mã hóa đơn   : " + this.maHoaDon);
        System.out.println(" Ngày lập     : " + this.ngayLap);
        System.out.println(" Thu ngân     : " + (nv != null ? nv.getHoTen() + " (" + nv.getMaNV() + ")" : this.maNV));
        System.out.println(" Khách hàng   : " + (this.khachHang != null ? this.khachHang.getHoTen() + " - SĐT: " + this.khachHang.getSdt() : "Khách vãng lai"));
        System.out.println(" Hạng thành viên: " + (this.loaiKhachHang != null ? this.loaiKhachHang.getNoiDung() + " (Giảm " + (this.loaiKhachHang.getTyLeGiamGia() * 100) + "%)" : "Không có"));
        System.out.println(" Trạng thái   : " + this.trangThai);
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(" DANH SÁCH VÉ:");

        for (int i = 0; i < this.danhSachItemVe.size(); i++) {
            ChiTietItemVe item = this.danhSachItemVe.get(i);
            System.out.printf(" [%02d] Phim: %s (%s)\n", (i + 1), item.getPhim().getTenPhim(), item.getNhomPhim().getTenNhomPhim());
            System.out.printf("      Loại vé: %s | Giá gốc: %,.0f VNĐ | Phụ phí: +%,.0f VNĐ\n",
                    item.getLoaiVe().getTenLoaiVe(), item.getGiaGoc(), item.getPhuPhi());
            System.out.printf("      Giảm loại vé: -%.0f%% | Giảm thành viên: -%.0f%%\n",
                    item.getGiamGiaVe() * 100, item.getGiamGiaKhachHang() * 100);
            System.out.printf("      => THÀNH TIỀN: %,.0f VNĐ\n", item.getThanhTien());
            System.out.println("      - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        }

        System.out.println("--------------------------------------------------------------------------------");
        System.out.printf(" 💰 TỔNG CỘNG HÓA ĐƠN : %,15.0f VNĐ\n", this.tongTien);
        System.out.println("================================================================================");

        // In kèm thông tin thanh toán (Payment)
        if (this.thongTinPayment != null) {
            this.thongTinPayment.inThongTinThanhToan();
            System.out.println("================================================================================\n");
        } else {
            System.out.println(" ⚠️ Hóa đơn chưa hoàn tất thanh toán.");
            System.out.println("================================================================================\n");
        }
    }

    // Getters
    public String getMaHoaDon() { return maHoaDon; }
    public double getTongTien() { return tongTien; }
    public TrangThaiGiaoDichEnum getTrangThai() { return trangThai; } // Cập nhật getter trả về Enum
    public Payment getThongTinPayment() { return thongTinPayment; }
    public String getNgayLap() {
        return ngayLap;
    }
    public KhachHang getKhachHang() { return khachHang; }
    public List<ChiTietItemVe> getDanhSachItemVe() { return danhSachItemVe; }
}