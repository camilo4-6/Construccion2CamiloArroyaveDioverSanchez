/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controllers;

import app.controller.validator.PersonValidator;
import app.controller.validator.UserValidator;
import app.dto.PersonDto;
import app.dto.UserDto;

/**
 *
 * @author Camilo
 */
public class AdminController implements ControllerInterface {

    private static final String MENU = "ingrese la opcion que desea ejecutar: \n 1. Para crear socio \n 2. Ver facturas  \n 3. para realizar consulta";
    private PersonValidator personValidator;
    private UserValidator userValidator;

    public AdminController() {
        this.personValidator = new PersonValidator();
        this.userValidator = new UserValidator();
        
    }

    @Override
    public void session() throws Exception {

    }

    public void createPartner() throws Exception {
        System.out.println("Ingrese el nombre del socio");
        String name = Utils.getReader().nextLine();
        personValidator.validName(name);
        System.out.println("ingrese la cedula");
        long cedula = personValidator.validDocument(Utils.getReader().nextLine());
        System.out.println("ingrese el numero de celular");
        long celPhone = personValidator.validAge(Utils.getReader().nextLine());
        System.out.println("ingrese el usuario del socio");
        String userName = Utils.getReader().nextLine();
        userValidator.validUserName(userName);
        System.out.println("ingrese la contraseña ");
        String password = Utils.getReader().nextLine();
        userValidator.validUserName(password);
        PersonDto personDto = new PersonDto();
        personDto.setName(name);
        personDto.setCedula(cedula);
        personDto.setCelPhone(celPhone);
        UserDto userDto = new UserDto();
        userDto.setPersonId(personDto);
        userDto.setUserName(userName);
        userDto.setPassword(password);
        userDto.setRol("Partner");
        System.out.println("se ha creado el usuario exitosamente ");
    }
}
