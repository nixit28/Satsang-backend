package com.satsang.webapps.repositories;

import com.satsang.webapps.entity.Orator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by nixit on 12/18/14.
 */

public interface OratorRepository extends JpaRepository<Orator, Integer> {

    Orator findByName(String name);

}
