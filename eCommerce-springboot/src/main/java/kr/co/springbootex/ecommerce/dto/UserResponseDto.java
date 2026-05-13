package kr.co.springbootex.ecommerce.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserResponseDto {
    private Long id;
    private String email;
    private String name;
}
