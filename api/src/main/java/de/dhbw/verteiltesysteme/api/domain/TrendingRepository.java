package de.dhbw.verteiltesysteme.api.domain;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import de.dhbw.verteiltesysteme.shared.Region;

public interface TrendingRepository extends CrudRepository<Trending, TrendingId> {

    Page<Trending> findAllByRegionAndFetchedOnOrderByRankAsc(Region region, LocalDateTime fetchedOn, Pageable pageable);

    Page<Trending> findAllByRegionAndVideoIdOrderByFetchedOnDesc(Region region, String videoId, Pageable pageable);

    Page<Trending> findAllByRegionAndChannelIdOrderByFetchedOnDesc(Region region, String channelId, Pageable pageable);

}
