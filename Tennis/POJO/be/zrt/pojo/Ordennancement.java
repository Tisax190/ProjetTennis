package be.zrt.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Ordennancement {
	private int nbrDeSetGagnant;
	private String typeDeTournoi; // simple H/F || double || mixte
	private ArrayList<Equipe> listeDesEquipe;
	private ArrayList<Match> listeDesMatchs;
	private ArrayList<Arbitre> listeDesArbitres;
	private Boolean fini;

	public Ordennancement(String typeDeTournoi, int nbrDeSetGagnant, ArrayList<Joueur> listeJoueur) {
		// génération arbitre via bdd
		Arbitre arbitre = new Arbitre("test", "test", "test");
		this.listeDesArbitres = arbitre.fetchArbitre();
		this.typeDeTournoi = typeDeTournoi;
		this.nbrDeSetGagnant = nbrDeSetGagnant;
		generationEquipe(listeJoueur);
		this.listeDesMatchs = new ArrayList<Match>();
		fini = false;

	}

	public Ordennancement(String typeDeTournoi, int nbrDeSetGagnant, ArrayList<Joueur> listeJoueurHomme,
			ArrayList<Joueur> listeJoueurFemme) {
		this.typeDeTournoi = typeDeTournoi;
		// génération arbitre via bdd
		Arbitre arbitre = new Arbitre("test", "test", "test");
		this.listeDesArbitres = arbitre.fetchArbitre();
		this.nbrDeSetGagnant = nbrDeSetGagnant;
		generationEquipe(listeJoueurHomme, listeJoueurFemme);
		this.listeDesMatchs = new ArrayList<Match>();
		fini = false;

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
			Random rdm = new Random();
			this.listeDesMatchs.add(new Match(tmpList, this.listeDesArbitres.get(rdm.nextInt(14)), nbrDeSetGagnant)); // lien
																														// db
			// ici
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
		if (listeDesEquipe.size() == 1) {
			fini = true;
			System.out.println("fin du tournoi " + this.typeDeTournoi + " le gagnant est : " + this.listeDesEquipe.toString());
		}
		listeDesMatchs.clear();
		if (this.typeDeTournoi == "mixte") {
			//System.out.println(listeDesEquipe);
			//System.out.println(listeDesEquipe.size());
		}

	}

	public String getType() {
		return this.typeDeTournoi;
	}

	public Boolean getFinale() {
		return this.fini;
	}

	@Override
	public String toString() {
		return this.typeDeTournoi;
	}
}
