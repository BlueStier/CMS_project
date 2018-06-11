package model;
/* class object representant une catégorie de la bdd 
 * comprenant son id, son nom, son ordre
 * getters et setters en fonction des variables membres
 * toString redéfinie
 * */

public class Cat {
	private int _id;
	private String _nom;
	private int _ordre;

	public Cat() {
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

	public int get_ordre() {
		return _ordre;
	}

	public void set_ordre(int _ordre) {
		this._ordre = _ordre;
	}

	public String toString() {
		return "id  : " + _id + "  nom : " + _nom + "  ordre : " + _ordre;
	}

}
