package be.zrt.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Match {

	private int dateDuMatch;
	private int heureDuMatch;
	private Date duree;
	private Equipe vainqueur;
	private int scoreJeuA;
	private int scoreJeuB; // 1=15 2 = 30 3 = 40 4 = egal 5 = av
	private int scoreSetA;
	private int scoreSetB;

	private ArrayList<Equipe> lesJoueurs;
	private Court terrain;
	private Arbitre arbitre;

	public Match(ArrayList<Equipe> lesJoueurs, Arbitre arbitre, int dateDuMatch) {
		this.lesJoueurs = lesJoueurs;
		this.arbitre = arbitre;
		this.dateDuMatch = dateDuMatch;
	}

	public Match(ArrayList<Equipe> lesJoueurs, Arbitre arbitre) {
		this.lesJoueurs = lesJoueurs;
		this.arbitre = arbitre;
	}

	public void setDate(int jour, int heure) {
		this.dateDuMatch = jour;
		this.heureDuMatch = heure;
	}

	public Equipe jouer() {
		Boolean fin = false;
		Random rdm = new Random();
		do {
			
		} while (!fin);
	}
	
	private int calculJeu()
	{
		Random rdm = new Random();
	}
}
