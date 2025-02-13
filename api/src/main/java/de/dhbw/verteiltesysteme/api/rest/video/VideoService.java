package de.dhbw.verteiltesysteme.api.rest.video;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import de.dhbw.verteiltesysteme.api.domain.Trending;
import de.dhbw.verteiltesysteme.api.domain.TrendingRepository;
import de.dhbw.verteiltesysteme.shared.Region;

@Service
public class VideoService {

    @Autowired
    private TrendingRepository trendingRepository;

    public Page<Trending> getByRegionAndVideoId(Region region, String videoId, Pageable pageable) {
        return trendingRepository.findAllByRegionAndVideoIdOrderByFetchedOnDesc(region, videoId, pageable);
    }

}
