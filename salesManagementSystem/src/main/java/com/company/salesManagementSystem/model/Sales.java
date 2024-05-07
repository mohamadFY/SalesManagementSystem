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

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Client client;

    @ManyToMany
    private List<Product> products;

    @NotEmpty(message = "Name must not be empty")
    private String seller;

    @Min(value = 1, message = "Not For Free")
    private long total;

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

