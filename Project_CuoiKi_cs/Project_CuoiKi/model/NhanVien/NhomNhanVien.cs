using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace model
{
    public class NhomNhanVien
    {
        private string maNhomNV;
        private string noiDung;

        public NhomNhanVien(string maNhomNV, string noiDung)
        {
            this.maNhomNV = maNhomNV;
            this.noiDung = noiDung;
        }

        public string getMaNhomNV() { return maNhomNV; }
        public void setMaNhomNV(string maNhomNV) { this.maNhomNV = maNhomNV; }
        public string getNoiDung() { return noiDung; }
        public void setNoiDung(string noiDung) { this.noiDung = noiDung; }
    }
}
