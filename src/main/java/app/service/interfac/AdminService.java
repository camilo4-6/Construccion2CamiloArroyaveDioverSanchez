
package app.service.interfac;

import app.dto.UserDto;


public interface AdminService {
    public void createPartner(UserDto userDto) throws Exception;
    public void createVoice (UserDto userDto) throws Exception;
}
