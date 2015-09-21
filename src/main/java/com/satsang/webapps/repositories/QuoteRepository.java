package com.satsang.webapps.repositories;

import com.satsang.webapps.entity.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by nixit on 12/22/14.
 */

public interface QuoteRepository extends JpaRepository<Quote, Integer> {
    Quote findByDatePublish(Date date);
    List<Quote> findByDatePublishGreaterThanEqual(Date date);
    List<Quote> findByDatePublishLessThan(Date date);
}
