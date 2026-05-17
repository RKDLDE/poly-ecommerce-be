package kr.co.springbootex.ecommerce.order.query.mapper;

import kr.co.springbootex.ecommerce.order.query.dto.OrderItemResponseDTO;
import kr.co.springbootex.ecommerce.order.query.dto.OrderRequestDTO;
import kr.co.springbootex.ecommerce.order.query.dto.OrderResponseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    // 관리자: 전체 주문
    List<OrderResponseDTO> findAllOrdersForAdmin(OrderRequestDTO requestDTO);

    // 페이징
    int countAllOrdersForAdmin(OrderRequestDTO requestDTO);

    // 주문 상세
    List<OrderItemResponseDTO> findOrderItemsByOrderId(String orderId);
}
