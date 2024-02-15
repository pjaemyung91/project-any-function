package com.example.myproject.user.dao;

import com.example.myproject.user.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    UserDto registerUser(UserDto userDto);
}
