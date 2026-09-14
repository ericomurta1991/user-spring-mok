package br.com.projeto.api_rest.repositories;

import br.com.projeto.api_rest.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
