package model.Ticket;

public class Rap {
    private String maRap;
    private String noiDung;

    public Rap(String maRap, String noiDung) {
        this.maRap = maRap;
        this.noiDung = noiDung;
    }

    public String getMaRap() { return maRap; }
    public void setMaRap(String maRap) { this.maRap = maRap; }
    public String getNoiDung() { return noiDung; }
    public void setNoiDung(String noiDung) { this.noiDung = noiDung; }
}