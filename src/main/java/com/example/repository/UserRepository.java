package com.example.repository;

import com.example.entity.UserBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("userRepository")
public interface UserRepository extends CrudRepository<UserBean, Integer > {
}
