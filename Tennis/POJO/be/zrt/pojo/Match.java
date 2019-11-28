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
	private int scoreJeuB; // 1=15 2 = 30 3 = 40 4 = jeu 5 = av
	private int scoreSetA;
	private int scoreSetB;
	private String score;

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
		/*
		 * Boolean fin = false; switch (key) { case "simpleHomme": int cpt = 1; do {
		 * 
		 * int tmp = this.calculJeu(); if (cpt == 6) { tmp = 0; fin = true; // faire la
		 * fin } if (tmp == 1) { this.scoreSetA++; if (scoreSetA == 6 && scoreSetB < 5)
		 * { this.score += "6/" + scoreSetB + " "; this.scoreSetA = 0; this.scoreJeuB =
		 * 0; cpt++; } } else if (scoreSetA == 6 && scoreSetB == 6) { // tieBreak } else
		 * if (tmp == 2) { this.scoreSetB++; if (scoreSetB == 6 && scoreSetA < 5) {
		 * this.score += scoreSetA + "/" + scoreSetB + " "; this.scoreSetA = 0;
		 * this.scoreJeuB = 0; cpt++; } else if (scoreSetA == 6 && scoreSetB == 6) { //
		 * tieBreak } }
		 * 
		 * } while (!fin); break; case "simpleFemme":
		 * 
		 * break; case "doubleHomme":
		 * 
		 * break; case "doubleFemme":
		 * 
		 * break; case "doubleMixte": break; }
		 */
		this.vainqueur = this.lesJoueurs.get(0);
		return this.vainqueur;
	}

	private int calculJeu() {
		Random rdm = new Random();
		scoreJeuA = 0;
		scoreJeuB = 0;
		do {
			if ((scoreJeuA == 4 && scoreJeuB < 3)) {
				return 1;
			} else if (scoreJeuB == 4 && scoreJeuA < 3) {
				return 2;
			} else if (scoreJeuA == 4 && scoreJeuB == 4) {
				scoreJeuA = 3;
				scoreJeuB = 3;
			} else if (scoreJeuA == 5 && scoreJeuB == 3) {
				return 1;
			} else if (scoreJeuB == 5 && scoreJeuA == 3) {
				return 2;
			} else if (rdm.nextInt() % 2 == 0) {
				this.scoreJeuA++;
			} else {
				this.scoreJeuB++;
			}
		} while (true);

	}
}
