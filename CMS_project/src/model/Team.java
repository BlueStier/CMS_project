package model;

public class Team {
	private int _id;
	private String _nom;
	private String _pseudo;
	private String _role;

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

	public String get_role() {
		return _role;
	}

	public void set_role(String _role) {
		this._role = _role;
	}

}
