package model;
/* class object representant un theme de la bdd 
 * comprenant son id, son contenu, son nom et son path
 * getters et setters en fonction des variables membres
 * toString redéfinie
 * */

import java.util.ArrayList;
import java.util.Date;

public class Themes extends MODEL<Themes>{
	private int _id;
	private String _nom;
	private String _path;

	public Themes() {
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
	public String get_path() {
		return _path;
	}

	@Override
	public void set_path(String _path) {
		this._path = _path;
	}
	
	@Override
	public String toString(){
		return "id : "+_id+" nom : "+_nom+" path: "+_path;
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

}
