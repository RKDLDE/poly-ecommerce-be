package kr.co.springbootex.ecommerce.category.command.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"parentCategory", "childCategories"})
public class Category {

    @Id
    @Column(name = "nb_category")
    private Long nbCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nb_parent_category")
    private Category parentCategory;

    @Column(name = "nm_category", length = 100, nullable = false)
    private String nmCategory;

    @Column(name = "cn_level")
    private Integer cnLevel;

    @Column(name = "cn_order")
    private Integer cnOrder;

    @OneToMany(mappedBy = "parentCategory", cascade = CascadeType.ALL)
    private List<Category> childCategories = new ArrayList<>();
}