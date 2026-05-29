package com.ecommerce.user_service.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.ecommerce.user_service.entities.Permission;
import com.ecommerce.user_service.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>, JpaSpecificationExecutor<Role>{

    Optional<Role> findByNameContainingIgnoreCase(String name, Pageable pageable);

    Page<Role> findByPermissionContaining(Permission permission, Pageable pageable);

    Page<Role> findByDistinctPermissionContaining(Permission permission, Pageable pageable);

    @EntityGraph(attributePaths= {"permissions"})
    Optional<Role> findWithPermissionById(Long id);

}
