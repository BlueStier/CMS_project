package model;
/* class object representant une team de la bdd 
 * comprenant son id, son nom,son pseudo et son role en objet
 * getters et setters en fonction des variables membres
 * toString redéfinie
 * */

public class Team {
	private int _id;
	private String _nom;
	private String _pseudo;
	private String _mail;
	private Roles _role;

	public Team() {

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

	public String get_pseudo() {
		return _pseudo;
	}

	public void set_pseudo(String _pseudo) {
		this._pseudo = _pseudo;
	}

	public String get_mail() {
		return _mail;
	}

	public void set_mail(String _mail) {
		this._mail = _mail;
	}

	public Roles get_role() {
		return _role;
	}

	public void set_role(Roles _role) {
		this._role = _role;
	}
	
	public String toString(){
		return"id : "+_id+" nom : "+_nom+" pseudo : "+_pseudo+" mail : "+_mail+"\nrole :"+_role.toString();
	}

}
