package kr.co.springbootex.ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="e_users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String name;
//    private Integer age;
}
