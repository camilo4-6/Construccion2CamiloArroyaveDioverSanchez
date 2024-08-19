/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controllers;

import app.controller.validator.UserValidator;
import app.service.interfac.LoginService;
import app.service.x.Service;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Camilo
 */
public class LoginController implements ControllerInterface{
    private UserValidator userValidator;
	private LoginService service;
	private static final String MENU= "ingrese la opcion que desea: \n 1. para iniciar sesion. \n 2. para detener la ejecucion.";
	private Map<String,ControllerInterface> roles;

    public LoginController() {
        this.userValidator= new UserValidator();
		this.service=new Service();
                ControllerInterface adminController = new AdminController();
		ControllerInterface partnerController = new PartnerController();
		ControllerInterface guestController = new GuestController();
                this.roles= new HashMap<String,ControllerInterface>();
		roles.put("admin", adminController);
		roles.put("veterinarian", partnerController);
		roles.put("seller", guestController);
    }

    @Override
    public void session() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
        
}
