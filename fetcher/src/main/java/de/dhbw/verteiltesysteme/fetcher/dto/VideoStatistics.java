package de.dhbw.verteiltesysteme.fetcher.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class VideoStatistics {

  private Long viewCount;
  private Integer likeCount;
  private Integer dislikeCount;
  private Integer favoriteCount;
  private Integer commentCount;

}
