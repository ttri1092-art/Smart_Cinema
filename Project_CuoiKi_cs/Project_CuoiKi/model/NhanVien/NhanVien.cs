using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace model
{
    public class NhanVien
    {
        private string maNV;
        private string hoTen;
        private string ngaySinh;
        private string diaChi;
        private string sdt;
        private string maNhomNV;

        public NhanVien(string maNV, string hoTen, string ngaySinh, string diaChi, string sdt, string maNhomNV)
        {
            this.maNV = maNV;
            this.hoTen = hoTen;
            this.ngaySinh = ngaySinh;
            this.diaChi = diaChi;
            this.sdt = sdt;
            this.maNhomNV = maNhomNV;
        }

        public string getMaNV() { return maNV; }
        public void setMaNV(string maNV) { this.maNV = maNV; }

        public string getHoTen() { return hoTen; }
        public void setHoTen(string hoTen) { this.hoTen = hoTen; }

        public string getNgaySinh() { return ngaySinh; }
        public void setNgaySinh(string ngaySinh) { this.ngaySinh = ngaySinh; }

        public string getDiaChi() { return diaChi; }
        public void setDiaChi(string diaChi) { this.diaChi = diaChi; }

        public string getSdt() { return sdt; }
        public void setSdt(string sdt) { this.sdt = sdt; }

        public string getMaNhomNV() { return maNhomNV; }
        public void setMaNhomNV(string maNhomNV) { this.maNhomNV = maNhomNV; }

    }
}
