package dao;

import accessBDD.BDD;
import model.Visiteurs;

public class VisiteursDAO extends DAO<Visiteurs>{
	
	public VisiteursDAO(BDD conn) {
		super(conn);
	}

	@Override
	public boolean create(Visiteurs obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Visiteurs obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Visiteurs obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Visiteurs find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
