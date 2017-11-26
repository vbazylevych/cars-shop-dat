package com.playtika.qa.carsshop.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ads")
    //    uniqueConstraints = {@UniqueConstraint(columnNames={"car_id", "deal_id"})})
public class AdsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    @JoinColumn (name = "user_id", nullable = false)
    private UserEntity user;

    @OneToOne()
    @JoinColumn(name = "car_id", nullable = false)
    private CarEntity car;

    @Column(nullable = false)
    @Check(constraints = "price > 0")
    private Integer price;

    @OneToMany(orphanRemoval=true, mappedBy = "ads")
    @Column(name = "deal_id")
    private List<DealEntity> deal;

    public AdsEntity(UserEntity user, CarEntity car, Integer price, List<DealEntity> deal) {
        this.user = user;
        this.car = car;
        this.price = price;
        this.deal = deal;
    }
}
