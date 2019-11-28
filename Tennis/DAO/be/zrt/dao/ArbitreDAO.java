package be.zrt.dao;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import be.zrt.pojo.Arbitre;
import be.zrt.pojo.Joueur;

public class ArbitreDAO extends DaoBdd {
	public ArbitreDAO() {
		super();
	}

	public ArrayList<Arbitre> getArbitre() {
		ArrayList<Arbitre> tmpList = new ArrayList<Arbitre>();
		try {
			String requete = "SELECT * FROM Arbitre";
			stmt = connec.createStatement();
			res = stmt.executeQuery(requete);
			String nom;
			String prenom;
			String sexe;
			while (res.next()) {
				nom = res.getString(1);
				prenom = res.getString(2);
				sexe = res.getString(3);
				tmpList.add(new Arbitre(nom, prenom, sexe));
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		} finally {
			try {
				if (res != null)
					res.close();
				if (stmt != null)
					stmt.close();
				if (connec != null)
					connec.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return tmpList;
	}
}
