package de.dhbw.verteiltesysteme.fetcher.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Snippet {

  private LocalDateTime publishedAt;
  private String title;
  private String description;
  private String channelId;
  private String channelTitle;
  private List<String> tags = new ArrayList<>();
  private String categoryId;

}
