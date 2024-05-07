package com.company.salesManagementSystem.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty(message = "Name must not be empty")
    private String name;
    @NotEmpty(message = "Description must not be empty")
    private String description;
    @NotEmpty(message = "Category must not be empty")
    private String category;
    @Min(value = 0, message = "Invalid Quantity")
    private int quantity;
    @Min(value = 1, message = "Not For Free")
    private long price;

    @CreatedDate
    private String creationDate;

    @LastModifiedDate
    private String editionDate;

    @CreatedBy
    @ManyToOne(fetch = FetchType.LAZY)
    private User creator;

    @LastModifiedBy
    @ManyToOne(fetch = FetchType.LAZY)
    private User lastModifier;
}
