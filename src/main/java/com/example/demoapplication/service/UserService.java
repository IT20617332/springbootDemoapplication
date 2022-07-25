package com.example.demoapplication.service;

import com.example.demoapplication.dto.UserDTO;
import com.example.demoapplication.entity.User;
import com.example.demoapplication.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    public UserDTO saveUser(UserDTO userDTO){//post method
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }

    public List<UserDTO> getAllUsers(){//get method
        List<User>userList=userRepo.findAll();
        return modelMapper.map(userList,new TypeToken<List<UserDTO>>(){}.getType());
    }

    public UserDTO updateUser(UserDTO userDTO){//update method
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }

    public boolean deleteUser(UserDTO userDTO){//delete method
        userRepo.delete(modelMapper.map(userDTO, User.class));
        return true;
    }

    public UserDTO getUserByUserID(String userID){//get user by user id
        User user =  userRepo.getUserByUserID(userID);
        return modelMapper.map(user, UserDTO.class);
    }

    public UserDTO getUserByUserIDAndAddress(String userID, String address){//get by id and address
        User user = userRepo.getUserByUserIDAndAddress(userID, address);//userId also valid here
        return modelMapper.map(user, UserDTO.class);
    }
}
