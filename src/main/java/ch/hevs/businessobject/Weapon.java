package ch.hevs.businessobject;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Weapon {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String name;
	private int year_creation;
	private int weight;
	private int scope;
	@ManyToOne
	private Country country;
	public Weapon(){
		
	}
	
	public Weapon(String name, int year, int weight, int scope){
		this.name=name;
		this.year_creation = year;
		this.weight = weight;
		this.scope = scope;
		//this.country = country;
	}
	
	/*public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}*/
	
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
	public int getYear_creation() {
		return year_creation;
	}
	public void setYear_creation(int year_creation) {
		this.year_creation = year_creation;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getScope() {
		return scope;
	}
	public void setScope(int scope) {
		this.scope = scope;
	}
	
	
}
