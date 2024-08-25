/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package app.dao.interfaces;

import app.dto.GuestDto;
import app.dto.UserDto;

/**
 *
 * @author Camilo
 */
public interface GuestDao {
        public void createPartner(GuestDto guestDto) throws Exception;
    public void deletePartner(GuestDto guestDto) throws Exception;
 boolean existsByUser(UserDto userDto) throws Exception;
}
