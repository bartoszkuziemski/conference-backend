package com.example.conferencebackend.repository;

import com.example.conferencebackend.models.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<CustomUser, Long> {

//    @Query(value = "SELECT * FROM custom_user WHERE username = ?1", nativeQuery = true)
    CustomUser findByUsername(String username);

}
