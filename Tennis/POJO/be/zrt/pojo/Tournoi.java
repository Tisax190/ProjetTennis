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
		ArrayList<Ordennancement> tmpList = new ArrayList<Ordennancement>();
		tmpList.add(new Ordennancement("simpleHomme", 5));
		tmpList.add(new Ordennancement("simpleFemme", 3));
		tmpList.add(new Ordennancement("doubleHomme", 3));
		tmpList.add(new Ordennancement("doubleFemme", 3));
		tmpList.add(new Ordennancement("mixte", 3));
		generationListeJoueurHomme(); // méthode pour générer les joueurs et les noms depuis un fichier txt remplis à
										// l'avance
		generationListeJoueurFemme(); // pour montrer l'utilisation de fichier vu en classe
	}

	private void generationListeJoueurHomme() {
		String nomFich = "nomHomme.txt";
		String ligne;
		String nom;
		String prenom;
		String tmp[];
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
