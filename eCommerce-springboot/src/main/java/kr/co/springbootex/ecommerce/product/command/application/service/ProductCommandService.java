package kr.co.springbootex.ecommerce.product.command.application.service;

import kr.co.springbootex.ecommerce.category.command.domain.entity.Category;
import kr.co.springbootex.ecommerce.category.command.domain.entity.CategoryProductMapping;
import kr.co.springbootex.ecommerce.category.command.domain.repository.CategoryProductMappingRepository;
import kr.co.springbootex.ecommerce.category.command.domain.repository.CategoryRepository;
import kr.co.springbootex.ecommerce.product.command.application.dto.ProductCreateRequestDTO;
import kr.co.springbootex.ecommerce.product.command.application.dto.ProductUpdateRequestDTO;
import kr.co.springbootex.ecommerce.product.command.domain.entity.Product;
import kr.co.springbootex.ecommerce.product.command.domain.repository.ProductRepository;
import kr.co.springbootex.ecommerce.product.query.dto.ProductResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductCommandService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final CategoryProductMappingRepository categoryProductMappingRepository;

    // 상품 등록
    @Transactional
    public ProductResponseDTO createProduct(ProductCreateRequestDTO productCreateRequestDTO) {

        // 상품 번호 중복 확인
        if (productRepository.existsById(productCreateRequestDTO.getNoProduct())) {
            throw new IllegalArgumentException("이미 존재하는 상품 번호입니다.");
        }

        // 카테고리 존재 여부 확인
        Category category = categoryRepository.findById(productCreateRequestDTO.getNbCategory())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 카테고리입니다."));

        // 요청받은거 만들고
        Product product = new Product(
                productCreateRequestDTO.getNoProduct(),
                productCreateRequestDTO.getNmProduct(),
                productCreateRequestDTO.getNmDetailExplain(),
                productCreateRequestDTO.getDtStartDate(),
                productCreateRequestDTO.getDtEndDate(),
                productCreateRequestDTO.getQtSalePrice(),
                productCreateRequestDTO.getQtStock()
        );

        // 저장
        Product savedProduct = productRepository.save(product);

        // 카테고리 매핑
        CategoryProductMapping mapping = new CategoryProductMapping(
                category,
                savedProduct,
                productCreateRequestDTO.getCnOrder()
        );

        // 카테고리-상품 매핑에 저장
        categoryProductMappingRepository.save(mapping);

        return buildResponseDTO(savedProduct);
    }

    // 상품 정보 수정
    @Transactional
    public ProductResponseDTO updateProduct(String noProduct, ProductUpdateRequestDTO productUpdateRequestDTO) {

        // 해당 상품 ID 있는지 확인
        Product product = productRepository.findById(noProduct)
                .orElseThrow(() -> new IllegalArgumentException("상품을 찾을 수 없습니다."));

        // 수정
        product.setNmProduct(productUpdateRequestDTO.getNmProduct());
        product.setNmDetailExplain(productUpdateRequestDTO.getNmDetailExplain());
        product.setDtStartDate(productUpdateRequestDTO.getDtStartDate());
        product.setDtEndDate(productUpdateRequestDTO.getDtEndDate());
        product.setQtSalePrice(productUpdateRequestDTO.getQtSalePrice());
        product.setQtStock(productUpdateRequestDTO.getQtStock());

        return buildResponseDTO(product);
    }

    // 상품 삭제
    @Transactional
    public void deleteProduct(String noProduct) {

        // 해당 상품 ID 있는지 확인
        if (!productRepository.existsById(noProduct)) {
            throw new IllegalArgumentException("상품을 찾을 수 없습니다.");
        }

        // 삭제 (매핑이랑 상품 둘다)
        categoryProductMappingRepository.deleteByProductNoProduct(noProduct);
        productRepository.deleteById(noProduct);
    }

    // 판매 중지 처리
    @Transactional
    public ProductResponseDTO stopSale(String noProduct) {

        // 해당 상품 ID 있는지 확인
        Product product = productRepository.findById(noProduct)
                .orElseThrow(() -> new IllegalArgumentException("상품을 찾을 수 없습니다."));

        // 중지된 시점 = 지금
        String today = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        product.setDtEndDate(today);

        return buildResponseDTO(product);
    }

    // 품절 처리
    @Transactional
    public ProductResponseDTO outOfStock(String noProduct) {

        // 해당 상품 ID 있는지 확인
        Product product = productRepository.findById(noProduct)
                .orElseThrow(() -> new IllegalArgumentException("상품을 찾을 수 없습니다."));

        // 재고 0으로 설정
        product.setQtStock(0);

        return buildResponseDTO(product);
    }

    // 재고 수량 업데이트
    @Transactional
    public ProductResponseDTO updateStock(String noProduct, Integer newStock) {

        // 새롭게 입력한 재고가 0 이하면
        if (newStock < 0) {
            throw new IllegalArgumentException("재고 수량은 0개 이상이어야 합니다.");
        }

        // 해당 상품 ID 있는지 확인
        Product product = productRepository.findById(noProduct)
                .orElseThrow(() -> new IllegalArgumentException("상품을 찾을 수 없습니다."));

        // 재고 업데이트
        product.setQtStock(newStock);

        return buildResponseDTO(product);
    }


    // 상품 -> 카테고리 찾아서 DTO 변환
    // 별도 메서드로 분리
    private ProductResponseDTO buildResponseDTO(Product product) {
        Long nbCategory = null;
        String nmCategory = null;

        // 카테고리 정보 찾기
        CategoryProductMapping mapping = categoryProductMappingRepository.findByProductNoProduct(product.getNoProduct())
                .orElse(null);

        if (mapping != null && mapping.getCategory() != null) {
            nbCategory = mapping.getCategory().getNbCategory();
            nmCategory = mapping.getCategory().getNmCategory();
        }

        // 만들기
        return new ProductResponseDTO(
                product.getNoProduct(),
                product.getNmProduct(),
                product.getNmDetailExplain(),
                product.getDtStartDate(),
                product.getDtEndDate(),
                product.getQtSalePrice(),
                product.getQtStock(),
                nbCategory,
                nmCategory
        );
    }
}