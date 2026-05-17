package kr.co.springbootex.ecommerce.product.query.service;

import kr.co.springbootex.ecommerce.product.query.dto.ProductRequestDTO;
import kr.co.springbootex.ecommerce.product.query.dto.ProductResponseDTO;
import kr.co.springbootex.ecommerce.product.query.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class ProductQueryService {
    private final ProductMapper productMapper;

    // 관리자: 상품 전체 조회
    public Map<String, Object> getAllProducts(ProductRequestDTO productRequestDTO) {
        List<ProductResponseDTO> items = productMapper.findAllForAdmin(productRequestDTO);
        int totalCount = productMapper.countAllForAdmin(productRequestDTO);

        Map<String, Object> result = new HashMap<>();
        result.put("items", items);
        result.put("totalCount", totalCount);
        return result;
    }

    // 상품 상세 조회
    public ProductResponseDTO getProductDetail(String noProductId) {
        return productMapper.findById(noProductId);
    }

    // 카테고리별 상품 조회
    public Map<String, Object> getProductsByCategory(ProductRequestDTO productRequestDTO) {
        List<ProductResponseDTO> items = productMapper.findByCategory(productRequestDTO);
        int totalCount = productMapper.countByCategory(productRequestDTO);

        Map<String, Object> result = new HashMap<>();
        result.put("items", items);
        result.put("totalCount", totalCount);
        return result;
    }
}
