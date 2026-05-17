package kr.co.springbootex.ecommerce.order.command.application.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDirectRequestDTO {
    private String noProduct;         // 상품 번호
    private Integer qtOrderItem;      // 주문 수량
    private String nmOrderPerson;     // 수령인
    private String nmDeliveryAddress; // 배송지 주소
}