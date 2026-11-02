package model.Phim;

public class NhomPhim {
    private String maNhomPhim;
    private String tenNhomPhim;
    private String noiDung;
    private double phuPhi; // Phụ phí theo nhóm/định dạng (Ví dụ: 3D phụ phí 30,000đ)

    public NhomPhim(String maNhomPhim, String tenNhomPhim, String noiDung, double phuPhi) {
        this.maNhomPhim = maNhomPhim;
        this.tenNhomPhim = tenNhomPhim;
        this.noiDung = noiDung;
        this.phuPhi = phuPhi;
    }

    public String getMaNhomPhim() { return maNhomPhim; }
    public void setMaNhomPhim(String maNhomPhim) { this.maNhomPhim = maNhomPhim; }
    public String getTenNhomPhim() { return tenNhomPhim; }
    public void setTenNhomPhim(String tenNhomPhim) { this.tenNhomPhim = tenNhomPhim; }
    public String getNoiDung() { return noiDung; }
    public void setNoiDung(String noiDung) { this.noiDung = noiDung; }
    public double getPhuPhi() { return phuPhi; }
    public void setPhuPhi(double phuPhi) { this.phuPhi = phuPhi; }
}