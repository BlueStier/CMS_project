package model;


import java.util.ArrayList;
import java.util.Date;
/* class object representant un article de la bdd 
 * comprenant son id, son contenu, la date.
 * la catégotie de l'article,son résumé, l'auteur
 * getters et setters en fonction des variables membres
 * toString redéfinie
 * */

public class Articles extends MODEL<Articles> {
	private int _id;
	private String _titre;
	private String _resume;
	private String _contenu;
	private String _writer;
	private Cat _cat;	
	private Date _date;
	private boolean _commentaires;
	private boolean _visible;

	public Articles() {

	}

	@Override
	public int get_id() {
		return _id;
	}

	@Override
	public void set_id(int _id) {
		this._id = _id;
	}

	@Override
	public String get_titre() {
		return _titre;
	}

	@Override
	public void set_titre(String _titre) {
		this._titre = _titre;
	}

	@Override
	public String get_resume() {
		return _resume;
	}

	@Override
	public void set_resume(String _resume) {
		this._resume = _resume;
	}

	@Override
	public String get_contenu() {
		return _contenu;
	}

	@Override
	public void set_contenu(String _contenu) {
		this._contenu = _contenu;
	}

	@Override
	public String get_writer() {
		return _writer;
	}

	@Override
	public void set_writer(String _writer) {
		this._writer = _writer;
	}

	@Override
	public Cat get_cat() {
		return _cat;
	}

	@Override
	public void set_cat(Cat _cat) {
		this._cat = _cat;
	}

	@Override
	public Date get_date() {
		return _date;
	}

	@Override
	public void set_date(Date _date) {
		this._date = _date;
	}

	@Override
	public boolean is_commentaires() {
		return _commentaires;
	}

	@Override
	public void set_commentaires(boolean _commentaires) {
		this._commentaires = _commentaires;
	}
	
	@Override
	public String toString() {
		return "id : "+_id+"   titre : "+_titre+"   résumé : "+_resume+"   contenu : "+_contenu+"   writer : "+_writer+"   \ncat : "+_cat.toString()+"  date : "+_date+"  commentaires :"+_commentaires+" visible : "+_visible;
	}

	@Override
	public void set_nom(String n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String get_nom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void set_ordre(int o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int get_ordre() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void set_mod(boolean m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean is_mod() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void set_article(Articles a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Articles get_article() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void set_visiteur(Visiteurs v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Visiteurs get_visiteurs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void set_theme(Themes t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Themes get_theme() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void set_description(String d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String get_description() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean is_ajout_users() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void set_ajout_users(boolean au) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean is_ajout_themes() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void set_ajout_themes(boolean at) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean is_ajout_articles() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void set_ajout_articles(boolean aa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String get_pseudo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void set_pseudo(String p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String get_mail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void set_mail(String m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Roles get_role() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void set_role(Roles r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String get_path() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void set_path(String p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String get_mdp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void set_mdp(String mdp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MODEL<?> verify(ArrayList<?> liste, Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean is_visible() {		
		return _visible;
	}

	@Override
	public void set_visible(boolean v) {
		_visible = v;
		
	}

	@Override
	public boolean is_ajout_role() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void set_ajout_role(boolean aa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean is_ajout_visiteur() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void set_ajout_visiteur(boolean aa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean is_ajout_param() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void set_ajout_param(boolean aa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean is_ajout_cat() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void set_ajout_cat(boolean aa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean is_courant() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void set_courant(boolean aa) {
		// TODO Auto-generated method stub
		
	}


}
