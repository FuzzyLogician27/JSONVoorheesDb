package com.sparta.jsonvoorhees.springapi.model.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;


public class SecurityUser implements UserDetails {

    private RoleUser roleUser;

    public SecurityUser(RoleUser roleUser) {
        this.roleUser = roleUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.stream(roleUser
                        .getRoles()
                        .split(","))
                .map(SimpleGrantedAuthority::new)
                .toList();

    }

    @Override
    public String getPassword() {
        return roleUser.getPassword();
    }

    @Override
    public String getUsername() {
        return roleUser.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
