package propensi.myjisc.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import propensi.myjisc.user.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    Optional<User> findByEmail(String email);
 }
