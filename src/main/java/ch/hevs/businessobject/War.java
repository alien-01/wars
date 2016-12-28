/**

Author : Evgueni CHAKHTARINE
14 déc. 2016

Description :

*/

package ch.hevs.businessobject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

@Entity
public class War {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String name;
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Temporal(TemporalType.DATE)
	private Date endDate;
	@ManyToMany(mappedBy="wars")
	private Collection <Country> countries;
	@OneToMany
	private Collection <Weapon> weapons;
	
	//Constructor
	
	public  War() {} ;
	
	public War(String name, Date start, Date end)
	{
		this.name = name;
		this.startDate = start;
		this.endDate = end;
		countries = new ArrayList <Country>();
		weapons = new ArrayList <Weapon>();
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
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date start) {
		this.startDate = start;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date end) {
		this.endDate = end;
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
	
	@PostPersist
	public void acknowledgePersist() {
		System.out.println("war persisted!!!");
	}
}
