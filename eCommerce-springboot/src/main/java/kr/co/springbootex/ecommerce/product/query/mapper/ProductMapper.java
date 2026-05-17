package kr.co.springbootex.ecommerce.product.query.mapper;

import kr.co.springbootex.ecommerce.product.query.dto.ProductRequestDTO;
import kr.co.springbootex.ecommerce.product.query.dto.ProductResponseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    //  관리자: 전체 상품 조회
    List<ProductResponseDTO> findAllForAdmin(ProductRequestDTO productRequestDTO);

    // 페이징을 위한 카운트
    int countAllForAdmin(ProductRequestDTO productRequestDTO);

    // 상품 상세 조회
    ProductResponseDTO findById(String noProduct);

    // 카테고리 별 조회
    List<ProductResponseDTO> findByCategory(ProductRequestDTO productRequestDTO);

    // 페이징을 위한 카운트
    int countByCategory(ProductRequestDTO productRequestDTO);
}
