package model.beans;

import java.sql.Date;

public class Trajet {

    private int id;
    private Itiniraire itiniraire;
    private boolean etat;
    private User createur;
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepart() {
        return itiniraire.getDepart().getName();
    }

    public void setDepart(String depart) {
        Ville depa = new Ville();
        depa.setName(depart);
        itiniraire.setArrive(depa);
    }

    public String getDesti() {
        return itiniraire.getArrive().getName();
    }

    public void setDesti(String desti) {
        Ville destination = new Ville();
        destination.setName(desti);
        itiniraire.setArrive(destination);
    }

    public boolean isEtatDispo() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public User getCreateur() {
        return createur;
    }

    public void setCreateur(User createur) {
        this.createur = createur;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Itiniraire getItiniraire() {
        return itiniraire;
    }

    public void setItiniraire(Itiniraire itiniraire) {
        this.itiniraire = itiniraire;
    }
}
