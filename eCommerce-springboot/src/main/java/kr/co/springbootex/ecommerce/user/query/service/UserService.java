package kr.co.springbootex.ecommerce.user.query.service;

import kr.co.springbootex.ecommerce.user.query.dto.UserDTO;
import kr.co.springbootex.ecommerce.user.query.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;

    // 관리자: 회원 전부 불러오기
    public List<UserDTO> getAllUsers(){
        return userMapper.findAll();
    }

    // 사용자: 개인 정보 불러오기
    public UserDTO getUserById(String idUser){
        return userMapper.findById(idUser);
    }
}