package kr.co.springbootex.ecommerce.category.command.domain.repository;

import kr.co.springbootex.ecommerce.category.command.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}