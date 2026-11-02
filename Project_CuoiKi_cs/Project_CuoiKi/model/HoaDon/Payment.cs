using System;

namespace model
{
    public class Payment
    {
        private string maThanhToan;
        private string ngayLap;
        private double tongTien;
        private PhuongThucThanhToanEnum phuongThuc;
        private TrangThaiGiaoDichEnum trangThai;
        private string maHoaDon;

        public Payment(string maThanhToan, string ngayLap, double tongTien,
                       PhuongThucThanhToanEnum phuongThuc, TrangThaiGiaoDichEnum trangThai, string maHoaDon)
        {
            this.maThanhToan = maThanhToan;
            this.ngayLap = ngayLap;
            this.tongTien = tongTien;
            this.phuongThuc = phuongThuc;
            this.trangThai = trangThai;
            this.maHoaDon = maHoaDon;
        }

        public void inThongTinThanhToan()
        {
            Console.WriteLine("---------- THÔNG TIN THANH TOÁN (PAYMENT) ----------");
            Console.WriteLine(" Mã giao dịch    : " + this.maThanhToan);
            Console.WriteLine(" Thời gian GD    : " + this.ngayLap);
            Console.WriteLine(" Phương thức     : " + this.phuongThuc);
            Console.WriteLine(" Số tiền đã trả  : " + string.Format("{0:#,##0}", this.tongTien) + " VNĐ");
            Console.WriteLine(" Trạng thái GD   : " + this.trangThai);
            Console.WriteLine("----------------------------------------------------");
        }

        public string getMaHoaDon() { return maHoaDon; }
        public double getTongTien() { return tongTien; }
        public PhuongThucThanhToanEnum getPhuongThuc() { return phuongThuc; }
        public TrangThaiGiaoDichEnum getTrangThai() { return trangThai; }
    }
}