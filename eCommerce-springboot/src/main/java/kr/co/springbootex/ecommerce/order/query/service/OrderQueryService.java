package kr.co.springbootex.ecommerce.order.query.service;

import kr.co.springbootex.ecommerce.order.command.domain.entity.Order;
import kr.co.springbootex.ecommerce.order.command.domain.repository.OrderRepository;
import kr.co.springbootex.ecommerce.order.query.dto.OrderItemResponseDTO;
import kr.co.springbootex.ecommerce.order.query.dto.OrderRequestDTO;
import kr.co.springbootex.ecommerce.order.query.dto.OrderResponseDTO;
import kr.co.springbootex.ecommerce.order.query.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderQueryService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    // 주문 목록
    public List<OrderResponseDTO> getMyOrders(String idUser) {
        List<Order> entityList = orderRepository.findByIdUserOrderByDaOrderDesc(idUser);

        return entityList.stream().map(order -> new OrderResponseDTO(
            order.getIdOrder(),
            order.getUser().getIdUser(),
            order.getQtOrderAmount(),
            order.getNmOrderPerson(),
            order.getNmDeliveryAddress(),
            order.getDaOrder(),
            order.getStOrder()
        )).collect(Collectors.toList());
    }

    // 관리자: 전체 주문
    public Map<String, Object> getOrdersForAdmin(OrderRequestDTO requestDTO) {
        List<OrderResponseDTO> items = orderMapper.findAllOrdersForAdmin(requestDTO);
        int totalCount = orderMapper.countAllOrdersForAdmin(requestDTO);

        Map<String, Object> result = new HashMap<>();
        result.put("items", items);
        result.put("totalCount", totalCount);
        return result;
    }

    // 주문 상세 조회
    public List<OrderItemResponseDTO> getOrderItems(String orderId) {
        return orderMapper.findOrderItemsByOrderId(orderId);
    }
}