import accessBDD.BDD;
import dao.RolesDAO;
import model.Roles;

public class test {
	BDD b = new BDD();	
	RolesDAO rd = new RolesDAO(b);
	Roles r = rd.find(1);
	System.out.println();
	
}
