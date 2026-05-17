package kr.co.springbootex.ecommerce.user.command.application.controller;

import kr.co.springbootex.ecommerce.user.command.application.service.UserCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/users")
@RequiredArgsConstructor
public class AdminUserController {
    private final UserCommandService userCommandService;

    // 관리자: 회원 요청 승인
    @PostMapping("/{idUser}/approve")
    public ResponseEntity<String> approveUserRequest(@PathVariable String idUser) {
        userCommandService.approveUserRequest(idUser);
        return ResponseEntity.ok("정상적으로 승인 처리되었습니다.");
    }

    // 관리자: 사용자 상태 변경
    @PutMapping("/{userId}/status")
    public ResponseEntity<String> changeUserStatus(
            @PathVariable String userId,
            @RequestParam String status) {

        userCommandService.changeUserStatus(userId, status);
        return ResponseEntity.ok("사용자 상태가 변경되었습니다.");
    }

    // 관리자: 사용자 권한 변경
    @PutMapping("/{userId}/role")
    public ResponseEntity<String> changeUserRole(
            @PathVariable String userId,
            @RequestParam String roleType) {

        userCommandService.changeUserRole(userId, roleType);
        return ResponseEntity.ok("사용자 권한이 변경되었습니다.");
    }
}
