package kr.co.springbootex.ecommerce.user.query.mapper;

import kr.co.springbootex.ecommerce.user.query.dto.UserRequestDTO;
import kr.co.springbootex.ecommerce.user.query.dto.UserResponseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    // 관리자: 회원 전부 불러오기
    List<UserResponseDTO> findAll(UserRequestDTO userRequestDTO);
}
