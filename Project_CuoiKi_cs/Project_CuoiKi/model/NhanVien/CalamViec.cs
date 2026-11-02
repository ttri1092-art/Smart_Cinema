using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace model
{
    public class CalamViec
    {
        private string maCa;
        private string tenCa;
        private string thoiGian;

        public CalamViec(string maCa, string tenCa, string thoiGian)
        {
            this.maCa = maCa;
            this.tenCa = tenCa;
            this.thoiGian = thoiGian;
        }

        public string getMaCa() { return maCa; }
        public void setMaCa(string maCa) { this.maCa = maCa; }
        public string getTenCa() { return tenCa; }
        public void setTenCa(string tenCa) { this.tenCa = tenCa; }
        public string getThoiGian() { return thoiGian; }
        public void setThoiGian(string thoiGian) { this.thoiGian = thoiGian; }
    }
}
