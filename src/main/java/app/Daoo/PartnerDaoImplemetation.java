/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.Daoo;

import app.config.MYSQLConnection;
import app.dao.interfaces.PartnerDao;
import app.dto.PartnerDto;

import app.dto.UserDto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Camilo
 */
public class PartnerDaoImplemetation implements PartnerDao{

   

    @Override
    public void createPartner(PartnerDto partnerDto) throws Exception {
         String query = "INSERT INTO PARTNER(ID,USERID,AMOUNT,TYPE,CREACIONDATE) VALUES (?, ?,?,?,?)" ;
        PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
        preparedStatement.setLong(1, partnerDto.getId());
        preparedStatement.setLong(2, partnerDto.getUser().getId());
        preparedStatement.setDouble(3, partnerDto.getMoney());
        preparedStatement.setString(4, partnerDto.getType());
        preparedStatement.setTimestamp(5, partnerDto.getDateCreated());
        preparedStatement.execute();
        preparedStatement.close();
    }

    @Override
    public void deletePartner(PartnerDto partnerDto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean existsByUser(UserDto userDto) throws Exception {
       String query = "SELECT 1 FROM USER WHERE USERNAME = ?";
		PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
		preparedStatement.setString(1, userDto.getUserName());
		ResultSet resulSet = preparedStatement.executeQuery();
		boolean exists = resulSet.next();
		resulSet.close();
		preparedStatement.close();
		return exists;
		}

    }


  
