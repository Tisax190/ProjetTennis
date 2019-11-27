package be.zrt.pojo;

import java.util.ArrayList;

public class Ordennancement {
	private int nbrDeSetGagant;
	private String typeDeTournoi; // simple H/F || double || mixte
	private ArrayList<Equipe> listeDesJoueurs; // relatif au type de tournoi
	private ArrayList<Match> listeDesMatchs;

	public Ordennancement(ArrayList<Match> listeDesMatchs) {
		this.listeDesMatchs = listeDesMatchs;
	}
}
