package be.zrt.pojo;

import java.util.ArrayList;
import java.util.Date;

public class Match {

	private Date dateDuMatch;
	private Date duree;
	private int tour;

	private ArrayList<Equipe> lesJoueurs;
	private Court terrain;
	private Arbitre arbitre;

	public Match(ArrayList<Equipe> lesJoueurs, Arbitre aribtre, Date dateDuMatch) {
		this.lesJoueurs = lesJoueurs;
		this.arbitre = arbitre;
		this.dateDuMatch = dateDuMatch;
	}
}
