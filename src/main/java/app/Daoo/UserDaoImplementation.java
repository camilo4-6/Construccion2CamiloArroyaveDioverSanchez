/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.Daoo;

import app.dao.interfaces.UserDao;
import app.dto.UserDto;

/**
 *
 * @author Camilo
 */
public class UserDaoImplementation implements UserDao{

    @Override
    public UserDto findByUserName(UserDto userDto) throws Exception {
           UserDto validateDto= new UserDto();
           if(userDto.getUserName().equals("admin")){
               validateDto.setUserName(userDto.getUserName());
               validateDto.setRol(userDto.getUserName());
               validateDto.setPassword("admin");
               return validateDto;
               
           }
           if (userDto.getUserName().equals(userDto.getPassword())){
               validateDto.setUserName(userDto.getUserName());
			validateDto.setRol(userDto.getUserName());
			validateDto.setPassword(userDto.getUserName());
			return validateDto;
		}
		return null;
           }
    

    @Override
    public boolean existsByUserName(UserDto userDto) throws Exception {
        return userDto.getUserName().equals("rogelio"); 
    }

    @Override
    public void createUser(UserDto userDto) throws Exception {
        System.out.println("se ha registrado el ususario"); 
    }
    
}
