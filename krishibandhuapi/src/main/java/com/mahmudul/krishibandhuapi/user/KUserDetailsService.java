package com.mahmudul.krishibandhuapi.user;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mahmudul.krishibandhuapi.entities.User;

@Service
public class KUserDetailsService implements UserDetailsService{

    private UserRepository userRepository;

    public KUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameOrEmail(username, username);
        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add((GrantedAuthority) () -> "ROLE_" + user.getRole());
        return new org.springframework.security.core.userdetails.User(
            user.getUsername(),
            user.getPassword(),
            authorities
        );
    }
}
