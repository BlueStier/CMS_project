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
		int ordre = c.get_ordre();
		String str = "insert into cat values(NULL,'" + nom + "'," + ordre + ")";

		try {
			this._connection.getInstance().createStatement().executeUpdate(str);
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

	/**Met à jour une catégorie de la bdd**/
	@Override
	public boolean update(MODEL<?> c) {
		int id = c.get_id();
		String nom = c.get_nom();
		int ordre = c.get_ordre();
		
		String str = "update cat set nom='" + nom + "', ordre=" + ordre + " where id="+id;

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
		String Str = "SELECT * from cat";
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

}
