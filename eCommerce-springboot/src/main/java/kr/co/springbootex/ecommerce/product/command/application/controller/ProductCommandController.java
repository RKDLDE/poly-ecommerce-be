package kr.co.springbootex.ecommerce.product.command.application.controller;

import kr.co.springbootex.ecommerce.product.command.application.dto.ProductCreateRequestDTO;
import kr.co.springbootex.ecommerce.product.command.application.dto.ProductUpdateRequestDTO;
import kr.co.springbootex.ecommerce.product.command.application.service.ProductCommandService;
import kr.co.springbootex.ecommerce.product.query.dto.ProductResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/products")
@RequiredArgsConstructor
public class ProductCommandController {

    private final ProductCommandService productCommandService;

    // 상품 등록
    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductCreateRequestDTO productCreateRequestDTO) {
        ProductResponseDTO response = productCommandService.createProduct(productCreateRequestDTO);
        return ResponseEntity.ok(response);
    }

    // 상품 정보 수정
    @PutMapping("/{noProduct}")
    public ResponseEntity<ProductResponseDTO> updateProduct(
            @PathVariable String noProduct,
            @RequestBody ProductUpdateRequestDTO productUpdateRequestDTO) {
        ProductResponseDTO response = productCommandService.updateProduct(noProduct, productUpdateRequestDTO);
        return ResponseEntity.ok(response);
    }

    // 상품 삭제
    @DeleteMapping("/{noProduct}")
    public ResponseEntity<String> deleteProduct(@PathVariable String noProduct) {
        productCommandService.deleteProduct(noProduct);
        return ResponseEntity.ok("상품이 삭제되었습니다.");
    }

    // 판매 중지 처리
    @PutMapping("/{noProduct}/stop-sale")
    public ResponseEntity<ProductResponseDTO> stopSale(@PathVariable String noProduct) {
        ProductResponseDTO response = productCommandService.stopSale(noProduct);
        return ResponseEntity.ok(response);
    }

    // 품절 처리
    @PutMapping("/{noProduct}/out-of-stock")
    public ResponseEntity<ProductResponseDTO> outOfStock(@PathVariable String noProduct) {
        ProductResponseDTO response = productCommandService.outOfStock(noProduct);
        return ResponseEntity.ok(response);
    }

    // 상품 재고 수량 업데이트
    @PutMapping("/{noProduct}/stock")
    public ResponseEntity<ProductResponseDTO> updateStock(
            @PathVariable String noProduct,
            @RequestParam Integer stock) {
        ProductResponseDTO response = productCommandService.updateStock(noProduct, stock);
        return ResponseEntity.ok(response);
    }
}
