package kr.co.springbootex.ecommerce.basket.query.service;

import kr.co.springbootex.ecommerce.basket.query.dto.BasketItemResponseDTO;
import kr.co.springbootex.ecommerce.basket.query.mapper.BasketMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketQueryService {
    private final BasketMapper basketMapper;

    public List<BasketItemResponseDTO> getBasketItemById(String idUser) {
        return basketMapper.findByUserId(idUser);
    }
}
