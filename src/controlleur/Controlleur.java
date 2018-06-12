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
import model.MODEL;

/**
 * Servlet implementation class Controlleur
 */
@WebServlet("/Controlleur")
public class Controlleur extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controlleur() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String pseudo_or_mdp_error = "Pseudo ou mot de passe incorrect";
		String msg_remplir_champs_connexion = "Veuillez remplir tous les champs pour vous connecter";
		String pseudo = request.getParameter("pseudo");
		String mdp = request.getParameter("mdp");

		/**
		 * Si le bouton connexion est cliqué : On vérifie que tous les champs
		 * sont rempli si ce n'est pas le cas on retourne vers la page d'index
		 * en affichant "Veuillez remplir tous les champs pour vous connecter".
		 * Si les champs sont remplis on récupère les info team de la bdd et on
		 * compare le pseudo pour voir s'il est en base. S'il ne l'est pas on
		 * redirige vers la page index avec info mdp ou pseudo hs. Si le pseudo
		 * est en base on vérifie que le mdp est correct et on redirige vers la
		 * page suivante sinon retour index avec le même message.
		 */
		if (request.getParameter("connexion") != null) {
			if (pseudo.isEmpty() || pseudo.trim().equals("") || mdp.isEmpty() || mdp.trim().equals("")) {
				redirect(request, response, "/index.jsp", msg_remplir_champs_connexion);
				//
			} else {
				DAO<?> userDAO = DAOFactory.getTeamDAO();
				ArrayList<?> liste = userDAO.get_all();
				MODEL<?> user = MODELFactory.getTeam().verify(liste, pseudo);
				if (user != null) {
					boolean verify_mdp = Crypt.decripted(mdp, user.get_mdp());
					if (verify_mdp) {
						session.setAttribute("user", user);
						redirect_users_ok(request, response, user);
						// RequestDispatcher rd =
						// getServletContext().getRequestDispatcher("/acceuil.jsp");
						// rd.forward(request, response);
					} else {
						redirect(request, response, "/index.jsp", pseudo_or_mdp_error);
					}
				} else {
					redirect(request, response, "/index.jsp", pseudo_or_mdp_error);
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

	/** fonction de redirection vers la jsp **/
	public void redirect(HttpServletRequest request, HttpServletResponse response, String page, String message)
			throws ServletException, IOException {
		RequestDispatcher rd;
		rd = getServletContext().getRequestDispatcher(page);
		request.setAttribute("pseudo_or_mdp_error", message);
		rd.forward(request, response);
	}

	/**
	 * fonction sui redirige l'utilisateur en fonction de son role donc role 1
	 * admin, role 2 writer...S
	 **/
	public void redirect_users_ok(HttpServletRequest request, HttpServletResponse response, MODEL<?> user)
			throws ServletException, IOException {
		RequestDispatcher rd;

		/**
		 * vérification du role de l'utilisateur pour redirection sur la page
		 * correspondante
		 **/
		switch (user.get_role().get_id()) {
		case 1:
			rd = getServletContext().getRequestDispatcher("/admin.jsp");
			rd.forward(request, response);
			break;
		case 2:
			rd = getServletContext().getRequestDispatcher("/writer.jsp");
			rd.forward(request, response);
			break;
		case 3:
			rd = getServletContext().getRequestDispatcher("/mod.jsp");
			rd.forward(request, response);
			break;
		default:
			redirect(request, response, "/index.jsp", "nous n'avons pas pu donner une suite favorable à votre demande");
			break;
		}
	}
}
