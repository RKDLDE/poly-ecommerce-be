package kr.co.springbootex.ecommerce.user.query.mapper;

import kr.co.springbootex.ecommerce.user.query.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    // 관리자: 회원 전부 불러오기
    List<UserDTO> findAll();

    // 관리자: 회원 가입 요청만 보기 (선택)

    // 관리자: 탈퇴 요청만 보기 (선택)

    // 사용자: 개인 정보 불러오기
    UserDTO findById(String idUser);
}
