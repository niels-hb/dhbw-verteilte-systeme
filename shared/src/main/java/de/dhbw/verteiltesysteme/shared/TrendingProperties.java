package de.dhbw.verteiltesysteme.shared;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TrendingProperties implements Serializable {
    private static final long serialVersionUID = 2172336378402112881L;

    private String videoId;
    private LocalDateTime fetchedOn;
    private Integer rank;
    private String title;
    private LocalDateTime publishedAt;
    private String channelId;
    private String channelTitle;
    private String categoryId;
    private String tags;
    private String description;
    private Long viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private Integer dislikeCount;
    private Region region;

}
