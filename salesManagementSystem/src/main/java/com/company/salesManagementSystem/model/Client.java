package com.company.salesManagementSystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
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
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "Name must not be empty")
    private String name;

    @NotEmpty(message = "LastName must not be empty")
    private String lastName;

    @Pattern(regexp = "^\\d{10}$", message = "Invalid Phone Number")
    private String mobileNO;

    @Email(message = "invalid Email Address")
    private String email;

    @NotEmpty(message = "Enter Your Address")
    private String address;

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
