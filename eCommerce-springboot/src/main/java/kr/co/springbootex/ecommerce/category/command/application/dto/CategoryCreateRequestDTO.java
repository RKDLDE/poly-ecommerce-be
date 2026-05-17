package kr.co.springbootex.ecommerce.category.command.application.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CategoryCreateRequestDTO {
    private Long nbCategory;            // 카테고리 식별번호
    private Long nbParentCategory;      // 상위 카테고리 식별번호
    private String nmCategory;          // 카테고리명
    private Integer cnLevel;            // 레벨
    private Integer cnOrder;            // 순번
}
