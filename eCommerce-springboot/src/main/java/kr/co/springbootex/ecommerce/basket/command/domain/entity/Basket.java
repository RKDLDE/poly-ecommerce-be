package kr.co.springbootex.ecommerce.basket.command.domain.entity;

import jakarta.persistence.*;
import kr.co.springbootex.ecommerce.user.command.domain.entity.User;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_basket")
@SequenceGenerator(
        name = "BASKET_SEQ_GENERATOR",
        sequenceName = "seq_tb_basket",
        initialValue = 1,
        allocationSize = 1
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BASKET_SEQ_GENERATOR")
    @Column(name = "nb_basket")
    private Long nbBasket;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @OneToMany(mappedBy = "basket", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BasketItem> items = new ArrayList<>();

    public Basket(User user) {
        this.user = user;
    }
}