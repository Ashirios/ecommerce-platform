package com.ecommerce.user_service.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="users", indexes={
    @Index(name="idx_email",columnList="email",unique=true),
    @Index(name="idx_username",columnList="username",unique=true),
    @Index(name="idx_status",columnList="status")
})
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude={"roles","profile"})
@EqualsAndHashCode(exclude={"roles","profile"})
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, unique=true , length=100)
    private String username;

    @Column(nullable=false, unique=true, length=100)
    private String email;

    @Column(nullable=false, length=255)
    private String password;

    @Column(name="first_name", length=100)
    private String firstName;

    @Column(name="last_name", length=100)
    private String lastName;

    @Column(name="phone_namber",length=20)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    @Builder.Default
    private UserStatus status = UserStatus.ACTIVE;


    @Column(name="email_verified")
    @Builder.Default
    private Boolean emailVerified=false;

    @Column(name="two_factor_enabled")
    @Builder.Default
    private Boolean twoFactorEnabled=false;

    @CreationTimestamp
    @Column(nullable=false, updatable=false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable=false)
    private LocalDateTime updatedAt;

    @Column(name="last_login_at",nullable=false)
    private LocalDateTime lastLoginAt;

    @Column(name="deleted_at")
    private LocalDateTime deletedAt;

    @OneToOne(mappedBy="user", cascade=CascadeType.ALL, orphanRemoval=true)
    private Profile profile;

    @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.REFRESH)
    @JoinTable(
        name="user_roles",
        joinColumns=@JoinColumn(name="user_id", referencedColumnName="id"),
        inverseJoinColumns=@JoinColumn(name="role_id", referencedColumnName="id")
    )
    @Builder.Default
    private Set<Role> roles = new HashSet<>();









}
