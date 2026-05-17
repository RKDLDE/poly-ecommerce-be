package kr.co.springbootex.ecommerce.user.query.dto;

import lombok.*;

// 상태 및 권한
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserRequestDTO {
    private String stStatus;  // 상태 (ST01: 정상, ST02: 해지, ST03: 가입요청, ST04: 탈퇴요청)
}
