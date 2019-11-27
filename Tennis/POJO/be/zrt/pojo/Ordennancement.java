package be.zrt.pojo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Ordennancement {
	private int nbrDeSetGagnant;
	private String typeDeTournoi; // simple H/F || double || mixte
	private ArrayList<Equipe> listeDesEquipe;
	private ArrayList<Match> listeDesMatchs;

	public Ordennancement(String typeDeTournoi, int nbrDeSetGagnant, ArrayList<Joueur> listeJoueur) {
		this.typeDeTournoi = typeDeTournoi;
		this.nbrDeSetGagnant = nbrDeSetGagnant;
		generationEquipe(listeJoueur);
	}

	public Ordennancement(String typeDeTournoi, int nbrDeSetGagnant, ArrayList<Joueur> listeJoueurHomme,
			ArrayList<Joueur> listeJoueurFemme) {
		this.typeDeTournoi = typeDeTournoi;
		this.nbrDeSetGagnant = nbrDeSetGagnant;
		generationEquipe(listeJoueurHomme, listeJoueurFemme);
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

}
