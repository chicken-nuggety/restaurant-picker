package com.restaurant.picker.application.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

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
    private boolean isActive;

    @Column(name = "created_by")
    private String createdBy;

    @CreationTimestamp
    @Column(name = "created_time")
    private LocalDateTime createdTime;

    @Column(name = "modified_by")
    private String modifiedBy;

    @UpdateTimestamp
    @Column(name = "modified_time")
    private LocalDateTime modifiedTime;

    @PrePersist
    void setDefault() {
        isActive = true;
        createdBy = "System";
        modifiedBy = "System";
    }
}
