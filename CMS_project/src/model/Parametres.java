package model;

public class Parametres {
private int _id;
private Themes _theme;
private String _description;

public Parametres() {}

public int get_id() {
	return _id;
}

public void set_id(int _id) {
	this._id = _id;
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


}
