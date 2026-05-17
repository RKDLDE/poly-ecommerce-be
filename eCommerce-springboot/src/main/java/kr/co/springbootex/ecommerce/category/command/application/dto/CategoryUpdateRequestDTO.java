package kr.co.springbootex.ecommerce.category.command.application.dto;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CategoryUpdateRequestDTO {
    private String nmCategory;          // 카테고리명
    private Integer cnOrder;            // 순번
}
