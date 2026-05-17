package kr.co.springbootex.ecommerce.user.command.application.dto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginRequestDTO {
    private String idUser;
    private String nmPaswd;
}