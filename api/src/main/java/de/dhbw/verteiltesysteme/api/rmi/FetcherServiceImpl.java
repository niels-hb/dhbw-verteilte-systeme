package de.dhbw.verteiltesysteme.api.rmi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.dhbw.verteiltesysteme.api.domain.Trending;
import de.dhbw.verteiltesysteme.api.domain.TrendingRepository;
import de.dhbw.verteiltesysteme.shared.FetcherService;
import de.dhbw.verteiltesysteme.shared.TrendingProperties;

@Service
public class FetcherServiceImpl implements FetcherService {

    @Autowired
    private TrendingRepository trendingRepository;

    @Override
    public void save(TrendingProperties trendingProperties) {
        Trending trending = new Trending();
        trending.setVideoId(trendingProperties.getVideoId());
        trending.setFetchedOn(trendingProperties.getFetchedOn());
        trending.setRank(trendingProperties.getRank());
        trending.setTitle(trendingProperties.getTitle());
        trending.setPublishedAt(trendingProperties.getPublishedAt());
        trending.setChannelId(trendingProperties.getChannelId());
        trending.setChannelTitle(trendingProperties.getChannelTitle());
        trending.setCategoryId(trendingProperties.getCategoryId());
        trending.setTags(trendingProperties.getTags());
        trending.setDescription(trendingProperties.getDescription());
        trending.setViewCount(trendingProperties.getViewCount());
        trending.setCommentCount(trendingProperties.getCommentCount());
        trending.setLikeCount(trendingProperties.getLikeCount());
        trending.setDislikeCount(trendingProperties.getDislikeCount());
        trending.setRegion(trendingProperties.getRegion());

        trendingRepository.save(trending);
    }

}
