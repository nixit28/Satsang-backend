package com.satsang.webapps.repositories;

import com.satsang.webapps.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by nixit on 9/21/15.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserNameAndPassword(String userName, String password);
}
