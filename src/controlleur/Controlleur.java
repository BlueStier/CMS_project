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
import model.Cat;
import model.Commentaires;
import model.MODEL;
import model.Parametres;
import model.Roles;
import model.Team;
import model.Themes;
import model.Visiteurs;

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
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String choix = request.getQueryString();
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
						verif_com(session);
						session.setAttribute("user", user);
						session.setAttribute("user_pseudo", user.get_pseudo());
						RequestDispatcher rd = getServletContext().getRequestDispatcher("/tdb.jsp");
						rd.forward(request, response);
					} else {
						redirect(request, response, "/index.jsp", pseudo_or_mdp_error);
					}
				} else {
					redirect(request, response, "/index.jsp", pseudo_or_mdp_error);
				}
			}
		}
		/* vérifie les paramètres passés en méthode get */
		if (choix != null) {
			redirect_userOK(request, response, session, choix);

		}
		/*
		 * Lors d'un enregistrement d'article déclenche l'envoi en bdd si
		 * l'utilisateur clique sur enregistrer
		 */
		if (request.getParameter("registerArticle") != null) {
			registerArticle(request, response, session, true, (String) session.getAttribute("user_pseudo"));
		}
		/*
		 * Lors d'un enregistrement d'un nouveau membre de la team déclenche
		 * l'envoi en bdd si l'utilisateur clique sur enregistrer
		 */
		if (request.getParameter("registerUser") != null) {
			registerUser(request, response, session, true);

		}

		/*
		 * Lors d'un enregistrement d'un nouveau role déclenche l'envoi en bdd
		 * si l'utilisateur clique sur enregistrer
		 */
		if (request.getParameter("registerRole") != null) {
			registerRole(request, response, session, true);

		}

		/*
		 * Lors d'un enregistrement d'un nouveau visiteur déclenche l'envoi en
		 * bdd si l'utilisateur clique sur enregistrer
		 */
		if (request.getParameter("registerVis") != null) {
			registerVis(request, response, session, true);

		}

		/*
		 * Lors d'un enregistrement d'un nouveau parametre déclenche l'envoi en
		 * bdd si l'utilisateur clique sur enregistrer
		 */
		if (request.getParameter("registerParam") != null) {
			registerParam(request, response, session, true);

		}

		/*
		 * Lors d'un enregistrement d'une nouvelle catégorie déclenche l'envoi
		 * en bdd si l'utilisateur clique sur enregistrer
		 */
		if (request.getParameter("registerCat") != null) {
			registerCat(request, response, session, true);

		}
		/**
		 * Lors de la confirmation d'un utilisateur de suppression d'un
		 * utilisateur effectue la suppression dans la bdd et redirige vers la
		 * page affichant tous les utilisateurs
		 **/
		if (request.getParameter("confSupUser") != null) {
			int t = Integer.parseInt(request.getParameter("supUser"));
			MODEL<Team> team = (MODEL<Team>) DAOFactory.getTeamDAO().find(t);
			DAOFactory.getTeamDAO().delete(team);
			redirect_userOK(request, response, session, "5");
		}
		/**
		 * Lorsque l'on clique sur modifier un utilisateur récupère l'id à
		 * modifier et redirige vers la page d'enregistrement en récupérant les
		 * valeurs
		 **/
		if (request.getParameter("confModifUser") != null) {
			int t = Integer.parseInt(request.getParameter("modifUser"));
			MODEL<Team> team = (MODEL<Team>) DAOFactory.getTeamDAO().find(t);
			session.setAttribute("demandeModif", team);
			redirect_userOK(request, response, session, "2");

		}
		/*
		 * Lors d'un enregistrement de la modif d'un utilisateur déclenche
		 * l'envoi en bdd si l'utilisateur clique sur enregistrer
		 */
		if (request.getParameter("updateUser") != null) {
			registerUser(request, response, session, false);
		}
		/**
		 * Lors de la confirmation d'un utilisateur de suppression d'un role
		 * effectue la suppression dans la bdd et redirige vers la page
		 * affichant tous les utilisateurs
		 **/
		if (request.getParameter("confSupRole") != null) {
			int t = Integer.parseInt(request.getParameter("supRole"));
			MODEL<Roles> Role = (MODEL<Roles>) DAOFactory.getRolesDAO().find(t);
			DAOFactory.getRolesDAO().delete(Role);
			redirect_userOK(request, response, session, "9");
		}
		/**
		 * Lorsque l'on clique sur modifier un role récupère l'id à modifier et
		 * redirige vers la page d'enregistrement en récupérant les valeurs
		 **/
		if (request.getParameter("confModifRole") != null) {
			int t = Integer.parseInt(request.getParameter("modifRole"));
			MODEL<Roles> role = (MODEL<Roles>) DAOFactory.getRolesDAO().find(t);
			session.setAttribute("demandeModifR", role);
			redirect_userOK(request, response, session, "6");
		}
		/*
		 * Lors d'un enregistrement de la modif d'un role déclenche l'envoi en
		 * bdd si l'utilisateur clique sur enregistrer
		 */
		if (request.getParameter("updateRole") != null) {
			registerRole(request, response, session, false);
		}
		/**
		 * Lors de la confirmation d'un utilisateur de suppression d'un visiteur
		 * effectue la suppression dans la bdd et redirige vers la page
		 * affichant tous les visiteurs
		 **/
		if (request.getParameter("confSupVis") != null) {
			int t = Integer.parseInt(request.getParameter("supVis"));
			MODEL<Visiteurs> vis = (MODEL<Visiteurs>) DAOFactory.getVisiteursDAO().find(t);
			DAOFactory.getVisiteursDAO().delete(vis);
			redirect_userOK(request, response, session, "11");
		}

		/**
		 * Lorsque l'on clique sur modifier un visiteur récupère l'id à modifier
		 * et redirige vers la page d'enregistrement en récupérant les valeurs
		 **/
		if (request.getParameter("confModifVis") != null) {
			int t = Integer.parseInt(request.getParameter("modifVis"));
			MODEL<Visiteurs> vis = (MODEL<Visiteurs>) DAOFactory.getVisiteursDAO().find(t);
			session.setAttribute("demandeModifV", vis);
			redirect_userOK(request, response, session, "10");
		}
		/**
		 * Lors d'un enregistrement de la modif d'un visiteur déclenche l'envoi
		 * en bdd si l'utilisateur clique sur enregistrer
		 **/
		if (request.getParameter("updateVis") != null) {
			registerVis(request, response, session, false);
		}
		/**
		 * Lors de la confirmation d'un utilisateur de suppression d'un
		 * parametre effectue la suppression dans la bdd et redirige vers la
		 * page affichant tous les parametres
		 **/
		if (request.getParameter("confSupParam") != null) {
			int t = Integer.parseInt(request.getParameter("supParam"));
			MODEL<Parametres> vis = (MODEL<Parametres>) DAOFactory.getParametresDAO().find(t);
			DAOFactory.getParametresDAO().delete(vis);
			redirect_userOK(request, response, session, "15");
		}

		/**
		 * Lorsque l'on clique sur modifier un parametre récupère l'id à
		 * modifier et redirige vers la page d'enregistrement en récupérant les
		 * valeurs
		 **/
		if (request.getParameter("confModifParam") != null) {
			int t = Integer.parseInt(request.getParameter("modifParam"));
			MODEL<Parametres> param = (MODEL<Parametres>) DAOFactory.getParametresDAO().find(t);
			session.setAttribute("demandeModifP", param);
			redirect_userOK(request, response, session, "14");
		}
		/**
		 * Lorsque l'on clique sur appliquet un parametre récupère l'id à
		 * appliquer, met le theme à true en bdd et redirige vers la page de visu des paramètres
		 **/
		if (request.getParameter("appParam") != null) {
			int t = Integer.parseInt(request.getParameter("okParam"));
			MODEL<Parametres> param = (MODEL<Parametres>) DAOFactory.getParametresDAO().find(t);
			DAOFactory.getThemesDAO().reset_courant();
			MODEL<Themes> th =(MODEL<Themes>)DAOFactory.getThemesDAO().find(param.get_theme().get_id());
			th.set_courant(true);
			DAOFactory.getThemesDAO().update(th);
			redirect_userOK(request, response, session, "17");
		}
		/**
		 * Lors d'un enregistrement de la modif d'un parametre déclenche l'envoi
		 * en bdd si l'utilisateur clique sur enregistrer
		 **/
		if (request.getParameter("updateParam") != null) {
			registerParam(request, response, session, false);
		}
		/**
		 * Lors de la confirmation d'un utilisateur de suppression d'un article
		 * effectue la suppression dans la bdd et redirige vers la page
		 * affichant tous les articles
		 **/
		if (request.getParameter("confSupArticle") != null) {
			int t = Integer.parseInt(request.getParameter("supArticle"));
			MODEL<Articles> vis = (MODEL<Articles>) DAOFactory.getArticlesDAO().find(t);
			DAOFactory.getArticlesDAO().delete(vis);
			redirect_userOK(request, response, session, "19");
		}

		/**
		 * Lorsque l'on clique sur modifier un article récupère l'id à modifier
		 * et redirige vers la page d'enregistrement en récupérant les valeurs
		 **/
		if (request.getParameter("confModifArticle") != null) {
			int t = Integer.parseInt(request.getParameter("modifArticle"));
			MODEL<Articles> vis = (MODEL<Articles>) DAOFactory.getArticlesDAO().find(t);
			session.setAttribute("demandeModifA", vis);
			redirect_userOK(request, response, session, "18");
		}
		/**
		 * Lors d'un enregistrement de la modif d'un visiteur déclenche l'envoi
		 * en bdd si l'utilisateur clique sur enregistrer
		 **/
		if (request.getParameter("updateArticle") != null) {
			registerArticle(request, response, session, false, (String) session.getAttribute("user_pseudo"));
		}
		/**
		 * Lorsque l'on clique sur modéré un Commentaire récupère l'id à
		 * modifier et effectue le changement en bdd
		 **/
		if (request.getParameter("confModeCom") != null) {
			int t = Integer.parseInt(request.getParameter("modeCom"));
			MODEL<Commentaires> com = (MODEL<Commentaires>) DAOFactory.getCommentairesDAO().find(t);
			com.set_mod(false);
			DAOFactory.getCommentairesDAO().mod(com);
			redirect_userOK(request, response, session, "28");
		}
		/**
		 * Lorsque l'on clique sur la clochette et que l'on choisi un
		 * Commentaire a modéré récupère l'id à modifier et effectue le
		 * changement en bdd et remet à jour la clochette
		 **/
		if (request.getParameter("confModeCom1") != null) {
			int t = Integer.parseInt(request.getParameter("modeCom1"));
			MODEL<Commentaires> com = (MODEL<Commentaires>) DAOFactory.getCommentairesDAO().find(t);
			com.set_mod(false);
			DAOFactory.getCommentairesDAO().mod(com);
			verif_com(session);
			redirect_userOK(request, response, session, "1");
		}
		/**
		 * Lors de la confirmation d'un utilisateur de suppression d'un
		 * commentaires effectue la suppression dans la bdd et redirige vers la
		 * page affichant tous les commentaires
		 **/
		if (request.getParameter("confSupCom") != null) {
			int t = Integer.parseInt(request.getParameter("supCom"));
			MODEL<Commentaires> com = (MODEL<Commentaires>) DAOFactory.getCommentairesDAO().find(t);
			DAOFactory.getCommentairesDAO().delete(com);
			redirect_userOK(request, response, session, "28");
		}

		/**
		 * Lors de la confirmation d'un utilisateur de suppression d'une
		 * catégorie effectue la suppression dans la bdd remonte d'un cran
		 * toutes les catégories ayant un ordre inférieur et redirige vers la
		 * page affichant toutes les catégories
		 **/
		if (request.getParameter("confSupCat") != null) {
			int t = Integer.parseInt(request.getParameter("supCat"));
			MODEL<Cat> cat = (MODEL<Cat>) DAOFactory.getCatDAO().find(t);
			DAOFactory.getCatDAO().delete(cat);
			DAOFactory.getCatDAO().asc(cat.get_ordre());
			redirect_userOK(request, response, session, "23");
		}
		/**
		 * Lorsque l'on clique sur modifier un role récupère l'id à modifier et
		 * redirige vers la page d'enregistrement en récupérant le nom de la catégorie
		 **/
		if (request.getParameter("confModifCat") != null) {
			int t = Integer.parseInt(request.getParameter("modifCat"));
			MODEL<Cat> cat = (MODEL<Cat>) DAOFactory.getCatDAO().find(t);
			session.setAttribute("demandeModifC", cat);
			redirect_userOK(request, response, session, "22");
		}
		/*
		 * Lors d'un enregistrement de la modif d'une catégorie déclenche l'envoi en
		 * bdd si l'utilisateur clique sur enregistrer
		 */
		if (request.getParameter("updateCat") != null) {
			registerCat(request, response, session, false);
		}
		/**
		 * Lorsque l'on clique sur down d'une catégorie
		 * effectue le changement en bdd et redirige vers la page d'affichage
		 **/
		if (request.getParameter("downOk") != null) {
			int t = Integer.parseInt(request.getParameter("down"));
			DAOFactory.getCatDAO().upOrDown(t,false);			
			redirect_userOK(request, response, session, "23");
		}
		/**
		 * Lorsque l'on clique sur up d'une catégorie
		 * effectue le changement en bdd et redirige vers la page d'affichage
		 **/
		if (request.getParameter("upOk") != null) {
			int t = Integer.parseInt(request.getParameter("up"));
			DAOFactory.getCatDAO().upOrDown(t,true);			
			redirect_userOK(request, response, session, "23");
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
	 * fonction enregistrant un article dans la BDD et redirigeant vers la page
	 * d'acceuil
	 * 
	 * @throws IOException
	 * @throws ServletException
	 **/

	public void registerArticle(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			boolean createOrUpdate, String pseudo) throws ServletException, IOException {
		String titre = request.getParameter("titre");
		String contenu = request.getParameter("contenu");
		String resume = request.getParameter("resume");
		int cat = Integer.parseInt(request.getParameter("categorie")) + 1;
		String visible = request.getParameter("visible");
		String commentaires = request.getParameter("commentaires");
		boolean v = false;
		boolean c = false;

		if (visible != null) {
			v = true;
		}
		if (commentaires != null) {
			v = true;
		}
		DAO<?> article = DAOFactory.getArticlesDAO();
		MODEL<?> a = MODELFactory.getArticles();
		Cat ca = new Cat();
		ca.set_id(cat);
		a.set_titre(titre);
		a.set_contenu(contenu);
		a.set_resume(resume);
		a.set_cat(ca);
		a.set_writer(pseudo);
		a.set_visible(v);
		a.set_commentaires(c);
		if (createOrUpdate) {
			article.create(a);
		} else {
			int id = Integer.parseInt(request.getParameter("idModif"));
			a.set_id(id);
			article.update(a);
			session.setAttribute("demandeModifA", null);
		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/tdb.jsp");
		rd.forward(request, response);
	}

	/**
	 * fonction enregistrant un utilisateur dans la BDD et redirigeant vers la
	 * page d'acceuil
	 * 
	 * @throws IOException
	 * @throws ServletException
	 **/
	public void registerUser(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			boolean createOrUpdate) throws ServletException, IOException {
		String nom = request.getParameter("nomUser");
		String pseudo = request.getParameter("pseudoUser");
		String mail = request.getParameter("mailUser");
		String mdp = Crypt.encrypted(request.getParameter("mdpUser"));
		int rol = Integer.parseInt(request.getParameter("role")) + 1;
		DAO<?> team = DAOFactory.getTeamDAO();
		MODEL<?> a = MODELFactory.getTeam();
		Roles r = new Roles();
		r.set_id(rol);
		a.set_nom(nom);
		a.set_pseudo(pseudo);
		a.set_mail(mail);
		a.set_mdp(mdp);
		a.set_role(r);
		if (createOrUpdate) {
			team.create(a);
		} else {
			int id = Integer.parseInt(request.getParameter("idModif"));
			a.set_id(id);
			team.update(a);
			session.setAttribute("demandeModif", null);
		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/tdb.jsp");
		rd.forward(request, response);
	}

	/**
	 * fonction enregistrant un role dans la BDD et redirigeant vers la page
	 * d'acceuil
	 * 
	 * @throws IOException
	 * @throws ServletException
	 **/
	public void registerRole(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			boolean createOrUpdate) throws ServletException, IOException {
		String nom = request.getParameter("nomRole");
		String ajout_user = request.getParameter("ajout_users");
		String ajout_theme = request.getParameter("ajout_theme");
		String ajout_article = request.getParameter("ajout_article");
		String ajout_mod = request.getParameter("ajout_mod");
		String ajout_role = request.getParameter("ajout_role");
		String ajout_visiteur = request.getParameter("ajout_visiteur");
		String ajout_param = request.getParameter("ajout_param");
		String ajout_cat = request.getParameter("ajout_cat");
		boolean au = false;
		boolean at = false;
		boolean aa = false;
		boolean m = false;
		boolean ar = false;
		boolean av = false;
		boolean ap = false;
		boolean ac = false;

		if (ajout_user != null) {
			au = true;
		}
		if (ajout_theme != null) {
			at = true;
		}
		if (ajout_article != null) {
			aa = true;
		}
		if (ajout_mod != null) {
			m = true;
		}
		if (ajout_role != null) {
			ar = true;
		}
		if (ajout_visiteur != null) {
			av = true;
		}
		if (ajout_param != null) {
			ap = true;
		}
		if (ajout_cat != null) {
			ac = true;
		}
		DAO<?> role = DAOFactory.getRolesDAO();
		MODEL<?> a = MODELFactory.getRoles();
		a.set_nom(nom);
		a.set_ajout_articles(aa);
		a.set_ajout_themes(at);
		a.set_ajout_users(au);
		a.set_mod(m);
		a.set_ajout_role(ar);
		a.set_ajout_visiteur(av);
		a.set_ajout_param(ap);
		a.set_ajout_cat(ac);
		if (createOrUpdate) {
			role.create(a);

		} else {
			int id = Integer.parseInt(request.getParameter("idModif"));
			a.set_id(id);
			role.update(a);
			session.setAttribute("demandeModifR", null);
		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/tdb.jsp");
		rd.forward(request, response);
	}

	/**
	 * fonction enregistrant un utilisateur dans la BDD et redirigeant vers la
	 * page d'acceuil
	 * 
	 * @throws IOException
	 * @throws ServletException
	 **/
	public void registerVis(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			boolean createOrUpdate) throws ServletException, IOException {
		String pseudo = request.getParameter("pseudoVis");
		String mail = request.getParameter("mailVis");
		String mdp = Crypt.encrypted(request.getParameter("mdpVis"));
		DAO<?> visiteur = DAOFactory.getVisiteursDAO();
		MODEL<?> a = MODELFactory.getVisiteurs();

		a.set_pseudo(pseudo);
		a.set_mail(mail);
		a.set_mdp(mdp);
		if (createOrUpdate) {
			visiteur.create(a);
		} else {
			int id = Integer.parseInt(request.getParameter("idModif"));
			a.set_id(id);
			visiteur.update(a);
			session.setAttribute("demandeModifV", null);
		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/tdb.jsp");
		rd.forward(request, response);
	}

	/** Fonction vérifiant la présence de commentaires à modérer dans la bdd **/
	@SuppressWarnings("unchecked")
	public void verif_com(HttpSession session) {
		DAO<?> comDAO = DAOFactory.getCommentairesDAO();
		ArrayList<MODEL<Commentaires>> listeCOM = new ArrayList<MODEL<Commentaires>>();
		for (int i = 0; i < comDAO.get_all().size(); i++) {
			if (((MODEL<Commentaires>) comDAO.get_all().get(i)).is_mod()) {
				listeCOM.add((MODEL<Commentaires>) comDAO.get_all().get(i));
			}
		}
		if (listeCOM.size() > 0) {
			session.setAttribute("commentaires", listeCOM);
			session.setAttribute("comOK", 1);
		} else {
			session.setAttribute("comOK", 0);
		}
	}

	/**
	 * fonction enregistrant un paramètre dans la BDD et redirigeant vers la
	 * page d'acceuil
	 * 
	 * @throws IOException
	 * @throws ServletException
	 **/
	public void registerParam(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			boolean createOrUpdate) throws ServletException, IOException {
		String nom = request.getParameter("nomParam");
		String description = request.getParameter("paramDes");
		int cat = Integer.parseInt(request.getParameter("paramThem")) + 1;

		DAO<?> param = DAOFactory.getParametresDAO();
		MODEL<?> a = MODELFactory.getParametres();
		Themes ca = new Themes();
		ca.set_id(cat);
		a.set_nom(nom);
		a.set_description(description);
		a.set_theme(ca);
		if (createOrUpdate) {
			param.create(a);
		} else {
			int id = Integer.parseInt(request.getParameter("idModif"));
			a.set_id(id);
			param.update(a);
			session.setAttribute("demandeModifP", null);
		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/tdb.jsp");
		rd.forward(request, response);
	}

	/**
	 * fonction enregistrant une catégorie dans la BDD et redirigeant vers la
	 * page d'acceuil
	 * 
	 * @throws IOException
	 * @throws ServletException
	 **/
	public void registerCat(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			boolean createOrUpdate) throws ServletException, IOException {
		String nom = request.getParameter("nomCat");		
		DAO<?> Cat = DAOFactory.getCatDAO();
		MODEL<?> a = MODELFactory.getCat();
		a.set_nom(nom);		
		if (createOrUpdate) {
			Cat.create(a);
		} else {
			@SuppressWarnings("unchecked")
			MODEL<?> ordre = (MODEL<Cat>) session.getAttribute("demandeModifC");
			a.set_ordre(ordre.get_ordre());
			a.set_id(ordre.get_id());
			Cat.update(a);
		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/tdb.jsp");
		rd.forward(request, response);
	}

	public void redirect_userOK(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			String choix) throws ServletException, IOException {
		verif_com(session);
		RequestDispatcher rd;
		int indice = Integer.parseInt(choix);
		switch (indice) {
		case 1:
			session.setAttribute("voir", 1);
			rd = getServletContext().getRequestDispatcher("/tdb.jsp");
			rd.forward(request, response);
			break;
		/** utilisateur **/
		case 2:
			rd = getServletContext().getRequestDispatcher("/WEB-INF/ajouter/user.jsp");
			rd.forward(request, response);
			break;
		case 3:
		case 4:
		case 5:
			rd = getServletContext().getRequestDispatcher("/tdb.jsp");
			session.setAttribute("voir", 5);
			rd.forward(request, response);
			break;
		/** roles **/
		case 6:
			rd = getServletContext().getRequestDispatcher("/WEB-INF/ajouter/roles.jsp");
			rd.forward(request, response);
			break;
		case 7:
		case 8:
		case 9:
			rd = getServletContext().getRequestDispatcher("/tdb.jsp");
			session.setAttribute("voir", 9);
			rd.forward(request, response);
			break;
		/** visiteurs **/
		case 10:
			rd = getServletContext().getRequestDispatcher("/WEB-INF/ajouter/visiteur.jsp");
			rd.forward(request, response);
			break;
		case 11:
		case 12:
		case 13:
			rd = getServletContext().getRequestDispatcher("/tdb.jsp");
			session.setAttribute("voir", 13);
			rd.forward(request, response);
			break;
		/** parametres **/
		case 14:
			rd = getServletContext().getRequestDispatcher("/WEB-INF/ajouter/parametre.jsp");
			rd.forward(request, response);
			break;
		case 15:
		case 16:
		case 17:
			rd = getServletContext().getRequestDispatcher("/tdb.jsp");
			session.setAttribute("voir", 17);
			rd.forward(request, response);
			break;
		/** articles **/
		case 18:
			rd = getServletContext().getRequestDispatcher("/WEB-INF/ajouter/ajouterArticle.jsp");
			rd.forward(request, response);
			break;
		case 19:
		case 20:
		case 21:
			rd = getServletContext().getRequestDispatcher("/tdb.jsp");
			session.setAttribute("voir", 21);
			rd.forward(request, response);
			break;
		/** Catégories **/
		case 22:
			rd = getServletContext().getRequestDispatcher("/WEB-INF/ajouter/cat.jsp");
			rd.forward(request, response);
			break;
		case 23:
		case 24:
		case 25:
			rd = getServletContext().getRequestDispatcher("/tdb.jsp");
			session.setAttribute("voir", 23);
			rd.forward(request, response);
			break;
		/** Commentaires **/
		case 26:
		case 27:
		case 28:
			rd = getServletContext().getRequestDispatcher("/tdb.jsp");
			session.setAttribute("voir", 28);
			rd.forward(request, response);
			break;
		case 30:
			rd = getServletContext().getRequestDispatcher("/site.jsp");			
			rd.forward(request, response);
			break;	
		}
	}
}
