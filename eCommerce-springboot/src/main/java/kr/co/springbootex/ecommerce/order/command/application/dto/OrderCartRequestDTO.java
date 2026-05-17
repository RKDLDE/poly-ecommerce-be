package kr.co.springbootex.ecommerce.order.command.application.dto;

import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderCartRequestDTO {
    private List<Long> basketItemIds; // 장바구니 품목 번호들
    private String nmOrderPerson;     // 수령인
    private String nmDeliveryAddress; // 배송지 주소
}