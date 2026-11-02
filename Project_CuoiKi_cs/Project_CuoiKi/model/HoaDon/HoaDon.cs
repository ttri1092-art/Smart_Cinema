using System;
using System.Collections.Generic;
using exception;
using TinhToan;

namespace model
{
    public class HoaDon
    {
        private string maHoaDon;
        private string ngayLap;
        private double tongTien;
        private string maNV;
        private KhachHang khachHang;
        private LoaiKhachHang loaiKhachHang;
        private TrangThaiGiaoDichEnum trangThai;
        private List<ChiTietItemVe> danhSachItemVe;
        private Payment thongTinPayment;

        public HoaDon(string maHoaDon, string ngayLap, string maNV, KhachHang khachHang, LoaiKhachHang loaiKhachHang)
        {
            this.maHoaDon = maHoaDon;
            this.ngayLap = ngayLap;
            this.maNV = maNV;
            this.khachHang = khachHang;
            this.loaiKhachHang = loaiKhachHang;
            this.trangThai = TrangThaiGiaoDichEnum.CHO_XU_LY;
            this.tongTien = 0.0;
            this.danhSachItemVe = new List<ChiTietItemVe>();
            this.thongTinPayment = null;
        }

        public void themVe(Phim phim, NhomPhim nhomPhim, LoaiVe loaiVe)
        {
            double thanhTienVe = PricingCalculator.tinhTongTienMotVe(phim, nhomPhim, loaiVe, this.khachHang, this.loaiKhachHang);

            double giaGoc = phim.getGiaCoBan();
            double phuPhi = (nhomPhim != null) ? nhomPhim.getPhuPhi() : 0.0;
            double giamGiaVe = (loaiVe != null) ? loaiVe.getMucGiamGia() : 0.0;
            double giamGiaKH = (loaiKhachHang != null) ? loaiKhachHang.getTyLeGiamGia() : 0.0;

            ChiTietItemVe item = new ChiTietItemVe(phim, nhomPhim, loaiVe, giaGoc, phuPhi, giamGiaVe, giamGiaKH, thanhTienVe);
            this.danhSachItemVe.Add(item);
            this.tongTien += thanhTienVe;
        }

        public void thucHienThanhToan(string maGD, string ngayLap, PhuongThucThanhToanEnum phuongThuc)
        {
            if (this.trangThai == TrangThaiGiaoDichEnum.DA_THANH_TOAN)
            {
                throw new PaymentException("Lỗi: Hóa đơn " + this.maHoaDon + " đã được thanh toán trước đó!");
            }
            if (this.danhSachItemVe.Count == 0 || this.tongTien <= 0)
            {
                throw new PaymentException("Lỗi: Hóa đơn không có vé hợp lệ để thanh toán!");
            }

            this.thongTinPayment = new Payment(maGD, ngayLap, this.tongTien, phuongThuc, TrangThaiGiaoDichEnum.DA_THANH_TOAN, this.maHoaDon);
            this.trangThai = TrangThaiGiaoDichEnum.DA_THANH_TOAN;
        }

        public void inHoaDon(NhanVien nv)
        {
            Console.WriteLine("\n================================================================================");
            Console.WriteLine("                         HÓA ĐƠN XEM PHIM - SMARTCINEMA                         ");
            Console.WriteLine("================================================================================");
            Console.WriteLine(" Mã hóa đơn   : " + this.maHoaDon);
            Console.WriteLine(" Ngày lập     : " + this.ngayLap);
            Console.WriteLine(" Thu ngân     : " + (nv != null ? nv.getHoTen() + " (" + nv.getMaNV() + ")" : this.maNV));
            Console.WriteLine(" Khách hàng   : " + (this.khachHang != null ? this.khachHang.getHoTen() + " - SĐT: " + this.khachHang.getSdt() : "Khách vãng lai"));
            Console.WriteLine(" Hạng thành viên: " + (this.loaiKhachHang != null ? this.loaiKhachHang.getNoiDung() + " (Giảm " + (this.loaiKhachHang.getTyLeGiamGia() * 100) + "%)" : "Không có"));
            Console.WriteLine(" Trạng thái   : " + this.trangThai);
            Console.WriteLine("--------------------------------------------------------------------------------");
            Console.WriteLine(" DANH SÁCH VÉ:");

            for (int i = 0; i < this.danhSachItemVe.Count; i++)
            {
                ChiTietItemVe item = this.danhSachItemVe[i];
                Console.WriteLine(string.Format(" [{0:D2}] Phim: {1} ({2})", (i + 1), item.getPhim().getTenPhim(), item.getNhomPhim().getTenNhomPhim()));
                Console.WriteLine(string.Format("      Loại vé: {0} | Giá gốc: {1:#,##0} VNĐ | Phụ phí: +{2:#,##0} VNĐ",
                        item.getLoaiVe().getTenLoaiVe(), item.getGiaGoc(), item.getPhuPhi()));
                Console.WriteLine(string.Format("      Giảm loại vé: -{0:0}% | Giảm thành viên: -{1:0}%",
                        item.getGiamGiaVe() * 100, item.getGiamGiaKhachHang() * 100));
                Console.WriteLine(string.Format("      => THÀNH TIỀN: {0:#,##0} VNĐ", item.getThanhTien()));
                Console.WriteLine("      - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
            }

            Console.WriteLine("--------------------------------------------------------------------------------");
            Console.WriteLine(string.Format(" 💰 TỔNG CỘNG HÓA ĐƠN : {0,15:#,##0} VNĐ", this.tongTien));
            Console.WriteLine("================================================================================");

            if (this.thongTinPayment != null)
            {
                this.thongTinPayment.inThongTinThanhToan();
                Console.WriteLine("================================================================================\n");
            }
            else
            {
                Console.WriteLine(" ⚠️ Hóa đơn chưa hoàn tất thanh toán.");
                Console.WriteLine("================================================================================\n");
            }
        }

        public string getMaHoaDon() { return maHoaDon; }
        public double getTongTien() { return tongTien; }
        public string getNgayLap() { return ngayLap; }
        public TrangThaiGiaoDichEnum getTrangThai() { return trangThai; }
        public KhachHang getKhachHang() { return khachHang; }
        public List<ChiTietItemVe> getDanhSachItemVe() { return danhSachItemVe; }
    }
}