using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace model
{
    public class Rap
    {
        private string maRap;
        private string noiDung;

        public Rap(string maRap, string noiDung)
        {
            this.maRap = maRap;
            this.noiDung = noiDung;
        }

        public string getMaRap() { return maRap; }
        public void setMaRap(string maRap) { this.maRap = maRap; }

        public string getNoiDung() { return noiDung; }
        public void setNoiDung(string noiDung) { this.noiDung = noiDung; }

    }
}
