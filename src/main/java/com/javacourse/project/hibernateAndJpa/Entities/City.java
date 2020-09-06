package com.javacourse.project.hibernateAndJpa.Entities;
import javax.persistence.*;

@Entity// bunun bir veritabani nesnesi olduğunu anlatan notasyon
@Table(name="city")
public class City {
	@Id // private key for table
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)// Hibernate relies on an auto-incremented database column to generate the primary key
	// database'e city eklendiginde idsi otomatik olarak artirilarak eklenecek
	//If we don't specify a value explicitly, the generation type defaults to AUTO.
	//One thing to note is that IDENTITY generation disables batch updates.
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="countrycode")
	private String countryCode;
	@Column(name="district")
	private String district;
	@Column(name="population")
	private int population;
	
	
	public City() {}
	public City(int id, String name, String countryCode, String district, int population) {
		super();
		this.id = id;
		this.name = name;
		this.countryCode = countryCode;
		this.district = district;
		this.population = population;
	}
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
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	
}
