package kr.co.springbootex.ecommerce.user.command.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
// 회원가입 요청용 DTO
public class UserSignupRequestDTO {
    @NotBlank(message = "아이디는 필수 입력 값입니다.")
    @Pattern(regexp = "^[a-zA-Z0-9]{5,15}$",
            message = "아이디는 영문자, 숫자 조합으로 5~15자리여야 합니다.")
    private String idUser;      // 사용자 ID

    @NotBlank(message = "이름은 필수 입력 값입니다.")
    private String nmUser;      // 사용자명

    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{5,15}$",
            message = "비밀번호는 영문자(대소문자 무관)와 숫자를 최소 1개씩 포함하여 5~15자리여야 합니다.")
    private String nmPaswd;     // 비밀번호

    @NotBlank(message = "휴대전화 번호는 필수 입력 값입니다.")
    private String noMobile;    // 휴대전화

    @NotBlank(message = "이메일은 필수 입력 값입니다.")
    private String nmEmail;     // 이메일
    private String cdUserType;  // 사용자 구분 코드 (‘10’:일반사용자,‘20’: 관리자)
}
