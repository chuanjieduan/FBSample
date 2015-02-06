package sk.viawebtour.www.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sk.viawebtour.www.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByName(String name);
}
