package main;

import accessBDD.BDD;
import dao.VisiteursDAO;
import model.Visiteurs;

public class Main {

	public static void main(String[] args) {
		BDD b = new BDD();
		
		Visiteurs c = new Visiteurs();
		c.set_id(1);
		c.set_pseudo("update");
		c.set_mail("update encore");
		boolean a = new VisiteursDAO(b).update(c);
		System.out.println(a);
		// System.out.println(t.toString());

	}

}
 