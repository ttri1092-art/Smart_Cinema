using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace model
{
    public class LoaiVe
    {
        private string maLoaiVe;
        private string tenLoaiVe;
        private double mucGiamGia;

        public LoaiVe(string maLoaiVe, string tenLoaiVe, double mucGiamGia)
        {
            this.maLoaiVe = maLoaiVe;
            this.tenLoaiVe = tenLoaiVe;
            this.mucGiamGia = mucGiamGia;
        }

        public string getMaLoaiVe() { return maLoaiVe; }
        public void setMaLoaiVe(string maLoaiVe) { this.maLoaiVe = maLoaiVe; }

        public string getTenLoaiVe() { return tenLoaiVe; }
        public void setTenLoaiVe(string tenLoaiVe) { this.tenLoaiVe = tenLoaiVe; }

        public double getMucGiamGia() { return mucGiamGia; }
        public void setMucGiamGia(double mucGiamGia) { this.mucGiamGia = mucGiamGia; }

    }
}
