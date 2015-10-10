package com.satsang.webapps.repositories;

import com.satsang.webapps.entity.Track;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by nixit on 12/22/14.
 */
public interface TrackRepository extends JpaRepository<Track, Integer> {
}
