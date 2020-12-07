package de.dhbw.verteiltesysteme.api.rest.channel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import de.dhbw.verteiltesysteme.api.domain.Trending;
import de.dhbw.verteiltesysteme.api.domain.TrendingRepository;
import de.dhbw.verteiltesysteme.shared.Region;

@Service
public class ChannelService {

    @Autowired
    private TrendingRepository trendingRepository;

    public Page<Trending> getByRegionAndChannelId(Region region, String channelId, Pageable pageable) {
        return trendingRepository.findAllByRegionAndChannelIdOrderByFetchedOnDesc(region, channelId, pageable);
    }

}
