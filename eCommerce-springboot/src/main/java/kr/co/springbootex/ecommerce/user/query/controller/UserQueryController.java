package kr.co.springbootex.ecommerce.user.query.controller;

import kr.co.springbootex.ecommerce.user.query.dto.UserRequestDTO;
import kr.co.springbootex.ecommerce.user.query.dto.UserResponseDTO;
import kr.co.springbootex.ecommerce.user.query.service.UserQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserQueryController {
    private final UserQueryService userQueryService;

    // 관리자: 회원 전부 불러오기
    @GetMapping()
    public List<UserResponseDTO> getAllUsers(@ModelAttribute UserRequestDTO userRequestDTO){
        return userQueryService.getAllUsers(userRequestDTO);
    }
}