package com.ecommerce.user_service.repositories;

import java.awt.print.Pageable;
import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.ecommerce.user_service.entities.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long>, JpaSpecificationExecutor<Profile>{

    Page<Profile> findByCity(String city, Pageable pageable);

    Page<Profile> findByCountry(String country, Pageable pageable);

    Page<Profile> findByDateOfBirth(LocalDate dateOfBirth, Pageable pageable);

    boolean existsByUserId(Long id);

  

}
