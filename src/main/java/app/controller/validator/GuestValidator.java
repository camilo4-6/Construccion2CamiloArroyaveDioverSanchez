/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controller.validator;

/**
 *
 * @author Camilo
 */
public class GuestValidator  extends CommonsValidator{

    public GuestValidator() {
        super();
    }
    public void validUserName(String userName)throws Exception {
       super.isValidString("El nombre de usuario ",userName);
    }
}
