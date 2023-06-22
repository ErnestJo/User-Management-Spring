package ernestui.usermanagement.service;

import ernestui.usermanagement.configuration.database.entities.Role;
import ernestui.usermanagement.data.GeneralResponse;
import ernestui.usermanagement.data.request.roleDto;

import java.util.List;

/**
 * @author Ernest Joseph Nzalawahe
 * @created 22/06/2023 - 15:33
 * @project user-management
 */
public interface IRole {
    public GeneralResponse addRole(roleDto rDto);
    public GeneralResponse getRoles();
    public Role getRole(Long roleId);
    public Role deleteRole(Long roleId);
    public Role editRole(Long roleId, roleDto rDto);
}
