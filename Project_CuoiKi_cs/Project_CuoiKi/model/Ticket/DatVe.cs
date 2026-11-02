using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace model
{
    public class DatVe
    {
        private string maDatVe;
        private string ngayDat;
        private double tongTien;
        private string maHoaDon; 

        public DatVe(string maDatVe, string ngayDat, double tongTien, string maHoaDon)
        {
            this.maDatVe = maDatVe;
            this.ngayDat = ngayDat;
            this.tongTien = tongTien;
            this.maHoaDon = maHoaDon;
        }

        public string getMaDatVe() { return maDatVe; }
        public void setMaDatVe(string maDatVe) { this.maDatVe = maDatVe; }
        public string getNgayDat() { return ngayDat; }
        public void setNgayDat(string ngayDat) { this.ngayDat = ngayDat; }
        public double getTongTien() { return tongTien; }
        public void setTongTien(double tongTien) { this.tongTien = tongTien; }
        public string getMaHoaDon() { return maHoaDon; }
        public void setMaHoaDon(string maHoaDon) { this.maHoaDon = maHoaDon; }
    }
}