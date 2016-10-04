package com.treegrowth.dao.repository;

import com.treegrowth.model.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,String> {

    Optional<User> findById(String userId);

    Optional<User> findByEmail(String email);
}