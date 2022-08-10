package com.enesergen.bookPortal.core.utilities.configurations.secuirties;

import com.enesergen.bookPortal.entities.concretes.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;


public class MyUserDetails implements UserDetails {
    private final User user;

    public MyUserDetails(User user) {
        if (user!=null){
            this.user = user;
        }else{
            throw new UsernameNotFoundException("User could not be found.");
        }

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(!CollectionUtils.isEmpty(user.getRoles())){
            return user.getRoles()
                    .stream()
                    .map(t->new SimpleGrantedAuthority(t.getName()))
                    .toList();
        }
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return user.isActive();
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.isActive();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return user.isActive();
    }

    @Override
    public boolean isEnabled() {
        return user.isActive();
    }
}
