/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.Daoo;

import app.config.MYSQLConnection;
import app.dao.interfaces.PartnerDao;
import app.dto.PartnerDto;

import app.dto.UserDto;
import app.helpers.Helper;
import app.model.Partner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Camilo
 */
public class PartnerDaoImplemetation implements PartnerDao {

    @Override
    public void createPartner(PartnerDto partnerDto) throws Exception {
        Partner partner = Helper.parse(partnerDto);
        String query = "INSERT INTO PARTNER(USERID,AMOUNT,TYPE,CREATIONDATE) VALUES (?, ?,?,?)";
        PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
        preparedStatement.setLong(1, partner.getUserId().getId());
        preparedStatement.setDouble(2, partner.getMoney());
        preparedStatement.setString(3, partner.getType());
        preparedStatement.setTimestamp(4, partner.getDateCreated());
        preparedStatement.execute();
        preparedStatement.close();
    }

    @Override
    public void deletePartner(PartnerDto partnerDto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean existsByUser(UserDto userDto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
