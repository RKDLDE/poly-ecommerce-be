package kr.co.springbootex.ecommerce.product.query.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductRequestDTO {
    private Long categoryId;           // 카테고리 식별번호
    private String searchKeyword;      // 검색할 상품명
    private Boolean isSoldOut;         // 품절 여부 (true 시 재고 0 이하만 조회)

    // mybatis 내 paging을 위한 변수 설정
    private int page = 1;              // 요청 페이지 번호 (기본값 1)
    private int size = 10;             // 페이지당 출력 개수 (기본값 10)

    public int getOffset() {
        return (this.page - 1) * this.size;
    }
}
