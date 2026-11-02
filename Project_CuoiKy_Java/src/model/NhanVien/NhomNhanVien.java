package model.NhanVien;

public class NhomNhanVien {
    private String maNhomNV;
    private String noiDung;

    public NhomNhanVien(String maNhomNV, String noiDung) {
        this.maNhomNV = maNhomNV;
        this.noiDung = noiDung;
    }

    public String getMaNhomNV() { return maNhomNV; }
    public void setMaNhomNV(String maNhomNV) { this.maNhomNV = maNhomNV; }
    public String getNoiDung() { return noiDung; }
    public void setNoiDung(String noiDung) { this.noiDung = noiDung; }
}