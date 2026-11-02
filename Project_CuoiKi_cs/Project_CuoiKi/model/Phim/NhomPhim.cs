namespace model
{
    public class NhomPhim
    {
        private string maNhomPhim;
        private string tenNhomPhim;
        private string noiDung;
        private double phuPhi;

        public NhomPhim(string maNhomPhim, string tenNhomPhim, string noiDung, double phuPhi)
        {
            this.maNhomPhim = maNhomPhim;
            this.tenNhomPhim = tenNhomPhim;
            this.noiDung = noiDung;
            this.phuPhi = phuPhi;
        }

        public string getMaNhomPhim() { return maNhomPhim; }
        public string getTenNhomPhim() { return tenNhomPhim; }
        public string getNoiDung() { return noiDung; }
        public double getPhuPhi() { return phuPhi; }
    }
}