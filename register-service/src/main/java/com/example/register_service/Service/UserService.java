package com.example.register_service.Service;

import com.example.register_service.Entity.UserEntity;
import com.example.register_service.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserEntity saveUser(UserEntity user){
        return userRepository.save(user);
    }

    public UserEntity authenticateUser(String Rut, String Password) {
        Optional<UserEntity> user = userRepository.findByRut(Rut);

        if (user.isPresent()) {
            if (user.get().getPassword().equals(Password)) {
                return user.get();
            } else {

                System.out.println("Incorrect password for user with Rut: " + Rut);
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Wrong password");
            }
        } else {

            System.out.println("User not found for Rut: " + Rut);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }

    public UserEntity findUserById(Long Id){
        return userRepository.findById(Id)
                .orElseThrow(() -> new RuntimeException("User Not Found"));
    }
}
