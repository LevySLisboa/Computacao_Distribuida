package com.unifor.Arquiteturas.services;

import com.unifor.Arquiteturas.models.User;
import com.unifor.Arquiteturas.models.dtos.UserDTO;
import com.unifor.Arquiteturas.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public UserDTO createUser(UserDTO obj) {
        User user = new User(obj.getId(),obj.getName(),obj.getEmail());
        repository.save(user);
        return obj;
    }

    public List<UserDTO> findAll() {
        List<User> list = repository.findAll();
        List<UserDTO> dtos = list.stream().map(x-> new UserDTO(x.getId(),x.getName(),x.getEmail())).toList();
        return dtos;
    }

    public UserDTO findById(Long id) {
        User user =  repository.findById(id).orElseThrow();
        return new UserDTO(user.getId(), user.getName(), user.getEmail());
    }
}
