using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace model
{
    public class Ve
    {
        private string maVe;
        private double giaCoBan;
        private string maLoaiVe;
        private string maHoaDon; 
       
        public Ve(string maVe, double giaCoBan, string maLoaiVe, string maHoaDon)
        {
            this.maVe = maVe;
            this.giaCoBan = giaCoBan;
            this.maLoaiVe = maLoaiVe;
            this.maHoaDon = maHoaDon;
        }

        public string getMaVe() { return maVe; }
        public void setMaVe(string maVe) { this.maVe = maVe; }

        public double getGiaCoBan() { return giaCoBan; }
        public void setGiaCoBan(double giaCoBan) { this.giaCoBan = giaCoBan; }
        public string getMaLoaiVe() { return maLoaiVe; }
        public void setMaLoaiVe(string maLoaiVe) { this.maLoaiVe = maLoaiVe; }
        public string getMaHoaDon() { return maHoaDon; }
        public void setMaHoaDon(string maHoaDon) { this.maHoaDon = maHoaDon; }
    }
}