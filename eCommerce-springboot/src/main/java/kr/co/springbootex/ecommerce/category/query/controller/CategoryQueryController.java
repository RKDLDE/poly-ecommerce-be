package kr.co.springbootex.ecommerce.category.query.controller;

import kr.co.springbootex.ecommerce.category.query.dto.CategoryResponseDTO;
import kr.co.springbootex.ecommerce.category.query.service.CategoryQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryQueryController {
    private final CategoryQueryService categoryQueryService;

    // 관리자, 사용자: 모든 카테고리 조회
    @GetMapping()
    public List<CategoryResponseDTO> getAllCategory() {return categoryQueryService.getAllCategory();}

}
