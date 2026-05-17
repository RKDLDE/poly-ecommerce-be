package kr.co.springbootex.ecommerce.category.command.domain.repository;

import kr.co.springbootex.ecommerce.category.command.domain.entity.CategoryProductMapping;
import kr.co.springbootex.ecommerce.category.command.domain.entity.CategoryProductMappingId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryProductMappingRepository extends JpaRepository<CategoryProductMapping, CategoryProductMappingId> {

    // 상품 삭제
    void deleteByProductNoProduct(String noProduct);

    // 해당 카테고리에 상품이 있는가
    boolean existsByCategoryNbCategory(Long nbCategory);

    // 카테고리 가져오기
    Optional<CategoryProductMapping> findByProductNoProduct(String noProduct);
}
