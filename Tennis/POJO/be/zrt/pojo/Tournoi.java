package be.zrt.pojo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Tournoi {
	ArrayList<Ordennancement> typeTournoi;
	ArrayList<Joueur> listeJoueurHomme;
	ArrayList<Joueur> listeJoueurFemme;

	public Tournoi(ArrayList<Ordennancement> typeTournoi) {
		this.typeTournoi = typeTournoi;
	}

	public Tournoi() {
		this.typeTournoi = new ArrayList<Ordennancement>();
		generationListeJoueurHomme(); // méthode pour générer les joueurs et les noms depuis un fichier txt remplis à
		// l'avance
		generationListeJoueurFemme(); // pour montrer l'utilisation de fichier vu en classe
		typeTournoi.add(new Ordennancement("simpleHomme", 5, listeJoueurHomme));
		typeTournoi.add(new Ordennancement("simpleFemme", 3, listeJoueurFemme));
		typeTournoi.add(new Ordennancement("doubleHomme", 3, listeJoueurHomme));
		typeTournoi.add(new Ordennancement("doubleFemme", 3, listeJoueurFemme));
		typeTournoi.add(new Ordennancement("mixte", 3,listeJoueurHomme,listeJoueurFemme));
	}

	private void generationListeJoueurHomme() {
		String nomFich = "nomHomme.txt";
		String ligne;
		String nom;
		String prenom;
		String tmp[];
		this.listeJoueurHomme = new ArrayList<Joueur>();
		try (BufferedReader entree = new BufferedReader(new FileReader(nomFich))) {
			while ((ligne = entree.readLine()) != null) {
				tmp = ligne.split(" ");
				prenom = tmp[0];
				nom = tmp[1];
				this.listeJoueurHomme.add(new Joueur(nom, prenom, "homme"));
			}

		} catch (Exception e) {

		}
	}

	private void generationListeJoueurFemme() {
		String nomFich = "nomFemme.txt";
		String ligne;
		String nom;
		String prenom;
		String tmp[];
		this.listeJoueurFemme = new ArrayList<Joueur>();
		try (BufferedReader entree = new BufferedReader(new FileReader(nomFich))) {
			while ((ligne = entree.readLine()) != null) {
				tmp = ligne.split(" ");
				prenom = tmp[0];
				nom = tmp[1];
				this.listeJoueurFemme.add(new Joueur(nom, prenom, "femme"));
			}

		} catch (Exception e) {

		}
	}
}
