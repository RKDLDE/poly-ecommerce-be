package kr.co.springbootex.ecommerce.basket.command.application.service;

import kr.co.springbootex.ecommerce.basket.command.application.dto.BasketAddRequestDTO;
import kr.co.springbootex.ecommerce.basket.command.application.dto.BasketDeleteRequestDTO;
import kr.co.springbootex.ecommerce.basket.command.application.dto.BasketUpdateQtyRequestDTO;
import kr.co.springbootex.ecommerce.basket.command.domain.entity.Basket;
import kr.co.springbootex.ecommerce.basket.command.domain.entity.BasketItem;
import kr.co.springbootex.ecommerce.basket.command.domain.repository.BasketItemRepository;
import kr.co.springbootex.ecommerce.basket.command.domain.repository.BasketRepository;
import kr.co.springbootex.ecommerce.product.command.domain.entity.Product;
import kr.co.springbootex.ecommerce.product.command.domain.repository.ProductRepository;
import kr.co.springbootex.ecommerce.user.command.domain.entity.User;
import kr.co.springbootex.ecommerce.user.command.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BasketCommandService {

    private final BasketRepository basketRepository;
    private final BasketItemRepository basketItemRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    // 장바구니 상품 담기
    @Transactional
    public void addBasketItem(String idUser, BasketAddRequestDTO basketAddRequestDTO) {

        // 사용자나 상품을 잘못 입력했을 때..
        User user = userRepository.findById(idUser)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));
        Product product = productRepository.findById(basketAddRequestDTO.getNoProduct())
                .orElseThrow(() -> new IllegalArgumentException("상품을 찾을 수 없습니다."));

        // 시퀀스 생성
        Basket basket = basketRepository.findByUserIdUser(idUser)
                .orElseGet(() -> basketRepository.save(new Basket(user)));

        // 중복 품목 검사
        Optional<BasketItem> existingItem = basket.getItems().stream()
                .filter(item -> item.getProduct().getNoProduct().equals(basketAddRequestDTO.getNoProduct()))
                .findFirst();

        if (existingItem.isPresent()) {
            existingItem.get().updateQuantity(basketAddRequestDTO.getQtBasketItem());
        } else {
            int newOrder = basket.getItems().size() + 1;
            int price = product.getQtSalePrice();
            int qty = basketAddRequestDTO.getQtBasketItem();
            int amount = price * qty;

            BasketItem newItem = new BasketItem(
                    null, basket, newOrder, product, price, qty, amount
            );
            basket.getItems().add(newItem);
        }
    }

    // 장바구니 수량 변경
    @Transactional
    public void updateBasketItemQuantity(Long nbBasketItem, BasketUpdateQtyRequestDTO basketUpdateQtyRequestDTO) {

        BasketItem item = basketItemRepository.findById(nbBasketItem)
                .orElseThrow(() -> new IllegalArgumentException("장바구니 품목을 찾을 수 없습니다."));

        // 수량 변경
        item.setQtBasketItem(basketUpdateQtyRequestDTO.getQtBasketItem());

        // 가격 변경
        item.setQtBasketItemAmount(item.getQtBasketItemPrice() * basketUpdateQtyRequestDTO.getQtBasketItem());
    }

    // 장바구니 선택 삭제
    @Transactional
    public void deleteSelectedItems(BasketDeleteRequestDTO basketDeleteRequestDTO) {
        if (basketDeleteRequestDTO.getItemIds() != null && !basketDeleteRequestDTO.getItemIds().isEmpty()) {
            basketItemRepository.deleteByNbBasketItemIn(basketDeleteRequestDTO.getItemIds());
        }
    }
}