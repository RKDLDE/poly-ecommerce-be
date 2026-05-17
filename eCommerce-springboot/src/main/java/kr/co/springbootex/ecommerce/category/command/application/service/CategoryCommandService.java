package kr.co.springbootex.ecommerce.category.command.application.service;

import kr.co.springbootex.ecommerce.category.command.application.dto.CategoryCreateRequestDTO;
import kr.co.springbootex.ecommerce.category.command.application.dto.CategoryUpdateRequestDTO;
import kr.co.springbootex.ecommerce.category.command.domain.entity.Category;
import kr.co.springbootex.ecommerce.category.command.domain.repository.CategoryProductMappingRepository;
import kr.co.springbootex.ecommerce.category.command.domain.repository.CategoryRepository;
import kr.co.springbootex.ecommerce.category.query.dto.CategoryResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryCommandService {
    private final CategoryRepository categoryRepository;
    private final CategoryProductMappingRepository categoryProductMappingRepository;

    // 카테고리 생성
    @Transactional
    public CategoryResponseDTO createCategory(CategoryCreateRequestDTO categoryCreateRequestDTO) {

        // 존재하는 카테고리 번호인지 확인
        if (categoryRepository.existsById(categoryCreateRequestDTO.getNbCategory())) {
            throw new IllegalArgumentException("이미 존재하는 카테고리 번호입니다.");
        }

        // 상위 카테고리 매핑
        Category parentCategory = null;
        if (categoryCreateRequestDTO.getNbParentCategory() != null) {
            parentCategory = categoryRepository.findById(categoryCreateRequestDTO.getNbParentCategory())
                    .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상위 카테고리입니다."));
        }

        // 카테고리 엔티티 생성
        Category category = new Category(
                categoryCreateRequestDTO.getNbCategory(),
                parentCategory,
                categoryCreateRequestDTO.getNmCategory(),
                categoryCreateRequestDTO.getCnLevel(),
                categoryCreateRequestDTO.getCnOrder(),
                new ArrayList<>()
        );

        // 저장
        Category savedCategory = categoryRepository.save(category);

        Long parentId = null;
        if (savedCategory.getParentCategory() != null) {
            parentId = savedCategory.getParentCategory().getNbCategory();
        }

        // 응답 반환
        return CategoryResponseDTO.builder()
                .nbCategory(savedCategory.getNbCategory())
                .nbParentCategory(parentId)
                .nmCategory(savedCategory.getNmCategory())
                .cnLevel(savedCategory.getCnLevel())
                .cnOrder(savedCategory.getCnOrder())
                .build();
    }

    // 카테고리 수정
    @Transactional
    public CategoryResponseDTO updateCategory(Long nbCategory, CategoryUpdateRequestDTO categoryUpdateRequestDTO) {

        // 존재하는 카테고리 번호인지 확인
        Category category = categoryRepository.findById(nbCategory)
                .orElseThrow(() -> new IllegalArgumentException("해당 카테고리를 찾을 수 없습니다."));

        // 값 수정
        category.setNmCategory(categoryUpdateRequestDTO.getNmCategory());
        category.setCnOrder(categoryUpdateRequestDTO.getCnOrder());

        Long parentId = null;
        if (category.getParentCategory() != null) {
            parentId = category.getParentCategory().getNbCategory();
        }

        return CategoryResponseDTO.builder()
                .nbCategory(category.getNbCategory())
                .nbParentCategory(parentId)
                .nmCategory(category.getNmCategory())
                .cnLevel(category.getCnLevel())
                .cnOrder(category.getCnOrder())
                .build();
    }

    // 카테고리 삭제
    @Transactional
    public void deleteCategory(Long nbCategory) {

        // 존재하는 카테고리 번호인지 확인
        if (!categoryRepository.existsById(nbCategory)) {
            throw new IllegalArgumentException("해당 카테고리가 존재하지 않습니다.");
        }

        // 삭제 방어
        boolean hasProducts = categoryProductMappingRepository.existsByCategoryNbCategory(nbCategory);
        if (hasProducts) {
            throw new IllegalStateException("해당 카테고리에 등록된 상품이 있어 삭제할 수 없습니다.");
        }

        // 삭제
        categoryRepository.deleteById(nbCategory);
    }
}
