using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace model
{
    public class Phim
    {
        private string maPhim;
        private string tenPhim;
        private string theLoai;
        private double giaCoBan;
        private string noiDung;
        private string maNhomPhim;

        public Phim(string maPhim, string tenPhim, string theLoai, double giaCoBan, string noiDung, string maNhomPhim)
        {
            this.maPhim = maPhim;
            this.tenPhim = tenPhim;
            this.theLoai = theLoai;
            this.giaCoBan = giaCoBan;
            this.noiDung = noiDung;
            this.maNhomPhim = maNhomPhim;
        }


        public string getMaPhim() { return maPhim;}
        public void setMaPhim(string maPhim) { this.maPhim = maPhim; }
        public string getTenPhim() { return tenPhim; }
     
        public void setTenPhim(string tenPhim) { this.tenPhim = tenPhim; }

        public string getTheLoai() { return theLoai; }
        public void setTheLoai(string theLoai) { this.theLoai = theLoai; }

        public double getGiaCoBan() { return giaCoBan; }
        public void setGiaCoBan(double giaCoBan) { this.giaCoBan = giaCoBan; }

        public string getNoiDung() { return noiDung; }
        public void setNoiDung(string noiDung) { this.noiDung = noiDung; }

        public string getMaNhomPhim() { return maNhomPhim; }
        public void setMaNhomPhim(string maNhomPhim) { this.maNhomPhim = maNhomPhim; }
    }
}