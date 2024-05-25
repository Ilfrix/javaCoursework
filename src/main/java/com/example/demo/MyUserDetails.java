package com.example.demo;

import com.example.demo.entities.CustomUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;

public class MyUserDetails implements UserDetails {
    private CustomUser user;

    public MyUserDetails(CustomUser user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
//        System.out.println("authorities" + user);
//        System.out.println(user.getRole());
//        System.out.println(user.role);
//        System.out.println(user.getRole());
        authorities.add(new SimpleGrantedAuthority(user.getRole().getName()));
        return authorities;
    }


    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getName();
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
