package com.david.ServByte.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "MEAL")
public class Meal implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "PREPARATION_TIME")
    private String preparationTime;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "SERVICE_PROVIDER", referencedColumnName = "ID")
    private ServiceProvider serviceProvider;

    public Meal() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(String preparationTime) {
        this.preparationTime = preparationTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", price=" + price +
                ", preparationTime='" + preparationTime + '\'' +
                ", description='" + description + '\'' +
                ", serviceProvider=" + serviceProvider +
                '}';
    }
}
