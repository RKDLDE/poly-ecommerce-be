package kr.co.springbootex.ecommerce.user.command.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @Column(name = "id_user", length = 100)
    private String idUser;

    @Column(name = "nm_user", length = 100, nullable = false)
    private String nmUser;

    @Column(name = "nm_paswd", length = 256, nullable = false)
    private String nmPaswd;

    @Column(name = "no_mobile", length = 30, nullable = false)
    private String noMobile;

    @Column(name = "nm_email", length = 100, nullable = false, unique = true)
    private String nmEmail;

    @Column(name = "st_status", length = 4, nullable = false)
    private String stStatus;     // 정상('st01'), 해지('st02'), 가입요청('st03'), 탈퇴요청('st04')

    @Column(name = "cd_user_type", length = 4, nullable = false)
    private String cdUserType;   // 일반사용자('10'), 관리자('20')
}
