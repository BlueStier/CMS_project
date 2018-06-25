package model;
/* class object representant un role de la bdd 
 * comprenant son id, son nom, si il peut aujouter des user,
 * des articles, des themes et s'il est modérateur
 * getters et setters en fonction des variables membres
 * toString redéfinie
 * */

import java.util.ArrayList;
import java.util.Date;

public class Roles extends MODEL<Roles> {
	private int _id;
	private String _nom;
	private boolean _ajout_users;
	private boolean _moderateur;
	private boolean _ajout_themes;
	private boolean _ajout_articles;
	private boolean _ajout_role;
	private boolean _ajout_visiteur;
	private boolean _ajout_param;
	private boolean _ajout_cat;

	public Roles() {

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
	public String get_nom() {
		return _nom;
	}

	@Override
	public void set_nom(String _nom) {
		this._nom = _nom;
	}

	@Override
	public boolean is_ajout_users() {
		return _ajout_users;
	}

	@Override
	public void set_ajout_users(boolean _ajout_users) {
		this._ajout_users = _ajout_users;
	}

	@Override
	public boolean is_mod() {
		return _moderateur;
	}

	@Override
	public void set_mod(boolean _moderateur) {
		this._moderateur = _moderateur;
	}

	@Override
	public boolean is_ajout_themes() {
		return _ajout_themes;
	}

	@Override
	public void set_ajout_themes(boolean _ajout_themes) {
		this._ajout_themes = _ajout_themes;
	}

	@Override
	public boolean is_ajout_articles() {
		return _ajout_articles;
	}

	@Override
	public void set_ajout_articles(boolean _ajout_articles) {
		this._ajout_articles = _ajout_articles;
	}

	@Override
	public String toString() {
		return "id : " + _id + "   nom : " + _nom + "   ajout users : " + _ajout_users + "   ajout themes : "
				+ _ajout_themes + "   ajout articles : " + _ajout_articles + "   modérateur : " + _moderateur;
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
	public String get_contenu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void set_contenu(String c) {
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
	public Date get_date() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void set_date(Date d) {
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
	public void set_ordre(int o) {
		// TODO Auto-generated method stub

	}

	@Override
	public int get_ordre() {
		// TODO Auto-generated method stub
		return 0;
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
		return _ajout_role;
	}

	@Override
	public void set_ajout_role(boolean aa) {
		_ajout_role = aa;

	}

	@Override
	public boolean is_ajout_visiteur() {

		return _ajout_visiteur;
	}

	@Override
	public void set_ajout_visiteur(boolean aa) {
		_ajout_visiteur = aa;

	}

	@Override
	public boolean is_ajout_param() {

		return _ajout_param;
	}

	@Override
	public void set_ajout_param(boolean aa) {
		_ajout_param = aa;

	}

	@Override
	public boolean is_ajout_cat() {		
		return _ajout_cat;
	}

	@Override
	public void set_ajout_cat(boolean aa) {
		_ajout_cat=aa;
		
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
