package model;

import java.util.ArrayList;
import java.util.Date;

public abstract class MODEL<T> {
	protected int _id;

	public abstract void set_id(int id);

	public abstract int get_id();

	public abstract String get_titre();

	public abstract void set_titre(String t);

	public abstract String get_resume();

	public abstract void set_resume(String r);

	public abstract String get_contenu();

	public abstract void set_contenu(String c);

	public abstract String get_writer();

	public abstract void set_writer(String w);

	public abstract Cat get_cat();

	public abstract void set_cat(Cat c);

	public abstract Date get_date();

	public abstract void set_date(Date d);

	public abstract boolean is_commentaires();

	public abstract void set_commentaires(boolean c);

	public abstract String toString();

	public abstract void set_nom(String n);

	public abstract String get_nom();

	public abstract void set_ordre(int o);

	public abstract int get_ordre();

	public abstract void set_mod(boolean m);

	public abstract boolean is_mod();

	public abstract void set_article(Articles a);

	public abstract Articles get_article();

	public abstract void set_visiteur(Visiteurs v);

	public abstract Visiteurs get_visiteurs();

	public abstract void set_theme(Themes t);

	public abstract Themes get_theme();

	public abstract void set_description(String d);

	public abstract String get_description();

	public abstract boolean is_ajout_users();

	public abstract void set_ajout_users(boolean au);

	public abstract boolean is_ajout_themes();

	public abstract void set_ajout_themes(boolean at);

	public abstract boolean is_ajout_articles();

	public abstract void set_ajout_articles(boolean aa);

	public abstract String get_pseudo();

	public abstract void set_pseudo(String p);

	public abstract String get_mail();

	public abstract void set_mail(String m);

	public abstract Roles get_role();

	public abstract void set_role(Roles r);

	public abstract String get_path();

	public abstract void set_path(String p);

	public abstract String get_mdp();

	public abstract void set_mdp(String mdp);
	
	public abstract MODEL<?> verify(ArrayList<?> liste, Object o);
}
