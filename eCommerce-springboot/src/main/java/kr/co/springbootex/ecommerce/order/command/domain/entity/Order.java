package kr.co.springbootex.ecommerce.order.command.domain.entity;

import jakarta.persistence.*;
import kr.co.springbootex.ecommerce.user.command.domain.entity.User;
import lombok.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_order")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Order {
    @Id
    @Column(name = "id_order", length = 30)
    private String idOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @Column(name = "qt_order_amount")
    private Integer qtOrderAmount;

    @Column(name = "nm_order_person", length = 100)
    private String nmOrderPerson;

    @Column(name = "nm_delivery_address", length = 200)
    private String nmDeliveryAddress;

    @Column(name = "da_order")
    private LocalDateTime daOrder;

    @Column(name = "st_order", length = 4)
    private String stOrder;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        if (this.daOrder == null) {
            this.daOrder = LocalDateTime.now();
        }
        if (this.stOrder == null) {
            this.stOrder = "10";
        }
    }
}