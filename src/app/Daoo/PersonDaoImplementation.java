/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.Daoo;

import app.dao.interfaces.PersonDao;
import app.dto.PersonDto;

/**
 *
 * @author Camilo
 */
public class PersonDaoImplementation implements PersonDao{

    @Override
    public boolean existByDocument(PersonDto personDto) throws Exception {
        return personDto.getCedula()==123456789;
    }

    @Override
    public void createPerson(PersonDto personDto) throws Exception {
        System.out.println("se ha creado la persona"); 
    }
    
}
