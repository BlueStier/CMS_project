package dao;

import accessBDD.BDD;
import model.Commentaires;

public class CommentairesDAO extends DAO<Commentaires>{
	
	public CommentairesDAO(BDD conn) {
		super(conn);
	}

	@Override
	public boolean create(Commentaires obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Commentaires obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Commentaires obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Commentaires find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
