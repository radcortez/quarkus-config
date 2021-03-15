package com.radcortez.quarkus.config;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class UserRepository {
    @Inject
    EntityManager entityManager;

    User find(String id) {
        return entityManager.find(User.class, id);
    }

    User persist(User user) {
        entityManager.persist(user);
        return user;
    }
}
