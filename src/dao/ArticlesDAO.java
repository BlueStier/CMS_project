package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import accessBDD.BDD;
import model.Articles;
import model.MODEL;
/* class object faisant le lien avec la bdd et permettant de trouver, creer supprimer 
 * ou modifier un Article
 * */

public class ArticlesDAO extends DAO<Articles> {

	public ArticlesDAO(BDD conn) {
		super(conn);
	}

	/* insert un article dans la bdd */
	@Override
	public boolean create(MODEL<?> a) {
		String titre = a.get_titre();
		String resume = a.get_resume();
		String contenu = a.get_contenu();
		String writer = a.get_writer();
		int cat = a.get_cat().get_id();
		boolean com = a.is_commentaires();
		boolean v = a.is_visible();
		String str = "insert into articles values(NULL,'" + titre + "','" + resume + "','" + contenu + "',NOW(),'"
				+ writer + "'," + cat + "," + com + ","+v+")";

		try {
			this._connection.getInstance().createStatement().executeUpdate(str);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	/** supprime un article de la bdd **/
	@Override
	public boolean delete(MODEL<?> a) {
		int id = a.get_id();
		String str = "delete from articles where id=" + id;
		try {
			this._connection.getInstance().createStatement().executeUpdate(str);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	/**Met à jour un article de la bdd**/
	@Override
	public boolean update(MODEL<?> a) {
		int id = a.get_id();
		String titre = a.get_titre();
		String resume = a.get_resume();
		String contenu = a.get_contenu();
		String writer = a.get_writer();
		int cat = a.get_cat().get_id();
		boolean com = a.is_commentaires();
		boolean v = a.is_visible();
		String str = "update articles set titre='" + titre + "', resume='" + resume + "', contenu='" + contenu
				+ "', writer='" + writer + "', date=NOW(), cat=" + cat + ", commentaires="+com+", visible="+v+" where id="+id;

		try {
			this._connection.getInstance().createStatement().executeUpdate(str);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	/* trouve l'article dans la bdd qui correspond à l'id passé en parametre */
	@Override
	public Articles find(int id) {
		Articles a = new Articles();
		String Str = "SELECT * from articles where id=" + id;
		try {
			ResultSet result = this._connection.getInstance().createStatement().executeQuery(Str);
			while (result.next()) {
				a.set_id(result.getInt("id"));
				a.set_titre(result.getString("titre"));
				a.set_resume(result.getString("resume"));
				a.set_contenu(result.getString("contenu"));
				a.set_writer(result.getString("writer"));
				a.set_cat(new CatDAO(new BDD()).find(result.getInt("cat")));
				a.set_commentaires(result.getBoolean("commentaires"));
				a.set_visible(result.getBoolean("visible"));
				a.set_date(result.getDate("date"));
			}
		} catch (SQLException e) {

		}

		return a;
	}

	@Override
	public ArrayList<Articles> get_all() {
		ArrayList<Articles> liste = new ArrayList<Articles>();
		String Str = "SELECT * from articles";
		Articles a = new Articles();
		try {
			ResultSet result = this._connection.getInstance().createStatement().executeQuery(Str);
			while (result.next()) {
				a.set_id(result.getInt("id"));
				a.set_titre(result.getString("titre"));
				a.set_resume(result.getString("resume"));
				a.set_contenu(result.getString("contenu"));
				a.set_writer(result.getString("writer"));
				a.set_cat(new CatDAO(new BDD()).find(result.getInt("cat")));
				a.set_commentaires(result.getBoolean("commentaires"));
				a.set_visible(result.getBoolean("visible"));
				a.set_date(result.getDate("date"));
				liste.add(a);
				a = new Articles();
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
	public boolean upOrDown(int id, boolean up){
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean asc(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Articles find_courant() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reset_courant() {
		// TODO Auto-generated method stub
		
	}

}
