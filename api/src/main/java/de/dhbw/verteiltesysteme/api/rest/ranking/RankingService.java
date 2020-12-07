package de.dhbw.verteiltesysteme.api.rest.ranking;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import de.dhbw.verteiltesysteme.api.domain.Trending;
import de.dhbw.verteiltesysteme.api.domain.TrendingRepository;
import de.dhbw.verteiltesysteme.shared.Region;

@Service
public class RankingService {

    @Autowired
    private TrendingRepository trendingRepository;

    public Page<Trending> getByRegionAndFetchedOn(Region region, LocalDateTime fetchedOn, Pageable pageable) {
        return trendingRepository.findAllByRegionAndFetchedOnOrderByRankAsc(region, fetchedOn, pageable);
    }

}
