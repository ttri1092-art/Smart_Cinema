package model.Phim;

public class Phim {
    private String maPhim;
    private String tenPhim;
    private String theLoai;      // Thể loại phim (Hành động, Tình cảm,...)
    private double giaCoBan;     // Giá gốc của phim
    private String noiDung;
    private String maNhomPhim;   // Liên kết tới nhóm phim (2D, 3D,...)

    public Phim(String maPhim, String tenPhim, String theLoai, double giaCoBan, String noiDung, String maNhomPhim) {
        this.maPhim = maPhim;
        this.tenPhim = tenPhim;
        this.theLoai = theLoai;
        this.giaCoBan = giaCoBan;
        this.noiDung = noiDung;
        this.maNhomPhim = maNhomPhim;
    }

    public String getMaPhim() { return maPhim; }
    public void setMaPhim(String maPhim) { this.maPhim = maPhim; }
    public String getTenPhim() { return tenPhim; }
    public void setTenPhim(String tenPhim) { this.tenPhim = tenPhim; }
    public String getTheLoai() { return theLoai; }
    public void setTheLoai(String theLoai) { this.theLoai = theLoai; }
    public double getGiaCoBan() { return giaCoBan; }
    public void setGiaCoBan(double giaCoBan) { this.giaCoBan = giaCoBan; }
    public String getNoiDung() { return noiDung; }
    public void setNoiDung(String noiDung) { this.noiDung = noiDung; }
    public String getMaNhomPhim() { return maNhomPhim; }
    public void setMaNhomPhim(String maNhomPhim) { this.maNhomPhim = maNhomPhim; }
}