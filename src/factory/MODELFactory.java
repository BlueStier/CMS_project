package factory;

import model.Articles;
import model.Cat;
import model.Commentaires;
import model.MODEL;
import model.Parametres;
import model.Roles;
import model.Team;
import model.Themes;
import model.Visiteurs;

public class MODELFactory {

	/**
	 * retourne un objet Article 
	 **/
	public static MODEL<?> getArticles() {
		return new Articles();
	}
	
	/**
	 * retourne un objet Cat 
	 **/
	public static MODEL<?> getCat() {
		return new Cat();
	}
	
	/**
	 * retourne un objet Commentaires 
	 **/
	public static MODEL<?> getCommentaires() {
		return new Commentaires();
	}
	
	/**
	 * retourne un objet Parametres 
	 **/
	public static MODEL<?> getParametres() {
		return new Parametres();
	}
	
	/**
	 * retourne un objet Roles 
	 **/
	public static MODEL<?> getRoles() {
		return new Roles();
	}
	
	/**
	 * retourne un objet Team 
	 **/
	public static MODEL<?> getTeam() {
		return new Team();
	}
	
	/**
	 * retourne un objet Themes
	 **/
	public static MODEL<?> getThemes() {
		return new Themes();
	}
	
	/**
	 * retourne un objet Visiteurs
	 **/
	public static MODEL<?> getVisiteurs() {
		return new Visiteurs();
	}
	
}

