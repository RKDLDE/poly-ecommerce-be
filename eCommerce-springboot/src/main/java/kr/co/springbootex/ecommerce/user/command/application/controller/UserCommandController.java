package kr.co.springbootex.ecommerce.user.command.application.controller;

import jakarta.validation.Valid;
import kr.co.springbootex.ecommerce.user.command.application.dto.PasswordChangeRequestDTO;
import kr.co.springbootex.ecommerce.user.command.application.dto.UserLoginRequestDTO;
import kr.co.springbootex.ecommerce.user.command.application.dto.UserSignupRequestDTO;
import kr.co.springbootex.ecommerce.user.command.application.dto.UserUpdateRequestDTO;
import kr.co.springbootex.ecommerce.user.command.application.service.UserCommandService;
import kr.co.springbootex.ecommerce.user.query.dto.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserCommandController {

    private final UserCommandService userCommandService;

    // 회원가입 요청
    @PostMapping("/signup")
    public ResponseEntity<String> singup(@RequestBody UserSignupRequestDTO userSignupRequestDTO){
        userCommandService.signup(userSignupRequestDTO);
        return ResponseEntity.ok("회원가입 요청이 완료되었습니다.");
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<UserResponseDTO> login(@RequestBody UserLoginRequestDTO userLoginRequestDTO){
        UserResponseDTO userInfo = userCommandService.login(userLoginRequestDTO);
        return ResponseEntity.ok(userInfo);
    }

    // 로그아웃
    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        return ResponseEntity.ok("로그아웃 되었습니다.");
    }

    // 회원정보 수정
    @PutMapping("/me")
    public ResponseEntity<String> updateMyInfo(
            @RequestHeader("X-USER-ID") String idUser,
            @RequestBody UserUpdateRequestDTO userUpdateRequestDTO) {
        userCommandService.updateMyInfo(idUser, userUpdateRequestDTO);
        return ResponseEntity.ok("회원 정보가 수정되었습니다.");
    }

    // 비밀번호 변경
    @PutMapping("/me/password")
    public ResponseEntity<String> changePassword(
            @RequestHeader("X-USER-ID") String idUser,
            @Valid @RequestBody PasswordChangeRequestDTO passwordChangeRequestDTO) {

        userCommandService.changePassword(idUser, passwordChangeRequestDTO);

        return ResponseEntity.ok("비밀번호가 변경되었습니다.");
    }

    // 회원 탈퇴 요청
    @PostMapping("/me/withdraw")
    public ResponseEntity<String> requestWithdrawal(@RequestHeader("X-USER-ID") String idUser) {
        userCommandService.requestWithdrawal(idUser);
        return ResponseEntity.ok("탈퇴 요청 처리가 접수되었습니다.");
    }
    // 사용자 본인 정보 단건 조회
    @GetMapping("/me")
    public ResponseEntity<UserResponseDTO> getMyInfo(@RequestHeader("X-USER-ID") String idUser) {
        UserResponseDTO myInfo = userCommandService.getMyInfo(idUser);
        return ResponseEntity.ok(myInfo);
    }

}
