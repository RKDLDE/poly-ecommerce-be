package kr.co.springbootex.ecommerce.service;

import kr.co.springbootex.ecommerce.domain.User;
import kr.co.springbootex.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    // SELECT
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    // SELECT by ID
    public User getUserById(Long id){
        return userRepository.findById(id);
    }

    // INSERT
    public int registerUser(User user){
        return userRepository.save(user);
    }

    // UPDATE
    public int modifyUser(User user){
        return userRepository.update(user);
    }

    // DELETE
    public int removeUser(Long id){
        return userRepository.delete(id);
    }

}
