/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.helpers;

import app.dto.PersonDto;
import app.dto.UserDto;
import app.model.Person;
import app.model.User;

/**
 *
 * @author Camilo
 */
public abstract class Helper {
    public static PersonDto parse(Person person) {
		PersonDto personDto = new PersonDto();
		personDto.setId(person.getId());
		personDto.setCedula(person.getCedula());
		personDto.setName(person.getName());
		personDto.setCelPhone(person.getCelPhone());
		return personDto;
	}
	
	public static Person parse(PersonDto personDto) {
		Person person = new Person();
		person.setId(personDto.getId());
		person.setCedula(personDto.getCedula());
		person.setName(personDto.getName());
		person.setCelPhone(personDto.getCelPhone());
		return person;
	}
	
	public static UserDto parse(User user) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setPassword(user.getPassword());
		userDto.setPersonId(parse(user.getPersonId()));
		userDto.setRol(user.getRol());
		userDto.setUserName(user.getUserName());
		return userDto;
	}
	
	public static User parse(UserDto userDto) {
		User user = new User();
		user.setId(userDto.getId());
		user.setPassword(userDto.getPassword());
		user.setPersonId(parse(userDto.getPersonId()));
		user.setRol(userDto.getRol());
		user.setUserName(userDto.getUserName());
		return user;
	}
}
