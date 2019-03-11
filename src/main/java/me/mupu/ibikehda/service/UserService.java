package me.mupu.ibikehda.service;

import me.mupu.ibikehda.persistence.dao.User;
import me.mupu.ibikehda.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public User findUser(String name){
        return repository.findFirstByUsername(name);
    }

}
