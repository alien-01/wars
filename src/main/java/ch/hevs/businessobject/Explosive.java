package ch.hevs.businessobject;

import javax.persistence.*;

@Entity
public class Explosive extends Weapon {

	@Column(name="tnt_equivalent")
	private int tntEquivalent;
	
	public Explosive(){
		super();
	}
	
	public Explosive(String name, int year, int weight, int scope, int tntEquivalent){
		super(name, year, weight, scope);
		this.tntEquivalent=tntEquivalent;
	}

	public int getTntEquivalent() {
		return tntEquivalent;
	}

	public void setTntEquivalent(int tntEquivalent) {
		this.tntEquivalent = tntEquivalent;
	}
	
}
