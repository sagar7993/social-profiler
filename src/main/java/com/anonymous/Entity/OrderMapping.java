package com.anonymous.Entity;

import javax.persistence.*;

/**
 * Created by akash.mercer on 14-05-2016.
 */
@Entity
@Table(name = "order_mapping")
public class OrderMapping {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cuisine")
    private Cuisine cuisine;

    public void setCuisine(Cuisine cuisine){
        this.cuisine = cuisine;
    }

    public Cuisine getCuisine(){
        return this.cuisine;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subscription")
    private Subscription subscription;

    public Category getCategory() {
        return category;
    }

    public void setCategory( Category category) {
        this.category = category;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category")
    private Category category;
}
