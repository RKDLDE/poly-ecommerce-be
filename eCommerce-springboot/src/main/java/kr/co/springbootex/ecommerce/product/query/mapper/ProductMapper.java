package kr.co.springbootex.ecommerce.product.query.mapper;

import kr.co.springbootex.ecommerce.product.query.dto.ProductDTO;
import kr.co.springbootex.ecommerce.product.query.dto.ProductMapCategoryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    // 전체 상품 조회
    List<ProductDTO> findAll();

    // 상품 상세 조회
    ProductDTO findById(String noProduct);

    // 카테고리 별 조회
    List<ProductMapCategoryDTO> findByCategory(Long nbCategory);
}
