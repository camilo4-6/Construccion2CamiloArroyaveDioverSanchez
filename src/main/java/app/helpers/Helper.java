/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.helpers;

import app.dto.GuestDto;
import app.dto.PersonDto;
import app.dto.UserDto;
import app.model.Person;
import app.model.User;
import app.dto.PartnerDto;
import app.model.Guest;
import app.model.Partner;

/**
 *
 * @author Camilo
 */
public abstract class Helper {

    public static PersonDto parse(Person person) {

       if (person != null) {
        PersonDto personDto = new PersonDto();
        personDto.setId(person.getId());
        personDto.setDocument(person.getDocument());
        personDto.setName(person.getName());
        personDto.setCelPhone(person.getCelPhone());
        return personDto;
    } else {
        // Crear un PersonDto con valores predeterminados
        PersonDto personDto = new PersonDto();
        personDto.setId(14234); // Valor por defecto, o un ID que indique "no encontrado"
        personDto.setDocument(123); // Valor predeterminado para documento
        personDto.setName("Desconocido"); // Valor predeterminado para nombre
        personDto.setCelPhone(42343241); // Valor predeterminado para teléfono
        return personDto;
    }
    }

    public static Person parse(PersonDto personDto) {
        Person person = new Person();
        person.setId(personDto.getId());
        person.setDocument(personDto.getDocument());
        person.setName(personDto.getName());
        person.setCelPhone(personDto.getCelPhone());
        return person;
    }

    public static UserDto parse(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setPassword(user.getPassword());
        userDto.setPersonId(parse(user.getPersonId()));
        userDto.setRole(user.getRole());
        userDto.setUserName(user.getUserName());
        return userDto;
    }

    public static User parse(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setPassword(userDto.getPassword());
        user.setPersonId(parse(userDto.getPersonId()));
        user.setRole(userDto.getRole());
        user.setUserName(userDto.getUserName());
        return user;
    }

    public static Partner parse(PartnerDto partnerDto) {
        Partner partner = new Partner();
        partner.setId(partnerDto.getId());
        partner.setUserId(parse(partnerDto.getUserId()));
        partner.setMoney(partnerDto.getMoney());
        partner.setType(partnerDto.getType());
        partner.setDateCreated(partnerDto.getDateCreated());
        return partner;
    }

    public static PartnerDto parse(Partner partner) {
        PartnerDto partnerDto = new PartnerDto();
        partnerDto.setId(partner.getId());
        partnerDto.setUserId(parse(partner.getUserId()));
        partnerDto.setMoney(partner.getMoney());
        partnerDto.setDateCreated(partner.getDateCreated());

        return partnerDto;
    }

    public static Guest parse(GuestDto guestDto) {
        Guest guest = new Guest();
        guest.setId(guestDto.getId());
        guest.setUserId(parse(guestDto.getUserId()));
        guest.setPartnerId(parse(guestDto.getPartnerId()));
        guest.setStatus(guestDto.getStatus());

        return guest;
    }

    public static GuestDto parse(Guest guest) {
        GuestDto guestDto = new GuestDto();
        guestDto.setId(guest.getId());
        guestDto.setUserId(parse(guest.getUserId()));
        guestDto.setPartnerId(parse(guest.getPartnerId()));
        guestDto.setStatus(guest.getStatus());

        return guestDto;
    }
}
