package de.dhbw.verteiltesysteme.fetcher.services;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import de.dhbw.verteiltesysteme.fetcher.dto.ResponseWrapper;
import de.dhbw.verteiltesysteme.fetcher.dto.Video;
import de.dhbw.verteiltesysteme.shared.Region;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class YouTubeFetcherServiceImpl implements YouTubeFetcherService {

  @Value("${youtube.url}")
  private String ENDPOINT;

  @Value("${youtube.key}")
  private String AUTH_KEY;

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public Map<Region, List<Video>> fetch() {
    log.info("Started fetching...");

    Map<Region, List<Video>> results = new HashMap<>();

    for (Region region : Region.values()) {
      results.put(region, fetchVideosForRegion(region));

      log.info("Fetched region {}.", region);
    }

    log.info("Finished fetching.");

    return results;
  }

  private List<Video> fetchVideosForRegion(Region region) {
    return fetchVideosForRegion(region, null);
  }

  private List<Video> fetchVideosForRegion(Region region, String pageToken) {
    // @formatter:off
    ResponseEntity<ResponseWrapper> response = restTemplate.exchange(
      buildUri(region, pageToken),
      HttpMethod.GET,
      buildHttpEntity(),
      ResponseWrapper.class
    );
    // @formatter:on

    if (response.getStatusCode() != HttpStatus.OK) {
      throw new Error(String.format("Fetch failed with code {}.", response.getStatusCode()));
    }

    List<Video> videos = new ArrayList<>(response.getBody().getItems());

    if (StringUtils.hasLength(response.getBody().getNextPageToken())) {
      videos.addAll(fetchVideosForRegion(region, response.getBody().getNextPageToken()));
    }

    return videos;
  }

  private HttpEntity<ResponseWrapper> buildHttpEntity() {
    HttpHeaders headers = new HttpHeaders();
    headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

    return new HttpEntity<>(headers);
  }

  private URI buildUri(Region region, String pageToken) {
    // @formatter:off
    UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(ENDPOINT)
        .queryParam("part", "contentDetails,snippet,statistics,status,id")
        .queryParam("key", AUTH_KEY)
        .queryParam("chart", "mostPopular")
        .queryParam("maxResults", "50")
        .queryParam("regionCode", region)
        .queryParam("chart", "mostPopular")
        .queryParam("chart", "mostPopular")
        .queryParam("part", "contentDetails,snippet,statistics,status,id");
    // @formatter:on

    if (pageToken != null) {
      uriBuilder.queryParam("pageToken", pageToken);
    }

    return uriBuilder.build().toUri();
  }

}
