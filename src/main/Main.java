package main;

import java.util.ArrayList;

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
import model.Roles;
import model.Themes;
import model.Visiteurs;

public class Main {

	public static void main(String[] args) {
//		BDD b = new BDD();
//		
		MODEL<?> m = MODELFactory.getTeam();
		MODEL<?> r = MODELFactory.getRoles();
		r.set_id(3);
		m.set_id(1);
		m.set_pseudo("mod");
		m.set_nom("mod");
		m.set_mail("test@crypt.dtc");
		m.set_role((Roles)r);
		m.set_mdp(Crypt.encrypted("mod"));	
		
		
					
		DAO<?> a= DAOFactory.getTeamDAO();
		System.out.println(a.create(m));
		
//		
//		System.out.println(a.find(1));
//		 System.out.println(t.toString());
//		
		}

}
 