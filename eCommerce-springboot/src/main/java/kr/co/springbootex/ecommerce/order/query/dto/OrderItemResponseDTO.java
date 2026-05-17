package kr.co.springbootex.ecommerce.order.query.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderItemResponseDTO {
    private String idOrderItem;         // PK
    private String idOrder;             // 주문 번호
    private Integer cnOrderItem;        // 품목 순번
    private String noProduct;           // 상품 코드
    private String nmProduct;           // 상품명
    private Integer qtOrderItemPrice;   // 구매 당시 단가
    private Integer qtOrderItem;        // 구매 수량
    private Integer qtOrderItemAmount;  // 품목별 총 금액
}
