package com.example.JobApplicationManagement.Service;

import com.example.JobApplicationManagement.Dto.UserDto;
import com.example.JobApplicationManagement.Entity.Users;
import com.example.JobApplicationManagement.Mapper.UserMapper;
import com.example.JobApplicationManagement.Repository.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public String CreateUser(UserDto userDto){
        Users users = UserMapper.toEntity(userDto);
        userRepo.save(users);
        return "Success";

    }

    public List<UserDto> getAllusers(){
        return userRepo
                .findAll()
                .stream()
                .map(UserMapper::toDto)
                .toList();
    }

    public Users getUserByid(Long id ){
     Optional<Users> users = userRepo.findById(id);
     if(users.isEmpty()){
         throw new RuntimeException("Resource doesnt Exist" + id);
     }
     return users.get();


    }

    public void deleteUserbyId(Long id){
        userRepo.deleteById(id);

    }

    @Transactional
    public UserDto editUser(Long id , UserDto updateduser){
        Optional<Users> users = userRepo.findById(id);
        if(users.isEmpty()){
            throw new RuntimeException("Resource Not Found");

        }else{
            users.get().setName(updateduser.getName());
            users.get().setEmail(updateduser.getEmail());
            users.get().setCreateddate(updateduser.getCreateddate());
            userRepo.save(users.get());

            return UserMapper.toDto(users.get());
        }


    }
}
