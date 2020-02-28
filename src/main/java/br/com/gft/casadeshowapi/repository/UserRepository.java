package br.com.gft.casadeshowapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gft.casadeshowapi.domain.User;


public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
}
