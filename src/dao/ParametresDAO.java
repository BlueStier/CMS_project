package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import accessBDD.BDD;
import model.MODEL;
import model.Parametres;

/* class object faisant le lien avec la bdd et permettant de trouver, creer supprimer 
 * ou modifier un parametre
 * */

public class ParametresDAO extends DAO<Parametres> {

	public ParametresDAO(BDD conn) {
		super(conn);
	}

	/** insert un nouveau parametre dans la bdd **/
	@Override
	public boolean create(MODEL<?> p) {
		String nom = p.get_nom();
		int theme = p.get_theme().get_id();
		String description = p.get_description();

		String str = "insert into parametres values(NULL,'" + nom + "','" + description + "'," + theme + ")";
		try {
			this._connection.getInstance().createStatement().executeUpdate(str);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	/** Supprime un parametre de la bdd **/
	@Override
	public boolean delete(MODEL<?> p) {
		int id = p.get_id();
		String str = "delete from parametres where id=" + id;
		try {
			this._connection.getInstance().createStatement().executeUpdate(str);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	/** met à jour le parametre de la bdd **/
	@Override
	public boolean update(MODEL<?> p) {
		int id = p.get_id();
		String nom = p.get_nom();
		String description = p.get_description();
		int theme = p.get_theme().get_id();
		String str = "update parametres set nom='" + nom + "', description='" + description + "', theme=" + theme
				+ " where id=" + id;

		try {
			this._connection.getInstance().createStatement().executeUpdate(str);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	/*
	 * trouve le parametre dans la bdd qui correspond à l'id passé à la focntion
	 */
	@Override
	public Parametres find(int id) {
		Parametres p = new Parametres();
		String Str = "SELECT * from parametres where id=" + id;
		try {
			ResultSet result = this._connection.getInstance().createStatement().executeQuery(Str);
			while (result.next()) {
				p.set_id(result.getInt("id"));
				p.set_nom(result.getString("nom"));
				p.set_description(result.getString("description"));
				p.set_theme(new ThemesDAO(new BDD()).find(result.getInt("theme")));
			}
		} catch (SQLException e) {

		}
		return p;
	}

	@Override
	public ArrayList<Parametres> get_all() {
		ArrayList<Parametres> liste = new ArrayList<Parametres>();
		String Str = "SELECT * from parametres";
		Parametres p = new Parametres();
		try {
			ResultSet result = this._connection.getInstance().createStatement().executeQuery(Str);
			while (result.next()) {
				p.set_id(result.getInt("id"));
				p.set_nom(result.getString("nom"));
				p.set_description(result.getString("description"));
				p.set_theme(new ThemesDAO(new BDD()).find(result.getInt("theme")));
				liste.add(p);
				p = new Parametres();
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean asc(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Parametres find_courant() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reset_courant() {
		// TODO Auto-generated method stub
		
	}

}
