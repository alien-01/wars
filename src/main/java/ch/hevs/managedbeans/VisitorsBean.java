/**

Author : Evgueni CHAKHTARINE
28 déc. 2016

Description :

*/

package ch.hevs.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ch.hevs.businessobject.Country;
import ch.hevs.businessobject.War;
import ch.hevs.businessobject.Weapon;
import ch.hevs.service.HandlerInterface;

public class VisitorsBean {
	
	private int warID;
	private List <War> wars;
	private War war;
	private HandlerInterface handler;
	
	@PostConstruct
    public void initialize() throws NamingException {
    	
    	// use JNDI to inject reference to bank EJB
    	InitialContext ctx = new InitialContext();
		handler = (HandlerInterface) ctx.lookup("java:global/PROJECT_WARS-0.0.1-SNAPSHOT/HandlerBean!ch.hevs.service.HandlerInterface");
    	// get weapons
		this.wars = handler.getWars();
		System.out.println("There are "+wars.size()+" wars in the db."+wars.toString());
    }
	
	public boolean getWarFromDB()
	{
		try{
			this.war = handler.getWar(warID);
			return true;
		}catch(Exception e)
		{
			System.out.println("Error while getting a war by id : "+e.getMessage());
			return false;
		}
	}

	public List<War> getWars() {
		return wars;
	}

	public void setWars(List<War> wars) {
		this.wars = wars;
	}

	public War getWar() {
		return war;
	}

	public void setWar(War war) {
		this.war = war;
	}

	public int getWarID() {
		return warID;
	}

	public void setWarID(int warID) {
		this.warID = warID;
	}
}
