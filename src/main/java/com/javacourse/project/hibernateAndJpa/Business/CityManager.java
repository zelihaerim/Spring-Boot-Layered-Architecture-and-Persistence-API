package com.javacourse.project.hibernateAndJpa.Business;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javacourse.project.hibernateAndJpa.DataAccess.ICityDal;
import com.javacourse.project.hibernateAndJpa.Entities.City;
@Service
public class CityManager implements ICityService {
	private ICityDal cityDal;// Data Access ile iletisim icin
	
	@Autowired
	// super classa ihtiyac yok dependency injection ile olusturacagiz
	public CityManager(ICityDal cityDal) {
		this.cityDal = cityDal;
	}
	//Transaction işlemi bir veya birden fazla sorguların(SQL) aynı süreçte işlem görmesidir.
	// @Transaction ile veritabani'na baglanmakta vs. herhangi bir sorun olursa islemin otomatik olarak
	// geri alinmasi icin koyulur.
	@Transactional 
	public List<City> getAll() {
		return this.cityDal.getAll();
	}
	
	@Transactional
	public void add(City city) {
		this.cityDal.add(city);
	}
	
	@Transactional
	public void update(City city) {
		this.cityDal.update(city);
		
	}
	
	@Transactional
	public void delete(City city) {
		this.cityDal.delete(city);
		
	}

	public City getById(int id) {	
		return this.cityDal.getById(id);
	}

}
