package dao;

import accessBDD.BDD;
import model.MODEL;
/*class bstraite qui défini les fonctions de création, de suppression
 * de modification et de recherche
 */

public abstract class DAO<T> {
	protected BDD _connection;

	public DAO(BDD connection) {
		_connection = connection;
	}

	/**
	 * Méthode de création
	 * 
	 * @param m
	 * @return boolean
	 */
	public abstract boolean create(MODEL<?> m);

	/**
	 * Méthode pour effacer
	 * 
	 * @param obj
	 * @return boolean
	 */
	public abstract boolean delete(T obj);

	/**
	 * Méthode de mise à jour
	 * 
	 * @param obj
	 * @return boolean
	 */
	public abstract boolean update(T obj);

	/**
	 * Méthode de recherche des informations
	 * 
	 * @param id
	 * @return T
	 */
	public abstract T find(int id);
}
