/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controllers;

import app.Daoo.GuestDaoImplemetation;
import app.Daoo.PartnerDaoImplemetation;
import app.Daoo.PersonDaoImplementation;
import app.Daoo.UserDaoImplementation;
import app.controller.validator.GuestValidator;
import app.controller.validator.InvoiceValidator;
import app.controller.validator.PartnerValidator;
import app.controller.validator.PersonValidator;
import app.controller.validator.UserValidator;
import app.controllers.requests.CreateUserRequest;
import app.dao.interfaces.GuestDao;
import app.dao.interfaces.InvoiceDao;
import app.dao.interfaces.PartnerDao;
import app.dao.interfaces.PersonDao;
import app.dao.interfaces.UserDao;
import app.dto.GuestDto;
import app.dto.InvoiceDetailDto;
import app.dto.InvoiceDto;
import app.dto.PartnerDto;
import app.dto.PersonDto;
import app.dto.UserDto;
import app.model.Partner;
import app.service.interfac.PartnerService;
import app.service.x.ServiceClub;
import static app.service.x.ServiceClub.user;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Camilo
 */
@RestController
@Getter
@Setter
@NoArgsConstructor
public class PartnerController implements ControllerInterface {

    @Autowired
    private PartnerValidator partnerValidator;
    private static final String MENU = "ingrese la opcion que desea ejecutar: \n 1. para crear invitado. \n 2. para agragar fondos. \n 3. para mostrar invitados. \n 4. para activar/descativar invitado. \n 5. para solicitar promocion. \n 6. para solicitar baja.  \n 7. para crear factura \n 8. para ver facturas \n 9. para pagar factura  \n 10.para cerrar sesion \n";
    @Autowired
    private PersonValidator personValidator;
    @Autowired
    private GuestValidator guestValidator;
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private PartnerService service;
    @Autowired
    private PartnerDao partnerDao;
    @Autowired
    private PersonDao personDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private GuestDao guestDao;
    @Autowired
    private InvoiceValidator invoiceValidator;
    @Autowired
    private InvoiceDao invoiceDao;

    @Override
    public void session() throws Exception {

    }

    @PostMapping("/guest")
    public ResponseEntity createGuest(@RequestBody CreateUserRequest request) throws Exception {
        try {
            String name = request.getName();
            personValidator.validName(name);
            long document = personValidator.validDocument(request.getDocument());
            long celPhone = personValidator.validPhone(request.getCelPhone());
            String userName = request.getUserName();
            userValidator.validUserName(userName);
            String password = request.getPassword();
            userValidator.validPassword(password);
            long partnerId = personValidator.validPhone(request.getPartnerId());
            PersonDto personDto = new PersonDto();
            personDto.setName(name);
            personDto.setDocument(document);
            personDto.setCelPhone(celPhone);
            UserDto userDto = new UserDto();
            userDto.setPersonId(personDto);
            userDto.setUserName(userName);
            userDto.setPassword(password);
            userDto.setRole("guest");
            GuestDto guestDto = new GuestDto();
            PartnerDto partnerDto = new PartnerDto();
            partnerDto.setId(partnerId);
            this.partnerDao.existByPartner(partnerDto);

            guestDto.setPartnerId(partnerDto);
            guestDto.setUserId(userDto);
            guestDto.setStatus("inactivo");
            this.service.createGuest(guestDto);
            System.out.println("se ha creado el Invitado exitosamente");
            return new ResponseEntity<>("el usuario se ha creado exitosamente", HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/partner")
    public ResponseEntity<String> deletePartner() {
        try {
            this.service.deletePartner();
            return new ResponseEntity<>("Su cuenta ha sido eliminada exitosamente.", HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>("Ocurrió un error al eliminar la cuenta.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public void statusGuest() throws Exception {
       // PartnerDto partnerDto = partnerDao.existByPartner(ServiceClub.user);
        //if (partnerDto == null) {
            System.out.println("No se encontró un socio asociado al usuario.");
            return;
      //  }
       // service.showGuestsForPartner(partnerDto);

    }

    public void changeStatus() throws Exception {

    //    PartnerDto partnerDto = partnerDao.existByPartner(ServiceClub.user);
        System.out.println("Ingrese el ID del invitado cuyo estado desea cambiar:");
        long guestId = Long.parseLong(Utils.getReader().nextLine());
        GuestDto guestDto = service.getGuestById(guestId);

        System.out.println("Ingrese el nuevo estado (activo/inactivo):");
        String status = Utils.getReader().nextLine();
        guestDto.setStatus(status);
        service.updateGuestStatus(guestDto);
        System.out.println("Estado del invitado actualizado exitosamente.");
      //  service.checkGuestLimit(partnerDto);
    }

    public void addFouns() throws Exception {
        this.service.updateMoney();
    }

    public void vipPromocion() throws Exception {
        this.service.vipPromocion();
    }

    public void createVoice() throws Exception {
        this.service.createInvoice();
    }

    public void statusInvoice() throws Exception {
        this.service.showInvoiceForPartner();

    }

    public void payVoice() throws Exception {

        this.service.payInvoice();

    }
}
