namespace model
{
    public class Ghe
    {
        private string maGhe;
        private LoaiGheEnum loaiGhe;
        private string maRap;

        public Ghe(string maGhe, LoaiGheEnum loaiGhe, string maRap)
        {
            this.maGhe = maGhe;
            this.loaiGhe = loaiGhe;
            this.maRap = maRap;
        }

        public string getMaGhe() { return maGhe; }
        public LoaiGheEnum getLoaiGhe() { return loaiGhe; }
        public string getMaRap() { return maRap; }
    }
}