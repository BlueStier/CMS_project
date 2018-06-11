package factory;

import accessBDD.BDD;
import dao.ArticlesDAO;
import dao.CatDAO;
import dao.CommentairesDAO;
import dao.DAO;
import dao.ParametresDAO;
import dao.RolesDAO;
import dao.TeamDAO;
import dao.ThemesDAO;
import dao.VisiteursDAO;

public class DAOFactory {
	protected static final BDD conn = new BDD();

	/**
	 * retourne un objet interagissant avec la classe Article interagissant avec la
	 * bdd
	 **/
	public static DAO<?> getArticlesDAO() {
		return new ArticlesDAO(conn);
	}

	/**
	 * retourne un objet interagissant avec la classe cat interagissant avec la bdd
	 **/
	public static DAO<?> getCatDAO() {
		return new CatDAO(conn);
	}

	/**
	 * retourne un objet interagissant avec la classe Commentaires interagissant
	 * avec la bdd
	 **/
	public static DAO<?> getCommentairesDAO() {
		return new CommentairesDAO(conn);
	}

	/**
	 * retourne un objet interagissant avec la classe Parametres interagissant avec
	 * la bdd
	 **/
	public static DAO<?> getParametresDAO() {
		return new ParametresDAO(conn);
	}

	/**
	 * retourne un objet interagissant avec la classe Roles interagissant avec la
	 * bdd
	 **/
	public static DAO<?> getRolesDAO() {
		return new RolesDAO(conn);
	}
	
	/**
	 * retourne un objet interagissant avec la classe Team interagissant avec la
	 * bdd
	 **/
	public static DAO<?> getTeamDAO() {
		return new TeamDAO(conn);
	}
	
	/**
	 * retourne un objet interagissant avec la classe Themes interagissant avec la
	 * bdd
	 **/
	public static DAO<?> getThemesDAO() {
		return new ThemesDAO(conn);
	}
	
	/**
	 * retourne un objet interagissant avec la classe Visiteurs interagissant avec la
	 * bdd
	 **/
	public static DAO<?> getVisiteursDAO() {
		return new VisiteursDAO(conn);
	}
}

