package kr.co.springbootex.ecommerce.category.command.domain.entity;

import jakarta.persistence.*;
import kr.co.springbootex.ecommerce.product.command.domain.entity.Product;
import lombok.*;

@Entity
@Table(name = "tb_category_product_mapping")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(CategoryProductMappingId.class)
@ToString(exclude = {"category", "product"})
public class CategoryProductMapping {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nb_category")
    private Category category;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "no_product")
    private Product product;

    @Column(name = "cn_order", nullable = false)
    private Integer cnOrder;
}

