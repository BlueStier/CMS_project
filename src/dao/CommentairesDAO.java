package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import accessBDD.BDD;
import model.Commentaires;
/* class object faisant le lien avec la bdd et permettant de trouver, creer supprimer 
 * ou modifier un commentaire
 * */

public class CommentairesDAO extends DAO<Commentaires> {

	public CommentairesDAO(BDD conn) {
		super(conn);
	}

	/* insert un article dans la bdd */
	@Override
	public boolean create(Commentaires c) {
		String contenu = c.get_contenu();
		int visiteur = c.get_visiteur().get_id();
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
	public boolean delete(Commentaires c) {
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
	public boolean update(Commentaires c) {
		int id = c.get_id();
		String contenu = c.get_contenu();
		boolean mod = c.is_mod();
		int article = c.get_article().get_id();
		int visiteur = c.get_visiteur().get_id();

		String str = "update commentaires set contenu='" + contenu + "', visiteur=" + visiteur + ", article=" + article
				+ ", date=NOW(), moderateur=" + mod + " where id=" + id;

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

}
