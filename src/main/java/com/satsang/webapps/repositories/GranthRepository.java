package com.satsang.webapps.repositories;

import com.satsang.webapps.entity.Granth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by nixit on 12/22/14.
 */
public interface GranthRepository extends JpaRepository<Granth, Integer> {
}
