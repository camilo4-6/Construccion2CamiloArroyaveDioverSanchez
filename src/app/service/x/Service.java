
package app.service.x;

import app.dao.interfaces.PersonDao;
import app.dao.interfaces.UserDao;
import app.dto.GuestDto;
import app.dto.UserDto;
import app.service.interfac.AdminService;
import app.service.interfac.LoginService;
import app.service.interfac.PartnerService;


public class Service implements AdminService,LoginService,PartnerService{
        private UserDao userDao;
	private PersonDao personDao;
        public static UserDto user;
    @Override
    public void createPartner(UserDto userDto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void createVoice(UserDto userDto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void login(UserDto userDto) throws Exception {
        UserDto validateDto = userDao.findByUserName(userDto);
		if (validateDto == null) {
			throw new Exception("no existe usuario registrado");
		}
		if (!userDto.getPassword().equals(validateDto.getPassword())) {
			throw new Exception("usuario o contraseña incorrecto");
		}
		userDto.setRol(validateDto.getRol());
		user = validateDto;
      
    }

    @Override
    public void logout() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void createGuest(GuestDto guestDto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
