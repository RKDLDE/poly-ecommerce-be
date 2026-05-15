package kr.co.springbootex.ecommerce.basket.query.service;

import kr.co.springbootex.ecommerce.basket.query.dto.BasketItemDTO;
import kr.co.springbootex.ecommerce.basket.query.mapper.BasketMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketService {
    private final BasketMapper basketMapper;

    public List<BasketItemDTO> getBasketItemById(String idUser) {
        return basketMapper.findById(idUser);
    }
}
