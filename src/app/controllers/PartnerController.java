/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controllers;

import app.controller.validator.GuestValidator;

/**
 *
 * @author Camilo
 */
public class PartnerController implements ControllerInterface{

    private GuestValidator guestValidator;
    private static final String MENU = "ingrese la opcion que desea ejecutar: \n 1. para crear invitado. \n 2. para agregar fondos. \n 3.para ver historial de facturas . \n 4. para cerrar sesion.";
    
    public PartnerController() {
            this.guestValidator=new GuestValidator();
    }

    @Override
    public void session() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
