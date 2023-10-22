package spring.boot.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.boot.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer> {

	User findByEmail(String email);

}
