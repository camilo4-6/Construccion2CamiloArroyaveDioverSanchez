/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package app.dao.interfaces;

import app.dto.GuestDto;

/**
 *
 * @author Camilo
 */
public interface GuestDao {

    public void createGuest(GuestDto guestDto) throws Exception;

}
