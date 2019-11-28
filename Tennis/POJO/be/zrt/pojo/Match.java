package be.zrt.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Match {

	private int dateDuMatch;
	private int heureDuMatch;
	private Equipe vainqueur;
	private int scoreJeuA;
	private int scoreJeuB; // 1=15 2 = 30 3 = 40 4 = jeu 5 = av
	private int scoreSetA[];
	private int scoreSetB[];
	private int nbrSet;
	private Court court;

	private ArrayList<Equipe> lesJoueurs;
	private Court terrain;
	private Arbitre arbitre;

	public Match(ArrayList<Equipe> lesJoueurs, Arbitre arbitre, int dateDuMatch, int nbrSet) {
		this.lesJoueurs = lesJoueurs;
		this.arbitre = arbitre;
		this.dateDuMatch = dateDuMatch;
	}

	public Match(ArrayList<Equipe> lesJoueurs, Arbitre arbitre, int nbrSet) {
		this.lesJoueurs = lesJoueurs;
		this.arbitre = arbitre;
		this.nbrSet = nbrSet;
	}

	public void setDate(int jour, int heure) {
		this.dateDuMatch = jour;
		this.heureDuMatch = heure;
	}

	public int[] getScoreA() {
		return scoreSetA;
	}

	public int[] getScoreB() {
		return scoreSetB;
	}

	public Equipe jouer() {
		System.out.println("Nouveau match ! " + this.lesJoueurs);
		this.scoreSetA = new int[nbrSet];
		this.scoreSetB = new int[nbrSet];
		for (int i = 0; i < nbrSet; i++) {
			if (nbrSet == 3 && i == 2) {
				if (scoreSetA[0] > scoreSetB[0] && scoreSetA[1] > scoreSetB[1]) {
					this.vainqueur = this.lesJoueurs.get(0);
					System.out.println(vainqueur);
					return this.vainqueur;
				} else if (scoreSetB[0] > scoreSetA[0] && scoreSetB[1] > scoreSetA[1]) {
					this.vainqueur = this.lesJoueurs.get(1);
					System.out.println(vainqueur + " " + afficherScore());
					return this.vainqueur;
				}
			} else if (nbrSet == 4) {
				if (i == 4 && scoreSetA[0] > scoreSetB[0] && scoreSetA[1] > scoreSetB[1]
						&& scoreSetA[2] > scoreSetB[2]) {
					this.vainqueur = this.lesJoueurs.get(0);
					System.out.println(vainqueur + " " + afficherScore());
					return this.vainqueur;
				} else if (i == 4 && scoreSetB[0] > scoreSetA[0] && scoreSetB[1] > scoreSetA[1]
						&& scoreSetB[2] > scoreSetA[2]) {
					this.vainqueur = this.lesJoueurs.get(1);
					System.out.println(vainqueur + " " + afficherScore());
					return this.vainqueur;
				} else if (i == 5 && scoreSetA[0] > scoreSetB[0] && scoreSetA[1] > scoreSetB[1]
						&& scoreSetA[2] > scoreSetB[2] && scoreSetA[3] > scoreSetB[3]) {
					this.vainqueur = this.lesJoueurs.get(0);
					System.out.println(vainqueur + " " + afficherScore());
					return this.vainqueur;
				} else if (i == 5 && scoreSetB[0] > scoreSetA[0] && scoreSetB[1] > scoreSetA[1]
						&& scoreSetB[2] > scoreSetA[2] && scoreSetB[3] > scoreSetA[3]) {
					this.vainqueur = this.lesJoueurs.get(1);
					System.out.println(vainqueur + " " + afficherScore());
					return this.vainqueur;
				}

			}
			do {
				if (calculJeu() == 1) {
					this.scoreSetA[i]++;
				} else {
					this.scoreSetB[i]++;
				}
				if (scoreSetA[i] == 6 && scoreSetB[i] < 5) {
					break; // set suivant
				} else if (scoreSetB[i] == 6 && scoreSetA[i] < 5) {
					break; // set suivant
				} else if (scoreSetA[i] == 7 && scoreSetB[i] == 5) {
					break;
				} else if (scoreSetA[i] == 5 && scoreSetB[i] == 7) {
					break;
				} else if (scoreSetA[i] == 6 && scoreSetB[i] == 6) {
					if (tieBreak() == 1) {
						this.scoreSetA[i]++;
					} else {
						this.scoreSetB[i]++;
					}
					break;
				}
			} while (true);
		}
		int cptA = 0;
		for (int x : scoreSetA) {
			cptA += x;
		}
		int cptB = 0;
		for (int x : scoreSetB) {
			cptB += x;
		}
		if (cptA > cptB) {
			this.vainqueur = this.lesJoueurs.get(0);
			System.out.println(vainqueur + " " + afficherScore());
			return this.vainqueur;
		} else {
			this.vainqueur = this.lesJoueurs.get(1);
			System.out.println(vainqueur + " " + afficherScore());
			return this.vainqueur;
		}
	}

	private String afficherScore() {
		String tmp = "";
		for (int i = 0; i < nbrSet; i++) {
			tmp += Integer.toString(this.scoreSetA[i]);
			if (i != nbrSet - 1)
				tmp += "/";
		}
		tmp += " ";
		for (int i = 0; i < nbrSet; i++) {
			tmp += Integer.toString(this.scoreSetB[i]);
			if (i != nbrSet - 1)
				tmp += "/";
		}
		return tmp;
	}

	private int tieBreak() {
		int cptA = 0;
		int cptB = 0;
		Random rdm = new Random();
		do {
			if (rdm.nextInt() % 2 == 0) {
				cptA++;
			} else {
				cptB++;
			}
			if (cptA >= 7 && cptB < cptA - 2) {
				return 1;
			} else if (cptB >= 7 && cptA < cptB - 2) {
				return 2;
			}
		} while (true);
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

	public void setCourt(Court court) {
		this.court = court;
	}
}
