package kr.co.springbootex.ecommerce.basket.query.mapper;

import kr.co.springbootex.ecommerce.basket.query.dto.BasketItemDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BasketMapper {

    // 장바구니
    List<BasketItemDTO> findById(String idUser);
}
