package com.satsang.webapps.service;

import com.satsang.webapps.entity.Quote;

import java.util.Date;
import java.util.List;

/**
 * Created by nixit on 12/24/14.
 */
public interface QuoteDatabaseService extends DatabaseService<Quote>{
    Quote find(Date date);
    List<Quote> findAllGrater(Date date);
    List<Quote> findAllLess(Date date);
}
