package be.zrt.pojo;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

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
		JOptionPane tmp = new JOptionPane();
		String txt = "<html><p>Tour du tournoi de : "+this.typeDeTournoi+"</p><table border='1'>"
				+ " <tr>" + 
				"    <th><p>Noms des joueurs</p></th>" + 
				"    <th><p>Nom du vainqueur</p></th>" + 
				"    <th><p>Score</p></th>"+
				"    <th><p>Jour</p></th>"+
				"    <th><p>Heure</p></th>"+
				"    <th><p>Court</p></th>"+
				"    <th><p>Nombre de spectateur</p></th>"+
				"  </tr>";
		for (Match match : listeDesMatchs) {
			this.listeDesEquipe.add(match.jouer());
			txt += "<tr><td><p>"+match.getJoueurs()+"</p></td>"
					+ "<td><p>"+match.getVainqueur()+"</p></td>"
					+ "<td><p>"+match.afficherScore()+"</p></td>"
					+ "<td><p>"+match.getDate()+"</p></td>"
					+ "<td><p>"+match.getHeure()+"</p></td>"
					+ "<td><p>"+match.getCourt()+"</p></td>"
					+ "<td><p>"+match.getCourt().getSpectateur()+"</p></td>"
					+ " </tr>";
		}
		txt+="</table></html>";
		tmp.showMessageDialog(null, txt);
		if (listeDesEquipe.size() == 1) {
			fini = true;
			System.out.println(
					"fin du tournoi " + this.typeDeTournoi + " le gagnant est : " + this.listeDesEquipe.toString());
		}
		listeDesMatchs.clear();
		if (this.typeDeTournoi == "mixte") {
			// System.out.println(listeDesEquipe);
			// System.out.println(listeDesEquipe.size());
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
