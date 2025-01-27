package com.horizon.carpooling.dao;

import com.horizon.carpooling.entities.User;
import org.hibernate.Internal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findByCIN(long CIN);
    Optional<User> findByPhoneNumber(long phoneNumber);


}