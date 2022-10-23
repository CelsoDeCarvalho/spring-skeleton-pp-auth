package dev.mozcoder.usermanagementapi.repository;

import dev.mozcoder.usermanagementapi.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,String> {
}
