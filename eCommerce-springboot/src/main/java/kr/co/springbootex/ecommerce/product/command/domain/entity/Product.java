package kr.co.springbootex.ecommerce.product.command.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "tb_product")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @Column(name = "no_product", length = 30)
    private String noProduct;

    @Column(name = "nm_product", length = 200, nullable = false)
    private String nmProduct;

    @Column(name = "nm_detail_explain", length = 4000)
    private String nmDetailExplain;

    @Column(name = "dt_start_date", length = 8, nullable = false)
    private String dtStartDate;

    @Column(name = "dt_end_date", length = 8, nullable = false)
    private String dtEndDate;

    @Column(name = "qt_sale_price", nullable = false)
    private Integer qtSalePrice;

    @Column(name = "qt_stock")
    private Integer qtStock;

}
