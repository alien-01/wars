/**

Author : Evgueni CHAKHTARINE
21 déc. 2016

Description :

*/

package ch.hevs.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ch.hevs.businessobject.Country;
import ch.hevs.businessobject.War;
import ch.hevs.businessobject.Weapon;

public class Handler implements HandlerInterface {

	@PersistenceContext(name = "HandlerPU")
	private EntityManager em;
	
	
	@Override
	public List<War> getWars() {
		Query query = em.createQuery("SELECT * FROM Wars");
		return query.getResultList();
	}

	@Override
	public List<Country> getCountries() {
		Query query = em.createQuery("SELECT * FROM Country");
		return query.getResultList();
	}

	@Override
	public List<Weapon> getWeapons() {
		Query query = em.createQuery("SELECT * FROM Weapons");
		return query.getResultList();
	}

	@Override
	public War getWar(int warID) {
		Query query = em.createQuery("SELECT * FROM Wars WHERE id = :id");
		query.setParameter("id", warID);
		return (War) query.getSingleResult();
	}

	@Override
	public boolean insertWar(War war, List<Country> countries, List<Weapon> weapons) {
		return false;
		
	}

	@Override
	public boolean deleteWar(int warID) {
		
		return false;
	}

	@Override
	public boolean updateWar(int warID, War newWar) {
		
		return false;
	}
	
	

}
