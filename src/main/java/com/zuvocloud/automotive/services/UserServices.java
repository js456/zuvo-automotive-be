package com.zuvocloud.automotive.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zuvocloud.automotive.dto.AddUserDTO;
import com.zuvocloud.automotive.dto.UserDTO;
import com.zuvocloud.automotive.entity.User;
import com.zuvocloud.automotive.repository.UserRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServices {
    @Autowired
    private UserRepo userRepo;

    public List<UserDTO> gettAll() {
        List<User> users = userRepo.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();
        for(User user :users ){
            UserDTO dto = new UserDTO();
            dto.setId(user.getId());
            dto.setName(user.getName());
            dto.setRole(user.getRole());
            dto.setEmail(user.getEmail());
            dto.setPhone(user.getPhone());
            dto.setPasswordHash(user.getPassword_hash());
            dto.setTenantId(user.getTenantId());
         userDTOS.add(dto);
        }
        return userDTOS;
    }
    public User findById(int id){
        User user =  userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return user;
    }

    public User createUser(AddUserDTO addUserDTO) {
        try{
            User user = new User();
            user.setEmail(addUserDTO.getEmail());
            user.setRole(addUserDTO.getRole());
            user.setPhone(addUserDTO.getPhone());
            user.setPassword_hash(addUserDTO.getPasswordHash());
            user.setTenantId(addUserDTO.getTenantId());
            user.setName(addUserDTO.getName());
            User user1 = userRepo.save(user);
            return  user1;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public User updateUser(UserDTO userDTO) {
        try {
            User user = userRepo.findById(userDTO.getId())
                    .orElseThrow(() -> new RuntimeException("User not found with id: " ));

            user.setEmail(userDTO.getEmail());
            user.setRole(userDTO.getRole());
            user.setPhone(userDTO.getPhone());
            user.setPassword_hash(userDTO.getPasswordHash());
            user.setTenantId(userDTO.getTenantId());
            user.setName(userDTO.getName());

            return userRepo.save(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public User softDeleteUser(int userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        user.setDeleted(true);
        return userRepo.save(user);
    }



}
