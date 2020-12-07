package de.dhbw.verteiltesysteme.fetcher.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ContentDetails {

  private String duration;
  private String licensedContent;

}
