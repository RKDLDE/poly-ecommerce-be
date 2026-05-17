package kr.co.springbootex.ecommerce.category.command.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

// 복합키
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryProductMappingId implements Serializable {
    private Long category;
    private String product;
}
