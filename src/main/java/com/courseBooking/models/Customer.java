package com.courseBooking.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "town")
    private String town;

    @Column(name = "age")
    private Integer age;

    @JsonBackReference
    @OneToMany(mappedBy = "customer", fetch =  FetchType.LAZY)
    private List<Booking> bookings;

    public Customer(String name, String town, Integer age) {
        this.name = name;
        this.town = town;
        this.age = age;
        this.bookings = new ArrayList<>();
    }
}
