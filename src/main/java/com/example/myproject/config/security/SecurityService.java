package com.example.myproject.config.security;

import com.example.myproject.user.dto.UserDto;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecurityService {
//public class SecurityService implements UserDetailsService {

    private final SecurityDao securityDao;

//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        String userName, password;
//        List<GrantedAuthority> authorities;
//        List<UserDto> users = securityDao.findUserByEmail(email);
//        if (users.size() == 0) {
//            throw new UsernameNotFoundException("User details not found for the user : " + email);
//        } else{
//            userName = users.get(0).getEmail();
//            password = users.get(0).getPwd();
//            authorities = new ArrayList<>();
//            authorities.add(new SimpleGrantedAuthority(users.get(0).getRole()));
//        }
//        return new User(userName,password,authorities);
//    }
}
