package ro.fabio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ro.fabio.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

	Role findByName(String name);

}
