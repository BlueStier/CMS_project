package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import accessBDD.BDD;
import model.Cat;
import model.MODEL;

/**
 * class object faisant le lien avec la bdd et permettant de trouver, creer
 * supprimer ou modifier une categorie
 */

public class CatDAO extends DAO<Cat> {

	public CatDAO(BDD conn) {
		super(conn);
	}

	/** insert une categorie dans la bdd **/
	@Override
	public boolean create(MODEL<?> c) {
		String nom = c.get_nom();
		int ordre = 1;
		String str1 = "SELECT ordre FROM cat WHERE ordre = (SELECT MAX(ordre) FROM cat)";
		try {
			ResultSet result = this._connection.getInstance().createStatement().executeQuery(str1);
			while (result.next()) {
				ordre += result.getInt("ordre");
			}
			String str2 = "insert into cat values(NULL,'" + nom + "'," + ordre + ")";
			this._connection.getInstance().createStatement().executeUpdate(str2);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	/** Supprime une catégorie de la bdd **/
	@Override
	public boolean delete(MODEL<?> c) {
		int id = c.get_id();
		String str = "delete from cat where id=" + id;
		try {
			this._connection.getInstance().createStatement().executeUpdate(str);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	/** Met à jour une catégorie de la bdd **/
	@Override
	public boolean update(MODEL<?> c) {
		int id = c.get_id();
		String nom = c.get_nom();
		int ordre = c.get_ordre();

		String str = "update cat set nom='" + nom + "', ordre=" + ordre + " where id=" + id;
		try {
			this._connection.getInstance().createStatement().executeUpdate(str);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	/*
	 * trouve la catégorie dans la bdd qui correspond à l'id passé en parametre
	 */
	@Override
	public Cat find(int id) {
		Cat c = new Cat();
		String Str = "SELECT * from cat where id=" + id;
		try {
			ResultSet result = this._connection.getInstance().createStatement().executeQuery(Str);
			while (result.next()) {
				c.set_id(result.getInt("id"));
				c.set_nom(result.getString("nom"));
				c.set_ordre(result.getInt("ordre"));
			}
		} catch (SQLException e) {

		}
		return c;
	}

	@Override
	public ArrayList<Cat> get_all() {
		ArrayList<Cat> liste = new ArrayList<Cat>();
		String Str = "SELECT * from cat order by ordre";
		Cat c = new Cat();
		try {
			ResultSet result = this._connection.getInstance().createStatement().executeQuery(Str);
			while (result.next()) {
				c.set_id(result.getInt("id"));
				c.set_nom(result.getString("nom"));
				c.set_ordre(result.getInt("ordre"));
				liste.add(c);
				c = new Cat();
			}
		} catch (SQLException e) {

		}
		return liste;
	}

	@Override
	public boolean mod(MODEL<?> obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean upOrDown(int id, boolean up) {
		int ordreActuel = id;
		int ordreResult = 0;
		if (up) {
			ordreResult = id - 1;
		} else {
			ordreResult = id + 1;
		}

		String Str1 = "SELECT * from cat where ordre=" + ordreActuel;
		String Str2 = "SELECT * from cat where ordre=" + ordreResult;
		Cat c1 = new Cat();
		Cat c2 = new Cat();
		try {
			ResultSet result = this._connection.getInstance().createStatement().executeQuery(Str1);
			while (result.next()) {
				c1.set_id(result.getInt("id"));
				c1.set_nom(result.getString("nom"));				
				c1.set_ordre(0);
				update(c1);
			}
			ResultSet result2 = this._connection.getInstance().createStatement().executeQuery(Str2);
			while (result2.next()) {
				c2.set_id(result2.getInt("id"));
				c2.set_nom(result2.getString("nom"));				
				c2.set_ordre(ordreActuel);
				update(c2);
			}
			c1.set_ordre(ordreResult);
			update(c1);

		} catch (SQLException e) {
			return false;
		}

		return true;
	}

	@Override
	public boolean asc(int id) {
		int ordre = --id;
		ArrayList<Cat> liste = new ArrayList<Cat>();
		String Str = "SELECT * from cat where ordre>" + ordre + " order by ordre";
		Cat c = new Cat();
		try {
			ResultSet result = this._connection.getInstance().createStatement().executeQuery(Str);
			while (result.next()) {
				c.set_id(result.getInt("id"));
				c.set_nom(result.getString("nom"));
				c.set_ordre(result.getInt("ordre") - 1);
				liste.add(c);
				c = new Cat();
			}
		} catch (SQLException e) {
			return false;
		}
		int taille = liste.size();
		if (liste.size() == 0) {
			return false;
		} else {
			for (int i = 0; i < taille; i++) {
				update(liste.get(i));
			}
		}
		return true;
	}

	@Override
	public Cat find_courant() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reset_courant() {
		// TODO Auto-generated method stub
		
	}

}
