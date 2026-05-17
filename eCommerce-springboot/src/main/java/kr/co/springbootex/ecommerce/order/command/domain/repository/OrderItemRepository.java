package kr.co.springbootex.ecommerce.order.command.domain.repository;

import kr.co.springbootex.ecommerce.order.command.domain.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, String> {
}
