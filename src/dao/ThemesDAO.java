package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
		boolean courant = t.is_courant();
		String str = "insert into theme values(NULL,'" + nom + "','" + path + "','" + courant + ")";
		try {
			this._connection.getInstance().createStatement().executeUpdate(str);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	/** supprime un theme de la bdd **/
	@Override
	public boolean delete(MODEL<?> t) {
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
	public boolean update(MODEL<?> t) {
		int id = t.get_id();
		String nom = t.get_nom();
		String path = t.get_path();
		boolean courant = t.is_courant();
		String str = "update theme set nom='" + nom + "', path='" + path +"', courant=" + courant + " where id=" + id;

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
				t.set_courant(result.getBoolean("courant"));
			}
		} catch (SQLException e) {

		}
		return t;
	}

	@Override
	public ArrayList<Themes> get_all() {
		ArrayList<Themes> liste = new ArrayList<Themes>();
		String Str = "SELECT * from theme";
		Themes t = new Themes();
		try {
			ResultSet result = this._connection.getInstance().createStatement().executeQuery(Str);
			while (result.next()) {
				t.set_id(result.getInt("id"));
				t.set_nom(result.getString("nom"));
				t.set_path(result.getString("path"));
				t.set_courant(result.getBoolean("courant"));
				liste.add(t);
				t = new Themes();
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
	public Themes find_courant() {
		Themes t = new Themes();
		String Str = "SELECT * from theme where courant=1";
		try {
			ResultSet result = this._connection.getInstance().createStatement().executeQuery(Str);
			while (result.next()) {
				t.set_id(result.getInt("id"));
				t.set_nom(result.getString("nom"));
				t.set_path(result.getString("path"));
				t.set_courant(result.getBoolean("courant"));
			}
		} catch (SQLException e) {

		}
		return t;
	}

	@Override
	public void reset_courant() {
		Themes t= find_courant();		
		t.set_courant(false);
		update(t);
	}

}
