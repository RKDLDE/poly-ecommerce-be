package kr.co.springbootex.ecommerce.category.query.service;

import kr.co.springbootex.ecommerce.category.query.dto.CategoryDTO;
import kr.co.springbootex.ecommerce.category.query.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryMapper categoryMapper;

    // 카테고리 전체 조회
    public List<CategoryDTO> getAllCategory() {
        return categoryMapper.findAll();
    }
}
