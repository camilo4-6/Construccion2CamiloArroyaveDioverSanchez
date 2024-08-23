/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controllers;

import app.controller.validator.GuestValidator;
import app.controller.validator.PersonValidator;
import app.controller.validator.UserValidator;
import app.dto.PersonDto;
import app.dto.UserDto;
import app.service.x.Service;

/**
 *
 * @author Camilo
 */
public class PartnerController implements ControllerInterface {

    private GuestValidator guestValidator;
    private static final String MENU = "ingrese la opcion que desea ejecutar: \n 1. para crear invitado. \n 2. para agregar fondos. \n 3.para ver historial de facturas . \n 4. para cerrar sesion.";
    private PersonValidator personValidator;
    private UserValidator userValidator;

    public PartnerController() {
        this.guestValidator = new GuestValidator();
        this.personValidator = new PersonValidator();
        this.userValidator = new UserValidator();
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
                this.ADDFOUNDS();
                return true;
            }
            case "3": {
                System.out.println("se ha cerrado sesion");
                return false;
            }
            case "4": {
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
        long celPhone = personValidator.validAge(Utils.getReader().nextLine());
        System.out.println("ingrese el usuario del invitado");
        String userName = Utils.getReader().nextLine();
        userValidator.validUserName(userName);
        System.out.println("ingrese la contraseña del invitado ");
        String password = Utils.getReader().nextLine();
        userValidator.validUserName(password);
        PersonDto personDto = new PersonDto();
        personDto.setName(name);
        personDto.setDocument(document);
        personDto.setCelPhone(celPhone);
        UserDto userDto = new UserDto();
        userDto.setPersonId(personDto);
        userDto.setUserName(userName);
        userDto.setPassword(password);
        userDto.setRole("Guest");
        System.out.println("se ha creado el usuario exitosamente ");
    }

    private void ADDFOUNDS() {
        System.out.println("Cuanto quiere ingresar?");
        
        
           }
}
