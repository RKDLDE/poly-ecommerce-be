package kr.co.springbootex.ecommerce.order.command.application.controller;

import kr.co.springbootex.ecommerce.order.command.application.dto.OrderCartRequestDTO;
import kr.co.springbootex.ecommerce.order.command.application.dto.OrderDirectRequestDTO;
import kr.co.springbootex.ecommerce.order.command.application.service.OrderCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderCommandController {
    private final OrderCommandService orderCommandService;

    // 상품 상세화면에서 바로 주문
    @PostMapping("/direct")
    public ResponseEntity<String> createDirectOrder(
            @RequestHeader("X-USER-ID") String idUser,
            @RequestBody OrderDirectRequestDTO orderDirectRequestDTO) {

        String orderId = orderCommandService.createDirectOrder(idUser, orderDirectRequestDTO);
        return ResponseEntity.ok("주문이 완료되었습니다. (주문번호: " + orderId + ")");
    }

    // 장바구니 선택 상품 주문
    @PostMapping("/cart")
    public ResponseEntity<String> createOrderFromCart(
            @RequestHeader("X-USER-ID") String idUser,
            @RequestBody OrderCartRequestDTO orderCartRequestDTO) {

        String orderId = orderCommandService.createOrderFromCart(idUser, orderCartRequestDTO);
        return ResponseEntity.ok("장바구니 주문이 완료되었습니다. (주문번호: " + orderId + ")");
    }
}
