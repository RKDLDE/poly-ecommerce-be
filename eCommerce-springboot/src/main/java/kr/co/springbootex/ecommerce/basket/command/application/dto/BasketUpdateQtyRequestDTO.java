package kr.co.springbootex.ecommerce.basket.command.application.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BasketUpdateQtyRequestDTO {
    private Integer qtBasketItem;  // 변경할 수량
}
