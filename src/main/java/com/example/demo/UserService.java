package com.example.demo;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService {
    private final UserJpaRepository userJpaRepository;
    private final UserMyBatisRepository userMyBatisRepository;

    public UserService(UserJpaRepository userJpaRepository, UserMyBatisRepository userMyBatisRepository) {
        this.userJpaRepository = userJpaRepository;
        this.userMyBatisRepository = userMyBatisRepository;
    }

    public List<User> addAndFindAllUsingJpa(String name) {
        User user = new User(name, "JPA");
        this.userJpaRepository.save(user);
        List<User> result = new ArrayList<User>();
        this.userJpaRepository.findAll().forEach(result::add);
        return result;
    }

    public List<User> addAndFindAllUsingMyBatis(String name) {
        User user = new User(name, "MyBatis");
        this.userMyBatisRepository.create(user);
        return this.userMyBatisRepository.findAll();
    }

    public List<User> addAndFindAllUsingMultipleMapper(String name) {
        User user = new User(name, "JPA");
        this.userJpaRepository.save(user);
        List<User> result = new ArrayList<User>();
        User myBatisUser = new User(name, "MyBatis");
        this.userMyBatisRepository.create(myBatisUser);
        return this.userMyBatisRepository.findAll();
    }
}
