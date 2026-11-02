namespace model
{
    public class ChiTietDatVe
    {
        private string maPhim;
        private string maDatVe;
        private string maGhe;

        public ChiTietDatVe(string maPhim, string maDatVe, string maGhe)
        {
            this.maPhim = maPhim;
            this.maDatVe = maDatVe;
            this.maGhe = maGhe;
        }

        public string getMaPhim() { return maPhim; }
        public string getMaDatVe() { return maDatVe; }
        public string getMaGhe() { return maGhe; }
    }
}