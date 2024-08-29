/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controller.validator;

/**
 *
 * @author Camilo
 */
public class PartnerValidator extends CommonsValidator {

    public PartnerValidator() {
        super();
    }

    public double validMoney(String money) throws Exception {
        return super.isValidDouble("El valor ingresado", money);
    }

}
