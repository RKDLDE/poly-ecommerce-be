package kr.co.springbootex.ecommerce.user.query.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {
    private String idUser;      // 사용자 ID
    private String nmUser;      // 사용자명
    private String nmPaswd;    // 비밀번호
    private String noMobile;    // 휴대전화
    private String nmEmail;     // 이메일
    private String stStatus;    // 상태 (ST01: 정상, ST02: 해지, ST03: 가입요청, ST04: 탈퇴요청)
    private String cdUserType;  // 사용자 구분 코드 (‘10’:일반사용자,‘20’: 관리자)
}
