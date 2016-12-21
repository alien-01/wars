package ch.hevs.businessobject;

import javax.persistence.Entity;

@Entity
public class FireArm extends Weapon {

	private int cadence;
	private int capacity;
	
	public FireArm(){
		super();
	}
	
	public FireArm(String name, int year, int weight, int scope, int cadence, int capacity){
		super(name, year, weight, scope);
		this.cadence=cadence;
		this.capacity=capacity;
	}

	public int getCadence() {
		return cadence;
	}

	public void setCadence(int cadence) {
		this.cadence = cadence;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	
	
	
}
