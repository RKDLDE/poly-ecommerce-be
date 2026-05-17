package kr.co.springbootex.ecommerce.order.command.application.service;

import kr.co.springbootex.ecommerce.basket.command.domain.entity.BasketItem;
import kr.co.springbootex.ecommerce.basket.command.domain.repository.BasketItemRepository;
import kr.co.springbootex.ecommerce.order.command.application.dto.OrderCartRequestDTO;
import kr.co.springbootex.ecommerce.order.command.application.dto.OrderDirectRequestDTO;
import kr.co.springbootex.ecommerce.order.command.domain.entity.Order;
import kr.co.springbootex.ecommerce.order.command.domain.entity.OrderItem;
import kr.co.springbootex.ecommerce.order.command.domain.repository.OrderRepository;
import kr.co.springbootex.ecommerce.product.command.domain.entity.Product;
import kr.co.springbootex.ecommerce.product.command.domain.repository.ProductRepository;
import kr.co.springbootex.ecommerce.user.command.domain.entity.User;
import kr.co.springbootex.ecommerce.user.command.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderCommandService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final BasketItemRepository basketItemRepository;

    // 상품 상세화면에서 바로 주문
    @Transactional
    public String createDirectOrder(String idUser, OrderDirectRequestDTO orderDirectRequestDTO) {

        // 사용자 확인
        User user = userRepository.findById(idUser)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        // 상품 확인
        Product product = productRepository.findById(orderDirectRequestDTO.getNoProduct())
                .orElseThrow(() -> new IllegalArgumentException("상품을 찾을 수 없습니다."));

        // 재고 있는지
        if (product.getQtStock() < orderDirectRequestDTO.getQtOrderItem()) {
            throw new IllegalArgumentException("재고가 부족합니다.");
        }

        // 재고 차감
        product.setQtStock(product.getQtStock() - orderDirectRequestDTO.getQtOrderItem());

        // 주문 생성
        Order order = new Order();

        // PK 생성
        String newOrderId = "ORD-" + System.currentTimeMillis();

        // 주문 set
        order.setIdOrder(newOrderId);
        order.setUser(user);
        order.setNmOrderPerson(orderDirectRequestDTO.getNmOrderPerson());
        order.setNmDeliveryAddress(orderDirectRequestDTO.getNmDeliveryAddress());

        // 금액 게산
        int unitPrice = product.getQtSalePrice();
        int totalAmount = unitPrice * orderDirectRequestDTO.getQtOrderItem();
        order.setQtOrderAmount(totalAmount);

        // 주문 상세 생성
        OrderItem orderItem = new OrderItem(
                newOrderId + "-1", order, 1, product, unitPrice, orderDirectRequestDTO.getQtOrderItem()
        );

        // 주문 리스트에 추가
        order.getItems().add(orderItem);

        // DB저장
        orderRepository.save(order);
        return newOrderId;
    }

    // 장바구니 선택 상품 주문
    @Transactional
    public String createOrderFromCart(String idUser, OrderCartRequestDTO orderCartRequestDTO) {

        // 사용자 확인
        User user = userRepository.findById(idUser)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        // 장바구니 품목들 조회
        List<BasketItem> basketItems = basketItemRepository.findAllById(orderCartRequestDTO.getBasketItemIds());

        // 만약 장바구니가 비어있으면
        if (basketItems.isEmpty()) {
            throw new IllegalArgumentException("주문할 장바구니 상품이 없습니다.");
        }

        // 주문 생성
        Order order = new Order();

        // PK
        String newOrderId = "ORD-" + System.currentTimeMillis();

        // 주문 set
        order.setIdOrder(newOrderId);
        order.setUser(user);
        order.setNmOrderPerson(orderCartRequestDTO.getNmOrderPerson());
        order.setNmDeliveryAddress(orderCartRequestDTO.getNmDeliveryAddress());

        // 총 주문 금액
        int totalAmount = 0;

        // 주문 상세 순번
        int orderSeq = 1;

        // 선택된 장바구니 품목들을 주문 상세로 변환
        for (BasketItem bItem : basketItems) {
            Product product = bItem.getProduct();
            int qty = bItem.getQtBasketItem();

            // 재고 확인
            if (product.getQtStock() < qty) {
                throw new IllegalArgumentException(product.getNmProduct() + " 의 재고가 부족합니다.");
            }

            // 재고 차감
            product.setQtStock(product.getQtStock() - qty);

            // 총 금액
            int unitPrice = product.getQtSalePrice();
            totalAmount += (unitPrice * qty);

            // 주문 상세 생성 및 매핑
            OrderItem orderItem = new OrderItem(
                    newOrderId + "-" + orderSeq, order, orderSeq, product, unitPrice, qty
            );

            // 리스트에 추가
            order.getItems().add(orderItem);
            orderSeq++;
        }

        // 주문 금액 set
        order.setQtOrderAmount(totalAmount);

        // order에 저자ㅓㅇ
        orderRepository.save(order);

        // 주문 후 장바구니 비우기
        basketItemRepository.deleteByNbBasketItemIn(orderCartRequestDTO.getBasketItemIds());

        return newOrderId;
    }
}