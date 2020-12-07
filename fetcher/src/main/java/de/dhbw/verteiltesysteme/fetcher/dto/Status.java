package de.dhbw.verteiltesysteme.fetcher.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Status {

  private LocalDateTime publishedAt;
  private String license;

}
