package com.example.api.services;

import com.example.api.models.UserModel;
import com.example.api.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;
@Service
public class UserService {

    @Autowired
    IUserRepository userRepository;
    public ArrayList<UserModel> getUser() {
        return (ArrayList<UserModel>) userRepository.findAll();
    }
    public UserModel saveUser(UserModel user) {
        return userRepository.save(user);
    }
    public Optional<UserModel> getById(Long id) {
        return userRepository.findById(id);
    }
    public UserModel updateByid(UserModel request, Long id) {
        UserModel user = userRepository.findById(id).get();

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        return user;
    }

    public Boolean deleteUser (Long id) {
        try{
            userRepository.deleteById(id);
            return true;

        } catch (Exception e){
            return false;
        }
    }
}
