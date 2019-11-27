package be.zrt.pojo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public final class Tournoi {
	ArrayList<Ordennancement> typeTournoi;
	ArrayList<Joueur> listeJoueurHomme;
	ArrayList<Joueur> listeJoueurFemme;
	ArrayList<Calendrier> listeCalendrier;
	private static volatile Tournoi instance = null;

	private Tournoi() {
		super();
		this.typeTournoi = new ArrayList<Ordennancement>();
		this.listeCalendrier = new ArrayList<Calendrier>();
		this.genererCalendrier();
		generationListeJoueurHomme(); // méthode pour générer les joueurs et les noms depuis un fichier txt remplis à
		// l'avance
		generationListeJoueurFemme(); // pour montrer l'utilisation de fichier vu en classe
		typeTournoi.add(new Ordennancement("simpleHomme", 5, listeJoueurHomme));
		typeTournoi.add(new Ordennancement("simpleFemme", 3, listeJoueurFemme));
		typeTournoi.add(new Ordennancement("doubleHomme", 3, listeJoueurHomme));
		typeTournoi.add(new Ordennancement("doubleFemme", 3, listeJoueurFemme));
		typeTournoi.add(new Ordennancement("mixte", 3, listeJoueurHomme, listeJoueurFemme));
	}

	private int nbrMatch() {
		int cpt = 0;
		for (Ordennancement ord : typeTournoi) {
			cpt += ord.getListeDesMatchs().size();
		}
		System.out.println(cpt);
		return cpt;
	}

	public void ordreDesMatchs() {
		Ordennancement[] tabMatch = new Ordennancement[5];
		for (int i = 0; i < 5; i++) {
			tabMatch[i] = typeTournoi.get(i);
		}
		for (int i = 0; i < tabMatch.length; i++) {
			for (int j = 0; j < tabMatch[i].getListeDesMatchs().size(); j++) {
				for (int k = 0; k < this.listeCalendrier.size(); k++) {
					if (!listeCalendrier.get(k).getBloq()) {
						tabMatch[i].getListeDesMatchs().get(j).setDate(listeCalendrier.get(k).getJour(),
								listeCalendrier.get(k).getHeure());
						this.listeCalendrier.get(k).setBloq(true);
						
					}
				}
			}
		}

	}

	private void genererCalendrier() {
		for (int i = 0; i < 21; i++) { // 21 = jours
			for (int j = 0; j < 30; j++) { // 30 match par jours (15 court x 2 match)
				if (j % 2 == 0) {
					this.listeCalendrier.add(new Calendrier(i, 9));
				} else {
					this.listeCalendrier.add(new Calendrier(i, 13));
				}

			}
		}
	}

	public final static Tournoi getInstance() {
		if (Tournoi.instance == null) {
			// Le mot-clé synchronized sur ce bloc empêche toute instanciation
			// multiple même par différents "threads".
			// Il est TRES important.
			synchronized (Tournoi.class) {
				if (Tournoi.instance == null) {
					Tournoi.instance = new Tournoi();
				}
			}
		}
		return Tournoi.instance;
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
	
	public ArrayList<Ordennancement> getTypeTournoi()
	{
		return typeTournoi;
	}

	public void jouer() {
		for (Ordennancement x : typeTournoi) {
			x.jouer();
		}
		
	}
}
