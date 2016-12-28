/**

Author : Evgueni CHAKHTARINE
14 déc. 2016

Description :

*/

package ch.hevs.businessobject;
import java.util.*;
import javax.persistence.*;

import org.hibernate.annotations.Cascade;

@Entity
public class Country {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String name;
	private int area;
	private String capital;
	private int year_foundation;
	@ManyToMany
	private Collection <War> wars;

	@OneToMany(mappedBy="country", cascade = CascadeType.ALL)
	private Collection <Weapon> weapons;
	
	//Constructor
	
	public Country(){};
	
	public Country(String name, int superficie, String capitale, int year_foundation)
	{
		this.name = name;
		this.area = superficie;
		this.capital = capitale;
		this.year_foundation = year_foundation;
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
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capitale) {
		this.capital = capitale;
	}
	public int getYear_foundation() {
		return year_foundation;
	}
	public void setYear_foundation(int year_foundation) {
		this.year_foundation = year_foundation;
	}
	
	public Collection<War> getWars() {
		return wars;
	}

	public void setWars(Collection<War> wars) {
		this.wars = wars;
	}

	public Collection<Weapon> getWeapons() {
		return weapons;
	}

	public void setWeapons(Collection<Weapon> weapons) {
		this.weapons = weapons;
	}
	
	//Helpers
	
	public boolean addWar(War war)
	{
		return this.wars.add(war);
	}
	
	public boolean removeWar(War war)
	{
		return this.wars.remove(war);
	}
	
	@PostPersist
	public void acknowledgePersist() {
		System.out.println("country persisted!!!");
	}
	
}
