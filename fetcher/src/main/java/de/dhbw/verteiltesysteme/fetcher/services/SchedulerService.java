package de.dhbw.verteiltesysteme.fetcher.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import de.dhbw.verteiltesysteme.fetcher.dto.Video;
import de.dhbw.verteiltesysteme.shared.FetcherService;
import de.dhbw.verteiltesysteme.shared.TrendingProperties;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SchedulerService {

    @Autowired
    private YouTubeFetcherService youTubeFetcherService;

    @Autowired
    private FetcherService rmiFetcherService;

    @Scheduled(cron = "0 0 * * * *")
    public void fetchHourly() {
        log.info("Hourly execution of YouTube Fetcher started...");

        youTubeFetcherService.fetch().forEach((region, videos) -> {
            for (int i = 0; i < videos.size(); i++) {
                Video video = videos.get(i);

                TrendingProperties trendingProperties = new TrendingProperties();
                trendingProperties.setVideoId(video.getId());
                trendingProperties.setFetchedOn(LocalDateTime.now().withMinute(0).withSecond(0).withNano(0));
                trendingProperties.setRank(i + 1);

                if (video.getSnippet() != null) {
                    trendingProperties.setTitle(video.getSnippet().getTitle());
                    trendingProperties.setPublishedAt(video.getSnippet().getPublishedAt());
                    trendingProperties.setChannelId(video.getSnippet().getChannelId());
                    trendingProperties.setChannelTitle(video.getSnippet().getChannelTitle());
                    trendingProperties.setCategoryId(video.getSnippet().getCategoryId());
                    trendingProperties.setTags(String.join(", ", video.getSnippet().getTags()));
                    trendingProperties.setDescription(video.getSnippet().getDescription());
                }

                if (video.getStatistics() != null) {
                    trendingProperties.setViewCount(video.getStatistics().getViewCount());
                    trendingProperties.setCommentCount(video.getStatistics().getCommentCount());
                    trendingProperties.setLikeCount(video.getStatistics().getLikeCount());
                    trendingProperties.setDislikeCount(video.getStatistics().getDislikeCount());
                }

                trendingProperties.setRegion(region);

                rmiFetcherService.save(trendingProperties);
            }

            log.info("Finished syncing {} results for region {}.", videos.size(), region);
        });

        log.info("Hourly execution of YouTube Fetcher finished.");
    }

}
