/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controller.validator;

/**
 *
 * @author Camilo
 */
public class InvoiceDetailValidator extends CommonsValidator {

    public InvoiceDetailValidator() {
        super();

    }

    public void validItems(String items) throws Exception {
        super.isValidString("items de la factura", items);
    }
}
