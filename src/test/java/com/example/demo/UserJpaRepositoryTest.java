package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Transactional
@Sql("classpath:/test-data.sql")
public class UserJpaRepositoryTest {
    @Autowired
    EntityManager entityManager;
    @Autowired
    UserJpaRepository userJpaRepository;

    @Test
    public void findAll_success() {
        User user = new User();
        user.setCreatedBy("tester");
        user.setName("Test Taro");
        entityManager.persist(user);
        Iterable<User> users = userJpaRepository.findAll();
        users.forEach(user1 -> {
            assertAll(
                    () -> assertTrue(user1.getId() > 0),
                    () -> assertEquals("tester", user1.getCreatedBy()),
                    () -> assertEquals("Test Taro", user1.getName())
            );
        });
        assertEquals(1, ((Collection<?>) users).size());
    }
}
