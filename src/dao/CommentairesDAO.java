package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import accessBDD.BDD;
import model.Commentaires;
import model.MODEL;
/* class object faisant le lien avec la bdd et permettant de trouver, creer supprimer 
 * ou modifier un commentaire
 * */

public class CommentairesDAO extends DAO<Commentaires> {

	public CommentairesDAO(BDD conn) {
		super(conn);
	}

	/* insert un article dans la bdd */
	@Override
	public boolean create(MODEL<?> c) {
		String contenu = c.get_contenu();
		int visiteur = c.get_visiteurs().get_id();
		int article = c.get_article().get_id();
		boolean mod = c.is_mod();
		String str = "insert into commentaires values(NULL,'" + contenu + "'," + visiteur + "," + article + ",NOW(),"
				+ mod + ")";
		try {
			this._connection.getInstance().createStatement().executeUpdate(str);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	/** Supprime un commentaire de la bdd **/
	@Override
	public boolean delete(MODEL<?> c) {
		int id = c.get_id();
		String str = "delete from commentaires where id=" + id;
		try {
			this._connection.getInstance().createStatement().executeUpdate(str);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	/** Modifie un commentaire en bdd **/
	@Override
	public boolean update(MODEL<?> c) {
		int id = c.get_id();
		String contenu = c.get_contenu();
		boolean mod = c.is_mod();
		int article = c.get_article().get_id();
		int visiteur = c.get_visiteurs().get_id();

		String str = "update commentaires set contenu='" + contenu + "', visiteur=" + visiteur + ", article=" + article
				+ ", date=NOW(), moderateur=" + mod + " where id=" + id;

		try {
			this._connection.getInstance().createStatement().executeUpdate(str);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	public boolean mod(MODEL<?> c) {
		int id = c.get_id();		
		boolean mod = c.is_mod();
		String str = "update commentaires set moderateur=" + mod + " where id=" + id;

		try {
			this._connection.getInstance().createStatement().executeUpdate(str);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	/*
	 * trouve le commentaire dans la bdd qui correspond à l'id passé en
	 * parametre
	 */
	@Override
	public Commentaires find(int id) {
		Commentaires com = new Commentaires();
		String Str = "SELECT * from commentaires where id=" + id;
		try {
			ResultSet result = this._connection.getInstance().createStatement().executeQuery(Str);
			while (result.next()) {
				com.set_id(result.getInt("id"));
				com.set_contenu(result.getString("contenu"));
				com.set_date(result.getDate("date"));
				com.set_article(new ArticlesDAO(new BDD()).find(result.getInt("article")));
				com.set_visiteur(new VisiteursDAO(new BDD()).find(result.getInt("visiteur")));
				com.set_mod(result.getBoolean("mod"));

			}
		} catch (SQLException e) {

		}
		return com;
	}

	@Override
	public ArrayList<Commentaires> get_all() {
		ArrayList<Commentaires> liste = new ArrayList<Commentaires>();
		String Str = "SELECT * from commentaires order by moderateur DESC";
		Commentaires com = new Commentaires();
		try {
			ResultSet result = this._connection.getInstance().createStatement().executeQuery(Str);
			while (result.next()) {				
				com.set_id(result.getInt("id"));				
				com.set_contenu(result.getString("contenu"));				
				com.set_date(result.getDate("date"));				
				com.set_article(new ArticlesDAO(new BDD()).find(result.getInt("article")));				
				com.set_visiteur(new VisiteursDAO(new BDD()).find(result.getInt("visiteur")));			
				com.set_mod(result.getBoolean("moderateur"));				
				liste.add(com);	
				com = new Commentaires();
			}
		} catch (SQLException e) {
			}
		return liste;
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
	public Commentaires find_courant() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reset_courant() {
		// TODO Auto-generated method stub
		
	}

}
