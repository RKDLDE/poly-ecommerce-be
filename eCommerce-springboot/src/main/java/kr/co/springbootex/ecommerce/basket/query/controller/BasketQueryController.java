package kr.co.springbootex.ecommerce.basket.query.controller;

import kr.co.springbootex.ecommerce.basket.query.dto.BasketItemDTO;
import kr.co.springbootex.ecommerce.basket.query.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/basket")
public class BasketQueryController {
    private final BasketService basketService;

    @GetMapping("/{idUser}")
    public List<BasketItemDTO> getBasketItemById(@PathVariable String idUser){
        return basketService.getBasketItemById(idUser);
    }
}
