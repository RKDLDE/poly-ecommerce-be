package kr.co.springbootex.ecommerce.order.query.dto;

import lombok.*;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderResponseDTO {
    private String idOrder;             // 주문 번호
    private String idUser;              // 사용자 ID
    private Integer qtOrderAmount;      // 총 주문 금액
    private String nmOrderPerson;       // 주문자 명
    private String nmDeliveryAddress;   // 배송 주소
    private LocalDateTime daOrder;      // 주문 일자
    private String stOrder;             // 주문 상태
}
