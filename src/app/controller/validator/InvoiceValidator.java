/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controller.validator;

/**
 *
 * @author Camilo
 */
public class InvoiceValidator extends CommonsValidator {

    public InvoiceValidator() {
        super();
    }

    public double validAmount(String amount) throws Exception {
        return super.isValidDouble("el monto de la factura ", amount);
    }
}
