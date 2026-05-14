package kr.co.springbootex.ecommerce.user.service;

import kr.co.springbootex.ecommerce.entity.User;
import kr.co.springbootex.ecommerce.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    // SELECT
    public List<User> getAllUsers(){
        return userMapper.findAll();
    }

    // SELECT by ID
    public User getUserById(Long id){
        return userMapper.findById(id);
    }

}