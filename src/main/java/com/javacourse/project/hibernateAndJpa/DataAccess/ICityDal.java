package com.javacourse.project.hibernateAndJpa.DataAccess;
import java.util.List;
import com.javacourse.project.hibernateAndJpa.Entities.City;

public interface ICityDal {
	// City başka bir pakette oldugu icin goremedi
	List<City> getAll();// butun sehirleri listeleyecek bir fonksiyon
	void add(City city);
	void update(City city);
	void delete(City city);
	City getById(int id);
}
