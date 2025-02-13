package de.dhbw.verteiltesysteme.fetcher.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Video {

  private String kind;
  private String etag;
  private String id;
  private Snippet snippet;
  private ContentDetails contentDetails;
  private Status status;
  private VideoStatistics statistics;

}
