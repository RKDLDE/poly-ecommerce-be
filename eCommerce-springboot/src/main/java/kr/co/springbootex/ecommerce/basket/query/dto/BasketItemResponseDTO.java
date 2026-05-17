package kr.co.springbootex.ecommerce.basket.query.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BasketItemResponseDTO {
    private Integer nbBasket;           // 장바구니 식별번호
    private String idUser;              // 사용자 식별번호
    private Integer nbBasketItem;       // 장바구니 품목 식별번호
    private Integer cnBasketItemOrder;  // 품목 순번
    private String noProduct;           // 상품 코드
    private String nmProduct;           // 상품명
    private Integer qtBasketItemPrice;  // 품목 단가
    private Integer qtBasketItem;       // 품목 수량
    private Integer qtBasketItemAmount; // 품목 금액
}
