package kr.co.springbootex.ecommerce.category.query.mapper;

import kr.co.springbootex.ecommerce.category.query.dto.CategoryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    // 카테고리 전체 조회
    List<CategoryDTO> findAll();
}
