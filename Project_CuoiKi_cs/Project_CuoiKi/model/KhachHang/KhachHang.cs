using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace model
{
    public class KhachHang
    {
        private string maKhachHang; 
        private string hoTen; 
        private string ngaySinh; 
        private string diaChi; 
        private string sdt; 
        private string email; 
        private string maLoaiKhachHang;

        public KhachHang(string maKhachHang, string hoTen, string ngaySinh, string diaChi, string sdt, string email, string maLoaiKhachHang)
        {
            this.maKhachHang = maKhachHang;
            this.hoTen = hoTen;
            this.ngaySinh = ngaySinh;
            this.diaChi = diaChi;
            this.sdt = sdt;
            this.email = email;
            this.maLoaiKhachHang = maLoaiKhachHang;
        }

        public string getMaKhachHang() { return maKhachHang; }
        public void setMaKhachHang(string maKhachHang) { this.maKhachHang = maKhachHang; }
        public string getHoTen() { return hoTen; }
        public void setHoTen(string hoTen) { this.hoTen = hoTen; }

        public string getNgaySinh() { return ngaySinh; }
        public void setNgaySinh(string ngaySinh) { this.ngaySinh = ngaySinh; }

        public string getDiaChi() { return diaChi; }
        public void setDiaChi(string diaChi) { this.diaChi=diaChi; }

        public string getSdt() { return sdt; }
        public void setSdt(string sdt) {this.sdt=sdt; }

        public string getEmail() { return email; }
        public void setEmail(string email) { this.email=email; }

        public string getMaLoaiKhachHang() { return maLoaiKhachHang; }
        public void setMaLoaiKhachHang(string maLoaiKhachHang) { this.maLoaiKhachHang=maLoaiKhachHang; }

    }
}
