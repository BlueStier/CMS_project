package dao;

import accessBDD.BDD;
import model.Themes;

public class ThemesDAO extends DAO<Themes>{
	
	public ThemesDAO(BDD conn) {
		super(conn);
	}

	@Override
	public boolean create(Themes obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Themes obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Themes obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Themes find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
