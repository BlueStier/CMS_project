package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import accessBDD.BDD;
import model.MODEL;
import model.Themes;
/* class object faisant le lien avec la bdd et permettant de trouver, creer supprimer 
 * ou modifier un theme
 * */

public class ThemesDAO extends DAO<Themes> {

	public ThemesDAO(BDD conn) {
		super(conn);
	}

	/** insert un theme dans la bdd **/
	@Override
	public boolean create(MODEL<?> t) {
		String nom = t.get_nom();
		String path = t.get_path();
		String str = "insert into theme values(NULL,'" + nom + "','" + path + "')";
		try {
			this._connection.getInstance().createStatement().executeUpdate(str);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	/** supprime un theme de la bdd **/
	@Override
	public boolean delete(Themes t) {
		int id = t.get_id();
		String str = "delete from theme where id=" + id;
		try {
			this._connection.getInstance().createStatement().executeUpdate(str);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	/** met à jour un theme de la bdd **/
	@Override
	public boolean update(Themes t) {
		int id = t.get_id();
		String nom = t.get_nom();
		String path = t.get_path();
		String str = "update theme set nom='" + nom + "', path='" + path + "' where id=" + id;

		try {
			this._connection.getInstance().createStatement().executeUpdate(str);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	/* trouve le theme dans la bdd qui correspond à l'id passé en parametre */
	@Override
	public Themes find(int id) {
		Themes t = new Themes();
		String Str = "SELECT * from theme where id=" + id;
		try {
			ResultSet result = this._connection.getInstance().createStatement().executeQuery(Str);
			while (result.next()) {
				t.set_id(result.getInt("id"));
				t.set_nom(result.getString("nom"));
				t.set_path(result.getString("path"));
			}
		} catch (SQLException e) {

		}
		return t;
	}

}
