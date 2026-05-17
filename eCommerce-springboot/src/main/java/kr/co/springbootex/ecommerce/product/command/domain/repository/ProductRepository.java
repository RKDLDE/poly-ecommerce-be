package kr.co.springbootex.ecommerce.product.command.domain.repository;

import kr.co.springbootex.ecommerce.product.command.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}
