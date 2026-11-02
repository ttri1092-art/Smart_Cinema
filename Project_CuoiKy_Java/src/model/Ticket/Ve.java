package model.Ticket;

public class Ve {
    private String maVe;
    private double giaCoBan;
    private String maLoaiVe;
    private String maHoaDon; // Khóa ngoại liên kết HoaDon

    // Cập nhật Constructor thêm maHoaDon
    public Ve(String maVe, double giaCoBan, String maLoaiVe, String maHoaDon) {
        this.maVe = maVe;
        this.giaCoBan = giaCoBan;
        this.maLoaiVe = maLoaiVe;
        this.maHoaDon = maHoaDon;
    }

    public String getMaVe() { return maVe; }
    public void setMaVe(String maVe) { this.maVe = maVe; }
    public double getGiaCoBan() { return giaCoBan; }
    public void setGiaCoBan(double giaCoBan) { this.giaCoBan = giaCoBan; }
    public String getMaLoaiVe() { return maLoaiVe; }
    public void setMaLoaiVe(String maLoaiVe) { this.maLoaiVe = maLoaiVe; }

    // Getter/Setter cho khóa ngoại
    public String getMaHoaDon() { return maHoaDon; }
    public void setMaHoaDon(String maHoaDon) { this.maHoaDon = maHoaDon; }
}