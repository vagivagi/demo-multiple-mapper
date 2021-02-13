package com.example.demo;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMyBatisRepository {
    @Select("SELECT id, name, created_by FROM user")
    List<User> findAll();

    @Insert("INSERT INTO user (name, created_by) VALUES (#{name}, #{createdBy})")
    @Options(useGeneratedKeys = true, keyProperty = "id") // (3)
    void create(User user);
}
