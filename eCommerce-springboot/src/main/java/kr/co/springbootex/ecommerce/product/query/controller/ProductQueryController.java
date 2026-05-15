package kr.co.springbootex.ecommerce.product.query.controller;

import kr.co.springbootex.ecommerce.product.query.dto.ProductDTO;
import kr.co.springbootex.ecommerce.product.query.dto.ProductMapCategoryDTO;
import kr.co.springbootex.ecommerce.product.query.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductQueryController {
    private final ProductService productService;

    @GetMapping()
    public List<ProductDTO> getAllProducts()
    {
        return productService.getAllProducts();
    }

    @GetMapping("/{noProductId}")
    public ProductDTO getProductById(@PathVariable String noProductId){
        return productService.getProductById(noProductId);
    }

    @GetMapping("/categorymap/{nbCategory}")
    public List<ProductMapCategoryDTO> getProductByCategory(@PathVariable Long nbCategory){
        return productService.getProductByCategory(nbCategory);
    }
}
