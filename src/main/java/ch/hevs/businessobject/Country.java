/**

Author : Evgueni CHAKHTARINE
14 déc. 2016

Description :

*/

package ch.hevs.businessobject;

public class Country {
	
	private int id;
	private String name;
	private int superficie;
	private String capitale;
	private int year_foundation;
	
	//Constructor
	
	public Country(String name, int superficie, String capitale, int year_foundation)
	{
		this.name = name;
		this.superficie = superficie;
		this.capitale = capitale;
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
	public int getSuperficie() {
		return superficie;
	}
	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}
	public String getCapitale() {
		return capitale;
	}
	public void setCapitale(String capitale) {
		this.capitale = capitale;
	}
	public int getYear_foundation() {
		return year_foundation;
	}
	public void setYear_foundation(int year_foundation) {
		this.year_foundation = year_foundation;
	}
}
