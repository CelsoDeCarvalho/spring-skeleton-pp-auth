package dev.mozcoder.usermanagementapi.util.generators;

import dev.mozcoder.usermanagementapi.model.User;
import dev.mozcoder.usermanagementapi.repository.UserRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.context.annotation.Lazy;

import java.io.Serializable;
import java.util.Optional;

public class UserUUID implements IdentifierGenerator {

    private final UserRepository userRepository;

    public UserUUID(@Lazy UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        String shortId = null;
        Optional<User> user = null;
        do{
            shortId = RandomStringUtils.randomAlphanumeric(8);
            user = userRepository.findById(shortId);
        }while(user.isPresent());

        return shortId;
    }
}
