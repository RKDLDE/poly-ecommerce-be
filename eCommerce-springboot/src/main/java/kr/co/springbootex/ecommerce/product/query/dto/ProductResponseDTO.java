package kr.co.springbootex.ecommerce.product.query.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ProductResponseDTO {
    private String noProduct;          // 상품 코드
    private String nmProduct;          // 상품명
    private String nmDetailExplain;    // 상세 설명
    private String dtStartDate;        // 판매 시작 일자
    private String dtEndDate;          // 판매 종료 일자
    private Integer qtSalePrice;       // 판매 가격
    private Integer qtStock;           // 재고 수량

    private Long nbCategory;           // 카테고리 식별번호
    private String nmCategory;         // 카테고리명
}
