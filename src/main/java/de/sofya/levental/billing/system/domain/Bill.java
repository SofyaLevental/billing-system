package de.sofya.levental.billing.system.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Bill implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Double amount;

    public Bill(String title, Double amount){
        this.title = title;
        this.amount = amount;
    }

    protected Bill(){
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Double getAmount() {
        return amount;
    }
}
