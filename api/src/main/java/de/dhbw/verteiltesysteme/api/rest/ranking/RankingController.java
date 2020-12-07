package de.dhbw.verteiltesysteme.api.rest.ranking;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.dhbw.verteiltesysteme.api.domain.Trending;
import de.dhbw.verteiltesysteme.shared.Region;

@RestController
@RequestMapping("/ranking")
public class RankingController {

    @Autowired
    private RankingService rankingService;

    @GetMapping
    public ResponseEntity<Page<Trending>> get(@RequestParam(required = true) Region region,
            @RequestParam(required = true) @DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime fetchedOn,
            Pageable pageable) {
        return ResponseEntity.ok(rankingService.getByRegionAndFetchedOn(region, fetchedOn, pageable));
    }

}
