package be.zrt.pojo;

import java.util.ArrayList;

public class Calendrier {

	private int jour; // jour du mois
	private int heure;// 9h ou 16h
	private Court terrain;
	private Boolean dateBloquee;

	public Calendrier() {

	}

	public Calendrier(int jour, int heure) {
		dateBloquee = false;
		this.jour = jour;
		this.heure = heure;
	}

	public int getJour() {
		return jour;
	}

	public ArrayList<Calendrier> generation(ArrayList<Court> listeCourt) {
		ArrayList<Calendrier> listeCalendrier = new ArrayList<Calendrier>();
		for (int i = 0; i < 21; i++) { // 21 = jours
			for (int j = 0; j < 30; j++) { // 30 match par jours (15 court x 2 match)
				if (j % 2 == 0) {
					listeCalendrier.add(new Calendrier(i + 1, 9));
				} else {
					listeCalendrier.add(new Calendrier(i + 1, 13));
				}

			}
		}
		int cpt = 0;
		for (int i = 0; i < listeCalendrier.size(); i += 2) {
			if (cpt > 14)
				cpt = 0;

			listeCalendrier.get(i).setCourt(listeCourt.get(cpt));
			listeCalendrier.get(i + 1).setCourt(listeCourt.get(cpt++));
		}
		return listeCalendrier;
	}

	public int getHeure() {
		return heure;
	}

	public Court getCourt() {
		return terrain;
	}

	public Boolean getBloq() {
		return dateBloquee;
	}

	public void setCourt(Court terrain) {
		this.terrain = terrain;
	}

	public void setBloq(Boolean pris) {
		this.dateBloquee = pris;
	}

}
