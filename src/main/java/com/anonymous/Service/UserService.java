package com.anonymous.Service;

import com.anonymous.Entity.User;
import com.anonymous.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by akash.mercer on 14-05-2016.
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User save(User user){
        User retrievedUser = userRepository.findByEmail(user.getEmail());

        if (retrievedUser == null){
            return userRepository.save(user);
        }

        return retrievedUser;
    }

    public User findByEmail(User user){
        return userRepository.findByEmail(user.getEmail());
    }
}
