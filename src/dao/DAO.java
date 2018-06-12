package dao;

import java.util.ArrayList;

import accessBDD.BDD;
import model.MODEL;
/*class bstraite qui d�fini les fonctions de cr�ation, de suppression
 * de modification et de recherche
 */

public abstract class DAO<T> {
	protected BDD _connection;

	public DAO(BDD connection) {
		_connection = connection;
	}

	/**
	 * M�thode de cr�ation
	 * 
	 * @param m
	 * @return boolean
	 */
	public abstract boolean create(MODEL<?> m);

	/**
	 * M�thode pour effacer
	 * 
	 * @param obj
	 * @return boolean
	 */
	public abstract boolean delete(MODEL<?> obj);

	/**
	 * M�thode de mise � jour
	 * 
	 * @param obj
	 * @return boolean
	 */
	public abstract boolean update(MODEL<?> obj);

	/**
	 * M�thode de recherche des informations
	 * 
	 * @param id
	 * @return T
	 */
	public abstract T find(int id);
	
	
	/**
	 * M�thode de recherche de tous les objects de la bdd
	 * 
	 * @param id
	 * @return T
	 */
	public abstract ArrayList<T> get_all();
}
