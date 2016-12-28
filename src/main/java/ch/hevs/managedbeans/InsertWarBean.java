/**

Author : Evgueni CHAKHTARINE
27 déc. 2016

Description :

*/

package ch.hevs.managedbeans;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ch.hevs.businessobject.*;
import ch.hevs.service.Handler;

/***
 * This bean will be used to manage the insertions of wars.
 * @author gueny_000
 */

public class InsertWarBean {
	
	private List <Weapon> weapons;
	private List <String> weaponsNames;
	private List <Country> countries;
	private List <String> countriesNames;
	private String warName;
	private Date startDate;
	private Date endDate;
	private String insertionMessage;
	private Handler handler;
	
	@PostConstruct
    public void initialize() throws NamingException {
    	
    	// use JNDI to inject reference to bank EJB
    	InitialContext ctx = new InitialContext();
		handler = (Handler) ctx.lookup("java:global/PROJECT_WARS-0.0.1-SNAPSHOT/Handler!ch.hevs.service.Handler");    	
			
    	// get weapons
		weapons = handler.getWeapons();
		
		//get weapons names
		weaponsNames = new ArrayList <String>();
		for(Weapon w : weapons)
		{
			weaponsNames.add(w.getName());
		}
		
		//get countries
		countries = new ArrayList <Country>();
		for(Country c : countries)
		{
			countriesNames.add(c.getName());
		}
    }
	
	public void insertWar()
	{
		System.out.println("Name is : "+this.warName);
		System.out.println("Date start is : "+this.startDate.toString());
		System.out.println("Date end is : "+this.endDate.toString());
		
		//TODO : Filter the values to insert.
		
		War w = new War(this.warName, this.startDate, this.endDate);
		if(handler.insertWar(w, null, null))
		{
			System.out.println("War successfuly inserted.");
		}else{
			System.out.println("Error while inserting the war.");
		}
	}
	
	
	public List<Weapon> getWeapons() {
		return weapons;
	}
	public void setWeapons(List<Weapon> weapons) {
		this.weapons = weapons;
	}
	public List<String> getWeaponsNames() {
		return weaponsNames;
	}
	public void setWeaponsNames(List<String> weaponsNames) {
		this.weaponsNames = weaponsNames;
	}
	public List<Country> getCountries() {
		return countries;
	}
	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}
	public List<String> getCountriesNames() {
		return countriesNames;
	}
	public void setCountriesNames(List<String> countriesNames) {
		this.countriesNames = countriesNames;
	}
	public String getWarName() {
		return warName;
	}
	public void setWarName(String warName) {
		this.warName = warName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getInsertionMessage() {
		return insertionMessage;
	}
	public void setInsertionMessage(String insertionMessage) {
		this.insertionMessage = insertionMessage;
	}
}
