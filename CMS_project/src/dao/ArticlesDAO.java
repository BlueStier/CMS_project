package dao;

import accessBDD.BDD;
import model.Articles;

public class ArticlesDAO extends DAO<Articles> {
	
	public ArticlesDAO(BDD conn) {
		super(conn);
	}

	@Override
	public boolean create(Articles obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Articles obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Articles obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Articles find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
