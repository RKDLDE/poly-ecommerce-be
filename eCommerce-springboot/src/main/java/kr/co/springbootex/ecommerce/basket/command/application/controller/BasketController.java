package kr.co.springbootex.ecommerce.basket.command.application.controller;


import kr.co.springbootex.ecommerce.basket.command.application.dto.BasketAddRequestDTO;
import kr.co.springbootex.ecommerce.basket.command.application.dto.BasketDeleteRequestDTO;
import kr.co.springbootex.ecommerce.basket.command.application.dto.BasketUpdateQtyRequestDTO;
import kr.co.springbootex.ecommerce.basket.command.application.service.BasketCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/baskets")
@RequiredArgsConstructor
public class BasketController {

    private final BasketCommandService basketCommandService;

    // 장바구니 상품 담기
    @PostMapping
    public ResponseEntity<String> addBasketItem(
            @RequestHeader("X-USER-ID") String idUser,
            @RequestBody BasketAddRequestDTO basketAddRequestDTO) {
        basketCommandService.addBasketItem(idUser, basketAddRequestDTO);
        return ResponseEntity.ok("상품이 장바구니에 담겼습니다.");
    }

    // 장바구니 상품 수량 변경
    @PutMapping("/items/{nbBasketItem}")
    public ResponseEntity<String> updateBasketItemQuantity(
            @PathVariable Long nbBasketItem,
            @RequestBody BasketUpdateQtyRequestDTO basketUpdateQtyRequestDTO) {
        basketCommandService.updateBasketItemQuantity(nbBasketItem, basketUpdateQtyRequestDTO);
        return ResponseEntity.ok("수량이 변경되었습니다.");
    }

    // 장바구니 선택 상품(들) 삭제
    @DeleteMapping("/items")
    public ResponseEntity<String> deleteSelectedItems(@RequestBody BasketDeleteRequestDTO basketDeleteRequestDTO) {
        basketCommandService.deleteSelectedItems(basketDeleteRequestDTO);
        return ResponseEntity.ok("선택한 상품이 장바구니에서 삭제되었습니다.");
    }
}