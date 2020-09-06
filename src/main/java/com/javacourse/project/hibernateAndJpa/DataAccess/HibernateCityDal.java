package com.javacourse.project.hibernateAndJpa.DataAccess;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javacourse.project.hibernateAndJpa.Entities.City;
// JPA - ORM
@Repository
public class HibernateCityDal implements ICityDal{
	private EntityManager entityManager;
	
	
	@Autowired // constructor injection yapacagiz
	public HibernateCityDal(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	//AOP - Aspect Oriented Programming
	@Transactional
	public List<City> getAll() {	
		// Hibernate sessionu actim
		Session session = entityManager.unwrap(Session.class);
		List<City> cities=session.createQuery("from City",City.class).getResultList();
		return cities;
	}
	public void add(City city) {
		Session session=entityManager.unwrap(Session.class);
		session.saveOrUpdate(city);//hem update hem de ekleme icin kullanmistik
		// eger id si yoksa ekler, id si varsa update eder
		
	}
	public void update(City city) {
		Session session=entityManager.unwrap(Session.class);
		session.saveOrUpdate(city);//hem update hem de ekleme icin kullanmistik
		// eger id si yoksa ekler, id si varsa update eder
	}
	public void delete(City city) {
		Session session=entityManager.unwrap(Session.class);
		session.delete(city);
	}
	public City getById(int id) {
		Session session=entityManager.unwrap(Session.class);
		City city=session.get(City.class, id);
		return city;
	}
	// bu fonksiyonlarin test edilmesi Postman App sitesi ile yapilabilir.

}
