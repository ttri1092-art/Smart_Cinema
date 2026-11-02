package model.Ticket;

import model.Enum.LoaiGheEnum;
public class Ghe {
    private String maGhe;
    private LoaiGheEnum loaiGhe;
    private String maRap;

    public Ghe(String maGhe, LoaiGheEnum loaiGhe, String maRap) {
        this.maGhe = maGhe;
        this.loaiGhe = loaiGhe;
        this.maRap = maRap;
    }

    public LoaiGheEnum getLoaiGhe() { return loaiGhe; }
    public String getMaGhe() { return maGhe; }
    public void setMaGhe(String maGhe) { this.maGhe = maGhe; }
    public String getMaRap() { return maRap; }
    public void setMaRap(String maRap) { this.maRap = maRap; }
}