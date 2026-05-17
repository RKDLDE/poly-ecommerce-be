package kr.co.springbootex.ecommerce.category.command.application.controller;

import kr.co.springbootex.ecommerce.category.command.application.dto.CategoryCreateRequestDTO;
import kr.co.springbootex.ecommerce.category.command.application.dto.CategoryUpdateRequestDTO;
import kr.co.springbootex.ecommerce.category.command.application.service.CategoryCommandService;
import kr.co.springbootex.ecommerce.category.query.dto.CategoryResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/categories")
@RequiredArgsConstructor
public class CategoryCommandController {
    private final CategoryCommandService categoryCommandService;

    // 카테고리 생성
    @PostMapping
    public ResponseEntity<CategoryResponseDTO> createCategory(@RequestBody CategoryCreateRequestDTO categoryCreateRequestDTO) {
        CategoryResponseDTO response = categoryCommandService.createCategory(categoryCreateRequestDTO);
        return ResponseEntity.ok(response);
    }

    // 카테고리 수정
    @PutMapping("/{nbCategory}")
    public ResponseEntity<CategoryResponseDTO> updateCategory(
            @PathVariable Long nbCategory,
            @RequestBody CategoryUpdateRequestDTO categoryUpdateRequestDTO) {
        CategoryResponseDTO response = categoryCommandService.updateCategory(nbCategory, categoryUpdateRequestDTO);
        return ResponseEntity.ok(response);
    }

    // 카테고리 삭제
    @DeleteMapping("/{nbCategory}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long nbCategory) {
        categoryCommandService.deleteCategory(nbCategory);
        return ResponseEntity.ok("카테고리가 삭제되었습니다.");
    }
}
