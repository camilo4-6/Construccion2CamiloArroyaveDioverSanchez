/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controllers;

import app.Daoo.GuestDaoImplemetation;
import app.Daoo.PartnerDaoImplemetation;
import app.Daoo.PersonDaoImplementation;
import app.Daoo.UserDaoImplementation;
import app.controller.validator.GuestValidator;
import app.controller.validator.PartnerValidator;
import app.controller.validator.PersonValidator;
import app.controller.validator.UserValidator;
import app.dao.interfaces.GuestDao;
import app.dao.interfaces.PartnerDao;
import app.dao.interfaces.PersonDao;
import app.dao.interfaces.UserDao;
import app.dto.GuestDto;
import app.dto.PartnerDto;
import app.dto.PersonDto;
import app.dto.UserDto;
import app.model.Partner;
import app.service.interfac.PartnerService;
import app.service.x.Service;
import java.sql.SQLException;

/**
 *
 * @author Camilo
 */
public class PartnerController implements ControllerInterface {

    private PartnerValidator partnerValidator;
    private static final String MENU = "ingrese la opcion que desea ejecutar: \n 1. para crear invitado.  \n 2. para activar invitado. \n 3. para desactivar socio\n 4. para solicitar promocio \n 5. para solicitar baja  \n 6. para cerrar sesion \n ";
    private PersonValidator personValidator;
    private UserValidator userValidator;
    private PartnerService service;
    private PartnerDao partnerDao;
    private PersonDao personDao;
    private UserDao userDao;

    public PartnerController() {
        this.partnerValidator = new PartnerValidator();
        this.personValidator = new PersonValidator();
        this.userValidator = new UserValidator();
        this.service = new Service();
        this.partnerDao = new PartnerDaoImplemetation();
        this.personDao = new PersonDaoImplementation();
        this.userDao = new UserDaoImplementation();
    }

    @Override
    public void session() throws Exception {
        boolean session = true;
        while (session) {
            session = partnerSession();
        }

    }

    private boolean partnerSession() {
        try {
            System.out.println("bienvenido " + Service.user.getUserName());
            System.out.print(MENU);
            String option = Utils.getReader().nextLine();
            return options(option);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    private boolean options(String option) throws Exception {
        switch (option) {
            case "1": {
                this.createGuest();
                return true;
            }
            case "2": {
                System.out.println("");;
                return true;
            }
            case "5": {

                this.deletePartner();
                return false;
            }
            case "6": {
                System.out.println("se ha cerrado sesion");
                return false;
            }
            default: {
                System.out.println("ingrese una opcion valida");
                return true;
            }
        }
    }

    public void createGuest() throws Exception {
        System.out.println("Ingrese el nombre del invitado");
        String name = Utils.getReader().nextLine();
        personValidator.validName(name);
        System.out.println("ingrese la cedula");
        long document = personValidator.validDocument(Utils.getReader().nextLine());
        System.out.println("ingrese el numero de celular");
        long celPhone = personValidator.validPhone(Utils.getReader().nextLine());
        System.out.println("ingrese el usuario del invitado");
        String userName = Utils.getReader().nextLine();
        userValidator.validUserName(userName);
        System.out.println("ingrese la contraseña del invitado ");
        String password = Utils.getReader().nextLine();
        userValidator.validPassword(password);
        PersonDto personDto = new PersonDto();
        personDto.setName(name);
        personDto.setDocument(document);
        personDto.setCelPhone(celPhone);
        UserDto userDto = new UserDto();
        userDto.setPersonId(personDto);
        userDto.setUserName(userName);
        userDto.setPassword(password);
        userDto.setRole("guest");
        GuestDto guestDto = new GuestDto();
        guestDto.setUserId(userDto);
        guestDto.setStatus("activo");
        System.out.println("se ha creado el usuario exitosamente ");
        this.service.createGuest(guestDto);
    }

    public void deletePartner() throws Exception {
        this.service.deletePartner();

    }

    public void statusGuest() throws Exception {

        System.out.println("ingrese 1. si desea activar el invitado // Ingrese 2.si desea desactivar el invitado");
    }
}
