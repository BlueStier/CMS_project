package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import accessBDD.BDD;
import model.Roles;


public class RolesDAO extends DAO<Roles>{
	
	public RolesDAO(BDD conn) {
		super(conn);
	}

	@Override
	public boolean create(Roles obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Roles obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Roles obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Roles find(int id) {
		Roles r = new Roles();
		String Str = "SELECT * from Roles where id="+id;
		try {
			ResultSet result= this._connection.getInstance().createStatement().executeQuery(Str);
			while (result.next()) {
				r.set_id(result.getInt(id));
				r.set_nom(result.getString("nom"));
				r.set_ajout_articles(result.getBoolean("ajout_articles"));
				r.set_ajout_themes(result.getBoolean("ajout_themes"));
				r.set_ajout_users(result.getBoolean("ajout_users"));
				r.set_moderateur(result.getBoolean("moderateur"));
			}
		}catch(SQLException e){
			
		}
		return r;
	}

}
