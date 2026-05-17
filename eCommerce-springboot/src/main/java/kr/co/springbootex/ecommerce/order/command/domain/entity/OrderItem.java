package kr.co.springbootex.ecommerce.order.command.domain.entity;

import jakarta.persistence.*;
import kr.co.springbootex.ecommerce.product.command.domain.entity.Product;
import lombok.*;

@Entity
@Table(name = "tb_order_item")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "order")
public class OrderItem {
    @Id
    @Column(name = "id_order_item", length = 30)
    private String idOrderItem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_order", nullable = false)
    private Order order;

    @Column(name = "cn_order_item", nullable = false)
    private Integer cnOrderItem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "no_product", nullable = false)
    private Product product;

    @Column(name = "qt_unit_price", nullable = false)
    private Integer qtUnitPrice;

    @Column(name = "qt_order_item", nullable = false)
    private Integer qtOrderItem;
}
