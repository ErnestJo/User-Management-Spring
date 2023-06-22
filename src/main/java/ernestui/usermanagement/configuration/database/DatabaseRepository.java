package ernestui.usermanagement.configuration.database;

import ernestui.usermanagement.configuration.database.repository.RoleRepository;
import org.springframework.stereotype.Service;

/**
 * @author Ernest Joseph Nzalawahe
 * @created 19/06/2023 - 12:51
 * @project user-management
 */
@Service
public class DatabaseRepository {
    public final RoleRepository roleRepository;

    public RoleRepository getRoleRepository() {
        return roleRepository;
    }

    public DatabaseRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
}
