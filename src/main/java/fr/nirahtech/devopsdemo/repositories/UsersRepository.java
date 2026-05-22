package fr.nirahtech.devopsdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.nirahtech.devopsdemo.domain.User;

@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {
    
}
