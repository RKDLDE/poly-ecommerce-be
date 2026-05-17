package kr.co.springbootex.ecommerce.order.command.domain.repository;

import kr.co.springbootex.ecommerce.order.command.domain.entity.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, String> {
    // 본인 전체 주문
    @Query("select o from Order o join fetch o.user where o.user.idUser = :idUser order by o.daOrder desc")
    List<Order> findByIdUserOrderByDaOrderDesc(@Param("idUser") String idUser);
}
