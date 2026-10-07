package com.example.JobApplicationManagement.Mapper;

import com.example.JobApplicationManagement.Dto.UserDto;
import com.example.JobApplicationManagement.Entity.Companies;
import com.example.JobApplicationManagement.Entity.Users;

import java.util.List;

public class UserMapper {

    public static UserDto toDto( Users users){

        UserDto userDto = new UserDto();
       userDto.setName(users.getName());
       userDto.setEmail(users.getEmail());
       userDto.setCreateddate(users.getCreateddate());


        return userDto;
    }


    public static Users toEntity(UserDto userDto){
        Users user = new Users();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setCreateddate(userDto.getCreateddate());
        return user ;
    }



}
