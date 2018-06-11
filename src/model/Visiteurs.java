package model;
/* class object representant un commentaires de la bdd 
 * comprenant son id, son pseudo,et son mail
 * getters et setters en fonction des variables membres
 * toString redéfinie
 * */

public class Visiteurs {
	private int _id;
	private String _pseudo;
	private String _mail;
	
	public Visiteurs() {
		
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

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}
	
	public String toString(){
		return " id : "+_id+" pseudo : "+_pseudo+" mail : "+_mail;
	}

}
