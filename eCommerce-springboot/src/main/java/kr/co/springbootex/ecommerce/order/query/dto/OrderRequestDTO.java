package kr.co.springbootex.ecommerce.order.query.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderRequestDTO {
    private String idUser;         // 사용자별 필터
    private String daOrderDate;    // 일자별 필터
    private String stOrder;        // 주문 상태


    // 페이징용
    private int page = 0;
    private int size = 10;
}