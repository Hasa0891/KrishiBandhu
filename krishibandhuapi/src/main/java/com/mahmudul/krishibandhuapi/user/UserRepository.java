package com.mahmudul.krishibandhuapi.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    User findByUsername(String username);
    User findByEmail(String email);
}
