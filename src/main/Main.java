package main;

import org.mindrot.jbcrypt.BCrypt;

import accessBDD.BDD;
import crypt.Crypt;
import dao.ArticlesDAO;
import dao.DAO;
import dao.VisiteursDAO;
import factory.DAOFactory;
import factory.MODELFactory;
import model.Articles;
import model.MODEL;
import model.Visiteurs;

public class Main {

	public static void main(String[] args) {
//		BDD b = new BDD();
//		
//		MODEL<?> m = MODELFactory.getThemes();
//		m.set_nom("model factory avec package indépendant");
//		m.set_path("dit ça marche ?");
//		
//		
//		DAO<?> a= DAOFactory.getThemesDAO();
//		a.create(m);
//		
//		System.out.println(a.find(1));
//		 System.out.println(t.toString());
//		
		String mdp_crypt = BCrypt.hashpw("secret", BCrypt.gensalt());
		System.out.println(mdp_crypt);
		System.out.println(Crypt.decripted("secret", mdp_crypt));

	}

}
 