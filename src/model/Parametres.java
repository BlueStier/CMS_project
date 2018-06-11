package model;
/* class object representant un theme de la bdd 
 * comprenant son id, sa decsription, et utilisant un objet theme
 * getters et setters en fonction des variables membres
 * toString redéfinie
 * */

public class Parametres {
	private int _id;
	private String _nom;
	private Themes _theme;
	private String _description;

	public Parametres() {
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

	public Themes get_theme() {
		return _theme;
	}

	public void set_theme(Themes _theme) {
		this._theme = _theme;
	}

	public String get_description() {
		return _description;
	}

	public void set_description(String _description) {
		this._description = _description;
	}

	public String toString() {
		return "id : " + _id + " description :" + _description + " theme : " + _theme.toString();
	}

}
