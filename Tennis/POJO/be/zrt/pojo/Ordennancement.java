package be.zrt.pojo;

import java.util.ArrayList;
import java.util.Date;

public class Ordennancement {
	private int nbrDeSetGagnant;
	private String typeDeTournoi; // simple H/F || double || mixte
	private ArrayList<Equipe> listeDesEquipe;
	private ArrayList<Match> listeDesMatchs;

	public Ordennancement(String typeDeTournoi, int nbrDeSetGagnant, ArrayList<Joueur> listeJoueur) {
		this.typeDeTournoi = typeDeTournoi;
		this.nbrDeSetGagnant = nbrDeSetGagnant;
		generationEquipe(listeJoueur);
		this.listeDesMatchs = new ArrayList<Match>();
	}

	public Ordennancement(String typeDeTournoi, int nbrDeSetGagnant, ArrayList<Joueur> listeJoueurHomme,
			ArrayList<Joueur> listeJoueurFemme) {
		this.typeDeTournoi = typeDeTournoi;
		this.nbrDeSetGagnant = nbrDeSetGagnant;
		generationEquipe(listeJoueurHomme, listeJoueurFemme);
		this.listeDesMatchs = new ArrayList<Match>();
		generationMatch();
	}

	private void generationEquipe(ArrayList<Joueur> listeJoueurHomme, ArrayList<Joueur> listeJoueurFemme) {

		this.listeDesEquipe = new ArrayList<Equipe>();
		for (int i = 0; i < listeJoueurHomme.size(); i++) {
			ArrayList<Joueur> tmpListeJoueur = new ArrayList<Joueur>();
			tmpListeJoueur.add(listeJoueurHomme.get(i));
			tmpListeJoueur.add(listeJoueurFemme.get(i));
			listeDesEquipe.add(new Equipe(tmpListeJoueur));
		}
	}

	private void generationEquipe(ArrayList<Joueur> listeJoueur) {
		if (this.typeDeTournoi == "simpleHomme" || this.typeDeTournoi == "simpleFemme") {
			this.listeDesEquipe = new ArrayList<Equipe>();
			for (int i = 0; i < listeJoueur.size(); i++) {
				ArrayList<Joueur> tmpListeJoueur = new ArrayList<Joueur>();
				tmpListeJoueur.add(listeJoueur.get(i));
				listeDesEquipe.add(new Equipe(tmpListeJoueur));
			}
		} else {
			this.listeDesEquipe = new ArrayList<Equipe>();
			int cpt = 1;
			ArrayList<Joueur> tmpListeJoueur = new ArrayList<Joueur>();
			for (Joueur joueur : listeJoueur) {
				tmpListeJoueur.add(joueur);
				if (cpt % 2 == 0) {
					listeDesEquipe.add(new Equipe(tmpListeJoueur));
					tmpListeJoueur = new ArrayList<Joueur>();
				}
				cpt++;
			}
		}
	}

	public void generationMatch() {
		this.listeDesMatchs = new ArrayList<Match>();
		for (int i = 0; i < listeDesEquipe.size(); i += 2) {
			ArrayList<Equipe> tmpList = new ArrayList<Equipe>();
			tmpList.add(listeDesEquipe.get(i));
			tmpList.add(listeDesEquipe.get(i + 1));
			this.listeDesMatchs.add(new Match(tmpList, new Arbitre("test", "test", "h"))); // lien db ici
		}
	}

	public ArrayList<Match> getListeDesMatchs() {
		return this.listeDesMatchs;
	}

	public void jouer() {
		this.listeDesEquipe.clear();
		for (Match match : listeDesMatchs) {
			this.listeDesEquipe.add(match.jouer());
		}

	}
}
