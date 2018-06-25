package main;


import java.util.ArrayList;

import dao.DAO;

import factory.DAOFactory;
import model.Commentaires;


public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		DAO<?> c = DAOFactory.getCommentairesDAO();
		
		
		
	}

}
 