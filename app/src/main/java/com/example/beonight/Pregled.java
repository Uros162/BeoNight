package com.example.beonight;

public class Pregled {

    private String ime;
    private String radnoVreme;
    private int slika;

    public Pregled(String ime, String radnoVreme,int slika) {
        this.ime = ime;
        this.radnoVreme = radnoVreme;
        this.slika = slika;
    }

    public int getSlika() {
        return slika;
    }

    public void setSlika(int slika) {
        this.slika = slika;
    }

    public String getIme() {
        return ime;
    }

    public String getRadnoVreme() {
        return radnoVreme;
    }
}
