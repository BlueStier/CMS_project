package model;
/* class object representant un theme de la bdd 
 * comprenant son id, son contenu, son nom et son path
 * getters et setters en fonction des variables membres
 * toString redéfinie
 * */

public class Themes {
	private int _id;
	private String _nom;
	private String _path;

	public Themes() {
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

	public String get_path() {
		return _path;
	}

	public void set_path(String _path) {
		this._path = _path;
	}
	
	public String toString(){
		return "id : "+_id+" nom : "+_nom+" path: "+_path;
	}

}
