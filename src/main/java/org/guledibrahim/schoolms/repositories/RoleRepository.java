package org.guledibrahim.schoolms.repositories;

import org.guledibrahim.schoolms.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>
{

    Role findByName(String name);
}
