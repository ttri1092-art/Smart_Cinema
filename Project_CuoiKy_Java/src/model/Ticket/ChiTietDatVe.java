package model.Ticket;

public class ChiTietDatVe {
    private String maPhim;
    private String maDatVe;
    private String maGhe;

    public ChiTietDatVe(String maPhim, String maDatVe, String maGhe) {
        this.maPhim = maPhim;
        this.maDatVe = maDatVe;
        this.maGhe = maGhe;
    }

    public String getMaPhim() { return maPhim; }
    public void setMaPhim(String maPhim) { this.maPhim = maPhim; }
    public String getMaDatVe() { return maDatVe; }
    public void setMaDatVe(String maDatVe) { this.maDatVe = maDatVe; }
    public String getMaGhe() { return maGhe; }
    public void setMaGhe(String maGhe) { this.maGhe = maGhe; }
}