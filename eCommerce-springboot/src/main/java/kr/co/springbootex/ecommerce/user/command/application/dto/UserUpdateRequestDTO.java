package kr.co.springbootex.ecommerce.user.command.application.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateRequestDTO {
    private String nmUser;
    private String noMobile;
    private String nmEmail;
}
