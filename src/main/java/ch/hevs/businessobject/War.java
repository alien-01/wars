/**

Author : Evgueni CHAKHTARINE
14 déc. 2016

Description :

*/

package ch.hevs.businessobject;

import java.sql.Date;
import java.util.Collection;

public class War {
	
	private int id;
	private String name;
	private Date start;
	private Date end;
	private Collection <Country> countries;
	private Collection <Weapon> weapons;
	
	//Constructor
	
	public War(String name, Date start, Date end)
	{
		this.name = name;
		this.start = start;
		this.end = end;
		countries = new Collection <Country>();
		weapons = new Collection <Weapon>();
	}
	
	//Getters and setters
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public Collection<Country> getCountries() {
		return countries;
	}
	public void setCountries(Collection<Country> countries) {
		this.countries = countries;
	}
	public Collection<Weapon> getWeapons() {
		return weapons;
	}
	public void setWeapons(Collection<Weapon> weapons) {
		this.weapons = weapons;
	}
	
	//Helpers
	
	public boolean addCountry(Country country)
	{
		return this.countries.add(country);
	}
	
	public boolean removeCountry(Country country)
	{
		return this.countries.remove(country);
	}
	
	public boolean addWeapon(Weapon weapon)
	{
		return this.weapons.add(weapon);
	}
	
	public boolean removeWeapon(Weapon weapon)
	{
		return this.weapons.remove(weapon);
	}
}
