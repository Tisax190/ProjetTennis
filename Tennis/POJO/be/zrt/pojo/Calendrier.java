 package be.zrt.pojo;

public class Calendrier {

	private int jour; // jour du mois
	private int heure;// 9h ou 16h
	private Court terrain;
	private Boolean dateBloquee;

	public Calendrier(int jour, int heure,Court terrain) {
		dateBloquee = false;
		this.jour = jour;
		this.heure = heure;
		this.terrain = terrain;
	}

	public int getJour() {
		return jour;
	}

	public int getHeure() {
		return heure;
	}

	public Boolean getBloq()
	{
		return dateBloquee;
	}
	
	public void setBloq(Boolean pris)
	{
		this.dateBloquee = pris;
	}

}
