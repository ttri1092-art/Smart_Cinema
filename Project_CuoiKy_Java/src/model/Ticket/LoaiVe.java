package model.Ticket;

public class LoaiVe {
    private String maLoaiVe;
    private String tenLoaiVe;
    private double mucGiamGia;
    public LoaiVe(String maLoaiVe, String tenLoaiVe, double mucGiamGia) {
        this.maLoaiVe = maLoaiVe;
        this.tenLoaiVe = tenLoaiVe;
        this.mucGiamGia = mucGiamGia;
    }

    public String getMaLoaiVe() { return maLoaiVe; }
    public void setMaLoaiVe(String maLoaiVe) { this.maLoaiVe = maLoaiVe; }
    public String getTenLoaiVe() { return tenLoaiVe; }
    public void setTenLoaiVe(String tenLoaiVe) { this.tenLoaiVe = tenLoaiVe; }
    public double getMucGiamGia() { return mucGiamGia; }
    public void setMucGiamGia(double mucGiamGia) { this.mucGiamGia = mucGiamGia; }
}