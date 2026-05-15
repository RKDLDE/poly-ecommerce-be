package kr.co.springbootex.ecommerce.category.query.controller;

import kr.co.springbootex.ecommerce.category.query.dto.CategoryDTO;
import kr.co.springbootex.ecommerce.category.query.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryQueryController {
    private final CategoryService categoryService;

    // 관리자, 사용자: 모든 카테고리 조회
    @GetMapping()
    public List<CategoryDTO> getAllCategory() {return categoryService.getAllCategory();}

}
