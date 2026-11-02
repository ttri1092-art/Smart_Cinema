package model.NhanVien;

public class QuanlyCalamviec {
    private String maCa;
    private String maNV;
    private String congViec;

    public QuanlyCalamviec(String maCa, String maNV, String congViec) {
        this.maCa = maCa;
        this.maNV = maNV;
        this.congViec = congViec;
    }

    public String getMaCa() { return maCa; }
    public void setMaCa(String maCa) { this.maCa = maCa; }
    public String getMaNV() { return maNV; }
    public void setMaNV(String maNV) { this.maNV = maNV; }
    public String getCongViec() { return congViec; }
    public void setCongViec(String congViec) { this.congViec = congViec; }
}