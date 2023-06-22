package ernestui.usermanagement.service;

import ernestui.usermanagement.configuration.database.DatabaseRepository;
import ernestui.usermanagement.configuration.database.entities.Role;
import ernestui.usermanagement.data.GeneralResponse;
import ernestui.usermanagement.data.request.roleDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ernest Joseph Nzalawahe
 * @created 22/06/2023 - 15:42
 * @project user-management
 */
@Service
public class RoleService implements IRole{
    private DatabaseRepository databaseRepository;

    public RoleService(DatabaseRepository databaseRepository) {
        this.databaseRepository = databaseRepository;
    }

    public <T> GeneralResponse<T> processResponse(String status, String message, T body) {
        GeneralResponse<T> responseWrapper = new GeneralResponse<>();
        responseWrapper.setBody(body);
        responseWrapper.setStatusCode(status);
        responseWrapper.setMessage(message);
        return responseWrapper;
    }

    @Override
    public GeneralResponse addRole(roleDto rDto) {
        Role role = new Role();
        role.setRoleName(rDto.getRoleName());
        Role response =databaseRepository.roleRepository.save(role);
        return (processResponse("200", "Success", response));
    }

    @Override
    public GeneralResponse getRoles() {
        List<Role> response = (List<Role>) databaseRepository.roleRepository.findAll();
        return (processResponse("200", "Success",response));
    }

    @Override
    public Role getRole(Long roleId) {
        return null;
    }

    @Override
    public Role deleteRole(Long roleId) {
        return null;
    }

    @Override
    public Role editRole(Long roleId, roleDto rDto) {
        return null;
    }
}
