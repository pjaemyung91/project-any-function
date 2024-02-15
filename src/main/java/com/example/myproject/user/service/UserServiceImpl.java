package com.example.myproject.user.service;

import com.example.myproject.user.dao.UserDao;
import com.example.myproject.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final BCryptPasswordEncoder bcryptPasswordEncoder;
    private final UserDao userDao;

    @Override
    public UserDto registerUser(UserDto userDto) {
        String hashedPwd = bcryptPasswordEncoder.encode(userDto.getPwd());
        userDto.setPwd(hashedPwd);
        return userDao.registerUser(userDto);
    }
}
