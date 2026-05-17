package kr.co.springbootex.ecommerce.product.query.controller;

import kr.co.springbootex.ecommerce.product.query.dto.ProductRequestDTO;
import kr.co.springbootex.ecommerce.product.query.dto.ProductResponseDTO;
import kr.co.springbootex.ecommerce.product.query.service.ProductQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ProductQueryController {
    private final ProductQueryService productQueryService;

    //  관리자: 전체 상품 조회
    @GetMapping("/admin/products")
    public Map<String, Object> getAllProducts(@ModelAttribute ProductRequestDTO productRequestDTO) {
        return productQueryService.getAllProducts(productRequestDTO);
    }

    // 상품 상세 조회
    @GetMapping("/products/{noProduct}")
    public ProductResponseDTO getProductDetail(@PathVariable("noProduct") String noProduct) {
        return productQueryService.getProductDetail(noProduct);
    }

    // 카테고리 별 조회
    @GetMapping("/products")
    public Map<String, Object> getProductsByCategory(@ModelAttribute ProductRequestDTO productRequestDTO) {
        return productQueryService.getProductsByCategory(productRequestDTO);
    }
}
