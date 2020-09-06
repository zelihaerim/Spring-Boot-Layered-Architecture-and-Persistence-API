package com.javacourse.project.hibernateAndJpa.restApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javacourse.project.hibernateAndJpa.Business.ICityService;
import com.javacourse.project.hibernateAndJpa.Entities.City;

@RestController
@RequestMapping("/api")
public class CityController {
	private ICityService cityService;
	
	@Autowired
	public CityController(ICityService cityService) {
		this.cityService=cityService;
	}
	// GetMapping db dn veri cekmek icin kullanilir
	@GetMapping("/cities") // localhost/cities dediğimde bu fonksiyonun outputu ekrana gelsin
	public List<City> get(){
		return cityService.getAll();
	}
	@PostMapping("/add")// db deki degisiklik yapilacaksa post metodu kullanilir
	public void add(@RequestBody City city) {//yapilan istegin body'sinden alacagiz
		cityService.add(city);
	}
	@PostMapping("/update")
	public void update(@RequestBody City city) {
		cityService.update(city);
	}
	@PostMapping("/delete")
	public void delete(@RequestBody City city) {
		cityService.delete(city);
	}
	@GetMapping("/cities/{id}") // localhost/cities dediğimde bu fonksiyonun outputu ekrana gelsin
	public City getById(@PathVariable int id){//parametre olan id'ye ,pathteki {id} degerini alir e set eder
		return cityService.getById(id);
	}
	
	
	
	
}
