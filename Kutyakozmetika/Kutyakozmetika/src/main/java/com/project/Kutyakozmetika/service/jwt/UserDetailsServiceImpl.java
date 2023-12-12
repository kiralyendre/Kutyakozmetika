package com.project.Kutyakozmetika.service.jwt;


import com.project.Kutyakozmetika.domain.User;
import com.project.Kutyakozmetika.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameOrEmail(usernameOrEmail,usernameOrEmail);
        if (user == null) {
            throw new UsernameNotFoundException("USer not found", null);
        }

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
//        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
//        private Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
//            return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList()); //itt kell hozzáadni a jogosultságot
        }

    }
