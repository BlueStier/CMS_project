package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import accessBDD.BDD;
import model.Team;

public class TeamDAO extends DAO<Team>{
	
	public TeamDAO(BDD conn) {
		super(conn);
	}

	@Override
	public boolean create(Team obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Team obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Team obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Team find(int id) {
		Team t = new Team();
		String Str = "SELECT * from Team";
		try {
			ResultSet result= this._connection.getInstance().createStatement().executeQuery(Str);
			while (result.next()) {
				t.set_id(result.getInt(id));
				t.set_nom(result.getString("nom"));
				t.set_pseudo("pseudo");
				t.set_role("role");
			}
		}catch(SQLException e){
			
		}
		return t;
	}

}
