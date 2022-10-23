package dev.mozcoder.usermanagementapi.util.generators;

import dev.mozcoder.usermanagementapi.model.Role;
import dev.mozcoder.usermanagementapi.model.User;
import dev.mozcoder.usermanagementapi.repository.RoleRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.context.annotation.Lazy;

import java.io.Serializable;
import java.util.Optional;

public class RoleUUID implements IdentifierGenerator {

    private final RoleRepository roleRepository;

    public RoleUUID(@Lazy RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        String shortId = null;
        Optional<Role> role = null;
        do{
            shortId = RandomStringUtils.randomAlphanumeric(8);
            role = roleRepository.findById(shortId);
        }while(role.isPresent());
        return shortId;
    }
}
