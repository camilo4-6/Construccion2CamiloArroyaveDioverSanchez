/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dto;

/**
 *
 * @author Camilo
 */
public class PersonDto {

    private long id;
    private long cedula;
    private String name;
    private long celPhone;

    public PersonDto() {
    }

    public long getId() {
        return id;
    }

  

    public void setId(long id) {
        this.id = id;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCelPhone() {
        return celPhone;
    }

    public void setCelPhone(long celPhone) {
        this.celPhone = celPhone;
    }

}
