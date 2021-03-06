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
	 * M�thode de mise � jour de la mod�ration pour les commentaires
	 * 
	 * @param obj
	 * @return boolean
	 */
	public abstract boolean mod(MODEL<?> obj);

	/**
	 * M�thode de recherche des informations
	 * 
	 * @param id
	 * @return T
	 */
	public abstract T find(int id);
	
	/**
	 * M�thode de changement d'ordre
	 * 
	 * @param id
	 * @return T
	 */
	public abstract boolean upOrDown(int id, boolean up);
	
	/**
	 * M�thode de changement d'ordre si suppression de cat
	 * 
	 * @param id
	 * @return T
	 */
	public abstract boolean asc(int id);
	
	/**
	 * M�thode retrouvant le th�me courant
	 * 
	 * @param id
	 * @return T
	 */
	public abstract T find_courant();
	
	/**
	 * M�thode de recherche de tous les objects de la bdd
	 * 
	 * @param id
	 * @return T
	 */
	public abstract ArrayList<T> get_all();
	
	/**
	 * M�thode de recherche de tous les objects de la bdd
	 * 
	 * @param id
	 * @return T
	 */
	public abstract void reset_courant();
}
