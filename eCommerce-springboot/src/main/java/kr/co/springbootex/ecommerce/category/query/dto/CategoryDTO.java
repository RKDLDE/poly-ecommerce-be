package kr.co.springbootex.ecommerce.category.query.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CategoryDTO {
    private int nbCategory;         // 카테고리 식별번호
    private int nbParentCategory;   // 상위 카테고리 식별번호
    private String nmCategory;      // 카테고리명
    private int cnLevel;           // 레벨
    private int cnOrder;           // 순번
}
