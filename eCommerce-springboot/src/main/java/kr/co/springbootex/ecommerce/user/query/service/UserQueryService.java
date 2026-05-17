package kr.co.springbootex.ecommerce.user.query.service;

import kr.co.springbootex.ecommerce.user.query.dto.UserRequestDTO;
import kr.co.springbootex.ecommerce.user.query.dto.UserResponseDTO;
import kr.co.springbootex.ecommerce.user.query.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserQueryService {
    private final UserMapper userMapper;

    // 관리자: 회원 전부 불러오기
    public List<UserResponseDTO> getAllUsers(UserRequestDTO userRequestDTO){
        return userMapper.findAll(userRequestDTO);
    }
}