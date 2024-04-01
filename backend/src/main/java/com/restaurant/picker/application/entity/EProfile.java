package com.restaurant.picker.application.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "Profile")
@Table(schema = "test", name = "profile")
@Getter
@Setter
public class EProfile extends BaseEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    private Long id;

    @Column(name = "name", updatable = false, nullable = false)
    private String name;

    @Column(name = "userName", unique = true, updatable = false, nullable = false)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;
}
