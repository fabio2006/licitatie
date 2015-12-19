package ro.fabio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ro.fabio.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByName(String name);
	User findByEmail(String email);


}
