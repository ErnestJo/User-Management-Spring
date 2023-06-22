package ernestui.usermanagement.configuration.database.repository;

import ernestui.usermanagement.configuration.database.entities.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ernest Joseph Nzalawahe
 * @created 22/06/2023 - 16:04
 * @project user-management
 */
@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
}
