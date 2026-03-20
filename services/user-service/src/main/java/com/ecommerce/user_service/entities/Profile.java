package com.ecommerce.user_service.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="profiles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude="user")
public class Profile {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id", nullable=false, unique=true)
    private User user;

    @Column(name="avatar_url", length=500)
    private String avatarUrl;

    @Column(name="bio", length=500)
    private String bio;

    @Column(name="date_of_birth")
    private LocalDateTime dateOfBirth;

    @Column(name="country", length=100)
    private String country;

    @Column(name="city", length=100)
    private String city;

    @Column(name="street_address", length=255)
    private String streetAddress;

    @Column(name="postal_code", length=20)
    private String postalCode;

    @Column(name="company_name", length=255)
    private String companyName;

    @Column(name="website_url", length=500)
    private String websiteUrl;

    @Enumerated(EnumType.STRING)
    @Column(name="gender")
    private Gender gender;

    @CreationTimestamp
    @Column(nullable=false, updatable=false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable=false)
    private LocalDateTime uptatedAt;


}
