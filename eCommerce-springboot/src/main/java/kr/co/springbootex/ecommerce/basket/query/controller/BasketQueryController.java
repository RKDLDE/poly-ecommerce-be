package kr.co.springbootex.ecommerce.basket.query.controller;

import kr.co.springbootex.ecommerce.basket.query.dto.BasketItemResponseDTO;
import kr.co.springbootex.ecommerce.basket.query.service.BasketQueryService;
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
    private final BasketQueryService basketQueryService;

    @GetMapping("/{idUser}")
    public List<BasketItemResponseDTO> getBasketItemById(@PathVariable String idUser){
        return basketQueryService.getBasketItemById(idUser);
    }
}
