package de.dhbw.verteiltesysteme.api.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Index;
import javax.persistence.Table;

import de.dhbw.verteiltesysteme.shared.Region;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(indexes = { @Index(columnList = "fetchedOn") })
@Data
@NoArgsConstructor
@IdClass(TrendingId.class)
public class Trending {

    @Id
    private String videoId;

    @Id
    private LocalDateTime fetchedOn;

    @Id
    @Enumerated(EnumType.STRING)
    private Region region;

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

}
