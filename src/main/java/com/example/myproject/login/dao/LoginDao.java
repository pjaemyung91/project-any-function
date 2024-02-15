package com.example.myproject.login.dao;

import com.example.myproject.user.dto.UserDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginDao {

    List<UserDto> findUserById(String username);
}
