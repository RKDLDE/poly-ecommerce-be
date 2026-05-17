package kr.co.springbootex.ecommerce.basket.command.domain.repository;

import kr.co.springbootex.ecommerce.basket.command.domain.entity.BasketItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasketItemRepository extends JpaRepository<BasketItem, Long> {

    // 장바구니 일괄 삭제
    void deleteByNbBasketItemIn(List<Long> itemIds);
}