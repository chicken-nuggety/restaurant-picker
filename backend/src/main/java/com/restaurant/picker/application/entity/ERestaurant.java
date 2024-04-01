package com.restaurant.picker.application.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "Restaurant")
@Table(schema = "test", name = "restaurant")
@Getter
@Setter
public class ERestaurant extends BaseEntity<Long> {

    @Id
    @GenericGenerator(name="generator" , strategy="increment")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="generator")
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "active_status")
    private boolean activeStatus;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_time")
    private LocalDateTime createdTime;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "modified_time")
    private LocalDateTime modifiedTime;
}
