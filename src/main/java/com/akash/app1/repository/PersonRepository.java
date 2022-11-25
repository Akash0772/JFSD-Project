package com.akash.app1.repository;

import org.springframework.data.repository.CrudRepository;

import com.akash.app1.entity.Person;

public interface PersonRepository extends CrudRepository<Person, Integer>{
	public Person findByUsernameAndPassword(String username, String password);
	public Person findByUsername(String username);
}
