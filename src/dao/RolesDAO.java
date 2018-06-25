package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
		boolean _ajout_role= r.is_ajout_role();
		boolean _ajout_visiteur=r.is_ajout_visiteur();
		boolean _ajout_param = r.is_ajout_param();
		boolean _ajout_cat = r.is_ajout_cat();
		String str = "insert into roles values(NULL,'" + nom + "'," + ajout_users + "," + ajout_themes + ","
				+ ajout_articles + "," + moderateur +","+_ajout_role+","+_ajout_visiteur+","+_ajout_param+","+_ajout_cat+ ")";

		try {
			this._connection.getInstance().createStatement().executeUpdate(str);
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	/** Supprime un role de la bdd **/
	@Override
	public boolean delete(MODEL<?> r) {
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
	public boolean update(MODEL<?> r) {
		int id = r.get_id();
		String nom = r.get_nom();
		boolean ajout_users = r.is_ajout_users();
		boolean moderateur = r.is_mod();
		boolean ajout_themes = r.is_ajout_themes();
		boolean ajout_articles = r.is_ajout_articles();
		boolean _ajout_role= r.is_ajout_role();
		boolean _ajout_visiteur=r.is_ajout_visiteur();
		boolean _ajout_param = r.is_ajout_param();
		boolean _ajout_cat = r.is_ajout_cat();
		String str = "update roles set nom='" + nom + "', ajout_users=" + ajout_users + ", ajout_themes=" + ajout_themes
				+ ", ajout_articles=" + ajout_articles + ", moderateur=" + moderateur +", ajout_role=" + _ajout_role +", ajout_visiteur=" + _ajout_visiteur +", ajout_param=" + _ajout_param +", ajout_cat="+_ajout_cat+ " where id=" + id;

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
				r.set_ajout_role(result.getBoolean("ajout_role"));
				r.set_ajout_visiteur(result.getBoolean("ajout_visiteur"));
				r.set_ajout_param(result.getBoolean("ajout_param"));
				r.set_ajout_cat(result.getBoolean("ajout_cat"));
			}
		} catch (SQLException e) {

		}
		return r;
	}

	@Override
	public ArrayList<Roles> get_all() {
		ArrayList<Roles> liste = new ArrayList<Roles>();
		String Str = "SELECT * from roles";
		Roles r = new Roles();
		try {
			ResultSet result = this._connection.getInstance().createStatement().executeQuery(Str);
			while (result.next()) {
				r.set_id(result.getInt("id"));
				r.set_nom(result.getString("nom"));
				r.set_ajout_articles(result.getBoolean("ajout_articles"));
				r.set_ajout_themes(result.getBoolean("ajout_themes"));
				r.set_ajout_users(result.getBoolean("ajout_users"));
				r.set_mod(result.getBoolean("moderateur"));
				r.set_ajout_role(result.getBoolean("ajout_role"));
				r.set_ajout_visiteur(result.getBoolean("ajout_visiteur"));
				r.set_ajout_param(result.getBoolean("ajout_param"));
				r.set_ajout_cat(result.getBoolean("ajout_cat"));
				liste.add(r);
				r = new Roles();
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
	public Roles find_courant() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reset_courant() {
		// TODO Auto-generated method stub
		
	}

}
