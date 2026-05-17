package kr.co.springbootex.ecommerce.basket.command.application.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BasketAddRequestDTO {
    private String noProduct;      // 상품 코드
    private Integer qtBasketItem;  // 담을 수량
}
