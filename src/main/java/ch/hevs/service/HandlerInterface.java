/**

Author : Evgueni CHAKHTARINE
27 déc. 2016

Description :

*/

package ch.hevs.service;

import java.util.List;

import ch.hevs.businessobject.*;
public interface HandlerInterface {
	
	/***
	 * Returns a list of wars.
	 * @return
	 */
	List <War> getWars();
	
	/***
	 * Returns a list of all existing countries.
	 * @return
	 */
	List <Country> getCountries();
	
	/***
	 * Returns a list of existing weapons.
	 * @return
	 */
	List <Weapon> getWeapons();
	
	/***
	 * Returns a war by ID.
	 * @param warID
	 * @return
	 */
	War getWar(int warID);
	
	/***
	 * Creates a new war.
	 * @param war
	 * @param countries
	 * @param weapons
	 * @return
	 */
	boolean insertWar(War war, List <Country> countries, List <Weapon> weapons);
	
	/***
	 * Deletes a war.
	 * @param warID
	 * @return
	 */
	boolean deleteWar(int warID);
	
	/***
	 * Upadates a war.
	 * @param warID : id of the war to update.
	 * @param newWar : updated war.
	 * @return
	 */
	boolean updateWar(int warID, War newWar);

}
