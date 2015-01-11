package com.satsang.webapps.repositories;

import com.satsang.webapps.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by nixit on 12/22/14.
 */
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
