package be.zrt.dao;

import java.sql.*;

import javax.swing.JOptionPane;

public abstract class DaoBdd {

	protected Connection connec;
	protected Statement stmt;
	protected ResultSet res;

	public DaoBdd() {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Classe de driver introuvable " + e.getMessage());
			System.exit(0);
		}

		this.connec = null;
		this.stmt = null;
		this.res = null;
		try {
			String url = "jdbc:ucanaccess://./Database21.accdb";
			connec = DriverManager.getConnection(url);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}
}
