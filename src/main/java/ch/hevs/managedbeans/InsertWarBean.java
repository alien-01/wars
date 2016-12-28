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
import ch.hevs.service.HandlerBean;
import ch.hevs.service.HandlerInterface;
import javassist.expr.Instanceof;

/***
 * This bean will be used to manage the insertions of wars.
 * @author gueny_000
 */

public class InsertWarBean {
	
	//For display
	private List <Weapon> weapons;
	private List <Explosive> explosives;
	private List <ColdArm> coldArms;
	private List <FireArm> fireArms;
	
	private List <Country> countries;
	private List <String> countriesNames;
	
	//For insertion
	private String warName;
	private Date startDate;
	private Date endDate;
	private Explosive explosiveToInsert;
	private ColdArm coldArmToInsert;
	private FireArm fireArmToInsert;
	private List <Explosive> selectedExplosives;
	
	
	//Feedback
	private String insertionMessage;
	
	//Service layer
	private HandlerInterface handler;
	
	//For inserting new weapons
	
	
	
	@PostConstruct
    public void initialize() throws NamingException {
		
    	// use JNDI to inject reference to bank EJB
    	InitialContext ctx = new InitialContext();
		handler = (HandlerInterface) ctx.lookup("java:global/PROJECT_WARS-0.0.1-SNAPSHOT/HandlerBean!ch.hevs.service.HandlerInterface");
    	
		//init to avoid null pointers
		explosives = new ArrayList<Explosive>();
		coldArms = new ArrayList <ColdArm>();
		fireArms = new ArrayList <FireArm>();
		explosiveToInsert = new Explosive();
		coldArmToInsert = new ColdArm();
		fireArmToInsert = new FireArm();
		selectedExplosives = new ArrayList<Explosive>();
		
		// get weapons
		weapons = handler.getWeapons();
		
		for(Weapon w : weapons)
		{			
			System.out.println(w.toString());
			if (w  instanceof Explosive) {
				System.out.println(w.toString());
				explosives.add((Explosive)w);
				continue;
			};
			
			if(w instanceof FireArm)
			{
				System.out.println("Instance of firearm found.");
				fireArms.add((FireArm)w);
				continue;
			};
			
			if(w instanceof ColdArm)
			{
				System.out.println("Instance of cold arm found.");
				coldArms.add((ColdArm)w);
				continue;
			}
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
	
	public boolean insertExplosive()
	{
		//TODO : Check the entries for the explosive.
		
		if(handler.insertExplosive(this.explosiveToInsert))
		{
	
			System.out.println("Explosive successfuly inserted");
			//Add the inserted explosive to the list of explosives.
			explosives.add(explosiveToInsert);
			return true;
		}
		System.out.println("Failed to insert explosive.");
		return false;
	}
	
	public boolean insertColdArm()
	{
		//TODO : Check the entires for cold arm.
		
		if(handler.insertColdArm(this.coldArmToInsert))
		{
			System.out.println("Cold arm successfuly inserted.");
			return true;
		}
		return false;
	}
	
	public boolean insertFireArm()
	{
		//TODO : Check the entires for fire arm
		
		if(handler.insertFireArm(this.fireArmToInsert))
		{
			System.out.println("Fire arm successfuly inserted.");
			return true;
		}
		return false;
	}
	
	
	public List<Weapon> getWeapons() {
		return weapons;
	}
	public void setWeapons(List<Weapon> weapons) {
		this.weapons = weapons;
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
	public void setWarName(final String warName) {
		this.warName = warName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(final Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(final Date endDate) {
		this.endDate = endDate;
	}
	public String getInsertionMessage() {
		return insertionMessage;
	}
	public void setInsertionMessage(String insertionMessage) {
		this.insertionMessage = insertionMessage;
	}

	public List<Explosive> getExplosives() {
		return explosives;
	}

	public void setExplosives(List<Explosive> explosives) {
		this.explosives = explosives;
	}

	public List<ColdArm> getColdArms() {
		return coldArms;
	}

	public void setColdArms(List<ColdArm> coldArms) {
		this.coldArms = coldArms;
	}

	public List<FireArm> getFireArms() {
		return fireArms;
	}

	public void setFireArms(List<FireArm> fireArms) {
		this.fireArms = fireArms;
	}

	public Explosive getExplosiveToInsert() {
		return explosiveToInsert;
	}

	public void setExplosiveToInsert(Explosive explosiveToInsert) {
		this.explosiveToInsert = explosiveToInsert;
	}

	public ColdArm getColdArmToInsert() {
		return coldArmToInsert;
	}

	public void setColdArmToInsert(ColdArm coldArmToInsert) {
		this.coldArmToInsert = coldArmToInsert;
	}

	public FireArm getFireArmToInsert() {
		return fireArmToInsert;
	}

	public void setFireArmToInsert(FireArm fireArmToInsert) {
		this.fireArmToInsert = fireArmToInsert;
	}

	public List<Explosive> getSelectedExplosives() {
		return selectedExplosives;
	}

	public void setSelectedExplosives(List<Explosive> selectedExplosives) {
		this.selectedExplosives = selectedExplosives;
	}
	
	
}
