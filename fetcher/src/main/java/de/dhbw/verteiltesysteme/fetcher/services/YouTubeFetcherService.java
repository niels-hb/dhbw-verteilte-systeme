package de.dhbw.verteiltesysteme.fetcher.services;

import java.util.List;
import java.util.Map;

import de.dhbw.verteiltesysteme.fetcher.dto.Video;
import de.dhbw.verteiltesysteme.shared.Region;

public interface YouTubeFetcherService {

    Map<Region, List<Video>> fetch();

}
