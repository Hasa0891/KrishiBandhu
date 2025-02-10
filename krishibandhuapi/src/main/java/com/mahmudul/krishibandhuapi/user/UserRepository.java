package com.mahmudul.krishibandhuapi.user;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mahmudul.krishibandhuapi.entities.User;

public interface UserRepository extends JpaRepository<User,Long>{
    User findByUsernameOrEmail(String username, String email);
}
