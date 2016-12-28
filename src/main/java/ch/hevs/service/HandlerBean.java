/**

Author : Evgueni CHAKHTARINE
21 déc. 2016

Description :

*/

package ch.hevs.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ch.hevs.businessobject.ColdArm;
import ch.hevs.businessobject.Country;
import ch.hevs.businessobject.Explosive;
import ch.hevs.businessobject.FireArm;
import ch.hevs.businessobject.War;
import ch.hevs.businessobject.Weapon;

@Stateless
public class HandlerBean implements HandlerInterface {

	@PersistenceContext(name = "warsPU")
	private EntityManager em;

	@Override
	public List<War> getWars() {
		Query query = em.createQuery("SELECT w FROM War w");
		return query.getResultList();
	}

	@Override
	public List<Country> getCountries() {
		Query query = em.createQuery("SELECT c FROM Country c");
		return query.getResultList();
	}

	@Override
	public List<Weapon> getWeapons() {
		Query query = em.createQuery("SELECT w FROM Weapon w");
		System.out.println("Returning "+query.getResultList().size()+" weapons.");
		return query.getResultList();
	}

	@Override
	public War getWar(int warID) {
		War temp = em.find(War.class, warID);
		// Query query = em.createQuery("SELECT w FROM War w WHERE w.id = :id");
		// query.setParameter("id", warID);
		// return (War) query.getSingleResult();
		return temp;
	}

	@Override
	public boolean insertWar(War war, List<Country> countries, List<Weapon> weapons) {
		try {
			em.persist(war);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteWar(int warID) {

		return false;
	}

	@Override
	public boolean updateWar(int warID, War newWar) {

		return false;
	}

	@Override
	public boolean insertExplosive(Explosive explosive) {
		try {
			em.persist(explosive);
			return true;
		} catch (Exception e) {
			System.out.println(this.getClass()+" failed to insert explosive. "+e.getMessage());
			return false;
		}
	}

	@Override
	public boolean insertColdArm(ColdArm coldArm) {
		try {
			em.persist(coldArm);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean insertFireArm(FireArm fireArm) {
		try {
			em.persist(fireArm);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
