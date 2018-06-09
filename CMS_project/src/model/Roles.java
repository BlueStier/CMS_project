package model;

public class Roles {
	private int _id;
	private String _nom;
	private boolean _ajout_users;
	private boolean _moderateur;
	private boolean _ajout_themes;
	private boolean _ajout_articles;

	public Roles() {

	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String get_nom() {
		return _nom;
	}

	public void set_nom(String _nom) {
		this._nom = _nom;
	}

	public boolean is_ajout_users() {
		return _ajout_users;
	}

	public void set_ajout_users(boolean _ajout_users) {
		this._ajout_users = _ajout_users;
	}

	public boolean is_moderateur() {
		return _moderateur;
	}

	public void set_moderateur(boolean _moderateur) {
		this._moderateur = _moderateur;
	}

	public boolean is_ajout_themes() {
		return _ajout_themes;
	}

	public void set_ajout_themes(boolean _ajout_themes) {
		this._ajout_themes = _ajout_themes;
	}

	public boolean is_ajout_articles() {
		return _ajout_articles;
	}

	public void set_ajout_articles(boolean _ajout_articles) {
		this._ajout_articles = _ajout_articles;
	}

}
