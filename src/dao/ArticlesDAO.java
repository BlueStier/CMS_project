package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

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
		String str = "insert into articles values(NULL,'" + titre + "','" + resume + "','" + contenu + "',NOW(),'"
				+ writer + "'," + cat + "," + com + ")";

		try {
			this._connection.getInstance().createStatement().executeUpdate(str);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	/** supprime un article de la bdd **/
	@Override
	public boolean delete(Articles a) {
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
	public boolean update(Articles a) {
		int id = a.get_id();
		String titre = a.get_titre();
		String resume = a.get_resume();
		String contenu = a.get_contenu();
		String writer = a.get_writer();
		int cat = a.get_cat().get_id();
		boolean com = a.is_commentaires();
		String str = "update articles set titre='" + titre + "', resume='" + resume + "', contenu='" + contenu
				+ "', writer='" + writer + "', date=NOW(), cat=" + cat + ", commentaires="+com+" where id="+id;

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
				a.set_date(result.getDate("date"));
			}
		} catch (SQLException e) {

		}

		return a;
	}

}
