package model;

import java.util.Date;

/* class object representant un commentaires de la bdd 
 * comprenant son id, son contenu, s'il est modéré ou non,la date.
 * fait appel aux objets articles et visiteur
 * getters et setters en fonction des variables membres
 * toString redéfinie
 * */
public class Commentaires {
	private int _id;
	private String _contenu;
	private boolean _mod;
	private Articles _article;
	private Date _date;
	private Visiteurs _visiteur;

	public Commentaires() {
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String get_contenu() {
		return _contenu;
	}

	public void set_contenu(String _contenu) {
		this._contenu = _contenu;
	}

	public boolean is_mod() {
		return _mod;
	}

	public void set_mod(boolean _mod) {
		this._mod = _mod;
	}

	public Articles get_article() {
		return _article;
	}

	public void set_article(Articles _article) {
		this._article = _article;
	}

	public Date get_date() {
		return _date;
	}

	public void set_date(Date _date) {
		this._date = _date;
	}

	public Visiteurs get_visiteur() {
		return _visiteur;
	}

	public void set_visiteur(Visiteurs _visiteur) {
		this._visiteur = _visiteur;
	}

	public String toString() {
		return "id : " + _id + " contenu : " + _contenu + " modérateur : " + _mod + " date : " + _date + "\narticle : "
				+ _article.toString() + "\n visiteur :" + _visiteur.toString();
	}

}
