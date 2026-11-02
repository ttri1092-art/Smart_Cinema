using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace model
{
    public class LoaiKhachHang
    {
        private string maLoaiKhachHang;
        private string noiDung;
        private double tyLeGiamGia;

        public LoaiKhachHang(string maLoaiKhachHang, string noiDung, double tyLeGiamGia)
        {
            this.maLoaiKhachHang = maLoaiKhachHang;
            this.noiDung = noiDung;
            this.tyLeGiamGia = tyLeGiamGia;
        }


        public string getMaLoaiKhachHang() { return maLoaiKhachHang; }
        public string getNoiDung() { return noiDung; }
        public double getTyLeGiamGia() { return tyLeGiamGia; }
        public void setTyLeGiamGia(double tyLeGiamGia) { this.tyLeGiamGia = tyLeGiamGia; }

    }
}
