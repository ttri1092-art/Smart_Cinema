using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace model
{
    public class QuanlyCalamviec
    {
        private string maCa; 
        private string maNV; 
        private string congViec; 

        public QuanlyCalamviec(string maCa, string maNV, string congViec)
        {
            this.maCa = maCa;
            this.maNV = maNV; 
            this.congViec = congViec;
        }

        public string getMaCa() { return maCa; }
        public void setMaCa(string maCa) { this.maCa = maCa; }

        public string getMaNV() { return maNV; }
        public void setMaNV(string maNV) { this.maNV = maNV; }

        public string getCongViec() { return congViec; }
        public void setCongViec(string congViec) { this.congViec = congViec; }

    }
}