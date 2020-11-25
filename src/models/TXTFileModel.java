package models;

public class TXTFileModel {
    String prenume;
    String nume;
    String grupa;
    String bursa;



    public String getBursa() {
        return bursa;
    }

    public String getGrupa() {
        return grupa;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setGrupa(String grupa) {
        this.grupa = grupa;
    }

    public void setBursa(String bursa) {
        this.bursa = bursa;
    }
}
