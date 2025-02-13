package de.dhbw.verteiltesysteme.fetcher.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ResponseWrapper {

  private String kind;
  private String etag;
  private String nextPageToken;
  private String prevPageToken;
  private List<Video> items;

}
