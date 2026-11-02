package model.NhanVien;

public class CalamViec {
    private String maCa;
    private String tenCa;
    private String thoiGian;

    public CalamViec(String maCa, String tenCa, String thoiGian) {
        this.maCa = maCa;
        this.tenCa = tenCa;
        this.thoiGian = thoiGian;
    }

    public String getMaCa() { return maCa; }
    public void setMaCa(String maCa) { this.maCa = maCa; }
    public String getTenCa() { return tenCa; }
    public void setTenCa(String tenCa) { this.tenCa = tenCa; }
    public String getThoiGian() { return thoiGian; }
    public void setThoiGian(String thoiGian) { this.thoiGian = thoiGian; }
}