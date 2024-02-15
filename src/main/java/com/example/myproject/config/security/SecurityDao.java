package com.example.myproject.config.security;

import com.example.myproject.user.dto.UserDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SecurityDao {

    List<UserDto> findUserByEmail(String email);
}
