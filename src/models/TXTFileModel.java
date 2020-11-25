package models;

public class TXTFileModel {
    String prenume;
    String nume;
    String grupa;
    String bursa;
    String media;

    public TXTFileModel(String[] data) {
       this.nume = data[0];
       this.prenume = data[1];
       this.grupa = data[2];
       this.bursa = data[3];
       this.media = data[4];
    }

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

    public String getMedia() { return media; }

    public void setMedia(String media) { this.media = media; }

    public String getValue(int j) {
        switch (j) {
            case 0 -> {
                return nume;
            }
            case 1 -> {
                return prenume;
            }
            case 2 -> {
                return grupa;
            }
            case 3 -> {
                return bursa;
            }
            case 4 -> {
                return media;
            }
            default -> {
                return null;
            }
        }
    }
}
