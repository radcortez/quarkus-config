package com.radcortez.quarkus.config;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
class UserRepositoryTest {
    @Inject
    UserRepository userRepository;

    @Test
    void persist() {
        userRepository.persist(new User("1"));

        User user = userRepository.find("1");
        assertEquals("1", user.getId());
    }
}
