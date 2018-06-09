package model;

import java.util.Date;

public class Articles {
	private int _id;
	private String _titre;
	private String _resume;
	private String _contenu;
	private String _writer;
	private String _cat;
	private Date _date;

	public Articles() {

	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String get_titre() {
		return _titre;
	}

	public void set_titre(String _titre) {
		this._titre = _titre;
	}

	public String get_resume() {
		return _resume;
	}

	public void set_resume(String _resume) {
		this._resume = _resume;
	}

	public String get_contenu() {
		return _contenu;
	}

	public void set_contenu(String _contenu) {
		this._contenu = _contenu;
	}

	public String get_writer() {
		return _writer;
	}

	public void set_writer(String _writer) {
		this._writer = _writer;
	}

	public String get_cat() {
		return _cat;
	}

	public void set_cat(String _cat) {
		this._cat = _cat;
	}

	public Date get_date() {
		return _date;
	}

	public void set_date(Date _date) {
		this._date = _date;
	}

}
