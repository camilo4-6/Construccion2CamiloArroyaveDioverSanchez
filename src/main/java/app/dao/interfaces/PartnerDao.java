/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package app.dao.interfaces;

import app.dto.PartnerDto;
import app.dto.PersonDto;
import app.dto.UserDto;

/**
 *
 * @author Camilo
 */
public interface PartnerDao {
    public void createPartner(PartnerDto partnerDto) throws Exception;
    public void deletePartner(PartnerDto partnerDto) throws Exception;
public PartnerDto existByPartner(PartnerDto partnerDto) throws Exception;
}
