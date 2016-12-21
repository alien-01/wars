package ch.hevs.businessobject;

import javax.persistence.Entity;

@Entity
public class ColdArm extends Weapon {

	
	private double lenght;
	
	public ColdArm(){
		super();
	}
	
	public ColdArm(String name, int year, int weight, int scope, double lenght){
		super(name, year, weight, scope);
		this.lenght = lenght;
	}

	public double getLenght() {
		return lenght;
	}

	public void setLenght(double lenght) {
		this.lenght = lenght;
	}
	
	
}
