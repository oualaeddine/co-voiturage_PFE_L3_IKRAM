package model.beans;

import java.sql.Date;
import java.sql.Time;

public class Trajet {
	private int id,nombrePlaces;
    private boolean etat;
    private User createur;
    private Date date;
	private Ville depart, arrive;
    private float prix;
    private String typeVéhicule;
    private Time heure;
	
    public Trajet() {
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isEtat() {
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

	public int getNombrePlaces() {
		return nombrePlaces;
	}

	public void setNombrePlaces(int nombrePlaces) {
		this.nombrePlaces = nombrePlaces;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public String getTypeVéhicule() {
		return typeVéhicule;
	}

	public void setTypeVéhicule(String typeVéhicule) {
		this.typeVéhicule = typeVéhicule;
	}

	public Ville getDepart() {
		return depart;
	}

	public void setDepart(Ville depart) {
		this.depart = depart;
	}


	@Override
	public String toString() {
		return "Trajet{" +
				"id=" + id +
				", nombrePlaces=" + nombrePlaces +
				", etat=" + etat +
				", createur=" + createur +
				", date=" + date +
				", depart=" + depart +
				", arrive=" + arrive +
				", prix=" + prix +
				", typeVéhicule='" + typeVéhicule + '\'' +
				'}';
	}

	public Time getHeure() {
		return heure;
	}

	public void setHeure(Time heure) {
		this.heure = heure;
	}
}
