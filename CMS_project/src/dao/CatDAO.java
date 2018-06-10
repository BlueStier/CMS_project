package dao;


import accessBDD.BDD;
import model.Cat;

public class CatDAO extends DAO<Cat>{
	
	public CatDAO(BDD conn) {
		super(conn);
	}

	@Override
	public boolean create(Cat obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Cat obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Cat obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cat find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
