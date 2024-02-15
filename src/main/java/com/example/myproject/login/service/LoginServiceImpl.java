package com.example.myproject.login.service;


import com.example.myproject.login.dao.LoginDao;
import com.example.myproject.user.dto.UserDto;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements UserDetailsService {

    private final LoginDao loginDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        String userName, password;
//        List<GrantedAuthority> authorities;
//        List<UserDto> users = loginDao.findUserById(username);
//        if (users.size() == 0) {
//            throw new UsernameNotFoundException("User details not found for the user : " + username);
//        } else{
//            userName = users.get(0).getUsername();
//            password = users.get(0).getPassword();
//            authorities = new ArrayList<>();
//            authorities.add(new SimpleGrantedAuthority(users.get(0).getRole()));
//        }
//        return new User(userName,password,authorities);
//    }
}
