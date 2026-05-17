package kr.co.springbootex.ecommerce.user.command.application.dto;

import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PasswordChangeRequestDTO {
    private String currentPassword;

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{5,15}$",
            message = "비밀번호는 영문자(대소문자 무관)와 숫자를 최소 1개씩 포함하여 5~15자리여야 합니다.")
    private String newPassword;
}
