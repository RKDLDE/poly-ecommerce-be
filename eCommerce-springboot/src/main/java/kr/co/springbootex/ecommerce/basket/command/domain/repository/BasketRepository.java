package kr.co.springbootex.ecommerce.basket.command.domain.repository;

import kr.co.springbootex.ecommerce.basket.command.domain.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Long> {

    // idUser로 조회
    Optional<Basket> findByUserIdUser(String idUser);
}
