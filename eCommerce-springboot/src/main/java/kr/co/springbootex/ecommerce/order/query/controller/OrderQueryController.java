package kr.co.springbootex.ecommerce.order.query.controller;

import kr.co.springbootex.ecommerce.order.query.dto.OrderItemResponseDTO;
import kr.co.springbootex.ecommerce.order.query.dto.OrderRequestDTO;
import kr.co.springbootex.ecommerce.order.query.dto.OrderResponseDTO;
import kr.co.springbootex.ecommerce.order.query.service.OrderQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class OrderQueryController {
    private final OrderQueryService orderQueryService;

    // 관리자: 전체 주문 목록
    @GetMapping("/admin/orders")
    public Map<String, Object> getOrdersForAdmin(@ModelAttribute OrderRequestDTO orderRequestDTO) {
        return orderQueryService.getOrdersForAdmin(orderRequestDTO);
    }

    // 본인 주문 목록
    @GetMapping("/orders/{idUser}")
    public List<OrderResponseDTO> getMyOrders(@PathVariable("idUser") String idUser) {
        return orderQueryService.getMyOrders(idUser);
    }


    // 주문 상세 내역
    @GetMapping("/orders/items/{orderId}")
    public List<OrderItemResponseDTO> getOrderItems(@PathVariable("orderId") String orderId) {
        return orderQueryService.getOrderItems(orderId);
    }
}
