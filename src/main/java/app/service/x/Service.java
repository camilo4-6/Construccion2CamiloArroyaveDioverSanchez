package app.service.x;

import app.Daoo.GuestDaoImplemetation;
import app.Daoo.PartnerDaoImplemetation;
import app.Daoo.PersonDaoImplementation;
import app.Daoo.UserDaoImplementation;
import app.dao.interfaces.GuestDao;
import app.dao.interfaces.InvoiceDao;
import app.dao.interfaces.InvoiceDetailDao;
import app.dao.interfaces.PartnerDao;
import app.dao.interfaces.PersonDao;
import app.dao.interfaces.UserDao;
import app.dto.GuestDto;
import app.dto.InvoiceDto;
import app.dto.PartnerDto;
import app.dto.PersonDto;
import app.dto.UserDto;
import app.helpers.Helper;
import app.model.Partner;
import app.model.Person;
import app.service.interfac.AdminService;
import app.service.interfac.LoginService;
import app.service.interfac.PartnerService;
import java.sql.Date;
import java.sql.SQLException;

public class Service implements AdminService, LoginService, PartnerService {

    private UserDao userDao;
    private PersonDao personDao;
    private PartnerDao partnerDao;
    private InvoiceDetailDao invoiceDetailDao;
    private InvoiceDao invoiceDao;
    private GuestDao guestDao;
    public static UserDto user;
    public static PersonDto person;

    public Service() {
        this.userDao = new UserDaoImplementation();
        this.personDao = new PersonDaoImplementation();
        this.partnerDao = new PartnerDaoImplemetation();
        this.guestDao = new GuestDaoImplemetation();
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
        userDto.setRole(validateDto.getRole());
        user = validateDto;

    }

    @Override
    public void logout() {
        user = null;
        System.out.println("se ha cerrado sesion");
    }

    private void createUser(UserDto userDto) throws Exception {
        this.createPerson(userDto.getPersonId());
        PersonDto personDto = personDao.findByDocument(userDto.getPersonId());
        userDto.setPersonId(personDto);
        if (this.userDao.existsByUserName(userDto)) {
            this.personDao.deletePerson(userDto.getPersonId());
            throw new Exception("ya existe un usuario con ese user name");
        }
        try {
            this.userDao.createUser(userDto);
        } catch (SQLException e) {
            this.personDao.deletePerson(userDto.getPersonId());
            throw new Exception("error al crear el usuario");
        }
    }

    private void createPerson(PersonDto personDto) throws Exception {

        if (this.personDao.existByDocument(personDto)) {
            throw new Exception("Ya existe una persona con este documento");
        }

        this.personDao.createPerson(personDto);
    }

    @Override
    public void createPartner(PartnerDto partnerDto) throws Exception {
        this.createUser(partnerDto.getUserId());
        UserDto userDto = userDao.findByUserName(partnerDto.getUserId());
        partnerDto.setUserId(userDto);
        try {
            Partner partner = Helper.parse(partnerDto);
            this.partnerDao.createPartner(partnerDto);
        } catch (SQLException e) {
            this.userDao.deleteUser(userDto);
            throw new Exception("error al crear el partner");
        }
    }

    @Override
    public void createGuest(GuestDto guestDto) throws Exception {
        this.createUser(guestDto.getUserId());
        UserDto userDto = userDao.findByUserName(guestDto.getUserId());
        guestDto.setUserId(userDto);
        PartnerDto partnerDto = partnerDao.existByPartner(user);
        guestDto.setPartnerId(partnerDto);
        try {
            this.guestDao.createGuest(guestDto);
        } catch (SQLException e) {
            this.userDao.deleteUser(userDto);

            throw new Exception("error al crear el invitador", e);
        }
    }

    @Override
    public void deletePartner() throws Exception {
        UserDto users = Service.user;
        try {
            PartnerDto partnerDto = this.partnerDao.existByPartner(users);
            UserDto userDto = this.userDao.findByUserName(users);
            this.userDao.existsByUserName(userDto);

            this.partnerDao.deletePartner(partnerDto);
            this.userDao.deleteUser(userDto);
            this.personDao.deletePerson(userDto.getPersonId());
            System.out.println("Su cuenta ha sido eliminada exitosamente.");
            this.logout();
        } catch (SQLException e) {
            System.out.println("El usuario no existe en la base de datos.");
        }
    }

    @Override
    public void changeRol(PartnerDto partnerDto) throws Exception {

        UserDto users = Service.user;
        GuestDto guestDto = this.guestDao.existByGuest(users);
        this.guestDao.deleteGuest(guestDto);
        UserDto userDto = userDao.findByUserName(users);
        partnerDto.setUserId(userDto);
        userDto.setRole("partner");
        this.userDao.updateUserRole(userDto);
        try {
            this.partnerDao.createPartner(partnerDto);
            System.out.println("Se ha convertido el Guest en Partner exitosamente.");
            
        } catch (SQLException e) {
            System.out.println("El usuario no existe en la base de datos.");
        }
    }
}

/*private InvoiceDto createOrder(PartnerDto partnerDto) throws Exception {
        InvoiceDto orderDto = new InvoiceDto();
        orderDto.setCreationDate(new Date(clinicalHistoryDto.getDate()));
        orderDto.setId(getId());
        orderDto.setOwnerId(clinicalHistoryDto.getPetId().getOwnerId());
        orderDto.setMedicine(clinicalHistoryDto.getMedicine());
        orderDto.setDose(clinicalHistoryDto.getDose());
        orderDto.setVeterinarian(clinicalHistoryDto.getVeterinarian());
        orderDao.createOrder(orderDto);
        return orderDto;*/
 /*this.createUser(guestDto.getUserId());
        UserDto userDto = userDao.findByUserName(guestDto.getUserId());
        guestDto.setUserId(userDto);
           PartnerDto partnerDto = partnerDao.existByPartner(user);
        guestDto.setPartnerId(partnerDto);
       try {
             guestDao.createGuest(guestDto);
       } catch (SQLException e) {
            
            throw new Exception("error al crear el invitador");
       }*/
