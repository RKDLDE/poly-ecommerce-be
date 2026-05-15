package kr.co.springbootex.ecommerce.user.query.controller;

import kr.co.springbootex.ecommerce.user.query.dto.UserDTO;
import kr.co.springbootex.ecommerce.user.query.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserQueryController {
    private final UserService userService;

//    @Autowired
//    public UserQueryController(UserService userService){
//        this.userService = userService;
//    }

    // 관리자: 회원 전부 불러오기
    @GetMapping()
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    // 사용자: 개인 정보 불러오기
    @GetMapping("/{idUser}")
    public UserDTO getUserById(@PathVariable String idUser){
        return userService.getUserById(idUser);
    }
}

