package model;
/* class object representant un theme de la bdd 
 * comprenant son id, sa decsription, et utilisant un objet theme
 * getters et setters en fonction des variables membres
 * toString red�finie
 * */

import java.util.ArrayList;
import java.util.Date;

public class Parametres extends MODEL<Parametres>{
	private int _id;
	private String _nom;
	private Themes _theme;
	private String _description;

	public Parametres() {
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
	public Themes get_theme() {
		return _theme;
	}

	@Override
	public void set_theme(Themes _theme) {
		this._theme = _theme;
	}
	
	@Override
	public String get_description() {
		return _description;
	}
	
	@Override
	public void set_description(String _description) {
		this._description = _description;
	}

	@Override
	public String toString() {
		return "id : " + _id + " description :" + _description + " theme : " + _theme.toString();
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
