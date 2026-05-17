package kr.co.springbootex.ecommerce.basket.command.domain.entity;

import jakarta.persistence.*;
import kr.co.springbootex.ecommerce.product.command.domain.entity.Product;
import lombok.*;

@Entity
@Table(name = "tb_basket_item")
@SequenceGenerator(
        name = "BASKET_ITEM_SEQ_GENERATOR",
        sequenceName = "seq_tb_basket_item",
        initialValue = 1,
        allocationSize = 1
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BasketItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BASKET_ITEM_SEQ_GENERATOR")
    @Column(name = "nb_basket_item")
    private Long nbBasketItem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nb_basket", nullable = false)
    private Basket basket;

    @Column(name = "cn_basket_item_order", nullable = false)
    private Integer cnBasketItemOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "no_product", nullable = false)
    private Product product;

    @Column(name = "qt_basket_item_price")
    private Integer qtBasketItemPrice;

    @Column(name = "qt_basket_item")
    private Integer qtBasketItem;

    @Column(name = "qt_basket_item_amount")
    private Integer qtBasketItemAmount;

    public void updateQuantity(int addQty) {
        this.qtBasketItem += addQty;
        this.qtBasketItemAmount = this.qtBasketItemPrice * this.qtBasketItem;
    }
}