package be.zrt.pojo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public final class Tournoi {
	ArrayList<Ordennancement> typeTournoi;
	ArrayList<Joueur> listeJoueurHomme;
	ArrayList<Joueur> listeJoueurFemme;
	ArrayList<Calendrier> listeCalendrier;
	ArrayList<Court> listeCourt;
	private static volatile Tournoi instance = null;

	private Tournoi() {
		super();
		this.listeCourt = new ArrayList<Court>();
		generationCourt();
		this.typeTournoi = new ArrayList<Ordennancement>();
		this.listeCalendrier = new ArrayList<Calendrier>();
		this.genererCalendrier();
		generationListeJoueurHomme(); // m�thode pour g�n�rer les joueurs et les noms depuis un fichier txt remplis �
		// l'avance
		generationListeJoueurFemme(); // pour montrer l'utilisation de fichier vu en classe
		typeTournoi.add(new Ordennancement("simpleHomme", 5, listeJoueurHomme));
		typeTournoi.add(new Ordennancement("simpleFemme", 3, listeJoueurFemme));
		typeTournoi.add(new Ordennancement("doubleHomme", 3, listeJoueurHomme));
		typeTournoi.add(new Ordennancement("doubleFemme", 3, listeJoueurFemme));
		typeTournoi.add(new Ordennancement("mixte", 3, listeJoueurHomme, listeJoueurFemme));
	}

	private void generationCourt() {
		Court court = new Court();
		this.listeCourt = court.generationListeCourt();
	}

	private int nbrMatch() {
		int cpt = 0;
		for (Ordennancement ord : typeTournoi) {
			cpt += ord.getListeDesMatchs().size();
		}
		System.out.println(cpt);
		return cpt;
	}

	private void ordreDesMatchs() {
		Ordennancement[] tabMatch = new Ordennancement[5];
		for (int i = 0; i < 5; i++) {
			tabMatch[i] = typeTournoi.get(i);
		}
		for (int i = 0; i < tabMatch.length; i++) {
			for (int j = 0; j < tabMatch[i].getListeDesMatchs().size(); j++) {
				for (int k = 0; k < this.listeCalendrier.size(); k++) {
					if (!listeCalendrier.get(k).getBloq()) {
						tabMatch[i].getListeDesMatchs().get(j).setDate(listeCalendrier.get(k).getJour(),
								listeCalendrier.get(k).getHeure(), listeCalendrier.get(k).getCourt());
						this.listeCalendrier.get(k).setBloq(true);
						break;
					}
				}
			}
		}

	}

	private void genererCalendrier() {
		Calendrier tmp = new Calendrier();
		this.listeCalendrier = tmp.generation(listeCourt);
	}

	public final static Tournoi getInstance() {
		if (Tournoi.instance == null) {
			// Le mot-cl� synchronized sur ce bloc emp�che toute instanciation
			// multiple m�me par diff�rents "threads".
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

	public ArrayList<Ordennancement> getTypeTournoi() {
		return typeTournoi;
	}

	public void jouer() {

		for (Ordennancement x : typeTournoi) {
			if (x.getFinale() == true) {
				continue;
			} else if (x.getListeDesMatchs().isEmpty()) {
				x.generationMatch();
			}
		}
		this.ordreDesMatchs();
		for (Ordennancement x : typeTournoi) {
			if (x.getFinale() == true) {
				continue;
			} else {
				System.out.println("**********Debut tour " + x.getType());
				x.jouer();
				System.out.println("**********fin tour " + x.getType());
			}
		}

	}
}
