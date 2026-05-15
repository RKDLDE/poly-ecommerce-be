package kr.co.springbootex.ecommerce.product.query.service;

import kr.co.springbootex.ecommerce.product.query.dto.ProductDTO;
import kr.co.springbootex.ecommerce.product.query.dto.ProductMapCategoryDTO;
import kr.co.springbootex.ecommerce.product.query.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductMapper productMapper;

    // 상품 전체 조회
    public List<ProductDTO> getAllProducts() {
        return productMapper.findAll();
    }

    // 상품 상세 조회
    public ProductDTO getProductById(String noProductId) {
        return productMapper.findById(noProductId);
    }

    // 카테고리별 상품 조회
    public List<ProductMapCategoryDTO> getProductByCategory(Long nbCategory){
        return productMapper.findByCategory(nbCategory);
    }
}
