package com.sparta.jsonvoorhees.springapi.service;

import com.sparta.jsonvoorhees.springapi.model.entities.SecurityUser;
import com.sparta.jsonvoorhees.springapi.model.repositories.RoleUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MongoRoleUserService implements UserDetailsService {

    private final RoleUserRepository roleUserRepository;

    public MongoRoleUserService(RoleUserRepository roleUserRepository) {
        this.roleUserRepository = roleUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return roleUserRepository.findRoleUserByUserName(username)
                .map(SecurityUser::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " +  username));
    }
}
