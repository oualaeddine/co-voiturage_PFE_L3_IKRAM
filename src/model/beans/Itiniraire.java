package model.beans;

public class Itiniraire {
    private Ville depart, arrive;
    private float prix;
    private int id;

    public Itiniraire() {
    }

    public Ville getDepart() {
        return depart;
    }

    public void setDepart(Ville depart) {
        this.depart = depart;
    }

    public Ville getArrive() {
        return arrive;
    }

    public void setArrive(Ville arrive) {
        this.arrive = arrive;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
