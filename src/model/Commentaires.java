package model;

import java.util.ArrayList;
import java.util.Date;

/* class object representant un commentaires de la bdd 
 * comprenant son id, son contenu, s'il est modéré ou non,la date.
 * fait appel aux objets articles et visiteur
 * getters et setters en fonction des variables membres
 * toString redéfinie
 * */
public class Commentaires extends MODEL<Commentaires>{
	private int _id;
	private String _contenu;
	private boolean _mod;
	private Articles _article;
	private Date _date;
	private Visiteurs _visiteur;

	public Commentaires() {
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
	public String get_contenu() {
		return _contenu;
	}

	@Override
	public void set_contenu(String _contenu) {
		this._contenu = _contenu;
	}

	@Override
	public boolean is_mod() {
		return _mod;
	}

	@Override
	public void set_mod(boolean _mod) {
		this._mod = _mod;
	}

	@Override
	public Articles get_article() {
		return _article;
	}

	@Override
	public void set_article(Articles _article) {
		this._article = _article;
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
	public Visiteurs get_visiteurs() {
		return _visiteur;
	}

	@Override
	public void set_visiteur(Visiteurs _visiteur) {
		this._visiteur = _visiteur;
	}

	@Override
	public String toString() {
		return "id : " + _id + " contenu : " + _contenu + " modérateur : " + _mod + " date : " + _date + "\narticle : "
				+ _article.toString() + "\n visiteur :" + _visiteur.toString();
	}

	@Override
	public String get_titre() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void set_titre(String t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String get_resume() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void set_resume(String r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String get_writer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void set_writer(String w) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cat get_cat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void set_cat(Cat c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean is_commentaires() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void set_commentaires(boolean c) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void set_visible(boolean v) {
		// TODO Auto-generated method stub
		
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
