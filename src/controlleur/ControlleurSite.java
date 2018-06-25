package controlleur;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import crypt.Crypt;
import dao.DAO;
import factory.DAOFactory;
import factory.MODELFactory;
import model.Articles;
import model.MODEL;
import model.Visiteurs;

/**
 * Servlet implementation class ControlleurSite
 */
@WebServlet("/ControlleurSite")
public class ControlleurSite extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControlleurSite() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String choix = request.getQueryString();
		HttpSession session = request.getSession();
		String text = request.getParameter("text");
		String inscription = request.getParameter("boutoninscrip");
		String connexion = request.getParameter("boutonconn");
		String pseudo_in = request.getParameter("pseudo_inscr");
		String mdp_in = request.getParameter("mdp_inscr");
		String mail = request.getParameter("email");		
		String pseudo_co = request.getParameter("pseudo_conn");
		String mdp_co = request.getParameter("mdp_conn");
		String pseudo_or_mdp_error = "Pseudo ou mot de passe incorrect";

		/* vérifie les paramètres passés en méthode get */
		if (choix != null) {
			redirect_userOK(request, response, session, choix);

		}
		/** envoi en bdd un commentaire si le bouton poster est cliqué **/
		if (text != null) {
			if (session.getAttribute("visiteur") != null) {
				int id = Integer.parseInt(request.getParameter("numArt"));
				String cont = request.getParameter("textarea");
				MODEL<?> com = MODELFactory.getCommentaires();
				com.set_article((Articles) DAOFactory.getArticlesDAO().find(id));
				com.set_visiteur((Visiteurs) DAOFactory.getVisiteursDAO().find(1));
				com.set_contenu(cont);
				com.set_mod(true);
				DAOFactory.getCommentairesDAO().create(com);
				session.setAttribute("attenteMod", "Votre commentaires est bien pris en compte, il est en attente de validation");
				redirect_userOK(request, response, session, "2");
			} else {
				redirect_userOK(request, response, session, "4");
			}
		}

		if (inscription != null) {
			MODEL<Visiteurs> v = (MODEL<Visiteurs>) MODELFactory.getVisiteurs();
			v.set_pseudo(pseudo_in);
			mdp_in = Crypt.encrypted(mdp_in);
			v.set_mdp(mdp_in);
			v.set_mail(mail);
			DAOFactory.getVisiteursDAO().create(v);
			session.setAttribute("visiteur",v);
			redirect_userOK(request, response, session, "2");
		}
		if (connexion != null) {			
			ArrayList<Visiteurs> liste =(ArrayList<Visiteurs>) DAOFactory.getVisiteursDAO().get_all();
			int taille = liste.size();
			for(int i = 0;i<taille;i++){
				if(pseudo_co.equals(liste.get(i).get_pseudo())){					
					boolean verify_mdp = Crypt.decripted(mdp_co, liste.get(i).get_mdp());					
					if(verify_mdp){
						session.setAttribute("visiteur",liste.get(i));
						session.setAttribute("pseudo_or_mdp_error",null);
						redirect_userOK(request, response, session, "2");
					}
					else{						
						session.setAttribute("pseudo_or_mdp_error", pseudo_or_mdp_error);
						redirect_userOK(request, response, session, "2");
					}
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public void redirect_userOK(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			String choix) throws ServletException, IOException {
		RequestDispatcher rd;
		int indice = Integer.parseInt(choix);
		switch (indice) {
		/** Acceuil **/
		case 1:
			session.setAttribute("voir", 1);
			rd = getServletContext().getRequestDispatcher("/site.jsp");
			rd.forward(request, response);
			break;
		/** Articles **/
		case 2:
			rd = getServletContext().getRequestDispatcher("/site.jsp");
			session.setAttribute("voir", 2);
			rd.forward(request, response);
			break;
		/** Catégories **/
		case 3:
			rd = getServletContext().getRequestDispatcher("/site.jsp");
			session.setAttribute("voir", 3);
			rd.forward(request, response);
			break;
		/** inscription connection **/
		case 4:
			rd = getServletContext().getRequestDispatcher("/site.jsp");
			session.setAttribute("voir", 4);
			rd.forward(request, response);
			break;
		}
	}
}
