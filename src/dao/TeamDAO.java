package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import accessBDD.BDD;
import model.MODEL;
import model.Team;
/* class object faisant le lien avec la bdd et permettant de trouver, creer supprimer 
 * ou modifier une team
 * */

public class TeamDAO extends DAO<Team> {

	public TeamDAO(BDD conn) {
		super(conn);
	}

	/** insert une team dans la bdd **/
	@Override
	public boolean create(MODEL<?> t) {
		String nom = t.get_nom();
		String pseudo = t.get_pseudo();
		String mail = t.get_mail();
		int role = t.get_role().get_id();
		String mdp = t.get_mdp();
		String str = "insert into team values(NULL,'" + nom + "','" + pseudo + "','" + mail + "'," + role + ",'" + mdp
				+ "')";		
		try {
			this._connection.getInstance().createStatement().executeUpdate(str);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	/** Supprime une team de la bdd **/
	@Override
	public boolean delete(MODEL<?> t) {
		int id = t.get_id();
		String str = "delete from team where id=" + id;
		try {
			this._connection.getInstance().createStatement().executeUpdate(str);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	/** met à jour une team dans la bdd **/
	@Override
	public boolean update(MODEL<?> t) {
		int id = t.get_id();
		String nom = t.get_nom();
		String mail = t.get_mail();
		String pseudo = t.get_pseudo();
		int role = t.get_role().get_id();
		String mdp = t.get_mdp();
		String str = "update team set nom='" + nom + "', email='" + mail + "', pseudo='" + pseudo + "', role=" + role
				+ ", mdp='" + mdp + "' where id=" + id;

		try {
			this._connection.getInstance().createStatement().executeUpdate(str);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	/* trouve la team dans la bdd qui correspond à l'id passé en parametre */
	@Override
	public Team find(int id) {
		Team t = new Team();
		String Str = "SELECT * from Team";
		try {
			ResultSet result = this._connection.getInstance().createStatement().executeQuery(Str);
			while (result.next()) {
				t.set_id(result.getInt("id"));
				t.set_nom(result.getString("nom"));
				t.set_pseudo(result.getString("pseudo"));
				t.set_mail(result.getString("email"));
				t.set_role(new RolesDAO(new BDD()).find(result.getInt("role")));
				t.set_mdp(result.getString("mdp"));
			}
		} catch (SQLException e) {

		}
		return t;
	}

	@Override
	public ArrayList<Team> get_all() {
		ArrayList<Team> liste = new ArrayList<Team>();
		String Str = "SELECT * from team";
		Team t = new Team();
		try {
			ResultSet result = this._connection.getInstance().createStatement().executeQuery(Str);
			while (result.next()) {
				t.set_id(result.getInt("id"));
				t.set_nom(result.getString("nom"));
				t.set_pseudo(result.getString("pseudo"));
				t.set_mail(result.getString("email"));
				t.set_role(new RolesDAO(new BDD()).find(result.getInt("role")));
				t.set_mdp(result.getString("mdp"));
				liste.add(t);
				t = new Team();
			}
		} catch (SQLException e) {

		}
		return liste;
	}

}
