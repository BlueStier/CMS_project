package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import accessBDD.BDD;
import model.MODEL;
import model.Roles;
/* class object faisant le lien avec la bdd et permettant de trouver, creer supprimer 
 * ou modifier un role
 * */

public class RolesDAO extends DAO<Roles> {

	public RolesDAO(BDD conn) {
		super(conn);
	}

	/* insert un nouveau role dans la bdd */
	@Override
	public boolean create(MODEL<?> r) {
		String nom = r.get_nom();
		boolean ajout_users = r.is_ajout_users();
		boolean ajout_themes = r.is_ajout_themes();
		boolean ajout_articles = r.is_ajout_articles();
		boolean moderateur = r.is_mod();
		String str = "insert into roles values(NULL,'" + nom + "'," + ajout_users + "," + ajout_themes + ","
				+ ajout_articles + "," + moderateur + ")";

		try {
			this._connection.getInstance().createStatement().executeUpdate(str);
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	/** Supprime un role de la bdd **/
	@Override
	public boolean delete(Roles r) {
		int id = r.get_id();
		String str = "delete from roles where id=" + id;
		try {
			this._connection.getInstance().createStatement().executeUpdate(str);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	/** met à jour un role dans la bdd **/
	@Override
	public boolean update(Roles r) {
		int id = r.get_id();
		String nom = r.get_nom();
		boolean ajout_users = r.is_ajout_users();
		boolean moderateur = r.is_mod();
		boolean ajout_themes = r.is_ajout_themes();
		boolean ajout_articles = r.is_ajout_articles();
		String str = "update roles set nom='" + nom + "', ajout_users=" + ajout_users + ", ajout_themes=" + ajout_themes
				+ ", ajout_articles=" + ajout_articles + ", moderateur=" + moderateur + " where id=" + id;

		try {
			this._connection.getInstance().createStatement().executeUpdate(str);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	/* trouve le role dans la bdd qui correspond à l'id passé en parametre */
	@Override
	public Roles find(int id) {
		Roles r = new Roles();
		String Str = "SELECT * from Roles where id=" + id;
		try {
			ResultSet result = this._connection.getInstance().createStatement().executeQuery(Str);
			while (result.next()) {
				r.set_id(result.getInt("id"));
				r.set_nom(result.getString("nom"));
				r.set_ajout_articles(result.getBoolean("ajout_articles"));
				r.set_ajout_themes(result.getBoolean("ajout_themes"));
				r.set_ajout_users(result.getBoolean("ajout_users"));
				r.set_mod(result.getBoolean("moderateur"));
			}
		} catch (SQLException e) {

		}
		return r;
	}

}
