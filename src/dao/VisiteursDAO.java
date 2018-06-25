package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import accessBDD.BDD;
import model.MODEL;
import model.Visiteurs;
/* class object faisant le lien avec la bdd et permettant de trouver, creer supprimer 
* ou modifier un visiteur
* */

public class VisiteursDAO extends DAO<Visiteurs> {

	public VisiteursDAO(BDD conn) {
		super(conn);
	}

	/** insert un visiteur dans la bdd **/
	@Override
	public boolean create(MODEL<?> v) {
		String pseudo = v.get_pseudo();
		String mail = v.get_mail();
		String mdp = v.get_mdp();
		String str = "insert into visiteur values(NULL,'" + pseudo + "','" + mail + "','" + mdp + "')";
		try {
			this._connection.getInstance().createStatement().executeUpdate(str);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	/** Supprime un visiteur de la BDD **/
	@Override
	public boolean delete(MODEL<?> v) {
		int id = v.get_id();
		String str = "delete from visiteur where id=" + id;
		try {
			this._connection.getInstance().createStatement().executeUpdate(str);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	/** met � jour un visiteur de la bdd **/
	@Override
	public boolean update(MODEL<?> v) {
		int id = v.get_id();
		String pseudo = v.get_pseudo();
		String mail = v.get_mail();
		String mdp = v.get_mdp();
		String str = "update visiteur set pseudo='" + pseudo + "', email='" + mail + "', mdp='" + mdp + "' where id="
				+ id;

		try {
			this._connection.getInstance().createStatement().executeUpdate(str);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public Visiteurs find(int id) {
		Visiteurs v = new Visiteurs();
		String Str = "SELECT * from visiteur where id=" + id;
		try {
			ResultSet result = this._connection.getInstance().createStatement().executeQuery(Str);
			while (result.next()) {
				v.set_id(result.getInt("id"));
				v.set_pseudo(result.getString("pseudo"));
				v.set_mail(result.getString("email"));
				v.set_mdp(result.getString("mdp"));
			}
		} catch (SQLException e) {

		}
		return v;
	}

	@Override
	public ArrayList<Visiteurs> get_all() {
		ArrayList<Visiteurs> liste = new ArrayList<Visiteurs>();
		String Str = "SELECT * from visiteur";
		Visiteurs v = new Visiteurs();
		try {
			ResultSet result = this._connection.getInstance().createStatement().executeQuery(Str);
			while (result.next()) {
				v.set_id(result.getInt("id"));
				v.set_pseudo(result.getString("pseudo"));
				v.set_mail(result.getString("email"));
				v.set_mdp(result.getString("mdp"));
				liste.add(v);
				v = new Visiteurs();
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
	public Visiteurs find_courant() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reset_courant() {
		// TODO Auto-generated method stub
		
	}

}
