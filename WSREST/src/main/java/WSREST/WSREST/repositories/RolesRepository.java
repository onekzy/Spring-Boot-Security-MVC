package WSREST.WSREST.repositories;

import WSREST.WSREST.entities.Role;
import WSREST.WSREST.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface RolesRepository extends CrudRepository<Role, Long> {
    Role findById(long id);
    Role findByRole(String role);
}
